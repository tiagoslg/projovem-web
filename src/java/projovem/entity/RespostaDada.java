/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projovem.entity;

import java.io.Serializable;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author admprojovem
 */
@Entity
@Table
public class RespostaDada implements Serializable{

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;

    @OneToOne
    private Resposta resposta;

    @Column(nullable = true, length = 1000)
    private String valor;

    @Transient
    private List<SelectItem> listSelectItem;

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
     * @return the resposta
     */
    public Resposta getResposta() {
        return resposta;
    }

    /**
     * @param resposta the resposta to set
     */
    public void setResposta(Resposta resposta) {
        this.resposta = resposta;
    }

    /**
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * @return the listSelectItem
     */
    public List<SelectItem> getListSelectItem() {
        return listSelectItem;
    }

    /**
     * @param listSelectItem the listSelectItem to set
     */
    public void setListSelectItem(List<SelectItem> listSelectItem) {
        this.listSelectItem = listSelectItem;
    }

}
