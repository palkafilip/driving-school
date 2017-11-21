import { NgModule } from '@angular/core';
import { PagesRoutingModule } from './pages-router.module';
import {SharedModule} from "../shared/shared.module";

@NgModule({
  imports: [
    SharedModule,
    PagesRoutingModule
  ],
  declarations: []
})
export class PagesModule { }
