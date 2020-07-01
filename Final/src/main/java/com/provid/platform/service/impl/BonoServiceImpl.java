package com.provid.platform.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.provid.platform.model.Bono;
import com.provid.platform.repository.BonoRepository;
import com.provid.platform.service.BonoService;

@Service
public class BonoServiceImpl implements BonoService {

	@Autowired
	private BonoRepository bonoRepository;
	
	@Transactional(readOnly=true)
	@Override
	public List<Bono> findAll() throws Exception {
		return bonoRepository.findAll();
	}

	@Transactional
	@Override
	public int save(Bono bono) throws Exception {
		int result=bonoRepository.countById(bono.getId());
		
		if(result==0) {
			bonoRepository.save(bono);
		}
		return result;
	}
	
	@Transactional(readOnly = true)
	@Override
	public Optional<Bono>fetchByBonoIdWithClient(Long id) throws Exception{
		return bonoRepository.fetchByBonoIdWithClient(id);
	}
	
	@Transactional(readOnly = true)
	@Override
	public Optional<Bono> findById(Long id) throws Exception{
		return bonoRepository.findById(id);
	}
}
