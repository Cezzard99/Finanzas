package com.provid.platform.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.provid.platform.controller.dto.ClientRegistrationDto;
import com.provid.platform.model.Client;
import com.provid.platform.model.Role;
import com.provid.platform.repository.ClientRepository;
import com.provid.platform.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	private ClientRepository clientRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public ClientServiceImpl(ClientRepository clientRepository) {
		super();
		this.clientRepository = clientRepository;
	}

	@Override
	public Client save(ClientRegistrationDto registrationDto) {
		Client client = new Client(registrationDto.getEmpresa(), registrationDto.getRazon(), registrationDto.getRuc(),
				passwordEncoder.encode(registrationDto.getContra()), Arrays.asList(new Role("ROLE_USER")));

		return clientRepository.save(client);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Client client = clientRepository.findByRuc(username);
		if (client == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(client.getRuc(), client.getContra(),
				mapRolesToAuthorities(client.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	@Override
	public List<Client> findAll() throws Exception {
		return clientRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Client> findById(Long id) throws Exception {
		return clientRepository.findById(id);
	}

	@Override
	public Client findByRuc(String ruc) {
		return clientRepository.findByRuc(ruc);
	}

	@Override
	public List<Client> findAllClients() throws Exception {
		return clientRepository.getClients();
	}
}
