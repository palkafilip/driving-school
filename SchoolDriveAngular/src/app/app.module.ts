import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {AppRouterModule} from "./app-router.module";
import {SharedModule} from "./shared/shared.module";
import {MenuService} from "./service/menu.service";
import {LoggedUserService} from "./service/logged-user.service";
import {AuthenticatedGuardService} from "./service/authenticated-guard.service";
import {DateUtilsService} from "./utils/date-utils.service";

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRouterModule,
    SharedModule,
  ],
  providers: [
    MenuService,
    LoggedUserService,
    AuthenticatedGuardService,
    DateUtilsService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
