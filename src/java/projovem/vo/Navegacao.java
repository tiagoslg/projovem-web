/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projovem.vo;

import java.io.Serializable;
import projovem.entity.Questao;

/**
 *
 * @author admprojovem
 */
public class Navegacao implements Serializable {

    private Questao questao;
    private boolean rendered;
    private String status;

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
     * @return the rendered
     */
    public boolean isRendered() {
        return rendered;
    }

    /**
     * @param rendered the rendered to set
     */
    public void setRendered(boolean rendered) {
        this.rendered = rendered;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

}
