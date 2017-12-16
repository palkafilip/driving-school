import { Component, OnInit } from '@angular/core';
import { RegisterUser } from "../../register-user";
import { RegisterService } from "../../service/service.service";

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.scss']
})
export class RegisterFormComponent implements OnInit {

  user: RegisterUser;
  msg: string;
  constructor(private service: RegisterService) { }

  ngOnInit() {
    this.user = new RegisterUser();
  }

  register() {
    this.msg = '';
    for(const prop in this.user) {
      if(this.user[prop].length < 1 && prop !== 'email') {
        this.msg = `Wypełnij pole ${prop}`;
        return;
      }
    }
    this.service
      .registerUser(this.user)
      .subscribe(res => {
        console.log(res);
        this.msg = `${res['firstname']}, zostałeś zarejestrowany pomyślnie!`
      });
  }

}
