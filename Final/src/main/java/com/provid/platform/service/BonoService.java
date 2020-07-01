package com.provid.platform.service;

import java.util.List;
import java.util.Optional;

import com.provid.platform.model.Bono;

public interface BonoService {

	public Optional<Bono>fetchByBonoIdWithClient(Long id) throws Exception;
	
	public Optional<Bono> findById(Long id) throws Exception;
	
	public List<Bono> findAll() throws Exception;
	
	public int save(Bono bono) throws Exception;
}
