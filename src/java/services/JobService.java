/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

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
    
    static public String getJobs(String login){
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
    
    static public List<Object> getUserJobs(User user){
        List<Object> jobs = dao.getJobsForUser(user.getIdUser());
        return jobs;
    }
}
