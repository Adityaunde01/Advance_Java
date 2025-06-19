package com.crudrest.dayEleven.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudrest.dayEleven.dto.ContactDTO;
import com.crudrest.dayEleven.service.ContactService;

@RestController
public class ContactMService {
	
	@Autowired
	ContactService contactService;
	
	@GetMapping("/contact/{id}")
	public ContactDTO getContactById(@PathVariable(name = "id")String id) {
		try {
			Integer cId = Integer.parseInt(id);
			System.out.println(cId);
			ContactDTO optContact = contactService.getContactByID(cId);
			System.out.println(optContact);
			return optContact;
		} catch (Exception e) {
			e.printStackTrace(); 
				return null;
		}	
	}
	
	@GetMapping("/allContacts")
	public String getAllContacts() {
		
		return "getting contacts";
	}

}
