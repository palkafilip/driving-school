import { Injectable } from '@angular/core';
import {RestService} from "../../../service/rest.service";
import {Observable} from "rxjs/Observable";

@Injectable()
export class InstructorService {

  constructor(private rest: RestService) { }

  getAllInstructors(): Observable<any> {
    const URL = 'instructors/all';
    return this.rest
      .GET(URL);
  }

  getInstructorById(id: number): Observable<any> {
    const URL = `instructors/instructor/${id}`;
    return this.rest
      .GET(URL);
  }

  getInstructorDetailsWithRates(id: number) {
    const URL = `instructors/instructor/${id}/instructor-ratings`;
    return this.rest
      .GET(URL);
  }

}
