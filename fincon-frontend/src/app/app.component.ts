import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'fincon-frontend';
  valueToDouble = 12;
  valueToDoubleResult = 0;
  valueToMultiplyA = 12;
  valueToMultiplyB = 18;
  valueToMultiplyResult = 0;

  double = (value: number) => 2 * value;

  multiply = (a: number, b: number) => a * b;

  doubleValue = (value: number) => {
    this.valueToDoubleResult = this.double(value);
  }

  multiplyValues = (a: number, b: number) => {
    this.valueToMultiplyResult = this.multiply(a, b);
  }
}
