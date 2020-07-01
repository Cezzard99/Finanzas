package com.provid.platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.provid.platform.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	
	@Query("from Client c left join fetch c.roles r where c.id=r.id and r.name='ROLE_USER'")
	List<Client>getClients();
	
	Client findByRuc(String ruc);
}
