package com.helpcall.helpcallapp.views.login;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.helpcall.helpcallapp.views.login.LoginView.LoginViewModel;
import com.helpcall.helpcallapp.views.main.MainView;

@Route(value = "login", layout = MainView.class)
@PageTitle("Zaloguj się")
@JsModule("./views/login/login-view.js")
@CssImport("./views/login/login-view.css")
@Tag("login-view")
public class LoginView extends PolymerTemplate<LoginViewModel> {

    public static interface LoginViewModel extends TemplateModel {
    }

    public LoginView() {

        //implementacja Spring Security: na podstawie danych z bazy
    }
}
