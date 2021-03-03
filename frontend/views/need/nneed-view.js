import { PolymerElement } from '@polymer/polymer/polymer-element';
import { html } from '@polymer/polymer/lib/utils/html-tag';

class NewNeedView extends PolymerElement {

  static get template() {
    return html`
`;
  }

  static get is() {
    return 'nneed-view';
  }
}

customElements.define(NewNeedView.is, NewNeedView);