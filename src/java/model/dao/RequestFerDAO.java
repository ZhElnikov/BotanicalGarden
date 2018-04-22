/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.RequestFert;
import model.pojo.RequestTree;
import model.pojo.User;
import model.util.NewHibernateUtil;
import org.hibernate.Query;
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
    public void add(String login, String name, String body, int q){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        RequestFert requestFert = new RequestFert();
        requestFert.setFertName(name);
        UserDAO udao = new UserDAO();
        User user = udao.getUserByLogin(login);
        requestFert.setUser(user);
        requestFert.setBody(body);
        requestFert.setQuantity(q);
        requestFert.setStatus(0);
        session.saveOrUpdate(requestFert);
        session.getTransaction().commit();
        session.close();
    }
    
    public int amount(){
        getAllNotes();
        return list.size();
    }
}
