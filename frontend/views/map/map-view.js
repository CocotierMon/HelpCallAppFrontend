import { PolymerElement } from '@polymer/polymer/polymer-element';
import { html } from '@polymer/polymer/lib/utils/html-tag';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

class MapView extends PolymerElement {

  static get template() {
    return html`
<vaadin-vertical-layout id="vaadinVerticalLayout" style="justify-content: space-evenly; align-items: baseline; flex-wrap: wrap; align-content: space-between; flex-direction: column;">
 <vaadin-horizontal-layout class="header" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct); align-self: center; align-items: center; justify-content: center; height: 80%;" id="vaadinHorizontalLayout">
  <h1 id="h1" style="align-self: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m);">Sprawdź na mapie</h1>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
<vaadin-vertical-layout theme="spacing" id="vaadinVerticalLayout1" style="width: 100%; height: 100%; margin: var(--lumo-space-m); padding: var(--lumo-space-m); justify-content: center; align-items: center; flex-direction: row;"></vaadin-vertical-layout>
`;
  }

  static get is() {
    return 'map-view';
  }
}

customElements.define(MapView.is, MapView);
