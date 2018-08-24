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
public class ValidacaoR004V2 {

    public static boolean validaRotina(Rotina004V2 rotina) {

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



                if (rotina.getQ10() == null || (rotina.getQ10() != null && rotina.getQ10().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 10 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                } else {
                    if (rotina.getQ10() != null && rotina.getQ10().equals("sim")) {
                        if (rotina.getQ10Complemento() != null && rotina.getQ10Complemento().isEmpty()) {
                            rotinaValida = false;
                            String message = "As informações complementares da questão número 10 devem ser informadas";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }
                    } else {
                        rotina.setQ10Complemento(null);
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
                }

                if (rotina.getQ14() == null || (rotina.getQ14() != null && rotina.getQ14().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 14 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                } else {
                    if (rotina.getQ14() != null && rotina.getQ14().equals("sim")) {
                        if (rotina.getQ15() == null || (rotina.getQ15() != null && rotina.getQ15().isEmpty())) {
                            rotinaValida = false;
                            String message = "A Questão número 15 deve ser informada";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }
                    } else {
                        rotina.setQ15(null);
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
                } else {
                    if (rotina.getQ19() != null) {
                        if (rotina.getQ19().equals("0")) {
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
                        }
                        if (rotina.getQ19().equals("1")) {
                            if (!validarTurma1(rotina)) {
                                rotinaValida = false;
                            }
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
                        }
                        if (rotina.getQ19().equals("2")) {
                            if (!validarTurma1(rotina)) {
                                rotinaValida = false;
                            }
                            if (!validarTurma2(rotina)) {
                                rotinaValida = false;
                            }
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
                            rotina.setQ45(null);
                            rotina.setQ46(null);
                            rotina.setQ47(null);
                            rotina.setQ48(null);
                            rotina.setQ49(null);
                            rotina.setQ50(null);
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

                if (rotina.getQ20() == null || (rotina.getQ20() != null && rotina.getQ20().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 20 deve ser informada";
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
                } else {
                    if (rotina.getQ61() != null && rotina.getQ61().equals("sim")) {
                        if (rotina.getQ61Complemento() != null && rotina.getQ61Complemento().isEmpty()) {
                            rotinaValida = false;
                            String message = "As informações complementares da questão número 61 devem ser informadas";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }
                    } else {
                        rotina.setQ61Complemento(null);
                    }
                }



                if (rotina.getQ62() == null || (rotina.getQ62() != null && rotina.getQ62().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 62 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                } else {
                    if (rotina.getQ62() != null && rotina.getQ62().equals("sim")) {
                        if (rotina.getQ62Complemento() != null && rotina.getQ62Complemento().isEmpty()) {
                            rotinaValida = false;
                            String message = "As informações complementares da questão número 62 devem ser informadas";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }
                    } else {
                        rotina.setQ62Complemento(null);
                    }
                }



                if (rotina.getQ63() == null || (rotina.getQ63() != null && rotina.getQ63().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 63 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                } else {
                    if (rotina.getQ63() != null && rotina.getQ63().equals("sim")) {
                        if (rotina.getQ63Complemento() != null && rotina.getQ63Complemento().isEmpty()) {
                            rotinaValida = false;
                            String message = "As informações complementares da questão número 63 devem ser informadas";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }
                    } else {
                        rotina.setQ63Complemento(null);
                    }
                }


                if (rotina.getQ64() == null || (rotina.getQ64() != null && rotina.getQ64().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 64 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                } else {
                    if (rotina.getQ64() != null && rotina.getQ64().equals("sim")) {
                        if (rotina.getQ64Complemento() != null && rotina.getQ64Complemento().isEmpty()) {
                            rotinaValida = false;
                            String message = "As informações complementares da questão número 64 devem ser informadas";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }
                    } else {
                        rotina.setQ64Complemento(null);
                    }
                }



                if (rotina.getQ65() != null && rotina.getQ65().isEmpty()) {
                    rotinaValida = false;
                    String message = "A Questão número 65 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                } else {
                    if (rotina.getQ65() == null || (rotina.getQ65() != null && rotina.getQ65().equals("sim"))) {
                        if (rotina.getQ65Complemento() != null && rotina.getQ65Complemento().isEmpty()) {
                            rotinaValida = false;
                            String message = "As informações complementares da questão número 65 devem ser informadas";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }
                    } else {
                        rotina.setQ65Complemento(null);
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
                rotina.setQ9(null);
                rotina.setQ10(null);
                rotina.setQ10Complemento(null);
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
                rotina.setQ61Complemento(null);
                rotina.setQ62(null);
                rotina.setQ62Complemento(null);
                rotina.setQ63(null);
                rotina.setQ63Complemento(null);
                rotina.setQ64(null);
                rotina.setQ64Complemento(null);
                rotina.setQ65(null);
                rotina.setQ65Complemento(null);
            }
        }



        return rotinaValida;
    }

    private static boolean validarTurma1(Rotina004V2 rotina) {
        boolean rotinaValida = true;

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
        return rotinaValida;
    }

    private static boolean validarTurma2(Rotina004V2 rotina) {
        boolean rotinaValida = true;

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
        return rotinaValida;
    }

    private static boolean validarTurma3(Rotina004V2 rotina) {
        boolean rotinaValida = true;

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

        if (rotina.getQ38() == null || (rotina.getQ38() != null && rotina.getQ38().isEmpty())) {
            rotinaValida = false;
            String message = "A Questão número 38 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        return rotinaValida;
    }

    private static boolean validarTurma4(Rotina004V2 rotina) {
        boolean rotinaValida = true;

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
        return rotinaValida;
    }

    private static boolean validarTurma5(Rotina004V2 rotina) {
        boolean rotinaValida = true;

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
        return rotinaValida;
    }
}
