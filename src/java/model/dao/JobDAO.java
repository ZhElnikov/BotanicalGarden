/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.Job;
import model.util.NewHibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author 7853j
 */
public class JobDAO extends AbstractDAO{
    
    Job job;
    
    public List<Object> getAllNotes(){
        executeHQL("from Job");
        return list;
    }
    
    public String getStringJob(int i){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        this.job =  (Job) session.get(Job.class, i + 1);
        String result = "Задание: " + this.job.getBody() + "\r\nРаботник: " + this.job.getUser().getProfile().getName() + " " + this.job.getUser().getProfile().getSurname() + "\r\nсрок - " + this.job.getDeadline();
        session.getTransaction().commit();
        session.close();
        return result;
    }
    
    public List<Object> getJobsForUser(int i){
        executeHQL("from Job where id_user = " + i);
        return list;
    }
    
    public int amount(){
        getAllNotes();
        return list.size();
    }
}
