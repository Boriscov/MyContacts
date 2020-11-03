import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { Contact } from 'C:/Users/LENOVO/WS-ANG/ContactsWeb/src/model';

@Injectable({ providedIn: 'root' })
export class AuthenticationService {
  private currentUserSubject: BehaviorSubject<Contact>;
  public currentUser: Observable<Contact>;

  constructor(private http: HttpClient) {
    this.currentUserSubject = new BehaviorSubject<Contact>(JSON.parse(localStorage.getItem('currentUser')));
    this.currentUser = this.currentUserSubject.asObservable();
  }

  public get currentContactValue(): Contact {
    return this.currentUserSubject.value;
  }

  login(email: string, password: string) {
    return this.http.post<any>(`/contacts/authenticate`, { email, password })
      .pipe(map(contact => {
        // login successful if there's a jwt token in the response
        if (contact && contact.token) {
          // store contact details and jwt token in local storage to keep contact logged in between page refreshes
          localStorage.setItem('currentUser', JSON.stringify(contact));
          this.currentUserSubject.next(contact);
        }

        return contact;
      }));
  }

  logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('currentUser');
    this.currentUserSubject.next(null);
  }
}
