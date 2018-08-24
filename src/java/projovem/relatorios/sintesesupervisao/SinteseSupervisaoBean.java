/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.relatorios.sintesesupervisao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;
import projovem.dao.NucleoDAO;
import projovem.dao.UsuarioDAO;
import projovem.entity.Usuario;
import projovem.relatorios.sintesesupervisao.vo.Rotina001SinteseSupervisaoVo;
import projovem.relatorios.sintesesupervisao.vo.Rotina002SinteseSupervisaoVo;
import projovem.relatorios.sintesesupervisao.vo.Rotina002PerfilFormadoresSinteseSupervisaoVo;
import projovem.relatorios.sintesesupervisao.vo.Rotina002PerfilEducadoresSinteseSupervisaoVo;
import projovem.relatorios.sintesesupervisao.vo.Rotina003SinteseSupervisaoVo;
import projovem.relatorios.sintesesupervisao.vo.Rotina004V2SinteseSupervisaoVo;
import projovem.relatorios.sintesesupervisao.vo.Rotina005SinteseSupervisaoVo;
import projovem.relatorios.sintesesupervisao.vo.Rotina006SinteseSupervisaoVo;
import projovem.relatorios.sintesesupervisao.vo.Rotina007SinteseSupervisaoVo;
import projovem.relatorios.sintesesupervisao.vo.CeRotina001SinteseSupervisaoVo;
import projovem.relatorios.sintesesupervisao.vo.CeRotina002SinteseSupervisaoVo;
import projovem.relatorios.sintesesupervisao.vo.CeRotina003SinteseSupervisaoVo;
import projovem.DAO.LogAcessosDAO;
import projovem.entity.LogAcessos;

/**
 *
 * @author admprojovem
 */
public class SinteseSupervisaoBean implements Serializable {

    @Resource
    private UserTransaction utx;
    @PersistenceUnit(unitName = "projovemPU")
    private EntityManagerFactory emf;
    private NucleoDAO nucleoDao = new NucleoDAO();
    private UsuarioDAO usuarioDao = new UsuarioDAO();
    private List<SelectItem> coordenacoes = new ArrayList<SelectItem>();
    private List<SelectItem> municipios = new ArrayList<SelectItem>();
    private List<SelectItem> entradas = new ArrayList<SelectItem>();
    private Usuario usuarioLogado = new Usuario();
    private String coordenacaoEscolhida;
    private String municipioEscolhida;
    private String entradaEscolhida;
    private String rotinaEscolhida;
    private String irResponsavel;
    private String observacaoEscolhida;
    private Integer listaRotina001Size;
    private Integer listaRotina002Size;
    private Integer listaRotina002PerfilFormadoresSize;
    private Integer listaRotina002PerfilEducadoresSize;
    private Integer listaRotina003Size;
    private Integer listaRotina004Size;
    private Integer listaRotina005Size;
    private Integer listaRotina006Size;
    private Integer listaRotina007Size;
    private Integer listaCeRotina001Size;
    private Integer listaCeRotina002Size;
    private Integer listaCeRotina003Size;
    private Rotina001SinteseSupervisaoVo contagem001;
    private Rotina002SinteseSupervisaoVo contagem002;
    private Rotina002PerfilFormadoresSinteseSupervisaoVo contagem002PerfilFormadores;
    private Rotina002PerfilEducadoresSinteseSupervisaoVo contagem002PerfilEducadores;
    private Rotina003SinteseSupervisaoVo contagem003;
    private Rotina004V2SinteseSupervisaoVo contagem004;
    private Rotina005SinteseSupervisaoVo contagem005;
    private Rotina006SinteseSupervisaoVo contagem006;
    private Rotina007SinteseSupervisaoVo contagem007;
    private CeRotina001SinteseSupervisaoVo contagemCe001;
    private CeRotina002SinteseSupervisaoVo contagemCe002;
    private CeRotina003SinteseSupervisaoVo contagemCe003;
    private boolean renderedCoordenacoes;
    private boolean renderedMunicipios;
    private boolean renderedBotaoGerar;
    private boolean renderedRotinas;
    private boolean disableCoordenacao;
    private boolean disableMunicipios;
    private boolean renderedLinkCaed;
    private boolean renderedObservacao;
    private boolean disableObservacao;
    private String linkCaed;
    private String dataAtual;
    private LogAcessosDAO logAcessosDAO = new LogAcessosDAO();

    public SinteseSupervisaoBean() {
        usuarioLogado = usuarioDao.getUsuarioLogado();
    }

    public void liberarBotao() {
        renderedLinkCaed = false;
        renderedBotaoGerar = true;
    }

    public void obtemCoordenacoes() {
        renderedLinkCaed = false;
        setRenderedCoordenacoes(true);
        coordenacoes.clear();
        List<String> coordenacoesPossiveis = new ArrayList<String>();
        if (usuarioLogado.getPerfil().equals("1")) {
            coordenacoesPossiveis = nucleoDao.obtemCoordenacoesByEntrada(getEntradaEscolhida(), emf);
            for (String coordenacao : coordenacoesPossiveis) {
                coordenacoes.add(new SelectItem(coordenacao, coordenacao));
            }
            //disableCoordenacao = false;
        } else {
            if (usuarioLogado.getPerfil().equals("2")) {
                coordenacoes = nucleoDao.obtemCoordenacoesByIR(usuarioLogado.getIr(), emf);

            } else {

                coordenacoes.add(new SelectItem(usuarioLogado.getCordenacao(), usuarioLogado.getCordenacao()));
                setCoordenacaoEscolhida(usuarioLogado.getCordenacao());
                setRenderedRotinas(true);
            }

            //setDisableCoordenacao(true);
        }

    }
    public void obtemMunicipios() {
        renderedLinkCaed = false;
        setRenderedMunicipios(true);
        getMunicipios().clear();
        municipios = nucleoDao.obtemMunicipiosByCoordenacaoAndEntrada(entradaEscolhida, coordenacaoEscolhida, emf);
    }

    public void obtemRotinas() {
        renderedLinkCaed = false;
        renderedRotinas = true;
    }

    public void obtemObservacoes() {
        renderedLinkCaed = false;
        if(getRotinaEscolhida().equals("1") || getRotinaEscolhida().equals("2")|| getRotinaEscolhida().equals("21")|| getRotinaEscolhida().equals("22")|| getRotinaEscolhida().equals("3")|| getRotinaEscolhida().equals("CE2")){
            setObservacaoEscolhida("0");
            setDisableObservacao(true);
            liberarBotao();
        }
        renderedObservacao = true;
    }

