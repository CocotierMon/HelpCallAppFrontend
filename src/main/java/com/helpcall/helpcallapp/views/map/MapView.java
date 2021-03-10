package com.helpcall.helpcallapp.views.map;

import com.vaadin.addon.leaflet4vaadin.LeafletMap;
import com.vaadin.addon.leaflet4vaadin.layer.map.options.DefaultMapOptions;
import com.vaadin.addon.leaflet4vaadin.layer.map.options.MapOptions;
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

    public MapView() {
        MapOptions options = new DefaultMapOptions();
        options.setCenter(new LatLng(51.74913908790854, 19.456787109375));
        options.setZoom(7);
        LeafletMap leafletMap = new LeafletMap(options );
        leafletMap.setBaseUrl("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png");
        leafletMap.setHeight("800px");
        leafletMap.setWidth("800px");

        vaadinVerticalLayout1.add(leafletMap);
    }
}
