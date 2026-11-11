package com.example.helpdesk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
	
	private final TicketRepository ticketRepository;

	@Autowired
	public TicketService(com.example.helpdesk.TicketRepository ticketRepository) {
		super();
		this.ticketRepository = ticketRepository;
	}
	
	public List<Ticket> getTicket(){
		return ticketRepository.findAll();
	}


	public void insertTicket(Ticket ticket) {
		ticket.setStatus(Status.NEW);
		ticketRepository.save(ticket);
	}

	public Ticket getTicketById(Long ticketId) {
		return ticketRepository.findById(ticketId)
				.orElseThrow(() -> new IllegalStateException(
						ticketId + "not found"));
	}
	
	
	
}
