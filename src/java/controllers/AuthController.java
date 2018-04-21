/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import model.dao.UserDAO;
import model.pojo.User;

import services.AuthService;

/**
 *
 * @author 7853j
 */
@Controller
@RequestMapping("/loginPage.htm")
@SessionAttributes("user")
public class AuthController {
    private AuthService authService;

    @Autowired
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }
 
    @RequestMapping(method = RequestMethod.GET)
    public String showAuthForm(ModelMap model) {
        System.out.println("0");
        User user = new User();
        model.addAttribute(user);
        return "loginPage";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute("user") User user) {
        System.out.println("1");
        System.out.println(user.toString());
        System.out.println(user.getLogin()); 
        System.out.println(user.getPassword());   
        //System.out.println(authService.toString()); 
            System.out.println("3");  
            return "redirect:index.htm";
        //}
       // return "loginPage";  
    }
}
