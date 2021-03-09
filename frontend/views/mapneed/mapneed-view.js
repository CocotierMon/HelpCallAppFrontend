import { PolymerElement } from '@polymer/polymer/polymer-element';
import { html } from '@polymer/polymer/lib/utils/html-tag';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-date-time-picker/src/vaadin-date-time-picker.js';

class FindOnMapInNeedSideView extends PolymerElement {

  static get template() {
    return html`
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout class="header" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct); align-self: center; align-items: center; justify-content: center;">
  <h1 style="margin: var(--lumo-space-m); padding: var(--lumo-space-m); align-self: center;">Szukaj na mapie:</h1>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" style="width: 100%; align-self: center; align-items: center; justify-content: center;">
  <h3 style="align-self: center;">Znajdź na mapie wolontariuszy.</h3>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" style="align-self: center; align-items: stretch; width: 100%; flex-grow: 1; flex-direction: column; justify-content: space-around; margin: var(--lumo-space-m); padding: var(--lumo-space-m);">
  <vaadin-date-time-picker style="width: 100%; height: 100%; margin: var(--lumo-space-m); padding: var(--lumo-space-m); align-self: center;" date-placeholder="data od" time-placeholder="godzina od" label="Jeśli ustawisz datę i godzinę, zobaczysz dostępnych w wybranym czasie wolontariuszy"></vaadin-date-time-picker>
  <vaadin-date-time-picker style="width: 100%; height: 100%; margin: var(--lumo-space-m); padding: var(--lumo-space-m); align-self: center;" date-placeholder="data do" time-placeholder="godzina do"></vaadin-date-time-picker>
  <vaadin-vertical-layout theme="spacing" style="width: 100%; margin: var(--lumo-space-m); padding: var(--lumo-space-m); flex-grow: 0; align-self: center; flex-direction: column; align-items: center; justify-content: center;" id="vaadinVerticalLayout"></vaadin-vertical-layout>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout class="footer" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct); justify-content: center;"></vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
  }

  static get is() {
    return 'mapneed-view';
  }
}

customElements.define(FindOnMapInNeedSideView.is, FindOnMapInNeedSideView);
