package com.helpcall.helpcallapp.views.wallOfGlory;

import com.helpcall.helpcallapp.domain.VolunteerDto;
import com.helpcall.helpcallapp.service.VolunteerBackendService;
import com.helpcall.helpcallapp.views.main.MainView;
import com.helpcall.helpcallapp.views.wallOfGlory.WallOfGloryView.WallOfGloryViewModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;

import java.util.List;

@Route(value = "wall", layout = MainView.class)
@PageTitle("Moja ściana chwały")
@JsModule("./views/wall/wall-view.js")
@CssImport("./views/wall/wall-view.css")
@Tag("wall-view")
public class WallOfGloryView extends PolymerTemplate<WallOfGloryViewModel> {

    @Id("vaadinHorizontalLayout")
    private HorizontalLayout vaadinHorizontalLayout;

    public static interface WallOfGloryViewModel extends TemplateModel {
    }

    public WallOfGloryView(VolunteerBackendService volunteerBackendService) {
        List<VolunteerDto> needsList = volunteerBackendService.getVolunteers();
        Grid<VolunteerDto> vaadinGrid = new Grid<>(VolunteerDto.class);
        vaadinGrid.setItems(needsList);
                    //na razie zwraca listę wolontariuszy, stworzyć metodę, która będzie filtrować listę potrzeb wg id wolontariusza
        vaadinGrid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
        vaadinHorizontalLayout.add(vaadinGrid);
    }
}
