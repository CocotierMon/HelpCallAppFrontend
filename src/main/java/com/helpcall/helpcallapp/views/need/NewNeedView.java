package com.helpcall.helpcallapp.views.need;

import com.helpcall.helpcallapp.views.main.MainView;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.helpcall.helpcallapp.views.need.NewNeedView.NewNeedViewModel;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;

@Route(value = "nneed", layout = MainView.class)
@PageTitle("Nowa potrzeba")
@JsModule("./views/need/nneed-view.js")
@CssImport("./views/need/nneed-view.css")
@Tag("nneed-view")
public class NewNeedView extends PolymerTemplate<NewNeedViewModel> {

    public static interface NewNeedViewModel extends TemplateModel {
    }

    public NewNeedView() {

    }
}
