import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DrivebookRoutingModule } from './drivebook-routing.module';
import { BookingComponent } from './components/booking/booking.component';
import { IncomingComponent } from './components/incoming/incoming.component';
import {DrivebookService} from "./service/drivebook.service";
import { HistoricalComponent } from './components/historical/historical.component';
import { DrivebookComponent } from './components/drivebook/drivebook.component';

@NgModule({
  imports: [
    CommonModule,
    DrivebookRoutingModule
  ],
  declarations: [
    BookingComponent,
    IncomingComponent,
    HistoricalComponent,
    DrivebookComponent
  ],
  providers: [
    DrivebookService
  ]
})
export class DrivebookModule { }