    public String gerarRelatorio() {
        String retorno = "";

        //temos de generalizar essa ação, criando uma função para armazenar esses logs. Então poderemos logar outras ações no site
        Locale locale = new Locale("pt", "BR");
        GregorianCalendar calendar = new GregorianCalendar();
        SimpleDateFormat formatador = new SimpleDateFormat("dd'/'MM'/'yyyy' - 'HH':'mm'h'", locale);
        setDataAtual(formatador.format(calendar.getTime()));
        LogAcessos logAcessos = new LogAcessos();
        logAcessos.setAcao("Relatório Síntese - "+rotinaEscolhida);
        logAcessos.setDataAcesso(getDataAtual());
        logAcessos.setPagina("Relatório Síntese de Supervisão");
        logAcessos.setUsuario(usuarioLogado);
        getLogAcessosDAO().saveLogAcesso(logAcessos, emf, utx);

        if (rotinaEscolhida.equals("1")) {
            SinteseSupervisaoRotina001 rotina001 = new SinteseSupervisaoRotina001();
            contagem001 = rotina001.gerarRelatorio(coordenacaoEscolhida, entradaEscolhida, municipioEscolhida, emf);
            if (getContagem001().getListaRotina001().size() > 0) {
                irResponsavel = contagem001.getListaRotina001().get(0).getUsuario().getIr();
                irResponsavel = getIrResponsavel();
                retorno = "relatorioSinteseSupervisaoRotina001";
            } else {
                if (coordenacaoEscolhida.equals("Coordenação Estadual de Goiás")) {
                    String message = "A instituição responsável à época, setembro de 2008 a abril de 2009," +
                            "pelas ações de observação da implementação (supervisão) não realizou as atividades previstas.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                } else {

                    if (entradaEscolhida.equals("1") || entradaEscolhida.equals("2") || entradaEscolhida.equals("3")) {

                        if (entradaEscolhida.equals("1")) {

                            String arquivo = "";
                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Ananindeua")) {
                                arquivo = "RotinaObservacaodaMatriculaCMCAnanindeuaEntrada1Ciclo1.pdf";
                            }
                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Belém")) {
                                arquivo = "RotinaObservacaodaMatriculaCMBelemEntrada1Ciclo1.pdf";
                            }
                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Campo Grande")) {
                                arquivo = "RotinaObservacaodaMatriculaCMCampoGrandeEntrada1Ciclo1.pdf";
                            }
                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Carapicuíba")) {
                                arquivo = "RotinaObservacaodaMatriculaCMCarapicuibaEntrada1Ciclo1.pdf";
                            }
                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Caucaia")) {
                                arquivo = "RotinaObservacaodaMatriculaCMCaucaiaEntrada1Ciclo1.pdf";
                            }
                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Curitiba")) {
                                arquivo = "RotinaObservacaodaMatriculaCMCuritibaEntrada1Ciclo1.pdf";
                            }
                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Diadema")) {
                                arquivo = "RotinaObservacaodaMatriculaCMDiademaEntrada1Ciclo1.pdf";
                            }
                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Fortaleza")) {
                                arquivo = "RotinaObservacaodaMatriculaCMFortalezaEntrada1Ciclo1.pdf";
                            }
                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Guarulhos")) {
                                arquivo = "RotinaObservacaodaMatriculaCMGuarulhosEntrada1Ciclo1.pdf";
                            }
                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Itaquaquecetuba")) {
                                arquivo = "RotinaObservacaodaMatriculaCMItaquaquecetubaEntrada1Ciclo1.pdf";
                            }
                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Jaboatão dos Guararapes")) {
                                arquivo = "RotinaObservacaodaMatriculaCMJaboataodosGuararapesEntrada1Ciclo1.pdf";
                            }
                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Juazeiro")) {
                                arquivo = "RotinaObservacaodaMatriculaCMJuazeiroEntrada1Ciclo1.pdf";
                            }
                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Macapá")) {
                                arquivo = "RotinaObservacaodaMatriculaCMMacapaEntrada1Ciclo1.pdf";
                            }
                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Nova Iguaçu")) {
                                arquivo = "RotinaObservacaodaMatriculaCMNovaIguacuEntrada1Ciclo1.pdf";
                            }
                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Osasco")) {
                                arquivo = "RotinaObservacaodaMatriculaCMOsascoEntrada1Ciclo1.pdf";
                            }

                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Recife")) {
                                arquivo = "RotinaObservacaodaMatriculaCMRecifeEntrada1Ciclo1.pdf";
                            }
                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Rio de Janeiro")) {
                                arquivo = "RotinaObservacaodaMatriculaCMRiodeJaneiroEntrada1Ciclo1.pdf";
                            }
                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Salvador")) {
                                arquivo = "RotinaObservacaodaMatriculaCMSalvadorentrada1Ciclo1.pdf";
                            }
                            if (coordenacaoEscolhida.equals("Coordenação Municipal de São Vicente")) {
                                arquivo = "RotinaObservacaodaMatriculaCMSaoVicenteEntrada1Ciclo1.pdf";
                            }
                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Vitória da Conquista")) {
                                arquivo = "RotinaObservacaodaMatriculaCMVitoriadaConquistaEntrada1Ciclo1.pdf";
                            }
                            if (arquivo.equals("")) {
                                String message = "O registro das informações referentes a este instrumento de observação foi efetuado" +
                                        " no endereço www.caed.ufjf.br";
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                            } else {
                                String message = "O registro das informações referentes a este instrumento de observação foi efetuado" +
                                        " no endereço www.caed.ufjf.br \n" +
                                        " Clique no link abaixo para fazer o download.";
                                linkCaed = "http://projovem.fae.ufmg.br/projovem/caed/" + arquivo;
                                renderedLinkCaed = true;
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                            }
                        } else {
                            if (entradaEscolhida.equals("2")) {

                                String arquivo = "";
                                if (coordenacaoEscolhida.equals("Coordenação Municipal de Aparecida de Goiânia")) {
                                    arquivo = "RotinadeObservacaodeMatriculaCMAparecidadeGoianiaEntrada2Ciclo1.pdf";
                                }
                                if (coordenacaoEscolhida.equals("Coordenação Municipal de Magé")) {
                                    arquivo = "RotinadeObservacaodeMatriculaCMAparecidadeMageEntrada2Ciclo1.pdf";
                                }
                                if (coordenacaoEscolhida.equals("Coordenação Municipal de Belford Roxo")) {
                                    arquivo = "RotinadeObservacaodeMatriculaCMBelforRoxoEntrada2Ciclo1.pdf";
                                }
                                if (coordenacaoEscolhida.equals("Coordenação Municipal de Embu")) {
                                    arquivo = "RotinadeObservacaodeMatriculaCMEmbuEntrada2Ciclo1.pdf";
                                }
                                if (coordenacaoEscolhida.equals("Coordenação Municipal de Florianópolis")) {
                                    arquivo = "RotinadeObservacaodeMatriculaCMFlorianopolisEntrada2Ciclo1.pdf";
                                }
                                if (coordenacaoEscolhida.equals("Coordenação Municipal de Niterói")) {
                                    arquivo = "RotinadeObservacaodeMatriculaCMNiteroiEntrada2Ciclo1.pdf";
                                }
                                if (coordenacaoEscolhida.equals("Coordenação Municipal de São Gonçalo")) {
                                    arquivo = "RotinadeObservacaodeMatriculaCMSaoGoncaloEntrada2Ciclo1.pdf";
                                }
                                if (arquivo.equals("")) {
                                    String message = "O registro das informações referentes a este instrumento de observação foi efetuado" +
                                            " no endereço www.caed.ufjf.br";
                                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                                } else {
                                    String message = "O registro das informações referentes a este instrumento de observação foi efetuado" +
                                            " no endereço www.caed.ufjf.br \n" +
                                            " Clique no link abaixo para fazer o download.";
                                    linkCaed = "http://projovem.fae.ufmg.br/projovem/caed/" + arquivo;
                                    renderedLinkCaed = true;
                                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                                }

                            } else {
                                String message = "O registro das informações referentes a este instrumento de observação foi efetuado" +
                                        " no endereço www.caed.ufjf.br";
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                            }
                        }
                    } else {
                        String message = "Não existem dados para estes filtros.";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }
                }
            }
        }
        if (rotinaEscolhida.equals("2")) {
            SinteseSupervisaoRotina002 rotina002 = new SinteseSupervisaoRotina002();
            contagem002 = rotina002.gerarRelatorio(coordenacaoEscolhida, entradaEscolhida, municipioEscolhida, emf);
            if (getContagem002().getListaRotina002().size() > 0) {
                irResponsavel = contagem002.getListaRotina002().get(0).getUsuario().getIr();
                irResponsavel = getIrResponsavel();
                retorno = "relatorioSinteseSupervisaoRotina002";
            } else {
                if (coordenacaoEscolhida.equals("Coordenação Estadual de Goiás")) {
                    String message = "A instituição responsável à época, setembro de 2008 a abril de 2009," +
                            "pelas ações de observação da implementação (supervisão) não realizou as atividades previstas.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                } else {
                    if (entradaEscolhida.equals("1") || entradaEscolhida.equals("2") || entradaEscolhida.equals("3")) {

                        if (entradaEscolhida.equals("1")) {

                            String arquivo = "";
                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Ananindeua")) {
                                arquivo = "RotinadeObservacaodaFormacaoInicialCMAnanindeuaEntrada1Ciclo1.pdf";
                            }
                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Belém")) {
                                arquivo = "RotinadeObservacaodaFormacaoInicialCMBelemEntrada1Ciclo1.pdf";
                            }
                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Campo Grande")) {
                                arquivo = "RotinadeObservacaodaFormacaoInicialCMCampoGrandeEntrada1Ciclo1.pdf";
                            }
                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Carapicuíba")) {
                                arquivo = "RotinadeObservacaodaFormacaoInicialCMCarapicuibaEntrada1Ciclo1.pdf";
                            }
                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Caucaia")) {
                                arquivo = "RotinadeObservacaodaFormacaoInicialCMCaucaiaEntrada1Ciclo1.pdf";
                            }

                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Diadema")) {
                                arquivo = "RotinadeObservacaodaFormacaoInicialCMDiademaEntrada1Ciclo1.pdf";
                            }
                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Fortaleza")) {
                                arquivo = "RotinadeObservacaodaFormacaoInicialCMFortalezaEntrada1Ciclo1.pdf";
                            }
                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Guarulhos")) {
                                arquivo = "RotinadeObservacaodaFormacaoInicialCMGuarulhosEntrada1Ciclo1.pdf";
                            }

                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Itaquaquecetuba")) {
                                arquivo = "RotinadeObservacaodaFormacaoInicialCMItaquaquecetubaEntrada1Ciclo1.pdf";
                            }
                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Jaboatão dos Guararapes")) {
                                arquivo = "RotinadeObservacaodaFormacaoInicialCMJaboataodosGuararapesEntrada1Ciclo1.pdf";
                            }
                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Juazeiro")) {
                                arquivo = "RotinadeObservacaodaFormacaoInicialCMJuazeiroEntrada1Ciclo1.pdf";
                            }
                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Macapá")) {
                                arquivo = "RotinadeObservacaodaFormacaoInicialCMMacapaEntrada1Ciclo1.pdf";
                            }
                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Olinda")) {
                                arquivo = "RotinadeObservacaodaFormacaoInicialCMOlindaEntrada1Ciclo1.pdf";
                            }
                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Osasco")) {
                                arquivo = "RotinadeObservacaodaFormacaoInicialCMOsascoEntrada1Ciclo1.pdf";
                            }
                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Paulista")) {
                                arquivo = "RotinadeObservacaodaFormacaoInicialCMPaulistaEntrada1Ciclo1.pdf";
                            }

                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Rio de Janeiro")) {
                                arquivo = "RotinadeObservacaodaFormacaoInicialCMRiodeJaneiroEntrada1Ciclo1.pdf";
                            }
                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Salvador")) {
                                arquivo = "RotinadeObservacaodaFormacaoInicialCMSalvadorEntrada1Ciclo1.pdf";
                            }
                            if (coordenacaoEscolhida.equals("Coordenação Municipal de São Vicente")) {
                                arquivo = "RotinadeObservacaodaFormacaoInicialCMSaoVicenteEntrada1Ciclo1.pdf";
                            }
                            if (coordenacaoEscolhida.equals("Coordenação Municipal de Vitória da Conquista")) {
                                arquivo = "RotinadeObservacaodaFormacaoInicialCMVitoriadaConquistaEntrada1Ciclo1.pdf";
                            }
                            if (arquivo.equals("")) {
                                String message = "O registro das informações referentes a este instrumento de observação foi efetuado" +
                                        " no endereço www.caed.ufjf.br";
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                            } else {
                                String message = "O registro das informações referentes a este instrumento de observação foi efetuado" +
                                        " no endereço www.caed.ufjf.br \n" +
                                        " Clique no link abaixo para fazer o download.";
                                linkCaed = "http://projovem.fae.ufmg.br/projovem/caed/" + arquivo;
                                renderedLinkCaed = true;
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                            }
                        } else {
                            String message = "O registro das informações referentes a este instrumento de observação foi efetuado" +
                                    " no endereço www.caed.ufjf.br";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                        }
                    } else {
                        String message = "Não existem dados para estes filtros.";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }
                }
            }
        }//retorno = "relatorioSinteseSupervisaoRotina002";
        if (rotinaEscolhida.equals("21")) {
            SinteseSupervisaoRotina002PerfilFormadores rotina002PerfilFormadores = new SinteseSupervisaoRotina002PerfilFormadores();
            setContagem002PerfilFormadores(rotina002PerfilFormadores.gerarRelatorio(coordenacaoEscolhida, entradaEscolhida, municipioEscolhida, emf));
            if (getContagem002PerfilFormadores().getListaRotina002PerfilFormadores().size() > 0) {
                irResponsavel = contagem002PerfilFormadores.getListaRotina002PerfilFormadores().get(0).getUsuario().getIr();
                irResponsavel = getIrResponsavel();
                retorno = "relatorioSinteseSupervisaoRotina002PerfilFormadores";
            } else {
                if (coordenacaoEscolhida.equals("Coordenação Estadual de Goiás")) {
                    String message = "A instituição responsável à época, setembro de 2008 a abril de 2009," +
                            "pelas ações de observação da implementação (supervisão) não realizou as atividades previstas.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                } else {
                    if (entradaEscolhida.equals("1") || entradaEscolhida.equals("2") || entradaEscolhida.equals("3")) {
                        String message = "O registro das informações referentes a este instrumento de observação foi efetuado" +
                                " no endereço www.caed.ufjf.br";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    } else {
                        String message = "Não existem dados para estes filtros.";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }
                }
            }
        }//retorno = "relatorioSinteseSupervisaoRotina002PerfilFormadores";
        if (rotinaEscolhida.equals("22")) {
            SinteseSupervisaoRotina002PerfilEducadores rotina002PerfilEducadores = new SinteseSupervisaoRotina002PerfilEducadores();
            setContagem002PerfilEducadores(rotina002PerfilEducadores.gerarRelatorio(coordenacaoEscolhida, entradaEscolhida, municipioEscolhida, emf));
            if (getContagem002PerfilEducadores().getListaRotina002PerfilEducadores().size() > 0) {
                irResponsavel = contagem002PerfilEducadores.getListaRotina002PerfilEducadores().get(0).getUsuario().getIr();
                irResponsavel = getIrResponsavel();
                retorno = "relatorioSinteseSupervisaoRotina002PerfilEducadores";
            } else {
                if (coordenacaoEscolhida.equals("Coordenação Estadual de Goiás")) {
                    String message = "A instituição responsável à época, setembro de 2008 a abril de 2009," +
                            "pelas ações de observação da implementação (supervisão) não realizou as atividades previstas.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                } else {
                    if (entradaEscolhida.equals("1") || entradaEscolhida.equals("2") || entradaEscolhida.equals("3")) {
                        String message = "O registro das informações referentes a este instrumento de observação foi efetuado" +
                                " no endereço www.caed.ufjf.br";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    } else {
                        String message = "Não existem dados para estes filtros.";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }
                }
            }
        } //retorno = "relatorioSinteseSupervisaoRotina002PerfilEducadores";
        if (rotinaEscolhida.equals("3")) {
            SinteseSupervisaoRotina003 rotina003 = new SinteseSupervisaoRotina003();

            contagem003 = rotina003.gerarRelatorio(coordenacaoEscolhida, entradaEscolhida, municipioEscolhida, emf);
            if (getContagem003().getListaRotina003().size() > 0) {
                irResponsavel = contagem003.getListaRotina003().get(0).getUsuario().getIr();
                irResponsavel = getIrResponsavel();
                retorno = "relatorioSinteseSupervisaoRotina003";
            } else {
                if (coordenacaoEscolhida.equals("Coordenação Estadual de Goiás")) {
                    String message = "A instituição responsável à época, setembro de 2008 a abril de 2009," +
                            "pelas ações de observação da implementação (supervisão) não realizou as atividades previstas.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                } else {
                    if (entradaEscolhida.equals("1") || entradaEscolhida.equals("2")) {
                        String message = "O registro das informações referentes a este instrumento de observação foi efetuado" +
                                " no endereço www.caed.ufjf.br";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    } else {
                        String message = "Não existem dados para estes filtros.";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }
                }
            }
        }
        if (rotinaEscolhida.equals("4")) {
            SinteseSupervisaoRotina004 rotina004 = new SinteseSupervisaoRotina004();
            contagem004 = rotina004.gerarRelatorio(coordenacaoEscolhida, entradaEscolhida, observacaoEscolhida, municipioEscolhida, emf);
            if (getContagem004().getListaRotina004() != null && getContagem004().getListaRotina004().size() > 0) {
                irResponsavel = contagem004.getListaRotina004().get(0).getNucleo().getIr();
                retorno = "relatorioSinteseSupervisaoRotina004";
            } else {
                if (entradaEscolhida.equals("1")) {

                    String arquivo = "";
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Ananindeua")) {
                        arquivo = "RotinadeSupervisaodasCondicoesdeOfertaCMAnanindeuaEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Belém")) {
                        arquivo = "RotinadeSupervisaodasCondicoesdeOfertaCMBelemEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Carapicuíba")) {
                        arquivo = "RotinadeSupervisaodasCondicoesdeOfertaCMCarapicuibaEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Caucaia")) {
                        arquivo = "RotinadeSupervisaodasCondicoesdeOfertaCMCaucaiaEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Curitiba")) {
                        arquivo = "RotinadeSupervisaodasCondicoesdeOfertaCMCuritibaEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Diadema")) {
                        arquivo = "RotinadeSupervisaodasCondicoesdeOfertaCMDiademaEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Fortaleza")) {
                        arquivo = "RotinadeSupervisaodasCondicoesdeOfertaCMFortalezaEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Guarulhos")) {
                        arquivo = "RotinadeSupervisaodasCondicoesdeOfertaCMGuarulhosEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Imperatriz")) {
                        arquivo = "RotinadeSupervisaodasCondicoesdeOfertaCMImperatrizEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Itaboraí")) {
                        arquivo = "RotinadeSupervisaodasCondicoesdeOfertaCMItaboraiEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Itaquaquecetuba")) {
                        arquivo = "RotinadeSupervisaodasCondicoesdeOfertaCMItaquaquecetubaEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Jaboatão dos Guararapes")) {
                        arquivo = "RotinadeSupervisaodasCondicoesdeOfertaCMJaboataodosGuararapesEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Juazeiro")) {
                        arquivo = "RotinadeSupervisaodasCondicoesdeOfertaCMJuazeiroEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Macapá")) {
                        arquivo = "RotinadeSupervisaodasCondicoesdeOfertaCMMacapaEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Nova Iguaçu")) {
                        arquivo = "RotinadeSupervisaodasCondicoesdeOfertaCMNovaIguacuEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Osasco")) {
                        arquivo = "RotinadeSupervisaodasCondicoesdeOfertaCMOsascoEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Paulista")) {
                        arquivo = "RotinadeSupervisaodasCondicoesdeOfertaCMPaulistaEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Recife")) {
                        arquivo = "RotinadeSupervisaodasCondicoesdeOfertaCMRecifeEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Rio de Janeiro")) {
                        arquivo = "RotinadeSupervisaodasCondicoesdeOfertaCMRiodeJaneiroEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Salvador")) {
                        arquivo = "RotinadeSupervisaodasCondicoesdeOfertaCMSalvadorEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de São Vicente")) {
                        arquivo = "RotinadeSupervisaodasCondicoesdeOfertaCMSaoVicenteEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Vitória da Conquista")) {
                        arquivo = "RotinadeSupervisaodasCondicoesdeOfertaCMVitoriadaConquistaEntrada1Ciclo1.pdf";
                    }
                    if (arquivo.equals("")) {
                        String message = "O registro das informações referentes a este instrumento de observação foi efetuado" +
                                " no endereço www.caed.ufjf.br";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    } else {
                        String message = "O registro das informações referentes a este instrumento de observação foi efetuado" +
                                " no endereço www.caed.ufjf.br \n" +
                                " Clique no link abaixo para fazer o download.";
                        linkCaed = "http://projovem.fae.ufmg.br/projovem/caed/" + arquivo;
                        renderedLinkCaed = true;
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }
                } else {

                    String message = "Não existem dados para estes filtros.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
            }
        }
        if (rotinaEscolhida.equals("5")) {
            SinteseSupervisaoRotina005 rotina005 = new SinteseSupervisaoRotina005();
            setContagem005(rotina005.gerarRelatorio(coordenacaoEscolhida, entradaEscolhida, observacaoEscolhida, municipioEscolhida, emf));
            if (getContagem005().getListaRotina005() != null && getContagem005().getListaRotina005().size() > 0) {
                irResponsavel = getContagem005().getListaRotina005().get(0).getNucleo().getIr();
                retorno = "relatorioSinteseSupervisaoRotina005";
            } else {

                if (entradaEscolhida.equals("1")) {

                    String arquivo = "";
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Ananindeua")) {
                        arquivo = "RotinadeObservacaodaFrequenciaCMAnanindeuaEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Belém")) {
                        arquivo = "RotinadeObservacaodaFrequenciaCMBelemEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Carapicuíba")) {
                        arquivo = "RotinadeObservacaodaFrequenciaCMCarapicuibaEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Curitiba")) {
                        arquivo = "RotinadeObservacaodaFrequenciaCMCuritibaEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Diadema")) {
                        arquivo = "RotinadeObservacaodaFrequenciaCMDiademaEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Guarulhos")) {
                        arquivo = "RotinadeObservacaodaFrequenciaCMGuarulhosEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Imperatriz")) {
                        arquivo = "RotinadeObservacaodaFrequenciaCMImperatrizEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Itaquaquecetuba")) {
                        arquivo = "RotinadeObservacaodaFrequenciaCMItaquaquecetubaEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Jaboatão dos Guararapes")) {
                        arquivo = "RotinadeObservacaodaFrequenciaCMJaboataodosGuararapesEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Juazeiro")) {
                        arquivo = "RotinadeObservacaodaFrequenciaCMJuazeiroEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Osasco")) {
                        arquivo = "RotinadeObservacaodaFrequenciaCMOsascoEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Recife")) {
                        arquivo = "RotinadeObservacaodaFrequenciaCMRecifeEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Salvador")) {
                        arquivo = "RotinadeObservacaodaFrequenciaCMSalvadorEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de São Vicente")) {
                        arquivo = "RotinadeObservacaodaFrequenciaCMSaoVicenteEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Vitória da Conquista")) {
                        arquivo = "RotinadeObservacaodaFrequenciaCMVitoriadaConquistaEntrada1Ciclo1.pdf";
                    }
                    if (arquivo.equals("")) {
                        String message = "O registro das informações referentes a este instrumento de observação foi efetuado" +
                                " no endereço www.caed.ufjf.br";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    } else {
                        String message = "O registro das informações referentes a este instrumento de observação foi efetuado" +
                                " no endereço www.caed.ufjf.br \n" +
                                " Clique no link abaixo para fazer o download.";
                        linkCaed = "http://projovem.fae.ufmg.br/projovem/caed/" + arquivo;
                        renderedLinkCaed = true;
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }
                } else {
                    String message = "Não existem dados para estes filtros.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }

            }

        }
        if (rotinaEscolhida.equals("6")) {
            SinteseSupervisaoRotina006 rotina006 = new SinteseSupervisaoRotina006();

            contagem006 = rotina006.gerarRelatorio(coordenacaoEscolhida, entradaEscolhida, observacaoEscolhida, municipioEscolhida, emf);
            if (getContagem006().getListaRotina006() != null && getContagem006().getListaRotina006().size() > 0) {
                irResponsavel = contagem006.getListaRotina006().get(0).getUsuario().getIr();
                irResponsavel = getIrResponsavel();
                retorno = "relatorioSinteseSupervisaoRotina006";
            } else {
                if (entradaEscolhida.equals("1")) {

                    String arquivo = "";
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Ananindeua")) {
                        arquivo = "RotinadeQualificacaoProfissionalCMAnanindeuaEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Belém")) {
                        arquivo = "RotinadeQualificacaoProfissionalCMBelemEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Carapicuíba")) {
                        arquivo = "RotinadeQualificacaoProfissionalCMCarapicuibaEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Curitiba")) {
                        arquivo = "RotinadeQualificacaoProfissionalCMCuritibaEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Diadema")) {
                        arquivo = "RotinadeQualificacaoProfissionalCMDiademaEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Guarulhos")) {
                        arquivo = "RotinadeQualificacaoProfissionalCMGuarulhosEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Imperatriz")) {
                        arquivo = "RotinadeQualificacaoProfissionalCMImperatrizEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Itaquaquecetuba")) {
                        arquivo = "RotinadeQualificacaoProfissionalCMItaquaquecetubaEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Jaboatão dos Guararapes")) {
                        arquivo = "RotinadeQualificacaoProfissionalCMJaboataodosGuararapesEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Juazeiro")) {
                        arquivo = "RotinadeQualificacaoProfissionalCMJuazeiroEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Osasco")) {
                        arquivo = "RotinadeQualificacaoProfissionalCMOsascoEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Recife")) {
                        arquivo = "RotinadeQualificacaoProfissionalCMRecifeEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Salvador")) {
                        arquivo = "RotinadeQualificacaoProfissionalCMSalvadorEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de São Vicente")) {
                        arquivo = "RotinadeQualificacaoProfissionalCMSaoVicenteEntrada1Ciclo1.pdf";
                    }
                    if (coordenacaoEscolhida.equals("Coordenação Municipal de Vitória da Conquista")) {
                        arquivo = "RotinadeQualificacaoProfissionalCMVitoriadaConquistaEntrada1Ciclo1.pdf";
                    }
                    String message = "O registro das informações referentes a este instrumento de observação foi efetuado" +
                            " no endereço www.caed.ufjf.br \n" +
                            " Clique no link abaixo para fazer o download.";
                    linkCaed = "http://projovem.fae.ufmg.br/projovem/caed/" + arquivo;
                    renderedLinkCaed = true;
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                } else {
                    String message = "Não existem dados para estes filtros.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                }
            }
        }
        if (rotinaEscolhida.equals("7")) {
            SinteseSupervisaoRotina007 rotina007 = new SinteseSupervisaoRotina007();
            contagem007 = rotina007.gerarRelatorio(coordenacaoEscolhida, entradaEscolhida, observacaoEscolhida, municipioEscolhida, emf);
            if (getContagem007().getListaRotina007().size() > 0) {
                irResponsavel = contagem007.getListaRotina007().get(0).getUsuario().getIr();
                irResponsavel = getIrResponsavel();
                retorno = "relatorioSinteseSupervisaoRotina007";
            } else {
                String message = "Não existem dados para estes filtros.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
            }
            //retorno = "relatorioSinteseSupervisaoRotina007";
            }
        if (rotinaEscolhida.equals("CE1")) {
            SinteseSupervisaoCeRotina001 ceRotina001 = new SinteseSupervisaoCeRotina001();
            setContagemCe001(ceRotina001.gerarRelatorio(coordenacaoEscolhida, entradaEscolhida, observacaoEscolhida, municipioEscolhida, emf));
            if (getContagemCe001().getListaCeRotina001().size() > 0) {
                irResponsavel = contagemCe001.getListaCeRotina001().get(0).getUsuario().getIr();
                irResponsavel = getIrResponsavel();
                retorno = "relatorioSinteseSupervisaoCeRotina001";
            } else {
                String message = "Não existem dados para estes filtros.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
            }
        }
        if (rotinaEscolhida.equals("CE2")) {
            SinteseSupervisaoCeRotina002 ceRotina002 = new SinteseSupervisaoCeRotina002();
            setContagemCe002(ceRotina002.gerarRelatorio(coordenacaoEscolhida, entradaEscolhida, municipioEscolhida, emf));
            if (getContagemCe002().getListaCeRotina002().size() > 0) {
                irResponsavel = contagemCe002.getListaCeRotina002().get(0).getUsuario().getIr();
                irResponsavel = getIrResponsavel();
                retorno = "relatorioSinteseSupervisaoCeRotina002";
            } else {
                String message = "Não existem dados para estes filtros.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
            }
        }
        if (rotinaEscolhida.equals("CE3")) {
            SinteseSupervisaoCeRotina003 ceRotina003 = new SinteseSupervisaoCeRotina003();
            setContagemCe003(ceRotina003.gerarRelatorio(coordenacaoEscolhida, entradaEscolhida, observacaoEscolhida, municipioEscolhida, emf));
            if (getContagemCe003().getListaCeRotina003().size() > 0) {
                irResponsavel = contagemCe003.getListaCeRotina003().get(0).getUsuario().getIr();
                irResponsavel = getIrResponsavel();
                retorno = "relatorioSinteseSupervisaoCeRotina003";
            } else {
                String message = "Não existem dados para estes filtros.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
            }
        }
        return retorno;
    }

    /**
     * @return the coordenacoes
     */
    public List<SelectItem> getCoordenacoes() {

        return coordenacoes;
    }

    /**
     * @param coordenacoes the coordenacoes to set
     */
    public void setCoordenacoes(List<SelectItem> coordenacoes) {
        this.coordenacoes = coordenacoes;
    }

    /**
     * @return the coordenacaoEscolhida
     */
    public String getCoordenacaoEscolhida() {
        return coordenacaoEscolhida;
    }

    /**
     * @param coordenacaoEscolhida the coordenacaoEscolhida to set
     */
    public void setCoordenacaoEscolhida(String coordenacaoEscolhida) {
        this.coordenacaoEscolhida = coordenacaoEscolhida;
    }

    /**
     * @return the entradas
     */
    public List<SelectItem> getEntradas() {
        if (entradas != null && entradas.size() == 0) {
            List<String> entradasPossiveis = new ArrayList<String>();
            entradasPossiveis =
                    nucleoDao.obtemEntradas(emf);
            for (String entrada : entradasPossiveis) {
                entradas.add(new SelectItem(entrada, entrada));
            }

        }
        return entradas;
    }

    /**
     * @param entradas the entradas to set
     */
    public void setEntradas(List<SelectItem> entradas) {
        this.entradas = entradas;
    }

    /**
     * @return the renderedCoordenacoes
     */
    public boolean isRenderedCoordenacoes() {
        return renderedCoordenacoes;
    }

    /**
     * @param renderedCoordenacoes the renderedCoordenacoes to set
     */
    public void setRenderedCoordenacoes(boolean renderedCoordenacoes) {
        this.renderedCoordenacoes = renderedCoordenacoes;
    }

    /**
     * @return the entradaEscolhida
     */
    public String getEntradaEscolhida() {
        return entradaEscolhida;
    }

    /**
     * @param entradaEscolhida the entradaEscolhida to set
     */
    public void setEntradaEscolhida(String entradaEscolhida) {
        this.entradaEscolhida = entradaEscolhida;
    }

    /**
     * @return the rotinaEscolhida
     */
    public String getRotinaEscolhida() {
        return rotinaEscolhida;
    }

    /**
     * @param rotinaEscolhida the rotinaEscolhida to set
     */
    public void setRotinaEscolhida(String rotinaEscolhida) {
        this.rotinaEscolhida = rotinaEscolhida;
    }

    public Rotina006SinteseSupervisaoVo getContagem006() {
        return contagem006;
    }

    public void setContagem006(Rotina006SinteseSupervisaoVo contagem006) {
        this.contagem006 = contagem006;
    }

    public Rotina005SinteseSupervisaoVo getContagem005() {
        return contagem005;
    }

    public void setContagem005(Rotina005SinteseSupervisaoVo contagem005) {
        this.contagem005 = contagem005;
    }

    /**
     * @return the listaRotina005Size
     */
    public Integer getListaRotina005Size() {
        return getContagem005().getListaRotina005().size();
    }

    /**
     * @param listaRotina005Size the listaRotina005Size to set
     */
    public void setListaRotina005Size(Integer listaRotina005Size) {
        this.listaRotina005Size = listaRotina005Size;
    }

    /**
     * @return the renderedBotaoGerar
     */
    public boolean isRenderedBotaoGerar() {
        return renderedBotaoGerar;
    }

    /**
     * @param renderedBotaoGerar the renderedBotaoGerar to set
     */
    public void setRenderedBotaoGerar(boolean renderedBotaoGerar) {
        this.renderedBotaoGerar = renderedBotaoGerar;
    }

    /**
     * @return the contagem004
     */
    public Rotina004V2SinteseSupervisaoVo getContagem004() {
        return contagem004;
    }

    /**
     * @param contagem004 the contagem004 to set
     */
    public void setContagem004(Rotina004V2SinteseSupervisaoVo contagem004) {
        this.contagem004 = contagem004;
    }

    /**
     * @return the listaRotina004Size
     */
    public Integer getListaRotina004Size() {
        return contagem004.getListaRotina004().size();
    }

    /**
     * @param listaRotina004Size the listaRotina004Size to set
     */
    public void setListaRotina004Size(Integer listaRotina004Size) {
        this.listaRotina004Size = listaRotina004Size;
    }

    /**
     * @return the irResponsavel
     */
    public String getIrResponsavel() {

        if (irResponsavel.equals("UFMG") || irResponsavel.equals("ufmg")) {
            irResponsavel = "UNIVERSIDADE FEDERAL DE MINAS GERAIS";
        } else {
            if (irResponsavel.equals("UFPR") || irResponsavel.equals("ufpr")) {
                irResponsavel = "UNIVERSIDADE FEDERAL DO PARANÁ";
            } else {
                if (irResponsavel.equals("UFJF") || irResponsavel.equals("ufjf")) {
                    irResponsavel = "UNIVERSIDADE FEDERAL DE JUIZ DE FORA";
                } else {
                    if (irResponsavel.equals("UNIRIO") || irResponsavel.equals("unirio")) {
                        irResponsavel = "UNIVERSIDADE DO RIO DE JANEIRO";
                    } else {
                        if (irResponsavel.equals("UFAM") || irResponsavel.equals("ufam")) {
                            irResponsavel = "UNIVERSIDADE FEDERAL DO AMAZONAS";
                        } else {
                            if (irResponsavel.equals("UFPA") || irResponsavel.equals("ufpa")) {
                                irResponsavel = "UNIVERSIDADE FEDERAL DO PARÁ";
                            } else {
                                if (irResponsavel.equals("UFBA") || irResponsavel.equals("ufba")) {
                                    irResponsavel = "UNIVERSIDADE FEDERAL DA BAHIA";
                                } else {
                                    if (irResponsavel.equals("UFPE") || irResponsavel.equals("ufpe")) {
                                        irResponsavel = "UNIVERSIDADE FEDERAL DE PERNAMBUCO";
                                    } else {
                                        if (irResponsavel.equals("UFC") || irResponsavel.equals("ufc")) {
                                            irResponsavel = "UNIVERSIDADE FEDERAL DO CEARÁ";
                                        }

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return irResponsavel;
    }

    /**
     * @param irResponsavel the irResponsavel to set
     */
    public void setIrResponsavel(String irResponsavel) {
        this.irResponsavel = irResponsavel;
    }

    /**
     * @return the listaRotina006Size
     */
    public Integer getListaRotina006Size() {
        return contagem006.getListaRotina006().size();
    }

    /**
     * @param listaRotina006Size the listaRotina006Size to set
     */
    public void setListaRotina006Size(Integer listaRotina006Size) {
        this.listaRotina006Size = listaRotina006Size;
    }

    /**
     * @return the renderedRotinas
     */
    public boolean isRenderedRotinas() {
        return renderedRotinas;
    }

    /**
     * @param renderedRotinas the renderedRotinas to set
     */
    public void setRenderedRotinas(boolean renderedRotinas) {
        this.renderedRotinas = renderedRotinas;
    }

    public Rotina001SinteseSupervisaoVo getContagem001() {
        return contagem001;
    }

    public void setContagem001(Rotina001SinteseSupervisaoVo contagem001) {
        this.contagem001 = contagem001;
    }

    /**
     * @return the listaRotina001Size
     */
    public Integer getListaRotina001Size() {
        return contagem001.getListaRotina001().size();
    }

    /**
     * @param listaRotina001Size the listaRotina001Size to set
     */
    public void setListaRotina001Size(Integer listaRotina001Size) {
        this.listaRotina001Size = listaRotina001Size;
    }


    /*
     *Iniciar Rotina003
     */
    public Rotina003SinteseSupervisaoVo getContagem003() {
        return contagem003;
    }

    public void setContagem003(Rotina003SinteseSupervisaoVo contagem003) {
        this.contagem003 = contagem003;
    }

    /**
     * @return the listaRotina003Size
     */
    public Integer getListaRotina003Size() {
        return contagem003.getListaRotina003().size();
    }

    /**
     * @param listaRotina003Size the listaRotina003Size to set
     */
    public void setListaRotina003Size(Integer listaRotina003Size) {
        this.listaRotina003Size = listaRotina003Size;
    }

    public Rotina007SinteseSupervisaoVo getContagem007() {
        return contagem007;
    }

    public void setContagem007(Rotina007SinteseSupervisaoVo contagem007) {
        this.contagem007 = contagem007;
    }

    public Integer getListaRotina007Size() {
        return contagem007.getListaRotina007().size();
    }

    public void setListaRotina007Size(Integer listaRotina007Size) {
        this.listaRotina007Size = listaRotina007Size;
    }

    public Rotina002SinteseSupervisaoVo getContagem002() {
        return contagem002;
    }

    public void setContagem002(Rotina002SinteseSupervisaoVo contagem002) {
        this.contagem002 = contagem002;
    }

    public Integer getListaRotina002Size() {
        return contagem002.getListaRotina002().size();
    }

    public void setListaRotina002Size(Integer listaRotina002Size) {
        this.listaRotina002Size = listaRotina002Size;
    }

    public boolean isDisableCoordenacao() {
        if (isRenderedCoordenacoes() != true) {
            disableCoordenacao = true;
        } else {
            disableCoordenacao = false;
        }

        return disableCoordenacao;
    }

    public void setDisableCoordenacao(boolean disableCoordenacao) {
        this.disableCoordenacao = disableCoordenacao;
    }

    /**
     * @return the contagem002PerfilFormadores
     */
    public Rotina002PerfilFormadoresSinteseSupervisaoVo getContagem002PerfilFormadores() {
        return contagem002PerfilFormadores;
    }

    /**
     * @param contagem002PerfilFormadores the contagem002PerfilFormadores to set
     */
    public void setContagem002PerfilFormadores(Rotina002PerfilFormadoresSinteseSupervisaoVo contagem002PerfilFormadores) {
        this.contagem002PerfilFormadores = contagem002PerfilFormadores;
    }

    public Integer getListaRotina002PerfilFormadoresSize() {
        return contagem002PerfilFormadores.getListaRotina002PerfilFormadores().size();
    }

    public void setListaRotina002PerfilFormadoresSize(Integer listaRotina002PerfilFormadoresSize) {
        this.listaRotina002PerfilFormadoresSize = listaRotina002PerfilFormadoresSize;
    }

    /**
     * @return the contagem002PerfilEducadores
     */
    public Rotina002PerfilEducadoresSinteseSupervisaoVo getContagem002PerfilEducadores() {
        return contagem002PerfilEducadores;
    }

    /**
     * @param contagem002PerfilEducadores the contagem002PerfilEducadores to set
     */
    public void setContagem002PerfilEducadores(Rotina002PerfilEducadoresSinteseSupervisaoVo contagem002PerfilEducadores) {
        this.contagem002PerfilEducadores = contagem002PerfilEducadores;
    }

    /**
     * @return the listaRotina002PerfilEducadoresSize
     */
    public Integer getListaRotina002PerfilEducadoresSize() {
        return contagem002PerfilEducadores.getListaRotina002PerfilEducadores().size();
    }

    /**
     * @param listaRotina002PerfilEducadoresSize the listaRotina002PerfilEducadoresSize to set
     */
    public void setListaRotina002PerfilEducadoresSize(Integer listaRotina002PerfilEducadoresSize) {
        this.listaRotina002PerfilEducadoresSize = listaRotina002PerfilEducadoresSize;
    }

    /**
     * @return the listaCeRotina001Size
     */
    public Integer getListaCeRotina001Size() {
        return contagemCe001.getListaCeRotina001().size();
    }

    /**
     * @param listaCeRotina001Size the listaCeRotina001Size to set
     */
    public void setListaCeRotina001Size(Integer listaCeRotina001Size) {
        this.listaCeRotina001Size = listaCeRotina001Size;
    }

    /**
     * @return the listaCeRotina002Size
     */
    public Integer getListaCeRotina002Size() {
        return contagemCe002.getListaCeRotina002().size();
    }

    /**
     * @param listaCeRotina002Size the listaCeRotina002Size to set
     */
    public void setListaCeRotina002Size(Integer listaCeRotina002Size) {
        this.listaCeRotina002Size = listaCeRotina002Size;
    }

    /**
     * @return the listaCeRotina003Size
     */
    public Integer getListaCeRotina003Size() {
        return contagemCe003.getListaCeRotina003().size();
    }

    /**
     * @param listaCeRotina003Size the listaCeRotina003Size to set
     */
    public void setListaCeRotina003Size(Integer listaCeRotina003Size) {
        this.listaCeRotina003Size = listaCeRotina003Size;
    }

    /**
     * @return the contagemCe001
     */
    public CeRotina001SinteseSupervisaoVo getContagemCe001() {
        return contagemCe001;
    }

    /**
     * @param contagemCe001 the contagemCe001 to set
     */
    public void setContagemCe001(CeRotina001SinteseSupervisaoVo contagemCe001) {
        this.contagemCe001 = contagemCe001;
    }

    /**
     * @return the contagemCe002
     */
    public CeRotina002SinteseSupervisaoVo getContagemCe002() {
        return contagemCe002;
    }

    /**
     * @param contagemCe002 the contagemCe002 to set
     */
    public void setContagemCe002(CeRotina002SinteseSupervisaoVo contagemCe002) {
        this.contagemCe002 = contagemCe002;
    }

    /**
     * @return the contagemCe003
     */
    public CeRotina003SinteseSupervisaoVo getContagemCe003() {
        return contagemCe003;
    }

    /**
     * @param contagemCe003 the contagemCe003 to set
     */
    public void setContagemCe003(CeRotina003SinteseSupervisaoVo contagemCe003) {
        this.contagemCe003 = contagemCe003;
    }

    public String getLinkCaed() {
        return linkCaed;
    }

    public void setLinkCaed(String linkCaed) {
        this.linkCaed = linkCaed;
    }

    public boolean isRenderedLinkCaed() {
        return renderedLinkCaed;
    }

    public void setRenderedLinkCaed(boolean renderedLinkCaed) {
        this.renderedLinkCaed = renderedLinkCaed;
    }

    public String getObservacaoEscolhida() {
        return observacaoEscolhida;
    }

    public void setObservacaoEscolhida(String observacaoEscolhida) {
        this.observacaoEscolhida = observacaoEscolhida;
    }

    public boolean isRenderedObservacao() {
        return renderedObservacao;
    }

    public void setRenderedObservacao(boolean renderedObservacao) {
        this.renderedObservacao = renderedObservacao;
    }

    public boolean isDisableObservacao() {
        return disableObservacao;
    }

    public void setDisableObservacao(boolean disableObservacao) {
        this.disableObservacao = disableObservacao;
    }

    /**
     * @return the municipioEscolhida
     */
    public String getMunicipioEscolhida() {
        return municipioEscolhida;
    }

    /**
     * @param municipioEscolhida the municipioEscolhida to set
     */
    public void setMunicipioEscolhida(String municipioEscolhida) {
        this.municipioEscolhida = municipioEscolhida;
    }

    /**
     * @return the renderedMunicipios
     */
    public boolean isRenderedMunicipios() {
        return renderedMunicipios;
    }

    /**
     * @param renderedMunicipios the renderedMunicipios to set
     */
    public void setRenderedMunicipios(boolean renderedMunicipios) {
        this.renderedMunicipios = renderedMunicipios;
    }

    /**
     * @return the disableMunicipios
     */
    public boolean isDisableMunicipios() {
        if(municipios.size() == 1){
            disableMunicipios = true;
            setMunicipioEscolhida(municipios.get(0).getLabel());
            obtemRotinas();
        }else{
            disableMunicipios = false;
        }
        return disableMunicipios;
    }

    /**
     * @param disableMunicipios the disableMunicipios to set
     */
    public void setDisableMunicipios(boolean disableMunicipios) {
        this.disableMunicipios = disableMunicipios;
    }

    /**
     * @return the municipios
     */
    public List<SelectItem> getMunicipios() {
        return municipios;
    }

    /**
     * @return the dataAtual
     */
    public String getDataAtual() {
        return dataAtual;
    }

    /**
     * @param dataAtual the dataAtual to set
     */
    public void setDataAtual(String dataAtual) {
        this.dataAtual = dataAtual;
    }

    /**
     * @return the logAcessosDAO
     */
    public LogAcessosDAO getLogAcessosDAO() {
        return logAcessosDAO;
    }

    /**
     * @param logAcessosDAO the logAcessosDAO to set
     */
    public void setLogAcessosDAO(LogAcessosDAO logAcessosDAO) {
        this.logAcessosDAO = logAcessosDAO;
    }

}
