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
	public void createTicket(Ticket ticket) {
		ticketRepository.save(ticket);
	}

	@Override
	public void updateTicket(Ticket ticket) {
		ticketRepository.save(ticket);
	}

	@Override
	public void deleteTicket(int ticketId) {
		ticketRepository.deleteById(ticketId);
	}

}
