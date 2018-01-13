import { Injectable } from '@angular/core';
import {LoggedUser} from "../../../classes/logged-user";
import {LoggedUserService} from "../../../service/logged-user.service";
import {RestService} from "../../../service/rest.service";
import {Observable} from "rxjs/Observable";

@Injectable()
export class DrivebookService {

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
    const URL: string = `drives?userId=${this.loggedUser.id}`;
    return this.rest
      .GET(URL);
  }

  getDriveById(id: number): Observable<any> {
    const URL: string = `drives/${id}`;
    return this.rest
      .GET(URL);
  }

  deleteBook(id: number): Observable<any> {
    const URL: string = `drives/${id}`;
    return this.rest
      .DELETE(URL);
  }

}
