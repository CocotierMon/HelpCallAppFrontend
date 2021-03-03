import { PolymerElement } from '@polymer/polymer/polymer-element';
import { html } from '@polymer/polymer/lib/utils/html-tag';

class FindOnMapInNeedSideView extends PolymerElement {

  static get template() {
    return html`
`;
  }

  static get is() {
    return 'mapneed-view';
  }
}

customElements.define(FindOnMapInNeedSideView.is, FindOnMapInNeedSideView);
