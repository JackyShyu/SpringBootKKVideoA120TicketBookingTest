package org.shyu.springboot.service;

import org.shyu.springboot.model.Ticket;

public interface TicketService {
	public abstract Iterable<Ticket> getAllTickets();
	public abstract Ticket getTicketById(int ticketId);
	public abstract void createTicket(Ticket ticket);
	public abstract void updateTicket(Ticket ticket);
	public abstract void deleteTicket(int ticketId);
}
