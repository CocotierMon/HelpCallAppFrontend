package com.helpcall.helpcallapp.views.registrationvolunteer;

import com.helpcall.helpcallapp.domain.VolunteerDto;
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
import com.vaadin.flow.component.formlayout.FormLayout;
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

    @Id("vaadinHorizontalLayout")
    private HorizontalLayout vaadinHorizontalLayout;
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

    private VolunteerDto volunteerDto = new VolunteerDto();

    public static interface RegistrationVolunteerViewModel extends TemplateModel {
    }

    public RegistrationVolunteerView() {

        MapOptions options = new DefaultMapOptions();
        options.setCenter(new LatLng(51.74913908790854, 19.456787109375));
        options.setZoom(7);
        LeafletMap leafletMap = new LeafletMap(options );
        leafletMap.setBaseUrl("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png");
        leafletMap.setHeight("800px");
        leafletMap.setWidth("800px");

        Marker marker = new Marker(options.getCenter());
        marker.setDraggable(true);
        marker.setIcon(new Icon("icons/marker.png"));
        marker.bindPopup("Przesuń mnie i upuść");

        FormLayout form = new FormLayout();
        TextField latitude = new TextField();
        TextField longitude = new TextField();
        longitude.setWidthFull();
        latitude.setWidthFull();

        latitude.setValue(marker.getLatLng().getLat().toString());
        latitude.setReadOnly(true);
        longitude.setValue(marker.getLatLng().getLng().toString());
        longitude.setReadOnly(true);
        marker.onMove((event) -> {
            LatLng newPosition = event.getLatLng();
            latitude.setValue(newPosition.getLat().toString());
            longitude.setValue(newPosition.getLng().toString());
        });

        marker.onDragEnd(dragEndEvent -> {
            volunteerDto.setLat(latitude.getValue());
            volunteerDto.setLon(longitude.getValue());
        });

        form.addFormItem(latitude, "Szerokość:");
        form.addFormItem(longitude, "Długość:");

        marker.addTo(leafletMap);

        vaadinHorizontalLayout.add(leafletMap);

        vaadinHorizontalLayout1.add(form);
    }


}
