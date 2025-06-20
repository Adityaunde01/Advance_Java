package com.crudrest.dayEleven.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.crudrest.dayEleven.entity.Contact;
import com.crudrest.dayEleven.exception.Resource404Exception;

public interface ContactRepo extends JpaRepository<Contact, Integer> {
		
	public Contact findByFirstName(String firstName) throws Resource404Exception;
	@Query(value = "select obj from Contact obj where obj.firstName like :cri%")
	public List<Contact> getContactLike(@Param("cri")String Like);
	@Query(value = "select * from contact where first_name =:fname and last_name =:lname",nativeQuery = true)
	public Contact findContactbyFullName(@Param("fname")String firstName,@Param("lname")String lastName);
}
