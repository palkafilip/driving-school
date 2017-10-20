import { Injectable } from '@angular/core';
import {Http, RequestOptions} from '@angular/http';
import {Headers} from '@angular/http';

@Injectable()
export class RestService {

  ORIGIN = 'http://localhost:8080/rest/';

  constructor(private http: Http) { }

  GET(resource: string): Promise<any> {

    let headers = new Headers({
      'Authorization': 'Basic ' + btoa('filip:password'),
      'X-Requested-With': 'XMLHttpRequest' // to suppress 401 browser popup
    });

    let options = new RequestOptions({
      headers: headers,
      withCredentials: true,
    });

    const url = this.ORIGIN + resource;

    return this.http
      .get(url, options)
      .toPromise()
      .then(response => response.json())
      .catch(err => console.log(err));
  }

  POST(resource: string, params: any): Promise<any> {

    let headers = new Headers({
      'Authorization': 'Basic ' + btoa('filip:password'),
      'X-Requested-With': 'XMLHttpRequest' // to suppress 401 browser popup
    });

    let options = new RequestOptions({
      headers: headers
    });

    const url = this.ORIGIN + resource;

    return this.http
      .post(url, params, options)
      .toPromise()
      .then(response => response.json());
  }

}
