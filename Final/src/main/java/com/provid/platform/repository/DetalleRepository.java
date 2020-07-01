package com.provid.platform.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.provid.platform.model.DetalleBono;

@Repository
public interface DetalleRepository extends JpaRepository<DetalleBono, Long> {

	@Query("select d from DetalleBono d join fetch d.bonoId b where d.id=?1")
	Optional<DetalleBono> fetchByDetalleIdWithBono(Long id);
}
