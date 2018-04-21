/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author 7853j
 */
@Controller
@RequestMapping("/plan.htm")
public class PlanController {
    
    @RequestMapping(method = RequestMethod.GET)
    public String showPlan(ModelMap model, @CookieValue(value = "user", defaultValue = "none") String userLogin, @CookieValue(value = "role", defaultValue = "-1") String userRole) {
        model.addAttribute("userlogin", userLogin);
        model.addAttribute("userrole", userRole);
        return "plan";
        
    }
    
}
