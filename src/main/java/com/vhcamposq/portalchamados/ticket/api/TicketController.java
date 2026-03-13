package com.vhcamposq.portalchamados.ticket.api;

import com.vhcamposq.portalchamados.ticket.domain.Ticket;
import com.vhcamposq.portalchamados.ticket.domain.TicketCategory;
import com.vhcamposq.portalchamados.ticket.domain.TicketPriority;
import com.vhcamposq.portalchamados.ticket.domain.TicketStatus;
import com.vhcamposq.portalchamados.ticket.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets")
public class TicketController {

	private final TicketService ticketService;

	public TicketController(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	@PostMapping
	public ResponseEntity<TicketResponse> create(@Valid @RequestBody TicketCreateRequest request) {
		Ticket ticket = ticketService.create(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(toResponse(ticket));
	}

	@GetMapping
	public Page<TicketResponse> list(
			@PageableDefault(size = 20) Pageable pageable,
			@RequestParam(required = false) TicketStatus status,
			@RequestParam(required = false) TicketPriority priority,
			@RequestParam(required = false) TicketCategory category
	) {
		return ticketService.list(pageable, status, priority, category).map(this::toResponse);
	}

	@GetMapping("/{id}")
	public TicketResponse getById(@PathVariable Long id) {
		return toResponse(ticketService.getById(id));
	}

	@PutMapping("/{id}")
	public TicketResponse update(@PathVariable Long id, @Valid @RequestBody TicketUpdateRequest request) {
		return toResponse(ticketService.update(id, request));
	}

	@PatchMapping("/{id}/status")
	public TicketResponse changeStatus(@PathVariable Long id, @Valid @RequestBody TicketStatusChangeRequest request) {
		return toResponse(ticketService.changeStatus(id, request));
	}

	private TicketResponse toResponse(Ticket ticket) {
		return new TicketResponse(
				ticket.getId(),
				ticket.getTitle(),
				ticket.getDescription(),
				ticket.getStatus(),
				ticket.getPriority(),
				ticket.getCategory(),
				ticket.getCreatedAt(),
				ticket.getUpdatedAt()
		);
	}
}
