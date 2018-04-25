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
import model.pojo.User;
import services.ProfileService;
import services.JobService;
import services.AuthService;
import java.util.List;
import model.pojo.Job;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
/**
 *
 * @author 7853j
 */
@Controller
@SessionAttributes({"user", "profile"})
public class MyIndexController {
    
    @RequestMapping(value = "/index.htm", method = RequestMethod.GET)
    public String showIndex(HttpServletRequest request, ModelMap model, @CookieValue(value = "user", defaultValue = "none") String userLogin, @CookieValue(value = "role", defaultValue = "-1") String userRole) {
        Profile myprofile = ProfileService.getLoginProfile(userLogin);
        String jobs = JobService.getJobsString(userLogin);
        List<Profile> proflist = ProfileService.getAllProfiles();
        List<User> userlist = AuthService.getAllUsers();
        User user = new User();
        Profile profile = new Profile();
        model.addAttribute("jobs", jobs);
        model.addAttribute("myprofile", myprofile);
        model.addAttribute("userlogin", userLogin);
        model.addAttribute("userrole", userRole);
        model.addAttribute("proflist", proflist);
        model.addAttribute("userlist", userlist);
        model.addAttribute("user", user);
        model.addAttribute("profile", profile);
        return "index";
        
    }

    @RequestMapping(value = "/index/delete.htm", method = RequestMethod.POST)
    public String onDelete(@ModelAttribute("user") User user) { 
        AuthService.deleteUser(user.getIdUser());
        return "redirect:/index.htm";
    }
    
    @RequestMapping(value = "/index/add.htm", method = RequestMethod.POST)
    public String onAdd(@ModelAttribute("user") User user, @ModelAttribute("profile") Profile profile) { 
        AuthService.addUserWithProfile(user, profile);
        return "redirect:/index.htm";
    }
}
