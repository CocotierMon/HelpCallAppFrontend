import { PolymerElement } from '@polymer/polymer/polymer-element';
import { html } from '@polymer/polymer/lib/utils/html-tag';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class RegistrationView extends PolymerElement {

  static get template() {
    return html`
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout class="header" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 1; background-color: var(--lumo-contrast-10pct); align-self: center; align-items: center; justify-content: center; flex-grow: 1; flex-wrap: wrap; align-content: center;">
  <h1 style="align-self: center;">Buduj lokalną sieć wsparcia</h1>
 </vaadin-horizontal-layout>
 <vaadin-vertical-layout class="content" style="width: 70%; flex-grow: 1; flex-shrink: 1; flex-basis: auto; align-self: center; align-items: center; justify-content: center; flex-wrap: wrap;">
  <div style="align-self: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m);">
    Myśl globalnie - działaj lokalnie. Chcesz pomóc? W łatwy sposób znajdź osoby potrzebujące pomocy blisko Ciebie. Potrzebujesz pomocy? Szybko poinformuj społeczność o potrzebnym wsparciu. 
  </div>
 </vaadin-vertical-layout>
 <vaadin-horizontal-layout style="width: 100%; height: 100%; align-self: center; align-items: center; justify-content: space-around; margin: var(--lumo-space-m); padding: var(--lumo-space-m); flex-grow: 1; flex-wrap: wrap; align-content: center;">
  <vaadin-vertical-layout theme="spacing" style="flex-grow: 1;">
   <vaadin-button onclick="location.href='http://localhost:8081/registrationVolunteer';" theme="primary" style="flex-grow: 1; align-self: center;">
     Zarejestruj się jako wolontariusz 
   </vaadin-button>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout theme="spacing" style="flex-grow: 1;">
   <vaadin-button onclick="location.href='http://localhost:8081/registrationNeedHelp';" theme="primary" style="flex-grow: 1; align-self: center;">
     Zarejestruj się jako szukający pomocy 
   </vaadin-button>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout class="footer" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct);"></vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
  }

  static get is() {
    return 'registration-view';
  }
}

customElements.define(RegistrationView.is, RegistrationView);
