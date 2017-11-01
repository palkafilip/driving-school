import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginRootComponent } from './components/login-root/login-root.component';
import { LoginFormComponent } from './components/login-form/login-form.component';
import {LoginRouterModule} from "./login-router.module";
import {SharedModule} from "../../shared/shared.module";
import {LoginService} from "./service/login.service";

@NgModule({
  imports: [
    CommonModule,
    LoginRouterModule,
    SharedModule
  ],
  declarations: [
    LoginRootComponent,
    LoginFormComponent
  ],
  providers: [
    LoginService
  ]
})
export class LoginModule { }
