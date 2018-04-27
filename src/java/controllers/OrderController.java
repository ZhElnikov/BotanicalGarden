/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import model.pojo.RequestFert;
import model.pojo.RequestTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import services.OrderService;
/**
 *
 * @author 7853j
 */
@Controller
@SessionAttributes({"attrs"})
public class OrderController {
    
    private int filter = 0;
    
    @RequestMapping(value = "/order.htm", method = RequestMethod.GET)
    public String showOrder(ModelMap model, @CookieValue(value = "user", defaultValue = "none") String userLogin, @CookieValue(value = "role", defaultValue = "-1") String userRole) {
        if (userRole.equals("-1")){
            return "redirect:/loginPage.htm";
        }
        List<RequestFert> fertList = OrderService.getFerts();
        List<RequestTree> treeList = OrderService.getTrees();
        if (this.filter == 1){
            fertList.clear();
        }
        if (this.filter == 2){
            treeList.clear();
        }
        this.filter = 0;
        List<String> treeNames = OrderService.getTreesNames();
        Attributes attrs = new Attributes();
        model.addAttribute("treeList", treeList);
        model.addAttribute("treeNames", treeNames);
        model.addAttribute("fertList", fertList);
        model.addAttribute("userlogin", userLogin);
        model.addAttribute("userrole", userRole);
        model.addAttribute("attrs", attrs);
        return "order";
        
    }
    
    @RequestMapping(value = "/order/response.htm", method = RequestMethod.POST)
    public String onStatusChange(@ModelAttribute("attrs") Attributes attrs) {
        int id = Integer.parseInt(attrs.getId());
        int stat = 2;
        if (attrs.getStatus().equals("Подтвердить")){
            stat = 1;
        }
        if (attrs.getType().equals("Деревья")){
            OrderService.changeStateTree(id, stat);
        }
        if (attrs.getType().equals("Удобрения")){
            OrderService.changeStateFert(id, stat);
        }
        return "redirect:/order.htm";
    }
    
    @RequestMapping(value = "/order/add.htm", method = RequestMethod.POST)
    public String onAdd(@ModelAttribute("attrs") Attributes attrs, HttpServletResponse response, @CookieValue(value = "valid", defaultValue = "false") String valid) {
        if (valid.equals("false")){
            System.out.println("NOT VALID");
            return "redirect:/order.htm";
        }
        
        String body = attrs.getBody();
        String name = attrs.getName();
        String nameTree = attrs.getNameTree();
        System.out.println(nameTree);
        String user = attrs.getUser();
        int q = Integer.parseInt(attrs.getQ());
        if (attrs.getType().equals("tree")){
            OrderService.addTreeReq(user, nameTree, body, q);
        }
        if (attrs.getType().equals("fertilizer")){
            OrderService.addFertReq(user, name, body, q);
        }
        return "redirect:/order.htm";
    }

    @RequestMapping(value = "/order/filter.htm", method = RequestMethod.POST)
    public String onFilter(HttpServletResponse response, @ModelAttribute("attrs") Attributes attrs, @CookieValue(value = "role", defaultValue = "-1") String userRole) {
        if (userRole.equals("-1") || userRole.equals("1")){
            return "redirect:/loginPage.htm";
        }
        if (attrs.getBody().equals("без фильтра")){
            this.filter = 0;
            return "redirect:/order.htm";
        } if (attrs.getBody().equals("только деревья")){
            this.filter = 1;
            return "redirect:/order.htm";
        } else {
            this.filter = 2;
            return "redirect:/order.htm";
        }
    }
    
}
