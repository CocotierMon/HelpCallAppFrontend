package com.helpcall.helpcallapp.views.registrationneedhelp;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.helpcall.helpcallapp.views.registrationneedhelp.RegistrationNeedHelpView.RegistrationNeedHelpViewModel;
import com.helpcall.helpcallapp.views.main.MainView;
import software.xdev.vaadin.maps.leaflet.flow.LMap;

@Route(value = "registrationNeedHelp", layout = MainView.class)
@PageTitle("Rejestracja dla osób potrzebujących pomocy")
@JsModule("./views/registrationneedhelp/registration-need-help-view.js")
@CssImport("./views/registrationneedhelp/registration-need-help-view.css")
@Tag("registration-need-help-view")
public class RegistrationNeedHelpView extends PolymerTemplate<RegistrationNeedHelpViewModel> {

    private LMap map;
    private boolean viewSwitch;
    @Id("vaadinHorizontalLayout")
    private HorizontalLayout vaadinHorizontalLayout;

    public static interface RegistrationNeedHelpViewModel extends TemplateModel {
    }

    public RegistrationNeedHelpView() {
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
