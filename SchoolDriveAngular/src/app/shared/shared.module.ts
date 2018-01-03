import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RestService } from "../service/rest.service";
import { FormsModule } from "@angular/forms";
import { HttpModule }    from '@angular/http';
import {StarRatingComponent} from "../utils/star-rating/star-rating.component";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    HttpModule,
  ],
  declarations: [
    StarRatingComponent
  ],
  providers: [
    RestService,
  ],
  exports: [
    FormsModule,
    CommonModule,
    HttpModule,
    StarRatingComponent,
  ]
})
export class SharedModule { }
