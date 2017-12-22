import { NgModule } from '@angular/core';

import { BooksRoutingModule } from './books-routing.module';
import { BookComponent } from './components/book/book.component';
import {BookService} from "./service/book.service";
import {SharedModule} from "../../shared/shared.module";

@NgModule({
  imports: [
    SharedModule,
    BooksRoutingModule
  ],
  declarations: [BookComponent],
  providers: [
    BookService,
  ]
})
export class BooksModule { }
