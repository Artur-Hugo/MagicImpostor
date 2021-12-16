package com.devoliga.MagicImpostor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devoliga.MagicImpostor.model.Personagem;
import com.devoliga.MagicImpostor.repository.PersonagemRepository;

@Service
public class PersonagemService {
	
	@Autowired
	private PersonagemRepository repository;
	
	public List<Personagem> getPersonagem(){
		return repository.findAll();
	}
	
	public void salvar(Personagem personagem){
		repository.save(personagem);
	}

}
