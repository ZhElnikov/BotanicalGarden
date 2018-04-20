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
public interface InterfaceDAO {
    List getAllNotes();
    List getFilterNotes(String column, String filter);
    int findNote(String column, String filter);
    int saveOrUpdate(Object o);
    void delNote(int i);
}
