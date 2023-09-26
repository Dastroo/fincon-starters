import {Component, OnInit} from '@angular/core';
import {MathApiService, MultiplyResponse} from "./core/services/math-api.service";
import {environment} from "../environments/environment";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'fincon-frontend';
  valueToDouble!: number;
  valueToDoubleResult!: number;
  valueToDoubleResultFromApi!: number;
  valueToMultiplyA!: number;
  valueToMultiplyB!: number;
  valueToMultiplyResult!: number;
  valueToMultiplyResultFromApi!: number;

  constructor(private mathService: MathApiService) {
    console.log('API: ' + environment.apiURL);
  }

  ngOnInit() {
    this.valueToDouble = this.randomInt(1, 100);
    this.valueToMultiplyA = this.randomInt(1, 100);
    this.valueToMultiplyB = this.randomInt(1, 100);
  }

  randomInt = (min: number, max: number) => Math.floor(Math.random() * (max - min + 1) + min);

  double = (value: number) => 2 * value;

  multiply = (a: number, b: number) => a * b;

  doubleValue = (value: number) => {
    this.valueToDoubleResult = this.double(value);
    this.mathService.double(value).subscribe(data => {
      this.valueToDoubleResultFromApi = data
    });
  }

  multiplyValues = (a: number, b: number) => {
    this.valueToMultiplyResult = this.multiply(a, b);
    this.mathService.multiply(a, b).subscribe((data: MultiplyResponse) => {
      this.valueToMultiplyResultFromApi = data.result
    })
  }
}
