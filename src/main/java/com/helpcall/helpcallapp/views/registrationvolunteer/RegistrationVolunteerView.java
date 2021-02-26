package com.helpcall.helpcallapp.views.registrationvolunteer;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
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

    // This is the Java companion file of a design
    // You can find the design file in
    // /frontend/views/views/registrationvolunteer/registration-volunteer-view.js
    // The design can be easily edited by using Vaadin Designer
    // (vaadin.com/designer)

    public static interface RegistrationVolunteerViewModel extends TemplateModel {
    }

    public RegistrationVolunteerView() {
    }
}
