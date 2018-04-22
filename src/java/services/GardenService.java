/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import model.dao.SectorDAO;
import model.dao.SoilDAO;
import model.dao.TreeDAO;
import model.pojo.Sector;
import model.pojo.Soil;
import model.pojo.Tree;

/**
 *
 * @author 7853j
 */
public class GardenService {
    
    static SoilDAO soildao = new SoilDAO();
    static SectorDAO sectordao = new SectorDAO();
    static TreeDAO treedao = new TreeDAO();
    
    static public String getStringInfo(int page){
        String result = new String();
        Sector sector = sectordao.getSector(page);
        Tree tree = sectordao.getTreeBySector(sector);
        Soil soil = sectordao.getSoilBySector(sector);
        result += "Сектор - " + sector.getIdSector() + "\r\n";
        result += "Площадь сектора - " + sector.getSquare() + " кв.м.\r\n";
        result += "Засажен - " + tree.getName() + "\r\n";
        result += "Состояние: \r\n";
        result += "Гумус - опт: " + tree.getOptHumus() + "% реально: " + soil.getHumus() + "%\r\n";
        result += "Кислотность - опт: " + tree.getOptAcidity() + "% реально: " + soil.getAcidity() + "%\r\n";
        result += "Нитраты - опт: " + tree.getOptNitrate() + "% реально: " + soil.getNitrate() + "%\r\n";
        result += "Фосфор - опт: " + tree.getOptPhosphor()+ "% реально: " + soil.getPhosphor() + "%\r\n";
        return result;
    }
}
