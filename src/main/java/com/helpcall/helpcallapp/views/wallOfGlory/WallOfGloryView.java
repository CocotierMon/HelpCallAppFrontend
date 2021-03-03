package com.helpcall.helpcallapp.views.wallOfGlory;

import com.helpcall.helpcallapp.views.main.MainView;
import com.helpcall.helpcallapp.views.wallOfGlory.WallOfGloryView.WallOfGloryViewModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;

@Route(value = "wall", layout = MainView.class)
@PageTitle("Moja ściana chwały")
@JsModule("./views/wall/wall-view.js")
@CssImport("./views/wall/wall-view.css")
@Tag("wall-view")
public class WallOfGloryView extends PolymerTemplate<WallOfGloryViewModel> {

    public static interface WallOfGloryViewModel extends TemplateModel {
    }

    public WallOfGloryView() {
    }
}
