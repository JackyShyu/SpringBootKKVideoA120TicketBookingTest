package org.shyu.springboot.controller;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.shyu.springboot.model.Ticket;
import org.shyu.springboot.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value=TicketControllerTest.class, secure=false)
//@WebAppConfiguration
public class TicketControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TicketService ticketService;
	
	/*@Test
	@Ignore
	public void testCreateTicket() throws Exception {
		Ticket ticket1 = getTicket1();
		
		String inputInJson = mapToJson(ticket1);
		String uri = "/api/tickets/create";
		Mockito.when(ticketService.createTicket(Mockito.any(Ticket.class))).thenReturn(ticket1);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
											.post(uri)
											.accept(MediaType.APPLICATION_JSON_VALUE)
											.content(inputInJson)
											.contentType(MediaType.APPLICATION_JSON_VALUE);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String outputInJson = response.getContentAsString();
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertThat(HttpStatus.OK.value()).isEqualTo(response.getStatus());
	}*/
	
	/*@Test
	public void testGetAllTickets() throws Exception {
		Ticket ticket1 = getTicket1();
		Ticket ticket2 = getTicket2();
		List<Ticket> tickets = new ArrayList<>();
		tickets.add(ticket1);
		tickets.add(ticket2);
		
		String uri = "/api/tickets/alltickets";
		Mockito.when(ticketService.getAllTickets()).thenReturn(tickets);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
											.get(new URI(uri))
											.accept(MediaType.APPLICATION_JSON);
													
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String inputInJson = mapToJson(tickets);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(HttpStatus.OK.value()).isEqualTo(result.getResponse().getStatus());										
	}*/
	
	@Test
	public void testGetTicket() throws Exception {
		Ticket ticket1 = getTicket1();
		
		String uri = "/api/tickets/ticketId/1";
		Mockito.when(ticketService.getTicketById(Mockito.anyInt())).thenReturn(ticket1);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
											.get(uri)
											.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String inputInJson = mapToJson(ticket1);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(HttpStatus.OK.value()).isEqualTo(result.getResponse().getStatus());
	}
	
	@Test 
	public void testGetTicketByEmail() throws Exception {
		Ticket ticket1 = getTicket1();
		
		String uri = "/api/tickets/email/Jacky@Gmail.com";
		Mockito.when(ticketService.getTicketByEmail(Mockito.anyString())).thenReturn(ticket1);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
											.get(uri)
											.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String inputInJson = mapToJson(ticket1);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(HttpStatus.OK.value()).isEqualTo(result.getResponse().getStatus());
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
