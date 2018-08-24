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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author admprojovem
 */
@Entity
@Table
public class RespostaMaterial implements Serializable {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = true)
    private String arco;

    @Column(nullable = true)
    private String instalacaoDisponivel;

    @Column(nullable = true)
    private String materialPermanente;

    @Column(nullable = true)
    private String quantidadeMaterialPermanente;

    @Column(nullable = true)
    private String materialConsumo;

    @Column(nullable = true)
    private String quantidadeMaterialConsumo;

    @ManyToOne
    private ColetaDados coleta;

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
     * @return the arco
     */
    public String getArco() {
        return arco;
    }

    /**
     * @param arco the arco to set
     */
    public void setArco(String arco) {
        this.arco = arco;
    }

    /**
     * @return the instalacaoDisponivel
     */
    public String getInstalacaoDisponivel() {
        return instalacaoDisponivel;
    }

    /**
     * @param instalacaoDisponivel the instalacaoDisponivel to set
     */
    public void setInstalacaoDisponivel(String instalacaoDisponivel) {
        this.instalacaoDisponivel = instalacaoDisponivel;
    }

    /**
     * @return the materialPermanente
     */
    public String getMaterialPermanente() {
        return materialPermanente;
    }

    /**
     * @param materialPermanente the materialPermanente to set
     */
    public void setMaterialPermanente(String materialPermanente) {
        this.materialPermanente = materialPermanente;
    }

    /**
     * @return the quantidadeMaterialPermanente
     */
    public String getQuantidadeMaterialPermanente() {
        return quantidadeMaterialPermanente;
    }

    /**
     * @param quantidadeMaterialPermanente the quantidadeMaterialPermanente to set
     */
    public void setQuantidadeMaterialPermanente(String quantidadeMaterialPermanente) {
        this.quantidadeMaterialPermanente = quantidadeMaterialPermanente;
    }

    /**
     * @return the materialConsumo
     */
    public String getMaterialConsumo() {
        return materialConsumo;
    }

    /**
     * @param materialConsumo the materialConsumo to set
     */
    public void setMaterialConsumo(String materialConsumo) {
        this.materialConsumo = materialConsumo;
    }

    /**
     * @return the quantidadeMaterialConsumo
     */
    public String getQuantidadeMaterialConsumo() {
        return quantidadeMaterialConsumo;
    }

    /**
     * @param quantidadeMaterialConsumo the quantidadeMaterialConsumo to set
     */
    public void setQuantidadeMaterialConsumo(String quantidadeMaterialConsumo) {
        this.quantidadeMaterialConsumo = quantidadeMaterialConsumo;
    }

    /**
     * @return the coleta
     */
    public ColetaDados getColeta() {
        return coleta;
    }

    /**
     * @param coleta the coleta to set
     */
    public void setColeta(ColetaDados coleta) {
        this.coleta = coleta;
    }

}
