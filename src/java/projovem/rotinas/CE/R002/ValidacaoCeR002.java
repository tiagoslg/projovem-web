/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.rotinas.CE.R002;

import projovem.rotinas.R005.*;
import projovem.rotinas.R004.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Leandro Nunes
 */
public class ValidacaoCeR002 {

    public static boolean validaRotina(CeRotina002 rotina) {

        boolean rotinaValida = true;

        if (rotina.getListComponenteCurricular() == null || (rotina.getListComponenteCurricular() != null && rotina.getListComponenteCurricular().isEmpty())) {
            rotinaValida = false;
            String message = "Informe a(s) disciplina(s) que o Educador leciona no núcleo.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if (rotina.getNome() == null || (rotina.getNome() != null && rotina.getNome().isEmpty())) {
            rotinaValida = false;
            String message = "Informe o Nome do Educador.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getMotivo() == null || rotina.getMotivo() != null && rotina.getMotivo().isEmpty()) {
            rotinaValida = false;
            String message = "Informe se o educador respondeu ou não ao questionário.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        } else {
            if (rotina.getMotivo() == null || (rotina.getMotivo() != null && rotina.getMotivo().isEmpty())) {
                if (rotina.getMotivoComplemento() != null && rotina.getMotivo().equals("outro")) {
                    rotinaValida = false;
                    String message = "Informe o motivo para o educador não ter respondido ao questionário.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
            }
            if (rotina.getMotivoComplemento() != null && rotina.getMotivo().equals("respondeu")) {

                if (rotina.getQ1() == null || (rotina.getQ1() != null && rotina.getQ1().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 1 deve ser informada.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ2() == null || (rotina.getQ2() != null && rotina.getQ2().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 2 deve ser informada.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ3() == null || (rotina.getQ3() != null && rotina.getQ3().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 3 deve ser informada.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ4() == null || (rotina.getQ4() != null && rotina.getQ4().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 4 deve ser informada.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getListQ5() == null || (rotina.getListQ5() != null && rotina.getListQ5().isEmpty())) {
                    rotinaValida = false;
                    String message = "Informe os níveis/modalidades que o Educador já lecionou por pelo menos um ano.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                } else {
                    if (rotina.getQ5OutrosComplemento() == null && rotina.getListQ5().contains("Q5Outros")) {
                        rotinaValida = false;
                        String message = "Informe o outro nível/modalidade de ensino que o Educador já lecionou.";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }
                }

                if (rotina.getQ6() == null || (rotina.getQ6() != null && rotina.getQ6().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 6 deve ser informada.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getListQ7() == null || (rotina.getListQ7() != null && rotina.getListQ7().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 7 deve ser informada.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getListQ8() == null || (rotina.getListQ8() != null && rotina.getListQ8().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 8 deve ser informada.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ9SoftwaresTexto() == null || (rotina.getQ9SoftwaresTexto() != null && rotina.getQ9SoftwaresTexto().isEmpty())) {
                    rotinaValida = false;
                    String message = "Informe o nível de conhecimento do Educador em Software de texto (Questão 9).";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ9ConfeccaoPlanilhas() == null || (rotina.getQ9ConfeccaoPlanilhas() != null && rotina.getQ9ConfeccaoPlanilhas().isEmpty())) {
                    rotinaValida = false;
                    String message = "Informe o nível de conhecimento do Educador em Confecção de Planilhas (Questão 9).";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ9Internet() == null || (rotina.getQ9Internet() != null && rotina.getQ9Internet().isEmpty())) {
                    rotinaValida = false;
                    String message = "Informe o nível de conhecimento do Educador em Internet (Questão 9).";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ10() == null || (rotina.getQ10() != null && rotina.getQ10().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 10 deve ser informada.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                } else {
                    if ((rotina.getQ10() != null && rotina.getQ10().equals("sim")) || (rotina.getQ10() != null && rotina.getQ10().equals("parcialmente"))) {
                        if (rotina.getQ11a() == null || (rotina.getQ11a() != null && rotina.getQ11a().isEmpty())) {
                            rotinaValida = false;
                            String message = "Informe a data de início da Formação Inicial (Questão 11-A)";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }
                        if (rotina.getQ11b() == null || (rotina.getQ11b() != null && rotina.getQ11b().isEmpty())) {
                            rotinaValida = false;
                            String message = "Informe a data de término da Formação Inicial (Questão 11-B)";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }

                        if (rotina.getQ12() == null || (rotina.getQ12() != null && rotina.getQ12().isEmpty())) {
                            rotinaValida = false;
                            String message = "A Questão número 12 deve ser informada.";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }

                        if (rotina.getQ13() == null || (rotina.getQ13() != null && rotina.getQ13().isEmpty())) {
                            rotinaValida = false;
                            String message = "A Questão número 13 deve ser informada.";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }

                        if (rotina.getQ14() == null || (rotina.getQ14() != null && rotina.getQ14().isEmpty())) {
                            rotinaValida = false;
                            String message = "A Questão número 14 deve ser informada.";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }

                        if (rotina.getQ15() == null || (rotina.getQ15() != null && rotina.getQ15().isEmpty())) {
                            rotinaValida = false;
                            String message = "A Questão número 15 deve ser informada.";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }
                    } else {
                        rotina.setQ11a(null);
                        rotina.setQ11b(null);
                        rotina.setQ12(null);
                        rotina.setQ13(null);
                        rotina.setQ14(null);
                        rotina.setQ15(null);
                    }
                }

                if (rotina.getQ16() == null || (rotina.getQ16() != null && rotina.getQ16().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 16 deve ser informada.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                } else {
                    if ((rotina.getQ16() != null && rotina.getQ16().equals("sim12menos")) || (rotina.getQ16() != null && rotina.getQ16().equals("sim12horas"))) {
                        if (rotina.getQ17() == null || (rotina.getQ17() != null && rotina.getQ17().isEmpty())) {
                            rotinaValida = false;
                            String message = "A Questão número 17 deve ser informada.";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }
                        if (rotina.getQ18() == null || (rotina.getQ18() != null && rotina.getQ18().isEmpty())) {
                            rotinaValida = false;
                            String message = "A Questão número 18 deve ser informada.";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }

                        if (rotina.getQ19() == null || (rotina.getQ19() != null && rotina.getQ19().isEmpty())) {
                            rotinaValida = false;
                            String message = "A Questão número 19 deve ser informada.";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }

                        if (rotina.getQ20() == null || (rotina.getQ20() != null && rotina.getQ20().isEmpty())) {
                            rotinaValida = false;
                            String message = "A Questão número 20 deve ser informada.";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        } else {
                            if (rotina.getQ20Complemento().isEmpty() && rotina.getQ20().equals("outro")) {
                                rotinaValida = false;
                                String message = "Informe o complemento da Questão 20.";
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                            } else {
                                rotina.setQ20Complemento(null);
                            }
                        }

                        if (rotina.getQ21() == null || (rotina.getQ21() != null && rotina.getQ21().isEmpty())) {
                            rotinaValida = false;
                            String message = "A Questão número 21 deve ser informada.";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }

                        if (rotina.getQ22() == null || (rotina.getQ22() != null && rotina.getQ22().isEmpty())) {
                            rotinaValida = false;
                            String message = "A Questão número 22 deve ser informada.";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }

                        if (rotina.getQ23() == null || (rotina.getQ23() != null && rotina.getQ23().isEmpty())) {
                            rotinaValida = false;
                            String message = "A Questão número 23 deve ser informada.";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }

                        if (rotina.getQ24() == null || (rotina.getQ24() != null && rotina.getQ24().isEmpty())) {
                            rotinaValida = false;
                            String message = "A Questão número 24 deve ser informada.";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }

                        if (rotina.getQ25() == null || (rotina.getQ25() != null && rotina.getQ25().isEmpty())) {
                            rotinaValida = false;
                            String message = "A Questão número 25 deve ser informada.";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }

                        if (rotina.getQ26() == null || (rotina.getQ26() != null && rotina.getQ26().isEmpty())) {
                            rotinaValida = false;
                            String message = "A Questão número 26 deve ser informada.";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }

                        if (rotina.getQ27() == null || (rotina.getQ27() != null && rotina.getQ27().isEmpty())) {
                            rotinaValida = false;
                            String message = "A Questão número 27 deve ser informada.";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }

                        if (rotina.getQ28() == null || (rotina.getQ28() != null && rotina.getQ28().isEmpty())) {
                            rotinaValida = false;
                            String message = "A Questão número 28 deve ser informada.";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }

                        if (rotina.getQ29() == null || (rotina.getQ29() != null && rotina.getQ29().isEmpty())) {
                            rotinaValida = false;
                            String message = "A Questão número 29 deve ser informada.";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }

                        if (rotina.getQ30() == null || (rotina.getQ30() != null && rotina.getQ30().isEmpty())) {
                            rotinaValida = false;
                            String message = "A Questão número 30 deve ser informada.";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }

                        if (rotina.getQ31() == null || (rotina.getQ31() != null && rotina.getQ31().isEmpty())) {
                            rotinaValida = false;
                            String message = "A Questão número 31 deve ser informada.";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }

                        if (rotina.getQ32() == null || (rotina.getQ32() != null && rotina.getQ32().isEmpty())) {
                            rotinaValida = false;
                            String message = "A Questão número 32 deve ser informada.";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }
                    } else {
                        rotina.setQ17(null);
                        rotina.setQ18(null);
                        rotina.setQ19(null);
                        rotina.setQ20(null);
                        rotina.setQ20Complemento(null);
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
                        rotina.setQ31(null);
                        rotina.setQ32(null);
                    }
                }
            } else {
                rotina.setQ1(null);
                rotina.setQ2(null);
                rotina.setQ3(null);
                rotina.setQ4(null);
                rotina.setListQ5(null);
                rotina.setQ5OutrosComplemento(null);
                rotina.setQ6(null);
                rotina.setListQ7(null);
                rotina.setListQ8(null);
                rotina.setQ9SoftwaresTexto(null);
                rotina.setQ9ConfeccaoPlanilhas(null);
                rotina.setQ9Internet(null);
                rotina.setQ10(null);
                rotina.setQ11a(null);
                rotina.setQ11b(null);
                rotina.setQ12(null);
                rotina.setQ13(null);
                rotina.setQ14(null);
                rotina.setQ15(null);
                rotina.setQ16(null);
                rotina.setQ17(null);
                rotina.setQ18(null);
                rotina.setQ19(null);
                rotina.setQ20(null);
                rotina.setQ20Complemento(null);
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
                rotina.setQ31(null);
                rotina.setQ32(null);
            }
        }
        return rotinaValida;
    }
}
