import {Component, OnDestroy, OnInit} from '@angular/core';
import {MenuService} from "./service/menu.service";
import {Subscription} from "rxjs/Subscription";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit, OnDestroy {

  userLogged: boolean;
  sub: Subscription;

  constructor(private menu: MenuService) {
    this.sub = this.menu
      .getObservable()
      .subscribe(val => this.userLogged = val);
  }

  ngOnInit() : void {
  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }



}
