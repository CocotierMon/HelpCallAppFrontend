package com.helpcall.helpcallapp.views.needList;

import com.helpcall.helpcallapp.views.main.MainView;
import com.helpcall.helpcallapp.views.needList.MyNeedListView.MyNeedListViewModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;

@Route(value = "needList", layout = MainView.class)
@PageTitle("Moja lista potrzeb")
@JsModule("./views/needList/my-need-list-view.js")
@CssImport("./views/needList/my-need-list-view.css")
@Tag("my-need-list-view")
public class MyNeedListView extends PolymerTemplate<MyNeedListViewModel> {

    public static interface MyNeedListViewModel extends TemplateModel {
    }

    public MyNeedListView() {
    }
}
