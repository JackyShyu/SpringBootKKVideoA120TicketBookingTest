package org.shyu.springboot.service;

import org.shyu.springboot.model.Ticket;

public interface TicketService {
	public abstract Iterable<Ticket> getAllTickets();
	public abstract Ticket getTicketById(int ticketId);
	public abstract Ticket createTicket(Ticket ticket);
	public abstract Ticket updateTicket(Ticket ticket);
	public abstract boolean deleteTicket(int ticketId);
	public abstract Ticket getTicketByEmail(String email);
}
