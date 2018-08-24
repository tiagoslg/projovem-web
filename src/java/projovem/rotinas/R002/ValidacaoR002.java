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
public class ValidacaoR002 {

    public static boolean validaRotina(Rotina002 rotina) {

        boolean rotinaValida = true;



        if (rotina.getRealizada() == null || (rotina.getRealizada() != null && rotina.getRealizada().isEmpty())) {
            rotinaValida = false;
            String message = "Deve ser informada se a Formação inicial foi realizada.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        } else {
            if (rotina.getRealizada() != null && rotina.getRealizada().equals("nao")) {
                if (rotina.getRealizadaComplemento() == null || (rotina.getRealizadaComplemento() != null && rotina.getRealizadaComplemento().isEmpty())) {
                    rotinaValida = false;
                    String message = "Justifique porque nao houve formação inicial";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
            } else {
                rotina.setRealizadaComplemento(null);
            }
            if (rotina.getRealizada() != null && rotina.getRealizada().equals("sim")) {

                if (rotina.getBairroLocal() == null || (rotina.getBairroLocal() != null && rotina.getBairroLocal().isEmpty())) {
                    rotinaValida = false;
                    String message = "O bairro do local observado deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
                if (rotina.getCepLocal() == null || (rotina.getCepLocal() != null && rotina.getCepLocal().isEmpty())) {
                    rotinaValida = false;
                    String message = "O Cep do local observado deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getEnderecoLocal() == null || (rotina.getEnderecoLocal() != null && rotina.getEnderecoLocal().isEmpty())) {
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
                    if (rotina.getClassificacaoLocal() != null && rotina.getClassificacaoLocal().equals("6")) {
                        if (rotina.getClassificacaoLocalComplemento() == null || (rotina.getClassificacaoLocalComplemento() != null && rotina.getClassificacaoLocalComplemento().isEmpty())) {
                            rotinaValida = false;
                            String message = "A complemento da classificação do local deve ser informada";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }
                    } else rotina.setClassificacaoLocalComplemento(null);
                }

                if (rotina.getNomeCoordenador() == null || (rotina.getNomeCoordenador() != null && rotina.getNomeCoordenador().isEmpty())) {
                    rotinaValida = false;
                    String message = "O nome do coordenador deve ser informado";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
                if (rotina.getCpfCoordenador() == null || (rotina.getCpfCoordenador() != null && rotina.getCpfCoordenador().isEmpty())) {
                    rotinaValida = false;
                    String message = "O cpf do coordenador deve ser informado";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
                if (rotina.getDataInicioFormacao() == null || (rotina.getDataInicioFormacao() != null && rotina.getDataInicioFormacao().isEmpty())) {
                    rotinaValida = false;
                    String message = "A data de inicio da formação deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
                if (rotina.getDataTerminoFormacao() == null || (rotina.getDataTerminoFormacao() != null && rotina.getDataTerminoFormacao().isEmpty())) {
                    rotinaValida = false;
                    String message = "A data de termino da formação deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
                if (rotina.getNumeroEducadoresInscritos() == null || (rotina.getNumeroEducadoresInscritos() != null && rotina.getNumeroEducadoresInscritos().isEmpty())) {
                    rotinaValida = false;
                    String message = "O número de educadores inscritos deve ser informado";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
                if (rotina.getNumeroEducadoresPresentes() == null || (rotina.getNumeroEducadoresPresentes() != null && rotina.getNumeroEducadoresPresentes().isEmpty())) {
                    rotinaValida = false;
                    String message = "O número de educadores presentes deve ser informado";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
                if (rotina.getNumeroFormadoresInscritos() == null || (rotina.getNumeroFormadoresInscritos() != null && rotina.getNumeroFormadoresInscritos().isEmpty())) {
                    rotinaValida = false;
                    String message = "O número de formadores inscritos deve ser informado";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
                if (rotina.getNumeroFormadoresPresentes() == null || (rotina.getNumeroFormadoresPresentes() != null && rotina.getNumeroFormadoresPresentes().isEmpty())) {
                    rotinaValida = false;
                    String message = "O número de formadores presentes deve ser informado";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
                if (rotina.getHoraInicioFormacao() == null || (rotina.getHoraInicioFormacao() != null && rotina.getHoraInicioFormacao().isEmpty())) {
                    rotinaValida = false;
                    String message = "A hora de início da formação deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
                if (rotina.getHoraTerminoFormacao() == null || (rotina.getHoraTerminoFormacao() != null && rotina.getHoraTerminoFormacao().isEmpty())) {
                    rotinaValida = false;
                    String message = "A hora de termino da formação deve ser informada";
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
                }
                if (rotina.getQ12() == null || (rotina.getQ12() != null && rotina.getQ12().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 12 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
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

                if (rotina.getQ18QuantidadeDoutorado() == null || (rotina.getQ18QuantidadeDoutorado() != null && rotina.getQ18QuantidadeDoutorado().isEmpty())) {
                    rotinaValida = false;
                    String message = "A quantidade de educadores com nível - Doutorado - deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
                if (rotina.getQ18QuantidadeEnsinoFundamental() == null || (rotina.getQ18QuantidadeEnsinoFundamental() != null && rotina.getQ18QuantidadeEnsinoFundamental().isEmpty())) {
                    rotinaValida = false;
                    String message = "A quantidade de educadores com nível - Ensino Fundamental - deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
                if (rotina.getQ18QuantidadeEnsinoMedioMagisterio() == null || (rotina.getQ18QuantidadeEnsinoMedioMagisterio() != null && rotina.getQ18QuantidadeEnsinoMedioMagisterio().isEmpty())) {
                    rotinaValida = false;
                    String message = "A quantidade de educadores com nível - Ensino Médio/Magistério - deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
                if (rotina.getQ18QuantidadeEnsinoMedioTecnico() == null || (rotina.getQ18QuantidadeEnsinoMedioTecnico() != null && rotina.getQ18QuantidadeEnsinoMedioTecnico().isEmpty())) {
                    rotinaValida = false;
                    String message = "A quantidade de educadores com nível - Ensino Médio/Técnico - deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
                if (rotina.getQ18QuantidadeEnsinoSuperiorCompletoBacharelado() == null || (rotina.getQ18QuantidadeEnsinoSuperiorCompletoBacharelado() != null && rotina.getQ18QuantidadeEnsinoSuperiorCompletoBacharelado().isEmpty())) {
                    rotinaValida = false;
                    String message = "A quantidade de educadores com nível - Ensino Superior Completo Bacharelado - deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
                if (rotina.getQ18QuantidadeEnsinoSuperiorCompletoLicenciatura() == null || (rotina.getQ18QuantidadeEnsinoSuperiorCompletoLicenciatura() != null && rotina.getQ18QuantidadeEnsinoSuperiorCompletoLicenciatura().isEmpty())) {
                    rotinaValida = false;
                    String message = "A quantidade de educadores com nível - Ensino Superior Completo Licenciatura - deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
                if (rotina.getQ18QuantidadeEnsinoSuperiorCompletoTecnologico() == null || (rotina.getQ18QuantidadeEnsinoSuperiorCompletoTecnologico() != null && rotina.getQ18QuantidadeEnsinoSuperiorCompletoTecnologico().isEmpty())) {
                    rotinaValida = false;
                    String message = "A quantidade de educadores com nível - Ensino Superior Completo Tecnológico - deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
                if (rotina.getQ18QuantidadeEnsinoSuperiorIncompleto() == null || (rotina.getQ18QuantidadeEnsinoSuperiorIncompleto() != null && rotina.getQ18QuantidadeEnsinoSuperiorIncompleto().isEmpty())) {
                    rotinaValida = false;
                    String message = "A quantidade de educadores com nível - Ensino Superior Incompleto - deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
                if (rotina.getQ18QuantidadeEspecializacao() == null || (rotina.getQ18QuantidadeEspecializacao() != null && rotina.getQ18QuantidadeEspecializacao().isEmpty())) {
                    rotinaValida = false;
                    String message = "A quantidade de educadores com nível - Especialização - deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
                if (rotina.getQ18QuantidadeMestrado() == null || (rotina.getQ18QuantidadeMestrado() != null && rotina.getQ18QuantidadeMestrado().isEmpty())) {
                    rotinaValida = false;
                    String message = "A quantidade de educadores com nível - Mestrado - deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
                if (rotina.getQ19QuantidadeBiologicas() == null || (rotina.getQ19QuantidadeBiologicas() != null && rotina.getQ19QuantidadeBiologicas().isEmpty())) {
                    rotinaValida = false;
                    String message = "A quantidade de educadores com na área Biológica deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
                if (rotina.getQ19QuantidadeEducacao() == null || (rotina.getQ19QuantidadeEducacao() != null && rotina.getQ19QuantidadeEducacao().isEmpty())) {
                    rotinaValida = false;
                    String message = "A quantidade de educadores com na área Educação deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
                if (rotina.getQ19QuantidadeExatas() == null || (rotina.getQ19QuantidadeExatas() != null && rotina.getQ19QuantidadeExatas().isEmpty())) {
                    rotinaValida = false;
                    String message = "A quantidade de educadores com na área Exatas deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
                if (rotina.getQ19QuantidadeHumanas() == null || (rotina.getQ19QuantidadeHumanas() != null && rotina.getQ19QuantidadeHumanas().isEmpty())) {
                    rotinaValida = false;
                    String message = "A quantidade de educadores com na área Humanas deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
                if (rotina.getQ19QuantidadeLetras() == null || (rotina.getQ19QuantidadeLetras() != null && rotina.getQ19QuantidadeLetras().isEmpty())) {
                    rotinaValida = false;
                    String message = "A quantidade de educadores com na área Letras deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
                if (rotina.getQ19QuantidadeTecnologo() == null || (rotina.getQ19QuantidadeTecnologo() != null && rotina.getQ19QuantidadeTecnologo().isEmpty())) {
                    rotinaValida = false;
                    String message = "A quantidade de educadores com na área Tecnológo deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
                if (rotina.getQ19QuantidadeSuperior() == null || (rotina.getQ19QuantidadeSuperior() != null && rotina.getQ19QuantidadeSuperior().isEmpty())) {
                    rotinaValida = false;
                    String message = "A quantidade de educadores que não concluiram o Ensino Superior deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

            } else {
                rotina.setBairroLocal(null);
                rotina.setCepLocal(null);
                rotina.setEnderecoLocal(null);
                rotina.setDataVisita(null);
                rotina.setHoraInicioVisita(null);
                rotina.setHoraTerminoVisita(null);
                rotina.setClassificacaoLocal(null);
                rotina.setClassificacaoLocalComplemento(null);
                rotina.setNomeCoordenador(null);
                rotina.setCpfCoordenador(null);
                rotina.setDataInicioFormacao(null);
                rotina.setDataTerminoFormacao(null);
                rotina.setNumeroEducadoresInscritos(null);
                rotina.setNumeroEducadoresPresentes(null);
                rotina.setNumeroFormadoresInscritos(null);
                rotina.setNumeroFormadoresPresentes(null);
                rotina.setHoraInicioFormacao(null);
                rotina.setHoraTerminoFormacao(null);
                rotina.setQ10(null);
                rotina.setQ11(null);
                rotina.setQ12(null);
                rotina.setQ13(null);
                rotina.setQ13Complemento(null);
                rotina.setQ14(null);
                rotina.setQ14Complemento(null);
                rotina.setQ15(null);
                rotina.setQ15Complemento(null);
                rotina.setQ16(null);
                rotina.setQ16Complemento(null);
                rotina.setQ17(null);
                rotina.setQ17Complemento(null);
                rotina.setQ18QuantidadeDoutorado(null);
                rotina.setQ18QuantidadeEnsinoFundamental(null);
                rotina.setQ18QuantidadeEnsinoMedioMagisterio(null);
                rotina.setQ18QuantidadeEnsinoMedioTecnico(null);
                rotina.setQ18QuantidadeEnsinoSuperiorCompletoBacharelado(null);
                rotina.setQ18QuantidadeEnsinoSuperiorCompletoLicenciatura(null);
                rotina.setQ18QuantidadeEnsinoSuperiorCompletoTecnologico(null);
                rotina.setQ18QuantidadeEnsinoSuperiorIncompleto(null);
                rotina.setQ18QuantidadeEspecializacao(null);
                rotina.setQ18QuantidadeMestrado(null);
                rotina.setQ19QuantidadeBiologicas(null);
                rotina.setQ19QuantidadeEducacao(null);
                rotina.setQ19QuantidadeExatas(null);
                rotina.setQ19QuantidadeHumanas(null);
                rotina.setQ19QuantidadeLetras(null);
                rotina.setQ19QuantidadeTecnologo(null);
                rotina.setQ19QuantidadeSuperior(null);
            }
        }
        return rotinaValida;
    }
}

