package com.helpcall.helpcallapp.views.mapVol;

import com.helpcall.helpcallapp.views.main.MainView;
import com.helpcall.helpcallapp.views.mapVol.FindOnMapVolunteerSideView.FindOnMapVolunteerSideViewModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;

@Route(value = "mapvol", layout = MainView.class)
@PageTitle("Znajdź na mapie")
@JsModule("./views/mapvol/mapvol-view.js")
@CssImport("./views/mapvol/mapvol-view.css")
@Tag("mapvol-view")
public class FindOnMapVolunteerSideView extends PolymerTemplate<FindOnMapVolunteerSideViewModel> {

    public static interface FindOnMapVolunteerSideViewModel extends TemplateModel {
    }

    public FindOnMapVolunteerSideView() {
    }
}
