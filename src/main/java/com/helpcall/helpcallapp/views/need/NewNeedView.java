package com.helpcall.helpcallapp.views.need;

import com.helpcall.helpcallapp.views.main.MainView;
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
import com.helpcall.helpcallapp.views.need.NewNeedView.NewNeedViewModel;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;

@Route(value = "nneed", layout = MainView.class)
@PageTitle("Nowa potrzeba")
@JsModule("./views/need/nneed-view.js")
@CssImport("./views/need/nneed-view.css")
@Tag("nneed-view")
public class NewNeedView extends PolymerTemplate<NewNeedViewModel> {

    @Id("vaadinVerticalLayout")
    private VerticalLayout vaadinVerticalLayout;

    public static interface NewNeedViewModel extends TemplateModel {
    }

    public NewNeedView() {
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
