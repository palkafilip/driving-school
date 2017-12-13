import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {BookingComponent} from "./components/booking/booking.component";
import {IncomingComponent} from "./components/incoming/incoming.component";
import {HistoricalComponent} from "./components/historical/historical.component";

const routes: Routes = [
  { path: "", redirectTo: "/pages/drivebooks/incoming", pathMatch: "full"},
  { path: "bookings", component: BookingComponent },
  { path: "incoming", component: IncomingComponent },
  { path: "historical", component: HistoricalComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DrivebookRoutingModule { }
