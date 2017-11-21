import { Injectable } from '@angular/core';
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {Observable} from "rxjs/Observable";
import {RestService} from "./rest.service";
import {LoggedUserService} from "./logged-user.service";

@Injectable()
export class MenuService {

  // private loggedUserMenu = new BehaviorSubject(false);
  // constructor(private loggedUserService: LoggedUserService) {
  //   loggedUserService
  //     .getObservable()
  //     .subscribe(user => {
  //       if(!user || user === {}) {
  //         this.setStrangerMenu();
  //       } else {
  //         this.setLoggedUserMenu();
  //       }
  //     })
  // }
  //
  // setLoggedUserMenu() {
  //   this.loggedUserMenu.next(true);
  // }
  //
  // setStrangerMenu() {
  //   this.loggedUserMenu.next(false);
  // }
  //
  // getObservable(): Observable<boolean> {
  //   return this.loggedUserMenu.asObservable();
  // }

}
