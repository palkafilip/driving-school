import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {AppRouterModule} from "./app-router.module";
import {CarCheckingComponent} from "./pages/car-checking/car-checking.component";
import {SharedModule} from "./shared/shared.module";
import {MenuService} from "./service/menu-service.service";

@NgModule({
  declarations: [
    AppComponent,
    CarCheckingComponent
  ],
  imports: [
    BrowserModule,
    AppRouterModule,
    SharedModule,
  ],
  providers: [MenuService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
