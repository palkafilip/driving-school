import {Component, OnDestroy, OnInit} from '@angular/core';
import {Instructor} from "../../../../classes/instructor";
import {SearchInstructorService} from "../../service/search-instructor.service";
import {Subscription} from "rxjs/Subscription";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-search',
  templateUrl: './search-instructor.component.html',
  styleUrls: ['./search-instructor.component.scss']
})
export class SearchInstructorComponent implements OnInit, OnDestroy {

  instructors: Instructor[] = [];
  private sub: Subscription;
  searchInput = '';

  constructor(
    private instructorService: SearchInstructorService,
    private router: Router,
    private route: ActivatedRoute,
  ) { }

  ngOnInit() {
    this.getAllInstructors();
  }

  getAllInstructors() {
    this.sub = this.instructorService
      .getAllInstructors()
      .subscribe(instructors => this.instructors = instructors);
  }

  filterInstructors() {
    this.instructors = this.instructors
      .filter(i => i.firstname.search(this.searchInput) > -1 || i.lastname.search(this.searchInput) > -1);
  }

  goToDetails(id: number) {
    this.router
      .navigate(['../instructor-details', id], { relativeTo: this.route });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }
}
