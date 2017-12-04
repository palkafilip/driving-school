import {Injectable, OnInit} from '@angular/core';
import {LoggedUserService} from "../../../service/logged-user.service";
import {LoggedUser} from "../../../classes/logged-user";
import {RestService} from "../../../service/rest.service";
import {Observable} from "rxjs/Observable";

@Injectable()
export class HomeService {

  private loggedUser: LoggedUser;
  constructor(
    private loggedUserService: LoggedUserService,
    private rest: RestService
  ) {
    //w razie gdyby jakims cudem serwis odpalal sie pierwszy
    // this.loggedUserService.loggedUserEmitter.subscribe( s => {
    //   this.loggedUser = this.loggedUserService.getLoggedUser();
    //   console.log("mam juz usera");
    //
    // })
    this.loggedUser = this.loggedUserService.getLoggedUser();
  }

  getDrivesForLoggedUser(): Observable<any> {
    const URL: string = `drives/${this.loggedUser.id}/all`;
    return this.rest
      .GET(URL);
  }

}
