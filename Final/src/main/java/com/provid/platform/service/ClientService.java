package com.provid.platform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.provid.platform.controller.dto.ClientRegistrationDto;
import com.provid.platform.model.Client;

public interface ClientService extends UserDetailsService{
	
	Client findByRuc(String ruc);
	
	Client save(ClientRegistrationDto registrationDto);
	
	List<Client>findAll() throws Exception;
	
	List<Client>findAllClients() throws Exception;
	
	Optional<Client> findById(Long id) throws Exception;
	
}
