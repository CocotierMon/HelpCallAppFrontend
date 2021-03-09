package com.helpcall.helpcallapp.views.registrationneedhelp;

import com.helpcall.helpcallapp.domain.InstitutionDto;
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
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.helpcall.helpcallapp.views.registrationneedhelp.RegistrationNeedHelpView.RegistrationNeedHelpViewModel;
import com.helpcall.helpcallapp.views.main.MainView;

@Route(value = "registrationNeedHelp", layout = MainView.class)
@PageTitle("Rejestracja dla osób potrzebujących pomocy")
@JsModule("./views/registrationneedhelp/registration-need-help-view.js")
@CssImport("./views/registrationneedhelp/registration-need-help-view.css")
@Tag("registration-need-help-view")
public class RegistrationNeedHelpView extends PolymerTemplate<RegistrationNeedHelpViewModel> {

    @Id("vaadinHorizontalLayout1")
    private HorizontalLayout vaadinHorizontalLayout1;
    private final InstitutionDto institutionDto = new InstitutionDto();
    @Id("vaadinHorizontalLayout")
    private HorizontalLayout vaadinHorizontalLayout;
    @Id("wpiszSwójNick")
    private TextField wpiszSwójNick;
    @Id("wpiszAdresEMailDoKontaktu")
    private TextField wpiszAdresEMailDoKontaktu;
    @Id("wprowadźHasło")
    private TextField wprowadźHasło;
    @Id("powtórzHasło")
    private TextField powtórzHasło;
    @Id("wybierzOdpowiedź")
    private RadioButtonGroup<String> wybierzOdpowiedź;
    @Id("vaadinButton")
    private Button vaadinButton;

    public static interface RegistrationNeedHelpViewModel extends TemplateModel {
    }

    public RegistrationNeedHelpView() {

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
            institutionDto.setLat(latitude.getValue());
            institutionDto.setLon(longitude.getValue());
        });

        form.addFormItem(latitude, "Szerokość:");
        form.addFormItem(longitude, "Długość:");

        marker.addTo(leafletMap);

        vaadinHorizontalLayout.add(leafletMap);

        vaadinHorizontalLayout1.add(form);
    }

}
