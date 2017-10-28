import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {MenuService} from "../../service/menu-service.service";

@Component({
  selector: 'app-start',
  templateUrl: './start.component.html',
  styleUrls: ['./start.component.scss']
})
export class StartComponent implements OnInit {

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private menu: MenuService,
  ) { }

  ngOnInit() {
  }

  test() {
    this.menu.logUser();
  }

  test2() {
    this.menu.logoutUser();
  }

  changeSubpage(page: string) {
    this.router.navigate([`${page}`], { relativeTo: this.route });
  }

}
