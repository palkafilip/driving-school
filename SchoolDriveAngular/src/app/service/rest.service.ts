import { Injectable } from '@angular/core';
import {Http, RequestOptions} from '@angular/http';
import {Headers} from '@angular/http';
import {Observable} from "rxjs/Observable";
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/map'
import "rxjs/add/operator/catch";

@Injectable()
export class RestService {

  ORIGIN = 'http://localhost:8080/rest/';

  constructor(private http: Http) { }

  GET(resource: string): Observable<any> {
    const url = this.ORIGIN + resource;

    return this.http
      .get(url, { withCredentials: true })
      .map(res => this.extractData(res))
      .catch(err => this.handleError(err));

  }

  POST(resource: string, params: any): Observable<any> {
    const url = this.ORIGIN + resource;

    return this.http
      .post(url, params, { withCredentials: true })
      .map(res => this.extractData(res))
      .catch(err => this.handleError(err));
  }

  POSTWithAuthorization(resource: string, login: string, password: string, params: any) {

    const url = this.ORIGIN + resource;
    const options = this.createRequestOptions(login, password);

    return this.http
      .post(url, params, options)
      .map(res => this.extractData(res))
      .catch(err => this.handleError(err));

  }

  GETWithAuthorization(resource: string, login: string, password: string) {
    const url = this.ORIGIN + resource;
    const options = this.createRequestOptions(login, password);

    return this.http
      .get(url, options)
      .map(res => this.extractData(res))
      .catch(err => this.handleError(err));
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

  private handleError (error: Response | any) {
    // let errMsg: string;
    // if (error instanceof Response) {
    //   const body = error.json() || '';
    //   const err = JSON.stringify(body);
    //   errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    // } else {
    //   errMsg = error.message ? error.message : error.toString();
    // }

    // console.log(error['_body']);
    // console.log(error.json());
    return Observable.throw(error);
  }

}
