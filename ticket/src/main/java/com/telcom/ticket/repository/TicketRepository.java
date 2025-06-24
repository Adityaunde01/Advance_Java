package com.telcom.ticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.telcom.ticket.entity.Status;
import com.telcom.ticket.entity.Ticket;


//@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	
		@Query("select obj from Ticket obj where obj.status=:status")
		public List<Ticket> openTickets(@Param("status")Status status);

//	List<Ticket> findByStatus(Status status);
}
