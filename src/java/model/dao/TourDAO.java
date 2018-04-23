/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.Tour;
import model.util.NewHibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author 7853j
 */
public class TourDAO extends AbstractDAO{
    
    public List<Object> getAllNotes(){
        executeHQL("from Tour");
        return list;
    }
    
    public void add(Tour tour){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(tour);
        session.getTransaction().commit();
        session.close();
    }
    
    public void delete(int i){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Tour tour = (Tour) session.load(Tour.class, i);
        session.delete(tour);
        session.getTransaction().commit();
        session.close();
    }
    
    public int amount(){
        getAllNotes();
        return list.size();
    }
}
