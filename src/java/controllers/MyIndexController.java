/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import model.pojo.Profile;
import services.ProfileService;
import services.JobService;
/**
 *
 * @author 7853j
 */
@Controller
@RequestMapping("/index.htm")
public class MyIndexController {
    
    @RequestMapping(method = RequestMethod.GET)
    public String showIndex(HttpServletRequest request, ModelMap model, @CookieValue(value = "user", defaultValue = "none") String userLogin, @CookieValue(value = "role", defaultValue = "-1") String userRole) {
        Profile profile = ProfileService.getLoginProfile(userLogin);
        String jobs = JobService.getJobsString(userLogin);
        model.addAttribute("jobs", jobs);
        model.addAttribute("profile", profile);
        model.addAttribute("userlogin", userLogin);
        model.addAttribute("userrole", userRole);
        request.setAttribute("userrole", userRole);
        //sc.setInitParameter("userrole", userRole);
        return "index";
        
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onChange() { 
       
        return "index";
    }
}
