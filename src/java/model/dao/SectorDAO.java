/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.RequestTree;
import model.pojo.Sector;
import model.pojo.Soil;
import model.pojo.Tree;
import model.util.NewHibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author 7853j
 */
public class SectorDAO extends AbstractDAO{
    
    public List<Object> getAllNotes(){
        executeHQL("from Sector");
        return list;
    }
    
    public Sector getSector(int page){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Sector sector = (Sector) session.get(Sector.class, page);
        session.getTransaction().commit();
        session.close();
        return sector;
    }
    
    public Tree getTreeBySector(Sector sector){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Tree tree =  (Tree) session.get(Tree.class, sector.getTree().getIdTree());
        session.getTransaction().commit();
        session.close();
        return tree;
    }
            
    public Soil getSoilBySector(Sector sector){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Soil soil =  (Soil) session.get(Soil.class, sector.getSoil().getIdSoil());
        session.getTransaction().commit();
        session.close();
        return soil;
    }
    
    public int amount(){
        getAllNotes();
        return list.size();
    }
}
