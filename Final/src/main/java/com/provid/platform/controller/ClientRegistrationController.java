package com.provid.platform.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.provid.platform.controller.dto.ClientRegistrationDto;
import com.provid.platform.model.Client;
import com.provid.platform.service.ClientService;

@Controller
@RequestMapping("/registration")
public class ClientRegistrationController {

	private ClientService clientService;

	public ClientRegistrationController(ClientService clientService) {
		super();
		this.clientService = clientService;
	}

	@ModelAttribute("client")
	public ClientRegistrationDto clientRegistrationDto() {
		return new ClientRegistrationDto();
	}

	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}

	@PostMapping
	public String registerClientAccount(@ModelAttribute("client") @Valid ClientRegistrationDto registrationDto,
			BindingResult result) {
		Client client=clientService.findByRuc(registrationDto.getRuc());
		
		if(client!=null) {
			result.rejectValue("ruc", null, "Este número de RUC ya está asociado a otro cliente");
		}
		
		if(result.hasErrors()) {
			return "registration";
		}
		clientService.save(registrationDto);
		return "redirect:/registration?success";
	}
}
