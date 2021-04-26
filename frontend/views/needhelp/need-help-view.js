import { PolymerElement } from '@polymer/polymer/polymer-element';
import { html } from '@polymer/polymer/lib/utils/html-tag';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class NeedHelpView extends PolymerElement {

  static get template() {
    return html`
<vaadin-horizontal-layout theme="spacing" style="width: 100%; height: 100%;">
 <vaadin-vertical-layout style="width: 100%; height: 100%;">
  <vaadin-horizontal-layout class="header" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct); align-self: center; justify-content: center; align-items: center;">
   <h1 style="align-self: center; flex-grow: 0;">Jak mogę zgłosić, że potrzebuję pomocy?</h1>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout style="width: 100%; flex-grow: 1; flex-shrink: 1; flex-basis: auto; align-self: center; justify-content: space-around; margin: var(--lumo-space-m); padding: var(--lumo-space-m); align-items: center;">
   <vaadin-vertical-layout theme="spacing" style="align-items: center; justify-content: center;">
    <h3 style="align-self: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m);">✅ Jeśli potrzebujesz pomocy, zarejestruj się jako potrzebujący pomocy.</h3>
    <h3 style="align-self: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m);">✅ Przejdź do dodawania nowej potrzeby i wpisz tytuł - krótką informację zawierającą kluczowe informacje o przedmiocie pomocy.</h3>
    <h3 style="align-self: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m);">✅ Opisz swoją potrzebę tak dokładnie, żeby wolontariusze mogli dobrze się z nią zapoznać.</h3>
   </vaadin-vertical-layout>
   <vaadin-vertical-layout theme="spacing" style="align-items: center; justify-content: center;">
    <h3 style="align-self: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m);">✅ Wykorzystaj pinezkę, aby określić na mapie miejsce realizacji potrzeby.</h3>
    <h3 style="align-self: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m);">✅ Określ w kalendarzu czas, do kiedy Twoje marzenie powinno zostać zrealizowane.</h3>
    <h3 style="align-self: center; margin: var(--lumo-space-m); padding: var(--lumo-space-m);">✅ Poinformuj o swoim marzeniu innych ludzi - np. za pomocą mediów społecznościowych - teraz pozwól wolontariuszom działać.</h3>
   </vaadin-vertical-layout>
  </vaadin-horizontal-layout>
 </vaadin-vertical-layout>
</vaadin-horizontal-layout>
`;
  }

  static get is() {
    return 'need-help-view';
  }
}

customElements.define(NeedHelpView.is, NeedHelpView);
