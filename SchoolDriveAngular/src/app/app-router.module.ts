import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {CarCheckingComponent} from "./pages/car-checking/car-checking.component";
import {AuthenticatedGuardService} from "./service/authenticated-guard.service";

const applicationRoutes: Routes = [
  {path: "", redirectTo: "/start", pathMatch: "full"},
  {path: "start", loadChildren: "app/start/start.module#StartModule", canLoad: [AuthenticatedGuardService]},
  {path: "car", component: CarCheckingComponent},
  {path: "pages", loadChildren: "app/pages/pages.module#PagesModule", canLoad: [AuthenticatedGuardService]}
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
