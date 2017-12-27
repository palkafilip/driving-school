import {Component, OnDestroy, OnInit} from '@angular/core';
import {Instructor} from "../../../../classes/instructor";
import {InstructorService} from "../../service/instructor.service";
import {Subscription} from "rxjs/Subscription";
import {ActivatedRoute, Router} from "@angular/router";
import {Store, StoreService} from "../../../../service/store.service";

@Component({
  selector: 'app-search',
  templateUrl: './search-instructor.component.html',
  styleUrls: ['./search-instructor.component.scss']
})
export class SearchInstructorComponent implements OnInit, OnDestroy {

  allInstructors: Instructor[] = [];
  filteredInstructors: Instructor[] = [];
  searchResult = '';
  private sub: Subscription;
  store: Store = {
    searchInput : '',
  };
  constructor(
    private instructorService: InstructorService,
    private router: Router,
    private route: ActivatedRoute,
    private storeService: StoreService
  ) { }

  ngOnInit() {
    this.store = this.storeService.getRouteStore();
    this.getAllInstructors();
  }

  getAllInstructors() {
    this.sub = this.instructorService
      .getAllInstructors()
      .subscribe(instructors => {
        this.allInstructors = instructors;
        if(this.store.searchInput) {
          this.filterInstructors();
        }
      });
  }

  filterInstructors() {
    this.searchResult = '';
    this.filteredInstructors = this.allInstructors
      .filter(i => i.firstname.search(this.store.seachInput) > -1 || i.lastname.search(this.store.seachInput) > -1);
    if(this.filteredInstructors.length === 0) {
      this.searchResult = 'Nie znaleziono instruktorów spełniających podane kryteria';
    }
  }

  goToDetails(id: number) {
    this.storeService.setRouteStore(this.store);
    this.router
      .navigate(['../instructor-details', id], { relativeTo: this.route });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }
}
