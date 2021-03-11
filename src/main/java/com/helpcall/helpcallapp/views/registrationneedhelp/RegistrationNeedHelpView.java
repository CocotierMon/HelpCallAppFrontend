package com.helpcall.helpcallapp.views.registrationneedhelp;

import com.helpcall.helpcallapp.domain.InstitutionDto;
import com.helpcall.helpcallapp.service.InstitutionBackendService;
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
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
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
    @Id("vaadinHorizontalLayout")
    private HorizontalLayout vaadinHorizontalLayout;
    @Id("choose")
    private Div div;
    @Id("wpiszSwójNick")
    private TextField nick;
    @Id("wpiszAdresEMailDoKontaktu")
    private TextField email;
    @Id("wprowadźHasło")
    private TextField password;
    @Id("powtórzHasło")
    private TextField confirmPassword;
    @Id("vaadinButton")
    private Button vaadinButton;
    @Id("opiszSięWKilkuSłowach")
    private TextArea description;

    public static interface RegistrationNeedHelpViewModel extends TemplateModel {
    }

    public RegistrationNeedHelpView(InstitutionBackendService service) {

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

        InstitutionDto institution = new InstitutionDto();

        marker.onDragEnd(dragEndEvent -> {
            institution.setLat(latitude.getValue());
            institution.setLon(longitude.getValue());
        });

        form.addFormItem(latitude, "Szerokość:");
        form.addFormItem(longitude, "Długość:");

        marker.addTo(leafletMap);

        RadioButtonGroup<String> choosAnswer = new RadioButtonGroup<>();
        choosAnswer.setId("choose");
        choosAnswer.setLabel("Wybierz odpowiedź:");
        choosAnswer.setRequired(true);
        choosAnswer.setItems("Rejestruję się jako osoba prywatna", "Rejestruję się jako osoba reprezentująca instytucję");

        div.add(choosAnswer);
        vaadinHorizontalLayout.add(leafletMap);

        vaadinHorizontalLayout1.add(form);

        confirmPassword.setValueChangeMode(ValueChangeMode.ON_BLUR);
        confirmPassword.addValueChangeListener((event) -> {
            if (!password.getValue().equals(confirmPassword.getValue())) {
                confirmPassword.clear();
                confirmPassword.setHelperText("Wprowadź poprawne hasło");
            }
        });

        vaadinButton.addClickListener(buttonClickEvent -> {
            institution.setName(nick.getValue());
            institution.setEmail(email.getValue());
            institution.setPassword(password.getValue());
            institution.setDescription(description.getValue());
            if(choosAnswer.getValue().equals("Rejestruję się jako osoba prywatna")) {
                institution.setIsInstitution("private");
            } else {
                institution.setIsInstitution("institution");
            }

            service.createInstitution(institution);
        });
    }

}
