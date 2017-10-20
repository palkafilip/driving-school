import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {CarCheckingComponent} from "./pages/car-checking/car-checking.component";

const applicationRoutes: Routes = [
  {path: "", redirectTo: "/login", pathMatch: "full"},
  {path: "login", loadChildren: "app/start/login/login.module#LoginModule"},
  {path: "register", loadChildren: "app/start/register/register.module#RegisterModule"},
  {path: "car", component: CarCheckingComponent}

]

@NgModule({
  imports: [
    RouterModule.forRoot(applicationRoutes),
  ],
  exports: [
    RouterModule
  ]
})
export class AppRouterModule { }
