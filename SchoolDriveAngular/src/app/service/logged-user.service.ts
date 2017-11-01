import { Injectable } from '@angular/core';
import {LoggedUser} from "../classes/logged-user";

@Injectable()
export class LoggedUserService {

  private loggedUser: LoggedUser;

  constructor() { }

  getLoggedUser(): LoggedUser {
    return this.loggedUser;
  }

  setLoggedUser(user): void {
    this.loggedUser = user;
  }

}
