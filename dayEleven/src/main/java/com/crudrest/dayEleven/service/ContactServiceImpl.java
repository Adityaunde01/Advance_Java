package com.crudrest.dayEleven.service;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.crudrest.dayEleven.dto.ContactDTO;
import com.crudrest.dayEleven.entity.Contact;
import com.crudrest.dayEleven.repository.ContactRepo;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	ContactRepo contacts;
	
	@Override
	public ContactDTO getContactByID(String id) {	
		try {
			Integer cId = Integer.parseInt(id);
			System.out.println(cId);
			Optional<Contact> optContact = contacts.findById(cId);
		
		if(!optContact.isEmpty()) {
			ContactDTO dtoContact = new ContactDTO();
			BeanUtils.copyProperties(optContact.get(), dtoContact);
			return dtoContact;
		}
		} catch (Exception e) {
			e.printStackTrace(); 
				return null;
		}
		return null;
	}

	@Override
	public ContactDTO getContactByFirstName(Integer id) {
		return null;
	}

	@Override
	public List<ContactDTO> getAllContacts() {
		Iterator<Contact> contactIter = contacts.findAll().iterator();
		List<ContactDTO> contactDtoList = new ArrayList<>();
		while(contactIter.hasNext()) {
			Contact contact = contactIter.next(); 
		    ContactDTO dtoContact = new ContactDTO();
		    BeanUtils.copyProperties(contact, dtoContact);
		    contactDtoList.add(dtoContact);
		    
		}
		
		
		return contactDtoList;
	}
	

	@Override
	public List<ContactDTO> getAllContacts(Integer pageNo, Integer pageSize) {
		
		Sort sortLastName = Sort.by("firstName");
		Pageable page = PageRequest.of(pageNo, pageSize,sortLastName);
		Iterator<Contact> contactIter = contacts.findAll(page).iterator();
		List<ContactDTO> contactDtoList = new ArrayList<>();
		while(contactIter.hasNext()) {
			Contact contact = contactIter.next(); 
		    ContactDTO dtoContact = new ContactDTO();
		    BeanUtils.copyProperties(contact, dtoContact);
		    contactDtoList.add(dtoContact);
		}
		
		return contactDtoList;
	}

	@Override
	public ContactDTO getContactByFirstName(String name) {
		Contact contact = contacts.findByFirstName(name);
		ContactDTO contactDto = new ContactDTO();
		BeanUtils.copyProperties(contact, contactDto);
		return contactDto;
	}

	@Override
	public Boolean addContact(ContactDTO contactDto) {
		Contact contact = new Contact();
		BeanUtils.copyProperties(contactDto, contact);
		contacts.save(contact);
		return true;
	}

	@Override
	public List<ContactDTO> getContactLike(String like) {
		Iterator<Contact> contact =  contacts.getContactLike(like).iterator();
		List<ContactDTO> contactDtoList = new ArrayList<ContactDTO>();
		
		while(contact.hasNext()) {
		Contact contactI = contact.next();
		ContactDTO contactDto = new ContactDTO();
		BeanUtils.copyProperties(contactI, contactDto);	
		contactDtoList.add(contactDto);
		}
		
		return contactDtoList;
	}

	@Override
	public ContactDTO getContactByFullName(String firstName, String lastName) {
		Contact contact = contacts.findContactbyFullName(firstName, lastName);
		ContactDTO contactDto = new ContactDTO();
		BeanUtils.copyProperties(contact, contactDto);
		return contactDto;
	}

}
