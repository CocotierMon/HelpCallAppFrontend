import { PolymerElement } from '@polymer/polymer/polymer-element';
import { html } from '@polymer/polymer/lib/utils/html-tag';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-date-picker/src/vaadin-date-picker.js';

class MyNeedListView extends PolymerElement {

  static get template() {
    return html`
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout class="header" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct); align-self: center; align-items: center; justify-content: center;">
  <h1 style="margin: var(--lumo-space-m); padding: var(--lumo-space-m); align-self: center;">Moja lista marzeń i potrzeb do spełnienia</h1>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout" style="align-self: stretch; margin: var(--lumo-space-m); padding: var(--lumo-space-m); width: 100%; flex-grow: 1; flex-direction: column;">
  <vaadin-date-picker label="Kalendarz potrzeb" placeholder="Wybierz datę końca realizacji" style="margin: var(--lumo-space-m); padding: var(--lumo-space-m);"></vaadin-date-picker>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout class="footer" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct);"></vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
  }

  static get is() {
    return 'my-need-list-view';
  }
}

customElements.define(MyNeedListView.is, MyNeedListView);
