import { NgModule } from '@angular/core';
import { PagesRoutingModule } from './pages-router.module';
import {SharedModule} from "../shared/shared.module";
import {HomeComponent} from "./home/components/home.component";
import {HomeService} from "./home/services/home.service";

@NgModule({
  imports: [
    SharedModule,
    PagesRoutingModule
  ],
  declarations: [
    HomeComponent
  ],
  providers: [
    HomeService
  ]
})
export class PagesModule { }
