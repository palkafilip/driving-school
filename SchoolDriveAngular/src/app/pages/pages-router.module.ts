import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: "", redirectTo: "/pages/home", pathMatch: "full"},
  { path: "home", loadChildren: "app/pages/home/home.module#HomeModule" },
  { path: "drivebooks", loadChildren: "app/pages/drivebook/drivebook.module#DrivebookModule" },
  { path: "instructors", loadChildren: "app/pages/instructor/instructor.module#InstructorModule" },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PagesRoutingModule { }
