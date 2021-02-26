import { PolymerElement } from '@polymer/polymer/polymer-element';
import { html } from '@polymer/polymer/lib/utils/html-tag';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class HowDoesItWorkView extends PolymerElement {

  static get template() {
    return html`
<vaadin-horizontal-layout theme="spacing" style="width: 100%; height: 100%; align-items: flex-start; justify-content: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m);">
 <p style="width: 30%; height: 100%; margin: var(--lumo-space-m); padding: var(--lumo-space-m); align-self: flex-start; font-size: 40px;">Jak to działa?</p>
</vaadin-horizontal-layout>
<vaadin-horizontal-layout theme="spacing" style="width: 100%; height: 100%; justify-content: center; align-items: flex-start;">
 <p style="align-self: flex-start; width: 70%; margin: var(--lumo-space-m); padding: var(--lumo-space-m); font-size: 25px;">Wykorzystaj mapę, aby w szybki i łatwy sposób znaleźć osoby potrzebujące wsparcia.</p>
</vaadin-horizontal-layout>
<vaadin-horizontal-layout theme="spacing" style="width: 100%; height: 100%; margin: var(--lumo-space-m); padding: var(--lumo-space-m); justify-content: center; align-items: flex-start;">
 <table style="width: 100%; height: 100%; margin: var(--lumo-space-m); padding: var(--lumo-space-m); align-self: center; flex-shrink: 1; flex-grow: 1;">
  <tbody style="width: 100%; height: 100%; margin: var(--lumo-space-m); padding: var(--lumo-space-m);">
   <tr style="margin: var(--lumo-space-m); padding: var(--lumo-space-m);">
    <th style="margin: var(--lumo-space-m); padding: var(--lumo-space-m);">01</th>
    <th style="margin: var(--lumo-space-m); padding: var(--lumo-space-m);">02</th>
    <th style="margin: var(--lumo-space-m); padding: var(--lumo-space-m);">03</th>
   </tr>
   <tr style="margin: var(--lumo-space-m); padding: var(--lumo-space-m);">
    <td style="margin: var(--lumo-space-m); padding: var(--lumo-space-m);">Zostań wolontariuszem</td>
    <td style="margin: var(--lumo-space-m); padding: var(--lumo-space-m);">Znajdź na mapie</td>
    <td style="margin: var(--lumo-space-m); padding: var(--lumo-space-m);">Zadeklaruj swoją pomoc</td>
   </tr>
   <tr style="margin: var(--lumo-space-m); padding: var(--lumo-space-m);">
    <td style="margin: var(--lumo-space-m); padding: var(--lumo-space-m);">Zarejestruj się i zaloguj, aby w pełni korzystać z wszystkich dostępnych funkcjonalności.</td>
    <td style="margin: var(--lumo-space-m); padding: var(--lumo-space-m);">Sprawdź, kto w Twojej okolicy może potrzebować wsparcia.</td>
    <td style="margin: var(--lumo-space-m); padding: var(--lumo-space-m);">Dopisz się do realizacji czyjegoś marzenia i przejdź do czynów w realu!</td>
   </tr>
  </tbody>
 </table>
</vaadin-horizontal-layout>
`;
  }

  static get is() {
    return 'how-does-it-work-view';
  }
}

customElements.define(HowDoesItWorkView.is, HowDoesItWorkView);
