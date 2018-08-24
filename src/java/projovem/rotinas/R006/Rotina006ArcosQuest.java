/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.rotinas.R006;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import projovem.entity.MaterialUtilizado;

/**
 *
 * @author admprojovem
 */
@Entity
@Table
public class Rotina006ArcosQuest implements Serializable {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = true, length=250)
    private String nomeEducador;
    @Column(nullable = true, length=250)
    private String arcoOcupacional;

    @Column(nullable = true)
    private Integer Q3;
    @Column(nullable = true)
    private Integer Q4;
    @Column(nullable = true)
    private Integer Q5;
    @Column(nullable = true, columnDefinition="TEXT")
    private String Q5Complemento;

    @Column(nullable = true, columnDefinition="TEXT")
    private String materialUtilizado;

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
     * @return the nomeEducador
     */
    public String getNomeEducador() {
        return nomeEducador;
    }

    /**
     * @param nomeEducador the nomeEducador to set
     */
    public void setNomeEducador(String nomeEducador) {
        this.nomeEducador = nomeEducador;
    }

    /**
     * @return the Q3
     */
    public Integer getQ3() {
        return Q3;
    }

    /**
     * @param Q3 the Q3 to set
     */
    public void setQ3(Integer Q3) {
        this.Q3 = Q3;
    }

    /**
     * @return the Q4
     */
    public Integer getQ4() {
        return Q4;
    }

    /**
     * @param Q4 the Q4 to set
     */
    public void setQ4(Integer Q4) {
        this.Q4 = Q4;
    }

    /**
     * @return the Q5
     */
    public Integer getQ5() {
        return Q5;
    }

    /**
     * @param Q5 the Q5 to set
     */
    public void setQ5(Integer Q5) {
        this.Q5 = Q5;
    }

    /**
     * @return the Q5Complemento
     */
    public String getQ5Complemento() {
        return Q5Complemento;
    }

    /**
     * @param Q5Complemento the Q5Complemento to set
     */
    public void setQ5Complemento(String Q5Complemento) {
        this.Q5Complemento = Q5Complemento;
    }

    /**
     * @return the materialUtilizado
     */
    public String getMaterialUtilizado() {
        return materialUtilizado;
    }

    /**
     * @param materialUtilizado the materialUtilizado to set
     */
    public void setMaterialUtilizado(String materialUtilizado) {
        this.materialUtilizado = materialUtilizado;
    }

    /**
     * @return the arcoOcupacional
     */
    public String getArcoOcupacional() {
        return arcoOcupacional;
    }

    /**
     * @param arcoOcupacional the arcoOcupacional to set
     */
    public void setArcoOcupacional(String arcoOcupacional) {
        this.arcoOcupacional = arcoOcupacional;
    }
    
}
