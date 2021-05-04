package com.helpcall.helpcallapp.views.wallOfGlory;

import com.helpcall.helpcallapp.client.VolunteersWallBackendClient;
import com.helpcall.helpcallapp.domain.VolunteerWallDto;
import com.helpcall.helpcallapp.service.VolunteerWallBackendService;
import com.helpcall.helpcallapp.views.main.MainView;
import com.helpcall.helpcallapp.views.wallOfGlory.WallOfGloryView.WallOfGloryViewModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.checkbox.Checkbox;
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
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route(value = "wall", layout = MainView.class)
@PageTitle("Moja ściana chwały")
@JsModule("./views/wall/wall-view.js")
@CssImport("./views/wall/wall-view.css")
@Tag("wall-view")
public class WallOfGloryView extends PolymerTemplate<WallOfGloryViewModel> {

    @Id("vaadinHorizontalLayout")
    private HorizontalLayout vaadinHorizontalLayout;

    @Autowired
    VolunteersWallBackendClient service;

    public static interface WallOfGloryViewModel extends TemplateModel {
    }

    public WallOfGloryView(VolunteerWallBackendService service) {

        List<VolunteerWallDto> volunteerWallDtos = service.getVolunteersWall(22L);
        //stworzyć metodę, która będzie tworzyć listę potrzeb wg id zalogowanego wolontariusza

        Grid<VolunteerWallDto> vaadinGrid = new Grid<>(VolunteerWallDto.class);
        vaadinGrid.setColumnReorderingAllowed(true);
        vaadinGrid.addComponentColumn(volunteerWallDto -> new Checkbox()).setHeader("Czy potwierdzono wykonanie?");
        vaadinGrid.setItems(volunteerWallDtos);
        vaadinGrid.getColumnByKey("title").setHeader("Tytuł");
        vaadinGrid.getColumnByKey("endTime").setHeader("Data zakończenia");
        vaadinGrid.getColumnByKey("institutionName").setHeader("Potrzeba spełniona dla:");
        vaadinGrid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
        vaadinHorizontalLayout.add(vaadinGrid);
    }
}

// dodać możliwość skontaktowania się z instytucją, której potrzebę realizuje wolontariusz