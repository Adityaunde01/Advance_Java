package com.telcom.ticket.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telcom.ticket.entity.Ticket;
import com.telcom.ticket.service.TicketService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {
	
	@Autowired
	TicketService ticketService;
	
	@PostMapping("/create")
	public ResponseEntity<String> createTable(@Valid @RequestBody Ticket ticet) {
		String message = ticketService.createTicket(ticet);
		return ResponseEntity.status(HttpStatus.CREATED).body(message) ;
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateTicket(@Valid @RequestParam("id") Integer id , @Valid @RequestBody Ticket ticet) {
		String message = ticketService.updateTicket(ticet,id);
		return ResponseEntity.status(HttpStatus.OK).body(message) ;
	}
	
	
	@GetMapping("/ticket/{id}")
	public ResponseEntity<Ticket> getTicket(@Valid @PathVariable Integer id) {
		Ticket tickets = ticketService.getTicketbyID(id);
		return ResponseEntity.status(HttpStatus.OK).body(tickets) ;
	}
	
	@GetMapping("/open")
	public ResponseEntity<List<Ticket>> getOpenTicket() {
		List<Ticket> tickets = ticketService.getOpenTickets();
		return ResponseEntity.status(HttpStatus.OK).body(tickets) ;
	}
	
		
	

}
