/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.rotinas.R007;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Leandro Nunes
 */
public class ValidacaoR007 {

    public static boolean validaRotina(Rotina007 rotina) {

        boolean rotinaValida = true;

        if (rotina.getIdentificaEntradaObservacao() == null || rotina.getIdentificaEntradaObservacao().isEmpty()) {
            rotinaValida = false;
            String message = "A observação a que se refere esta rotina deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getExclusivoResponsavelAplicacaoQ2() == null || (rotina.getExclusivoResponsavelAplicacaoQ2() != null && rotina.getExclusivoResponsavelAplicacaoQ2().isEmpty())) {
            rotinaValida = false;
            String message = "O número de visitas necessárias deve ser informado";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getExclusivoResponsavelAplicacaoQ3() == null || (rotina.getExclusivoResponsavelAplicacaoQ3() != null && rotina.getExclusivoResponsavelAplicacaoQ3().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 2 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        } else {
            if (rotina.getExclusivoResponsavelAplicacaoQ3() != null && rotina.getExclusivoResponsavelAplicacaoQ3().equals("respondeu")) {

                if (rotina.getNome() != null && rotina.getNome().isEmpty()) {
                    rotinaValida = false;
                    String message = "O nome deve ser informado";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getNumeroNucleos() == null) {
                    rotinaValida = false;
                    String message = "Informe o número de Núcleos em que o educador atua.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getNumeroTurmas() == null) {
                    rotinaValida = false;
                    String message = "Informe o número de Turmas em que o educador atua.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getDataAplicacao() != null && rotina.getDataAplicacao().isEmpty()) {
                    rotinaValida = false;
                    String message = "A data de aplicação deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getComponenteCurricularLinguaPortuguesa().equals("Nao") && rotina.getComponenteCurricularMatematica().equals("Nao") && rotina.getComponenteCurricularCienciasNatureza().equals("Nao") && rotina.getComponenteCurricularQualificacaoProfissional().equals("Nao") && rotina.getComponenteCurricularLinguaEstrangeira().equals("Nao") && rotina.getComponenteCurricularCienciasHumanas().equals("Nao") && rotina.getComponenteCurricularParticipacaoCidada().equals("Nao")) {
                    rotinaValida = false;
                    String message = "O componente curricular deve ser informado";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ1() == null || rotina.getQ1() != null && rotina.getQ1().isEmpty()) {
                    rotinaValida = false;
                    String message = "A Questão número 1 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ2() == null || rotina.getQ2() != null && rotina.getQ2().isEmpty()) {
                    rotinaValida = false;
                    String message = "A Questão número 2 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ3() == null || rotina.getQ3() != null && rotina.getQ3().isEmpty()) {
                    rotinaValida = false;
                    String message = "A Questão número 3 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ4() == null || rotina.getQ4() != null && rotina.getQ4().isEmpty()) {
                    rotinaValida = false;
                    String message = "A Questão número 4 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ5() == null || rotina.getQ5() != null && rotina.getQ5().isEmpty()) {
                    rotinaValida = false;
                    String message = "A Questão número 5 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ6a().equals("Nao") && rotina.getQ6b().equals("Nao") && rotina.getQ6c().equals("Nao") && rotina.getQ6d().equals("Nao") && rotina.getQ6e().equals("Nao") && rotina.getQ6f().equals("Nao") && rotina.getQ6g().equals("Nao")) {
                    rotinaValida = false;
                    String message = "A Questão número 6 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if ((rotina.getQ7SoftwaresTexto() == null || rotina.getQ7SoftwaresTexto() != null && rotina.getQ7SoftwaresTexto().isEmpty()) || (rotina.getQ7ConfeccaoPlanilhas() == null || rotina.getQ7ConfeccaoPlanilhas() != null && rotina.getQ7ConfeccaoPlanilhas().isEmpty()) || (rotina.getQ7Internet() == null || rotina.getQ7Internet() != null && rotina.getQ7Internet().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 7 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ8() == null || rotina.getQ8() != null && rotina.getQ8().isEmpty()) {
                    rotinaValida = false;
                    String message = "A Questão número 8 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ9() == null || rotina.getQ9() != null && rotina.getQ9().isEmpty()) {
                    rotinaValida = false;
                    String message = "A Questão número 9 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                } else if ((rotina.getQ9() != null && rotina.getQ9().equals("12mais")) || (rotina.getQ9() != null && rotina.getQ9().equals("12menos")) || (rotina.getQ9() != null && rotina.getQ9().equals("educadorNaoRespondeu"))) {
                    if (rotina.getQ10() == null || rotina.getQ10() != null && rotina.getQ10().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão número 10 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ11() == null || rotina.getQ11() != null && rotina.getQ11().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão número 11 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ12() == null || rotina.getQ12() != null && rotina.getQ12().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão número 12 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ13() == null || rotina.getQ13() != null && rotina.getQ13().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão número 13 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ14() == null || rotina.getQ14() != null && rotina.getQ14().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão número 14 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ15() == null || rotina.getQ15() != null && rotina.getQ15().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão número 15 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if ((rotina.getQ16() == null || (rotina.getQ16() != null && rotina.getQ16().isEmpty())) && rotina.getVersaoFormulario().equals(3)) {
                        rotinaValida = false;
                        String message = "A Questão número 16 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if ((rotina.getQ17() == null || (rotina.getQ17() != null && rotina.getQ17().isEmpty())) && rotina.getVersaoFormulario().equals(3)) {
                        rotinaValida = false;
                        String message = "A Questão número 17 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if ((rotina.getQ18() == null || (rotina.getQ18() != null && rotina.getQ18().isEmpty())) && rotina.getVersaoFormulario().equals(3)) {
                        rotinaValida = false;
                        String message = "A Questão número 18 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ19() == null || rotina.getQ19() != null && rotina.getQ19().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão número 19 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ20() == null || rotina.getQ20() != null && rotina.getQ20().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão número 20 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ21() == null || rotina.getQ21() != null && rotina.getQ21().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão número 21 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ22() == null || rotina.getQ22() != null && rotina.getQ22().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão número 22 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ23() == null || rotina.getQ23() != null && rotina.getQ23().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão número 23 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ24() == null || rotina.getQ24() != null && rotina.getQ24().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão número 24 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ25() == null || rotina.getQ25() != null && rotina.getQ25().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão número 25 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ26() == null || rotina.getQ26() != null && rotina.getQ26().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão número 26 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ27() == null || rotina.getQ27() != null && rotina.getQ27().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão número 27 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ28() == null || rotina.getQ28() != null && rotina.getQ28().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão número 28 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ29() == null || rotina.getQ29() != null && rotina.getQ29().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão número 29 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ30() == null || rotina.getQ30() != null && rotina.getQ30().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão número 30 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }
                } else {
                    rotina.setQ10(null);
                    rotina.setQ11(null);
                    rotina.setQ12(null);
                    rotina.setQ13(null);
                    rotina.setQ14(null);
                    rotina.setQ15(null);
                    rotina.setQ16(null);
                    rotina.setQ17(null);
                    rotina.setQ18(null);
                    rotina.setQ19(null);
                    rotina.setQ20(null);
                    rotina.setQ21(null);
                    rotina.setQ22(null);
                    rotina.setQ23(null);
                    rotina.setQ24(null);
                    rotina.setQ25(null);
                    rotina.setQ26(null);
                    rotina.setQ27(null);
                    rotina.setQ28(null);
                    rotina.setQ29(null);
                    rotina.setQ30(null);
                }
            } else {
                rotina.setNome(null);
                rotina.setNumeroNucleos(null);
                rotina.setNumeroTurmas(null);
                rotina.setDataAplicacao(null);
                rotina.setComponenteCurricularLinguaPortuguesa(null);
                rotina.setComponenteCurricularMatematica(null);
                rotina.setComponenteCurricularCienciasNatureza(null);
                rotina.setComponenteCurricularQualificacaoProfissional(null);
                rotina.setComponenteCurricularLinguaEstrangeira(null);
                rotina.setComponenteCurricularCienciasHumanas(null);
                rotina.setComponenteCurricularParticipacaoCidada(null);
                rotina.setQ1(null);
                rotina.setQ2(null);
                rotina.setQ3(null);
                rotina.setQ4(null);
                rotina.setQ5(null);
                rotina.setQ6a(null);
                rotina.setQ6b(null);
                rotina.setQ6c(null);
                rotina.setQ6d(null);
                rotina.setQ6e(null);
                rotina.setQ6f(null);
                rotina.setQ6g(null);
                rotina.setQ7SoftwaresTexto(null);
                rotina.setQ7ConfeccaoPlanilhas(null);
                rotina.setQ7Internet(null);
                rotina.setQ8(null);
                rotina.setQ9(null);
                rotina.setQ10(null);
                rotina.setQ11(null);
                rotina.setQ12(null);
                rotina.setQ13(null);
                rotina.setQ14(null);
                rotina.setQ15(null);
                rotina.setQ16(null);
                rotina.setQ17(null);
                rotina.setQ18(null);
                rotina.setQ19(null);
                rotina.setQ20(null);
                rotina.setQ21(null);
                rotina.setQ22(null);
                rotina.setQ23(null);
                rotina.setQ24(null);
                rotina.setQ25(null);
                rotina.setQ26(null);
                rotina.setQ27(null);
                rotina.setQ28(null);
                rotina.setQ29(null);
                rotina.setQ30(null);
            }

            if (rotina.getExclusivoResponsavelAplicacaoQ3() != null && rotina.getExclusivoResponsavelAplicacaoQ3().equals("outro")) {

                if (rotina.getExclusivoResponsavelAplicacaoQ3Complemento() != null && rotina.getExclusivoResponsavelAplicacaoQ3Complemento().isEmpty()) {
                    rotinaValida = false;
                    String message = "O motivo deve ser informado";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
            } else {
                rotina.setExclusivoResponsavelAplicacaoQ3Complemento(null);
            }
        }


        return rotinaValida;
    }
}
