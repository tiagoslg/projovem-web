/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.rotinas.R003;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Leandro Nunes
 */
public class ValidacaoR003 {

    public static boolean validaRotina(Rotina003 rotina) {

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
            String message = "A data da visita deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getHoraInicioVisita() != null && rotina.getHoraInicioVisita().isEmpty()) {
            rotinaValida = false;
            String message = "A hora de início da visita deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getHoraTerminoVisita() != null && rotina.getHoraTerminoVisita().isEmpty()) {
            rotinaValida = false;
            String message = "A hora de término da visita deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getClassificacaoLocal() == null || (rotina.getClassificacaoLocal() != null && rotina.getClassificacaoLocal().isEmpty())) {
            rotinaValida = false;
            String message = "Informe a classificação do local";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        } else {
            if (rotina.getClassificacaoLocal() != null && rotina.getClassificacaoLocal().equals("7")) {
                if (rotina.getClassificacaoLocalComplemento() == null || (rotina.getClassificacaoLocalComplemento() != null && rotina.getClassificacaoLocalComplemento().isEmpty())) {
                    rotinaValida = false;
                    String message = "Informe a classificação do local, já que foi selecionada a opção 'Outro'";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
            } else {
                rotina.setClassificacaoLocalComplemento(null);
            }
        }

        if (rotina.getFormaArmazenamentoFichas() == null || (rotina.getFormaArmazenamentoFichas() != null && rotina.getFormaArmazenamentoFichas().isEmpty())) {
            rotinaValida = false;
            String message = "Informe a forma de armazenamento das fichas";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        } else {
            if (rotina.getFormaArmazenamentoFichas() != null && rotina.getFormaArmazenamentoFichas().equals("outro")) {
                if (rotina.getFormaArmazenamentoFichasComplemento() == null || (rotina.getFormaArmazenamentoFichasComplemento() != null && rotina.getFormaArmazenamentoFichasComplemento().isEmpty())) {
                    rotinaValida = false;
                    String message = "Informe a forma de armazenamento das fichas, já que foi selecionada a opção 'Outro'";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
            } else {
                rotina.setFormaArmazenamentoFichasComplemento(null);
            }
        }

        if (rotina.getListaFichas() != null && rotina.getListaFichas().isEmpty()) {
            rotinaValida = false;
            String message = "Preencha a tabela de verificação documental";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        return rotinaValida;
    }
}
