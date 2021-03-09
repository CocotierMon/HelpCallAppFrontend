import { PolymerElement } from '@polymer/polymer/polymer-element';
import { html } from '@polymer/polymer/lib/utils/html-tag';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-area.js';
import '@vaadin/vaadin-date-picker/src/vaadin-date-picker.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class NewNeedView extends PolymerElement {

  static get template() {
    return html`
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout class="header" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct); align-self: center; align-items: center; justify-content: center;">
  <h1 style="margin: var(--lumo-space-m); padding: var(--lumo-space-m); align-self: center;">Zgłoś nową potrzebę</h1>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" style="width: 100%; align-self: center; align-items: center; justify-content: center;">
  <h3 style="align-self: center;">Opisz swoje marzenie, aby ktoś mógł je dla Ciebie zrealizować</h3>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" style="align-self: stretch; justify-content: space-evenly; align-items: center;">
  <vaadin-vertical-layout class="content" style="width: 50%; flex-grow: 1; flex-shrink: 1; flex-basis: auto; flex-direction: column; justify-content: center; align-items: center; align-self: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m);" theme="spacing">
   <vaadin-text-field label="Tytuł" placeholder="Tutaj wpisz tytuł" style="align-self: center; flex-grow: 0; width: 100%; margin: var(--lumo-space-m); padding: var(--lumo-space-m);" minlength="5" required invalid></vaadin-text-field>
   <vaadin-text-area label="Opisz swoją potrzebę" placeholder="Przykładowy opis:
Stary odkurzacz odmówił nam posłuszeństwa, a nie stać nas w tym momencie na nowy. Jeśli mają Państwo zbędny, z chęcią przyjmiemy go do siebie. Nie musi być nowy, ale też dobrze by było, żeby trochę jeszcze u nas podziałał. Prowadzimy ośmioosobowy dom, dlatego taki sprzęt jest nam niezbędny do codziennych porządków." style="width: 100%; margin: var(--lumo-space-m); padding: var(--lumo-space-m); align-self: center; height: 100%; flex-grow: 1;" minlength="50" required></vaadin-text-area>
   <h5 style="align-self: stretch;">Do kiedy Twoja potrzeba powinna zostać zrealizowana?</h5>
   <vaadin-date-picker label="Wybierz datę" placeholder="Pick a date" style="align-self: center; width: 50%;" required show-week-numbers></vaadin-date-picker>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout theme="spacing" id="vaadinVerticalLayout" style="flex-direction: column; width: 100%; align-items: center; justify-content: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m); height: 100%;">
   <h5 style="margin: var(--lumo-space-m); padding: var(--lumo-space-m); align-self: stretch;">Oznacz orientacyjne miejsce realizacji potrzeby. Jeśli nie określisz go teraz, wtedy zostanie ustawione na takie, które podano podczas rejestracji.</h5>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout class="footer" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct); justify-content: center;">
  <vaadin-vertical-layout theme="spacing" style="flex-shrink: 0;">
   <vaadin-button theme="primary success" style="flex-grow: 0; flex-shrink: 0;">
     Dodaj swoje nowe marzenie do listy! 
   </vaadin-button>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
  }

  static get is() {
    return 'nneed-view';
  }
}

customElements.define(NewNeedView.is, NewNeedView);