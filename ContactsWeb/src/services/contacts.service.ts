import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {Contact} from '../model/contact';
// import {HttpClient} from '@angular/common/http';

@Injectable()
export class ContactsService {
  constructor(public http: Http) { }
  // constructor(private http: HttpClient) { }

  getContacts(keyword: string, page: number, size: number) {
    return this.http.get('http://localhost:8081/searchContacts?k=' +
      keyword + '&size=' + size + '&page=' + page)
      .map (resp => resp.json());
  }

  getContact(id: number) {
    return this.http.get('http://localhost:8081/contacts/' + id)
      .map (resp => resp.json());
  }

   saveContacts(contact: Contact) {
     return this.http.post('http://localhost:8081/contacts', contact)
      .map (resp => resp.json());
  }

  updateContacts(contact: Contact) {
    return this.http.put('http://localhost:8081/contacts/' + contact.id, contact)
      .map (resp => resp.json());
  }

  deleteContacts(id: number) {
    return this.http.delete('http://localhost:8081/contacts/' + id)
      .map (resp => resp.json());
  }

  /*getAll() {
    return this.http.get<Contact[]>(`/contacts`);
  }*/

  register(contact: Contact) {
    return this.http.post(`http://localhost:8081/contacts/`, contact);
  }
}
