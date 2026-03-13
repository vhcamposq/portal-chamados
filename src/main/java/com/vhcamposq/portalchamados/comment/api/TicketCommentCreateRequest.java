package com.vhcamposq.portalchamados.comment.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TicketCommentCreateRequest(
		@NotBlank @Size(max = 2000) String message
) {
}
