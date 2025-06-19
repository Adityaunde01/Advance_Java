package com.crudrest.dayEleven.service;

import java.util.List;

import com.crudrest.dayEleven.dto.ContactDTO;

public interface ContactService {
		
	public ContactDTO getContactByID(String id);
	public ContactDTO getContactByFirstName(Integer id);
	public List<ContactDTO> getAllContacts();
	public List<ContactDTO> getAllContacts(Integer pageNo, Integer pageSize);
	public ContactDTO getContactByFirstName(String name);
	public Boolean addContact(ContactDTO contact);
	public List<ContactDTO> getContactLike(String like);
	public ContactDTO getContactByFullName(String firstName,String lastName);
}
