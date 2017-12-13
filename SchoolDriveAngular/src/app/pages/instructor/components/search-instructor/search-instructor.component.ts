import {Component, OnDestroy, OnInit} from '@angular/core';
import {Instructor} from "../../../../classes/instructor";
import {InstructorService} from "../../service/instructor.service";
import {Subscription} from "rxjs/Subscription";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-search',
  templateUrl: './search-instructor.component.html',
  styleUrls: ['./search-instructor.component.scss']
})
export class SearchInstructorComponent implements OnInit, OnDestroy {

  allInstructors: Instructor[] = [];
  filteredInstructors: Instructor[] = [];
  private sub: Subscription;
  searchInput = '';
  searchResult = '';

  constructor(
    private instructorService: InstructorService,
    private router: Router,
    private route: ActivatedRoute,
  ) { }

  ngOnInit() {
    this.getAllInstructors();
  }

  getAllInstructors() {
    this.sub = this.instructorService
      .getAllInstructors()
      .subscribe(instructors => this.allInstructors = instructors);
  }

  filterInstructors() {
    this.searchResult = '';
    this.filteredInstructors = this.allInstructors
      .filter(i => i.firstname.search(this.searchInput) > -1 || i.lastname.search(this.searchInput) > -1);
    if(this.filteredInstructors.length === 0) {
      this.searchResult = 'Nie znaleziono instruktorów spełniających podane kryteria';
    }
  }

  goToDetails(id: number) {
    this.router
      .navigate(['../instructor-details', id], { relativeTo: this.route });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }
}
