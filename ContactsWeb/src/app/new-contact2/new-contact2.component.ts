import { Component, OnInit } from '@angular/core';
import {ContactsService} from '../../services/contacts.service';

@Component({
  selector: 'app-new-contact2',
  templateUrl: './new-contact2.component.html',
  styleUrls: ['./new-contact2.component.css']
})
export class NewContact2Component implements OnInit {

  constructor(public contactsService: ContactsService) { }

  ngOnInit() {
  }

  onSaveContact(dataForm) {
    this.contactsService.saveContacts(dataForm)
      .subscribe(data => {
      console.log('OK');
    }, err => {
        // to display the error message
      console.log(JSON.parse(err._body).message);
    });
  }

}
