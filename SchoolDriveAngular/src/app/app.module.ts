import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpModule}    from '@angular/http';

import {AppComponent} from './app.component';
import {AppRouterModule} from "./app-router.module";
import {CarCheckingComponent} from "./pages/car-checking/car-checking.component";
import {RestService} from "./service/rest-service.service";

@NgModule({
  declarations: [
    AppComponent,
    CarCheckingComponent
  ],
  imports: [
    BrowserModule,
    AppRouterModule,
    HttpModule,
  ],
  providers: [
    RestService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
