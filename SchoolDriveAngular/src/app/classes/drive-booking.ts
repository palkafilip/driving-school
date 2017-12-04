import {User} from "./user";
import {Instructor} from "./instructor";
import {Car} from "./car";

export class DriveBooking {
  id: number;
  user: User;
  instructor: Instructor;
  car: Car;
  day: string;
  startTime: string;
  endTime: string;
}

