import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {CarCheckingComponent} from "./pages/car-checking/car-checking.component";

const applicationRoutes: Routes = [
  {path: "", redirectTo: "/start", pathMatch: "full"},
  {path: "start", loadChildren: "app/start/start.module#StartModule"},
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
