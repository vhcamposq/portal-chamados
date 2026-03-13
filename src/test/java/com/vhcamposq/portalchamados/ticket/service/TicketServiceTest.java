package com.vhcamposq.portalchamados.ticket.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.vhcamposq.portalchamados.comment.api.TicketCommentCreateRequest;
import com.vhcamposq.portalchamados.comment.domain.TicketComment;
import com.vhcamposq.portalchamados.comment.infra.TicketCommentRepository;
import com.vhcamposq.portalchamados.shared.exception.ResourceNotFoundException;
import com.vhcamposq.portalchamados.ticket.api.TicketCreateRequest;
import com.vhcamposq.portalchamados.ticket.api.TicketStatusChangeRequest;
import com.vhcamposq.portalchamados.ticket.domain.Ticket;
import com.vhcamposq.portalchamados.ticket.domain.TicketCategory;
import com.vhcamposq.portalchamados.ticket.domain.TicketPriority;
import com.vhcamposq.portalchamados.ticket.domain.TicketStatus;
import com.vhcamposq.portalchamados.ticket.infra.TicketRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TicketServiceTest {

	@Mock
	TicketRepository ticketRepository;

	@Mock
	TicketCommentRepository ticketCommentRepository;

	@InjectMocks
	TicketService ticketService;

	@Test
	void create_shouldPersistTicket() {
		TicketCreateRequest req = new TicketCreateRequest(
				"Titulo",
				"Descricao",
				TicketPriority.HIGH,
				TicketCategory.BUG
		);

		Ticket persisted = new Ticket();
		persisted.setId(10L);
		persisted.setTitle(req.title());
		persisted.setDescription(req.description());
		persisted.setPriority(req.priority());
		persisted.setCategory(req.category());

		when(ticketRepository.save(any(Ticket.class))).thenReturn(persisted);

		Ticket created = ticketService.create(req);

		assertNotNull(created);
		assertEquals(10L, created.getId());
		assertEquals("Titulo", created.getTitle());
	}

	@Test
	void getById_shouldThrowWhenNotFound() {
		when(ticketRepository.findById(99L)).thenReturn(Optional.empty());
		assertThrows(ResourceNotFoundException.class, () -> ticketService.getById(99L));
	}

	@Test
	void changeStatus_shouldUpdateStatus() {
		Ticket t = new Ticket();
		t.setId(1L);
		t.setStatus(TicketStatus.OPEN);

		when(ticketRepository.findById(1L)).thenReturn(Optional.of(t));
		when(ticketRepository.save(any(Ticket.class))).thenAnswer(inv -> inv.getArgument(0));

		Ticket updated = ticketService.changeStatus(1L, new TicketStatusChangeRequest(TicketStatus.DONE));

		assertEquals(TicketStatus.DONE, updated.getStatus());
	}

	@Test
	void addComment_shouldPersistComment() {
		Ticket t = new Ticket();
		t.setId(1L);

		when(ticketRepository.findById(1L)).thenReturn(Optional.of(t));
		when(ticketCommentRepository.save(any(TicketComment.class))).thenAnswer(inv -> {
			TicketComment c = inv.getArgument(0);
			c.setId(5L);
			return c;
		});

		TicketComment comment = ticketService.addComment(1L, new TicketCommentCreateRequest("msg"));

		assertEquals(5L, comment.getId());
		assertEquals("msg", comment.getMessage());
		assertEquals(1L, comment.getTicket().getId());
	}

	@Test
	void listComments_shouldThrowWhenTicketDoesNotExist() {
		when(ticketRepository.existsById(2L)).thenReturn(false);
		assertThrows(ResourceNotFoundException.class, () -> ticketService.listComments(2L));
	}

	@Test
	void listComments_shouldReturnOrderedList() {
		when(ticketRepository.existsById(1L)).thenReturn(true);

		TicketComment c1 = new TicketComment();
		c1.setId(1L);
		c1.setMessage("a");
		TicketComment c2 = new TicketComment();
		c2.setId(2L);
		c2.setMessage("b");

		when(ticketCommentRepository.findByTicketIdOrderByCreatedAtAsc(eq(1L))).thenReturn(List.of(c1, c2));

		List<TicketComment> comments = ticketService.listComments(1L);
		assertEquals(2, comments.size());
		assertEquals(1L, comments.getFirst().getId());
	}
}
