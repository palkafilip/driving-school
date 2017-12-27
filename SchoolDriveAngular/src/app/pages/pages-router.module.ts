import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [

  // { path: "", component: HomeComponent, children: [
  //   { path: "", redirectTo: "drivebooks", pathMatch: "full" },
  //   { path: "drivebooks", loadChildren: "app/pages/drivebook/drivebook.module#DrivebookModule" },
  // ]},
  {path: "", redirectTo: "drivebooks", pathMatch: "full"},
  { path: "drivebooks", loadChildren: "app/pages/drivebook/drivebook.module#DrivebookModule" },
  { path: "instructors", loadChildren: "app/pages/instructor/instructor.module#InstructorModule" },
  { path: "settings", loadChildren: "app/pages/user/user.module#UserModule" },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PagesRoutingModule { }
