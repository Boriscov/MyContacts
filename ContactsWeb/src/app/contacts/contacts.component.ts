import { Component, OnInit } from '@angular/core';
// import {Http} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import {ContactsService} from '../../services/contacts.service';
import {Router} from '@angular/router';
import {Contact} from '../../model/contact';
import {HttpClient} from '@angular/common/http';


@Component({
  // Tags to use if one need to insert this component in a html page.
  selector: 'app-c',
  templateUrl: './contacts.component.html',
  styleUrls: ['./contacts.component.css']
})
export class ContactsComponent implements OnInit {

  pageContacts: HTMLMetaElement;
  // pageContacts2: HTMLMetaElement;
  keyword = '';
  currentPage = 0;
  size = 5;
  pages: Array<number>;
  constructor(public http: HttpClient, public  contactservice: ContactsService,
              public router: Router) { }

  ngOnInit() {
    // when one send a request to the server , it will send
    // it and subscribe to the observable so that when the data will come it will manage it
    /*this.http.get('http://localhost:8080/searchContacts?k=m&size=5&page=0')
      .map (resp => resp.json())
      .subscribe(data => {
        this.pageContacts = data;
      }, err => {
        console.log(err);
      });*/


  }

  doSearch() {
    this.contactservice.getContacts(this.keyword, this.currentPage, this.size)
      .subscribe(data => {
        this.pageContacts = data;  // returned data are pageContatcts
        this.pages = new Array(data.totalPages); // number of pages, since backend return this attribut in pageContacts.
      }, err => {
        console.log(err);
      });

  }
  search() {
    this.doSearch();
  }

  gotoPage(i: number) {
    this.currentPage = i;
    this.doSearch();
  }

  onEditContact(id: number) {
    this.router.navigate(['editContact', id]);
  }


  onDeleteContact(c: Contact) {
    const confirm = window.confirm('Are you sure you want to delete?');
    // tslint:disable-next-line:triple-equals
    if (confirm == true) {
      this.contactservice.deleteContacts(c.id)
        .subscribe(data => {
          // @ts-ignore
          this.pageContacts.content.splice(
            this.pageContacts.content.indexOf(c.lastName), 1
          );
        }, err => {
          console.log(err);
        });
    }

  }

}
