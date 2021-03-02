package com.helpcall.helpcallapp.views.registrationvolunteer;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.helpcall.helpcallapp.views.registrationvolunteer.RegistrationVolunteerView.RegistrationVolunteerViewModel;
import com.helpcall.helpcallapp.views.main.MainView;
import software.xdev.vaadin.maps.leaflet.flow.LMap;

@Route(value = "registrationVolunteer", layout = MainView.class)
@PageTitle("Rejestracja dla wolontariuszy")
@JsModule("./views/registrationvolunteer/registration-volunteer-view.js")
@CssImport("./views/registrationvolunteer/registration-volunteer-view.css")
@Tag("registration-volunteer-view")
public class RegistrationVolunteerView extends PolymerTemplate<RegistrationVolunteerViewModel> {

    private LMap map;
    private boolean viewSwitch;
    @Id("vaadinHorizontalLayout")
    private HorizontalLayout vaadinHorizontalLayout;

    public static interface RegistrationVolunteerViewModel extends TemplateModel {
    }

    public RegistrationVolunteerView() {
        this.mapTest();
    }

    public void mapTest() {
        this.viewSwitch = true;
        this.map = new LMap(51.3688300, 19.3567100, 17);

        this.map.setHeight("400px");
        this.map.setWidth("400px");
        vaadinHorizontalLayout.add(this.map);
    }
}
