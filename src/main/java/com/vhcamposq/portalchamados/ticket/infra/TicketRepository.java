package com.vhcamposq.portalchamados.ticket.infra;

import com.vhcamposq.portalchamados.ticket.domain.Ticket;
import com.vhcamposq.portalchamados.ticket.domain.TicketCategory;
import com.vhcamposq.portalchamados.ticket.domain.TicketPriority;
import com.vhcamposq.portalchamados.ticket.domain.TicketStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
	Page<Ticket> findByStatus(TicketStatus status, Pageable pageable);

	Page<Ticket> findByPriority(TicketPriority priority, Pageable pageable);

	Page<Ticket> findByCategory(TicketCategory category, Pageable pageable);
}
