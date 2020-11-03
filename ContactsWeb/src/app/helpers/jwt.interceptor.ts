import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';

import { AuthenticationService } from 'C:/Users/LENOVO/WS-ANG/ContactsWeb/src/services';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {
  constructor(private authenticationService: AuthenticationService) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    // add authorization header with jwt token if available
    const currentContact = this.authenticationService.currentContactValue;
    if (currentContact && currentContact.token) {
      request = request.clone({
        setHeaders: {
          Authorization: `Bearer ${currentContact.token}`
        }
      });
    }

    return next.handle(request);
  }
}
