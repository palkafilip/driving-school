import { NgModule } from '@angular/core';
import { RegisterRootComponent } from './components/register-root/register-root.component';
import { RegisterFormComponent } from './components/register-form/register-form.component';
import { RegisterRouterModule } from "./register-router.module";
import {SharedModule} from "../../shared/shared.module";
import {RegisterService} from "./service/service.service";


@NgModule({
  imports: [
    RegisterRouterModule,
    SharedModule,
  ],
  declarations: [
    RegisterRootComponent,
    RegisterFormComponent
  ],
  providers: [
    RegisterService,
  ]
})
export class RegisterModule { }
