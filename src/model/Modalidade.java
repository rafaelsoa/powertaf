
package model;

import java.util.List;

public class Modalidade {
    
    private int id;
    private String modalidade;
    private String observacao;
    private List<Aluno> alunos;
    private List<Indice> indice;

    public Modalidade() {
    }

    public Modalidade(int id, String modalidade, String observacao, List<Aluno> alunos, List<Indice> indice) {
        this.id = id;
        this.modalidade = modalidade;
        this.observacao = observacao;
        this.alunos = alunos;
        this.indice = indice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
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

    public List<Indice> getIndice() {
        return indice;
    }

    public void setIndice(List<Indice> indice) {
        this.indice = indice;
    }

    @Override
    public String toString() {
        return "Modalidade{" + "id=" + id + ", modalidade=" + modalidade + ", observacao=" + observacao + ", alunos=" + alunos + ", indice=" + indice + '}';
    }
   
    
    
    
}
