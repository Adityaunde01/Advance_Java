package com.crudrest.dayEleven.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudrest.dayEleven.dto.ContactDTO;
import com.crudrest.dayEleven.entity.Contact;
import com.crudrest.dayEleven.repository.ContactRepo;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	ContactRepo contacts;
	
	@Override
	public ContactDTO getContactByID(Integer id) {
		System.out.println("bef0re++++++++++++++++++"+id);
		Optional<Contact> optContact = contacts.findById(id);
		System.out.println("after++++++++++++++++++");
		
		if(!optContact.isEmpty()) {
			ContactDTO dtoContact = new ContactDTO();
			System.out.println(dtoContact);
			BeanUtils.copyProperties(optContact.get(), dtoContact);
			System.out.println(dtoContact);
			return dtoContact;
		}
		return null;
	}

	@Override
	public ContactDTO getContactByFirstName(Integer id) {
		return null;
	}

	@Override
	public List<ContactDTO> getAllContacts() {
		return null;
	}

	@Override
	public List<ContactDTO> getPageContact(Integer pageNo, Integer pageSize) {
		return null;
	}

}
