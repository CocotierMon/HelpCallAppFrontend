import { PolymerElement } from '@polymer/polymer/polymer-element';
import { html } from '@polymer/polymer/lib/utils/html-tag';

class RegistrationView extends PolymerElement {
  _attachDom(dom) {
    // Do not use a shadow root
    this.appendChild(dom);
  }
  static get template() {
    return html` <div>Content placeholder</div> `;
  }

  static get is() {
    return 'registration-view';
  }
}

customElements.define(RegistrationView.is, RegistrationView);
