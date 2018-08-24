/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.rotinas.R004;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Leandro Nunes
 */
public class ValidacaoR004 {

    public static boolean validaRotina(Rotina004 rotina) {

        boolean rotinaValida = true;

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

        if (rotina.getQ1() == null || (rotina.getQ1() != null && rotina.getQ1().isEmpty())) {
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

                if (rotina.getQ4a() == null || (rotina.getQ4a() != null && rotina.getQ4a().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 4 (Hora de Abertura) deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ4b() == null || (rotina.getQ4b() != null && rotina.getQ4b().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 4 (Hora de Fechamento) deve ser informada";
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

                if (rotina.getQ9V() == null || (rotina.getQ9V() != null && rotina.getQ9V().isEmpty())) {
                    rotinaValida = false;
                    String message = "Informe se o núcleo possui alunos com necessidades especiais Visuais (Questão 9)";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }else if(rotina.getQ9V() != null && rotina.getQ9V().equals("sim")){
                    if (rotina.getQ9VQ() == null || (rotina.getQ9VQ() != null && rotina.getQ9VQ().isEmpty())) {
                        rotinaValida = false;
                        String message = "Informe a quantidade de alunos com necessidades especiais Visuais (Questão 9)";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }
                }

                if (rotina.getQ9A() == null || (rotina.getQ9A() != null && rotina.getQ9A().isEmpty())) {
                    rotinaValida = false;
                    String message = "Informe se o núcleo possui alunos com necessidades especiais Auditivas (Questão 9)";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }else if(rotina.getQ9A() != null && rotina.getQ9A().equals("sim")){
                    if (rotina.getQ9AQ() == null || (rotina.getQ9AQ() != null && rotina.getQ9AQ().isEmpty())) {
                        rotinaValida = false;
                        String message = "Informe a quantidade de alunos com necessidades especiais Auditivas (Questão 9)";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }
                }

                if (rotina.getQ9M() == null || (rotina.getQ9M() != null && rotina.getQ9M().isEmpty())) {
                    rotinaValida = false;
                    String message = "Informe se o núcleo possui alunos com necessidades especiais Motoras (Questão 9)";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }else if(rotina.getQ9M() != null && rotina.getQ9M().equals("sim")){
                    if (rotina.getQ9MQ() == null || (rotina.getQ9MQ() != null && rotina.getQ9MQ().isEmpty())) {
                        rotinaValida = false;
                        String message = "Informe a quantidade de alunos com necessidades especiais Motoras (Questão 9)";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }
                }

                if (rotina.getQ9O() == null || (rotina.getQ9O() != null && rotina.getQ9O().isEmpty())) {
                    rotinaValida = false;
                    String message = "Informe se o núcleo possui alunos com Outras necessidades especiais (Questão 9)";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }else if(rotina.getQ9O() != null && rotina.getQ9O().equals("sim")){
                    if (rotina.getQ9OQ() == null || (rotina.getQ9OQ() != null && rotina.getQ9OQ().isEmpty())) {
                        rotinaValida = false;
                        String message = "Informe a quantidade de alunos com Outras necessidades especiais (Questão 9)";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }
                }

                 if (rotina.getQ10() == null || (rotina.getQ10() != null && rotina.getQ10().isEmpty())) {
                    rotinaValida = false;
                    String message = "A questão 10 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }else if(rotina.getQ10() != null && rotina.getQ10().equals("sim")){
                    if (rotina.getQ10AV() == null || (rotina.getQ10AV() != null && rotina.getQ10AV().isEmpty())) {
                        rotinaValida = false;
                        String message = "Informe se existe alguma adequação de espaço para alunos com necessidades especiais Visuais (Questão 10)";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }
                    if (rotina.getQ10SV() == null || (rotina.getQ10SV() != null && rotina.getQ10SV().isEmpty())) {
                        rotinaValida = false;
                        String message = "Informe se existe algum Suporte Técnico para alunos com necessidades especiais Visuais (Questão 10)";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }
                    if (rotina.getQ10AA() == null || (rotina.getQ10AA() != null && rotina.getQ10AA().isEmpty())) {
                        rotinaValida = false;
                        String message = "Informe se existe alguma adequação de espaço para alunos com necessidades especiais Auditivas (Questão 10)";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }
                    if (rotina.getQ10SA() == null || (rotina.getQ10SA() != null && rotina.getQ10SA().isEmpty())) {
                        rotinaValida = false;
                        String message = "Informe se existe algum Suporte Técnico para alunos com necessidades especiais Auditivas (Questão 10)";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }
                    if (rotina.getQ10AM() == null || (rotina.getQ10AM() != null && rotina.getQ10AM().isEmpty())) {
                        rotinaValida = false;
                        String message = "Informe se existe alguma adequação de espaço para alunos com necessidades especiais Motoras (Questão 10)";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }
                    if (rotina.getQ10SM() == null || (rotina.getQ10SM() != null && rotina.getQ10SM().isEmpty())) {
                        rotinaValida = false;
                        String message = "Informe se existe algum Suporte Técnico para alunos com necessidades especiais Motoras (Questão 10)";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }
                    if (rotina.getQ10AO() == null || (rotina.getQ10AO() != null && rotina.getQ10AO().isEmpty())) {
                        rotinaValida = false;
                        String message = "Informe se existe alguma adequação de espaço para alunos com Outras necessidades especiais (Questão 10)";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }
                    if (rotina.getQ10SO() == null || (rotina.getQ10SO() != null && rotina.getQ10SO().isEmpty())) {
                        rotinaValida = false;
                        String message = "Informe se existe algum Suporte Técnico para alunos com Outras necessidades especiais (Questão 10)";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }
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
                }else if(rotina.getQ13() != null && rotina.getQ13().equals("sim")){
                    if (rotina.getQ14() == null || (rotina.getQ14() != null && rotina.getQ14().isEmpty())) {
                        rotinaValida = false;
                        String message = "A Questão número 14 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }
                    if (rotina.getQ15() == null || (rotina.getQ15() != null && rotina.getQ15().isEmpty())) {
                        rotinaValida = false;
                        String message = "A Questão número 15 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }
                }

                if (rotina.getQ16() == null || (rotina.getQ16() != null && rotina.getQ16().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 16 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ17() == null || (rotina.getQ17() != null && rotina.getQ17().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 17 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ18() == null || (rotina.getQ18() != null && rotina.getQ18().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 18 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ19() == null || (rotina.getQ19() != null && rotina.getQ19().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 19 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ21() == null || (rotina.getQ21() != null && rotina.getQ21().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 21 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                } else {
                    if (rotina.getQ21Complemento() != null && rotina.getQ21Complemento().isEmpty()) {
                        rotinaValida = false;
                        String message = "As informações complementares da questão número 21 devem ser informadas";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }
                }

                if (rotina.getQ20() == null || (rotina.getQ20() != null && rotina.getQ20().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 20 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                } else {
                    if (rotina.getQ20() != null) {
                        if (rotina.getQ20().equals("0")) {
                            rotina.setQ23(null);
                            rotina.setQ24(null);
                            rotina.setQ25(null);
                            rotina.setQ26(null);
                            rotina.setQ27(null);
                            rotina.setQ28(null);
                            rotina.setQ29(null);
                            rotina.setQ30(null);
                            rotina.setQ31(null);
                            rotina.setQ32(null);
                            rotina.setQ33(null);
                            rotina.setQ34(null);
                            rotina.setQ35(null);
                            rotina.setQ36(null);
                            rotina.setQ37(null);
                            rotina.setQ38(null);
                            rotina.setQ39(null);
                            rotina.setQ40(null);
                            rotina.setQ41(null);
                            rotina.setQ42(null);
                            rotina.setQ43(null);
                            rotina.setQ44(null);
                            rotina.setQ45(null);
                            rotina.setQ46(null);
                            rotina.setQ47(null);
                            rotina.setQ48(null);
                            rotina.setQ49(null);
                            rotina.setQ50(null);
                            rotina.setQ51(null);
                            rotina.setQ52(null);
                            rotina.setQ53(null);
                            rotina.setQ54(null);
                            rotina.setQ55(null);
                            rotina.setQ56(null);
                            rotina.setQ57(null);
                            rotina.setQ58(null);
                            rotina.setQ59(null);
                            rotina.setQ60(null);
                            rotina.setQ61(null);
                        }
                        if (rotina.getQ20().equals("1")) {
                            if (!validarTurma1(rotina)) {
                                rotinaValida = false;
                            }
                            rotina.setQ30(null);
                            rotina.setQ31(null);
                            rotina.setQ32(null);
                            rotina.setQ33(null);
                            rotina.setQ34(null);
                            rotina.setQ35(null);
                            rotina.setQ36(null);
                            rotina.setQ37(null);
                            rotina.setQ38(null);
                            rotina.setQ39(null);
                            rotina.setQ40(null);
                            rotina.setQ41(null);
                            rotina.setQ42(null);
                            rotina.setQ43(null);
                            rotina.setQ44(null);
                            rotina.setQ45(null);
                            rotina.setQ46(null);
                            rotina.setQ47(null);
                            rotina.setQ48(null);
                            rotina.setQ49(null);
                            rotina.setQ50(null);
                            rotina.setQ51(null);
                            rotina.setQ52(null);
                            rotina.setQ53(null);
                            rotina.setQ54(null);
                            rotina.setQ55(null);
                            rotina.setQ56(null);
                            rotina.setQ57(null);
                            rotina.setQ58(null);
                            rotina.setQ59(null);
                            rotina.setQ60(null);
                            rotina.setQ61(null);
                        }
                        if (rotina.getQ20().equals("2")) {
                            if (!validarTurma1(rotina)) {
                                rotinaValida = false;
                            }
                            if (!validarTurma2(rotina)) {
                                rotinaValida = false;
                            }
                            rotina.setQ38(null);
                            rotina.setQ39(null);
                            rotina.setQ40(null);
                            rotina.setQ41(null);
                            rotina.setQ42(null);
                            rotina.setQ43(null);
                            rotina.setQ44(null);
                            rotina.setQ45(null);
                            rotina.setQ46(null);
                            rotina.setQ47(null);
                            rotina.setQ48(null);
                            rotina.setQ49(null);
                            rotina.setQ50(null);
                            rotina.setQ51(null);
                            rotina.setQ52(null);
                            rotina.setQ53(null);
                            rotina.setQ54(null);
                            rotina.setQ55(null);
                            rotina.setQ56(null);
                            rotina.setQ57(null);
                            rotina.setQ58(null);
                            rotina.setQ59(null);
                            rotina.setQ60(null);
                            rotina.setQ61(null);
                        }
                        if (rotina.getQ20().equals("3")) {
                            if (!validarTurma1(rotina)) {
                                rotinaValida = false;
                            }
                            if (!validarTurma2(rotina)) {
                                rotinaValida = false;
                            }
                            if (!validarTurma3(rotina)) {
                                rotinaValida = false;
                            }
                            rotina.setQ46(null);
                            rotina.setQ47(null);
                            rotina.setQ48(null);
                            rotina.setQ49(null);
                            rotina.setQ50(null);
                            rotina.setQ51(null);
                            rotina.setQ52(null);
                            rotina.setQ53(null);
                            rotina.setQ54(null);
                            rotina.setQ55(null);
                            rotina.setQ56(null);
                            rotina.setQ57(null);
                            rotina.setQ58(null);
                            rotina.setQ59(null);
                            rotina.setQ60(null);
                            rotina.setQ61(null);
                        }
                        if (rotina.getQ20().equals("4")) {
                            if (!validarTurma1(rotina)) {
                                rotinaValida = false;
                            }
                            if (!validarTurma2(rotina)) {
                                rotinaValida = false;
                            }
                            if (!validarTurma3(rotina)) {
                                rotinaValida = false;
                            }
                            if (!validarTurma4(rotina)) {
                                rotinaValida = false;
                            }
                            rotina.setQ54(null);
                            rotina.setQ55(null);
                            rotina.setQ56(null);
                            rotina.setQ57(null);
                            rotina.setQ58(null);
                            rotina.setQ59(null);
                            rotina.setQ60(null);
                            rotina.setQ61(null);
                        }
                        if (rotina.getQ20().equals("5")) {
                            if (!validarTurma1(rotina)) {
                                rotinaValida = false;
                            }
                            if (!validarTurma2(rotina)) {
                                rotinaValida = false;
                            }
                            if (!validarTurma3(rotina)) {
                                rotinaValida = false;
                            }
                            if (!validarTurma4(rotina)) {
                                rotinaValida = false;
                            }
                            if (!validarTurma5(rotina)) {
                                rotinaValida = false;
                            }
                        }
                    }
                }

                if (rotina.getQ62() == null || (rotina.getQ62() != null && rotina.getQ62().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 62 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ63() == null || (rotina.getQ63() != null && rotina.getQ63().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 63 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ64() == null || (rotina.getQ64() != null && rotina.getQ64().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 64 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ65() == null || (rotina.getQ65() != null && rotina.getQ65().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 65 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ66() == null || (rotina.getQ66() != null && rotina.getQ66().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 66 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ67() == null || (rotina.getQ67() != null && rotina.getQ67().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 67 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ68() == null || (rotina.getQ68() != null && rotina.getQ68().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 68 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
                
                if (rotina.getQ69() == null || (rotina.getQ69() != null && rotina.getQ69().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 69 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                } else {
                    if (rotina.getQ69() != null && rotina.getQ69().equals("sim")) {
                        if (rotina.getQ69Complemento() != null && rotina.getQ69Complemento().isEmpty()) {
                            rotinaValida = false;
                            String message = "As informações complementares da questão número 69 devem ser informadas";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }
                    } else {
                        rotina.setQ69Complemento(null);
                    }
                }

                if (rotina.getQ70() == null || (rotina.getQ70() != null && rotina.getQ70().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 70 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                } else {
                    if (rotina.getQ70() != null && rotina.getQ70().equals("sim")) {
                        if (rotina.getQ70Complemento() != null && rotina.getQ70Complemento().isEmpty()) {
                            rotinaValida = false;
                            String message = "As informações complementares da questão número 70 devem ser informadas";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }
                    } else {
                        rotina.setQ70Complemento(null);
                    }
                }

                if (rotina.getQ71() == null || (rotina.getQ71() != null && rotina.getQ71().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 71 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                } else {
                    if (rotina.getQ71() != null && rotina.getQ71().equals("sim")) {
                        if (rotina.getQ71Complemento() != null && rotina.getQ71Complemento().isEmpty()) {
                            rotinaValida = false;
                            String message = "As informações complementares da questão número 71 devem ser informadas";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }
                    } else {
                        rotina.setQ71Complemento(null);
                    }
                }

                if (rotina.getQ72() == null || (rotina.getQ72() != null && rotina.getQ72().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 72 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                } else {
                    if (rotina.getQ72() != null && rotina.getQ72().equals("sim")) {
                        if (rotina.getQ72Complemento() != null && rotina.getQ72Complemento().isEmpty()) {
                            rotinaValida = false;
                            String message = "As informações complementares da questão número 72 devem ser informadas";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }
                    } else {
                        rotina.setQ72Complemento(null);
                    }
                }

                if (rotina.getQ73() != null && rotina.getQ73().isEmpty()) {
                    rotinaValida = false;
                    String message = "A Questão número 73 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                } else {
                    if (rotina.getQ73() == null || (rotina.getQ73() != null && rotina.getQ73().equals("sim"))) {
                        if (rotina.getQ73Complemento() != null && rotina.getQ73Complemento().isEmpty()) {
                            rotinaValida = false;
                            String message = "As informações complementares da questão número 73 devem ser informadas";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }
                    } else {
                        rotina.setQ73Complemento(null);
                    }
                }

                if (rotina.getQ74() != null && rotina.getQ74().isEmpty()) {
                    rotinaValida = false;
                    String message = "A Questão número 74 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                } else {
                    if (rotina.getQ74() == null || (rotina.getQ74() != null && rotina.getQ74().equals("sim"))) {
                        if (rotina.getQ74Complemento() != null && rotina.getQ74Complemento().isEmpty()) {
                            rotinaValida = false;
                            String message = "As informações complementares da questão número 74 devem ser informadas";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }
                    } else {
                        rotina.setQ74Complemento(null);
                    }
                }
            } else {
                rotina.setQ3(null);
                rotina.setQ4a(null);
                rotina.setQ4b(null);
                rotina.setQ5(null);
                rotina.setQ6(null);
                rotina.setQ7(null);
                rotina.setQ8(null);
                rotina.setQ69(null);
                rotina.setQ69Complemento(null);
                rotina.setQ70(null);
                rotina.setQ70Complemento(null);
                rotina.setQ71(null);
                rotina.setQ71Complemento(null);
                rotina.setQ72(null);
                rotina.setQ72Complemento(null);
                rotina.setQ73(null);
                rotina.setQ73Complemento(null);
                rotina.setQ74(null);
                rotina.setQ74Complemento(null);
            }
        }



        return rotinaValida;
    }

    private static boolean validarTurma1(Rotina004 rotina) {
        boolean rotinaValida = true;

        if (rotina.getQ22() == null || (rotina.getQ22() != null && rotina.getQ22().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 22 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ23() == null || (rotina.getQ23() != null && rotina.getQ23().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 23 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ24() == null || (rotina.getQ24() != null && rotina.getQ24().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 24 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ25() == null || (rotina.getQ25() != null && rotina.getQ25().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 25 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ26() == null || (rotina.getQ26() != null && rotina.getQ26().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 26 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ27() == null || (rotina.getQ27() != null && rotina.getQ27().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 27 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ28() == null || (rotina.getQ28() != null && rotina.getQ28().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 28 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ29() == null || (rotina.getQ29() != null && rotina.getQ29().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 29 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        return rotinaValida;
    }

    private static boolean validarTurma2(Rotina004 rotina) {
        boolean rotinaValida = true;

        if (rotina.getQ30() == null || (rotina.getQ30() != null && rotina.getQ30().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 30 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ31() == null || (rotina.getQ31() != null && rotina.getQ31().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 31 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ32() == null || (rotina.getQ32() != null && rotina.getQ32().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 32 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ33() == null || (rotina.getQ33() != null && rotina.getQ33().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 33 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ34() == null || (rotina.getQ34() != null && rotina.getQ34().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 34 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ35() == null || (rotina.getQ35() != null && rotina.getQ35().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 35 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ36() == null || (rotina.getQ36() != null && rotina.getQ36().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 36 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ37() == null || (rotina.getQ37() != null && rotina.getQ37().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 37 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        return rotinaValida;
    }

    private static boolean validarTurma3(Rotina004 rotina) {
        boolean rotinaValida = true;

        if (rotina.getQ38() == null || (rotina.getQ38() != null && rotina.getQ38().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 38 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ39() == null || (rotina.getQ39() != null && rotina.getQ39().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 39 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ40() == null || (rotina.getQ40() != null && rotina.getQ40().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 40 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ41() == null || (rotina.getQ41() != null && rotina.getQ41().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 41 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ42() == null || (rotina.getQ42() != null && rotina.getQ42().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 42 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ43() == null || (rotina.getQ43() != null && rotina.getQ43().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 43 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ44() == null || (rotina.getQ44() != null && rotina.getQ44().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 44 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ45() == null || (rotina.getQ45() != null && rotina.getQ45().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 45 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        return rotinaValida;
    }

    private static boolean validarTurma4(Rotina004 rotina) {
        boolean rotinaValida = true;

        if (rotina.getQ46() == null || (rotina.getQ46() != null && rotina.getQ46().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 46 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ47() == null || (rotina.getQ47() != null && rotina.getQ47().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 47 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ48() == null || (rotina.getQ48() != null && rotina.getQ48().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 48 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ49() == null || (rotina.getQ49() != null && rotina.getQ49().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 49 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ50() == null || (rotina.getQ50() != null && rotina.getQ50().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 50 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ51() == null || (rotina.getQ51() != null && rotina.getQ51().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 51 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ52() == null || (rotina.getQ52() != null && rotina.getQ52().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 52 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ53() == null || (rotina.getQ53() != null && rotina.getQ53().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 53 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        return rotinaValida;
    }

    private static boolean validarTurma5(Rotina004 rotina) {
        boolean rotinaValida = true;

        if (rotina.getQ54() == null || (rotina.getQ54() != null && rotina.getQ54().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 54 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ55() == null || (rotina.getQ55() != null && rotina.getQ55().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 55 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ56() == null || (rotina.getQ56() != null && rotina.getQ56().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 56 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ57() == null || (rotina.getQ57() != null && rotina.getQ57().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 57 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ58() == null || (rotina.getQ58() != null && rotina.getQ58().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 58 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ59() == null || (rotina.getQ59() != null && rotina.getQ59().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 59 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ60() == null || (rotina.getQ60() != null && rotina.getQ60().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 60 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ61() == null || (rotina.getQ61() != null && rotina.getQ61().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 61 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        return rotinaValida;
    }
}
