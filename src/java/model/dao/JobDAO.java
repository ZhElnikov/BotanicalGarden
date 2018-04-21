/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.Job;

/**
 *
 * @author 7853j
 */
public class JobDAO extends AbstractDAO{
    
    Job job;
    
    public void getAllNotes(){
        executeHQL("from Job");
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
