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
public class ValidacaoPerfilEducadores {

    public static boolean validaRotina(Rotina002PerfilEducadores rotina) {

        boolean rotinaValida = true;

        if (rotina.getNome() == null || (rotina.getNome() != null && rotina.getNome().isEmpty())) {
            rotinaValida = false;
            String message = "O nome deve ser informado";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if (rotina.getDataAplicacao() == null || (rotina.getDataAplicacao() != null && rotina.getDataAplicacao().isEmpty())) {
            rotinaValida = false;
            String message = "A data de aplicação deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if (rotina.getComponenteCurricularLinguaPortuguesa().equals("Nao") && rotina.getComponenteCurricularMatematica().equals("Nao") && rotina.getComponenteCurricularCienciasNatureza().equals("Nao") && rotina.getComponenteCurricularQualificacaoProfissional().equals("Nao") && rotina.getComponenteCurricularLinguaEstrangeira().equals("Nao") && rotina.getComponenteCurricularCienciasHumanas().equals("Nao") && rotina.getComponenteCurricularParticipacaoCidada().equals("Nao")) {
            rotinaValida = false;
            String message = "O componente curricular deve ser informado";
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

        if ((rotina.getQ8NuncaLecionei() != null && rotina.getQ8NuncaLecionei().equals("Nao")) &&
                rotina.getQ8EducacaoInfantil().equals("Nao") &&
                rotina.getQ8EnsinoFundamental().equals("Nao") &&
                rotina.getQ8EnsinoMedio().equals("Nao") &&
                rotina.getQ8EducacaoJovensAdultos().equals("Nao") &&
                rotina.getQ8EnsinoTecnicoProfissionalizante().equals("Nao") &&
                rotina.getQ8EnsinoSuperior().equals("Nao") &&
                rotina.getQ8Outros().equals("Nao")) {
            rotinaValida = false;
            String message = "A Questão número 8 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ8Outros() != null && rotina.getQ8Outros().equals("Sim")) {
            if (rotina.getQ8OutrosComplemento() != null && rotina.getQ8OutrosComplemento().isEmpty()) {
                rotinaValida = false;
                String message = "As informações complementares da questão número 8 devem ser informadas";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));

            }
        }

        if ((rotina.getQ9SoftwaresTexto() == null || rotina.getQ9SoftwaresTexto() != null && rotina.getQ9SoftwaresTexto().isEmpty()) || (rotina.getQ9ConfeccaoPlanilhas() == null || rotina.getQ9ConfeccaoPlanilhas() != null && rotina.getQ9ConfeccaoPlanilhas().isEmpty()) || (rotina.getQ9Internet() == null || rotina.getQ9Internet() != null && rotina.getQ9Internet().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 9 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if (rotina.getQ10() == null || (rotina.getQ10() != null && rotina.getQ10().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 10 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ11Convite().equals("Nao") &&
                rotina.getQ11AvaliacaoCurrículo().equals("Nao") &&
                rotina.getQ11Entrevista().equals("Nao") &&
                rotina.getQ11ProvaEscrita().equals("Nao") &&
                rotina.getQ11Desempenho().equals("Nao")) {
            rotinaValida = false;
            String message = "A Questão número 11 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));

        }

        if (rotina.getQ12() == null || (rotina.getQ12() != null && rotina.getQ12().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 12 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if (rotina.getQ13a().equals("Nao") &&
                rotina.getQ13b().equals("Nao") &&
                rotina.getQ13c().equals("Nao") &&
                rotina.getQ13d().equals("Nao") &&
                rotina.getQ13e().equals("Nao")) {
            rotinaValida = false;
            String message = "A Questão número 13 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }


        if (rotina.getQ14a().equals("Nao") &&
                rotina.getQ14b().equals("Nao") &&
                rotina.getQ14c().equals("Nao") &&
                rotina.getQ14d().equals("Nao") &&
                rotina.getQ14e().equals("Nao") &&
                rotina.getQ14f().equals("Nao") &&
                rotina.getQ14g().equals("Nao") &&
                rotina.getQ14h().equals("Nao") &&
                rotina.getQ14i().equals("Nao")) {
            rotinaValida = false;
            String message = "A Questão número 14 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }



        if (rotina.getQ15() == null || (rotina.getQ15() != null && rotina.getQ15().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 15 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        return rotinaValida;
    }

    public static Rotina002PerfilEducadores tratarListas(Rotina002PerfilEducadores rotina) {

        rotina.setComponenteCurricularLinguaPortuguesa("Nao");
        rotina.setComponenteCurricularMatematica("Nao");
        rotina.setComponenteCurricularCienciasNatureza("Nao");
        rotina.setComponenteCurricularQualificacaoProfissional("Nao");
        rotina.setComponenteCurricularLinguaEstrangeira("Nao");
        rotina.setComponenteCurricularCienciasHumanas("Nao");
        rotina.setComponenteCurricularParticipacaoCidada("Nao");

        if (rotina.getListComponenteCurricular() != null && rotina.getListComponenteCurricular().size() > 0) {
            for (String componenteCurricular : rotina.getListComponenteCurricular()) {
                if (componenteCurricular.equals("componenteCurricularLinguaPortuguesa")) {
                    rotina.setComponenteCurricularLinguaPortuguesa("Sim");
                }
                if (componenteCurricular.equals("componenteCurricularMatematica")) {
                    rotina.setComponenteCurricularMatematica("Sim");
                }
                if (componenteCurricular.equals("componenteCurricularCienciasNatureza")) {
                    rotina.setComponenteCurricularCienciasNatureza("Sim");
                }
                if (componenteCurricular.equals("componenteCurricularQualificacaoProfissional")) {
                    rotina.setComponenteCurricularQualificacaoProfissional("Sim");
                }
                if (componenteCurricular.equals("componenteCurricularLinguaEstrangeira")) {
                    rotina.setComponenteCurricularLinguaEstrangeira("Sim");
                }
                if (componenteCurricular.equals("componenteCurricularCienciasHumanas")) {
                    rotina.setComponenteCurricularCienciasHumanas("Sim");
                }
                if (componenteCurricular.equals("componenteCurricularParticipacaoCidada")) {
                    rotina.setComponenteCurricularParticipacaoCidada("Sim");
                }
            }
        }

        rotina.setQ8EducacaoInfantil("Nao");
        rotina.setQ8EnsinoFundamental("Nao");
        rotina.setQ8EnsinoMedio("Nao");
        rotina.setQ8EducacaoJovensAdultos("Nao");
        rotina.setQ8EnsinoTecnicoProfissionalizante("Nao");
        rotina.setQ8EnsinoSuperior("Nao");
        rotina.setQ8Outros("Nao");

        if (rotina.getListQ8() != null && rotina.getListQ8().size() > 0) {
            for (String q8 : rotina.getListQ8()) {
                if (q8.equals("Q8NuncaLecionei")) {
                    rotina.setQ8NuncaLecionei("Sim");
                }
                if (q8.equals("Q8EducacaoInfantil")) {
                    rotina.setQ8EducacaoInfantil("Sim");
                }
                if (q8.equals("Q8EnsinoFundamental")) {
                    rotina.setQ8EnsinoFundamental("Sim");
                }
                if (q8.equals("Q8EnsinoMedio")) {
                    rotina.setQ8EnsinoMedio("Sim");
                }
                if (q8.equals("Q8EducacaoJovensAdultos")) {
                    rotina.setQ8EducacaoJovensAdultos("Sim");
                }
                if (q8.equals("Q8EnsinoTecnicoProfissionalizante")) {
                    rotina.setQ8EnsinoTecnicoProfissionalizante("Sim");
                }
                if (q8.equals("Q8EnsinoSuperior")) {
                    rotina.setQ8EnsinoSuperior("Sim");
                }
                if (q8.equals("Q8Outros")) {
                    rotina.setQ8Outros("Sim");
                }
            }
        }

        rotina.setQ11Convite("Nao");
        rotina.setQ11AvaliacaoCurrículo("Nao");
        rotina.setQ11Entrevista("Nao");
        rotina.setQ11ProvaEscrita("Nao");
        rotina.setQ11Desempenho("Nao");

        if (rotina.getListQ11() != null && rotina.getListQ11().size() > 0) {
            for (String q11 : rotina.getListQ11()) {
                if (q11.equals("Q11Convite")) {
                    rotina.setQ11Convite("Sim");
                }
                if (q11.equals("Q11AvaliacaoCurrículo")) {
                    rotina.setQ11AvaliacaoCurrículo("Sim");
                }
                if (q11.equals("Q11Entrevista")) {
                    rotina.setQ11Entrevista("Sim");
                }
                if (q11.equals("Q11ProvaEscrita")) {
                    rotina.setQ11ProvaEscrita("Sim");
                }
                if (q11.equals("Q11Desempenho")) {
                    rotina.setQ11Desempenho("Sim");
                }
            }
        }

        rotina.setQ13a("Nao");
        rotina.setQ13b("Nao");
        rotina.setQ13c("Nao");
        rotina.setQ13d("Nao");
        rotina.setQ13e("Nao");

        if (rotina.getListQ13() != null && rotina.getListQ13().size() > 0) {
            for (String q13 : rotina.getListQ13()) {
                if (q13.equals("a")) {
                    rotina.setQ13a("Sim");
                }
                if (q13.equals("b")) {
                    rotina.setQ13b("Sim");
                }
                if (q13.equals("c")) {
                    rotina.setQ13c("Sim");
                }
                if (q13.equals("d")) {
                    rotina.setQ13d("Sim");
                }
                if (q13.equals("e")) {
                    rotina.setQ13e("Sim");
                }
            }
        }


        rotina.setQ14a("Nao");
        rotina.setQ14b("Nao");
        rotina.setQ14c("Nao");
        rotina.setQ14d("Nao");
        rotina.setQ14e("Nao");
        rotina.setQ14f("Nao");
        rotina.setQ14g("Nao");
        rotina.setQ14h("Nao");
        rotina.setQ14i("Nao");

        if (rotina.getListQ14() != null && rotina.getListQ14().size() > 0) {
            for (String q14 : rotina.getListQ14()) {
                if (q14.equals("a")) {
                    rotina.setQ14a("Sim");
                }
                if (q14.equals("b")) {
                    rotina.setQ14b("Sim");
                }
                if (q14.equals("c")) {
                    rotina.setQ14c("Sim");
                }
                if (q14.equals("d")) {
                    rotina.setQ14d("Sim");
                }
                if (q14.equals("e")) {
                    rotina.setQ14e("Sim");
                }
                if (q14.equals("f")) {
                    rotina.setQ14f("Sim");
                }
                if (q14.equals("g")) {
                    rotina.setQ14g("Sim");
                }
                if (q14.equals("h")) {
                    rotina.setQ14h("Sim");
                }
                if (q14.equals("i")) {
                    rotina.setQ14i("Sim");
                }
            }
        }
        return rotina;

    }
}
