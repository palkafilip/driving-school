import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-star-rating',
  templateUrl: './star-rating.component.html',
  styleUrls: ['./star-rating.component.scss']
})
export class StarRatingComponent implements OnInit {

  stars: number[] = [1,2,3,4,5];
  rate: number;

  @Output()
  rateOutput = new EventEmitter<number>();

  constructor() { }

  ngOnInit() {
  }

  changeRate(numb) {
    this.rate = numb;
    this.rateOutput.emit(numb+1);
  }

}
