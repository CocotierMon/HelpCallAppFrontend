import { PolymerElement } from '@polymer/polymer/polymer-element';
import { html } from '@polymer/polymer/lib/utils/html-tag';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class StatisticsView extends PolymerElement {

  static get template() {
    return html`
<vaadin-horizontal-layout class="footer" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct); margin: var(--lumo-space-m); padding: var(--lumo-space-m);">
 <vaadin-vertical-layout style="width: 100%; height: 100%;">
  <vaadin-horizontal-layout class="header" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct); align-self: center; justify-content: center; align-items: center;">
   <h1 style="align-self: center; flex-grow: 0;">Statystyki:</h1>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout style="width: 100%; flex-grow: 1; flex-shrink: 1; flex-basis: auto; align-self: center; justify-content: space-around; margin: var(--lumo-space-m); padding: var(--lumo-space-m); align-items: center;">
   <vaadin-vertical-layout theme="spacing" style="align-items: center; justify-content: center;">
    <h1 style="align-self: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m); flex-grow: 0; margin-bottom: var(--lumo-space-xs); padding-bottom: var(--lumo-space-xs);">50</h1>
    <h3 style="align-self: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m);">LICZBA ZAREJESTROWANYCH WOLONTARIUSZY</h3>
   </vaadin-vertical-layout>
   <vaadin-vertical-layout theme="spacing" style="align-items: center; justify-content: center;">
    <h1 style="align-self: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m); flex-grow: 0; margin-bottom: var(--lumo-space-xs); padding-bottom: var(--lumo-space-xs);">70</h1>
    <h3 style="align-self: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m); width: 100%;">TYLE ZGŁOSZONO POTRZEB</h3>
   </vaadin-vertical-layout>
   <vaadin-vertical-layout theme="spacing" style="align-self: center; align-items: center; justify-content: center;">
    <h1 style="align-self: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m); margin-bottom: var(--lumo-space-xs); padding-bottom: var(--lumo-space-xs);">30</h1>
    <h3 style="align-self: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m); flex-grow: 0;">TYLE POTRZEB ZREALIZOWALI WOLONTARIUSZE</h3>
   </vaadin-vertical-layout>
   <vaadin-vertical-layout theme="spacing" style="align-items: center; justify-content: center;">
    <h1 style="align-self: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m); margin-bottom: var(--lumo-space-xs); padding-bottom: var(--lumo-space-xs);">40</h1>
    <h3 style="align-self: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m);">TYLE POTRZEB POZOSTAŁO DO ZREALIZOWANIA</h3>
   </vaadin-vertical-layout>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout class="footer" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct); margin: var(--lumo-space-m); padding: var(--lumo-space-m);"></vaadin-horizontal-layout>
 </vaadin-vertical-layout>
</vaadin-horizontal-layout>
`;
  }

  static get is() {
    return 'statistics-view';
  }
}

customElements.define(StatisticsView.is, StatisticsView);
