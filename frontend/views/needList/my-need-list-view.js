import { PolymerElement } from '@polymer/polymer/polymer-element';
import { html } from '@polymer/polymer/lib/utils/html-tag';

class MyNeedListView extends PolymerElement {

  static get template() {
    return html`
`;
  }

  static get is() {
    return 'my-need-list-view';
  }
}

customElements.define(MyNeedListView.is, MyNeedListView);
