package com.gl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.gl.model.ticket;
import com.gl.repository.ticketRepository;

public class ticketServiceImpl implements ticketService {
	
	@Autowired
	ticketRepository dao;

	@Override
	public ticket addTickect(ticket t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public ticket findById(int id) {
		// TODO Auto-generated method stub
Optional<ticket> t=dao.findById(id);
		
		if(t.isPresent()) {
			ticket currentTicket = t.get();
			return dao.save(currentTicket);
		}
		else
		return null;
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
		return "deleted successfully";
	}

	@Override
	public List<ticket> getAllTickets() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<ticket> searchByTitle(String ticketTitle) {
		// TODO Auto-generated method stub
		return dao.findByTicketTitleContainingIgnoreCase(ticketTitle);
	}

}
