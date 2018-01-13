import { Injectable } from '@angular/core';
import {User} from "../../../classes/user";
import {Observable} from "rxjs/Observable";
import {RestService} from "../../../service/rest.service";

@Injectable()
export class UserService {

  constructor(private rest: RestService) { }

  updateUserData(user: User): Observable<any> {
    const URI = `users/${user.id}/settings`;
    return this.rest
      .POST(URI, user);
  }

}
