import { Component, OnInit } from '@angular/core';
import {RestService} from "../../service/rest-service.service";

@Component({
  selector: 'app-car-checking',
  templateUrl: './car-checking.component.html',
  styleUrls: ['./car-checking.component.css']
})
export class CarCheckingComponent implements OnInit {

  constructor(private service: RestService) {
  }

  ngOnInit() {
    this.service
      .GET("cars?id=1")
      .then(response => console.log(response))
      .catch(err => console.log("coooo" + err));
  }

}
