package com.vhcamposq.portalchamados.ticket.service;

import com.vhcamposq.portalchamados.shared.exception.ResourceNotFoundException;
import com.vhcamposq.portalchamados.ticket.api.TicketCreateRequest;
import com.vhcamposq.portalchamados.ticket.api.TicketStatusChangeRequest;
import com.vhcamposq.portalchamados.ticket.api.TicketUpdateRequest;
import com.vhcamposq.portalchamados.ticket.domain.Ticket;
import com.vhcamposq.portalchamados.ticket.domain.TicketCategory;
import com.vhcamposq.portalchamados.ticket.domain.TicketPriority;
import com.vhcamposq.portalchamados.ticket.domain.TicketStatus;
import com.vhcamposq.portalchamados.ticket.infra.TicketRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TicketService {

	private final TicketRepository ticketRepository;

	public TicketService(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	@Transactional
	public Ticket create(TicketCreateRequest request) {
		Ticket ticket = new Ticket();
		ticket.setTitle(request.title());
		ticket.setDescription(request.description());
		ticket.setPriority(request.priority());
		ticket.setCategory(request.category());
		return ticketRepository.save(ticket);
	}

	@Transactional(readOnly = true)
	public Ticket getById(Long id) {
		return ticketRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Ticket not found: " + id));
	}

	@Transactional(readOnly = true)
	public Page<Ticket> list(Pageable pageable, TicketStatus status, TicketPriority priority, TicketCategory category) {
		if (status != null) {
			return ticketRepository.findByStatus(status, pageable);
		}
		if (priority != null) {
			return ticketRepository.findByPriority(priority, pageable);
		}
		if (category != null) {
			return ticketRepository.findByCategory(category, pageable);
		}
		return ticketRepository.findAll(pageable);
	}

	@Transactional
	public Ticket update(Long id, TicketUpdateRequest request) {
		Ticket ticket = getById(id);
		ticket.setTitle(request.title());
		ticket.setDescription(request.description());
		ticket.setPriority(request.priority());
		ticket.setCategory(request.category());
		return ticketRepository.save(ticket);
	}

	@Transactional
	public Ticket changeStatus(Long id, TicketStatusChangeRequest request) {
		Ticket ticket = getById(id);
		ticket.setStatus(request.status());
		return ticketRepository.save(ticket);
	}
}
