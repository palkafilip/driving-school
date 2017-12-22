import { Component, OnInit } from '@angular/core';
import {HomeService} from "../services/home.service";
import {DriveBookingPresentation} from "../../../classes/drive-booking-presentation";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  drives: DriveBookingPresentation[] = [];

  constructor(private homeService: HomeService) { }

  ngOnInit() {
    this.homeService
      .getDrivesForLoggedUser()
      .subscribe(db => {
        this.drives = db
          .filter(drive => this.compareWithToday(drive.day));
      });
  }

  //funkcja zamieniająca pierwszą literę każdego słowa na wielką i zwracająca słowa oddzielone spacją
  capitalizeFirstLetters(...words: string[]) {
    let capitalized;
    capitalized = words.reduce((prev, curr) => {
      return prev.concat(curr.charAt(0).toUpperCase() + curr.substr(1).toLowerCase() + " ");
    }, "");
    return capitalized.substr(0, capitalized.length-1);
  }

  compareWithToday(date: string) {
    let today = new Date(this.getTodaysDate());
    let compareDate = new Date(date);
    return compareDate >= today;
  }

  getTodaysDate() {
    const date = new Date();
    let yyyy = date.getFullYear().toString();
    let mm = (date.getMonth() + 1).toString();
    let dd = date.getDate().toString();

    let mmChars = mm.split('');
    let ddChars = dd.split('');

    return yyyy + '-' + (mmChars[1] ? mm : "0" + mmChars[0]) + '-' + (ddChars[1] ? dd : "0" + ddChars[0]);
  }
}
