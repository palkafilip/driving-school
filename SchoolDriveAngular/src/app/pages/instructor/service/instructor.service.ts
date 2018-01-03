import { Injectable } from '@angular/core';
import {RestService} from "../../../service/rest.service";
import {Observable} from "rxjs/Observable";
import {InstructorRatingPresentation} from "../../../classes/instructor-rating-presentation";

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

  getInstructorDetailsWithRates(id: number): Observable<any> {
    const URL = `instructors/instructor/${id}/ratings`;
    return this.rest
      .GET(URL);
  }

  getIntructorRateByUserAndInstructor(userId: number, instructorId: number): Observable<any> {
    const URL = `instructors/instructor/${instructorId}/rating?userId=${userId}`;
    return this.rest
      .GET(URL);
  }

  addInstructorRate(instructorId: number, rate: InstructorRatingPresentation) {
    const URL = `instructors/instructor/${instructorId}/rating/new`;
    return this.rest
      .POST(URL, rate);
  }

}
