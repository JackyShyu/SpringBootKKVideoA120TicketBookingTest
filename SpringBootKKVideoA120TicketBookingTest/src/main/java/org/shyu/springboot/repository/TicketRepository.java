package org.shyu.springboot.repository;

import org.shyu.springboot.model.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {

}
