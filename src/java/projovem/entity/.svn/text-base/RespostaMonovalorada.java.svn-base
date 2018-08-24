/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projovem.entity;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 *
 * @author admprojovem
 */

@Entity
@Table

public class RespostaMonovalorada extends Resposta {



    @Column(nullable = true, length = 250)
    private String respostaMonovalorada;

    @OneToOne
    private Resposta respostaOpcional;

    

    
    /**
     * @return the resposta
     */
    public String getResposta() {
        return respostaMonovalorada;
    }

    /**
     * @param resposta the resposta to set
     */
    public void setResposta(String resposta) {
        this.respostaMonovalorada = resposta;
    }

    /**
     * @return the respostaOpcional
     */
    public Resposta getRespostaOpcional() {
        return respostaOpcional;
    }

    /**
     * @param respostaOpcional the respostaOpcional to set
     */
    public void setRespostaOpcional(Resposta respostaOpcional) {
        this.respostaOpcional = respostaOpcional;
    }


}