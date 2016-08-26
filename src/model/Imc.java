
package model;

import java.util.Calendar;
import java.util.List;



public class Imc {
    
    private int id;
    private int peso;
    private Calendar data;
    private String observacao;
    private List<Aluno> alunos;

    public Imc() {
    }

    public Imc(int id, int peso, Calendar data, String observacao, List<Aluno> alunos) {
        this.id = id;
        this.peso = peso;
        this.data = data;
        this.observacao = observacao;
        this.alunos = alunos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public String toString() {
        return "Imc{" + "id=" + id + ", peso=" + peso + ", data=" + data + ", observacao=" + observacao + ", alunos=" + alunos + '}';
    }
    
   
    
}
