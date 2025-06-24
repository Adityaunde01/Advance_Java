package com.telcom.ticket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telcom.ticket.entity.Status;
import com.telcom.ticket.entity.Ticket;
import com.telcom.ticket.exception.ResourceNotFound;
import com.telcom.ticket.repository.TicketRepository;

@Service
public class TicketService {
	
	@Autowired
	TicketRepository ticketRepo;
	
	 public String createTicket(Ticket ticket) {
	        ticketRepo.save(ticket);
	        return "Created a Ticket";
	 }
	 
	 public String updateTicket(Ticket ticket,Integer id) {
		    Ticket dbTicket = ticketRepo.findById(id)
		        .orElseThrow(() -> new ResourceNotFound("No ticket found with id " + id));

		    // Only update non-null fields
		    if (ticket.getPhoneNum() != null) {
		        dbTicket.setPhoneNum(ticket.getPhoneNum());
		    }

		    if (ticket.getCategory() != null) {
		        dbTicket.setCategory(ticket.getCategory());
		    }

		    if (ticket.getIssueDetails() != null) {
		        dbTicket.setIssueDetails(ticket.getIssueDetails());
		    }

		    if (ticket.getResolutionDetails() != null) {
		        dbTicket.setResolutionDetails(ticket.getResolutionDetails());
		    }

		    if (ticket.getStatus() != null) {
		        dbTicket.setStatus(ticket.getStatus());
		    }

		    if (ticket.getResuDate() != null) {
		        dbTicket.setResuDate(ticket.getResuDate());
		    }

		    // Don’t allow client to update CreatedDate — keep original

		    ticketRepo.save(dbTicket);
		    return "Ticket updated";
		}

	 
	 
	 public Ticket getTicketbyID(Integer id) {
		 Ticket ticket =  ticketRepo.findById(id).orElseThrow(()->new ResourceNotFound("No ticket found with id"+id));

			return ticket;
	 }
	 
	 public List<Ticket> getOpenTickets(){
		 List<Ticket> tickets = ticketRepo.openTickets(Status.OPEN);
		 if(tickets == null)
			 throw new ResourceNotFound("No Open Ticket Found");
		 
		 
		 return tickets;
	 }
	 
	
}
