import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";

export interface MultiplyResponse {
  a: number,
  b: number,
  result: number
}

@Injectable()
export class MathApiService {

  static OPERATION_DOUBLE = '/math/double';
  static OPERATION_MULTIPLY = '/math/multiply';

  constructor(private http: HttpClient) {
  }

  double = (value: number) => this.http.get<number>(environment.apiURL + MathApiService.OPERATION_DOUBLE + '/' + value);

  multiply = (a: number, b: number) => this.http.post<MultiplyResponse>(environment.apiURL + MathApiService.OPERATION_MULTIPLY, {
    a,
    b
  });
}
