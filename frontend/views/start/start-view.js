import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-split-layout/src/vaadin-split-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
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
<vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout"></vaadin-horizontal-layout>
<vaadin-vertical-layout style="width: 100%; height: 50%;" id="vaadinVerticalLayout">
 <vaadin-split-layout theme="minimal" style="height: 50%; width: 100%; flex-shrink: 0; flex-grow: 1;" id="vaadinSplitLayout">
  <span style="height: 100%; width: 50%;" id="span"><p style="font-size:200%;">HelpCallApp - </p>
   <div id="div">
    <p style="font-size:150%"> aplikacja, która pomaga pomagać. </p>
   </div></span>
  <span slot="secondary" style="width: 50%; height: 100%;" id="span1"><img src="images/serce.png" , alt="Image of heart" style="width:50px; height:50px; width: 25px; height: 25px; margin: var(--lumo-space-m); padding: var(--lumo-space-m);" id="img"></span>
 </vaadin-split-layout>
</vaadin-vertical-layout>
<vaadin-horizontal-layout theme="spacing" style="width: 50%; height: 30%; justify-content: space-around; align-items: flex-start; flex-wrap: wrap; align-content: space-around; margin: var(--lumo-space-m); padding: var(--lumo-space-m);" id="vaadinHorizontalLayout1">
 <vaadin-button style="align-self: center; width: 100%; height: 100%; margin: var(--lumo-space-m); padding: var(--lumo-space-m);" id="vaadinButton">
   Zostań wolontariuszem! 
 </vaadin-button>
</vaadin-horizontal-layout>
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
