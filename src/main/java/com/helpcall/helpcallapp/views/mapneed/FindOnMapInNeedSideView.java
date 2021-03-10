package com.helpcall.helpcallapp.views.mapneed;

import com.helpcall.helpcallapp.views.main.MainView;
import com.helpcall.helpcallapp.views.mapneed.FindOnMapInNeedSideView.FindOnMapInNeedSideViewModel;
import com.vaadin.addon.leaflet4vaadin.LeafletMap;
import com.vaadin.addon.leaflet4vaadin.layer.map.options.DefaultMapOptions;
import com.vaadin.addon.leaflet4vaadin.layer.map.options.MapOptions;
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

    public FindOnMapInNeedSideView() {
        MapOptions options = new DefaultMapOptions();
        options.setCenter(new LatLng(51.74913908790854, 19.456787109375));
        options.setZoom(7);
        LeafletMap leafletMap = new LeafletMap(options );
        leafletMap.setBaseUrl("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png");
        leafletMap.setHeight("800px");
        leafletMap.setWidth("800px");

        vaadinHorizontalLayout.add(leafletMap);
    }
}
