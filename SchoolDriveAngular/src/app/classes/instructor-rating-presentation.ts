import {User} from "./user";
import {Instructor} from "./instructor";
export class InstructorRatingPresentation {
  id: number;
  user: User;
  instructor: Instructor;
  comment: string;
  rate: number;
  date: string;
}
