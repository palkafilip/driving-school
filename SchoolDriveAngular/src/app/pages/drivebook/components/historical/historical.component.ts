import { Component, OnInit } from '@angular/core';
import {DrivebookService} from "../../service/drivebook.service";
import {DriveBooking} from "../../../../classes/drive-booking";

@Component({
  selector: 'app-historical',
  templateUrl: './historical.component.html',
  styleUrls: ['./historical.component.scss']
})
export class HistoricalComponent implements OnInit {

  drives: DriveBooking[] = [];

  constructor(private drivebookService: DrivebookService) { }

  ngOnInit() {
    this.drivebookService
      .getDrivesForLoggedUser()
      .subscribe(db => {
        this.drives = db
          .filter(drive => this.compareWithToday(drive.day));
      });
  }

  compareWithToday(date: string) {
    let today = new Date(this.getTodaysDate());
    let compareDate = new Date(date);
    return compareDate < today;
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
