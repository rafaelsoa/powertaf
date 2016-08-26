
package model;

import java.util.Calendar;
import java.util.List;



public class Indice {
    
   private int id;
   private String indice;
   private String observacao;
   private Calendar data;
   private List<Aluno> alunos;

    public Indice() {
    }

    public Indice(int id, String indice, String observacao, Calendar data, List<Aluno> alunos) {
        this.id = id;
        this.indice = indice;
        this.observacao = observacao;
        this.data = data;
        this.alunos = alunos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIndice() {
        return indice;
    }

    public void setIndice(String indice) {
        this.indice = indice;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public String toString() {
        return "Indice{" + "id=" + id + ", indice=" + indice + ", observacao=" + observacao + ", data=" + data + ", alunos=" + alunos + '}';
    }
  
   
}
