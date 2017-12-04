import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DrivebookRoutingModule } from './drivebook-routing.module';
import { BookingComponent } from './components/booking/booking.component';

@NgModule({
  imports: [
    CommonModule,
    DrivebookRoutingModule
  ],
  declarations: [BookingComponent]
})
export class DrivebookModule { }
