import {User} from "./user";
import {Instructor} from "./instructor";
export class InstructorRating {
  id: number;
  user: User;
  instructor: Instructor;
  comment: string;
  rate: number;
  date: string;
}
