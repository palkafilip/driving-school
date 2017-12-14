import {Component, Input, OnInit} from '@angular/core';
import {DriveBooking} from "../../../../classes/drive-booking";
import {DateUtilsService} from "../../../../utils/date-utils.service";

@Component({
  selector: 'app-drivebook',
  templateUrl: './drivebook.component.html',
  styleUrls: ['./drivebook.component.scss']
})
export class DrivebookComponent implements OnInit {

  @Input()
  drive: DriveBooking;

  constructor(
    private dateUtils: DateUtilsService,
  ) { }

  ngOnInit() {
  }

  //funkcja zamieniająca pierwszą literę każdego słowa na wielką i zwracająca słowa oddzielone spacją
  capitalizeFirstLetters(...words: string[]) {
    let capitalized;
    capitalized = words.reduce((prev, curr) => {
      return prev.concat(curr.charAt(0).toUpperCase() + curr.substr(1).toLowerCase() + " ");
    }, "");
    return capitalized.substr(0, capitalized.length-1);
  }

  convertTimeToHoursAndMinutes(date: string): string {
    return this.dateUtils.convertTimeToHoursAndMinutes(date);
  }
}
