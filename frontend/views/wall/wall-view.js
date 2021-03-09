import { PolymerElement } from '@polymer/polymer/polymer-element';
import { html } from '@polymer/polymer/lib/utils/html-tag';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-date-time-picker/src/vaadin-date-time-picker.js';

class WallOfGloryView extends PolymerElement {

  static get template() {
    return html`
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout class="header" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct); align-self: center; align-items: center; justify-content: center;">
  <h1 style="margin: var(--lumo-space-m); padding: var(--lumo-space-m); align-self: center;">Moja ściana chwały - tak pomagam</h1>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout id="vaadinHorizontalLayout" style="align-self: stretch; margin: var(--lumo-space-m); padding: var(--lumo-space-m); width: 100%; flex-grow: 1; flex-direction: column; justify-content: center; align-items: stretch;">
  <vaadin-date-time-picker style="margin: var(--lumo-space-m); align-self: center;"></vaadin-date-time-picker>
  <h5 style="margin: var(--lumo-space-m); padding: var(--lumo-space-m); align-self: stretch;">Zaznacz w kalendarzu dni i godziny, w których możesz pomagać innym. Wtedy osoby potrzebujące pomocy będą wiedzieć, w jakich terminach mogą prosić Cię o wsparcie.</h5>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout class="footer" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct);"></vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
  }

  static get is() {
    return 'wall-view';
  }
}

customElements.define(WallOfGloryView.is, WallOfGloryView);
