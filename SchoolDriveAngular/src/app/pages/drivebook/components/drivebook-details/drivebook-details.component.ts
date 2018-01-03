import {Component, OnDestroy, OnInit, TemplateRef} from '@angular/core';
import {Subscription} from "rxjs/Subscription";
import {ActivatedRoute, Router} from "@angular/router";
import {DriveBookingPresentation} from "../../../../classes/drive-booking-presentation";
import {DrivebookService} from "../../service/drivebook.service";
import {BsModalRef, BsModalService} from "ngx-bootstrap";

@Component({
  selector: 'app-drivebook-details',
  templateUrl: './drivebook-details.component.html',
  styleUrls: ['./drivebook-details.component.scss']
})
export class DrivebookDetailsComponent implements OnInit, OnDestroy {

  subscriptions : Subscription;
  id: number;
  drive: DriveBookingPresentation;
  type: string;
  modalRef: BsModalRef;
  message: string;
  constructor(
    private route: ActivatedRoute,
    private driveService: DrivebookService,
    private router: Router,
    private modalService: BsModalService
  ) {
    this.subscriptions = new Subscription();
  }

  ngOnInit() {
    this.subscriptions.add(
      this.route
        .params
        .subscribe(params => {
          this.id = +params['id'];
          this.getDriveById();
          this.type = this.route.snapshot.url[0].path;
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

  goToEdit(id: number) {
    this.router.navigate(['pages/drivebooks/incoming', id, 'edit']);
  }

  goToRateInstructor(id: number) {
    this.router.navigate(['pages/instructors/rate-instructor', id]);
  }

  cancelBook() {
    this.subscriptions
      .add(
        this.driveService
          .deleteBook(this.id)
          .subscribe(res => {
            this.modalRef.hide();
            this.router.navigate(['pages'])
          })
      )

  }
  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template, {class: 'modal-md modal-customized'});
  }

  confirm(): void {
    this.cancelBook();
  }

  decline(): void {
    this.modalRef.hide();
  }

  ngOnDestroy() {
    this.subscriptions.unsubscribe();
  }

}
