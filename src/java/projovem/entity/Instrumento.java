/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projovem.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author admprojovem
 */
@Entity
@Table
public class Instrumento implements Serializable{

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String codigo;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false,length=1000)
    private String textoAbertura;

    @Column(nullable = false,length=20)
    private String aplicadoEmLocaisDoTipo;

    @Column(nullable = false,length=1)
    private String permiteSelecaoDeMultiplosNucleos;

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
     * @return the numero
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param numero the numero to set
     */
    public void setCodigo(String numero) {
        this.codigo = numero;
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
     * @return the textoAbertura
     */
    public String getTextoAbertura() {
        return textoAbertura;
    }

    /**
     * @param textoAbertura the textoAbertura to set
     */
    public void setTextoAbertura(String textoAbertura) {
        this.textoAbertura = textoAbertura;
    }

    /**
     * @return the aplicadoEmLocaisDoTipo
     */
    public String getAplicadoEmLocaisDoTipo() {
        return aplicadoEmLocaisDoTipo;
    }

    /**
     * @param aplicadoEmLocaisDoTipo the aplicadoEmLocaisDoTipo to set
     */
    public void setAplicadoEmLocaisDoTipo(String aplicadoEmLocaisDoTipo) {
        this.aplicadoEmLocaisDoTipo = aplicadoEmLocaisDoTipo;
    }

    /**
     * @return the permiteSelecaoDeMultiplosNucleos
     */
    public String getPermiteSelecaoDeMultiplosNucleos() {
        return permiteSelecaoDeMultiplosNucleos;
    }

    /**
     * @param permiteSelecaoDeMultiplosNucleos the permiteSelecaoDeMultiplosNucleos to set
     */
    public void setPermiteSelecaoDeMultiplosNucleos(String permiteSelecaoDeMultiplosNucleos) {
        this.permiteSelecaoDeMultiplosNucleos = permiteSelecaoDeMultiplosNucleos;
    }


        
}
