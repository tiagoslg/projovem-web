/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.rotinas.R006;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author admprojovem
 */
@Entity
@Table
public class Rotina006ArcosOcupacionaisMateriais2 implements Serializable {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = true)
    private String IdentificacaoArco;
    @Column(nullable = true, columnDefinition = "TEXT")
    private String InstalacoesDisponiveis;
    @Column(nullable = true, columnDefinition = "TEXT")
    private String MaterialPermanente;
    @Column(nullable = true)
    private String MaterialPermanenteQuantidade;
    @Column(nullable = true, columnDefinition = "TEXT")
    private String MaterialConsumo;
    @Column(nullable = true)
    private String MaterialConsumoQuantidade;

    public String getIdentificacaoArco() {
        return IdentificacaoArco;
    }

    public void setIdentificacaoArco(String IdentificacaoArco) {
        this.IdentificacaoArco = IdentificacaoArco;
    }

    public String getInstalacoesDisponiveis() {
        return InstalacoesDisponiveis;
    }

    public void setInstalacoesDisponiveis(String InstalacoesDisponiveis) {
        this.InstalacoesDisponiveis = InstalacoesDisponiveis;
    }

    public String getMaterialConsumo() {
        return MaterialConsumo;
    }

    public void setMaterialConsumo(String MaterialConsumo) {
        this.MaterialConsumo = MaterialConsumo;
    }

    public String getMaterialConsumoQuantidade() {
        return MaterialConsumoQuantidade;
    }

    public void setMaterialConsumoQuantidade(String MaterialConsumoQuantidade) {
        this.MaterialConsumoQuantidade = MaterialConsumoQuantidade;
    }

    public String getMaterialPermanente() {
        return MaterialPermanente;
    }

    public void setMaterialPermanente(String MaterialPermanente) {
        this.MaterialPermanente = MaterialPermanente;
    }

    public String getMaterialPermanenteQuantidade() {
        return MaterialPermanenteQuantidade;
    }

    public void setMaterialPermanenteQuantidade(String MaterialPermanenteQuantidade) {
        this.MaterialPermanenteQuantidade = MaterialPermanenteQuantidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
}
