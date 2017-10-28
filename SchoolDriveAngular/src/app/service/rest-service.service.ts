import { Injectable } from '@angular/core';
import {Http, RequestOptions} from '@angular/http';
import {Headers} from '@angular/http';
import {Observable} from "rxjs/Observable";
import 'rxjs/add/operator/map'
import "rxjs/add/operator/catch";

@Injectable()
export class RestService {

  ORIGIN = 'http://localhost:8080/rest/';

  constructor(private http: Http) { }

  GET(resource: string): Observable<any> {
    const url = this.ORIGIN + resource;
    const options = this.createRequestOptions("filip","password");

    return this.http
      .get(url, options)
      .map(res => res.json());
  }

  POST(resource: string, params: any): Observable<any> {
    const url = this.ORIGIN + resource;
    const options = this.createRequestOptions("filip","password");

    console.log(url);

    return this.http
      .post(url, params, options)
      .map(response => response.json());
  }

  createRequestOptions(login: string, password: string): RequestOptions {
    let headers = new Headers({
      'Authorization': 'Basic ' + btoa(`${login}:${password}`),
      'X-Requested-With': 'XMLHttpRequest' // to suppress 401 browser popup
    });

    let options = new RequestOptions({
      headers: headers
    });

    return options;
  }

}
