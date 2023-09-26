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

  constructor(private http: HttpClient) {
  }

  double = (value: number) => this.http.get<number>(environment.apiURL + '/math/double/' + value);

  multiply = (a: number, b: number) => this.http.post<MultiplyResponse>(environment.apiURL + '/math/multiply', {
    a,
    b
  });
}
