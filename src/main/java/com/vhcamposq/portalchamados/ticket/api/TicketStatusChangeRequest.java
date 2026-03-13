package com.vhcamposq.portalchamados.ticket.api;

import com.vhcamposq.portalchamados.ticket.domain.TicketStatus;
import jakarta.validation.constraints.NotNull;

public record TicketStatusChangeRequest(
		@NotNull TicketStatus status
) {
}
