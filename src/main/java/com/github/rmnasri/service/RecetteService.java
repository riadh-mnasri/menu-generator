package com.github.rmnasri.service;

import com.github.rmnasri.model.Recette;
import com.github.rmnasri.repository.RecetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by riadh on 04/05/15.
 */
@Service
public class RecetteService {

    @Autowired
    RecetteRepository recetteRepository;

    public Recette saveRecette(Recette recette){
        return recetteRepository.save(recette);
    }

    public Recette findRecette(Long idRecette){
        return recetteRepository.findOne(idRecette);
    }

    public Iterable<Recette> findAllRecettes(){
        return recetteRepository.findAll();
    }

    public void deleteRecette(Long idRecette){
         recetteRepository.delete(idRecette);
    }
}
