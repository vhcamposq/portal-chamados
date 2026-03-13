package com.vhcamposq.portalchamados.comment.api;

import com.vhcamposq.portalchamados.comment.domain.TicketComment;
import com.vhcamposq.portalchamados.ticket.service.TicketService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets/{ticketId}/comments")
public class TicketCommentController {

	private final TicketService ticketService;

	public TicketCommentController(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	@PostMapping
	public ResponseEntity<TicketCommentResponse> add(
			@PathVariable Long ticketId,
			@Valid @RequestBody TicketCommentCreateRequest request
	) {
		TicketComment comment = ticketService.addComment(ticketId, request);
		return ResponseEntity.status(HttpStatus.CREATED).body(toResponse(comment));
	}

	@GetMapping
	public List<TicketCommentResponse> list(@PathVariable Long ticketId) {
		return ticketService.listComments(ticketId).stream().map(this::toResponse).toList();
	}

	private TicketCommentResponse toResponse(TicketComment comment) {
		return new TicketCommentResponse(comment.getId(), comment.getMessage(), comment.getCreatedAt());
	}
}
