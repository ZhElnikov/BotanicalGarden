/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.pojo.Profile;
import java.util.List;
import model.pojo.Job;
import model.pojo.User;
import model.util.NewHibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
/**
 *
 * @author 7853j
 */
public class ProfileDAO extends AbstractDAO{
    
    Profile profile;
    
    public List<Object> getAllNotes(){
        executeHQL("from Profile");
        return list;
    }
    
    public Profile getProfile(int i){
        executeHQL("from Profile where id_profile = " + i);
        this.profile = (Profile) list.get(0);
        return this.profile;
    }
    
    public void add(Profile profile){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(profile);
        session.getTransaction().commit();
        session.close();
    }
    
    public void delete(int i){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Profile prof = (Profile) session.load(Profile.class, i);
        session.delete(prof);
        session.getTransaction().commit();
        session.close();
    }
    
    public int amount(){
        getAllNotes();
        return list.size();
    }
}
