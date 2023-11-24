package com.gl.service;

import java.util.List;

import com.gl.model.ticket;

public interface ticketService {
	
	ticket addTickect(ticket t);
	ticket findById(int id);
	String delete(int id);
	List<ticket> getAllTickets();
   
	List<ticket> searchByTitle(String ticketTitle);

}
