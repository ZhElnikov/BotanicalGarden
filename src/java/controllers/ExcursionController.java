/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import model.pojo.Profile;
import model.pojo.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import services.ExcursionService;
import services.JobService;

/**
 *
 * @author 7853j
 */
@Controller
@RequestMapping("/excursion.htm")
@SessionAttributes("tour")
public class ExcursionController {
    
    @RequestMapping(method = RequestMethod.GET)
    public String showExcursion(ModelMap model, @CookieValue(value = "user", defaultValue = "none") String userLogin, @CookieValue(value = "role", defaultValue = "-1") String userRole) {
        List<Tour> tours = ExcursionService.getAllToursList();
        Tour tour = new Tour();
        model.addAttribute("userlogin", userLogin);
        model.addAttribute("userrole", userRole);
        model.addAttribute("tours", tours);
        model.addAttribute("tour", tour);
        return "excursion";
    }
    
    @RequestMapping(value = "/excursion.htm", method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute("tour") Tour tour) {
        ExcursionService.addTour(tour);
        return "redirect:excursion.htm";
    }
    
    @RequestMapping(value = "/excursion/delete.htm", method = RequestMethod.POST)
    public String onDelete(@ModelAttribute("tour") Tour tour) {
        ExcursionService.deleteTour(tour);
        return "redirect:/excursion.htm";
    }
    
}
