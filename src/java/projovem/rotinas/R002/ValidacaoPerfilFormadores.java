/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.rotinas.R002;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Leandro Nunes
 */
public class ValidacaoPerfilFormadores {

    public static boolean validaRotina(Rotina002PerfilFormadores rotina) {

        boolean rotinaValida = true;

        if (rotina.getNome() == null || (rotina.getNome() != null && rotina.getNome().isEmpty())) {
            rotinaValida = false;
            String message = "O nome deve ser informado";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if (rotina.getDia() == null || (rotina.getDia() != null && rotina.getDia().isEmpty())) {
            rotinaValida = false;
            String message = "A data deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if (rotina.getInstituicaoFormadora() == null || (rotina.getInstituicaoFormadora() != null && rotina.getInstituicaoFormadora().isEmpty())) {
            rotinaValida = false;
            String message = "A Instituição Formadora deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if (rotina.getDataInicio() == null || (rotina.getDataInicio() != null && rotina.getDataInicio().isEmpty())) {
            rotinaValida = false;
            String message = "A data de inicio deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if (rotina.getDataTermino() == null || (rotina.getDataTermino() != null && rotina.getDataTermino().isEmpty())) {
            rotinaValida = false;
            String message = "A data de termino deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ1() == null || (rotina.getQ1() != null && rotina.getQ1().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 1 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if (rotina.getQ2() == null || (rotina.getQ2() != null && rotina.getQ2().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 2 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if (rotina.getQ3() == null || (rotina.getQ3() != null && rotina.getQ3().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 3 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if (rotina.getQ4() == null || (rotina.getQ4() != null && rotina.getQ4().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 4 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if (rotina.getQ5() == null || (rotina.getQ5() != null && rotina.getQ5().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 5 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if (rotina.getQ6() == null || (rotina.getQ6() != null && rotina.getQ6().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 6 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if (rotina.getQ7() == null || (rotina.getQ7() != null && rotina.getQ7().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 7 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if (rotina.getQ8() == null || (rotina.getQ8() != null && rotina.getQ8().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 8 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        return rotinaValida;
    }
}
