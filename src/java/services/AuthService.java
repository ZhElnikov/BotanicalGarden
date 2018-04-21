/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import model.pojo.User;
import model.dao.UserDAO;
/**
 *
 * @author 7853j
 */
public class AuthService {
    static UserDAO dao = new UserDAO();
    
    static public void sayHello(){
        System.out.println("hello");
    }
    
    static public int checkAuth(User user){
        int size = dao.amount();
        User temp;
        for (int i = 1; i <= dao.amount(); i++){
            temp = dao.getUser(i);
            if(user.getLogin().equals(temp.getLogin()) && user.getPassword().equals(temp.getPassword())){
                return user.getRole();
            }
        }
        return -1; 
    }
    
}
