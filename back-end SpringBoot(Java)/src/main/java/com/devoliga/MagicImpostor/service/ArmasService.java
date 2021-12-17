package com.devoliga.MagicImpostor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devoliga.MagicImpostor.model.Armas;
import com.devoliga.MagicImpostor.repository.ArmaRepository;

@Service
public class ArmasService {

	@Autowired
    private ArmaRepository repository;
    
    public List<Armas> getArmas(){
        return repository.findAll();
    }

    public void salvar(Armas armas){
        repository.save(armas);
    }
    
    public Armas getArmasById(int codigo) {
        return repository.findById(codigo).get();
    }
}
