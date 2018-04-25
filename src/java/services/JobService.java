/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.dao.JobDAO;
import model.dao.UserDAO;
import model.pojo.Job;
import model.pojo.User;
/**
 *
 * @author 7853j
 */
public class JobService {
    
    static JobDAO dao = new JobDAO();
    static UserDAO userdao = new UserDAO();
    
    static public String getJobsString(String login){
        User user = userdao.getUserByLogin(login);
        List<Object> jobs = getUserJobs(user);
        String result = "Список работ: \r\n";
        for (int i = 0; i < jobs.size(); i++){
            Job temp = (Job) jobs.get(i);
            result += "Задание: " + temp.getBody() + " срок - " + temp.getDeadline();
            result += "\r\n";
        }
        return result;
    }
    
    static public List<String> getAllJobsListString(){
        int amount  = dao.amount();
        List<String> result = new ArrayList<>();
        String nres;
        List<Job> jobs = getAllJobsList();
        for (int i = 0; i < amount; i++){
            nres = dao.getStringJob(jobs.get(i).getIdJob());
            result.add(nres);
        }
        return result; 
    }
    
    static public List<Job> getAllJobsList(){
        int amount  = dao.amount();
        List<Object> list = dao.getAllNotes();
        List<Job> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            result.add((Job)list.get(i));
        }
        return result; 
    }
    
    static public List<Job> getUserJobsList(String login){
        User user = userdao.getUserByLogin(login);
        List<Object> jobs = getUserJobs(user);
        List<Job> result = new ArrayList<>();
        String nres;
        for (int i = 0; i < jobs.size(); i++){
            Job temp = (Job) jobs.get(i);
            result.add(temp);
        }
        return result;   
    } 
    
    static public List<Object> getUserJobs(User user){
        List<Object> jobs = dao.getJobsForUser(user.getIdUser());
        for (int i = 0; i < jobs.size(); i++) {
            Job temp = (Job) jobs.get(i);
            if (temp.getEndDate() != null){
                jobs.remove(i);
                i--;
            }
        }
        return jobs;
    }
    
    static public void addJob(Job job, int userId){
        dao.addWithId(job, userId);
    }
    
    static public void deleteJob(Job job){
        dao.delete(job.getIdJob());
    }
    
    static public void completeJob(Job job){
        String endDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        dao.complete(job.getIdJob(), endDate);
    }
}
