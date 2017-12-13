import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {AuthenticatedGuardService} from "./service/authenticated-guard.service";

const applicationRoutes: Routes = [
  {path: "", redirectTo: "/start", pathMatch: "full"},
  {path: "start", loadChildren: "app/start/start.module#StartModule", canLoad: [AuthenticatedGuardService]},
  {path: "pages", loadChildren: "app/pages/pages.module#PagesModule", canLoad: [AuthenticatedGuardService],}
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
