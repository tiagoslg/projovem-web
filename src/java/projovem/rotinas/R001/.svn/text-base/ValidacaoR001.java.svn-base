/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.rotinas.R001;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Leandro Nunes
 */
public class ValidacaoR001 {

    public static boolean validaRotina(Rotina001 rotina) {

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


        if (rotina.getClassificacaoLocal() == null || (rotina.getClassificacaoLocal() != null && rotina.getClassificacaoLocal().isEmpty())) {
            rotinaValida = false;
            String message = "A classificação do local deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        } else {
            if (rotina.getClassificacaoLocal() != null && rotina.getClassificacaoLocal().equals("7")) {
                if (rotina.getClassificacaoLocalComplemento() == null || (rotina.getClassificacaoLocalComplemento() != null && rotina.getClassificacaoLocalComplemento().isEmpty())) {
                    rotinaValida = false;
                    String message = "A complemento da classificação do local deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
            } else {
                rotina.setClassificacaoLocalComplemento(null);
            }
        }
        if (rotina.getFuncionavaAnteriormenteEmOutroLocal() == null || (rotina.getFuncionavaAnteriormenteEmOutroLocal() != null && rotina.getFuncionavaAnteriormenteEmOutroLocal().isEmpty())) {
            rotinaValida = false;
            String message = "A informação referente ao local anterior deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        } else {
            if (rotina.getFuncionavaAnteriormenteEmOutroLocal() != null && rotina.getFuncionavaAnteriormenteEmOutroLocal().equals("Sim")) {
                if (rotina.getFuncionavaAnteriormenteEmOutroLocalComplemento() == null || (rotina.getFuncionavaAnteriormenteEmOutroLocalComplemento() != null && rotina.getFuncionavaAnteriormenteEmOutroLocalComplemento().isEmpty())) {
                    rotinaValida = false;
                    String message = "O local de funcionamento anterior deve ser informado";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
            } else {
                rotina.setFuncionavaAnteriormenteEmOutroLocalComplemento(null);
            }
        }


        if (rotina.getQ1Aabertura() == null || (rotina.getQ1Aabertura() != null && rotina.getQ1Aabertura().isEmpty())) {
            rotinaValida = false;
            String message = "O horário de abertura do local deve ser informado";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if (rotina.getQ1Afechamento() == null || (rotina.getQ1Afechamento() != null && rotina.getQ1Afechamento().isEmpty())) {
            rotinaValida = false;
            String message = "O horário de fechamento do local deve ser informado";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if (rotina.getQ1Babertura() == null || (rotina.getQ1Babertura() != null && rotina.getQ1Babertura().isEmpty())) {
            if (!(rotina.getQ1Bfechamento() == null || (rotina.getQ1Bfechamento() != null && rotina.getQ1Bfechamento().isEmpty()))) {
                rotinaValida = false;
                String message = "Ao informar o horário de abertura do local na questão 1.b deve ser informado o horário de fechamento";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
            }
        }
        if (rotina.getQ1Bfechamento() == null || (rotina.getQ1Bfechamento() != null && rotina.getQ1Bfechamento().isEmpty())) {
            if (!(rotina.getQ1Babertura() == null || (rotina.getQ1Babertura() != null && rotina.getQ1Babertura().isEmpty()))) {
                rotinaValida = false;
                String message = "Ao informar o horário de fechamento do local na questão 1.b deve ser informado o horário de abertura";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
            }
        }
        if (rotina.getQ1Cabertura() == null || (rotina.getQ1Cabertura() != null && rotina.getQ1Cabertura().isEmpty())) {
            if (!(rotina.getQ1Cfechamento() == null || (rotina.getQ1Cfechamento() != null && rotina.getQ1Cfechamento().isEmpty()))) {
                rotinaValida = false;
                String message = "Ao informar o horário de abertura do local na questão 1.c deve ser informado o horário de fechamento";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
            }
        }
        if (rotina.getQ1Cfechamento() == null || (rotina.getQ1Cfechamento() != null && rotina.getQ1Cfechamento().isEmpty())) {
            if (!(rotina.getQ1Cabertura() == null || (rotina.getQ1Cabertura() != null && rotina.getQ1Cabertura().isEmpty()))) {
                rotinaValida = false;
                String message = "Ao informar o horário de fechamento do local na questão 1.c deve ser informado o horário de abertura";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
            }
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
        if ((rotina.getQ4InternetBandaLarga() == null || (rotina.getQ4InternetBandaLarga() != null && rotina.getQ4InternetBandaLarga().isEmpty())) && (rotina.getQ4InternetDiscada() == null || (rotina.getQ4InternetDiscada() != null && rotina.getQ4InternetDiscada().isEmpty())) && (rotina.getQ4OutrasFormas() == null || (rotina.getQ4OutrasFormas() != null && rotina.getQ4OutrasFormas().isEmpty())) && (rotina.getQ4NaoHavia() == null || (rotina.getQ4NaoHavia() != null && rotina.getQ4NaoHavia().isEmpty()))) {
            rotinaValida = false;
            String message = "A Questão número 4 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ5() == null || (rotina.getQ5() != null && rotina.getQ5().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 5 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if (rotina.getQ6a() == null || (rotina.getQ6a() != null && rotina.getQ6a().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 6a deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if (rotina.getQ6b() == null || (rotina.getQ6b() != null && rotina.getQ6b().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 6b deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if (rotina.getQ6c() == null || (rotina.getQ6c() != null && rotina.getQ6c().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 6c deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if (rotina.getQ7a() == null || (rotina.getQ7a() != null && rotina.getQ7a().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 7a deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if (rotina.getQ7b() == null || (rotina.getQ7b() != null && rotina.getQ7b().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 7b deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if (rotina.getQ7c() == null || (rotina.getQ7c() != null && rotina.getQ7c().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 7c deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if (rotina.getQ7d() == null || (rotina.getQ7d() != null && rotina.getQ7d().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 7d deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if (rotina.getQ8a() == null || (rotina.getQ8a() != null && rotina.getQ8a().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 8a deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if (rotina.getQ8b() == null || (rotina.getQ8b() != null && rotina.getQ8b().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 8b deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if (rotina.getQ9() == null || (rotina.getQ9() != null && rotina.getQ9().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 9 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if (rotina.getQ10() == null || (rotina.getQ10() != null && rotina.getQ10().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 10 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ11() == null || (rotina.getQ11() != null && rotina.getQ11().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 11 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        } else {
            if (rotina.getQ11() != null && rotina.getQ11().equals("sim")) {
                if (rotina.getQ11Complemento() != null && rotina.getQ11Complemento().isEmpty()) {
                    rotinaValida = false;
                    String message = "As informações complementares da questão número 11 devem ser informadas";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
            } else {
                rotina.setQ11Complemento(null);
            }
        }
        if (rotina.getQ12() == null || (rotina.getQ12() != null && rotina.getQ12().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 12 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        } else {
            if (rotina.getQ12() != null && rotina.getQ12().equals("sim")) {
                if (rotina.getQ12Complemento() != null && rotina.getQ12Complemento().isEmpty()) {
                    rotinaValida = false;
                    String message = "As informações complementares da questão número 12 devem ser informadas";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
            } else {
                rotina.setQ12Complemento(null);
            }
        }
        if (rotina.getQ13() == null || (rotina.getQ13() != null && rotina.getQ13().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 13 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        } else {
            if (rotina.getQ13() != null && rotina.getQ13().equals("sim")) {
                if (rotina.getQ13Complemento() != null && rotina.getQ13Complemento().isEmpty()) {
                    rotinaValida = false;
                    String message = "As informações complementares da questão número 13 devem ser informadas";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
            } else {
                rotina.setQ13Complemento(null);
            }
        }
        if (rotina.getQ14() == null || (rotina.getQ14() != null && rotina.getQ14().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 14 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        } else {
            if (rotina.getQ14() != null && rotina.getQ14().equals("sim")) {
                if (rotina.getQ14Complemento() != null && rotina.getQ14Complemento().isEmpty()) {
                    rotinaValida = false;
                    String message = "As informações complementares da questão número 14 devem ser informadas";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
            } else {
                rotina.setQ14Complemento(null);
            }
        }
        if (rotina.getQ15() == null || (rotina.getQ15() != null && rotina.getQ15().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 15 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        } else {
            if (rotina.getQ15() != null && rotina.getQ15().equals("sim")) {
                if (rotina.getQ15Complemento() != null && rotina.getQ15Complemento().isEmpty()) {
                    rotinaValida = false;
                    String message = "As informações complementares da questão número 15 devem ser informadas";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
            } else {
                rotina.setQ15Complemento(null);
            }
        }
        if (rotina.getQ16() == null || (rotina.getQ16() != null && rotina.getQ16().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 16 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        } else {
            if (rotina.getQ16() != null && rotina.getQ16().equals("sim")) {
                if (rotina.getQ16Complemento() != null && rotina.getQ16Complemento().isEmpty()) {
                    rotinaValida = false;
                    String message = "As informações complementares da questão número 16 devem ser informadas";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
            } else {
                rotina.setQ16Complemento(null);
            }
        }
        if (rotina.getQ17() == null || (rotina.getQ17() != null && rotina.getQ17().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 17 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        } else {
            if (rotina.getQ17() != null && rotina.getQ17().equals("sim")) {
                if (rotina.getQ17Complemento() != null && rotina.getQ17Complemento().isEmpty()) {
                    rotinaValida = false;
                    String message = "As informações complementares da questão número 17 devem ser informadas";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
            } else {
                rotina.setQ17Complemento(null);
            }
        }


        return rotinaValida;
    }

    public static Rotina001 tratarListas(Rotina001 rotina) {
        rotina.setQ4InternetBandaLarga("Nao");
        rotina.setQ4InternetDiscada("Nao");
        rotina.setQ4NaoHavia("Nao");
        rotina.setQ4OutrasFormas("Nao");

        if (rotina.getListQ4() != null && rotina.getListQ4().size() > 0) {
            for (String q4 : rotina.getListQ4()) {
                if (q4.equals("bandaLarga")) {
                    rotina.setQ4InternetBandaLarga("Sim");
                }
                if (q4.equals("discada")) {
                    rotina.setQ4InternetDiscada("Sim");
                }
                if (q4.equals("naoHavia")) {
                    rotina.setQ4NaoHavia("Sim");
                }
                if (q4.equals("outras")) {
                    rotina.setQ4OutrasFormas("Sim");
                }

            }
        }
        return rotina;
    }
}
