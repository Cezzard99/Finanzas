package com.provid.platform.service;

import java.util.Optional;

import com.provid.platform.model.DetalleBono;

public interface DetalleService {

	public Optional<DetalleBono> fetchByBonoIdWithClient(Long id) throws Exception;

	public Optional<DetalleBono> findById(Long id) throws Exception;
}
