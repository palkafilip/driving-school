import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-star-rating',
  templateUrl: './star-rating.component.html',
  styleUrls: ['./star-rating.component.scss']
})
export class StarRatingComponent implements OnInit {

  stars: number[] = [1,2,3,4,5];
  rate: number;
  constructor() { }

  ngOnInit() {
  }

  log(numb) {
    this.rate = numb;
  }

}
