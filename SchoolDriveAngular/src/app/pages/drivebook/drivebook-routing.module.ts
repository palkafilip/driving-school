import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {BookingComponent} from "./components/booking/booking.component";

const routes: Routes = [
  // { path: "", redirectTo: "/pages/drivebooks", pathMatch: "full"},
  { path: "", component: BookingComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DrivebookRoutingModule { }
