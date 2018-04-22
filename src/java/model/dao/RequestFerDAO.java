/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.RequestFert;
import model.util.NewHibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author 7853j
 */
public class RequestFerDAO extends AbstractDAO{
    RequestFert rf;
    
    public List<Object> getAllNotes(){
        executeHQL("from RequestFert");
        return list;
    }
    
    public void changeStatus(int id, int stat){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        RequestFert requestFert =  (RequestFert) session.get(RequestFert.class, id);
        requestFert.setStatus(stat);
        session.saveOrUpdate(requestFert);
        session.getTransaction().commit();
        session.close();
    }
    
    public int amount(){
        getAllNotes();
        return list.size();
    }
}
