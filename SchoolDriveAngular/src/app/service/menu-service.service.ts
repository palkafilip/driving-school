import { Injectable } from '@angular/core';
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {Observable} from "rxjs/Observable";

@Injectable()
export class MenuService {

  private userLogged = new BehaviorSubject(false);
  constructor() { }

  logUser() {
    this.userLogged.next(true);
  }

  logoutUser() {
    this.userLogged.next(false);
  }

  getObservable(): Observable<boolean> {
    return this.userLogged.asObservable();
  }

}
