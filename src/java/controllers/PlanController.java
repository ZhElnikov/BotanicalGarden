/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.Arrays;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
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
    
    private boolean filter = false;
    
    @RequestMapping(value = "/plan.htm", method = RequestMethod.GET)
    public String showPlan(ModelMap model, @CookieValue(value = "user", defaultValue = "none") String userLogin, 
            @CookieValue(value = "role", defaultValue = "-1") String userRole) {
        if (userRole.equals("-1")){
            return "redirect:/loginPage.htm";
        }
        List<Job> userJobs = JobService.getUserJobsList(userLogin);
        List<String> allJobs = JobService.getAllJobsListString();
        List<Job> jobs = JobService.getAllJobsList();
        if (filter){
            System.out.println("true");
            for (int i = 0; i < jobs.size(); i++) {
                Job temp = (Job) jobs.get(i);
                if (temp.getEndDate() != null) {
                    jobs.remove(i);
                    allJobs.remove(i);
                    i--;
                }
            }
        }
        this.filter = false;
        List<Profile> profiles = ProfileService.getAllProfiles();
        Attributes attrs = new Attributes();
        Job job = new Job();
        Profile profile = new Profile();
        model.addAttribute("userlogin", userLogin);
        model.addAttribute("userrole", userRole);
        model.addAttribute("userjobs", userJobs);
        model.addAttribute("alljobs", allJobs);
        model.addAttribute("jobs", jobs);
        model.addAttribute("profiles", profiles);
        model.addAttribute("attrs", attrs);
        model.addAttribute(job);
        model.addAttribute(profile);
        return "plan";
        
    }
    
    @RequestMapping(value = "/plan.htm", method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute("job") Job job, @ModelAttribute("profile") Profile profile, @CookieValue(value = "valid", defaultValue = "false") String valid) {
        if (valid.equals("false")){
            return "redirect:/plan.htm";
        }
        String s = profile.getName();
        String splited[] = s.split("\\.");
        JobService.addJob(job, Integer.parseInt(splited[0]));
        return "redirect:/plan.htm";
    }
    
    @RequestMapping(value = "/plan/delete.htm", method = RequestMethod.POST)
    public String onDelete(@ModelAttribute("job") Job job, @CookieValue(value = "role", defaultValue = "-1") String userRole) {
        if (userRole.equals("-1") || userRole.equals("1")){
            return "redirect:/loginPage.htm";
        }
        JobService.deleteJob(job);
        return "redirect:/plan.htm";
    }
    
    @RequestMapping(value = "/plan/complete.htm", method = RequestMethod.POST)
    public String onComplete(@ModelAttribute("job") Job job, @CookieValue(value = "role", defaultValue = "-1") String userRole) {
        if (userRole.equals("-1") || userRole.equals("1")){
            return "redirect:/loginPage.htm";
        }
        JobService.completeJob(job);
        return "redirect:/plan.htm";
    }
    
    @RequestMapping(value = "/plan/filter.htm", method = RequestMethod.POST)
    public String onFilter(HttpServletResponse response, @ModelAttribute("attrs") Attributes attrs, @CookieValue(value = "role", defaultValue = "-1") String userRole) {
        if (userRole.equals("-1") || userRole.equals("1")){
            return "redirect:/loginPage.htm";
        }
        if (attrs.getBody().equals("без фильтра")){
            System.out.println("false");
            this.filter = false;
            return "redirect:/plan.htm";
        } else {
            System.out.println("true");
            this.filter = true;
            return "redirect:/plan.htm";
        }
    }
}
