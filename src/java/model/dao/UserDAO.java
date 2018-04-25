/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import model.pojo.User;
import java.util.List;
import model.pojo.Profile;
import model.util.NewHibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author 7853j
 */
public class UserDAO extends AbstractDAO{
    User user;
    
    public List<Object> getAllNotes(){
        executeHQL("from User");
        return list;
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
    
    public void addwithProfile(User user, Profile profile){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String string = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        user.setRegDate(string);
        user.setProfile(profile);
        profile.setUser(user);
        session.save(user);
        session.save(profile);
        session.getTransaction().commit();
        session.close();
    }
    
    public void delete(int i){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User user = (User) session.load(User.class, i);
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }
    
    public int amount(){
        getAllNotes();
        return list.size();
    }
    
}
