/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.rotinas.CE.R001;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import projovem.rotinas.R001.Rotina001;

/**
 *
 * @author Leandro Nunes
 */
public class ValidacaoCeR001 {

    public static boolean validaRotina(CeRotina001 rotina) {

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
            String message = "A hora de término da visita deve ser informada";
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
                if (rotina.getQ3a() == null || (rotina.getQ3a() != null && rotina.getQ3a().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 3 (Hora de Abertura) deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ3b() == null || (rotina.getQ3b() != null && rotina.getQ3b().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 3 (Hora de Fechamento) deve ser informada";
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
                }

                if (rotina.getQ12() == null || (rotina.getQ12() != null && rotina.getQ12().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 12 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                } else {
                    if (rotina.getQ12() != null && rotina.getQ12().equals("sim")) {
                        if (rotina.getQ13() == null || (rotina.getQ13() != null && rotina.getQ13().isEmpty())) {
                            rotinaValida = false;
                            String message = "A Questão número 13 deve ser informada";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }
                    } else {
                        rotina.setQ13(null);
                    }
                }

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
                } else {
                    if (rotina.getQ19() != null) {
                        if (rotina.getQ19().equals("0")) {
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

                        }
                        if (rotina.getQ19().equals("1")) {
                            if (!validarTurma1(rotina)) {
                                rotinaValida = false;
                            }
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

                        }
                        if (rotina.getQ19().equals("2")) {
                            if (!validarTurma1(rotina)) {
                                rotinaValida = false;
                            }
                            if (!validarTurma2(rotina)) {
                                rotinaValida = false;
                            }
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
                        }
                        if (rotina.getQ19().equals("3")) {
                            if (!validarTurma1(rotina)) {
                                rotinaValida = false;
                            }
                            if (!validarTurma2(rotina)) {
                                rotinaValida = false;
                            }
                            if (!validarTurma3(rotina)) {
                                rotinaValida = false;
                            }
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
                        }
                        if (rotina.getQ19().equals("4")) {
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
                            rotina.setQ52(null);
                            rotina.setQ53(null);
                            rotina.setQ54(null);
                            rotina.setQ55(null);
                            rotina.setQ56(null);
                            rotina.setQ57(null);
                            rotina.setQ58(null);
                            rotina.setQ59(null);

                        }
                        if (rotina.getQ19().equals("5")) {
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
                } else {
                    if (rotina.getQ67() != null && rotina.getQ67().equals("sim")) {
                        if (rotina.getQ67Complemento() != null && rotina.getQ67Complemento().isEmpty()) {
                            rotinaValida = false;
                            String message = "As informações complementares da questão número 67 devem ser informadas";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }
                    } else {
                        rotina.setQ67Complemento(null);
                    }
                }

                if (rotina.getQ68() == null || (rotina.getQ68() != null && rotina.getQ68().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 68 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                } else {
                    if (rotina.getQ68() != null && rotina.getQ68().equals("sim")) {
                        if (rotina.getQ68Complemento() != null && rotina.getQ68Complemento().isEmpty()) {
                            rotinaValida = false;
                            String message = "As informações complementares da questão número 68 devem ser informadas";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }
                    } else {
                        rotina.setQ68Complemento(null);
                    }
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
            } else {
                rotina.setQ3a(null);
                rotina.setQ3b(null);
                rotina.setQ4(null);
                rotina.setQ5(null);
                rotina.setQ6(null);
                rotina.setQ7(null);
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
                rotina.setQ62(null);
                rotina.setQ63(null);
                rotina.setQ64(null);
                rotina.setQ65(null);
                rotina.setQ66(null);
                rotina.setQ67(null);
                rotina.setQ68(null);
                rotina.setQ69(null);
                rotina.setQ70(null);
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
        return rotinaValida;
    }

    private static boolean validarTurma1(CeRotina001 rotina) {
        boolean rotinaValida = true;

        if (rotina.getQ20() == null || (rotina.getQ20() != null && rotina.getQ20().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 20 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ21() == null || (rotina.getQ21() != null && rotina.getQ21().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 21 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

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
        return rotinaValida;
    }

    private static boolean validarTurma2(CeRotina001 rotina) {
        boolean rotinaValida = true;

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
        return rotinaValida;
    }

    private static boolean validarTurma3(CeRotina001 rotina) {
        boolean rotinaValida = true;

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
        return rotinaValida;
    }

    private static boolean validarTurma4(CeRotina001 rotina) {
        boolean rotinaValida = true;

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
        return rotinaValida;
    }

    private static boolean validarTurma5(CeRotina001 rotina) {
        boolean rotinaValida = true;

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
        return rotinaValida;
    }

    public static Rotina001 tratarListas(Rotina001 rotina001) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
