import { Component, OnInit } from '@angular/core';
import {DrivebookService} from "../../service/drivebook.service";
import {ActivatedRoute } from "@angular/router";
import {DriveBookingPresentation} from "../../../../classes/drive-booking-presentation";
import {Subscription} from "rxjs/Subscription";

@Component({
  selector: 'app-edit-drivebook',
  templateUrl: './edit-drivebook.component.html',
  styleUrls: ['./edit-drivebook.component.scss']
})
export class EditDrivebookComponent implements OnInit {

  id: number;
  drive: DriveBookingPresentation;
  private subscriptions: Subscription;
  constructor(
    private driveService: DrivebookService,
    private route: ActivatedRoute,
  ) { }

  ngOnInit() {
    this.subscriptions = new Subscription();
    this.subscriptions.add(
      this.route
        .params
        .subscribe(params => {
          this.id = +params['id'];
          this.getDriveById();
        })
    )
  }

  getDriveById() {
    this.subscriptions
      .add(
        this.driveService
          .getDriveById(this.id)
          .subscribe(res => this.drive = res)
      );
  }

}
