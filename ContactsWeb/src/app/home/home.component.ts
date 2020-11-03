import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { first } from 'rxjs/operators';

import { Contact } from 'C:/Users/LENOVO/WS-ANG/ContactsWeb/src/model';
import { ContactsService, AuthenticationService } from 'C:/Users/LENOVO/WS-ANG/ContactsWeb/src/services';

@Component({ templateUrl: 'home.component.html' })
export class HomeComponent implements OnInit, OnDestroy {
  currentContact: Contact;
  currentContactSubscription: Subscription;
  contacts: Contact[] = [];

  constructor(
    private authenticationService: AuthenticationService,
    private contactsService: ContactsService
  ) {
    this.currentContactSubscription = this.authenticationService.currentUser.subscribe(user => {
      this.currentContact = user;
    });
  }

  ngOnInit() {
    // this.loadAllUsers();
  }

  ngOnDestroy() {
    // unsubscribe to ensure no memory leaks
    this.currentContactSubscription.unsubscribe();
  }

  /*deleteUser(id: number) {
    this.contactsService.delete(id).pipe(first()).subscribe(() => {
      this.loadAllUsers();
    });
  }

  private loadAllUsers() {
    this.contactsService.getAll().pipe(first()).subscribe(users => {
      this.contacts = users;
    });
  }*/
}
