/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.rotinas.R006;

import projovem.rotinas.R005.*;
import projovem.rotinas.R004.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Leandro Nunes
 */
public class ValidacaoCoordenacaoLocal {

    public static boolean validaRotina(Rotina006CoordenacaoLocal rotina) {

        boolean rotinaValida = true;

        if (rotina.getNomeLocal() != null && rotina.getNomeLocal().isEmpty()) {
            rotinaValida = false;
            String message = "Informe o nome do local";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getEnderecoLocal() != null && rotina.getEnderecoLocal().isEmpty()) {
            rotinaValida = false;
            String message = "Informe o Endereço do local";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getBairroLocal() != null && rotina.getBairroLocal().isEmpty()) {
            rotinaValida = false;
            String message = "Informe o Bairro do local";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getNumeroLocal() != null && rotina.getNumeroLocal().isEmpty()) {
            rotinaValida = false;
            String message = "Informe o Número do local";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getDataVisita() != null && rotina.getDataVisita().isEmpty()) {
            rotinaValida = false;
            String message = "A data da observação deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getHoraInicioVisita() != null && rotina.getHoraInicioVisita().isEmpty()) {
            rotinaValida = false;
            String message = "A hora de início da observação deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getHoraTerminoVisita() != null && rotina.getHoraTerminoVisita().isEmpty()) {
            rotinaValida = false;
            String message = "A hora de término da observação deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ1() != null && rotina.getQ1().isEmpty()) {
            rotinaValida = false;
            String message = "A Questão número 1 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ2() != null && rotina.getQ2().isEmpty()) {
            rotinaValida = false;
            String message = "A Questão número 2 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ3a() == null || rotina.getQ3a() != null && rotina.getQ3a().isEmpty() || rotina.getQ3a().equals("naoInformado")) {
            rotinaValida = false;
            String message = "O Arco A deve ser informado";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (((!rotina.getQ3b().equals("naoInformado") && !rotina.getQ3b().equals("semPrevisao")) && rotina.getQ3b().equals(rotina.getQ3a())) ||
                ((!rotina.getQ3c().equals("naoInformado") && !rotina.getQ3c().equals("semPrevisao")) && (rotina.getQ3c().equals(rotina.getQ3a()) || rotina.getQ3c().equals(rotina.getQ3b()))) ||
                ((!rotina.getQ3d().equals("naoInformado") && !rotina.getQ3d().equals("semPrevisao")) && (rotina.getQ3d().equals(rotina.getQ3a()) || rotina.getQ3d().equals(rotina.getQ3b()) || rotina.getQ3d().equals(rotina.getQ3c()))) ||
                ((!rotina.getQ3e().equals("naoInformado") && !rotina.getQ3e().equals("semPrevisao")) && (rotina.getQ3e().equals(rotina.getQ3a()) || rotina.getQ3e().equals(rotina.getQ3b()) || rotina.getQ3e().equals(rotina.getQ3c()) || rotina.getQ3e().equals(rotina.getQ3d())))) {
            rotinaValida = false;
            String message = "Os arcos devem ser diferentes entre si";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ4a() != null && rotina.getQ4a().isEmpty() && !rotina.getQ3a().equals("semPrevisao")) {
            rotinaValida = false;
            String message = "A Questão número 4 (Arco A) deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (!rotina.getQ3b().equals("naoInformado") && !rotina.getQ3b().equals("semPrevisao") && rotina.getQ4b() != null && rotina.getQ4b().isEmpty()) {
            rotinaValida = false;
            String message = "A Questão número 4 (Arco B) deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (!rotina.getQ3c().equals("naoInformado") && !rotina.getQ3c().equals("semPrevisao") && rotina.getQ4c() != null && rotina.getQ4c().isEmpty()) {
            rotinaValida = false;
            String message = "A Questão número 4 (Arco C) deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (!rotina.getQ3d().equals("naoInformado") && !rotina.getQ3d().equals("semPrevisao") && rotina.getQ4d() != null && rotina.getQ4d().isEmpty()) {
            rotinaValida = false;
            String message = "A Questão número 4 (Arco D) deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (!rotina.getQ3e().equals("naoInformado") && !rotina.getQ3e().equals("semPrevisao") && rotina.getQ4e() != null && rotina.getQ4e().isEmpty()) {
            rotinaValida = false;
            String message = "A Questão número 4 (Arco E) deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ5() == null || rotina.getQ5() != null && rotina.getQ5().isEmpty()) {
            rotinaValida = false;
            String message = "A Questão número 5 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        } else {
            if (rotina.getQ5() != null && rotina.getQ5().equals("e") && (rotina.getQ5complemento() == null || rotina.getQ5complemento() != null && rotina.getQ5complemento().isEmpty())) {
                rotinaValida = false;
                String message = "A Questão número 5 deve ser totalmente informada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
            } else {
                rotina.setQ5complemento(null);
            }
        }

        return rotinaValida;
    }
}
