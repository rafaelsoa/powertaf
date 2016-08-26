
package controller;

import dao.AlunoDAO;
import java.util.Calendar;
import java.util.List;
import model.Aluno;


public class AlunoCTRL {
    
    private List <Aluno> alunos; 
    private AlunoDAO dao;
    public AlunoCTRL(){
    dao = new AlunoDAO();}


    public void insert (Aluno aluno){
    dao.insert(aluno);
    }
    public List<Aluno> selectAll(){
    return alunos;
    }
    public void selectFilter(String filter){
       dao.selectFilter(filter);
    }
    public void update (Aluno aluno){
       dao.update(aluno);      
    }
    public void delete (Aluno aluno){
       dao.delete(aluno);
    }
    public void deletemodindaluno (Aluno aluno){
       dao.deletemodindaluno(aluno);   
    }  
    public void insertindice (Aluno aluno){
      dao.insertindice(aluno);
    }
    public void insertmoda (Aluno aluno){
       dao.insertmoda(aluno);
    }
    public void insertimc (Aluno aluno){
       dao.insertimc(aluno); 
    }
    public void selectAlModaInd (int id){
       dao.selectAlModaInd(id);
    }

    public Iterable<Aluno> selectAll(Object object) {
        return alunos;
    }
   
}

    
    
   
