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
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class MaterialUtilizado implements Serializable {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;

    
    @ManyToOne
    private Material material;

    @Column
    private int qtdIdentificada;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int getQtdIdentificada() {
        return qtdIdentificada;
    }

    public void setQtdIdentificada(int qtdIdentificada) {
        this.qtdIdentificada = qtdIdentificada;
    }

}
