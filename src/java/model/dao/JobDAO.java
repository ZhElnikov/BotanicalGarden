/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

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
public class JobDAO extends AbstractDAO{
    
    Job job;
    
    public List<Object> getAllNotes(){
        executeHQL("from Job");
        return list;
    }
    
    public String getStringJob(int i){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        this.job =  (Job) session.get(Job.class, i);
        String result = "Задание: " + this.job.getBody() + "\r\nРаботник: " + this.job.getUser().getProfile().getName() + " " + this.job.getUser().getProfile().getSurname() + "\r\nсрок - " + this.job.getDeadline();
        session.getTransaction().commit();
        session.close();
        return result;
    }
    
    public List<Object> getJobsForUser(int i){
        executeHQL("from Job where id_user = " + i);
        return list;
    }
    
    public void addWithId(Job job, int id){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User user = (User) session.get(User.class, id);
        job.setUser(user);
        session.save(job);
        session.getTransaction().commit();
        session.close();
    }
    
    public void delete(int i){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Job job = (Job) session.load(Job.class, i);
        session.delete(job);
        session.getTransaction().commit();
        session.close();
    }
    
    public void complete(int i, String endDate){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Job job = (Job) session.load(Job.class, i);
        job.setEndDate(endDate);
        session.saveOrUpdate(job);
        session.getTransaction().commit();
        session.close();
    }
    
    public int amount(){
        getAllNotes();
        return list.size();
    }
}
