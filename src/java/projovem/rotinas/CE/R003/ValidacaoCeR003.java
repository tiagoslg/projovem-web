/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.rotinas.CE.R003;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Leandro Nunes
 */
public class ValidacaoCeR003 {

    public static boolean validaRotina(CeRotina003 rotina) {

        boolean rotinaValida = true;

        if (rotina.getBairroLocal() != null && rotina.getBairroLocal().isEmpty()) {
            rotinaValida = false;
            String message = "O bairro do local observado deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if (rotina.getCepLocal() != null && rotina.getCepLocal().isEmpty()) {
            rotinaValida = false;
            String message = "O Cep do local observado deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getEnderecoLocal() != null && rotina.getEnderecoLocal().isEmpty()) {
            rotinaValida = false;
            String message = "O Endereço do local observado deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }


        if (rotina.getIdentificaEntradaObservacao() == null || rotina.getIdentificaEntradaObservacao().isEmpty()) {
            rotinaValida = false;
            String message = "A observação a que se refere esta rotina deve ser informada";
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
            String message = "A hora de termino da visita deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }



        if (rotina.getQ1() == null || (rotina.getQ1() != null  && rotina.getQ1().equals("naoInformado"))) {
            rotinaValida = false;
            String message = "A Questão número 1 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if (rotina.getQ2() == null || (rotina.getQ2() != null && rotina.getQ2().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 2 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        } else {
            if (rotina.getQ2() != null && rotina.getQ2().equals("sim")) {
                if (rotina.getQ3() == null || (rotina.getQ3() != null && rotina.getQ3().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 3 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
                if (rotina.getNucleoAtendido() == null || (rotina.getNucleoAtendido() != null && rotina.getNucleoAtendido().size() == 0)) {
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
                } else {
                    if (rotina.getQ6() != null && rotina.getQ6().equals("sim")) {
                        if (rotina.getQ7() == null || (rotina.getQ7() != null && rotina.getQ7().isEmpty())) {
                            rotinaValida = false;
                            String message = "A Questão número 7 deve ser informada";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }
                    } else {
                        rotina.setQ7(null);
                    }
                }
                if (rotina.getQ8() == null || (rotina.getQ8() != null && rotina.getQ8().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 8 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                } else {
                    if (rotina.getQ8() != null && rotina.getQ8().equals("sim")) {
                        if (rotina.getQ9() == null || (rotina.getQ9() != null && rotina.getQ9().isEmpty())) {
                            rotinaValida = false;
                            String message = "A Questão número 9 deve ser informada";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }
                    } else {
                        rotina.setQ9(null);
                    }
                }
                if (rotina.getQ11() == null || (rotina.getQ11() != null && rotina.getQ11().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 11 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
            } else {
                rotina.setQ3(null);
                rotina.setNucleoAtendido(null);
                rotina.setQ5(null);
                rotina.setQ6(null);
                rotina.setQ7(null);
                rotina.setQ8(null);
                rotina.setQ9(null);
                rotina.setQ11(null);
            }
        }


        return rotinaValida;
    }
}
