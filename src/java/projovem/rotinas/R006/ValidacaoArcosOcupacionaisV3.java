/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.rotinas.R006;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Leandro Nunes
 */
public class ValidacaoArcosOcupacionaisV3 {

    public static boolean validaRotina(Rotina006ArcosOcupacionaisV3 rotina) {

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

        if (rotina.getIdentificaEntradaObservacao() == null || rotina.getIdentificaEntradaObservacao().isEmpty() || rotina.getIdentificaEntradaObservacao().equals("NSA")) {
            rotinaValida = false;
            String message = "A observação a que se refere esta rotina deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getDataVisita() != null && rotina.getDataVisita().isEmpty()) {
            rotinaValida = false;
            String message = "A data da observação deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getHoraInicioVisita() != null && rotina.getHoraInicioVisita().isEmpty()) {
            rotinaValida = false;
            String message = "A hora de início da observação deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getHoraTerminoVisita() != null && rotina.getHoraTerminoVisita().isEmpty()) {
            rotinaValida = false;
            String message = "A hora de término da observação deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ4Aarco() == null || rotina.getQ4Aarco() != null && rotina.getQ4Aarco().isEmpty() || rotina.getQ4Aarco().equals("naoInformado")) {
            rotinaValida = false;
            String message = "O Arco A deve ser informado";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ4AdataObservacao() != null && rotina.getQ4AdataObservacao().isEmpty()) {
            rotinaValida = false;
            String message = "A data da observação do Arco A deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ4AhoraInicio() != null && rotina.getQ4AhoraInicio().isEmpty()) {
            rotinaValida = false;
            String message = "A hora de início da observação do Arco A deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ4AhoraTermino() != null && rotina.getQ4AhoraTermino().isEmpty()) {
            rotinaValida = false;
            String message = "A hora de término da observação do Arco A deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ2() != null && rotina.getQ2().isEmpty()) {
            rotinaValida = false;
            String message = "A Questão número 2 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (!rotina.getQ4Aarco().equals("semPrevisao")) {
            if (rotina.getQ5() == null || rotina.getQ5() != null && rotina.getQ5().isEmpty()) {
                rotinaValida = false;
                String message = "A Questão de número 5 deve ser informada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
            }else if(rotina.getQ5() != null && rotina.getQ5().equals("sim")){
                if ((rotina.getQ10InicioAtividades() != null && rotina.getQ10InicioAtividades().isEmpty()) && (rotina.getQ10FinalAtividades() != null && rotina.getQ10FinalAtividades().isEmpty()) && !rotina.getQ10Fechado().equals("true")) {
                    rotinaValida = false;
                    String message = "A Questão de número 10 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                } else {
                    if (rotina.getQ10Fechado() != null && rotina.getQ10Fechado().equals("true")) {
                        if (!rotina.getQ10InicioAtividades().isEmpty() || !rotina.getQ10FinalAtividades().isEmpty()) {
                            rotinaValida = false;
                            String message = "O horário de início ou término do Arco A (questão 10) não podem ser informados se o Arco estiver fechado";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }
                    } else {
                        if ((rotina.getQ10InicioAtividades() != null && rotina.getQ10InicioAtividades().isEmpty()) || (rotina.getQ10FinalAtividades() != null && rotina.getQ10FinalAtividades().isEmpty())) {
                            rotinaValida = false;
                            String message = "O horário de início e término do Arco A (questão 10) devem ser informados";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }
                    }
                }

                if (rotina.getQ15() == null || rotina.getQ15() != null && rotina.getQ15().isEmpty()) {
                    rotinaValida = false;
                    String message = "A Questão de número 15 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ20() == null || rotina.getQ20() != null && rotina.getQ20().isEmpty()) {
                    rotinaValida = false;
                    String message = "A Questão de número 20 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if ((rotina.getQ25Educadores() != null && rotina.getQ25Educadores().isEmpty()) || (rotina.getQ25Alunos() != null && rotina.getQ25Alunos().isEmpty())|| (rotina.getQ25AlunosI() != null && rotina.getQ25AlunosI().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão de número 25 deve ser totalmente informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ30() == null || rotina.getQ30() != null && rotina.getQ30().isEmpty()) {
                    rotinaValida = false;
                    String message = "A Questão de número 30 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ35() == null || rotina.getQ35() != null && rotina.getQ35().isEmpty()) {
                    rotinaValida = false;
                    String message = "A Questão de número 35 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ40() == null || rotina.getQ40() != null && rotina.getQ40().isEmpty()) {
                    rotinaValida = false;
                    String message = "A Questão de número 40 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ45() == null || rotina.getQ45() != null && rotina.getQ45().isEmpty()) {
                    rotinaValida = false;
                    String message = "A Questão de número 45 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ50() == null || rotina.getQ50() != null && rotina.getQ50().isEmpty()) {
                    rotinaValida = false;
                    String message = "A Questão de número 50 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
            }
        } else {
            rotina.setQ5(null);
            rotina.setQ10InicioAtividades(null);
            rotina.setQ10Fechado(null);
            rotina.setQ10InicioAtividades(null);
            rotina.setQ10FinalAtividades(null);
            rotina.setQ15(null);
            rotina.setQ20(null);
            rotina.setQ25Educadores(null);
            rotina.setQ25Alunos(null);
            rotina.setQ25AlunosI(null);
            rotina.setQ30(null);
            rotina.setQ35(null);
            rotina.setQ40(null);
            rotina.setQ45(null);
            rotina.setQ50(null);
        }

        if (!rotina.getQ4Barco().equals("naoInformado")) {
            if (rotina.getQ4BdataObservacao() != null && rotina.getQ4BdataObservacao().isEmpty()) {
                rotinaValida = false;
                String message = "A data da observação do Arco B deve ser informada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
            }

            if (rotina.getQ4BhoraInicio() != null && rotina.getQ4BhoraInicio().isEmpty()) {
                rotinaValida = false;
                String message = "A hora de início da observação do Arco B deve ser informada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
            }

            if (rotina.getQ4BhoraTermino() != null && rotina.getQ4BhoraTermino().isEmpty()) {
                rotinaValida = false;
                String message = "A hora de término da observação do Arco B deve ser informada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
            }

            if (!rotina.getQ4Barco().equals("semPrevisao")) {
                if (rotina.getQ6() == null || rotina.getQ6() != null && rotina.getQ6().isEmpty()) {
                    rotinaValida = false;
                    String message = "A Questão de número 6 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }else if(rotina.getQ6() != null && rotina.getQ6().equals("sim")){
                    if ((rotina.getQ11InicioAtividades() != null && rotina.getQ11InicioAtividades().isEmpty()) && (rotina.getQ11FinalAtividades() != null && rotina.getQ11FinalAtividades().isEmpty()) && !rotina.getQ11Fechado().equals("true")) {
                        rotinaValida = false;
                        String message = "A Questão de número 11 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    } else {
                        if (rotina.getQ11Fechado() != null && rotina.getQ11Fechado().equals("true")) {
                            if (!rotina.getQ11InicioAtividades().isEmpty() || !rotina.getQ11FinalAtividades().isEmpty()) {
                                rotinaValida = false;
                                String message = "O horário de início ou término do Arco B (questão 11) não podem ser informados se o Arco estiver fechado";
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                            }
                        } else {
                            if ((rotina.getQ11InicioAtividades() != null && rotina.getQ11InicioAtividades().isEmpty()) || (rotina.getQ11FinalAtividades() != null && rotina.getQ11FinalAtividades().isEmpty())) {
                                rotinaValida = false;
                                String message = "O horário de início e término do Arco B (questão 11) devem ser informados";
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                            }
                        }
                    }

                    if (rotina.getQ16() == null || rotina.getQ16() != null && rotina.getQ16().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão de número 16 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ21() == null || rotina.getQ21() != null && rotina.getQ21().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão de número 21 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if ((rotina.getQ26Educadores() != null && rotina.getQ26Educadores().isEmpty()) || (rotina.getQ26Alunos() != null && rotina.getQ26Alunos().isEmpty()) || (rotina.getQ26AlunosI() != null && rotina.getQ26AlunosI().isEmpty())) {
                        rotinaValida = false;
                        String message = "A Questão de número 26 deve ser totalmente informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ31() == null || rotina.getQ31() != null && rotina.getQ31().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão de número 31 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ36() == null || rotina.getQ36() != null && rotina.getQ36().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão de número 36 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ41() == null || rotina.getQ41() != null && rotina.getQ41().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão de número 41 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ46() == null || rotina.getQ46() != null && rotina.getQ46().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão de número 46 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ51() == null || rotina.getQ51() != null && rotina.getQ51().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão de número 51 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }
                }
            } else {
                rotina.setQ6(null);
                rotina.setQ11InicioAtividades(null);
                rotina.setQ11Fechado(null);
                rotina.setQ11InicioAtividades(null);
                rotina.setQ11FinalAtividades(null);
                rotina.setQ15(null);
                rotina.setQ21(null);
                rotina.setQ26Educadores(null);
                rotina.setQ26Alunos(null);
                rotina.setQ26AlunosI(null);
                rotina.setQ31(null);
                rotina.setQ36(null);
                rotina.setQ41(null);
                rotina.setQ46(null);
                rotina.setQ51(null);
            }
        }

        if (!rotina.getQ4Carco().equals("naoInformado")) {
            if (rotina.getQ4CdataObservacao() != null && rotina.getQ4CdataObservacao().isEmpty()) {
                rotinaValida = false;
                String message = "A data da observação do Arco C deve ser informada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
            }

            if (rotina.getQ4ChoraInicio() != null && rotina.getQ4ChoraInicio().isEmpty()) {
                rotinaValida = false;
                String message = "A hora de início da observação do Arco C deve ser informada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
            }

            if (rotina.getQ4ChoraTermino() != null && rotina.getQ4ChoraTermino().isEmpty()) {
                rotinaValida = false;
                String message = "A hora de término da observação do Arco C deve ser informada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
            }

            if (!rotina.getQ4Carco().equals("semPrevisao")) {
                if (rotina.getQ7() == null || rotina.getQ7() != null && rotina.getQ7().isEmpty()) {
                    rotinaValida = false;
                    String message = "A Questão de número 7 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }else if(rotina.getQ7() != null && rotina.getQ7().equals("sim")){
                    if ((rotina.getQ12InicioAtividades() != null && rotina.getQ12InicioAtividades().isEmpty()) && (rotina.getQ12FinalAtividades() != null && rotina.getQ12FinalAtividades().isEmpty()) && !rotina.getQ12Fechado().equals("true")) {
                        rotinaValida = false;
                        String message = "A Questão de número 12 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    } else {
                        if (rotina.getQ12Fechado().equals("true")) {
                            if (!rotina.getQ12InicioAtividades().isEmpty() || !rotina.getQ12FinalAtividades().isEmpty()) {
                                rotinaValida = false;
                                String message = "O horário de início ou término do Arco C (questão 12) não podem ser informados se o Arco estiver fechado";
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                            }
                        } else {
                            if ((rotina.getQ12InicioAtividades() != null && rotina.getQ12InicioAtividades().isEmpty()) || (rotina.getQ12FinalAtividades() != null && rotina.getQ12FinalAtividades().isEmpty())) {
                                rotinaValida = false;
                                String message = "O horário de início e término do Arco C (questão 12) devem ser informados";
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                            }
                        }
                    }

                    if (rotina.getQ17() == null || rotina.getQ17() != null && rotina.getQ17().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão de número 17 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ22() == null || rotina.getQ22() != null && rotina.getQ22().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão de número 22 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if ((rotina.getQ27Educadores() != null && rotina.getQ27Educadores().isEmpty()) || (rotina.getQ27Alunos() != null && rotina.getQ27Alunos().isEmpty()) || (rotina.getQ27AlunosI() != null && rotina.getQ27AlunosI().isEmpty())) {
                        rotinaValida = false;
                        String message = "A Questão de número 27 deve ser totalmente informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ32() == null || rotina.getQ32() != null && rotina.getQ32().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão de número 32 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ37() == null || rotina.getQ37() != null && rotina.getQ37().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão de número 37 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ42() == null || rotina.getQ42() != null && rotina.getQ42().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão de número 42 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ47() == null || rotina.getQ47() != null && rotina.getQ47().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão de número 47 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ52() == null || rotina.getQ52() != null && rotina.getQ52().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão de número 52 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }
                }
            } else {
                rotina.setQ7(null);
                rotina.setQ12InicioAtividades(null);
                rotina.setQ12Fechado(null);
                rotina.setQ12InicioAtividades(null);
                rotina.setQ12FinalAtividades(null);
                rotina.setQ17(null);
                rotina.setQ22(null);
                rotina.setQ27Educadores(null);
                rotina.setQ27Alunos(null);
                rotina.setQ27AlunosI(null);
                rotina.setQ32(null);
                rotina.setQ37(null);
                rotina.setQ42(null);
                rotina.setQ47(null);
                rotina.setQ52(null);
            }
        }

        if (!rotina.getQ4Darco().equals("naoInformado")) {
            if (rotina.getQ4DdataObservacao() != null && rotina.getQ4DdataObservacao().isEmpty()) {
                rotinaValida = false;
                String message = "A data da observação do Arco D deve ser informada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
            }

            if (rotina.getQ4DhoraInicio() != null && rotina.getQ4DhoraInicio().isEmpty()) {
                rotinaValida = false;
                String message = "A hora de início da observação do Arco D deve ser informada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
            }

            if (rotina.getQ4DhoraTermino() != null && rotina.getQ4DhoraTermino().isEmpty()) {
                rotinaValida = false;
                String message = "A hora de término da observação do Arco D deve ser informada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
            }

            if (!rotina.getQ4Darco().equals("semPrevisao")) {
                if (rotina.getQ8() == null || rotina.getQ8() != null && rotina.getQ8().isEmpty()) {
                    rotinaValida = false;
                    String message = "A Questão de número 8 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }else if(rotina.getQ8() != null && rotina.getQ8().equals("sim")){
                    if ((rotina.getQ13InicioAtividades() != null && rotina.getQ13InicioAtividades().isEmpty()) && (rotina.getQ13FinalAtividades() != null && rotina.getQ13FinalAtividades().isEmpty()) && !rotina.getQ13Fechado().equals("true")) {
                        rotinaValida = false;
                        String message = "A Questão de número 13 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    } else {
                        if (rotina.getQ13Fechado().equals("true")) {
                            if (!rotina.getQ13InicioAtividades().isEmpty() || !rotina.getQ13FinalAtividades().isEmpty()) {
                                rotinaValida = false;
                                String message = "O horário de início ou término do Arco D (questão 13) não podem ser informados se o Arco estiver fechado";
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                            }
                        } else {
                            if ((rotina.getQ13InicioAtividades() != null && rotina.getQ13InicioAtividades().isEmpty()) || (rotina.getQ13FinalAtividades() != null && rotina.getQ13FinalAtividades().isEmpty())) {
                                rotinaValida = false;
                                String message = "O horário de início e término do Arco D (questão 13) devem ser informados";
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                            }
                        }
                    }

                    if (rotina.getQ18() == null || rotina.getQ18() != null && rotina.getQ18().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão de número 18 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ23() == null || rotina.getQ23() != null && rotina.getQ23().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão de número 23 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if ((rotina.getQ28Educadores() != null && rotina.getQ28Educadores().isEmpty()) || (rotina.getQ28Alunos() != null && rotina.getQ28Alunos().isEmpty()) || (rotina.getQ28AlunosI() != null && rotina.getQ28AlunosI().isEmpty())) {
                        rotinaValida = false;
                        String message = "A Questão de número 28 deve ser totalmente informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ33() == null || rotina.getQ33() != null && rotina.getQ33().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão de número 33 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ38() == null || rotina.getQ38() != null && rotina.getQ38().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão de número 38 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ43() == null || rotina.getQ43() != null && rotina.getQ43().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão de número 43 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ48() == null || rotina.getQ48() != null && rotina.getQ48().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão de número 48 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ53() == null || rotina.getQ53() != null && rotina.getQ53().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão de número 53 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }
                }
            } else {
                rotina.setQ8(null);
                rotina.setQ13InicioAtividades(null);
                rotina.setQ13Fechado(null);
                rotina.setQ13InicioAtividades(null);
                rotina.setQ13FinalAtividades(null);
                rotina.setQ18(null);
                rotina.setQ23(null);
                rotina.setQ28Educadores(null);
                rotina.setQ28Alunos(null);
                rotina.setQ28AlunosI(null);
                rotina.setQ33(null);
                rotina.setQ38(null);
                rotina.setQ43(null);
                rotina.setQ48(null);
                rotina.setQ53(null);
            }
        }

        if (!rotina.getQ4Earco().equals("naoInformado")) {
            if (rotina.getQ4EdataObservacao() != null && rotina.getQ4EdataObservacao().isEmpty()) {
                rotinaValida = false;
                String message = "A data da observação do Arco E deve ser informada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
            }

            if (rotina.getQ4EhoraInicio() != null && rotina.getQ4EhoraInicio().isEmpty()) {
                rotinaValida = false;
                String message = "A hora de início da observação do Arco E deve ser informada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
            }

            if (rotina.getQ4EhoraTermino() != null && rotina.getQ4EhoraTermino().isEmpty()) {
                rotinaValida = false;
                String message = "A hora de término da observação do Arco E deve ser informada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
            }

            if (!rotina.getQ4Earco().equals("semPrevisao")) {
                if (rotina.getQ9() == null || rotina.getQ9() != null && rotina.getQ9().isEmpty()) {
                    rotinaValida = false;
                    String message = "A Questão de número 9 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }else if(rotina.getQ9() != null && rotina.getQ9().equals("sim")){
                    if ((rotina.getQ14InicioAtividades() != null && rotina.getQ14InicioAtividades().isEmpty()) && (rotina.getQ14FinalAtividades() != null && rotina.getQ14FinalAtividades().isEmpty()) && !rotina.getQ14Fechado().equals("true")) {
                        rotinaValida = false;
                        String message = "A Questão de número 14 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    } else {
                        if (rotina.getQ14Fechado().equals("true")) {
                            if (!rotina.getQ14InicioAtividades().isEmpty() || !rotina.getQ14FinalAtividades().isEmpty()) {
                                rotinaValida = false;
                                String message = "O horário de início ou término do Arco E (questão 14) não podem ser informados se o Arco estiver fechado";
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                            }
                        } else {
                            if ((rotina.getQ14InicioAtividades() != null && rotina.getQ14InicioAtividades().isEmpty()) || (rotina.getQ14FinalAtividades() != null && rotina.getQ14FinalAtividades().isEmpty())) {
                                rotinaValida = false;
                                String message = "O horário de início e término do Arco E (questão 14) devem ser informados";
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                            }
                        }
                    }

                    if (rotina.getQ19() == null || rotina.getQ19() != null && rotina.getQ19().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão de número 19 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ24() == null || rotina.getQ24() != null && rotina.getQ24().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão de número 24 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if ((rotina.getQ29Educadores() != null && rotina.getQ29Educadores().isEmpty()) || (rotina.getQ29Alunos() != null && rotina.getQ29Alunos().isEmpty()) || (rotina.getQ29AlunosI() != null && rotina.getQ29AlunosI().isEmpty())) {
                        rotinaValida = false;
                        String message = "A Questão de número 29 deve ser totalmente informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ34() == null || rotina.getQ34() != null && rotina.getQ34().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão de número 34 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ39() == null || rotina.getQ39() != null && rotina.getQ39().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão de número 39 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ44() == null || rotina.getQ44() != null && rotina.getQ44().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão de número 44 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ49() == null || rotina.getQ49() != null && rotina.getQ49().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão de número 49 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }

                    if (rotina.getQ54() == null || rotina.getQ54() != null && rotina.getQ54().isEmpty()) {
                        rotinaValida = false;
                        String message = "A Questão de número 54 deve ser informada";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }
                }
            } else {
                rotina.setQ9(null);
                rotina.setQ14InicioAtividades(null);
                rotina.setQ14Fechado(null);
                rotina.setQ14InicioAtividades(null);
                rotina.setQ14FinalAtividades(null);
                rotina.setQ19(null);
                rotina.setQ24(null);
                rotina.setQ29Educadores(null);
                rotina.setQ29Alunos(null);
                rotina.setQ29AlunosI(null);
                rotina.setQ34(null);
                rotina.setQ39(null);
                rotina.setQ44(null);
                rotina.setQ49(null);
                rotina.setQ54(null);
            }
        }

        if (((!rotina.getQ4Barco().equals("naoInformado") && !rotina.getQ4Barco().equals("semPrevisao")) && rotina.getQ4Barco().equals(rotina.getQ4Aarco())) ||
                ((!rotina.getQ4Carco().equals("naoInformado") && !rotina.getQ4Carco().equals("semPrevisao")) && (rotina.getQ4Carco().equals(rotina.getQ4Aarco()) || rotina.getQ4Carco().equals(rotina.getQ4Barco()))) ||
                ((!rotina.getQ4Darco().equals("naoInformado") && !rotina.getQ4Darco().equals("semPrevisao")) && (rotina.getQ4Darco().equals(rotina.getQ4Aarco()) || rotina.getQ4Darco().equals(rotina.getQ4Barco()) || rotina.getQ4Darco().equals(rotina.getQ4Carco()))) ||
                ((!rotina.getQ4Earco().equals("naoInformado") && !rotina.getQ4Earco().equals("semPrevisao")) && (rotina.getQ4Earco().equals(rotina.getQ4Aarco()) || rotina.getQ4Earco().equals(rotina.getQ4Barco()) || rotina.getQ4Earco().equals(rotina.getQ4Carco()) || rotina.getQ4Earco().equals(rotina.getQ4Darco())))) {
            rotinaValida = false;
            String message = "Os arcos devem ser diferentes entre si";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ55() == null || rotina.getQ55() != null && rotina.getQ55().isEmpty()) {
            rotinaValida = false;
            String message = "A Questão de número 55 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        } else {
            if (rotina.getQ55() != null && rotina.getQ55().equals("sim") && (rotina.getQ55Complemento() == null || (rotina.getQ55Complemento() != null && rotina.getQ55Complemento().isEmpty()))) {
                rotinaValida = false;
                String message = "A Questão número 55 deve ser totalmente informada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
            } else {
                rotina.setQ55Complemento(null);
            }
        }

        if (rotina.getQ56() == null || rotina.getQ56() != null && rotina.getQ56().isEmpty()) {
            rotinaValida = false;
            String message = "A Questão de número 56 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        return rotinaValida;
    }
}
