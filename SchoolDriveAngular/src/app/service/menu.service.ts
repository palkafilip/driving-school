import { Injectable } from '@angular/core';
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {Observable} from "rxjs/Observable";
import {RestService} from "./rest.service";

@Injectable()
export class MenuService {

  private loggedUserMenu = new BehaviorSubject(false);
  private URI = 'users/login'
  constructor(private rest: RestService) { }

  // logUser(login: string, password: string) {
  //   this.rest
  //     .GETWithAuthorization(this.URI, login, password)
  //     .subscribe(res => {
  //       this.userLogged.next(true);
  //       console.log(res);
  //     });
  // }

  setLoggedUserMenu() {
    this.loggedUserMenu.next(true);
  }

  setForStrangerMenu() {
    this.loggedUserMenu.next(false);
  }

  getObservable(): Observable<boolean> {
    return this.loggedUserMenu.asObservable();
  }

}
