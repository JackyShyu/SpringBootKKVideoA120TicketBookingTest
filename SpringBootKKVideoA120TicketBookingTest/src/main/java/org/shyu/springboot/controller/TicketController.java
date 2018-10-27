package org.shyu.springboot.controller;

import org.shyu.springboot.model.Ticket;
import org.shyu.springboot.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/tickets")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public Ticket createTicket(@RequestBody Ticket ticket) {
		return ticketService.createTicket(ticket);
	}
	
	@RequestMapping(value="/ticketId/{ticketId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Ticket getTicketById(@PathVariable("ticketId") int id) {
		return ticketService.getTicketById(id);
	}
	
	@RequestMapping(value="/allTickets", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Ticket> getAllTickets() {
		return ticketService.getAllTickets();
	}
	
	@RequestMapping(value="/ticketId/{ticketId}", method=RequestMethod.DELETE)
	public void deleteTicket(@PathVariable("ticketId") int id) {
		ticketService.deleteTicket(id);
	}
	
	@RequestMapping(value="/ticketId/{ticketId}/email/{newEmail:.+}", method=RequestMethod.PUT)
	public Ticket updateTicket(@PathVariable("ticketId") int id, @PathVariable("newEmail") String email) {
		Ticket ticketDB = getTicketById(id);
		ticketDB.setEmail(email);
		ticketService.updateTicket(ticketDB);
		return ticketDB;
	}
	
	@RequestMapping(value="/email/{email}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Ticket getTicketByEmail(@PathVariable("email") String email) {
		return ticketService.getTicketByEmail(email);
	}
}
