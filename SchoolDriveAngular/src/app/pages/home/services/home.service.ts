import { Injectable } from '@angular/core';
import {LoggedUserService} from "../../../service/logged-user.service";
import {LoggedUser} from "../../../classes/logged-user";
import {RestService} from "../../../service/rest.service";
import {Observable} from "rxjs/Observable";

@Injectable()
export class HomeService {

  private loggedUser: LoggedUser;
  private URL: string = 'drives/all'
  constructor(
    private loggedUserService: LoggedUserService,
    private rest: RestService
  ) {
    this.loggedUser = this.loggedUserService.getLoggedUser();

  }

  getDrivesForLoggedUser(): Observable<any> {
    return this.rest
      .GET(this.URL);
  }

}
