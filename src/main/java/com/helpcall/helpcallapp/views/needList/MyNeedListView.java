package com.helpcall.helpcallapp.views.needList;

import com.helpcall.helpcallapp.domain.NeedDto;
import com.helpcall.helpcallapp.service.InstitutionBackendService;
import com.helpcall.helpcallapp.views.main.MainView;
import com.helpcall.helpcallapp.views.needList.MyNeedListView.MyNeedListViewModel;
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

import java.util.List;

@Route(value = "needList", layout = MainView.class)
@PageTitle("Moja lista potrzeb")
@JsModule("./views/needList/my-need-list-view.js")
@CssImport("./views/needList/my-need-list-view.css")
@Tag("my-need-list-view")
public class MyNeedListView extends PolymerTemplate<MyNeedListViewModel> {

    @Id("vaadinHorizontalLayout")
    private HorizontalLayout vaadinHorizontalLayout;

    public static interface MyNeedListViewModel extends TemplateModel {
    }

    public MyNeedListView(InstitutionBackendService institutionBackendService) {

        List<NeedDto> needs = institutionBackendService.getInstitutionsNeeds(14L);
        // implementacja: metoda pobierająca potrzeby zalogowanego uzytkownika

        Grid<NeedDto> vaadinGrid = new Grid<>(NeedDto.class);
        vaadinGrid.setColumnReorderingAllowed(true);
        vaadinGrid.setItems(needs);
        vaadinGrid.getColumns().forEach(needDtoColumn -> needDtoColumn.setAutoWidth(true));
        vaadinGrid.setColumns("title", "endTime", "done", "description");
        vaadinGrid.getColumnByKey("title").setHeader("Tytuł");
        vaadinGrid.getColumnByKey("endTime").setHeader("Data zakończenia");
        vaadinGrid.getColumnByKey("done").setHeader("Potwierdzono zakończenie?");
        vaadinGrid.getColumnByKey("description").setHeader("Opis");
        vaadinGrid.addComponentColumn(needDtos -> new Checkbox()).setHeader("Zamknięte ?");

        vaadinGrid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
        vaadinHorizontalLayout.add(vaadinGrid);
    }

    // dodać możliwość sprawdzenia, który wolontariusz jest przypisany do realizacji potrzeby i możliwość
    // wysłania do niego wiadomości prywatnej
    // dodać możliwość potwierdzania wykonania zadania przez wolontaiusza,
    // w odpowiedzi na jego prośbę o zatwierdzenie zakończenia realizacji potrzeby
    // wyświetlanie potrzeb z listy, które mają zakończyć się w określonym dniu - dodanie funkcjonalności
}
