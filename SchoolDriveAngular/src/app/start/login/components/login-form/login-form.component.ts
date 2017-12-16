import { Component, OnInit } from '@angular/core';
import {MenuService} from "../../../../service/menu.service";
import {LoginService} from "../../service/login.service";
import {HttpResponse} from "@angular/common/http";

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.scss']
})
export class LoginFormComponent implements OnInit {

  login: string;
  password: string;
  errorMsg: string;

  constructor(private loginService: LoginService) { }

  ngOnInit() {
  }

  log() {

    if(!this.password || !this.login) {
      this.errorMsg = "Podaj login i hasło";
      return;
    }
    this.errorMsg = '';
    this.loginService
      .logUser(this.login, this.password)
      .subscribe(
        res => {
          this.loginService.setLoggedUser(res);
        },
        (err: HttpResponse<any>) => {
          this.errorMsg = JSON.parse(err['_body']).error;
        }
      );
  }

}
