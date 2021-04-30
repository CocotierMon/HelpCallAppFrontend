package com.helpcall.helpcallapp.views.map;

import com.helpcall.helpcallapp.domain.InstitutionDto;
import com.helpcall.helpcallapp.domain.Point;
import com.helpcall.helpcallapp.domain.VolunteerDto;
import com.helpcall.helpcallapp.service.InstitutionBackendService;
import com.helpcall.helpcallapp.service.VolunteerBackendService;
import com.vaadin.addon.leaflet4vaadin.LeafletMap;
import com.vaadin.addon.leaflet4vaadin.layer.map.options.DefaultMapOptions;
import com.vaadin.addon.leaflet4vaadin.layer.map.options.MapOptions;
import com.vaadin.addon.leaflet4vaadin.layer.ui.marker.Marker;
import com.vaadin.addon.leaflet4vaadin.types.Icon;
import com.vaadin.addon.leaflet4vaadin.types.LatLng;
import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.helpcall.helpcallapp.views.map.MapView.MapViewModel;
import com.helpcall.helpcallapp.views.main.MainView;

import java.util.*;
import java.util.stream.Collectors;


@Route(value = "map", layout = MainView.class)
@PageTitle("Mapa")
@JsModule("./views/map/map-view.js")
@CssImport("./views/map/map-view.css")
@Tag("map-view")
public class MapView extends PolymerTemplate<MapViewModel> {

    @Id("vaadinVerticalLayout1")
    private VerticalLayout vaadinVerticalLayout1;

    public static interface MapViewModel extends TemplateModel {
    }

    public MapView(InstitutionBackendService service, VolunteerBackendService volunteerBackendService) {
        MapOptions options = new DefaultMapOptions();
        options.setCenter(new LatLng(51.74913908790854, 19.456787109375));
        options.setZoom(7);
        LeafletMap leafletMap = new LeafletMap(options);
        leafletMap.setBaseUrl("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png");
        leafletMap.setHeight("800px");
        leafletMap.setWidth("800px");

        List<Marker> markersFromInstitutions = createInstitutionsLatLngFromPoints(service);
        markersFromInstitutions.forEach(marker -> marker.addTo(leafletMap));
        List<Marker> markersFromVolunteers = createVolunteersLatLngFromPoints(volunteerBackendService);
        markersFromVolunteers.forEach(marker -> marker.addTo(leafletMap));
        vaadinVerticalLayout1.add(leafletMap);

        // dodać mozliwość wybierania danych do pokazania: wybór wolontariuszy lub potrzeb
    }

    private List<Marker> createVolunteersLatLngFromPoints(VolunteerBackendService volunteerBackendService) {
        List<Point> points = createPointsFromVolunteers(volunteerBackendService);
        List<LatLng> latLngs = points.stream().map(point -> new LatLng(point.getLat(), point.getLon())).collect(Collectors.toList());
        List<Marker> markers = latLngs.stream().map(Marker::new).collect(Collectors.toList());
        markers.forEach(marker -> marker.setIcon(new Icon("icons/marker.png")));

        for(int i = 0; i < markers.size(); i++) {
            markers.get(i).setTitle(points.get(i).getName() + ": wolontariusz");
        }

        return markers;
    }

    private List<Point> createPointsFromVolunteers(VolunteerBackendService volunteerBackendService) {
        List<VolunteerDto> volunteers = volunteerBackendService.getVolunteers().stream().map(
                volunteerDto -> new VolunteerDto(volunteerDto.getLat(), volunteerDto.getLon(), volunteerDto.getName()))
                .collect(Collectors.toList());

        return volunteers.stream().map(volunteerDto -> volunteerDto.createPoint(
                volunteerDto.getLat(), volunteerDto.getLon(), volunteerDto.getName()))
                .collect(Collectors.toList());
    }

    public List<Point> createPointsFromInstitutions(InstitutionBackendService institutionBackendService) {

        List<InstitutionDto> institutions = institutionBackendService.getInstitutions().stream().map(
                institutionDto -> new InstitutionDto(institutionDto.getLat(), institutionDto.getLon(), institutionDto.getName()))
                .collect(Collectors.toList());

        return institutions.stream().map(institutionDto -> institutionDto.createPoint(
                institutionDto.getLat(), institutionDto.getLon(), institutionDto.getName())).collect(Collectors.toList());
    }

    public List<Marker> createInstitutionsLatLngFromPoints(InstitutionBackendService service) {
        List<Point> points = createPointsFromInstitutions(service);
        List<LatLng> latLngs = points.stream().map(point -> new LatLng(point.getLat(), point.getLon())).collect(Collectors.toList());
        List<Marker> markers = latLngs.stream().map(Marker::new).collect(Collectors.toList());
        markers.forEach(marker -> marker.setIcon(new Icon("icons/marker.png")));

        for(int i = 0; i < markers.size(); i++) {
            markers.get(i).setTitle(points.get(i).getName() + ": potrzebuję pomocy");
        }

        return markers;
    }
}
