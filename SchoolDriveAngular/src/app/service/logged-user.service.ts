import {EventEmitter, Injectable} from '@angular/core';
import {LoggedUser} from "../classes/logged-user";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {Observable} from "rxjs/Observable";
import {RestService} from "./rest.service";

@Injectable()
export class LoggedUserService {

  private loggedUser: BehaviorSubject<LoggedUser>;
  public loggedUserEmitter: EventEmitter<boolean> = new EventEmitter();
  constructor(private rest: RestService) {
  }

  getLoggedUser(): LoggedUser {
    // if(!this.loggedUser) {
    //   console.log('wchodze');
    //   return this.loggedUserEmitter.map( e => this.loggedUser.asObservable());
    // }
    // return this.loggedUser.asObservable();

    return this.loggedUser.getValue();
  }

  setLoggedUser(user): void {
    if(!this.loggedUser) {
      this.loggedUserEmitter.map( e => {
        localStorage.setItem('loggedUser', JSON.stringify(user));
        this.loggedUser.next(user);
      })
    } else {
      localStorage.setItem('loggedUser', JSON.stringify(user));
      this.loggedUser.next(user);
    }
  }

  checkUserLocalStorage(): LoggedUser {
    return JSON.parse(localStorage.getItem('loggedUser'));
  }

  clearLocalStorage(): void {
    localStorage.clear();
  }

  getObservable(): Observable<LoggedUser> {
    return this.loggedUser.asObservable();
  }

  isUserLoggedOnServer(): Observable<boolean> {
    return new Observable(observer => {
      if(!this.checkUserLocalStorage()) {
        this.loggedUser = new BehaviorSubject<LoggedUser>(null);
        return observer.next(true);
      }
      const URI = 'users/logged';
      this.rest
        .GET(URI)
        .subscribe(
          res => {
            console.log('sukces');
            this.loggedUser = new BehaviorSubject<LoggedUser>(this.checkUserLocalStorage());
            observer.next(true);
            this.loggedUserEmitter.emit(true);
          },
          err => {
            console.log("porażka");
            this.clearLocalStorage();
            this.loggedUser = new BehaviorSubject<LoggedUser>(null);
            observer.next(true);
          }
        )
    })
  }
}
