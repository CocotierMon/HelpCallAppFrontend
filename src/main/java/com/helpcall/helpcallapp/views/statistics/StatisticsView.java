package com.helpcall.helpcallapp.views.statistics;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.helpcall.helpcallapp.views.statistics.StatisticsView.StatisticsViewModel;
import com.helpcall.helpcallapp.views.main.MainView;

@Route(value = "stats", layout = MainView.class)
@PageTitle("Statystyki")
@JsModule("./views/statistics/statistics-view.js")
@CssImport("./views/statistics/statistics-view.css")
@Tag("statistics-view")
public class StatisticsView extends PolymerTemplate<StatisticsViewModel> {

    // This is the Java companion file of a design
    // You can find the design file in
    // /frontend/views/views/statistics/statistics-view.js
    // The design can be easily edited by using Vaadin Designer
    // (vaadin.com/designer)

    public static interface StatisticsViewModel extends TemplateModel {
    }

    public StatisticsView() {
    }
}
