package com.helpcall.helpcallapp.views.opinions;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.helpcall.helpcallapp.views.opinions.OpinionsView.OpinionsViewModel;
import com.helpcall.helpcallapp.views.main.MainView;

@Route(value = "opinions", layout = MainView.class)
@PageTitle("Opinie")
@JsModule("./views/opinions/opinions-view.js")
@CssImport("./views/opinions/opinions-view.css")
@Tag("opinions-view")
public class OpinionsView extends PolymerTemplate<OpinionsViewModel> {

    // This is the Java companion file of a design
    // You can find the design file in
    // /frontend/views/views/opinions/opinions-view.js
    // The design can be easily edited by using Vaadin Designer
    // (vaadin.com/designer)

    public static interface OpinionsViewModel extends TemplateModel {
    }

    public OpinionsView() {
    }
}
