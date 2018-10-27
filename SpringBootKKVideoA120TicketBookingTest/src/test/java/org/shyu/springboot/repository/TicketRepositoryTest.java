package org.shyu.springboot.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shyu.springboot.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TicketRepositoryTest {
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Test
	public void testCreateTicket() {
		Ticket ticket = getTicket();
		Ticket ticketInDB = entityManager.persist(ticket);
		Ticket ticketFromDB = ticketRepository.findById(ticket.getTicketId()).get();
		
		assertThat(ticketFromDB).isEqualTo(ticketInDB);
	}
	
	@Test
	public void testGetTicketById() {
		Ticket ticket = getTicket();
		Ticket ticketInDB = entityManager.persist(ticket);
		Ticket ticketFromDB = ticketRepository.findById(ticket.getTicketId()).get();
		
		assertThat(ticketFromDB).isEqualTo(ticketInDB);
	}
	
	@Test
	public void testGetAllTickets() {
		Ticket ticket1 = getTicket1();
		entityManager.persist(ticket1);
		Ticket ticket2 = getTicket2();
		entityManager.persist(ticket2);
		
		Iterable<Ticket> tickets = ticketRepository.findAll();
		List<Ticket> ticketsList = new ArrayList<>();
		for (Ticket ticketIterable: tickets) {
			ticketsList.add(ticketIterable);
		}
		assertThat(ticketsList.size()).isEqualTo(2);
	}
	
	@Test
	public void testDeleteTicket() {
		Ticket ticket = getTicket();
		Ticket ticketInDB = entityManager.persist(ticket);
		Ticket ticketFromDB = ticketRepository.findById(ticket.getTicketId()).get();
		assertThat(ticketFromDB).isEqualTo(ticketInDB);
		
		ticketRepository.delete(ticket);
		Optional<Ticket> ticketFromDBAfterDeleted = ticketRepository.findById(ticket.getTicketId());
		assertThat(ticketFromDBAfterDeleted).isEqualTo(Optional.empty());
	}
	
	@Test
	public void testUpdateTicket() {
		String newEmail = "JackyUpdated@gmail.com";
		Ticket ticket = getTicket();
		Ticket ticketInDB = entityManager.persist(ticket);
		ticketInDB.setEmail(newEmail);
		
		ticketRepository.save(ticketInDB);
		Ticket ticketFromDB = ticketRepository.findById(ticket.getTicketId()).get();
		assertThat(ticketFromDB.getEmail()).isEqualTo(newEmail);
	}
	
	@Test
	public void testGetTicketByEmail() {
		Ticket ticket = getTicket();
		entityManager.persist(ticket);
		Ticket ticketFromDB = ticketRepository.findByEmail(ticket.getEmail());
		assertThat(ticketFromDB.getTicketId()).isEqualTo(1);
	}

	private Ticket getTicket() {
		Ticket ticket = new Ticket();
		ticket.setTicketId(1);
		ticket.setBookingDate(new Date());
		ticket.setPassengerName("Jacky");
		ticket.setEmail("Jacky@gmail.com");
		ticket.setSourceStation("DFW");
		ticket.setDestinationStation("LA");
		return ticket;
	}
	
	private Ticket getTicket1() {
		Ticket ticket = new Ticket();
		ticket.setTicketId(2);
		ticket.setBookingDate(new Date());
		ticket.setPassengerName("Lee");
		ticket.setEmail("Lee@gmail.com");
		ticket.setSourceStation("DFW");
		ticket.setDestinationStation("LA");
		return ticket;
	}
	
	private Ticket getTicket2() {
		Ticket ticket = new Ticket();
		ticket.setTicketId(3);
		ticket.setBookingDate(new Date());
		ticket.setPassengerName("Kala");
		ticket.setEmail("Kala@gmail.com");
		ticket.setSourceStation("DFW");
		ticket.setDestinationStation("LA");
		return ticket;
	}
}
