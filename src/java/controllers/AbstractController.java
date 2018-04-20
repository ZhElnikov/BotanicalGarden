/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import model.util.*;

/**
 *
 * @author 7853j
 */
public class AbstractController {
    
    List<Object> list;
    
    void executeHQL(String hql){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery(hql);
        list = q.list();
        session.getTransaction().commit();
        session.close();
    }
    
}
