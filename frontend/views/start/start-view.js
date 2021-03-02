import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class StartView extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout class="header" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct); align-self: center; justify-content: center; align-items: center;">
  <h1 style="align-self: center; flex-grow: 0; margin: var(--lumo-space-m); padding: var(--lumo-space-m);">Witaj na stronie aplikacji HelpCallApp!</h1>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout style="width: 100%; flex-grow: 1; flex-shrink: 1; flex-basis: auto; align-self: center; justify-content: space-evenly; margin: var(--lumo-space-m); padding: var(--lumo-space-m); margin-bottom: var(--lumo-space-xs); padding-bottom: var(--lumo-space-xs);">
  <vaadin-vertical-layout theme="spacing" style="width: 50%;">
   <h1 style="align-self: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m); flex-grow: 0; margin-bottom: var(--lumo-space-xs); padding-bottom: var(--lumo-space-xs);">HelpCallApp - aplikacja, która pomaga pomagać.</h1>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout theme="spacing">
   <img src="images/serce.png" , alt="Image of heart" style="width:300px; height:300px;">
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout class="footer" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct); margin: var(--lumo-space-m); padding: var(--lumo-space-m); flex-direction: row; align-items: center; justify-content: space-around; height: 100%;">
  <vaadin-button theme="primary" style="width: 100%;">
   Zostań wolontariuszem!
  </vaadin-button>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'start-view';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(StartView.is, StartView);
