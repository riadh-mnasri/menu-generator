package com.github.rmnasri.controller;

import com.github.rmnasri.model.Recette;
import com.github.rmnasri.service.RecetteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/gmf")
public class WelcomeController {

    private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);


    @Value("${application.message:Hello World}")
    private static String GREETINGS = "Hello ";

    @Autowired
    private RecetteService recetteService;


    @RequestMapping(value = "/recette/save", method = RequestMethod.POST)
    public ModelAndView addRecette(@ModelAttribute("recetteForm") RecetteForm recetteForm, BindingResult result) {
        ModelAndView mav = new ModelAndView("welcome");
        Recette recetteModel = mapRecette(recetteForm);
        Recette recetteSaved = recetteService.saveRecette(recetteModel);
        logger.info("Recette saved :: {}", recetteSaved);
        addCommonDataToMav(mav);
        return mav;
    }

    @RequestMapping(value = "/recette/delete/{id}")
    public ModelAndView deleteRecette(@PathVariable("id") Long idRecette) {
        ModelAndView mav = new ModelAndView("redirect:/gmf/welcome");
        recetteService.deleteRecette(idRecette);
        addCommonDataToMav(mav);
        return mav;
    }

    protected Iterable<Recette> findAllRecettes() {
        Iterable<Recette> recettes = recetteService.findAllRecettes();
        for (Recette recetteTmp : recettes){
            logger.info("Found Recette :: {}", recetteTmp);
        }
        return recettes;
    }

    protected void addCommonDataToMav(ModelAndView mav) {
        Iterable<Recette> recettes = findAllRecettes();
        mav.addObject("time", new Date());
        mav.addObject("message", GREETINGS+"World!");
        mav.addObject("recettes", recettes);
    }

    private Recette mapRecette(@ModelAttribute("recetteForm") RecetteForm recetteForm) {
        Recette recetteModel = new Recette();
        //recetteModel.setId(recetteForm.getId());
        recetteModel.setRecetteName(recetteForm.getRecetteName());
        return recetteModel;
    }

    @RequestMapping(value = "/welcome")
    public ModelAndView welcome(Map<String, Object> model, @ModelAttribute("recetteForm") RecetteForm recetteForm) {
        ModelAndView mav = new ModelAndView("welcome");
        addCommonDataToMav(mav);
        return mav;
    }

    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public String helloSomeone(Map<String, Object> model, @RequestParam("who") String persons) {
        YearMonth date = YearMonth.now();
        model.put("time", date);
        StringBuilder completeMessage = new StringBuilder(GREETINGS);
        completeMessage.append(persons);
        model.put("message", completeMessage.toString());
        return "welcome";
    }

    @RequestMapping(value="/greetings/{someone}", method = RequestMethod.GET)
    public ModelAndView hiSomeone(@PathVariable("someone") String username) {
        ModelAndView mav = new ModelAndView("welcome");
        LocalDateTime timePoint = getCurrentFormattedDate();
        mav.addObject("time", timePoint);
        mav.addObject("message", "Hello :: " + username);
        return mav;
    }

    protected LocalDateTime getCurrentFormattedDate() {
        LocalDateTime timePoint = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        timePoint.format(formatter);
        return timePoint;
    }

}