package com.helpcall.helpcallapp.views.map;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.crud.Crud;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.helpcall.helpcallapp.views.map.MapView.MapViewModel;
import com.helpcall.helpcallapp.views.main.MainView;
import software.xdev.vaadin.maps.leaflet.flow.LMap;
import software.xdev.vaadin.maps.leaflet.flow.data.*;

import java.util.Arrays;
import java.util.List;

@Route(value = "map", layout = MainView.class)
@PageTitle("Mapa")
@JsModule("./views/map/map-view.js")
@CssImport("./views/map/map-view.css")
@Tag("map-view")
public class MapView extends PolymerTemplate<MapViewModel> {

    private List<LPoint> points;
    private LMap map;
    private boolean viewSwitch;

    private LMarker markerZob;
    private LMarker markerRathaus;

    private LCircle circleRange;
    private LMarker markerPizza;
    private LMarker markerKebab;
    private LMarker markerAsia;
    private LMarker markerGreek;
    private LMarker markerBakery;
    private LMarker markerLeberkaese;
    @Id("vaadinButton")
    private Button vaadinButton;
    @Id("vaadinButton1")
    private Button vaadinButton1;
    @Id("vaadinSplitLayout")
    private SplitLayout vaadinSplitLayout;

    public static interface MapViewModel extends TemplateModel {
    }

    public MapView() {
        this.mapTest();
        this.vaadinButton.addClickListener(this::buttonOnClick);
        this.vaadinButton1.addClickListener(this::buttonOnClick1);
    }

    private void buttonOnClick(final ClickEvent<Button> event)
    {
        if(this.viewSwitch)
        {
            this.viewSwitch = false;

            this.map.setViewPoint(new LCenter(51.3688300, 19.3567100, 16));
            this.map.removeItem(this.markerRathaus, this.markerZob);

            this.map.addLComponent(
                    this.circleRange,
                    this.markerPizza,
                    this.markerKebab,
                    this.markerAsia,
                    this.markerGreek,
                    this.markerBakery,
                    this.markerLeberkaese);

        }
        else
        {
            this.viewSwitch = true;
            this.map.setViewPoint(new LCenter(51.3688300, 19.3567100, 17));
            this.map.addLComponent(this.markerRathaus, this.markerZob);

            this.map.removeItem(
                    this.circleRange,
                    this.markerPizza,
                    this.markerKebab,
                    this.markerAsia,
                    this.markerGreek,
                    this.markerBakery,
                    this.markerLeberkaese);
        }
    }

    private void buttonOnClick1(final ClickEvent<Button> event)
    {

        if(this.viewSwitch)
        {
            this.viewSwitch = false;

            this.map.setViewPoint(new LCenter(51.3688300, 19.3567100, 16));
            this.map.removeItem(this.markerRathaus, this.markerZob);

            this.map.addLComponent(
                    this.circleRange,
                    this.markerPizza,
                    this.markerKebab,
                    this.markerAsia,
                    this.markerGreek,
                    this.markerBakery,
                    this.markerLeberkaese);

        }
        else
        {
            this.viewSwitch = true;
            this.map.setViewPoint(new LCenter(51.3688300, 19.3567100, 17));
            this.map.addLComponent(this.markerRathaus, this.markerZob);

            this.map.removeItem(
                    this.circleRange,
                    this.markerPizza,
                    this.markerKebab,
                    this.markerAsia,
                    this.markerGreek,
                    this.markerBakery,
                    this.markerLeberkaese);
        }
    }

    public void mapTest()
    {
        this.viewSwitch = true;
        this.map = new LMap(51.3688300, 19.3567100, 17);

        this.map.setHeight("700px");
        this.map.setWidth("1000px");
        vaadinSplitLayout.addToPrimary(this.map);
        vaadinSplitLayout.addToSecondary(new Div());
        this.map.addMarkerClickListener(ev -> { System.out.println(ev.getTag());}); // add some logic here for called Markers (token)


        final LMarker markerXDev = new LMarker(51.3688300, 19.3567100);

        final LMarker markerInfo = new LMarker(51.3688300, 19.3567100);

        this.getPunkte();
        final LPolygon polygonNoc = new LPolygon(this.points);
        polygonNoc.setFill(true);
        polygonNoc.setFillColor("#3366ff");
        polygonNoc.setFillOpacity(0.8);
        polygonNoc.setStroke(false);
        polygonNoc.setPopup("NOC-Nordoberpfalz Center");

        this.markerRathaus = new LMarker(51.3688300, 19.3567100, "L-22556");
        this.markerRathaus.setPopup("Old Town Hall");


        this.circleRange = new LCircle(51.3688300, 19.3567100, 450);

        this.markerPizza = new LMarker(51.3688300, 19.3567100);
        this.markerPizza.setPopup("Pizza!");

        this.markerKebab = new LMarker(51.3688300, 19.3567100);
        this.markerKebab.setPopup("Kebab!");

        this.markerAsia = new LMarker(51.3688300, 19.3567100);
        this.markerAsia.setPopup("Asian Food");

        this.markerGreek = new LMarker(51.3688300, 19.3567100);
        this.markerGreek.setPopup("Greek Food");

        this.markerBakery = new LMarker(51.3688300, 19.3567100);
        this.markerBakery.setPopup("Fresh baked stuff");

        this.markerLeberkaese = new LMarker(51.3688300, 19.3567100);
        this.markerLeberkaese.setPopup("Fast food like Leberkäsesemmeln");

        this.map.addLComponent(
                markerXDev,
                markerInfo,
                this.markerZob,
                polygonNoc,
                this.markerRathaus);
    }

    public void getPunkte()
    {
        this.points = Arrays.asList(
                new LPoint(51.3688301, 19.3567101),
                new LPoint(51.3688303, 19.3567103),
                new LPoint(51.3688305, 19.3567105),
                new LPoint(51.3688307, 19.3567107),
                new LPoint(51.3688309, 19.3567109));
    }
}
