import { PolymerElement } from '@polymer/polymer/polymer-element';
import { html } from '@polymer/polymer/lib/utils/html-tag';

class FindOnMapVolunteerSideView extends PolymerElement {

  static get template() {
    return html`
`;
  }

  static get is() {
    return 'mapvol-view';
  }
}

customElements.define(FindOnMapVolunteerSideView.is, FindOnMapVolunteerSideView);
