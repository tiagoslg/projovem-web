/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projovem.vo;

import java.util.ArrayList;
import java.util.List;
import projovem.entity.RespostaDada;

/**
 *
 * @author admprojovem
 */
public class RespostasDadas {

    private String respostasMonovaloradas = new String();
    private List<RespostaDada> respostasTextuais = new ArrayList<RespostaDada>();

    /**
     * @return the respostasMonovaloradas
     */
    public String getRespostasMonovaloradas() {
        return respostasMonovaloradas;
    }

    /**
     * @param respostasMonovaloradas the respostasMonovaloradas to set
     */
    public void setRespostasMonovaloradas(String respostasMonovaloradas) {
        this.respostasMonovaloradas = respostasMonovaloradas;
    }

    /**
     * @return the respostasTextuais
     */
    public List<RespostaDada> getRespostasTextuais() {
        return respostasTextuais;
    }

    /**
     * @param respostasTextuais the respostasTextuais to set
     */
    public void setRespostasTextuais(List<RespostaDada> respostasTextuais) {
        this.respostasTextuais = respostasTextuais;
    }

}
