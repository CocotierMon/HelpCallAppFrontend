package com.helpcall.helpcallapp.views.start;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.helpcall.helpcallapp.views.start.StartView.StartViewModel;
import com.helpcall.helpcallapp.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "start", layout = MainView.class)
@PageTitle("Start")
@JsModule("./views/start/start-view.js")
@CssImport("./views/start/start-view.css")
@Tag("start-view")
@RouteAlias(value = "", layout = MainView.class)
public class StartView extends PolymerTemplate<StartViewModel> {
    @Id("vaadinHorizontalLayout")
    private HorizontalLayout vaadinHorizontalLayout;
    @Id("vaadinVerticalLayout")
    private VerticalLayout vaadinVerticalLayout;
    @Id("vaadinSplitLayout")
    private SplitLayout vaadinSplitLayout;
    @Id("span")
    private Span span;
    @Id("div")
    private Div div;
    @Id("span1")
    private Span span1;
    @Id("vaadinHorizontalLayout1")
    private HorizontalLayout vaadinHorizontalLayout1;
    @Id("vaadinButton")
    private Button vaadinButton;

    // This is the Java companion file of a design
    // You can find the design file in /frontend/views/views/start/start-view.js
    // The design can be easily edited by using Vaadin Designer
    // (vaadin.com/designer)

    public static interface StartViewModel extends TemplateModel {
    }

    public StartView() {
    }
}
