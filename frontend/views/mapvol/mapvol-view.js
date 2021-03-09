import { PolymerElement } from '@polymer/polymer/polymer-element';
import { html } from '@polymer/polymer/lib/utils/html-tag';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-date-picker/src/vaadin-date-picker.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

class FindOnMapVolunteerSideView extends PolymerElement {

  static get template() {
    return html`
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout class="header" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct); align-self: center; align-items: center; justify-content: center; flex-direction: column;">
  <h1 style="margin: var(--lumo-space-m); padding: var(--lumo-space-m); align-self: center;">Szukaj na mapie:</h1>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" style="width: 100%; align-self: center; align-items: center; justify-content: center; flex-direction: column;">
  <h3 style="align-self: center;">Znajdź na mapie potrzebę, którą możesz pomóc zrealizować.</h3>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" style="width: 100%; height: 100%; margin: var(--lumo-space-m); padding: var(--lumo-space-m); align-self: center; flex-direction: column; align-items: center; justify-content: center;">
  <vaadin-date-picker label="Możesz wybrać datę końca realizacji potrzeb" placeholder="Pick a date" style="align-self: center; width: 50%; margin: var(--lumo-space-m); padding: var(--lumo-space-m);" required show-week-numbers invalid></vaadin-date-picker>
  <vaadin-vertical-layout theme="spacing" style="width: 100%; align-self: stretch; flex-grow: 1; justify-content: center; align-items: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m); flex-direction: column;" id="vaadinVerticalLayout"></vaadin-vertical-layout>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout class="footer" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct); justify-content: center;"></vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
  }

  static get is() {
    return 'mapvol-view';
  }
}

customElements.define(FindOnMapVolunteerSideView.is, FindOnMapVolunteerSideView);
