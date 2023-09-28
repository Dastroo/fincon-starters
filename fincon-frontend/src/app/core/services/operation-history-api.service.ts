import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";

export interface Item {
  id: number,
  createDate: Date,
  operation: string,
  params: string
}

export interface PageableResponse {
  content: Item[],
  totalPages: number,
  totalElements: number,
  number: number,
  size: number
}

@Injectable()
export class OperationHistoryService {

  constructor(private http: HttpClient) {
  }

  findAll = () => this.http.get<PageableResponse>(environment.apiURL + '/history?sort=createDate,desc');
}
