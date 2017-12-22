import { Component, OnInit } from '@angular/core';
import {DrivebookService} from "../../service/drivebook.service";
import {DriveBookingPresentation} from "../../../../classes/drive-booking-presentation";
import {DateUtilsService} from "../../../../service/date-utils.service";

@Component({
  selector: 'app-historical',
  templateUrl: './historical.component.html',
  styleUrls: ['./historical.component.scss']
})
export class HistoricalComponent implements OnInit {

  drives: DriveBookingPresentation[] = [];

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
