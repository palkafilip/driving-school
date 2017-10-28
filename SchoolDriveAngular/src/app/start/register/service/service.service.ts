import { Injectable } from '@angular/core';
import {RestService} from "../../../service/rest-service.service";
import {RegisterUser} from "../register-user";
import {Observable} from "rxjs/Observable";

@Injectable()
export class RegisterService {

  private URI = 'users'
  constructor(private restService: RestService) { }

  registerUser(user: RegisterUser): Observable<any> {
    return this.restService
      .POST(this.URI, user);
  }



}
