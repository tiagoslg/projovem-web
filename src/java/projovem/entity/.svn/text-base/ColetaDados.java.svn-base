/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author admprojovem
 */
@Entity
@Table
public class ColetaDados implements Serializable {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<RespostaDada> respostasDadas;

    @OneToOne
    private Instrumento instrumento;

    @OneToOne
    private Usuario usuario;

    @OneToOne
    private Endereco enderecoLocal;

    @ManyToMany
    private List<Endereco> multiplosEnderecosLocal;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataLancamento;
    
    @Transient
    private Local local;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the instrumento
     */
    public Instrumento getInstrumento() {
        return instrumento;
    }

    /**
     * @param instrumento the instrumento to set
     */
    public void setInstrumento(Instrumento instrumento) {
        this.instrumento = instrumento;
    }

    /**
     * @return the respostasDadas
     */
    public List<RespostaDada> getRespostasDadas() {
        return respostasDadas;
    }

    /**
     * @param respostasDadas the respostasDadas to set
     */
    public void setRespostasDadas(List<RespostaDada> respostasDadas) {
        this.respostasDadas = respostasDadas;
    }

    /**
     * @return the enderecoLocal
     */
    public Endereco getEnderecoLocal() {
        return enderecoLocal;
    }

    /**
     * @param enderecoLocal the enderecoLocal to set
     */
    public void setEnderecoLocal(Endereco enderecoLocal) {
        this.enderecoLocal = enderecoLocal;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the dataLancamento
     */
    public Date getDataLancamento() {
        return dataLancamento;
    }

    /**
     * @param dataLancamento the dataLancamento to set
     */
    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    /**
     * @return the local
     */
    public Local getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(Local local) {
        this.local = local;
    }

    /**
     * @return the multiplosEnderecosLocal
     */
    public List<Endereco> getMultiplosEnderecosLocal() {
        return multiplosEnderecosLocal;
    }

    /**
     * @param multiplosEnderecosLocal the multiplosEnderecosLocal to set
     */
    public void setMultiplosEnderecosLocal(List<Endereco> multiplosEnderecosLocal) {
        this.multiplosEnderecosLocal = multiplosEnderecosLocal;
    }
}
