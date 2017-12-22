import {Component, OnDestroy, OnInit} from '@angular/core';
import {Instructor} from "../../../../classes/instructor";
import {BookService} from "../../service/book.service";
import {Car} from "../../../../classes/car";
import {DateUtilsService} from "../../../../service/date-utils.service";
import {HoursInterval} from "../../../../classes/hours-interval";
import {Subscription} from "rxjs/Subscription";
import {DriveBooking} from "../../classes/drive-booking";
import {DriveBookingPresentation} from "../../../../classes/drive-booking-presentation";
import {LoggedUserService} from "../../../../service/logged-user.service";

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.scss']
})
export class BookComponent implements OnInit, OnDestroy {

  private subscriptions: Subscription = new Subscription();

  instructors: Instructor[] = [];
  cars: Car[] = [];
  hourIntervals: HoursInterval[] = [];
  reservedHourIntervals: HoursInterval[] = [];

  newReservationRequest: DriveBooking;
  newReservation: DriveBookingPresentation;

  instructorId: number;
  carId: number;
  hourIntervalId: number;
  date: string;

  stage: number = 0;
  errorMsg: string;

  constructor(
    private bookService: BookService,
    private dateService: DateUtilsService,
    private loggedService: LoggedUserService,
  ) { }

  ngOnInit() {
    this.initializeBookingPresentation();

    this.getAllInstructors();
    this.date = this.dateService.getTodaysDate();
    this.subscriptions
      .add(
        this.bookService
          .getAllHourIntervals()
          .subscribe(hi => {
            this.hourIntervals = this.getRidOfSeconds(hi);
          })
      );
  }

  initializeBookingPresentation() {
    this.newReservation = new DriveBookingPresentation();
    this.newReservation.day = this.dateService.getTodaysDate();
    this.newReservation.user = this.loggedService.getLoggedUser();
  }
  // Methods communicating with booking service
  getAllInstructors() {
    this.subscriptions
      .add(
        this.bookService.getAllInstructors()
          .subscribe(instructors => this.instructors = instructors)
      );
  }

  getAllCars() {
    this.subscriptions
      .add(
        this.bookService.getAllCars()
          .subscribe(cars => this.cars = cars)
      );
  }

  // Stages in process of booking drive
  toCarStage() {
    if(!this.newReservation.instructor) {
      return this.errorMsg = 'Aby przejść dalej, wybierz instruktora';
    }
    this.getAllCars();
    this.errorMsg = '';
    this.stage = 1;
  }

  toDateStage() {
    if(!this.newReservation.car) {
      return this.errorMsg = 'Aby przejść dalej, wybierz samochód';
    }
    this.errorMsg = '';
    this.stage = 2;
  }

  toTimeStage() {
    if(!this.newReservation.day) {
      return this.errorMsg = 'Aby przejść dalej, wybierz dzień';
    }
    this.bookService
      .getReservedHourIntervals(this.newReservation.instructor.id, this.newReservation.car.id, this.newReservation.day)
      .subscribe(reserved => {
        this.reservedHourIntervals = reserved
        console.log(reserved);
      });
    this.errorMsg = '';
    this.stage = 3;
  }

  toSummary() {
    if(!this.newReservation.hoursInterval) {
      return this.errorMsg = 'Aby przejść dalej, wybierz godziny';
    }
    this.errorMsg = '';


    this.stage = 4;
  }

  reserveBook() {

  }

  // Utility methods manipulating data to display
  checkIfReserved(interval: HoursInterval): boolean {
    return this.reservedHourIntervals
      .some(hi => {
        return hi.id === interval.id;
      })
  }

  changeDate(event) {
    this.newReservation.day = event;
  }

  private getRidOfSeconds(hourInterval: HoursInterval[]) {
    hourInterval.forEach(i => {
        Object.keys(i).forEach(k => {
            if (k !== 'id') {
              i[k] = this.dateService.convertTimeToHoursAndMinutes(i[k]);
            }
          }
        );
      }
    )
    return hourInterval;
  }

  convertBookFromPresentationToRequest(presentation: DriveBookingPresentation) {
    let request = new DriveBooking();
    request.userId = presentation.user.id;
    request.instructorId = presentation.instructor.id;
    request.carId = presentation.car.id;
    request.hoursIntervalId = presentation.hoursInterval.id;
    request.day = presentation.day;

    return request;
  }

  ngOnDestroy(): void {
    this.subscriptions.unsubscribe();
  }
}
