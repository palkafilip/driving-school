import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginRootComponent } from './components/login-root/login-root.component';
import { LoginFormComponent } from './components/login-form/login-form.component';
import {LoginRouterModule} from "./login-router.module";

@NgModule({
  imports: [
    CommonModule, LoginRouterModule
  ],
  declarations: [LoginRootComponent, LoginFormComponent]
})
export class LoginModule { }
