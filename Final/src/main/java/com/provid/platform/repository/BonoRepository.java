package com.provid.platform.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.provid.platform.model.Bono;

@Repository
public interface BonoRepository extends JpaRepository<Bono, Long> {
	
	@Query("select b from Bono b join fetch b.clientId c where b.id=?1")
	Optional<Bono>fetchByBonoIdWithClient(Long id);
	
	@Query("select count(b.id) from Bono b where b.id = :id")
	int countById(@Param("id") Long id);
}
