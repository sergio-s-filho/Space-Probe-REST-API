package com.example.sonda.service;


import com.example.sonda.model.SondaModel;
import com.example.sonda.repository.SondaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SondaService {

    @Autowired
    SondaRepository sondaRepository;


    public SondaModel save(SondaModel sondaModel){
        return sondaRepository.save(sondaModel);
    }

    public List<SondaModel> findAll(){
        return sondaRepository.findAll();
    }

    public SondaModel findById(UUID id){
        return sondaRepository.findById(id).get();
    }

    public void delete(SondaModel sondaModel){
        sondaRepository.delete(sondaModel);
    }
}
