/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projovem.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author admprojovem
 */
@Entity
@Table
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Resposta implements Serializable{

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;

    @ManyToOne
    private Questao questao;

    @Column(nullable = true)
    private String textoAfirmativo;

    @Column(nullable = true)
    private Integer peso;


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
     * @return the questao
     */
    public Questao getQuestao() {
        return questao;
    }

    /**
     * @param questao the questao to set
     */
    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    /**
     * @return the textoAfirmativo
     */
    public String getTextoAfirmativo() {
        return textoAfirmativo;
    }

    /**
     * @param textoAfirmativo the textoAfirmativo to set
     */
    public void setTextoAfirmativo(String textoAfirmativo) {
        this.textoAfirmativo = textoAfirmativo;
    }

    /**
     * @return the peso
     */
    public Integer getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(Integer peso) {
        this.peso = peso;
    }
}
