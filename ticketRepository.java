package com.gl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.model.ticket;

public interface ticketRepository extends JpaRepository<ticket, Integer> {
	 List<ticket> findByTicketTitleContainingIgnoreCase(String ticketTitle);

}
