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
import model.pojo.User;
import model.util.NewHibernateUtil;
import org.hibernate.Query;
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
            Tree tree =  (Tree) session.get(Tree.class, ((RequestTree)list.get(i)).getTree().getIdTree());
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
    
    public void add(String login, String name, String body, int q){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("From Tree where name like '" + name + "'");
        List<Object> trees = query.list();
        Tree tree = (Tree) trees.get(0);
        RequestTree requestTree = new RequestTree();
        requestTree.setTree(tree);
        UserDAO udao = new UserDAO();
        User user = udao.getUserByLogin(login);
        requestTree.setUser(user);
        requestTree.setBody(body);
        requestTree.setQuantity(q);
        requestTree.setStatus(0);
        session.saveOrUpdate(requestTree);
        session.getTransaction().commit();
        session.close();
    }
    
    public int amount(){
        getAllNotes();
        return list.size();
    }
}
