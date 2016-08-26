
package controller;

import dao.ModalidadeDAO;
import java.util.List;
import model.Modalidade;


public class ModalidadeCTRL {
   
    private ModalidadeDAO dao;
    public ModalidadeCTRL(){
    dao = new ModalidadeDAO();
    }
    
  public boolean insert (String nome, String observacao){
        Modalidade modalidade = new Modalidade();
        modalidade.setModalidade(nome);
        modalidade.setObservacao(observacao);
        return dao.insert(modalidade);
        
    }
    
    public List<Modalidade> listModalidade (String filter){
    
        if (filter == null){
          return dao.selectAll();
        } else{
            return dao.selectFilter(filter);
        }
        
    }
  
    public void delete (Modalidade modalidade){
    dao.delete(modalidade);
    }
    
     
  
}
