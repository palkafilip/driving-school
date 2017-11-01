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

    return this.http
      .get(url)
      .map(res => res.json());
  }

  POST(resource: string, params: any): Observable<any> {
    const url = this.ORIGIN + resource;

    return this.http
      .post(url, params)
      .map(response => response.json());
  }

  POSTWithAuthorization(resource: string, login: string, password: string, params: any) {

    const url = this.ORIGIN + resource;
    const options = this.createRequestOptions(login, password);

    return this.http
      .post(url, params, options)
      .map(response => response.json());
  }

  GETWithAuthorization(resource: string, login: string, password: string) {
    const url = this.ORIGIN + resource;
    const options = this.createRequestOptions(login, password);

    return this.http
      .get(url, options)
      .map(res => this.extractData(res))
  }

  private createRequestOptions(login: string, password: string): RequestOptions {
    let headers = new Headers({
      'Authorization': 'Basic ' + btoa(`${login}:${password}`),
      'X-Requested-With': 'XMLHttpRequest' // to suppress 401 browser popup
    });

    let options = new RequestOptions({
      headers: headers,
      withCredentials: true,
    });

    return options;
  }

  private extractData(res: any) {
    return res.text() ? res.json() : {};
  }

}
