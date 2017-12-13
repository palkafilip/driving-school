import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Subscription} from "rxjs/Subscription";
import {InstructorRating} from "../../../../classes/instructor-rating";
import {InstructorService} from "../../service/instructor.service";

@Component({
  selector: 'app-instructor-details',
  templateUrl: './instructor-details.component.html',
  styleUrls: ['./instructor-details.component.scss']
})
export class InstructorDetailsComponent implements OnInit, OnDestroy {

  //TODO: Zamienic na 1 subskrybcje: AngularLove - ktores Tips&Tricks
  private sub: Subscription;
  private sub2: Subscription;
  id: number;
  instructorRates: InstructorRating[] = [];

  constructor(private route: ActivatedRoute, private instructorService: InstructorService) { }

  ngOnInit() {
    this.sub = this.route
      .params
      .subscribe(params => {
        this.id = +params['id'];
        this.getInstructorRates();
      })
  }

  getInstructorRates() {
    this.sub2 = this.instructorService
      .getInstructorDetailsWithRates(this.id)
      .subscribe(ir => this.instructorRates = ir);
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }
}
