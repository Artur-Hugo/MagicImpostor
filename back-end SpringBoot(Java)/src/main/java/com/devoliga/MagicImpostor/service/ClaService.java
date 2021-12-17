package com.devoliga.MagicImpostor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devoliga.MagicImpostor.model.Cla;
import com.devoliga.MagicImpostor.repository.ClaRepository;

@Service
public class ClaService {

	@Autowired
	private ClaRepository claRepository;

	public void salvar(Cla cla) {
		claRepository.save(cla);
	}
	
	public List<Cla> getCla(){
		return claRepository.findAll();
	}

}
