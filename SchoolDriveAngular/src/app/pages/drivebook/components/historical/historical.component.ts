import { Component, OnInit } from '@angular/core';
import {DrivebookService} from "../../service/drivebook.service";
import {DriveBooking} from "../../../../classes/drive-booking";
import {DateUtilsService} from "../../../../utils/date-utils.service";

@Component({
  selector: 'app-historical',
  templateUrl: './historical.component.html',
  styleUrls: ['./historical.component.scss']
})
export class HistoricalComponent implements OnInit {

  drives: DriveBooking[] = [];

  constructor(
    private drivebookService: DrivebookService,
    private dateUtils: DateUtilsService,
  ) { }

  ngOnInit() {
    this.drivebookService
      .getDrivesForLoggedUser()
      .subscribe(db => {
        this.drives = db
          .filter(drive => !this.dateUtils.compareWithToday(drive.day));
      });
  }



}
