/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author a965866
 */
@Entity
@Table(name = "tb_alunos", catalog = "powertaf", schema = "")
@NamedQueries({
    @NamedQuery(name = "TbAlunos.findAll", query = "SELECT t FROM TbAlunos t"),
    @NamedQuery(name = "TbAlunos.findByAluId", query = "SELECT t FROM TbAlunos t WHERE t.aluId = :aluId"),
    @NamedQuery(name = "TbAlunos.findByAluNome", query = "SELECT t FROM TbAlunos t WHERE t.aluNome = :aluNome"),
    @NamedQuery(name = "TbAlunos.findByAluCpf", query = "SELECT t FROM TbAlunos t WHERE t.aluCpf = :aluCpf"),
    @NamedQuery(name = "TbAlunos.findByAluEndereco", query = "SELECT t FROM TbAlunos t WHERE t.aluEndereco = :aluEndereco"),
    @NamedQuery(name = "TbAlunos.findByAluSexo", query = "SELECT t FROM TbAlunos t WHERE t.aluSexo = :aluSexo"),
    @NamedQuery(name = "TbAlunos.findByAluTelefone1", query = "SELECT t FROM TbAlunos t WHERE t.aluTelefone1 = :aluTelefone1"),
    @NamedQuery(name = "TbAlunos.findByAluTelefone2", query = "SELECT t FROM TbAlunos t WHERE t.aluTelefone2 = :aluTelefone2"),
    @NamedQuery(name = "TbAlunos.findByAluEmail", query = "SELECT t FROM TbAlunos t WHERE t.aluEmail = :aluEmail"),
    @NamedQuery(name = "TbAlunos.findByAluDatanasc", query = "SELECT t FROM TbAlunos t WHERE t.aluDatanasc = :aluDatanasc"),
    @NamedQuery(name = "TbAlunos.findByAluObservacao", query = "SELECT t FROM TbAlunos t WHERE t.aluObservacao = :aluObservacao"),
    @NamedQuery(name = "TbAlunos.findByAluAltura", query = "SELECT t FROM TbAlunos t WHERE t.aluAltura = :aluAltura")})
public class TbAlunos implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ALU_ID")
    private Integer aluId;
    @Basic(optional = false)
    @Column(name = "ALU_NOME")
    private String aluNome;
    @Basic(optional = false)
    @Column(name = "ALU_CPF")
    private String aluCpf;
    @Basic(optional = false)
    @Column(name = "ALU_ENDERECO")
    private String aluEndereco;
    @Basic(optional = false)
    @Column(name = "ALU_SEXO")
    private String aluSexo;
    @Basic(optional = false)
    @Column(name = "ALU_TELEFONE1")
    private String aluTelefone1;
    @Column(name = "ALU_TELEFONE2")
    private String aluTelefone2;
    @Column(name = "ALU_EMAIL")
    private String aluEmail;
    @Column(name = "ALU_DATANASC")
    @Temporal(TemporalType.DATE)
    private Date aluDatanasc;
    @Column(name = "ALU_OBSERVACAO")
    private String aluObservacao;
    @Basic(optional = false)
    @Column(name = "ALU_ALTURA")
    private int aluAltura;

    public TbAlunos() {
    }

    public TbAlunos(Integer aluId) {
        this.aluId = aluId;
    }

    public TbAlunos(Integer aluId, String aluNome, String aluCpf, String aluEndereco, String aluSexo, String aluTelefone1, int aluAltura) {
        this.aluId = aluId;
        this.aluNome = aluNome;
        this.aluCpf = aluCpf;
        this.aluEndereco = aluEndereco;
        this.aluSexo = aluSexo;
        this.aluTelefone1 = aluTelefone1;
        this.aluAltura = aluAltura;
    }

    public Integer getAluId() {
        return aluId;
    }

    public void setAluId(Integer aluId) {
        Integer oldAluId = this.aluId;
        this.aluId = aluId;
        changeSupport.firePropertyChange("aluId", oldAluId, aluId);
    }

    public String getAluNome() {
        return aluNome;
    }

    public void setAluNome(String aluNome) {
        String oldAluNome = this.aluNome;
        this.aluNome = aluNome;
        changeSupport.firePropertyChange("aluNome", oldAluNome, aluNome);
    }

    public String getAluCpf() {
        return aluCpf;
    }

    public void setAluCpf(String aluCpf) {
        String oldAluCpf = this.aluCpf;
        this.aluCpf = aluCpf;
        changeSupport.firePropertyChange("aluCpf", oldAluCpf, aluCpf);
    }

    public String getAluEndereco() {
        return aluEndereco;
    }

    public void setAluEndereco(String aluEndereco) {
        String oldAluEndereco = this.aluEndereco;
        this.aluEndereco = aluEndereco;
        changeSupport.firePropertyChange("aluEndereco", oldAluEndereco, aluEndereco);
    }

    public String getAluSexo() {
        return aluSexo;
    }

    public void setAluSexo(String aluSexo) {
        String oldAluSexo = this.aluSexo;
        this.aluSexo = aluSexo;
        changeSupport.firePropertyChange("aluSexo", oldAluSexo, aluSexo);
    }

    public String getAluTelefone1() {
        return aluTelefone1;
    }

    public void setAluTelefone1(String aluTelefone1) {
        String oldAluTelefone1 = this.aluTelefone1;
        this.aluTelefone1 = aluTelefone1;
        changeSupport.firePropertyChange("aluTelefone1", oldAluTelefone1, aluTelefone1);
    }

    public String getAluTelefone2() {
        return aluTelefone2;
    }

    public void setAluTelefone2(String aluTelefone2) {
        String oldAluTelefone2 = this.aluTelefone2;
        this.aluTelefone2 = aluTelefone2;
        changeSupport.firePropertyChange("aluTelefone2", oldAluTelefone2, aluTelefone2);
    }

    public String getAluEmail() {
        return aluEmail;
    }

    public void setAluEmail(String aluEmail) {
        String oldAluEmail = this.aluEmail;
        this.aluEmail = aluEmail;
        changeSupport.firePropertyChange("aluEmail", oldAluEmail, aluEmail);
    }

    public Date getAluDatanasc() {
        return aluDatanasc;
    }

    public void setAluDatanasc(Date aluDatanasc) {
        Date oldAluDatanasc = this.aluDatanasc;
        this.aluDatanasc = aluDatanasc;
        changeSupport.firePropertyChange("aluDatanasc", oldAluDatanasc, aluDatanasc);
    }

    public String getAluObservacao() {
        return aluObservacao;
    }

    public void setAluObservacao(String aluObservacao) {
        String oldAluObservacao = this.aluObservacao;
        this.aluObservacao = aluObservacao;
        changeSupport.firePropertyChange("aluObservacao", oldAluObservacao, aluObservacao);
    }

    public int getAluAltura() {
        return aluAltura;
    }

    public void setAluAltura(int aluAltura) {
        int oldAluAltura = this.aluAltura;
        this.aluAltura = aluAltura;
        changeSupport.firePropertyChange("aluAltura", oldAluAltura, aluAltura);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aluId != null ? aluId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbAlunos)) {
            return false;
        }
        TbAlunos other = (TbAlunos) object;
        if ((this.aluId == null && other.aluId != null) || (this.aluId != null && !this.aluId.equals(other.aluId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.TbAlunos[ aluId=" + aluId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
