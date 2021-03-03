import { PolymerElement } from '@polymer/polymer/polymer-element';
import { html } from '@polymer/polymer/lib/utils/html-tag';

class WallOfGloryView extends PolymerElement {

  static get template() {
    return html`
`;
  }

  static get is() {
    return 'wall-view';
  }
}

customElements.define(WallOfGloryView.is, WallOfGloryView);
