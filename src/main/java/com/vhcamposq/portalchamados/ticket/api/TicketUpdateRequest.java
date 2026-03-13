package com.vhcamposq.portalchamados.ticket.api;

import com.vhcamposq.portalchamados.ticket.domain.TicketCategory;
import com.vhcamposq.portalchamados.ticket.domain.TicketPriority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TicketUpdateRequest(
		@NotBlank @Size(max = 120) String title,
		@NotBlank @Size(max = 4000) String description,
		@NotNull TicketPriority priority,
		@NotNull TicketCategory category
) {
}
