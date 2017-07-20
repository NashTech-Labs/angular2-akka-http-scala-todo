import { Component } from '@angular/core';

@Component({
  selector: 'my-app',
  template: `<h1>Hello {{name}}</h1><button (click)="showName()">Click me</button>`,
})
export class AppComponent  {
  name = 'Angular';

  showName() {
    alert("Hey, you clicked me")
  }
}
