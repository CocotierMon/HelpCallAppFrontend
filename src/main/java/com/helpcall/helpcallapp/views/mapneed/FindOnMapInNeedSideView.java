package com.helpcall.helpcallapp.views.mapneed;

import com.helpcall.helpcallapp.domain.Point;
import com.helpcall.helpcallapp.domain.VolunteerDto;
import com.helpcall.helpcallapp.service.VolunteerBackendService;
import com.helpcall.helpcallapp.views.main.MainView;
import com.helpcall.helpcallapp.views.mapneed.FindOnMapInNeedSideView.FindOnMapInNeedSideViewModel;
import com.vaadin.addon.leaflet4vaadin.LeafletMap;
import com.vaadin.addon.leaflet4vaadin.controls.LayersControl;
import com.vaadin.addon.leaflet4vaadin.controls.LayersControlOptions;
import com.vaadin.addon.leaflet4vaadin.layer.groups.LayerGroup;
import com.vaadin.addon.leaflet4vaadin.layer.map.options.DefaultMapOptions;
import com.vaadin.addon.leaflet4vaadin.layer.map.options.MapOptions;
import com.vaadin.addon.leaflet4vaadin.layer.ui.marker.Marker;
import com.vaadin.addon.leaflet4vaadin.types.Icon;
import com.vaadin.addon.leaflet4vaadin.types.LatLng;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;

import java.util.List;
import java.util.stream.Collectors;

@Route(value = "mapneed", layout = MainView.class)
@PageTitle("Znajdź na mapie")
@JsModule("./views/mapneed/mapneed-view.js")
@CssImport("./views/mapneed/mapneed-view.css")
@Tag("mapneed-view")
public class FindOnMapInNeedSideView extends PolymerTemplate<FindOnMapInNeedSideViewModel> {

    @Id("vaadinHorizontalLayout")
    private HorizontalLayout vaadinHorizontalLayout;

    public static interface FindOnMapInNeedSideViewModel extends TemplateModel {
    }

    public FindOnMapInNeedSideView(VolunteerBackendService volunteerBackendService) {
        MapOptions options = new DefaultMapOptions();
        options.setCenter(new LatLng(51.74913908790854, 19.456787109375));
        options.setZoom(7);
        LeafletMap leafletMap = new LeafletMap(options );
        leafletMap.setBaseUrl("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png");
        leafletMap.setHeight("800px");
        leafletMap.setWidth("800px");

        LayersControlOptions layersControlOptions = new LayersControlOptions();
        layersControlOptions.setCollapsed(false);
        LayersControl layersControl = new LayersControl(layersControlOptions);
        layersControl.addTo(leafletMap);
        LayerGroup layerGroup1 = new LayerGroup(createVolunteersLatLngFromPoints(volunteerBackendService));
        layersControl.addOverlay(layerGroup1, "Pokaż wszystkich wolontariuszy");

        vaadinHorizontalLayout.add(leafletMap);
    }

    private List<Point> createPointsFromVolunteers(VolunteerBackendService volunteerBackendService) {
        List<VolunteerDto> volunteers = volunteerBackendService.getVolunteers().stream().map(
                volunteerDto -> new VolunteerDto(volunteerDto.getLat(), volunteerDto.getLon(), volunteerDto.getName()))
                .collect(Collectors.toList());

        return volunteers.stream().map(volunteerDto -> volunteerDto.createPoint(
                volunteerDto.getLat(), volunteerDto.getLon(), volunteerDto.getName()))
                .collect(Collectors.toList());
    }

    private LayerGroup createVolunteersLatLngFromPoints(VolunteerBackendService volunteerBackendService) {
        LayerGroup layerGroup = new LayerGroup();
        List<Point> points = createPointsFromVolunteers(volunteerBackendService);
        List<LatLng> latLngs = points.stream().map(point -> new LatLng(point.getLat(), point.getLon())).collect(Collectors.toList());
        List<Marker> markers = latLngs.stream().map(Marker::new).collect(Collectors.toList());
        markers.forEach(marker -> marker.setIcon(new Icon("icons/green.png")));

        for(int i = 0; i < markers.size(); i++) {
            markers.get(i).setTitle(points.get(i).getName() + ": wolontariusz");
            markers.forEach(marker -> marker.addTo(layerGroup));
        }

        return layerGroup;
    }
}

// stworzyć sposób na komunikowanie się zalogowanej instytucji z wybranym na mapie wolontariuszem
// dodać możliwość wybierania wolontariuszy dostępnych w wybranym czasie