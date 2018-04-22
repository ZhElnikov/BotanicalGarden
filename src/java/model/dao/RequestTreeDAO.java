/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.pojo.RequestTree;
import model.pojo.Tree;
import model.util.NewHibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author 7853j
 */
public class RequestTreeDAO extends AbstractDAO{
    RequestTree rt;
    
    public List<Object> getAllNotes(){
        executeHQL("from RequestTree");
        return list;
    }
    
    public List<String> getAllNames(){
        executeHQL("from RequestTree");
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            Tree tree =  (Tree) session.get(Tree.class, i + 1);
            result.add(tree.getName()); 
        }
        session.getTransaction().commit();
        session.close();
        return result;
    }
    
    public void changeStatus(int id, int stat){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        RequestTree requestTree =  (RequestTree) session.get(RequestTree.class, id);
        requestTree.setStatus(stat);
        session.saveOrUpdate(requestTree);
        session.getTransaction().commit();
        session.close();
    }
    
    public int amount(){
        getAllNotes();
        return list.size();
    }
}
