import { PolymerElement } from '@polymer/polymer/polymer-element';
import { html } from '@polymer/polymer/lib/utils/html-tag';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class BenefitsView extends PolymerElement {

  static get template() {
    return html`
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout class="header" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct); align-self: center; justify-content: center; align-items: center;">
  <h1 style="align-self: center; flex-grow: 0;">Co zyskam korzystając z tej apki?</h1>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout style="width: 100%; flex-grow: 1; flex-shrink: 1; flex-basis: auto; align-self: center; justify-content: space-evenly; margin: var(--lumo-space-m); padding: var(--lumo-space-m);">
  <vaadin-vertical-layout theme="spacing">
   <h1 style="align-self: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m); flex-grow: 0; margin-bottom: var(--lumo-space-xs); padding-bottom: var(--lumo-space-xs);">🗺</h1>
   <h3 style="align-self: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m);">Wizualizacja</h3>
   <h5 style="width: 50%; align-self: center; margin: var(--lumo-space-m);">Widzisz, czy w Twojej okolicy ktoś potrzebuje pomocy - szukanie potrzebujących osób i wolontariuszy wchodzi na nowy poziom.</h5>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout theme="spacing">
   <h1 style="align-self: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m); margin-bottom: var(--lumo-space-xs); padding-bottom: var(--lumo-space-xs);">👥</h1>
   <h3 style="align-self: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m);">Wsparcie</h3>
   <h5 style="align-self: center; width: 50%; margin: var(--lumo-space-m);">Jeśli czujesz, ze samodzielnie nie dasz rady spełnić czyjejś prośby, możesz znaleźć innych wolontariuszy wokół siebie i nawiązać z nimi kontakt.</h5>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout theme="spacing">
   <h1 style="align-self: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m); margin-bottom: var(--lumo-space-xs); padding-bottom: var(--lumo-space-xs);">👍</h1>
   <h3 style="align-self: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m);">Satysfakcja</h3>
   <h5 style="width: 50%; align-self: center; margin: var(--lumo-space-m);">Czerpiesz radość z ulepszania świata wokół Ciebie, zyskujesz nowe doświadczenia, jesteś na bieżąco z ważnymi problemami ludzi w Twojej okolicy.</h5>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout class="footer" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct); margin: var(--lumo-space-m); padding: var(--lumo-space-m);"></vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
  }

  static get is() {
    return 'benefits-view';
  }
}

customElements.define(BenefitsView.is, BenefitsView);
