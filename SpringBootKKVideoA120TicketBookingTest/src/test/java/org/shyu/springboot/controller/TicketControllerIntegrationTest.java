package org.shyu.springboot.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.shyu.springboot.SpringBootKkVideoA120TicketBookingTestApplication;
import org.shyu.springboot.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringBootKkVideoA120TicketBookingTestApplication.class, webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TicketControllerIntegrationTest {
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	private HttpHeaders headers = new HttpHeaders();
	
	@Test
	public void testCreateTicket() throws Exception {
		Ticket ticket1 = getTicket1();
		
		String uri = "/api/tickets/create";
		String inputInJson = mapToJson(ticket1);
		
		HttpEntity<Ticket> entity = new HttpEntity<Ticket>(ticket1, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(
											formFullURLWithPort(uri),
											HttpMethod.POST, entity, String.class
											);
		String responseInJson = response.getBody();
		System.out.println(inputInJson);
		System.out.println("*******");
		System.out.println(responseInJson);
		assertThat(responseInJson).isEqualTo(inputInJson);
	}
	
	@Test
	public void testGetTicketById() throws Exception {
		Ticket ticket1 = getTicket1();
		
		String uri = "/api/tickets/ticketId/1";
		String inputInJson = mapToJson(ticket1);
		
		HttpEntity<Ticket> entity = new HttpEntity<Ticket>(ticket1, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(
											formFullURLWithPort(uri),
											HttpMethod.GET, entity, String.class
											);
		String responseInJson = response.getBody();
		System.out.println(inputInJson);
		System.out.println("*******");
		System.out.println(responseInJson);
		assertThat(responseInJson).isEqualTo(inputInJson);
	}
	
	@Test
	public void testGetTicketByEmail() throws Exception {
		Ticket ticket1 = getTicket1();
		
		String uri = "/api/tickets/email/Jacky@Gmail.com";
		String inputInJson = mapToJson(ticket1);
		
		HttpEntity<Ticket> entity = new HttpEntity<Ticket>(ticket1, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(
											formFullURLWithPort(uri),
											HttpMethod.GET, entity, String.class
											);
		String responseInJson = response.getBody();
		System.out.println(inputInJson);
		System.out.println("*******");
		System.out.println(responseInJson);
		assertThat(responseInJson).isEqualTo(inputInJson);
		
	}
	
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
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
	
	private String formFullURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}
