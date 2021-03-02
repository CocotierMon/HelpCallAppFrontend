package com.helpcall.helpcallapp.views.needhelp;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.helpcall.helpcallapp.views.needhelp.NeedHelpView.NeedHelpViewModel;
import com.helpcall.helpcallapp.views.main.MainView;

@Route(value = "needHelp", layout = MainView.class)
@PageTitle("Potrzebuję pomocy")
@JsModule("./views/needhelp/need-help-view.js")
@CssImport("./views/needhelp/need-help-view.css")
@Tag("need-help-view")
public class NeedHelpView extends PolymerTemplate<NeedHelpViewModel> {

    public static interface NeedHelpViewModel extends TemplateModel {
    }

    public NeedHelpView() {
    }
}
