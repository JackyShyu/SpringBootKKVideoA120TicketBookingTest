package org.shyu.springboot.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.shyu.springboot.model.Ticket;
import org.shyu.springboot.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketServiceTest {
	@Autowired
	private TicketService ticketService;
	
	@MockBean
	private TicketRepository ticketRepository;
	
	@Test
	public void testGetAllTickets() {
		Ticket ticket1 = getTicket1();
		Ticket ticket2 = getTicket2();
		List<Ticket> ticketList = new ArrayList<>();
		ticketList.add(ticket1);
		ticketList.add(ticket2);
		
		Mockito.when(ticketRepository.findAll()).thenReturn(ticketList);
		assertThat(ticketService.getAllTickets()).isEqualTo(ticketList);
	}
	
	@Test
	public void testGetTicketById() {
		Ticket ticket1 = getTicket1();
		Mockito.when(ticketRepository.findById(1)).thenReturn(Optional.of(ticket1));
		assertThat(ticketService.getTicketById(1)).isEqualTo(ticket1);
	}
	
	@Test
	public void testCreateTicket() {
		Ticket ticket1 = getTicket1();
		Mockito.when(ticketRepository.save(ticket1)).thenReturn(ticket1);
		assertThat(ticketService.createTicket(ticket1)).isEqualTo(ticket1);
	}
	
	@Test
	public void testUpdateTicket() {
		Ticket ticket1 = getTicket1();
		ticket1.setEmail("JackyUpdated@Gmail.com");
		Mockito.when(ticketRepository.save(ticket1)).thenReturn(ticket1);
		assertThat(ticketService.updateTicket(ticket1)).isEqualTo(ticket1);
	}
	
	@Test
	public void testGetTicketByEmail() {
		Ticket ticket1 = getTicket1();
		Mockito.when(ticketRepository.findByEmail("Jacky@Gmail.com")).thenReturn(ticket1);
		assertThat(ticketService.getTicketByEmail("Jacky@Gmail.com")).isEqualTo(ticket1);
	}
	
	@Test
	public void testDeleteTicketTrueAndFalse() {
		Ticket ticket1 = getTicket1();
		Mockito.when(ticketRepository.existsById(ticket1.getTicketId())).thenReturn(true);
		assertThat(ticketService.deleteTicket(ticket1.getTicketId())).isEqualTo(true);
		
		Mockito.when(ticketRepository.existsById(ticket1.getTicketId())).thenReturn(false);
		assertThat(ticketService.deleteTicket(ticket1.getTicketId())).isEqualTo(false);
	}
	
	private Ticket getTicket1() {
		Ticket ticket = new Ticket();
		ticket.setTicketId(1);
		ticket.setBookingDate(new Date());
		ticket.setDestinationStation("DFW");
		ticket.setEmail("Jacky@Gmail.com");
		ticket.setPassengerName("Jacky");
		ticket.setSourceStation("LA");
		return ticket;
	}
	
	private Ticket getTicket2() {
		Ticket ticket = new Ticket();
		ticket.setTicketId(2);
		ticket.setBookingDate(new Date());
		ticket.setDestinationStation("DFW");
		ticket.setEmail("Lee@Gmail.com");
		ticket.setPassengerName("Lee");
		ticket.setSourceStation("LA");
		return ticket;
	}
}
