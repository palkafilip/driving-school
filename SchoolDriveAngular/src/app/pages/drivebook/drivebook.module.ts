import { NgModule } from '@angular/core';

import { DrivebookRoutingModule } from './drivebook-routing.module';
import { IncomingComponent } from './components/incoming/incoming.component';
import {DrivebookService} from "./service/drivebook.service";
import { HistoricalComponent } from './components/historical/historical.component';
import { DrivebookComponent } from './components/drivebook/drivebook.component';
import { DrivebookDetailsComponent } from './components/drivebook-details/drivebook-details.component';
import { BannerComponent } from './components/banner/banner.component';
import { EditDrivebookComponent } from './components/edit-drivebook/edit-drivebook.component';
import {BookComponent} from "./components/book/book.component";
import {SharedModule} from "../../shared/shared.module";
import {BookService} from "./service/book.service";

import { ModalModule } from 'ngx-bootstrap/modal';

@NgModule({
  imports: [
    SharedModule,
    DrivebookRoutingModule,
    ModalModule.forRoot(),
  ],
  declarations: [
    BookComponent,
    IncomingComponent,
    HistoricalComponent,
    DrivebookComponent,
    DrivebookDetailsComponent,
    BannerComponent,
    EditDrivebookComponent,
  ],
  providers: [
    DrivebookService,
    BookService
  ]
})
export class DrivebookModule { }
