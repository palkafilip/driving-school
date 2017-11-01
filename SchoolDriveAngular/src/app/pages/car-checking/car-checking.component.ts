import { Component, OnInit } from '@angular/core';
import {RestService} from "../../service/rest.service";

@Component({
  selector: 'app-car-checking',
  templateUrl: './car-checking.component.html',
  styleUrls: ['./car-checking.component.scss']
})
export class CarCheckingComponent implements OnInit {

  constructor(private service: RestService) {
  }

  ngOnInit() {
    this.service
      .GET("cars?id=2")
      .subscribe(
        res => console.log(res),
        err => console.log(JSON.parse(err._body))
      );
  }

}
