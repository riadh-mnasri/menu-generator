package com.github.rmnasri.service;

import com.github.rmnasri.model.Recette;
import com.github.rmnasri.repository.RecetteRepository;
import com.github.rmnasri.utils.DAY_OF_THE_WEEK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by riadh on 04/05/15.
 */
@Service
public class RecetteService {

    public static final int WEEK_LAST_DAY_NUMBER = 6;
    public static final int RANDOM_LIMIT = 10000;
    @Autowired
    RecetteRepository recetteRepository;

    public Recette saveRecette(Recette recette) {
        return recetteRepository.save(recette);
    }

    public Recette findRecette(Long idRecette) {
        return recetteRepository.findOne(idRecette);
    }

    public Iterable<Recette> findAllRecettes() {
        return recetteRepository.findAll();
    }

    public void deleteRecette(Long idRecette) {
        recetteRepository.delete(idRecette);
    }

    public Map findMenusOfTheWeek() {

        String[] suggestions = {"Couscous Poulet","Couscous Agneau","Couscous poisson","Couscous légumes",
                "Ragoût agneau","Ragoût poulet","Ragoût boulettes", "Pâtes Poulet", "Pâtes agneau","Pâtes boulettes",
                "Pâtes fruits de mer", "Poisson grillé","Poisson rôti", "Escalope grillé ","Agneau grillé ","Poulet rôti ",
                "Agneau rôti", "Riz escalope","Borgol poulet","Borgol agneau", "Pizza", "Tajine", "Salade grillée", "Menu Indien",
                "Fricassé", "Brik", "Crevettes panées", "Calamar grillé", "Chapati", "Mar9a poulet za3ra", "Leftt et Lablabi",
                "Chakchouket foul", "Ojja", "Omelettes", "Souflet", "Quiches", "Poivron me7chi", "Chorba", "Maslou9a"};

        Map menusOfTheWeek = new LinkedHashMap<>() ;
        Random random = new Random();
        int n = 0;
        for (int i = 0; i <= WEEK_LAST_DAY_NUMBER; i++) {
            n = random.nextInt(RANDOM_LIMIT) % suggestions.length;
            while(menusOfTheWeek.containsValue(suggestions[n])){
                n = random.nextInt(RANDOM_LIMIT) % suggestions.length;
            }
            menusOfTheWeek.put(DAY_OF_THE_WEEK.values()[i], suggestions[n]);
        }
        return menusOfTheWeek;
    }


}
