import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {MathApiService} from "./core/services/math-api.service";
import {OperationHistoryService} from "./core/services/operation-history-api.service";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
  ],
  providers: [MathApiService, OperationHistoryService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
