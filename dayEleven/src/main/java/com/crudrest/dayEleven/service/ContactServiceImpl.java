package com.crudrest.dayEleven.service;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.crudrest.dayEleven.dto.ContactDTO;
import com.crudrest.dayEleven.entity.Contact;
import com.crudrest.dayEleven.exception.Resource404Exception;
import com.crudrest.dayEleven.repository.ContactRepo;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	ContactRepo contacts;
	
	@Override
	public ContactDTO getContactByID(String id) {	
	
			Integer cId = Integer.parseInt(id);
			System.out.println(cId);
		Contact optContact = contacts.findById(cId).orElseThrow(()->new Resource404Exception("No contact Found"));
		
		
			ContactDTO dtoContact = new ContactDTO();
			BeanUtils.copyProperties(optContact, dtoContact);
			return dtoContact;
		
	
	
	}

	@Override
	public ContactDTO getContactByFirstName(Integer id) {
		return null;
	}

	@Override
	public List<ContactDTO> getAllContacts() {
		try {
			return contacts.findAll().stream().map(contact->{
				ContactDTO dto = new ContactDTO();
				BeanUtils.copyProperties(contact, dto);
				return dto;
			}).collect(Collectors.toList());
		} catch (Exception e) {
			throw new RuntimeException("Cant Fetch Contacts: "+e.getMessage(),e);
		}
	}
	

	@Override
	public List<ContactDTO> getAllContacts(Integer pageNo, Integer pageSize) {
		/*Sort sortLastName = Sort.by("firstName");
		Pageable page = PageRequest.of(pageNo, pageSize,sortLastName);
		Iterator<Contact> contactIter = contacts.findAll(page).iterator();
		List<ContactDTO> contactDtoList = new ArrayList<>();
		while(contactIter.hasNext()) {
			Contact contact = contactIter.next(); 
		    ContactDTO dtoContact = new ContactDTO();
		    BeanUtils.copyProperties(contact, dtoContact);
		    contactDtoList.add(dtoContact);
		}
		*/
		try {
			Pageable page = PageRequest.of(pageNo,pageSize);
			return contacts.findAll(page).stream().map(contact->{
				ContactDTO dto = new ContactDTO();
				BeanUtils.copyProperties(contact, dto);
				
				return dto;
			}).collect(Collectors.toList());
		} catch (Exception e) {
			throw new RuntimeException("Cant Fetch Contacts: "+e.getMessage(),e);
		}
		
	}

	@Override
	public ContactDTO getContactByFirstName(String name) {
		Contact contact = contacts.findByFirstName(name);
		if(contact == null)
			throw new Resource404Exception("No user of name: "+ name);
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
		if(contact == null)
			throw new Resource404Exception("none match the contact name like: "+ like);
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
		if(contact == null)
			throw new Resource404Exception("No user of name: "+ firstName + " " + lastName);
		ContactDTO contactDto = new ContactDTO();
		BeanUtils.copyProperties(contact, contactDto);
		return contactDto;
	}

}
