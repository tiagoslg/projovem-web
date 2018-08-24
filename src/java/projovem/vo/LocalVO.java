/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projovem.vo;

import java.io.Serializable;
import projovem.entity.Endereco;

/**
 *
 * @author admprojovem
 */
public class LocalVO implements Serializable {


    private Integer id;
    private String codigo;
    private String nome;
    private String tipoLocal;
    private Endereco endereco;
    private String selecionado;

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
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the tipoLocal
     */
    public String getTipoLocal() {
        return tipoLocal;
    }

    /**
     * @param tipoLocal the tipoLocal to set
     */
    public void setTipoLocal(String tipoLocal) {
        this.tipoLocal = tipoLocal;
    }

    /**
     * @return the enderecos
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * @param enderecos the enderecos to set
     */
    public void setEndereco(Endereco enderecos) {
        this.endereco = enderecos;
    }

    /**
     * @return the selecionado
     */
    public String getSelecionado() {
        return selecionado;
    }

    /**
     * @param selecionado the selecionado to set
     */
    public void setSelecionado(String selecionado) {
        this.selecionado = selecionado;
    }


}
