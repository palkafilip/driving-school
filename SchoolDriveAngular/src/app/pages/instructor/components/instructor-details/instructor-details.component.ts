import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Subscription} from "rxjs/Subscription";
import {InstructorRatingPresentation} from "../../../../classes/instructor-rating-presentation";
import {InstructorService} from "../../service/instructor.service";
import {Instructor} from "../../../../classes/instructor";
import {DateUtilsService} from "../../../../service/date-utils.service";

@Component({
  selector: 'app-instructor-details',
  templateUrl: './instructor-details.component.html',
  styleUrls: ['./instructor-details.component.scss']
})
export class InstructorDetailsComponent implements OnInit, OnDestroy {

  private subscriptions: Subscription;
  id: number;
  instructorRates: InstructorRatingPresentation[] = [];
  instructor: Instructor;

  constructor(
    private route: ActivatedRoute,
    private instructorService: InstructorService,
    private dateUtils: DateUtilsService
  ) { }

  ngOnInit() {
    this.subscriptions = new Subscription();
    this.subscriptions
      .add(
        this.route
          .params
          .subscribe(params => {
            this.id = +params['id'];
            this.getInstructorById();
            this.getInstructorRates();
          })
      )
  }

  getInstructorRates() {
    this.subscriptions
      .add(
        this.instructorService
          .getInstructorDetailsWithRates(this.id)
          .subscribe(ir => {
            this.instructorRates = ir;
            // console.log(this.averageInstructorRate());
          })
      )
  }

  getInstructorById() {
    this.instructorService
      .getInstructorById(this.id)
      .subscribe(i => this.instructor = i);
  }

  averageInstructorRate() {
    if(this.instructorRates.length === 0) {
      return '-';
    }
    return this.instructorRates
      .map(ir => ir.rate)
      .reduce((acc, curr) => acc + curr)/this.instructorRates.length;
  }

  convertDateWithoutTime(date: string): string {
    return this.dateUtils.getRidOfTimeInDate(date);
  }

  ngOnDestroy() {
    this.subscriptions.unsubscribe();
  }
}
