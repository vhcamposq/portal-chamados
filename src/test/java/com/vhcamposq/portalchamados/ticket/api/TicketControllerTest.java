package com.vhcamposq.portalchamados.ticket.api;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.vhcamposq.portalchamados.shared.api.GlobalExceptionHandler;
import com.vhcamposq.portalchamados.shared.exception.ResourceNotFoundException;
import com.vhcamposq.portalchamados.ticket.domain.Ticket;
import com.vhcamposq.portalchamados.ticket.domain.TicketCategory;
import com.vhcamposq.portalchamados.ticket.domain.TicketPriority;
import com.vhcamposq.portalchamados.ticket.domain.TicketStatus;
import com.vhcamposq.portalchamados.ticket.service.TicketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@WebMvcTest(controllers = TicketController.class)
@Import(GlobalExceptionHandler.class)
class TicketControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockitoBean
	TicketService ticketService;

	@Test
	void create_shouldReturn201() throws Exception {
		Ticket t = new Ticket();
		t.setId(1L);
		t.setTitle("t");
		t.setDescription("d");
		t.setStatus(TicketStatus.OPEN);
		t.setPriority(TicketPriority.HIGH);
		t.setCategory(TicketCategory.BUG);

		when(ticketService.create(any())).thenReturn(t);
		String body = "{\"title\":\"t\",\"description\":\"d\",\"priority\":\"HIGH\",\"category\":\"BUG\"}";

		mockMvc.perform(post("/tickets")
						.contentType(MediaType.APPLICATION_JSON)
						.content(body))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id").value(1));
	}

	@Test
	void create_shouldReturn400WhenInvalid() throws Exception {
		String body = "{\"title\":\"\",\"description\":\"d\",\"priority\":\"HIGH\",\"category\":\"BUG\"}";

		mockMvc.perform(post("/tickets")
						.contentType(MediaType.APPLICATION_JSON)
						.content(body))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.status").value(400))
				.andExpect(jsonPath("$.details.fieldErrors.title").exists());
	}

	@Test
	void getById_shouldReturn404() throws Exception {
		when(ticketService.getById(999L)).thenThrow(new ResourceNotFoundException("Ticket not found: 999"));

		mockMvc.perform(get("/tickets/999"))
				.andExpect(status().isNotFound())
				.andExpect(jsonPath("$.status").value(404));
	}

	@Test
	void update_shouldReturn200() throws Exception {
		Ticket t = new Ticket();
		t.setId(1L);
		t.setTitle("t2");
		t.setDescription("d2");
		t.setStatus(TicketStatus.OPEN);
		t.setPriority(TicketPriority.MEDIUM);
		t.setCategory(TicketCategory.SUPPORT);

		when(ticketService.update(any(), any())).thenReturn(t);
		String body = "{\"title\":\"t2\",\"description\":\"d2\",\"priority\":\"MEDIUM\",\"category\":\"SUPPORT\"}";

		mockMvc.perform(put("/tickets/1")
						.contentType(MediaType.APPLICATION_JSON)
						.content(body))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.title").value("t2"));
	}

	@Test
	void changeStatus_shouldReturn200() throws Exception {
		Ticket t = new Ticket();
		t.setId(1L);
		t.setTitle("t");
		t.setDescription("d");
		t.setStatus(TicketStatus.DONE);
		t.setPriority(TicketPriority.MEDIUM);
		t.setCategory(TicketCategory.SUPPORT);

		when(ticketService.changeStatus(any(), any())).thenReturn(t);
		String body = "{\"status\":\"DONE\"}";

		mockMvc.perform(patch("/tickets/1/status")
						.contentType(MediaType.APPLICATION_JSON)
						.content(body))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("DONE"));
	}
}
