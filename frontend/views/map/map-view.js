import { PolymerElement } from '@polymer/polymer/polymer-element';
import { html } from '@polymer/polymer/lib/utils/html-tag';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-split-layout/src/vaadin-split-layout.js';

class MapView extends PolymerElement {

  static get template() {
    return html`
<vaadin-vertical-layout id="vaadinVerticalLayout" style="justify-content: space-evenly; align-items: baseline; flex-wrap: wrap; align-content: space-between; flex-direction: column;">
 <vaadin-horizontal-layout class="header" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct); align-self: center; align-items: center; justify-content: center; height: 80%;" id="vaadinHorizontalLayout">
  <h1 id="h1" style="align-self: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m);">Sprawdź na mapie</h1>
 </vaadin-horizontal-layout>
 <vaadin-button id="vaadinButton" style="flex-grow: 0; align-self: stretch;">
  Szukaj wolontariuszy
 </vaadin-button>
 <vaadin-button id="vaadinButton1" style="align-self: stretch;">
  Szukaj potrzeb do spełnienia
 </vaadin-button>
</vaadin-vertical-layout>
<vaadin-split-layout id="vaadinSplitLayout" style="width: 100%; height: 100%;"></vaadin-split-layout>
`;
  }

  static get is() {
    return 'map-view';
  }
}

customElements.define(MapView.is, MapView);
