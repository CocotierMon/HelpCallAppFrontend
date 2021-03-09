package com.helpcall.helpcallapp.views.needList;

import com.helpcall.helpcallapp.domain.NeedDto;
import com.helpcall.helpcallapp.service.NeedBackendService;
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

    public MyNeedListView(NeedBackendService needBackendService) {
        List<NeedDto> needsList = needBackendService.getNeeds();
        Grid<NeedDto> vaadinGrid = new Grid<>(NeedDto.class);
        vaadinGrid.setItems(needsList);
        vaadinGrid.getColumnByKey("title").setHeader("Tytuł");
        vaadinGrid.getColumnByKey("endTime").setHeader("Data zakończenia");
        vaadinGrid.getColumnByKey("volunteers").setHeader("Przypisany wolontariusz");
        vaadinGrid.addComponentColumn(needDto -> new Checkbox()).setHeader("Zrobione ?");
        vaadinGrid.removeColumnByKey("id");
        vaadinGrid.removeColumnByKey("description");
        vaadinGrid.removeColumnByKey("institution");
        vaadinGrid.removeColumnByKey("location");
        vaadinGrid.removeColumnByKey("needsBoard");
        vaadinGrid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
        vaadinHorizontalLayout.add(vaadinGrid);

        //pobiera listę wszystkich potrzeb, metoda do wyciągania potrzeby przez id instytucji
    }
}
