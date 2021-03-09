package com.helpcall.helpcallapp.views.registrationvolunteer;

import com.vaadin.addon.leaflet4vaadin.LeafletMap;
import com.vaadin.addon.leaflet4vaadin.layer.map.options.DefaultMapOptions;
import com.vaadin.addon.leaflet4vaadin.layer.map.options.MapOptions;
import com.vaadin.addon.leaflet4vaadin.layer.ui.marker.Marker;
import com.vaadin.addon.leaflet4vaadin.types.Icon;
import com.vaadin.addon.leaflet4vaadin.types.LatLng;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.helpcall.helpcallapp.views.registrationvolunteer.RegistrationVolunteerView.RegistrationVolunteerViewModel;
import com.helpcall.helpcallapp.views.main.MainView;

@Route(value = "registrationVolunteer", layout = MainView.class)
@PageTitle("Rejestracja dla wolontariuszy")
@JsModule("./views/registrationvolunteer/registration-volunteer-view.js")
@CssImport("./views/registrationvolunteer/registration-volunteer-view.css")
@Tag("registration-volunteer-view")
public class RegistrationVolunteerView extends PolymerTemplate<RegistrationVolunteerViewModel> {

    @Id("vaadinHorizontalLayout1")
    private HorizontalLayout vaadinHorizontalLayout1;
    @Id("wpiszSwójNick")
    private TextField wpiszSwójNick;
    @Id("wpiszAdresEMailDoKontaktu")
    private TextField wpiszAdresEMailDoKontaktu;
    @Id("wprowadźHasło")
    private TextField wprowadźHasło;
    @Id("powtórzHasło")
    private TextField powtórzHasło;
    @Id("opiszSięWKilkuSłowach")
    private TextArea opiszSięWKilkuSłowach;
    @Id("vaadinButton")
    private Button vaadinButton;

    public static interface RegistrationVolunteerViewModel extends TemplateModel {
    }

    public RegistrationVolunteerView() {
        MapOptions options = new DefaultMapOptions();
        options.setCenter(new LatLng(51.74913908790854, 19.456787109375));
        options.setZoom(7);
        LeafletMap leafletMap = new LeafletMap(options );
        leafletMap.setBaseUrl("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png");
        leafletMap.setHeight("400px");
        leafletMap.setWidth("400px");

        Marker marker = new Marker(options.getCenter());
        marker.setDraggable(true);
      //  marker.setIcon(new Icon("icons/marker.png"));

        marker.addTo(leafletMap);

        vaadinHorizontalLayout1.add(leafletMap);
    }


}
