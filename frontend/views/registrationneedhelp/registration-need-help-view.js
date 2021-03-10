import { PolymerElement } from '@polymer/polymer/polymer-element';
import { html } from '@polymer/polymer/lib/utils/html-tag';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-area.js';
import '@vaadin/vaadin-radio-button/src/vaadin-radio-group.js';
import '@vaadin/vaadin-radio-button/src/vaadin-radio-button.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class RegistrationNeedHelpView extends PolymerElement {

  static get template() {
    return html`
<vaadin-vertical-layout style="width: 100%; height: 100%; flex-direction: column;">
 <vaadin-horizontal-layout class="header" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct); align-self: center; justify-content: center;">
  <h1>Rejestracja osoby zgłaszającej potrzebę</h1>
 </vaadin-horizontal-layout>
 <vaadin-vertical-layout class="content" style="width: 100%; flex-grow: 1; flex-shrink: 1; flex-basis: auto; align-self: center; align-items: center; justify-content: flex-start; flex-direction: row; align-content: space-between; height: 100%;">
  <vaadin-horizontal-layout theme="spacing" style="flex-direction: column; margin: var(--lumo-space-m); padding: var(--lumo-space-m); align-self: center; justify-content: center; align-items: center; align-content: center; width: 100%; height: 100%;">
   <vaadin-text-field placeholder="Nazwa użytkownika" style="align-self: center; width: 100%;" minlength="5" required maxlength="25" label="Wpisz swój nick" id="wpiszSwójNick" invalid></vaadin-text-field>
   <vaadin-text-field placeholder="E-mail" minlength="5" required maxlength="25" style="align-self: center; width: 100%;" label="Wpisz adres e-mail do kontaktu" id="wpiszAdresEMailDoKontaktu"></vaadin-text-field>
   <vaadin-text-field placeholder="Hasło" minlength="5" required maxlength="25" style="align-self: center; width: 100%;" label="Wprowadź hasło" id="wprowadźHasło"></vaadin-text-field>
   <vaadin-text-field placeholder="Powtórz hasło" minlength="5" required maxlength="25" style="align-self: center; width: 100%;" label="Powtórz hasło" id="powtórzHasło"></vaadin-text-field>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout theme="spacing" style="margin: var(--lumo-space-m); padding: var(--lumo-space-m); align-self: center; align-items: center; justify-content: space-around; flex-direction: column; height: 100%;" id="vaadinHorizontalLayout1">
   <div style="margin: var(--lumo-space-m); padding: var(--lumo-space-m); align-self: center; margin-bottom: var(--lumo-space-xs); padding-bottom: var(--lumo-space-xs); width: 100%; height: 100%;" id="choose"></div>
   <div style="margin: var(--lumo-space-m); padding: var(--lumo-space-m); align-self: center; margin-bottom: var(--lumo-space-xs); padding-bottom: var(--lumo-space-xs); width: 100%; height: 100%;">
     Oznacz swoje położenie na mapie. Złap pinezkę i opuść w wybrane miejsce na mapie. Nie musisz oznaczać swojego miejsca zamieszkania. Możesz zaznaczyć przybliżone miejsce, w którym Twoje potrzeby miałyby być zrealizowane. 
   </div>
  </vaadin-horizontal-layout>
 </vaadin-vertical-layout>
</vaadin-vertical-layout>
<vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout" style="width: 100%; height: 100%; padding: var(--lumo-space-m); margin: var(--lumo-space-m); align-items: center; justify-content: center;"></vaadin-horizontal-layout>
<vaadin-horizontal-layout theme="spacing" style="width: 100%; height: 100%; margin: var(--lumo-space-m); flex-direction: row; align-items: center; justify-content: center; align-content: flex-end; padding: var(--lumo-space-m); margin-top: var(--lumo-space-xs); padding-top: var(--lumo-space-xs); margin-bottom: var(--lumo-space-xs); padding-bottom: var(--lumo-space-xs); flex-wrap: wrap;">
 <vaadin-text-area label="Opisz się w kilku słowach" placeholder="Przykładowy opis:
Jesteśmy zawodową rodziną zastępczą. Działamy od 2010 roku, a w naszym domu gościliśmy do tej pory trzydzieścioro dzieci. Obecnie przebywa u nas czworo podopiecznych, dwoje z niepełnosprawnością. Dziękujemy za Waszą pomoc!" style="width: 100%; height: 100%; margin: var(--lumo-space-m); align-self: center;" minlength="30" maxlength="300" required id="opiszSięWKilkuSłowach" invalid></vaadin-text-area>
</vaadin-horizontal-layout>
<vaadin-horizontal-layout theme="spacing" style="margin: var(--lumo-space-m); padding: var(--lumo-space-m); align-items: flex-start; justify-content: center; flex-wrap: wrap; align-content: center; margin-top: var(--lumo-space-xs); padding-top: var(--lumo-space-xs);">
 <vaadin-button theme="primary success" style="margin: var(--lumo-space-m); width: 100%; height: 100%; flex-grow: 1; align-self: center;" id="vaadinButton" tabindex="">
   Zakładam konto jako osoba potrzebująca pomocy 
 </vaadin-button>
</vaadin-horizontal-layout>
<vaadin-horizontal-layout class="footer" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct);"></vaadin-horizontal-layout>
`;
  }

  static get is() {
    return 'registration-need-help-view';
  }
}

customElements.define(RegistrationNeedHelpView.is, RegistrationNeedHelpView);
