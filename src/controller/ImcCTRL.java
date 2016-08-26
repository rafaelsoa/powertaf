
package controller;

import dao.ImcDAO;
import java.util.Calendar;
import java.util.List;
import model.Imc;


public class ImcCTRL {
    
    private ImcDAO dao;
    public ImcCTRL(){
    dao = new ImcDAO();
   }
    
    public boolean insert (int peso, Calendar data){
        Imc imc = new Imc();
        imc.setPeso(peso);
        imc.setData(data);
        return dao.insert(imc);
        
    }
    
    
    public List<Imc> listImc (String filter){
    
        if (filter == null){
          return dao.selectAll();
        } else{
            return dao.selectFilter(filter);
        }
        
    }
    
    public void delete (Imc imc){
    dao.delete(imc);
    
    
    }
  
}


