package com.gl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.model.ticket;
import com.gl.service.ticketService;

@RestController
@RequestMapping("/admin")
public class HomeController {
	
	@Autowired
	ticketService service;
	
	@GetMapping("/tickets")
	public String getAll(Model m) {
		return "home";
		
	}
	@GetMapping("/tickets/newTicket")
	public String addTicket(Model m) {
		return "ticketForm";
		
	}
	@RequestMapping("/{id}/edit")
	public String edit(@PathVariable int id, Model m) {
		m.addAttribute("ticket", service.findById(id) );
		return "ticketForm";
		  
	}
	
	@GetMapping("/{id}/delete")
	public String delete(@PathVariable int id, Model m) {
	   m.addAttribute("ticket", service.delete(id));
		return "redirect:/admin/tickets";
		
	}
	
	@PostMapping("/saveTicket")
	public String save(@ModelAttribute("ticket") ticket ticket) {
		service.addTickect(ticket);
		return "redirect:/admin/tickets";
		
	}
	
	@GetMapping("/{id}/getbyId")
	public String findById(@PathVariable int id, Model m) {
		m.addAttribute("ticket", service.findById(id)); 
		return "View";
		
	}
	@GetMapping("/tickets/search")
    public String searchByTitle(@PathVariable String ticketTitle, Model model) {
        List<ticket> searchResults = service.searchByTitle(ticketTitle);
        model.addAttribute("ticket", searchResults);
        return "searchResults"+ticketTitle;

}
}
