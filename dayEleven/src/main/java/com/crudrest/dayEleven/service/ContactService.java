package com.crudrest.dayEleven.service;

import java.util.List;

import com.crudrest.dayEleven.dto.ContactDTO;

public interface ContactService {
		
	public ContactDTO getContactByID(Integer id);
	public ContactDTO getContactByFirstName(Integer id);
	public List<ContactDTO> getAllContacts();
	public List<ContactDTO> getPageContact(Integer pageNo, Integer pageSize);
}
