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
public class InstituicaoRegional implements Serializable {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = true, length = 250)
    private String nome;

    @OneToMany
    private List<UF> uf;

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
     * @return the uf
     */
    public List<UF> getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(List<UF> uf) {
        this.uf = uf;
    }

}
