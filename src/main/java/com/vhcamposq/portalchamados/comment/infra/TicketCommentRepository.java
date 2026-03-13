package com.vhcamposq.portalchamados.comment.infra;

import com.vhcamposq.portalchamados.comment.domain.TicketComment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketCommentRepository extends JpaRepository<TicketComment, Long> {
	List<TicketComment> findByTicketIdOrderByCreatedAtAsc(Long ticketId);
}
