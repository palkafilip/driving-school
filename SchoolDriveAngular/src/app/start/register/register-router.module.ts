import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {RegisterRootComponent} from "./components/register-root/register-root.component";
import {RegisterFormComponent} from "./components/register-form/register-form.component";

const applicationRoutes: Routes = [
  {path: "", component: RegisterRootComponent, children: [
    {path: "", component: RegisterFormComponent}
  ]}
]
@NgModule({
  imports: [
    RouterModule.forChild(applicationRoutes)
  ],
  exports: [RouterModule]
})
export class RegisterRouterModule { }
