import { Injectable } from '@angular/core';

@Injectable()
export class DateUtilsService {

  constructor() { }

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

  //from xx:yy:zz to xx:yy
  convertTimeToHoursAndMinutes(date: string) {
    const split = date.split(':');

    return `${split[0]}:${split[1]}`;
  }

  //from yyyy-mm-dd xx:yy to yyyy-mm-dd
  getRidOfTimeInDate(date: string) {
    const split = date.split(' ');

    return split[0];
  }

}
