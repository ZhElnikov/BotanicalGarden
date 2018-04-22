/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;

/**
 *
 * @author 7853j
 */
public class TreeDAO extends AbstractDAO{
    
    public List<Object> getAllNotes(){
        executeHQL("from Tree");
        return list;
    }
    
    public int amount(){
        getAllNotes();
        return list.size();
    }
}
