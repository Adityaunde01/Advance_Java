package com.crudrest.dayEleven.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudrest.dayEleven.entity.Contact;

public interface ContactRepo extends JpaRepository<Contact, Integer> {

}
