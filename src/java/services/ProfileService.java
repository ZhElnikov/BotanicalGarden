/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import model.dao.ProfileDAO;
import model.dao.UserDAO;
import model.pojo.Profile;
import model.pojo.User;

/**
 *
 * @author 7853j
 */
public class ProfileService {
    
    static ProfileDAO dao = new ProfileDAO();
    static UserDAO userdao = new UserDAO();
    
    static public Profile getLoginProfile(String login){
        User user = userdao.getUserByLogin(login);
        Profile profile = getUserProfile(user);
        return profile;
    }
    
    static public Profile getUserProfile(User user){
        Profile profile = dao.getProfile(user.getIdUser());
        return profile;
    }
    
}
