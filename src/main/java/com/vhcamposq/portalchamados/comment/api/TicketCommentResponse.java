package com.vhcamposq.portalchamados.comment.api;

import java.time.Instant;

public record TicketCommentResponse(
		Long id,
		String message,
		Instant createdAt
) {
}
