/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import java.util.List;
import model.pojo.User;
import model.dao.UserDAO;
import model.pojo.Profile;
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
        List<Object> list = dao.getAllNotes();
        User temp;
        for (int i = 0; i < list.size(); i++){
            temp = (User) list.get(i);
            if(user.getLogin().equals(temp.getLogin()) && user.getPassword().equals(temp.getPassword())){
                return temp.getRole();
            }
        }
        return -1; 
    }
    
    static public List<User> getAllUsers(){
        List<User> userlist = new ArrayList<User>();
        List<Object> list = dao.getAllNotes();
        for (int i = 0; i < list.size(); i++){
            userlist.add( (User) list.get(i));
        }
        return userlist;
    }
    
    static public void addUserWithProfile(User user, Profile profile){
        dao.addwithProfile(user, profile);
    }
    
    static public void deleteUser(int id){
        dao.delete(id);
    }
}
