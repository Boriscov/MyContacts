import { Injectable } from '@angular/core';
import { HttpRequest, HttpResponse, HttpHandler, HttpEvent, HttpInterceptor, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Observable, of, throwError } from 'rxjs';
import { delay, mergeMap, materialize, dematerialize } from 'rxjs/operators';

// array in local storage for registered contacts
let contacts = JSON.parse(localStorage.getItem('contacts')) || [];

@Injectable()
export class FakeBackendInterceptor implements HttpInterceptor {
  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const { url, method, headers, body } = request;

    // wrap in delayed observable to simulate server api call
    return of(null)
      .pipe(mergeMap(handleRoute))
      // tslint:disable-next-line:max-line-length
      .pipe(materialize()) // call materialize and dematerialize to ensure delay even if an error is thrown (https://github.com/Reactive-Extensions/RxJS/issues/648)
      .pipe(delay(500))
      .pipe(dematerialize());

    function handleRoute() {
      switch (true) {
        case url.endsWith('/contacts/authenticate') && method === 'POST':
          return authenticate();
        case url.endsWith('/contacts/register') && method === 'POST':
          return register();
        case url.endsWith('/contacts') && method === 'GET':
          return getUsers();
        case url.match(/\/contacts\/\d+$/) && method === 'DELETE':
          return deleteUser();
        default:
          // pass through any requests not handled above
          return next.handle(request);
      }
    }

    // route functions

    function authenticate() {
      const { email, password } = body;
      const contact = contacts.find(x => x.email === email && x.password === password);
      if (!contact) { return error('Username or password is incorrect'); }
      return ok({
        id: contact.id,
        email: contact.email,
        firstName: contact.firstName,
        lastName: contact.lastName,
        token: 'fake-jwt-token'
      });
    }

    function register() {
      const contact = body;

      if (contacts.find(x => x.email === contact.email)) {
        return error('Email "' + contact.email + '" is already taken');
      }

      contact.id = contacts.length ? Math.max(...contacts.map(x => x.id)) + 1 : 1;
      contacts.push(contact);
      localStorage.setItem('contacts', JSON.stringify(contacts));

      return ok();
    }

    function getUsers() {
      if (!isLoggedIn()) { return unauthorized(); }
      return ok(contacts);
    }

    function deleteUser() {
      if (!isLoggedIn()) { return unauthorized(); }

      contacts = contacts.filter(x => x.id !== idFromUrl());
      localStorage.setItem('contacts', JSON.stringify(contacts));
      return ok();
    }

    // helper functions

    // tslint:disable-next-line:no-shadowed-variable
    function ok(body?) {
      return of(new HttpResponse({ status: 200, body }));
    }

    function error(message) {
      return throwError({ error: { message } });
    }

    function unauthorized() {
      return throwError({ status: 401, error: { message: 'Unauthorised' } });
    }

    function isLoggedIn() {
      return headers.get('Authorization') === 'Bearer fake-jwt-token';
    }

    function idFromUrl() {
      const urlParts = url.split('/');
      // tslint:disable-next-line:radix
      return parseInt(urlParts[urlParts.length - 1]);
    }
  }
}

export const fakeBackendProvider = {
  // use fake backend in place of Http service for backend-less development
  provide: HTTP_INTERCEPTORS,
  useClass: FakeBackendInterceptor,
  multi: true
};
