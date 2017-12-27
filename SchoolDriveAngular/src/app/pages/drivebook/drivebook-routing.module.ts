import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {IncomingComponent} from "./components/incoming/incoming.component";
import {HistoricalComponent} from "./components/historical/historical.component";
import {DrivebookDetailsComponent} from "./components/drivebook-details/drivebook-details.component";
import {EditDrivebookComponent} from "./components/edit-drivebook/edit-drivebook.component";
import {BookComponent} from "./components/book/book.component";

const routes: Routes = [
  { path: "", redirectTo: "/pages/drivebooks/incoming", pathMatch: "full"},
  { path: "new-book", component: BookComponent },
  { path: "incoming", component: IncomingComponent },
  { path: "historical", component: HistoricalComponent },
  { path: "historical/:id", component: DrivebookDetailsComponent },
  { path: "incoming/:id", component: DrivebookDetailsComponent },
  { path: "incoming/:id/edit", component: EditDrivebookComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DrivebookRoutingModule { }
