/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import services.GardenService;

/**
 *
 * @author 7853j
 */
@Controller
@SessionAttributes({"attrs"})
public class GardenController {
    String info = "Выберете сектор";
    
    @RequestMapping(value = "/garden.htm", method = RequestMethod.GET)
    public String showGarden(ModelMap model, @CookieValue(value = "user", defaultValue = "none") String userLogin, @CookieValue(value = "role", defaultValue = "-1") String userRole) {
        Attributes attrs = new Attributes();
        model.addAttribute("userlogin", userLogin);
        model.addAttribute("userrole", userRole);
        model.addAttribute("attrs", attrs);
        model.addAttribute("info", this.info);
        return "garden";  
    }
    
    @RequestMapping(value = {"/garden/{key}.htm"}, method = RequestMethod.GET)
    public String showConcreteGarden(ModelMap model, @ModelAttribute("attrs") Attributes attrs, HttpServletRequest request) {
        /*String button = attrs.getStatus();
        String splited[] = button.split(" ");
        int page = Integer.parseInt(splited[1]);
        String sectorinfo = GardenService.getStringInfo(page);
        this.info = sectorinfo;
        System.out.println(info);*/
        String parts[] = request.getRequestURL().toString().split("/");
        String last2[] = parts[parts.length - 1].split("\\.");
        int page = Integer.parseInt(last2[0]);
        String sectorinfo = GardenService.getStringInfo(page);
        this.info = sectorinfo;
        //model.addAttribute("info", info);
        //response.addCookie(new Cookie("info", URLEncoder.encode(info, "UTF-8")));
        //ModelAndView mav = new ModelAndView();
        //mav.setViewName("/result.htm");
        //return mav;

        return "redirect:/garden.htm"; 
        
    }
}
