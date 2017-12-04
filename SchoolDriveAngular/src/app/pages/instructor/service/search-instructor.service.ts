import { Injectable } from '@angular/core';
import {RestService} from "../../../service/rest.service";
import {Observable} from "rxjs/Observable";

@Injectable()
export class SearchInstructorService {

  constructor(private rest: RestService) { }

  getAllInstructors(): Observable<any> {
    const URL = 'instructors/all';
    return this.rest
      .GET(URL);
  }

}
