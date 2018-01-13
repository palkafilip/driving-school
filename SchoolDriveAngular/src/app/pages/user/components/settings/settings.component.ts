import { Component, OnInit } from '@angular/core';
import {LoggedUserService} from "../../../../service/logged-user.service";
import {UserService} from "../../service/user.service";
import {LoggedUser} from "../../../../classes/logged-user";

@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.scss']
})
export class SettingsComponent implements OnInit {

  loggedUser: LoggedUser;
  newPassword: string;
  repeatedPassword: string;
  result: string = '';

  constructor(
    private loggedService: LoggedUserService,
    private userService: UserService
  ) { }

  ngOnInit() {
    this.loggedUser = this.loggedService.getLoggedUser();
  }

  applyPersonalChanges() {
    this.userService
      .updateUserData(this.loggedUser)
      .subscribe(data => this.loggedService.setLoggedUser(data));
  }

  applyPasswordChange() {
    if(!this.newPassword || !this.repeatedPassword) {
      return this.result = 'Hasło nie może być puste'
    }
    if(this.newPassword !== this.repeatedPassword) {
      return this.result = 'Podane hasła muszą być takie same';
    }

    this.loggedUser.password = this.newPassword;
    this.userService
      .updateUserData(this.loggedUser)
      .subscribe(data => this.loggedService.setLoggedUser(data));
  }

}
