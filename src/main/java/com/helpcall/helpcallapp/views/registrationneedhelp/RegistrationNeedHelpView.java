package com.helpcall.helpcallapp.views.registrationneedhelp;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
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

    // This is the Java companion file of a design
    // You can find the design file in
    // /frontend/views/views/registrationneedhelp/registration-need-help-view.js
    // The design can be easily edited by using Vaadin Designer
    // (vaadin.com/designer)

    public static interface RegistrationNeedHelpViewModel extends TemplateModel {
    }

    public RegistrationNeedHelpView() {
    }
}
