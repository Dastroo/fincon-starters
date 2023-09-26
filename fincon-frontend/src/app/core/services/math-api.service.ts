import {Injectable} from "@angular/core";
import {Constans} from "../../config/constans";
import {HttpClient} from "@angular/common/http";

export interface MultiplyResponse {
  a: number,
  b: number,
  result: number
}

@Injectable()
export class MathApiService {

  constructor(private http: HttpClient) {
  }

  double = (value: number) => this.http.get<number>(Constans.API_ENDPOINT + '/math/double/' + value);

  multiply = (a: number, b: number) => this.http.post<MultiplyResponse>(Constans.API_ENDPOINT + '/math/multiply', {
    a,
    b
  });
}
