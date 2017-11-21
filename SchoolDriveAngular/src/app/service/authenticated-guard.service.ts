import { Injectable } from '@angular/core';
import {CanLoad, Route, Router} from "@angular/router";
import {LoggedUserService} from "./logged-user.service";
import {Observable} from "rxjs/Observable";
import {RestService} from "./rest.service";

@Injectable()
export class AuthenticatedGuardService implements CanLoad {

  constructor(private loggedUserService: LoggedUserService,
              private rest: RestService,
              private router: Router) {
  }

  canLoad(route: Route): Observable<boolean> | boolean {

    return new Observable(observer => {
      const URI = 'users/logged';
      this.rest
        .GET(URI)
        .subscribe(
          res => {
            if(this.loggedUserService.checkUserLocalStorage()) {
              this.router.navigate(['/pages']);
              return true;
            } else {
              this.router.navigate(['/start']);
              return false;
            }
          },
          err => {
            this.router.navigate(['/start']);
            return false;
          }

        )
        observer.complete();
    })
    // const result = this.loggedUserService
    //   .getLoggedUser()
    //   .map(user => {
    //     if (!user) {
    //       this.router.navigate(['/start']);
    //       return false;
    //     }
    //     return true;
    //   });
    // ;
    // return result;
  }
}
