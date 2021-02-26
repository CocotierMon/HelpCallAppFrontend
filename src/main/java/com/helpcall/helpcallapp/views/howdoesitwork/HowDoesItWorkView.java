package com.helpcall.helpcallapp.views.howdoesitwork;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.helpcall.helpcallapp.views.howdoesitwork.HowDoesItWorkView.HowDoesItWorkViewModel;
import com.helpcall.helpcallapp.views.main.MainView;

@Route(value = "how", layout = MainView.class)
@PageTitle("Jak to działa?")
@JsModule("./views/howdoesitwork/how-does-it-work-view.js")
@CssImport("./views/howdoesitwork/how-does-it-work-view.css")
@Tag("how-does-it-work-view")
public class HowDoesItWorkView extends PolymerTemplate<HowDoesItWorkViewModel> {

    // This is the Java companion file of a design
    // You can find the design file in
    // /frontend/views/views/howdoesitwork/how-does-it-work-view.js
    // The design can be easily edited by using Vaadin Designer
    // (vaadin.com/designer)

    public static interface HowDoesItWorkViewModel extends TemplateModel {
    }

    public HowDoesItWorkView() {
    }
}
