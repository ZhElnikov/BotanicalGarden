/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import java.util.List;
import model.dao.TourDAO;
import model.pojo.Tour;
import static services.JobService.dao;

/**
 *
 * @author 7853j
 */
public class ExcursionService {
    
    static TourDAO dao = new TourDAO();
    
    static public List<Tour> getAllToursList(){
        int amount  = dao.amount();
        List<Object> list = dao.getAllNotes();
        List<Tour> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            result.add((Tour)list.get(i));
        }
        return result; 
    }
    
    static public void addTour(Tour tour){
        dao.add(tour);
    }
    
    static public void deleteTour(Tour tour){
        dao.delete(tour.getIdTour());
    }
}
