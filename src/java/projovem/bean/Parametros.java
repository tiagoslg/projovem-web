/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projovem.bean;

import java.io.Serializable;
import javax.faces.context.FacesContext;


/**
 *
 * @author admprojovem
 */
public class Parametros implements Serializable{

    private String numeroInstrumento;

    /**
     * @return the numeroInstrumento
     */
    public String getNumeroInstrumento() {
       numeroInstrumento = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("numeroInstrumento");
        return numeroInstrumento;
    }

    /**
     * @param numeroInstrumento the numeroInstrumento to set
     */
    public void setNumeroInstrumento(String numeroInstrumento) {
        this.numeroInstrumento = numeroInstrumento;
    }
   
}
