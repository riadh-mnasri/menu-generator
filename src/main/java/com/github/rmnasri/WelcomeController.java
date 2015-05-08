package com.github.rmnasri;

import com.github.rmnasri.controller.RecetteForm;
import com.github.rmnasri.model.Recette;
import com.github.rmnasri.service.RecetteServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping(value = "/gmf", method = RequestMethod.GET)
public class WelcomeController {

    private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);


    @Value("${application.message:Hello World}")
    private static String GREETINGS = "Hello ";

    @Autowired
    private RecetteServiceImpl recetteService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addRecettePost(@ModelAttribute("recetteForm") RecetteForm recetteForm, BindingResult result) {
        ModelAndView mav = new ModelAndView("welcome");
        Recette recetteModel = new Recette();
        recetteModel.setId(recetteForm.getId());
        recetteModel.setRecetteName(recetteForm.getRecetteName());
        recetteService.saveRecette(recetteModel);
        logger.info("Recette saved :: {}", recetteModel);
        Iterable<Recette> recettes = recetteService.findAllRecettes();
        for (Recette recetteTmp : recettes){
            logger.info("Found Recette :: {}", recetteTmp);
        }
        return mav;
    }


    @RequestMapping(value="/welcome")
    public String welcome(Map<String, Object> model, @ModelAttribute("recetteForm") RecetteForm recetteForm) {
        model.put("time", new Date());
        model.put("message", GREETINGS+"World!");
        return "welcome";
    }

    @RequestMapping(value="/hello")
    public String helloSomeone(Map<String, Object> model, @RequestParam("who") String persons) {
        YearMonth date = YearMonth.now();
        model.put("time", date);
        StringBuilder completeMessage = new StringBuilder(GREETINGS);
        completeMessage.append(persons);
        model.put("message", completeMessage.toString());
        return "welcome";
    }

    @RequestMapping("/greetings/{someone}")
    public ModelAndView hiSomeone(@PathVariable("someone") String username) {
        ModelAndView mav = new ModelAndView("welcome");
        LocalDateTime timePoint = getCurrentFormattedDate();
        mav.addObject("time", timePoint);
        mav.addObject("message", "Hello :: " + username);
        return mav;
    }

    private LocalDateTime getCurrentFormattedDate() {
        LocalDateTime timePoint = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        timePoint.format(formatter);
        return timePoint;
    }

/*    @RequestMapping("/greetings/{someone}")
    public String hiSomeone(Model model, @PathVariable("someone") String username) {
        model.addAttribute("time", new Date());
        model.addAttribute("message", "Hello :: " + username);
        return "welcome";
    }*/


/*    @RequestMapping(value="/greetings/{someone}")
    public String hiSomeone(Map<String, Object> model, @PathVariable("someone") String username) {
        model.put("time", new Date());
        StringBuilder completeMessage = new StringBuilder(GREETINGS);
        completeMessage.append(username);
        model.put("message", completeMessage.toString());
        return "welcome";
    }*/

}