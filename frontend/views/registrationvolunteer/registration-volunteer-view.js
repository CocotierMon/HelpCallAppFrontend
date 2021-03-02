import { PolymerElement } from '@polymer/polymer/polymer-element';
import { html } from '@polymer/polymer/lib/utils/html-tag';

class RegistrationVolunteerView extends PolymerElement {

  static get template() {
    return html`
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout class="header" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct); align-self: center; justify-content: center;">
  <h1>Rejestracja wolontariusza</h1>
 </vaadin-horizontal-layout>
 <vaadin-vertical-layout class="content" style="width: 100%; flex-grow: 1; flex-shrink: 1; flex-basis: auto; align-self: center; align-items: center; justify-content: flex-start; flex-direction: row;">
  <vaadin-horizontal-layout theme="spacing" style="flex-direction: column; margin: var(--lumo-space-m); padding: var(--lumo-space-m); align-self: center; justify-content: center; align-items: center; flex-wrap: wrap; align-content: center; width: 100%;">
   <vaadin-text-field placeholder="Nazwa użytkownika" style="align-self: center; width: 100%;" minlength="5" required maxlength="25" label="Wpisz swój nick"></vaadin-text-field>
   <vaadin-text-field placeholder="E-mail" minlength="5" required maxlength="25" style="align-self: center; width: 100%;" label="Wpisz adres e-mail do kontaktu"></vaadin-text-field>
   <vaadin-text-field placeholder="Hasło" minlength="5" required maxlength="25" style="align-self: center; width: 100%;" label="Wprowadź hasło"></vaadin-text-field>
   <vaadin-text-field placeholder="Powtórz hasło" minlength="5" required maxlength="25" style="align-self: center; width: 100%;" label="Powtórz hasło"></vaadin-text-field>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout" style="margin: var(--lumo-space-m); padding: var(--lumo-space-m); align-self: center; align-items: center; justify-content: center; flex-grow: 1;"></vaadin-horizontal-layout>
  <vaadin-horizontal-layout theme="spacing" style="margin: var(--lumo-space-m); padding: var(--lumo-space-m); align-self: center; align-items: center; justify-content: center; flex-direction: column;">
   <div style="margin: var(--lumo-space-m); padding: var(--lumo-space-m); align-self: center;">
    Oznacz swoje położenie na mapie. Złap pinezkę i opuść w wybrane miejsce na mapie. Nie musisz oznaczać swojego miejsca zamieszkania. Możesz zaznaczyć miejsce, wokół którego będziesz realizować prośby innych osób.
   </div>
  </vaadin-horizontal-layout>
 </vaadin-vertical-layout>
</vaadin-vertical-layout>
<vaadin-horizontal-layout theme="spacing" style="width: 100%; height: 100%; margin: var(--lumo-space-m); flex-direction: row; align-items: center; justify-content: center; align-content: flex-end; padding: var(--lumo-space-m); margin-top: var(--lumo-space-xs); padding-top: var(--lumo-space-xs); margin-bottom: var(--lumo-space-xs); padding-bottom: var(--lumo-space-xs);">
 <vaadin-text-area label="Opisz się w kilku słowach" placeholder="Przykładowy opis:
Jestem wolontariuszem, który specjalizuje się w pomocy wytchnieniowej dla rodzin osób niepełnosprawnych. Mogę zająć się Twoją bliską osobą, kiedy Ty musisz zrobić zakupy. Umiem i lubię też grać na gitarze, więc z chęcią nauczę kogoś podstaw gry. Jeśli potrzebujesz czasem z kimś wyjść na spacer - również chętnie Ci potowarzyszę." style="width: 100%; height: 100%; margin: var(--lumo-space-m); align-self: center;" minlength="300" maxlength="30" required></vaadin-text-area>
</vaadin-horizontal-layout>
<vaadin-horizontal-layout theme="spacing" style="margin: var(--lumo-space-m); padding: var(--lumo-space-m); align-items: flex-start; justify-content: center; flex-wrap: wrap; align-content: center; margin-top: var(--lumo-space-xs); padding-top: var(--lumo-space-xs);">
 <vaadin-button theme="primary success" style="margin: var(--lumo-space-m); width: 100%; height: 100%; flex-grow: 1; align-self: center;" disabled>
  Zakładam konto jako wolontariusz
 </vaadin-button>
</vaadin-horizontal-layout>
`;
  }

  static get is() {
    return 'registration-volunteer-view';
  }
}

customElements.define(RegistrationVolunteerView.is, RegistrationVolunteerView);
