import { Injectable } from '@angular/core';
import {RestService} from "../../../service/rest.service";
import {Observable} from "rxjs/Observable";
import {DriveBooking} from "../classes/drive-booking";

@Injectable()
export class BookService {

  constructor(
    private rest: RestService
  ) { }

  getAllInstructors(): Observable<any> {
    const URL = 'instructors/all';
    return this.rest
      .GET(URL);
  }

  getAllCars(): Observable<any> {
    const URL = 'cars/all';
    return this.rest
      .GET(URL);
  }

  getAllHourIntervals(): Observable<any> {
    const URL = 'hour-intervals/all';
    return this.rest
      .GET(URL);
  }

  getReservedHourIntervals(instructorId: number, carId: number, day: string) {
    const URL = `drives/reserved?instructorId=${instructorId}&carId=${carId}&day=${day}`;
    return this.rest
      .GET(URL);
  }

  bookDrive(bookInfo: DriveBooking) {

  }

}
