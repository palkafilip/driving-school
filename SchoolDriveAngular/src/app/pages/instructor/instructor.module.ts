import { NgModule } from '@angular/core';
import { InstructorRoutingModule } from './instructor-routing.module';
import { SearchInstructorComponent } from './components/search-instructor/search-instructor.component';
import {InstructorService} from "./service/instructor.service";
import {SharedModule} from "../../shared/shared.module";
import { InstructorDetailsComponent } from './components/instructor-details/instructor-details.component';
import { RateInstructorComponent } from './components/rate-instructor/rate-instructor.component';

@NgModule({
  imports: [
    SharedModule,
    InstructorRoutingModule
  ],
  declarations: [
    SearchInstructorComponent,
    InstructorDetailsComponent,
    RateInstructorComponent
  ],
  providers: [
    InstructorService,
  ]
})
export class InstructorModule { }
