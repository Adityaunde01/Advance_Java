package com.crudrest.dayEleven.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crudrest.dayEleven.dto.ContactDTO;
import com.crudrest.dayEleven.exception.Resource404Exception;
import com.crudrest.dayEleven.service.ContactService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;

@RestController
public class ContactMService {
	
	@Autowired
	ContactService contactService;
	
	@GetMapping("/{user}")
	public String authenticate(@PathVariable("user")String user, HttpSession session) {
		session.setAttribute("userObj", user);
		
		return "user added and authenticated: " + user;
	}
	
	@GetMapping("/contact/{id}")
	public ContactDTO getContactById(@PathVariable(name = "id")String id,HttpSession session) {
		if(session.getAttribute("userObj") == null)
			throw new Resource404Exception("the session has expired go to root url");
		ContactDTO contact = contactService.getContactByID(id);
		
		return contact;
	}
	
	@GetMapping("/contactByName")
	public ContactDTO getContactByFirstName(@RequestParam(name = "firstname")String id,HttpSession session) {
		if(session.getAttribute("userObj") == null)
			throw new Resource404Exception("the session has expired go to root url");
		ContactDTO contact = contactService.getContactByFirstName(id);
		
		return contact;
	}
	
	@GetMapping("/contactByName/{firstname}/{lastName}")
	public ContactDTO getContactByFirstName(@PathVariable(name = "firstname")String firstName,@PathVariable("lastName")String lastName) {
		ContactDTO contact = contactService.getContactByFullName(firstName,lastName);
		
		return contact;
	}
	
	@GetMapping("/contactNameLike/{firstname}")
	public List<ContactDTO> getContactNameLike(@PathVariable(name = "firstname")String id) {
		List<ContactDTO> contact = contactService.getContactLike(id);
		
		return contact;
	}
	
	@GetMapping("/allContacts")
	public List<ContactDTO> getAllContacts() {
		
		return contactService.getAllContacts();
	}
	
	@GetMapping("/allContacts/{pageNo}/{pageSize}")
	public List<ContactDTO> getAllContacts(@PathVariable("pageNo")Integer pageNo, @PathVariable("pageSize")Integer pageSize) {
		
		return contactService.getAllContacts(pageNo-1, pageSize);
	}
	
	
	@PostMapping("/addContact")
	public Boolean addContact(@RequestBody ContactDTO contact) {
		return contactService.addContact(contact);
	}

}
