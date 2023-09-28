import {Component, OnInit} from '@angular/core';
import {MathApiService, MultiplyResponse} from "./core/services/math-api.service";
import {environment} from "../environments/environment";
import {OperationHistoryService, PageableResponse} from "./core/services/operation-history-api.service";

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
  operationHistory: PageableResponse = {
    content: [],
    totalPages: 0,
    totalElements: 0,
    number: 0,
    size: 0
  };

  constructor(private mathService: MathApiService, private operationHistoryService: OperationHistoryService) {
    console.log('API: ' + environment.apiURL);
  }

  ngOnInit() {
    this.init();
  }

  randomInt = (min: number, max: number) => Math.floor(Math.random() * (max - min + 1) + min);

  init = () => {
    this.valueToDouble = this.randomInt(1, 100);
    this.valueToMultiplyA = this.randomInt(1, 100);
    this.valueToMultiplyB = this.randomInt(1, 100);

    this.refreshOperationHistory();
  }

  refreshOperationHistory = () => {
    this.operationHistoryService.findAll().subscribe((data: PageableResponse) => {
      this.operationHistory = data;
    })
  }

  double = (value: number) => 2 * value;

  multiply = (a: number, b: number) => a * b;

  doubleValue = (value: number) => {
    this.valueToDoubleResult = this.double(value);
    this.mathService.double(value).subscribe(data => {
      this.valueToDoubleResultFromApi = data;
      this.refreshOperationHistory();
    });
  }

  multiplyValues = (a: number, b: number) => {
    this.valueToMultiplyResult = this.multiply(a, b);
    this.mathService.multiply(a, b).subscribe((data: MultiplyResponse) => {
      this.valueToMultiplyResultFromApi = data.result;
      this.refreshOperationHistory();
    })
  }

  runCommand = (operation: string, params: string) => {
    switch (operation) {
      case MathApiService.OPERATION_DOUBLE:
        this.valueToDouble = Number(params);
        this.doubleValue(this.valueToDouble);
        break;
      case MathApiService.OPERATION_MULTIPLY:
        let values = params.split(',');
        this.valueToMultiplyA = Number(values[0]);
        this.valueToMultiplyB = Number(values[1]);
        this.multiplyValues(this.valueToMultiplyA, this.valueToMultiplyB);
        break;
    }
  }
}
