package com.helpcall.helpcallapp.views.opinions;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.helpcall.helpcallapp.views.opinions.OpinionsView.OpinionsViewModel;
import com.helpcall.helpcallapp.views.main.MainView;
import de.mekaso.vaadin.addons.Carousel;

import java.util.concurrent.TimeUnit;

@Route(value = "opinions", layout = MainView.class)
@PageTitle("Opinie")
@JsModule("./views/opinions/opinions-view.js")
@CssImport("./views/opinions/opinions-view.css")
@Tag("opinions-view")
public class OpinionsView extends PolymerTemplate<OpinionsViewModel> {

    @Id("vaadinVerticalLayout")
    private VerticalLayout vaadinVerticalLayout;

    public static interface OpinionsViewModel extends TemplateModel {
    }

    public OpinionsView() {
        Carousel carousel = Carousel.create()
                .withAutoplay()
                .withDuration(6, TimeUnit.SECONDS);

        carousel.setWidth("600px");
        carousel.setHeight("300px");

        Image img1 = new Image("images/Opinia1.png", "opinia 1");
        Image img2 = new Image("images/Opinia2.png", "opinia 2");
        Image img3 = new Image("images/Opinia3.png", "opinia 3");
        Image img4 = new Image("images/Opinia4.png", "opinia 4");
        carousel.add(img1);
        carousel.add(img2);
        carousel.add(img3);
        carousel.add(img4);

        vaadinVerticalLayout.add(carousel);
    }
}
