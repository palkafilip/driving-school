import { Component, OnInit } from '@angular/core';
import {DriveBooking} from "../../../../classes/drive-booking";
import {DrivebookService} from "../../service/drivebook.service";
import {DateUtilsService} from "../../../../utils/date-utils.service";

@Component({
  selector: 'app-incoming',
  templateUrl: './incoming.component.html',
  styleUrls: ['./incoming.component.scss']
})
export class IncomingComponent implements OnInit {

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
          .filter(drive => this.dateUtils.compareWithToday(drive.day));
      });
  }

}
