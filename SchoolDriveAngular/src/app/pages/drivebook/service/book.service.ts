import { Injectable } from '@angular/core';
import {RestService} from "../../../service/rest.service";
import {Observable} from "rxjs/Observable";
import {DriveBookingPresentation} from "../../../classes/drive-booking-presentation";

@Injectable()
export class BookService {

  constructor(
    private rest: RestService
  ) { }

  getAllInstructors(): Observable<any> {
    const URL = 'instructors';
    return this.rest
      .GET(URL);
  }

  getAllCars(): Observable<any> {
    const URL = 'cars';
    return this.rest
      .GET(URL);
  }

  getAllHourIntervals(): Observable<any> {
    const URL = 'hour-intervals';
    return this.rest
      .GET(URL);
  }

  getReservedHourIntervals(instructorId: number, carId: number, day: string) {
    const URL = `drives/reserved?instructorId=${instructorId}&carId=${carId}&day=${day}`;
    return this.rest
      .GET(URL);
  }

  bookDrive(bookInfo: DriveBookingPresentation) {
    const URL = 'drives';
    return this.rest
      .POST(URL, bookInfo);
  }

}
