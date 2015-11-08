package com.github.rmnasri.controller;

import com.github.rmnasri.model.Recette;
import com.github.rmnasri.service.RecetteService;
import com.github.rmnasri.validator.RecetteValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/gmf")
public class MenusOfTheWeekController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MenusOfTheWeekController.class);


    @Autowired
    private RecetteService recetteService;

    @Autowired
    private RecetteValidator recetteValidator;


    protected void addCommonDataToMav(ModelAndView mav) {
        Map recettes = recetteService.findMenusOfTheWeek();
        mav.addObject("message", "Have a nice lunch");
        mav.addObject("time", getCurrentFormattedDate());
        mav.addObject("recettes", recettes);
    }

    @RequestMapping(value = "/menusOfTheWeek", method = RequestMethod.GET)
    public ModelAndView welcome(Map<String, Object> model, @ModelAttribute("recetteForm") RecetteForm recetteForm) {
        ModelAndView mav = new ModelAndView("menusOfTheWeek");
        addCommonDataToMav(mav);
        return mav;
    }

    protected LocalDateTime getCurrentFormattedDate() {
        LocalDateTime timePoint = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        timePoint.format(formatter);
        return timePoint;
    }

}