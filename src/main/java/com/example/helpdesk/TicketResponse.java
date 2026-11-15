package com.example.helpdesk;

public record TicketResponse(Long ticketId, String subject, String description,Priority priority, Status status) {

}
 