package com.provid.platform.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.provid.platform.model.DetalleBono;
import com.provid.platform.repository.DetalleRepository;
import com.provid.platform.service.DetalleService;

@Service
public class DetalleServiceImpl implements DetalleService{

	@Autowired
	private DetalleRepository detalleRepository;
	
	@Transactional(readOnly = true)
	@Override
	public Optional<DetalleBono> fetchByBonoIdWithClient(Long id) throws Exception {
		return detalleRepository.fetchByDetalleIdWithBono(id);
	}

	@Override
	public Optional<DetalleBono> findById(Long id) throws Exception {
		return detalleRepository.findById(id);
	}

}
