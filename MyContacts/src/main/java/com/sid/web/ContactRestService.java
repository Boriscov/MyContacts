package com.sid.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sid.dao.ContactRepository;
import com.sid.entities.Contact;

@RestController
@CrossOrigin("*")
public class ContactRestService {
	
	@Autowired
	private ContactRepository contactrepository;
	
	//method to retun the list of all contact
	//to access this method with a httprequest one need this annotation
	@RequestMapping(value="/contacts", method=RequestMethod.GET)
	public List<Contact> getContacts(){
		return contactrepository.findAll();
	}
	
	//method to find a contact
	@RequestMapping(value="/contacts/{id}", method=RequestMethod.GET)
	public Optional<Contact> getContacts(@PathVariable Long id){
		return contactrepository.findById(id);
	}
	
	@RequestMapping(value="/searchContacts", method=RequestMethod.GET)
	public Page<Contact> search(@RequestParam(name="k", defaultValue = "") String k, 
								@RequestParam(name="page", defaultValue = "0")int page,
								@RequestParam(name="size", defaultValue = "5")int size){
		return contactrepository.search("%"+k+"%", PageRequest.of(page, size));
	}

	/*
	 * Use arc(advanced rest client): a google (chrome) api for http request method(get, post, put, ...) testing.
	 * Indeed, some http request method can not be tested just by writing the url in the adress. One need sometime api like arc for that.
	 * Content-type(application/json): the body of my request content data in json format
	 * accept (application/json): send me the result in json format
	 * x-auth-token: authentification token  to secure each  httpRequest. One need an authen with a username and password to get it
	 * */
	//method to add a contact
	@RequestMapping(value="/contacts", method=RequestMethod.POST)
	//@requestbody means here check in the httprequest, take the data in json format and save it in the object contact
	public Contact add(@RequestBody Contact c){
		return contactrepository.save(c);
	}
	
	//delete method
	@RequestMapping(value="/contacts/{id}", method=RequestMethod.DELETE)
	public boolean delete(@PathVariable Long id){
		contactrepository.deleteById(id);
		return true;
	}
	
	//update method
	@RequestMapping(value="/contacts/{id}", method=RequestMethod.PUT)
	@DeleteMapping("/employees/{id}")
	public Contact update(@PathVariable Long id, @RequestBody Contact c){
		c.setId(id);
		return contactrepository.save(c);
	}
	
	
}
