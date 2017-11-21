import { Injectable } from '@angular/core';
import {RestService} from "../../../service/rest.service";
import {MenuService} from "../../../service/menu.service";
import {LoggedUserService} from "../../../service/logged-user.service";

@Injectable()
export class LoginService {
  private URI = 'users/login';

  constructor(
    private rest: RestService,
    private loggedUserService: LoggedUserService
  ) { }

  logUser(login: string, password: string) {
    this.rest
      .GETWithAuthorization(this.URI, login, password)
      .subscribe(res => {
        this.loggedUserService.setLoggedUser(res);
      });
  }

}
