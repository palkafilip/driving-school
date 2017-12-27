// This impl. bases upon one that can be found in the router's test cases.
import {ActivatedRouteSnapshot, DetachedRouteHandle, RouteReuseStrategy} from "@angular/router";
export class CustomReuseStrategy implements RouteReuseStrategy {

  private handlers: {[key: string]: DetachedRouteHandle} = {};


  constructor() {

  }

  shouldDetach(route: ActivatedRouteSnapshot): boolean {
    return true;
  }

  store(route: ActivatedRouteSnapshot, handle: DetachedRouteHandle): void {
    this.handlers[route.parent.url.join("/")] = handle;
  }

  shouldAttach(route: ActivatedRouteSnapshot): boolean {
    return !!this.handlers['url'];
  }

  retrieve(route: ActivatedRouteSnapshot): DetachedRouteHandle {
    return this.handlers[route.url.join("/") || route.parent.url.join("/")];
  }

  shouldReuseRoute(future: ActivatedRouteSnapshot, curr: ActivatedRouteSnapshot): boolean {
    return future.routeConfig === curr.routeConfig;
  }

}
