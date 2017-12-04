import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { InstructorRoutingModule } from './instructor-routing.module';
import { SearchInstructorComponent } from './components/search-instructor/search-instructor.component';
import {SearchInstructorService} from "./service/search-instructor.service";
import {SharedModule} from "../../shared/shared.module";
import { InstructorDetailsComponent } from './components/instructor-details/instructor-details.component';

@NgModule({
  imports: [
    SharedModule,
    InstructorRoutingModule
  ],
  declarations: [
    SearchInstructorComponent,
    InstructorDetailsComponent
  ],
  providers: [SearchInstructorService]
})
export class InstructorModule { }
