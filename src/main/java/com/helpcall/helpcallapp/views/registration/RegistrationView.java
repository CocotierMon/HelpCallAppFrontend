package com.helpcall.helpcallapp.views.registration;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.helpcall.helpcallapp.views.registration.RegistrationView.RegistrationViewModel;
import com.helpcall.helpcallapp.views.main.MainView;

@Route(value = "registration", layout = MainView.class)
@PageTitle("Rejestracja")
@JsModule("./views/registration/registration-view.js")
@CssImport("./views/registration/registration-view.css")
@Tag("registration-view")
public class RegistrationView extends PolymerTemplate<RegistrationViewModel> {

    public static interface RegistrationViewModel extends TemplateModel {
    }

    public RegistrationView() {
    }
}
