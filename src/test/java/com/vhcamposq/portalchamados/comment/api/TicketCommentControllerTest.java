package com.vhcamposq.portalchamados.comment.api;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.vhcamposq.portalchamados.comment.domain.TicketComment;
import com.vhcamposq.portalchamados.shared.api.GlobalExceptionHandler;
import com.vhcamposq.portalchamados.shared.exception.ResourceNotFoundException;
import com.vhcamposq.portalchamados.ticket.domain.Ticket;
import com.vhcamposq.portalchamados.ticket.service.TicketService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@WebMvcTest(controllers = TicketCommentController.class)
@Import(GlobalExceptionHandler.class)
class TicketCommentControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockitoBean
	TicketService ticketService;

	@Test
	void add_shouldReturn201() throws Exception {
		Ticket ticket = new Ticket();
		ticket.setId(1L);

		TicketComment c = new TicketComment();
		c.setId(10L);
		c.setTicket(ticket);
		c.setMessage("m");

		when(ticketService.addComment(any(), any())).thenReturn(c);
		String body = "{\"message\":\"m\"}";

		mockMvc.perform(post("/tickets/1/comments")
						.contentType(MediaType.APPLICATION_JSON)
						.content(body))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id").value(10));
	}

	@Test
	void list_shouldReturn200() throws Exception {
		Ticket ticket = new Ticket();
		ticket.setId(1L);

		TicketComment c1 = new TicketComment();
		c1.setId(1L);
		c1.setTicket(ticket);
		c1.setMessage("a");

		when(ticketService.listComments(1L)).thenReturn(List.of(c1));

		mockMvc.perform(get("/tickets/1/comments"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].id").value(1));
	}

	@Test
	void list_shouldReturn404WhenTicketNotFound() throws Exception {
		when(ticketService.listComments(99L)).thenThrow(new ResourceNotFoundException("Ticket not found: 99"));

		mockMvc.perform(get("/tickets/99/comments"))
				.andExpect(status().isNotFound())
				.andExpect(jsonPath("$.status").value(404));
	}
}
