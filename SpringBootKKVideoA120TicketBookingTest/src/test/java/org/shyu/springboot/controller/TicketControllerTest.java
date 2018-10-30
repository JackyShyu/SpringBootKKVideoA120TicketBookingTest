package org.shyu.springboot.controller;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(value=TicketControllerTest.class, secure=false)
public class TicketControllerTest {
	/*@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TicketService ticketService;*/
	
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
											.request(HttpMethod.GET, uri)
											.accept(MediaType.APPLICATION_JSON);
													
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String inputInJson = mapToJson(tickets);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(HttpStatus.OK.value()).isEqualTo(result.getResponse().getStatus());										
	}*/
	
	
	
	/*private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}*/
	
	/*private Ticket getTicket1() {
		Ticket ticket = new Ticket();
		ticket.setTicketId(1);
		ticket.setBookingDate(new Date());
		ticket.setDestinationStation("DFW");
		ticket.setEmail("Jacky@Gmail.com");
		ticket.setPassengerName("Jacky");
		ticket.setSourceStation("LA");
		return ticket;
	}*/
	
	/*private Ticket getTicket2() {
		Ticket ticket = new Ticket();
		ticket.setTicketId(2);
		ticket.setBookingDate(new Date());
		ticket.setDestinationStation("DFW");
		ticket.setEmail("Lee@Gmail.com");
		ticket.setPassengerName("Lee");
		ticket.setSourceStation("LA");
		return ticket;
	}*/
}
