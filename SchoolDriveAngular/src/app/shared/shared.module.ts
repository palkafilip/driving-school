import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RestService } from "../service/rest-service.service";
import { FormsModule } from "@angular/forms";
import { HttpModule }    from '@angular/http';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    HttpModule,
  ],
  declarations: [],
  providers: [
    RestService,
  ],
  exports: [
    FormsModule,
    CommonModule,
    HttpModule,
  ]
})
export class SharedModule { }
