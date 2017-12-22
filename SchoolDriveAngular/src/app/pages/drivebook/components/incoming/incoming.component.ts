import { Component, OnInit } from '@angular/core';
import {DriveBookingPresentation} from "../../../../classes/drive-booking-presentation";
import {DrivebookService} from "../../service/drivebook.service";
import {DateUtilsService} from "../../../../service/date-utils.service";

@Component({
  selector: 'app-incoming',
  templateUrl: './incoming.component.html',
  styleUrls: ['./incoming.component.scss']
})
export class IncomingComponent implements OnInit {

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
          .filter(drive => this.dateUtils.compareWithToday(drive.day));
      });
  }

}
