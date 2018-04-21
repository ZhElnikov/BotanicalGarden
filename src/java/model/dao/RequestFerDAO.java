/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.RequestFert;

/**
 *
 * @author 7853j
 */
public class RequestFerDAO extends AbstractDAO{
    RequestFert rf;
    
    public List<Object> getAllNotes(){
        executeHQL("from RequestFert");
        return list;
    }
    
    
    public int amount(){
        getAllNotes();
        return list.size();
    }
}
