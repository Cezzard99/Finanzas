package com.provid.platform.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.provid.platform.model.Client;
import com.provid.platform.service.ClientService;

@Controller
@SessionAttributes("client")
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@GetMapping("/list")
	public String listClientes(Model model) {
		try {
			model.addAttribute("clients", clientService.findAllClients());
		}catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "list";
	}
	
	@GetMapping("/bonos/{id}")
	public String bonosClient(@PathVariable(value="id") Long id, Model model) {
		try {
			Optional<Client>client=clientService.findById(id);
			
			if(!client.isPresent()) {
				model.addAttribute("info","Cliente no existe");
				return "redirect:/clients/list";
			}else {
				model.addAttribute("client",client.get());
			}
		}catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "bonos";
	}
}