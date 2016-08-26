
package model;

import java.util.Calendar;
import java.util.List;

public class Aluno {
    
    private int matricula;
    private String nome;
    private Calendar datanasc;
    private String cpf;
    private String sexo;
    private String endereco;
    private String telefone1;
    private String telefone2;
    private String email;
    private String observacao;
    private int altura;
    private List<Modalidade> modalidades;
    private List<Imc> imcs;
    private List<Indice> indeces;

    public Aluno() {
    }

    public Aluno(int matricula, String nome, Calendar datanasc, String cpf, String sexo, String endereco, String telefone1, String telefone2, String email, String observacao, int altura, List<Modalidade> modalidades, List<Imc> imcs, List<Indice> indeces) {
        this.matricula = matricula;
        this.nome = nome;
        this.datanasc = datanasc;
        this.cpf = cpf;
        this.sexo = sexo;
        this.endereco = endereco;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.email = email;
        this.observacao = observacao;
        this.altura = altura;
        this.modalidades = modalidades;
        this.imcs = imcs;
        this.indeces = indeces;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(Calendar datanasc) {
        this.datanasc = datanasc;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public List<Modalidade> getModalidades() {
        return modalidades;
    }

    public void setModalidades(List<Modalidade> modalidades) {
        this.modalidades = modalidades;
    }

    public List<Imc> getImcs() {
        return imcs;
    }

    public void setImcs(List<Imc> imcs) {
        this.imcs = imcs;
    }

    public List<Indice> getIndeces() {
        return indeces;
    }

    public void setIndeces(List<Indice> indeces) {
        this.indeces = indeces;
    }

    @Override
    public String toString() {
        return "Aluno{" + "matricula=" + matricula + ", nome=" + nome + ", datanasc=" + datanasc + ", cpf=" + cpf + ", sexo=" + sexo + ", endereco=" + endereco + ", telefone1=" + telefone1 + ", telefone2=" + telefone2 + ", email=" + email + ", observacao=" + observacao + ", altura=" + altura + ", modalidades=" + modalidades + ", imcs=" + imcs + ", indeces=" + indeces + '}';
    }
    
    
    
}
