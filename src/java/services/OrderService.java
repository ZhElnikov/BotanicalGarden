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
        for (int i = 0; i < fertList.size(); i++) {
            RequestFert temp = (RequestFert) fertList.get(i);
            if (temp.getStatus() != 0){
                fertList.remove(i);
                i--;
            }
        }
        return fertList;
    }
    
    static public List<RequestTree> getTrees(){
        List<RequestTree> treeList = new ArrayList<RequestTree>();
        List<Object> list = treedao.getAllNotes();
        for (int i = 0; i < list.size(); i++){
            treeList.add( (RequestTree) list.get(i));
        }
        for (int i = 0; i < treeList.size(); i++) {
            RequestTree temp = (RequestTree) treeList.get(i);
            if (temp.getStatus() != 0){
                treeList.remove(i);
                i--;
            }
        }
        return treeList;
    }
    
    static public List<String> getTreesNames(){
        List<String> names = treedao.getAllNames();
        return names;
    }
    
    static public void changeStateTree(int id, int stat){
        treedao.changeStatus(id, stat);
    }
    static public void changeStateFert(int id, int stat){
        fertdao.changeStatus(id, stat);
    }
    
    static public void addTreeReq(String user, String name, String body, int q){
        treedao.add(user, name, body, q);
    }
    static public void addFertReq(String user, String name, String body, int q){
        fertdao.add(user, name, body, q);
    }
}
