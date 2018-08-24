/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.rotinas.R003;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author admprojovem
 */
@Entity
@Table
public class Rotina003_Rotina003Ficha implements Serializable {

    @Column(nullable = false)
    private Integer Rotina003_id;

    @Id
    @Column(nullable = false)
    private Integer listaFichas_id;

    @Transient
    List<String> atributos = new ArrayList<String>();

    public List<String> getAtributos() {
        return atributos;
    }

    public void setAtributos(List<String> atributos) {
        this.atributos = atributos;
    }
    
    public Integer getRotina003_id() {
        return Rotina003_id;
    }

    public void setRotina003_id(Integer Rotina003_id) {
        this.Rotina003_id = Rotina003_id;
    }

    public Integer getlistaFichas_id() {
        return listaFichas_id;
    }

    public void setlistaFichas_id(Integer listaFichas_id) {
        this.listaFichas_id = listaFichas_id;
    }
    
}
