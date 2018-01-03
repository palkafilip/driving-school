import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs/Subscription";
import {InstructorService} from "../../service/instructor.service";
import {ActivatedRoute} from "@angular/router";
import {LoggedUserService} from "../../../../service/logged-user.service";
import {InstructorRatingPresentation} from "../../../../classes/instructor-rating-presentation";
import {DateUtilsService} from "../../../../service/date-utils.service";
import {Instructor} from "../../../../classes/instructor";

@Component({
  selector: 'app-rate-instructor',
  templateUrl: './rate-instructor.component.html',
  styleUrls: ['./rate-instructor.component.scss']
})
export class RateInstructorComponent implements OnInit, OnDestroy {

  private subscriptions: Subscription;
  id: number;
  instructorRating: InstructorRatingPresentation;
  instructor: Instructor;
  rateExist: boolean = false;
  errorMsg: string = '';

  constructor(
    private route: ActivatedRoute,
    private instructorService: InstructorService,
    private loggedUserService: LoggedUserService,
    private dateService: DateUtilsService,
  ) { }

  ngOnInit() {
    this.instructorRating = new InstructorRatingPresentation();
    this.subscriptions = new Subscription();
    this.subscriptions
      .add(
        this.route
          .params
          .subscribe(params => {
            this.id = +params['id'];
            this.getInstructorRate();
          })
      )
  }

  getInstructorById() {
    this.instructorService
      .getInstructorById(this.id)
      .subscribe(i => {
        this.instructor = i;
        this.initializeForRate();
      });
  }

  getInstructorRate() {
    this.instructorService
      .getIntructorRateByUserAndInstructor(this.loggedUserService.getLoggedUser().id, this.id)
      .subscribe(res => {
        if(Object.keys(res).length !== 0) {
          this.instructorRating = res;
          this.rateExist = true;
        } else {
          this.getInstructorById();
        }
      });
  }

  initializeForRate() {
    this.instructorRating.instructor = this.instructor;
    this.instructorRating.user = this.loggedUserService.getLoggedUser();
    this.instructorRating.date = this.dateService.getTodaysDate();
  }

  changeRate(rate) {
    console.log(rate);
    this.instructorRating.rate = rate;
  }

  rateInstructor() {
    this.errorMsg = '';
    if (!this.instructorRating.rate) {
      return this.errorMsg = 'Dodaj ocenę'
    }
    if (!this.instructorRating.comment || this.instructorRating.comment.length < 5) {
      return this.errorMsg = 'Komentarz musi zawierać przynajmniej 5 znaków'
    }

    this.instructorService.addInstructorRate(this.id, this.instructorRating)
      .subscribe(res => {
        console.log('hej')
      });
  }

  ngOnDestroy() {
    this.subscriptions.unsubscribe();
  }

  convertDateWithoutTime(date: string) {
    return this.dateService.getRidOfTimeInDate(date);
  }

}
