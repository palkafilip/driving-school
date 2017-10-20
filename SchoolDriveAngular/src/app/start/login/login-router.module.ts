import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginRootComponent} from "./components/login-root/login-root.component";
import {LoginFormComponent} from "./components/login-form/login-form.component";


const applicationRoutes: Routes = [
  {path: "", component: LoginRootComponent, children: [
    {path: "", component: LoginFormComponent }
  ]}
]

@NgModule({
  imports: [ RouterModule.forChild(applicationRoutes) ],
  exports: [ RouterModule ]
})
export class LoginRouterModule { }
