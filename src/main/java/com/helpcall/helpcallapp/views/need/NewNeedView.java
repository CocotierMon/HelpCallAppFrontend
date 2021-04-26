package com.helpcall.helpcallapp.views.need;

import com.helpcall.helpcallapp.domain.InstitutionDto;
import com.helpcall.helpcallapp.domain.NeedDto;
import com.helpcall.helpcallapp.domain.VolunteerDto;
import com.helpcall.helpcallapp.observer.Observable;
import com.helpcall.helpcallapp.observer.Observer;
import com.helpcall.helpcallapp.service.InstitutionBackendService;
import com.helpcall.helpcallapp.service.NeedBackendService;
import com.helpcall.helpcallapp.views.main.MainView;
import com.vaadin.addon.leaflet4vaadin.LeafletMap;
import com.vaadin.addon.leaflet4vaadin.layer.map.options.DefaultMapOptions;
import com.vaadin.addon.leaflet4vaadin.layer.map.options.MapOptions;
import com.vaadin.addon.leaflet4vaadin.layer.ui.marker.Marker;
import com.vaadin.addon.leaflet4vaadin.types.Icon;
import com.vaadin.addon.leaflet4vaadin.types.LatLng;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.helpcall.helpcallapp.views.need.NewNeedView.NewNeedViewModel;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;

import java.util.ArrayList;
import java.util.List;

@Route(value = "nneed", layout = MainView.class)
@PageTitle("Nowa potrzeba")
@JsModule("./views/need/nneed-view.js")
@CssImport("./views/need/nneed-view.css")
@Tag("nneed-view")
public class NewNeedView extends PolymerTemplate<NewNeedViewModel> implements Observable {

    @Id("vaadinVerticalLayout")
    private VerticalLayout vaadinVerticalLayout;
    @Id("vaadinHorizontalLayout")
    private HorizontalLayout vaadinHorizontalLayout;
    @Id("tytuł")
    private TextField title;
    @Id("opiszSwojąPotrzebę")
    private TextArea description;
    @Id("wybierzDatę")
    private DatePicker endDate;
    @Id("vaadinButton")
    private Button vaadinButton;

    private List<Observer> observers = new ArrayList<>();
    private NeedBackendService service;
    private InstitutionBackendService institutionService;
    private NeedDto needDto = new NeedDto();
    private TextField latitude;
    private TextField longitude;

    public static interface NewNeedViewModel extends TemplateModel {
    }

    public NewNeedView(NeedBackendService service, InstitutionBackendService institutionService, NeedDto needDto) {
        this.service = service;
        this.institutionService = institutionService;

        MapOptions options = new DefaultMapOptions();
        options.setCenter(new LatLng(51.74913908790854, 19.456787109375));
        options.setZoom(7);
        LeafletMap leafletMap = new LeafletMap(options );
        leafletMap.setBaseUrl("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png");
        leafletMap.setHeight("500px");
        leafletMap.setWidth("500px");

        Marker marker = new Marker(options.getCenter());
        marker.setDraggable(true);
        marker.setIcon(new Icon("icons/marker.png"));
        marker.bindPopup("Przesuń mnie i upuść");

        FormLayout form = new FormLayout();
        TextField latitude = new TextField();
        TextField longitude = new TextField();
        TextField country = new TextField();
        TextField state = new TextField();
        TextField city = new TextField();
        longitude.setWidthFull();
        latitude.setWidthFull();
        country.setReadOnly(true);
        state.setReadOnly(true);
        city.setReadOnly(true);

        latitude.setValue(marker.getLatLng().getLat().toString());
        latitude.setReadOnly(true);
        longitude.setValue(marker.getLatLng().getLng().toString());
        longitude.setReadOnly(true);
        marker.onMove((event) -> {
            LatLng newPosition = event.getLatLng();
            latitude.setValue(newPosition.getLat().toString());
            longitude.setValue(newPosition.getLng().toString());
        });

        marker.onDragEnd(dragEndEvent -> {
            needDto.setLat(latitude.getValue());
            needDto.setLon(longitude.getValue());
        });

        form.addFormItem(latitude, "Szerokość:");
        form.addFormItem(longitude, "Długość:");
        form.addFormItem(country, "Kraj");       //https://nominatim.openstreetmap.org/reverse?lat=50.
                                                         // 803339712828986&lon=19.116208585832624&json_callback=<string>&zoom=10
                                                        //dodanie połączenia do bazy wyszukującej miejscowość po koordynatach

        form.addFormItem(state, "Województwo");
        form.addFormItem(city, "Miejscowość");

        marker.addTo(leafletMap);

        vaadinHorizontalLayout.add(leafletMap);

        vaadinVerticalLayout.add(form);

        vaadinButton.addClickListener(buttonClickEvent -> {

            setNewNeed(needDto);

            addNotification();
        });
    }

    public void setNewNeed(NeedDto needDto) {

        needDto.setTitle(title.getValue());
        needDto.setDescription(description.getValue());
        needDto.setEndTime(endDate.getValue());

        InstitutionDto institutionDto = institutionService.getInstitutions().get(0);
        System.out.println(institutionDto);

        institutionDto.getNeeds().add(needDto);

        needDto.setInstitution(institutionDto);
        System.out.println(institutionDto);

        VolunteerDto volunteer = new VolunteerDto();
        registerObserver(volunteer);        //implementacja metody do pobierania danych zalogowanego użytkownika,
                                            // implementacja metody wysyłającej wiadomości do obserwatorów

        institutionService.addNeed(needDto, institutionDto.getId());

        try {
            notifyObservers(needDto);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public void addNotification() {
        Notification notification = new Notification(
                "Twoja potrzeba została dodana do listy potrzeb. " +
                        "Możesz ją teraz znaleźć w swoim panelu oraz na ogólnej mapie.", 3000,
                Notification.Position.TOP_START);
        notification.setOpened(true);
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers(NeedDto needDto) throws NoSuchFieldException {
        for(Observer observer : observers) {
            observer.update(needDto);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}
