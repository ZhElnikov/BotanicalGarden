/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import java.util.List;
import model.dao.RequestTreeDAO;
import model.dao.RequestFerDAO;
import model.pojo.RequestTree;
import model.pojo.RequestFert;

/**
 *
 * @author 7853j
 */
public class OrderService {
    
    static RequestFerDAO fertdao = new RequestFerDAO();
    static RequestTreeDAO treedao = new RequestTreeDAO();
    
    static public List<RequestFert> getFerts(){
        List<RequestFert> fertList = new ArrayList<RequestFert>();
        List<Object> list = fertdao.getAllNotes();
        for (int i = 0; i < list.size(); i++){
            fertList.add( (RequestFert) list.get(i));
        }
        return fertList;
    }
    
    static public List<RequestTree> getTrees(){
        List<RequestTree> treeList = new ArrayList<RequestTree>();
        List<Object> list = treedao.getAllNotes();
        for (int i = 0; i < list.size(); i++){
            treeList.add( (RequestTree) list.get(i));
        }
        return treeList;
    }
}
