/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.rotinas.R005;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Leandro Nunes
 */
public class ValidacaoR005 {

    public static boolean validaRotina(Rotina005 rotina) {

        boolean rotinaValida = true;

        if (rotina.getIdentificaEntradaObservacao() == null || rotina.getIdentificaEntradaObservacao().isEmpty()) {
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

        if (rotina.getQ1() == null || rotina.getQ1() != null && rotina.getQ1().isEmpty()) {
            rotinaValida = false;
            String message = "A Questão número 1 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }

        if (rotina.getQ2() == null || rotina.getQ2() != null && rotina.getQ2().isEmpty()) {
            rotinaValida = false;
            String message = "A Questão número 2 deve ser informada";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        } else {
            if (rotina.getQ2() != null && rotina.getQ2().equals("sim")) {

                if (rotina.getQ3() == null || rotina.getQ3() != null && rotina.getQ3().isEmpty()) {
                    rotinaValida = false;
                    String message = "A Questão número 3 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if ((rotina.getQ4a() != null && rotina.getQ4a().isEmpty()) || (rotina.getQ4b() != null && rotina.getQ4b().isEmpty())) {
                    rotinaValida = false;
                    String message = "A Questão número 4 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ5() == null || rotina.getQ5() != null && rotina.getQ5().isEmpty()) {
                    rotinaValida = false;
                    String message = "A Questão número 5 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                } else {
                    if (rotina.getQ5().equals("0")) {
                        rotina.setQ6a(null);
                        rotina.setQ6b(null);
                        rotina.setQ6c(null);
                        rotina.setQ6d(null);
                        rotina.setQ6e(null);
                    }

                    if (rotina.getQ5().equals("1")) {
                        if ((rotina.getQ6a() == null || rotina.getQ6a() != null && rotina.getQ6a().isEmpty())||(rotina.getQ6aI() == null || rotina.getQ6aI() != null && rotina.getQ6aI().isEmpty())) {
                            rotinaValida = false;
                            String message = "A Questão número 6 deve ser completamente preenchida";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }
                        rotina.setQ6b(null);
                        rotina.setQ6c(null);
                        rotina.setQ6d(null);
                        rotina.setQ6e(null);
                    }
                    if (rotina.getQ5().equals("2")) {
                        if ((rotina.getQ6a() == null || rotina.getQ6a() != null && rotina.getQ6a().isEmpty())||(rotina.getQ6aI() == null || rotina.getQ6aI() != null && rotina.getQ6aI().isEmpty()) ||
                                (rotina.getQ6b() == null || rotina.getQ6b() != null && rotina.getQ6b().isEmpty()) || (rotina.getQ6bI() == null || rotina.getQ6bI() != null && rotina.getQ6bI().isEmpty())) {
                            rotinaValida = false;
                            String message = "A Questão número 6 deve ser completamente preenchida";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }
                        rotina.setQ6c(null);
                        rotina.setQ6d(null);
                        rotina.setQ6e(null);
                    }
                    if (rotina.getQ5().equals("3")) {
                        if ((rotina.getQ6a() == null || rotina.getQ6a() != null && rotina.getQ6a().isEmpty())||(rotina.getQ6aI() == null || rotina.getQ6aI() != null && rotina.getQ6aI().isEmpty()) ||
                                (rotina.getQ6b() == null || rotina.getQ6b() != null && rotina.getQ6b().isEmpty()) || (rotina.getQ6bI() == null || rotina.getQ6bI() != null && rotina.getQ6bI().isEmpty()) ||
                                (rotina.getQ6c() == null || rotina.getQ6c() != null && rotina.getQ6c().isEmpty()) || (rotina.getQ6cI() == null || rotina.getQ6cI() != null && rotina.getQ6cI().isEmpty())) {
                            rotinaValida = false;
                            String message = "A Questão número 6 deve ser completamente preenchida";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }
                        rotina.setQ6d(null);
                        rotina.setQ6e(null);
                    }
                    if (rotina.getQ5().equals("4")) {
                        if ((rotina.getQ6a() == null || rotina.getQ6a() != null && rotina.getQ6a().isEmpty())||(rotina.getQ6aI() == null || rotina.getQ6aI() != null && rotina.getQ6aI().isEmpty()) ||
                                (rotina.getQ6b() == null || rotina.getQ6b() != null && rotina.getQ6b().isEmpty()) || (rotina.getQ6bI() == null || rotina.getQ6bI() != null && rotina.getQ6bI().isEmpty()) ||
                                (rotina.getQ6c() == null || rotina.getQ6c() != null && rotina.getQ6c().isEmpty()) || (rotina.getQ6cI() == null || rotina.getQ6cI() != null && rotina.getQ6cI().isEmpty()) ||
                                (rotina.getQ6d() == null || rotina.getQ6d() != null && rotina.getQ6d().isEmpty()) || (rotina.getQ6dI() == null || rotina.getQ6dI() != null && rotina.getQ6dI().isEmpty())) {
                            rotinaValida = false;
                            String message = "A Questão número 6 deve ser completamente preenchida";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }
                        rotina.setQ6e(null);
                    }
                    if (rotina.getQ5().equals("5")) {
                        if ((rotina.getQ6a() == null || rotina.getQ6a() != null && rotina.getQ6a().isEmpty())||(rotina.getQ6aI() == null || rotina.getQ6aI() != null && rotina.getQ6aI().isEmpty()) ||
                                (rotina.getQ6b() == null || rotina.getQ6b() != null && rotina.getQ6b().isEmpty()) || (rotina.getQ6bI() == null || rotina.getQ6bI() != null && rotina.getQ6bI().isEmpty()) ||
                                (rotina.getQ6c() == null || rotina.getQ6c() != null && rotina.getQ6c().isEmpty()) || (rotina.getQ6cI() == null || rotina.getQ6cI() != null && rotina.getQ6cI().isEmpty()) ||
                                (rotina.getQ6d() == null || rotina.getQ6d() != null && rotina.getQ6d().isEmpty()) || (rotina.getQ6dI() == null || rotina.getQ6dI() != null && rotina.getQ6dI().isEmpty()) ||
                                (rotina.getQ6e() == null || rotina.getQ6e() != null && rotina.getQ6e().isEmpty()) || (rotina.getQ6eI() == null || rotina.getQ6eI() != null && rotina.getQ6eI().isEmpty())) {
                            rotinaValida = false;
                            String message = "A Questão número 6 deve ser completamente preenchida";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }
                    }
                }

                if (rotina.getQ7() == null || rotina.getQ7() != null && rotina.getQ7().isEmpty()) {
                    rotinaValida = false;
                    String message = "A Questão número 7 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ8a() == null || rotina.getQ8a() != null && rotina.getQ8a().isEmpty()) {
                    rotinaValida = false;
                    String message = "A Questão número 8A deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ8b() == null || rotina.getQ8b() != null && rotina.getQ8b().isEmpty()) {
                    rotinaValida = false;
                    String message = "A Questão número 8B deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ8c() == null || rotina.getQ8c() != null && rotina.getQ8c().isEmpty()) {
                    rotinaValida = false;
                    String message = "A Questão número 8C deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ8d() == null || rotina.getQ8d() != null && rotina.getQ8d().isEmpty()) {
                    rotinaValida = false;
                    String message = "A Questão número 8D deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ8e() == null || rotina.getQ8e() != null && rotina.getQ8e().isEmpty()) {
                    rotinaValida = false;
                    String message = "A Questão número 8E deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ8f() == null || rotina.getQ8f() != null && rotina.getQ8f().isEmpty()) {
                    rotinaValida = false;
                    String message = "A Questão número 8F deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ8g() == null || rotina.getQ8g() != null && rotina.getQ8g().isEmpty()) {
                    rotinaValida = false;
                    String message = "A Questão número 8G deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ9() == null || rotina.getQ9() != null && rotina.getQ9().isEmpty()) {
                    rotinaValida = false;
                    String message = "A Questão número 9 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

                if (rotina.getQ10() == null || rotina.getQ10() != null && rotina.getQ10().isEmpty()) {
                    rotinaValida = false;
                    String message = "A Questão número 10 deve ser informada";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                } else {
                    if (rotina.getQ10() != null && rotina.getQ10().equals("Sim")) {
                        if (rotina.getQ10Complemento() != null && rotina.getQ10Complemento().isEmpty()) {
                            rotinaValida = false;
                            String message = "A Questão número 10 deve ser totalmente informada";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }
                    } else {
                        rotina.setQ10Complemento(null);
                    }
                }
            } else {
                rotina.setQ3(null);
                rotina.setQ4a(null);
                rotina.setQ4b(null);
                rotina.setQ5(null);
                rotina.setQ6a(null);
                rotina.setQ6b(null);
                rotina.setQ6c(null);
                rotina.setQ6d(null);
                rotina.setQ6e(null);
                rotina.setQ7(null);
                rotina.setQ8a(null);
                rotina.setQ8b(null);
                rotina.setQ8c(null);
                rotina.setQ8d(null);
                rotina.setQ8e(null);
                rotina.setQ8f(null);
                rotina.setQ8g(null);
                rotina.setQ9(null);
                rotina.setQ10(null);
                rotina.setQ10Complemento(null);

            }
        }

        return rotinaValida;
    }
}
