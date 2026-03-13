package com.vhcamposq.portalchamados.ticket.api;

import com.vhcamposq.portalchamados.ticket.domain.TicketCategory;
import com.vhcamposq.portalchamados.ticket.domain.TicketPriority;
import com.vhcamposq.portalchamados.ticket.domain.TicketStatus;
import java.time.Instant;

public record TicketResponse(
		Long id,
		String title,
		String description,
		TicketStatus status,
		TicketPriority priority,
		TicketCategory category,
		Instant createdAt,
		Instant updatedAt
) {
}
