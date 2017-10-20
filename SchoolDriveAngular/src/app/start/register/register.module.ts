import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegisterRootComponent } from './components/register-root/register-root.component';
import { RegisterFormComponent } from './components/register-form/register-form.component';
import {RegisterRouterModule} from "./register-router.module";

@NgModule({
  imports: [
    CommonModule, RegisterRouterModule,
  ],
  declarations: [RegisterRootComponent, RegisterFormComponent]
})
export class RegisterModule { }
