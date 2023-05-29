import { CookieService } from 'ngx-cookie-service';
import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from 'express';

@Injectable()
export class JwtInterceptorInterceptor implements HttpInterceptor {

  constructor(private cookieService:CookieService, private router:Router) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    const token: string = this.cookieService.get('token');
    let req = request;
    if(token){
      req = request.clone({
        setHeaders: {
          authorization: `Bearer ${token}`
        }
      })
    }
    return next.handle(req);
  }
}
