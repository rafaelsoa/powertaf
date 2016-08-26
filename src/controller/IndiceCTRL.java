
package controller;

import dao.IndiceDAO;
import java.util.Calendar;
import java.util.List;
import model.Indice;


public class IndiceCTRL {
    
    private IndiceDAO dao;
    public IndiceCTRL(){
    dao = new IndiceDAO();
    }
    
  public boolean insert (Calendar data, String indiceAL, String observacao){
        Indice indice = new Indice();
        indice.setData(data);
        indice.setIndice(indiceAL);
        return dao.insert(indice);
        
    }

    
    public List<Indice> listIndice (String filter){
    
        if (filter == null){
          return dao.selectAll();
        } else{
            return null;
        }
        
    }
  
    public void delete (Indice indice){
    dao.delete(indice);
    }
    
    
  
    
    
}
