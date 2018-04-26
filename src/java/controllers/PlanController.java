/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.Arrays;
import java.util.List;
import model.pojo.Job;
import model.pojo.Profile;
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
import services.JobService;
import services.ProfileService;
/**
 *
 * @author 7853j
 */
@Controller
@SessionAttributes({"job", "profile"})
public class PlanController {
    
    @RequestMapping(value = "/plan.htm", method = RequestMethod.GET)
    public String showPlan(ModelMap model, @CookieValue(value = "user", defaultValue = "none") String userLogin, @CookieValue(value = "role", defaultValue = "-1") String userRole) {
        List<Job> userJobs = JobService.getUserJobsList(userLogin);
        List<String> allJobs = JobService.getAllJobsListString();
        List<Job> jobs = JobService.getAllJobsList();
        List<Profile> profiles = ProfileService.getAllProfiles();
        Job job = new Job();
        Profile profile = new Profile();
        model.addAttribute("userlogin", userLogin);
        model.addAttribute("userrole", userRole);
        model.addAttribute("userjobs", userJobs);
        model.addAttribute("alljobs", allJobs);
        model.addAttribute("jobs", jobs);
        model.addAttribute("profiles", profiles);
        model.addAttribute(job);
        model.addAttribute(profile);
        return "plan";
        
    }
    
    @RequestMapping(value = "/plan.htm", method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute("job") Job job, @ModelAttribute("profile") Profile profile) {
        String s = profile.getName();
        String splited[] = s.split("\\.");
        JobService.addJob(job, Integer.parseInt(splited[0]));
        return "redirect:/plan.htm";
    }
    
    @RequestMapping(value = "/plan/delete.htm", method = RequestMethod.POST)
    public String onDelete(@ModelAttribute("job") Job job) {
        JobService.deleteJob(job);
        return "redirect:/plan.htm";
    }
    
    @RequestMapping(value = "/plan/complete.htm", method = RequestMethod.POST)
    public String onComplete(@ModelAttribute("job") Job job) {
        JobService.completeJob(job);
        return "redirect:/plan.htm";
    }
    
}
