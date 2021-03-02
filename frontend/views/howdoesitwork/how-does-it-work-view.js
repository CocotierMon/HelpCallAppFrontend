import { PolymerElement } from '@polymer/polymer/polymer-element';
import { html } from '@polymer/polymer/lib/utils/html-tag';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class HowDoesItWorkView extends PolymerElement {

  static get template() {
    return html`
<vaadin-vertical-layout style="width: 100%; height: 100%; align-content: stretch; align-items: center; justify-content: center;">
 <vaadin-horizontal-layout class="header" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct); align-self: center; justify-content: center; align-items: center; flex-wrap: wrap;">
  <h1 style="align-self: center; flex-grow: 0;">Jak to działa?</h1>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout style="justify-content: center; align-items: center; width: 100%; align-self: center; flex-shrink: 0; flex-wrap: wrap; align-content: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m);">
  <p style="align-self: center; font-size: 25px; flex-grow: 0;">Wykorzystaj mapę, aby w szybki i łatwy sposób znaleźć osoby potrzebujące wsparcia.</p>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout style="flex-grow: 1; flex-shrink: 1; flex-basis: auto; align-self: center; justify-content: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m); align-content: flex-start; flex-direction: row; align-items: center; flex-wrap: nowrap;">
  <vaadin-vertical-layout theme="spacing" style="align-self: center; align-items: center; justify-content: center; flex-wrap: wrap; align-content: center;">
   <h1 style="align-self: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m); flex-grow: 0; margin-bottom: var(--lumo-space-xs); padding-bottom: var(--lumo-space-xs);">1️⃣</h1>
   <h3 style="align-self: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m);">Zostań wolontariuszem</h3>
   <h5 style="width: 50%; align-self: center; margin: var(--lumo-space-m);">Zarejestruj się i zaloguj, aby w pełni korzystać z wszystkich dostępnych funkcjonalności.</h5>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout theme="spacing" style="align-self: center; align-items: center; justify-content: center; flex-wrap: wrap; align-content: center;">
   <h1 style="align-self: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m); margin-bottom: var(--lumo-space-xs); padding-bottom: var(--lumo-space-xs);">2️⃣</h1>
   <h3 style="align-self: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m);">Znajdź na mapie</h3>
   <h5 style="align-self: center; width: 50%; margin: var(--lumo-space-m);">Sprawdź, kto w Twojej okolicy może potrzebować wsparcia.</h5>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout theme="spacing" style="align-self: center; align-items: center; justify-content: center; flex-wrap: wrap; align-content: center;">
   <h1 style="align-self: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m); margin-bottom: var(--lumo-space-xs); padding-bottom: var(--lumo-space-xs);">3️⃣</h1>
   <h3 style="align-self: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m);">Zadeklaruj swoją pomoc</h3>
   <h5 style="width: 50%; align-self: center; margin: var(--lumo-space-m);">Dopisz się do realizacji czyjegoś marzenia i przejdź do czynów w realu!</h5>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout class="footer" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct); margin: var(--lumo-space-m); padding: var(--lumo-space-m); align-items: center; justify-content: center; flex-wrap: wrap; align-content: center;"></vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
  }

  static get is() {
    return 'how-does-it-work-view';
  }
}

customElements.define(HowDoesItWorkView.is, HowDoesItWorkView);
