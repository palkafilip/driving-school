import { NgModule } from '@angular/core';
import { StartComponent } from './start/start.component';
import {StartRouterModule} from "./start-router.module";
import {SharedModule} from "../shared/shared.module";

@NgModule({
  imports: [
    StartRouterModule,
    SharedModule
  ],
  declarations: [StartComponent]
})
export class StartModule { }
