/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.pojo.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author 7853j
 */
public class UserDAO extends AbstractDAO{
    User user;
    
    public void getAllNotes(){
        executeHQL("from User");
    }
    
    public User getUser(int i){
        executeHQL("from User where id_user = " + i);
        this.user = (User) list.get(0);
        return this.user;
    }
    
    public User getUserByLogin(String login){
        executeHQL("From User where login like '" + login + "'");
        this.user = (User) list.get(0);
        return this.user;
    }
    
    public int amount(){
        getAllNotes();
        return list.size();
    }
    
}
