package com.example.helpdesk;

import java.util.ArrayList;
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
	
	private TicketResponse toResponse(Ticket ticket) {
	    return new TicketResponse(ticket.getTicketId(), ticket.getSubject(),
	            ticket.getDescription(), ticket.getPriority(), ticket.getStatus());
	}
	public List<TicketResponse> getTicket() {
	    List<TicketResponse> responses = new ArrayList<>();
	    for (Ticket ticket : ticketRepository.findAll()) {
	        responses.add(toResponse(ticket));
	    }
	    return responses;
	}

	public TicketResponse insertTicket(CreateTicketRequest request) {
	    Ticket ticket = new Ticket();
	    ticket.setSubject(request.subject());
	    ticket.setDescription(request.description());
	    ticket.setPriority(request.priority());
	    ticket.setStatus(Status.NEW);
	    return toResponse(ticketRepository.save(ticket));
	}

	public TicketResponse getTicketById(Long ticketId) {
	    Ticket ticket = ticketRepository.findById(ticketId)
	            .orElseThrow(() -> new IllegalStateException("Ticket " + ticketId + " not found"));
	    return toResponse(ticket);
	}
	
	
}
