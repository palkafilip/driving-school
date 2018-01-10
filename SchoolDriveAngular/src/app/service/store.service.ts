import { Injectable } from '@angular/core';
export interface Store {
  [key: string] : any;
}
@Injectable()
export class StoreService {

  constructor() { }

  public setRouteStore(store: Store): void {
    sessionStorage.setItem(location.pathname, JSON.stringify(store));
  }

  public getRouteStore(): Store {
    return JSON.parse(sessionStorage.getItem(location.pathname)) || {};
  }
}

