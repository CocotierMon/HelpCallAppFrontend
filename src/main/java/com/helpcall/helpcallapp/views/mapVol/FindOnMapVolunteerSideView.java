package com.helpcall.helpcallapp.views.mapVol;

import com.helpcall.helpcallapp.domain.NeedDto;
import com.helpcall.helpcallapp.domain.Point;
import com.helpcall.helpcallapp.service.NeedBackendService;
import com.helpcall.helpcallapp.views.main.MainView;
import com.helpcall.helpcallapp.views.mapVol.FindOnMapVolunteerSideView.FindOnMapVolunteerSideViewModel;
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

@Route(value = "mapvol", layout = MainView.class)
@PageTitle("Znajdź na mapie")
@JsModule("./views/mapvol/mapvol-view.js")
@CssImport("./views/mapvol/mapvol-view.css")
@Tag("mapvol-view")
public class FindOnMapVolunteerSideView extends PolymerTemplate<FindOnMapVolunteerSideViewModel> {

    @Id("vaadinHorizontalLayout")
    private HorizontalLayout vaadinHorizontalLayout;

    public static interface FindOnMapVolunteerSideViewModel extends TemplateModel {
    }

    public FindOnMapVolunteerSideView(NeedBackendService service) {
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
        LayerGroup layerGroup = new LayerGroup(createNeedsLatLngFromPoints(service));
        layersControl.addOverlay(layerGroup, "Pokaż mi wszystkie potrzeby, które mogę zrealizować");

        vaadinHorizontalLayout.add(leafletMap);
    }

    public List<Point> createPointsFromNeeds(NeedBackendService needBackendService) {

        List<NeedDto> needs = needBackendService.getNeeds().stream().map(
                needDto -> new NeedDto(needDto.getLat(), needDto.getLon(), needDto.getTitle()))
                .collect(Collectors.toList());

        return needs.stream().map(needDto -> needDto.createPoint(
                needDto.getLat(), needDto.getLon(), needDto.getTitle())).collect(Collectors.toList());
    }

    public LayerGroup createNeedsLatLngFromPoints(NeedBackendService service) {
        LayerGroup layerGroup = new LayerGroup();
        List<Point> points = createPointsFromNeeds(service);
        List<LatLng> latLngs = points.stream().map(point -> new LatLng(point.getLat(), point.getLon())).collect(Collectors.toList());
        List<Marker> markers = latLngs.stream().map(Marker::new).collect(Collectors.toList());
        markers.forEach(marker -> marker.setIcon(new Icon("icons/blue.png")));

        for(int i = 0; i < markers.size(); i++) {
            markers.get(i).setTitle(points.get(i).getName() + ": moje marzenie");
            markers.forEach(marker -> marker.addTo(layerGroup));
        }

        return layerGroup;
    }
}

// dodać możliwość zapisania się wolontariusza do realizacji potrzeb