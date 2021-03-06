package com.helpcall.helpcallapp.views.benefits;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.helpcall.helpcallapp.views.benefits.BenefitsView.BenefitsViewModel;
import com.helpcall.helpcallapp.views.main.MainView;

@Route(value = "benefits", layout = MainView.class)
@PageTitle("Korzyści")
@JsModule("./views/benefits/benefits-view.js")
@CssImport("./views/benefits/benefits-view.css")
@Tag("benefits-view")
public class BenefitsView extends PolymerTemplate<BenefitsViewModel> {

    public static interface BenefitsViewModel extends TemplateModel {
    }

    public BenefitsView() {
    }
}
