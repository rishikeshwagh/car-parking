package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>  {

}
