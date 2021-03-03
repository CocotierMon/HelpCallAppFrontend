package com.helpcall.helpcallapp.views.mapneed;

import com.helpcall.helpcallapp.views.main.MainView;
import com.helpcall.helpcallapp.views.mapneed.FindOnMapInNeedSideView.FindOnMapInNeedSideViewModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;

@Route(value = "mapneed", layout = MainView.class)
@PageTitle("Znajdź na mapie")
@JsModule("./views/mapneed/mapneed-view.js")
@CssImport("./views/mapneed/mapneed-view.css")
@Tag("mapneed-view")
public class FindOnMapInNeedSideView extends PolymerTemplate<FindOnMapInNeedSideViewModel> {

    public static interface FindOnMapInNeedSideViewModel extends TemplateModel {
    }

    public FindOnMapInNeedSideView() {
    }
}
