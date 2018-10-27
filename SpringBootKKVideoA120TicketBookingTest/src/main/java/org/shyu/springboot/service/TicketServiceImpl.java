package org.shyu.springboot.service;

import org.shyu.springboot.model.Ticket;
import org.shyu.springboot.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public Iterable<Ticket> getAllTickets() {
		return ticketRepository.findAll();
	}

	@Override
	public Ticket getTicketById(int ticketId) {
		return ticketRepository.findById(ticketId).get();
	}

	@Override
	public Ticket createTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	@Override
	public Ticket updateTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	@Override
	public boolean deleteTicket(int ticketId) {
		boolean isDeleted = false;
		if (ticketRepository.existsById(ticketId)) {
			ticketRepository.deleteById(ticketId);
			isDeleted = true;
		}
		return isDeleted;
	}

	@Override
	public Ticket getTicketByEmail(String email) {
		return ticketRepository.findByEmail(email);
	}

}
