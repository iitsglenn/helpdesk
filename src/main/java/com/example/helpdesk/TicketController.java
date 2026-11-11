package com.example.helpdesk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Tickets")
public class TicketController {
	
	
	private final TicketService ticketService;
	
	@Autowired
	public TicketController(TicketService ticketService) {
	    this.ticketService = ticketService;
	}
	@GetMapping
	public List<Ticket> getAllTicket() {
		return ticketService.getTicket();
	}
	
	@GetMapping("{ticketId}")
	public Ticket getTicketById(@PathVariable Long ticketId) {
		return ticketService.getTicketById(ticketId);
	}
	
	@PostMapping
	public void addNewTicket(@RequestBody Ticket ticket) {
		ticketService.insertTicket(ticket);
	}
}
