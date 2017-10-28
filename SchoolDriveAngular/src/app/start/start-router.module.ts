import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {StartComponent} from "./start/start.component";

const routes: Routes = [
  {path: "", component: StartComponent },
  {path: "login", loadChildren: "app/start/login/login.module#LoginModule"},
  {path: "register", loadChildren: "app/start/register/register.module#RegisterModule"},

]
@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class StartRouterModule { }
