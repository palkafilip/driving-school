import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {BookComponent} from "./components/book/book.component";

const routes: Routes = [
  { path: "", redirectTo: "/pages/books/new-book", pathMatch: "full"},
  { path: "new-book", component: BookComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BooksRoutingModule { }
