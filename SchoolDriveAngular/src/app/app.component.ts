import {Component, OnDestroy, OnInit} from '@angular/core';
import {MenuService} from "./service/menu.service";
import {Subscription} from "rxjs/Subscription";
import {LoggedUserService} from "./service/logged-user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit, OnDestroy {

  userLogged: boolean;
  private menuSub: Subscription;
  private loggedUserSub: Subscription;

  constructor(private loggedUser: LoggedUserService, private router: Router) {

  }

  ngOnInit() : void {
    this.checkIfUserIsLogged();
  }

  checkIfUserIsLogged() {
    this.loggedUserSub = this.loggedUser.isUserLoggedOnServer().subscribe(res => {
      this.menuSub = this.loggedUser
        .getObservable()
        .subscribe(user => {
          if (!user || user === {}) {
            this.setStrangerMenu();
            this.router.navigate(['/start']);
          } else {
            this.setLoggedUserMenu();
            this.router.navigateByUrl('/pages');
          }
        });
    })
  }

  setLoggedUserMenu(): void {
    this.userLogged = true;
  }

  setStrangerMenu(): void {
    this.userLogged = false;
  }

  ngOnDestroy(): void {
    this.menuSub.unsubscribe();
    this.loggedUserSub.unsubscribe();
  }


}
