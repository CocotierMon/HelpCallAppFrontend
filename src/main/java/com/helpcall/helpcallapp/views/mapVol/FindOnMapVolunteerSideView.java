package com.helpcall.helpcallapp.views.mapVol;

import com.helpcall.helpcallapp.views.main.MainView;
import com.helpcall.helpcallapp.views.mapVol.FindOnMapVolunteerSideView.FindOnMapVolunteerSideViewModel;
import com.vaadin.addon.leaflet4vaadin.LeafletMap;
import com.vaadin.addon.leaflet4vaadin.layer.map.options.DefaultMapOptions;
import com.vaadin.addon.leaflet4vaadin.layer.map.options.MapOptions;
import com.vaadin.addon.leaflet4vaadin.layer.ui.marker.Marker;
import com.vaadin.addon.leaflet4vaadin.types.Icon;
import com.vaadin.addon.leaflet4vaadin.types.LatLng;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;

@Route(value = "mapvol", layout = MainView.class)
@PageTitle("Znajdź na mapie")
@JsModule("./views/mapvol/mapvol-view.js")
@CssImport("./views/mapvol/mapvol-view.css")
@Tag("mapvol-view")
public class FindOnMapVolunteerSideView extends PolymerTemplate<FindOnMapVolunteerSideViewModel> {

    @Id("vaadinVerticalLayout")
    private VerticalLayout vaadinVerticalLayout;

    public static interface FindOnMapVolunteerSideViewModel extends TemplateModel {
    }

    public FindOnMapVolunteerSideView() {
        MapOptions options = new DefaultMapOptions();
        options.setCenter(new LatLng(47.070121823, 19.204101562500004));
        options.setZoom(7);
        LeafletMap leafletMap = new LeafletMap(options );
        leafletMap.setBaseUrl("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png");
        leafletMap.setHeight("400px");
        leafletMap.setWidth("400px");

        Marker marker = new Marker(options.getCenter());
        marker.setDraggable(true);
        marker.setIcon(new Icon("icons/marker.png"));
        marker.addTo(leafletMap);

        vaadinVerticalLayout.add(leafletMap);
    }
}
