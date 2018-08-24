/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projovem.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author admprojovem
 */
@Entity
@Table
public class Questao implements Serializable{

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false, length = 250)
    private String pergunta;

    @ManyToOne
    private Instrumento instrumento;

    @Column(nullable = false, length = 25)
    private String tipoResposta;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<RenderedIfResposta> renderedIfResposta;

    @Column(nullable = true, length = 250)
    private String titulo;

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

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
     * @return the tipoResposta
     */
    public String getTipoResposta() {
        return tipoResposta;
    }

    /**
     * @param tipoResposta the tipoResposta to set
     */
    public void setTipoResposta(String tipoResposta) {
        this.tipoResposta = tipoResposta;
    }

    /**
     * @return the instrumento
     */
    public Instrumento getInstrumento() {
        return instrumento;
    }

    /**
     * @param instrumento the instrumento to set
     */
    public void setInstrumento(Instrumento instrumento) {
        this.instrumento = instrumento;
    }

    /**
     * @return the numero
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * @return the renderedIfResposta
     */
    public List<RenderedIfResposta> getRenderedIfResposta() {
        return renderedIfResposta;
    }

    /**
     * @param renderedIfResposta the renderedIfResposta to set
     */
    public void setRenderedIfResposta(List<RenderedIfResposta> renderedIfResposta) {
        this.renderedIfResposta = renderedIfResposta;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    
}
