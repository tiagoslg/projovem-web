/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projovem.nucleo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import projovem.entity.Usuario;

/**
 *
 * @author admprojovem
 */
@Entity
@Table
public class Nucleo implements Serializable{
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = true)
    private String ir;
    @Column(nullable = true)
    private String coordenacao;
    @Column(nullable = true)
    private String referencia;
    @Column(nullable = true)
    private String logradouro;
    @Column(nullable = true)
    private String numero;
    @Column(nullable = true)
    private String complemento;
    @Column(nullable = true)
    private String bairro;
    @Column(nullable = true)
    private String municipio;
    @Column(nullable = true)
    private String uf;
    @Column(nullable = true)
    private String cep;
    @Column(nullable = true)
    private String entrada;
    @Column(nullable = true)
    private String codigoCAED;

    @OneToOne
    private Usuario usuario;

    @Column(nullable = true)
    private String justificativa;


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }



    @Transient
    private String selecionado;

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCoordenacao() {
        return coordenacao;
    }

    public void setCoordenacao(String coordenacao) {
        this.coordenacao = coordenacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIr() {
        return ir;
    }

    public void setIr(String ir) {
        this.ir = ir;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(String selecionado) {
        this.selecionado = selecionado;
    }

    /**
     * @return the entrada
     */
    public String getEntrada() {
        return entrada;
    }

    /**
     * @param entrada the entrada to set
     */
    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    /**
     * @return the codigoCAED
     */
    public String getCodigoCAED() {
        return codigoCAED;
    }

    /**
     * @param codigoCAED the codigoCAED to set
     */
    public void setCodigoCAED(String codigoCAED) {
        this.codigoCAED = codigoCAED;
    }

    
}
