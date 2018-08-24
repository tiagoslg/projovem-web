/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projovem.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author admprojovem
 */
@Entity
@Table
public class RespostaTextual extends Resposta {

    

    @Column(nullable = true, length = 250)
    private String respostaTextual;

    @Column(nullable = true, length = 15)
    private String dataTypeResposta;

    @Column(nullable = false, length = 25)
    private String origemResposta;

    @Transient
    private boolean disabled = true;
    /**
     * @return the respostaTextualMultivalorada
     */
    public String getRespostaTextual() {
        return respostaTextual;
    }

    /**
     * @param respostaTextualMultivalorada the respostaTextualMultivalorada to set
     */
    public void setRespostaTextual(String respostaTextual) {
        this.respostaTextual = respostaTextual;
    }

    /**
     * @return the dataTypeResposta
     */
    public String getDataTypeResposta() {
        return dataTypeResposta;
    }

    /**
     * @param dataTypeResposta the dataTypeResposta to set
     */
    public void setDataTypeResposta(String dataTypeResposta) {
        this.dataTypeResposta = dataTypeResposta;
    }

    /**
     * @return the disabled
     */
    public boolean isDisabled() {
        return disabled;
    }

    /**
     * @param disabled the disabled to set
     */
    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    /**
     * @return the origemResposta
     */
    public String getOrigemResposta() {
        return origemResposta;
    }

    /**
     * @param origemResposta the origemResposta to set
     */
    public void setOrigemResposta(String origemResposta) {
        this.origemResposta = origemResposta;
    }

    
}
