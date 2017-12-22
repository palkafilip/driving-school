import {User} from "./user";
import {Instructor} from "./instructor";
import {Car} from "./car";
import {HoursInterval} from "./hours-interval";

export class DriveBookingPresentation {
  id: number;
  user: User;
  instructor: Instructor;
  car: Car;
  hoursInterval: HoursInterval;
  day: string;
}

