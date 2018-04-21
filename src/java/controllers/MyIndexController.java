/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import model.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import services.AuthService;

/**
 *
 * @author 7853j
 */
@Controller
@RequestMapping("/index.htm")
public class MyIndexController {
    
    @RequestMapping(method = RequestMethod.GET)
    public String showIndex(ModelMap model, @CookieValue(value = "user", defaultValue = "none") String userCookie) {
        model.addAttribute("userlogin", userCookie);
        return "index";
        
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onChange() { 
       
        return "index";
    }
}
