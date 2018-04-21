/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.pojo.Profile;
import java.util.List;
import model.pojo.User;
import org.hibernate.Query;
import org.hibernate.Session;
/**
 *
 * @author 7853j
 */
public class ProfileDAO extends AbstractDAO{
    
    Profile profile;
    
    public void getAllNotes(){
        executeHQL("from Profile");
    }
    
    public Profile getProfile(int i){
        executeHQL("from Profile where id_profile = " + i);
        this.profile = (Profile) list.get(0);
        return this.profile;
    }
    
    public int amount(){
        getAllNotes();
        return list.size();
    }
}
