/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.relatorios.rotinaslancadas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;
import projovem.controller.InstrumentoController;
import projovem.dao.NucleoDAO;
import projovem.dao.Rotina001DAO;
import projovem.dao.Rotina002DAO;
import projovem.dao.Rotina003DAO;
import projovem.dao.Rotina004DAO;
import projovem.dao.Rotina005DAO;
import projovem.dao.Rotina006DAO;
import projovem.dao.Rotina007DAO;
import projovem.dao.CeRotina001DAO;
import projovem.dao.CeRotina002DAO;
import projovem.dao.CeRotina003DAO;
import projovem.dao.RotinasDAO;
import projovem.dao.UsuarioDAO;
import projovem.entity.MaterialUtilizado;
import projovem.entity.Usuario;
import projovem.nucleo.Nucleo;
import projovem.relatorios.rotinaslancadas.vo.FiltrosVo;
import projovem.relatorios.rotinaslancadas.vo.RotinasLancadasVO;
import projovem.rotinas.R001.Rotina001;
import projovem.rotinas.R002.Rotina002;
import projovem.rotinas.R002.Rotina002PerfilEducadores;
import projovem.rotinas.R002.Rotina002PerfilFormadores;
import projovem.rotinas.R003.Rotina003;
import projovem.rotinas.R004.Rotina004;
import projovem.rotinas.R004.Rotina004V2;
import projovem.rotinas.R005.Rotina005;
import projovem.rotinas.R006.Rotina006ArcosOcupacionais;
import projovem.rotinas.R006.Rotina006ArcosOcupacionaisV3;
import projovem.rotinas.R006.Rotina006CoordenacaoLocal;
import projovem.rotinas.R007.Rotina007;
import projovem.rotinas.CE.R001.CeRotina001;
import projovem.rotinas.CE.R002.CeRotina002;
import projovem.rotinas.CE.R003.CeRotina003;
import projovem.rotinas.R001.Rotina001Bean;
import projovem.rotinas.R002.Rotina002Bean;
import projovem.rotinas.R002.Rotina002PerfilFormadoresBean;
import projovem.rotinas.R002.Rotina002PerfilEducadoresBean;
import projovem.rotinas.R003.Rotina003Bean;
import projovem.rotinas.R004.Rotina004Bean;
import projovem.rotinas.R004.Rotina004BeanV2;
import projovem.rotinas.R005.Rotina005Bean;
import projovem.rotinas.R006.Rotina006ArcosOcupacionaisBean;
import projovem.rotinas.R006.Rotina006ArcosOcupacionaisV3Bean;
import projovem.rotinas.R006.Rotina006ArcosOcupacionaisMateriais;
import projovem.rotinas.R006.Rotina006CoordenacaoLocalBean;
import projovem.rotinas.R007.Rotina007Bean;
import projovem.rotinas.CE.R001.CeRotina001Bean;
import projovem.rotinas.CE.R001.ValidacaoCeR001;
import projovem.rotinas.CE.R002.CeRotina002Bean;
import projovem.rotinas.CE.R002.ValidacaoCeR002;
import projovem.rotinas.CE.R003.CeRotina003Bean;
import projovem.rotinas.CE.R003.ValidacaoCeR003;
import projovem.rotinas.CE.R004.CeRotina004;
import projovem.rotinas.CE.R004.CeRotina004Bean;
import projovem.rotinas.CE.R004.CeRotina004DAO;
import projovem.rotinas.CE.R004.ValidacaoCeR004;
import projovem.rotinas.R001.ValidacaoR001;
import projovem.rotinas.R002.ValidacaoPerfilEducadores;
import projovem.rotinas.R002.ValidacaoPerfilFormadores;
import projovem.rotinas.R002.ValidacaoR002;
import projovem.rotinas.R003.Rotina003Ficha;
import projovem.rotinas.R003.ValidacaoR003;
import projovem.rotinas.R004.ValidacaoR004;
import projovem.rotinas.R004.ValidacaoR004V2;
import projovem.rotinas.R005.ValidacaoR005;
import projovem.rotinas.R006.ValidacaoArcosOcupacionais;
import projovem.rotinas.R006.ValidacaoArcosOcupacionaisV3;
import projovem.rotinas.R006.ValidacaoCoordenacaoLocal;
import projovem.rotinas.R007.ValidacaoR007;

/**
 *
 * @author admprojovem
 */
public class RotinasLancadasBean implements Serializable {

    @Resource
    private UserTransaction utx;
    @PersistenceUnit(unitName = "projovemPU")
    private EntityManagerFactory emf;
    private InstrumentoController controller = new InstrumentoController();
    private NucleoDAO nucleoDao = new NucleoDAO();
    private RotinasDAO rotinasDao = new RotinasDAO();
    private Rotina001DAO rotina001Dao = new Rotina001DAO();
    private Rotina002DAO rotina002Dao = new Rotina002DAO();
    private Rotina003DAO rotina003Dao = new Rotina003DAO();
    private Rotina004DAO rotina004Dao = new Rotina004DAO();
    private Rotina005DAO rotina005Dao = new Rotina005DAO();
    private Rotina006DAO rotina006Dao = new Rotina006DAO();
    private Rotina007DAO rotina007Dao = new Rotina007DAO();
    private CeRotina001DAO cerotina001Dao = new CeRotina001DAO();
    private CeRotina002DAO cerotina002Dao = new CeRotina002DAO();
    private CeRotina003DAO cerotina003Dao = new CeRotina003DAO();
    private CeRotina004DAO cerotina004Dao = new CeRotina004DAO();
    private UsuarioDAO usuarioDao = new UsuarioDAO();
    private List<RotinasLancadasVO> listaRotinasLancadasVO = new ArrayList<RotinasLancadasVO>();
    private Integer idRotinaEscolhida;
    private String rotinaEscolhida;
    private boolean rotinaAguardandoValidacao;
    private boolean disabled;
    private String irEscolhida;
    private String coordenacaoEscolhida;
    private String municipioEscolhida;
    private String entradaEscolhida;
    private String supervisorEscolhida;
    private String dataInicialEscolhida;
    private String dataFinalEscolhida;
    private boolean renderedBotaoGerar;
    private Rotina001 rotina001 = new Rotina001();
    private Rotina002 rotina002 = new Rotina002();
    private Rotina002PerfilEducadores rotina002PerfilEducadores = new Rotina002PerfilEducadores();
    private Rotina002PerfilFormadores rotina002PerfilFormadores = new Rotina002PerfilFormadores();
    private Rotina003 rotina003 = new Rotina003();
    private Rotina003Ficha ficha = new Rotina003Ficha();
    private Rotina004 rotina004 = new Rotina004();
    private Rotina004V2 rotina004V2 = new Rotina004V2();
    private Rotina005 rotina005 = new Rotina005();
    private Rotina006ArcosOcupacionais rotina006ArcosOcupacionais = new Rotina006ArcosOcupacionais();
    private Rotina006ArcosOcupacionaisV3 rotina006ArcosOcupacionaisV3 = new Rotina006ArcosOcupacionaisV3();
    private Rotina006CoordenacaoLocal rotina006CoordenacaoLocal = new Rotina006CoordenacaoLocal();
    private Rotina007 rotina007 = new Rotina007();
    private CeRotina001 cerotina001 = new CeRotina001();
    private CeRotina002 cerotina002 = new CeRotina002();
    private CeRotina003 cerotina003 = new CeRotina003();
    private MaterialUtilizado materilUtilizado = new MaterialUtilizado();
    private Nucleo nucleo = new Nucleo();
    private CeRotina004 ceRotina004 = new CeRotina004();
    private Usuario usuarioLogado = new Usuario();
    private boolean disableIr;
    private boolean disableCoordenacao;
    private boolean disableEntrada;
    private boolean disableMunicipio;
    private boolean disableSupervisor;
    private List<SelectItem> irs = new ArrayList<SelectItem>();
    private List<SelectItem> coordenacoes = new ArrayList<SelectItem>();
    private List<SelectItem> municipios = new ArrayList<SelectItem>();
    private List<SelectItem> entradas = new ArrayList<SelectItem>();
    private List<SelectItem> supervidores = new ArrayList<SelectItem>();
    private Rotina006ArcosOcupacionaisMateriais arcoOcupacionalMaterial = new Rotina006ArcosOcupacionaisMateriais();
    private List<Rotina006ArcosOcupacionaisMateriais> materiais = new ArrayList<Rotina006ArcosOcupacionaisMateriais>();
    private List<MaterialUtilizado> listaMaterialUtilizado = new ArrayList<MaterialUtilizado>();
    private List<Rotina003Ficha> listaFichas = new ArrayList<Rotina003Ficha>();
    private String validacao;
    private Rotina001Bean rotina001Bean = new Rotina001Bean();
    private Rotina002Bean rotina002Bean = new Rotina002Bean();
    private Rotina002PerfilFormadoresBean rotina002PerfilFormadoresBean = new Rotina002PerfilFormadoresBean();
    private Rotina002PerfilEducadoresBean rotina002PerfilEducadoresBean = new Rotina002PerfilEducadoresBean();
    private Rotina003Bean rotina003Bean = new Rotina003Bean();
    private Rotina004BeanV2 rotina004BeanV2 = new Rotina004BeanV2();
    private Rotina004Bean rotina004Bean = new Rotina004Bean();
    private Rotina005Bean rotina005Bean = new Rotina005Bean();
    private Rotina006ArcosOcupacionaisBean rotina006ArcosOcupacionaisBean = new Rotina006ArcosOcupacionaisBean();
    private Rotina006ArcosOcupacionaisV3Bean rotina006ArcosOcupacionaisV3Bean = new Rotina006ArcosOcupacionaisV3Bean();
    private Rotina006CoordenacaoLocalBean rotina006CoordenacaoLocalBean = new Rotina006CoordenacaoLocalBean();
    private Rotina007Bean rotina007Bean = new Rotina007Bean();
    private CeRotina001Bean cerotina001Bean = new CeRotina001Bean();
    private CeRotina002Bean cerotina002Bean = new CeRotina002Bean();
    private CeRotina003Bean cerotina003Bean = new CeRotina003Bean();
    private CeRotina004Bean ceRotina004Bean = new CeRotina004Bean();
    private List<String> listRotinaAguardandoValidacao = new ArrayList<String>();
    private List<String> isArcoAFechado = new ArrayList<String>();
    private List<String> isArcoBFechado = new ArrayList<String>();
    private List<String> isArcoCFechado = new ArrayList<String>();
    private List<String> isArcoDFechado = new ArrayList<String>();
    private List<String> isArcoEFechado = new ArrayList<String>();
    private String usuarioResponsavel;
    private String cpfResponsavel;
    private String usuarioEditor;

    public void adicionarLinha() {
        ficha.setTemCarteiraIdentidade("Não");
        ficha.setTemComprovanteResidencia("Não");
        ficha.setTemRegistroEscolar("Não");
        ficha.setTemTeste("Não");

        if (ficha.getAtributos() != null && ficha.getAtributos().size() > 0) {
            for (String string : ficha.getAtributos()) {
                if (string.equals("temCarteiraIdentidade")) {
                    ficha.setTemCarteiraIdentidade("Sim");
                }
                if (string.equals("temComprovanteResidencia")) {
                    ficha.setTemComprovanteResidencia("Sim");
                }
                if (string.equals("temRegistroEscolar")) {
                    ficha.setTemRegistroEscolar("Sim");
                }
                if (string.equals("temTeste")) {
                    ficha.setTemTeste("Sim");
                }
            }
        }

        listaFichas = rotina003.getListaFichas();
        System.out.println(listaFichas.size());
        if (!listaFichas.contains(ficha)) {
            listaFichas.add(ficha);
        }
        System.out.println(listaFichas.size());
        rotina003.setListaFichas(listaFichas);
        ficha = new Rotina003Ficha();
    }

    public void editarFicha() {
    }

    public void excluirFicha() {
        rotina003.getListaFichas().remove(ficha);
        ficha = new Rotina003Ficha();
    }

    public void adicionarMaterial() {
        System.out.println("Entrou aqui.....");
        if (!materiais.contains(arcoOcupacionalMaterial)) {
            materiais.add(arcoOcupacionalMaterial);
        }
        arcoOcupacionalMaterial = new Rotina006ArcosOcupacionaisMateriais();
    }
    
    public void editarMaterial() {
    }

    public void removerMaterial() {
        materiais.remove(arcoOcupacionalMaterial);
        arcoOcupacionalMaterial = new Rotina006ArcosOcupacionaisMateriais();
    }

    public void irSelecionada() {
        entradas = nucleoDao.obtemEntradasByIR(irEscolhida, emf);
        supervidores = usuarioDao.getByIrAndPerfil(emf, irEscolhida);
    }

    public void coordenacaoSelecionada() {
        municipios = nucleoDao.obtemMunicipiosByCoordenacaoAndEntrada(entradaEscolhida, coordenacaoEscolhida, emf);
    }

    public void municipioSelecionada() {
    }

    public void entradaSelecionada() {
        coordenacoes = nucleoDao.obtemCoordenacoesByEntradaandIR(entradaEscolhida, irEscolhida, emf);
    }

    public void supervisorSelecionada() {
    }

    public void rotinaSelecionada() {
        setRotinaEscolhida(rotinaEscolhida);
    }

    public void rotinaAguardandoValidacao() {
        setListRotinaAguardandoValidacao(getListRotinaAguardandoValidacao());
        if (getListRotinaAguardandoValidacao() != null && getListRotinaAguardandoValidacao().size() > 0) {
            for (String AguardandoValidacao : getListRotinaAguardandoValidacao()) {
                if (AguardandoValidacao.equals("1")) {
                    setRotinaAguardandoValidacao(true);
                } else {
                    setRotinaAguardandoValidacao(false);
                }
            }
        }
    }

    public boolean isDisableCoordenacao() {
        if  ((entradaEscolhida != null && entradaEscolhida.isEmpty()) || entradaEscolhida == null) {
            disableCoordenacao = true;
        } else {
            disableCoordenacao = false;
        }
        return disableCoordenacao;
    }

    public void setDisableCoordenacao(boolean disableCoordenacao) {
        this.disableCoordenacao = disableCoordenacao;
    }

    public boolean isDisableEntrada() {
        if ((irEscolhida != null && irEscolhida.isEmpty()) || irEscolhida == null) {
            disableEntrada = true;
        } else {
            disableEntrada = false;
        }

        return disableEntrada;
    }

    public void setDisableEntrada(boolean disableEntrada) {
        this.disableEntrada = disableEntrada;
    }

    public boolean isDisableIr() {
        if (usuarioLogado.getPerfil().equals("1")) {
            disableIr = false;
        } else {
            disableIr = true;
            irEscolhida = usuarioLogado.getIr().toUpperCase();
            irSelecionada();
        }
        return disableIr;
    }

    public void setDisableIr(boolean disableIr) {
        this.disableIr = disableIr;
    }

    public boolean isDisableSupervisor() {
        if (usuarioLogado.getPerfil().equals("1") || usuarioLogado.getPerfil().equals("2")) {
            disableSupervisor = false;
        } else {
            disableSupervisor = true;
            supervisorEscolhida = usuarioLogado.getNome();
        }
        return disableSupervisor;
    }

    public void setDisableSupervisor(boolean disableSupervisor) {
        this.disableSupervisor = disableSupervisor;
    }

    public RotinasLancadasBean() {
        usuarioLogado = usuarioDao.getUsuarioLogado();
    }

    public String visualizarRotina() {
        String retorno = "rotina001SomenteLeitura";
        disabled = true;

        if (rotinaEscolhida.equals("Rotina 001")) {
            setRotina001(rotina001Dao.getById(idRotinaEscolhida, emf));
            rotina001_ObterListQ4(rotina001);
            retorno = "rotina001SomenteLeitura";
        }

        if (rotinaEscolhida.equals("Rotina 002")) {
            setRotina002(rotina002Dao.getById(idRotinaEscolhida, emf));
            retorno = "rotina002SomenteLeitura";
        }

        if (rotinaEscolhida.equals("Rotina 002 - Perfil Educadores")) {
            setRotina002PerfilEducadores(rotina002Dao.getPerfilEducadoresById(idRotinaEscolhida, emf));

            obterComponenteCurricular(rotina002PerfilEducadores);
            rotina002PerfilEducadores_ObterListQ8(rotina002PerfilEducadores);
            rotina002PerfilEducadores_ObterListQ11(rotina002PerfilEducadores);
            rotina002PerfilEducadores_ObterListQ13(rotina002PerfilEducadores);
            rotina002PerfilEducadores_ObterListQ14(rotina002PerfilEducadores);
            retorno = "rotina002PerfilEducadoresSomenteLeitura";
        }

        if (rotinaEscolhida.equals("Rotina 002 - Perfil Formadores")) {
            setRotina002PerfilFormadores(rotina002Dao.getPerfilFormadoresById(idRotinaEscolhida, emf));
            obterComponenteCurricular(cerotina002);
            rotina002Ce_ObterListQ5(cerotina002);
            rotina002Ce_ObterListQ7(cerotina002);
            rotina002Ce_ObterListQ8(cerotina002);
            retorno = "rotina002PerfilFormadoresSomenteLeitura";
        }

        if (rotinaEscolhida.equals("Rotina 003")) {
            setRotina003(rotina003Dao.getById(idRotinaEscolhida, emf));
            this.listaFichas = rotina003.getListaFichas();
            retorno = "rotina003SomenteLeitura";
        }

        if (rotinaEscolhida.equals("Rotina 004V2")) {
            setRotina004V2(rotina004Dao.getByIdV2(idRotinaEscolhida, emf));
            retorno = "rotina004V2SomenteLeitura";
        }

        if (rotinaEscolhida.equals("Rotina 004")) {
            setRotina004(rotina004Dao.getById(idRotinaEscolhida, emf));
            retorno = "rotina004SomenteLeitura";
        }

        if (rotinaEscolhida.equals("Rotina 005")) {
            setRotina005(rotina005Dao.getById(idRotinaEscolhida, emf));
            retorno = "rotina005SomenteLeitura";
        }

        if (rotinaEscolhida.equals("Rotina 006 - Arcos Ocupacionais")) {
            setRotina006ArcosOcupacionais(rotina006Dao.getArcosOcupacionaisById(idRotinaEscolhida, emf));

            this.materiais = rotina006ArcosOcupacionais.getQ55();

            this.isArcoAFechado.add("false");
            this.isArcoBFechado.add("false");
            this.isArcoCFechado.add("false");
            this.isArcoDFechado.add("false");
            this.isArcoEFechado.add("false");

            if (rotina006ArcosOcupacionais.getQ9Fechado() != null && rotina006ArcosOcupacionais.getQ9Fechado().equals("true")) {
                this.isArcoAFechado.add("fechado");
            }
            if (rotina006ArcosOcupacionais.getQ10Fechado() != null && rotina006ArcosOcupacionais.getQ10Fechado().equals("true")) {
                this.isArcoBFechado.add("true");
            }
            if (rotina006ArcosOcupacionais.getQ11Fechado() != null && rotina006ArcosOcupacionais.getQ11Fechado().equals("true")) {
                this.isArcoCFechado.add("true");
            }
            if (rotina006ArcosOcupacionais.getQ12Fechado() != null && rotina006ArcosOcupacionais.getQ12Fechado().equals("true")) {
                this.isArcoDFechado.add("true");
            }
            if (rotina006ArcosOcupacionais.getQ13Fechado() != null && rotina006ArcosOcupacionais.getQ13Fechado().equals("true")) {
                this.isArcoEFechado.add("true");
            }
            retorno = "rotina006ArcosOcupacionaisSomenteLeitura";
        }

        if (rotinaEscolhida.equals("Rotina 006 - Arcos OcupacionaisV3")) {
            setRotina006ArcosOcupacionaisV3(rotina006Dao.getArcosOcupacionaisV3ById(idRotinaEscolhida, emf));

            this.isArcoAFechado.add("false");
            this.isArcoBFechado.add("false");
            this.isArcoCFechado.add("false");
            this.isArcoDFechado.add("false");
            this.isArcoEFechado.add("false");

            if (rotina006ArcosOcupacionaisV3.getQ10Fechado() != null && rotina006ArcosOcupacionaisV3.getQ10Fechado().equals("true")) {
                this.isArcoAFechado.add("fechado");
            }
            if (rotina006ArcosOcupacionaisV3.getQ11Fechado() != null && rotina006ArcosOcupacionaisV3.getQ11Fechado().equals("true")) {
                this.isArcoBFechado.add("true");
            }
            if (rotina006ArcosOcupacionaisV3.getQ12Fechado() != null && rotina006ArcosOcupacionaisV3.getQ12Fechado().equals("true")) {
                this.isArcoCFechado.add("true");
            }
            if (rotina006ArcosOcupacionaisV3.getQ13Fechado() != null && rotina006ArcosOcupacionaisV3.getQ13Fechado().equals("true")) {
                this.isArcoDFechado.add("true");
            }
            if (rotina006ArcosOcupacionaisV3.getQ14Fechado() != null && rotina006ArcosOcupacionaisV3.getQ14Fechado().equals("true")) {
                this.isArcoEFechado.add("true");
            }
            retorno = "rotina006ArcosOcupacionaisV3SomenteLeitura";
        }

        if (rotinaEscolhida.equals("Rotina 006 - Coordenacao Local")) {
            setRotina006CoordenacaoLocal(rotina006Dao.getCoordenacaoLocalById(idRotinaEscolhida, emf));
            retorno = "rotina006CoordenacaoLocalSomenteLeitura";
        }

        if (rotinaEscolhida.equals("Rotina 007")) {
            setRotina007(rotina007Dao.getById(idRotinaEscolhida, emf));
            obterComponenteCurricular(rotina007);
            rotina007_ObterListQ6(rotina007);
            retorno = "rotina007SomenteLeitura";
        }

        if (rotinaEscolhida.equals("Rotina 001 - Estadual")) {
            setCerotina001(cerotina001Dao.getById(idRotinaEscolhida, emf));
            retorno = "cerotina001SomenteLeitura";
        }
        if (rotinaEscolhida.equals("Rotina 002 - Estadual")) {
            setCerotina002(cerotina002Dao.getById(idRotinaEscolhida, emf));
            retorno = "cerotina002SomenteLeitura";
        }
        if (rotinaEscolhida.equals("Rotina 003 - Estadual")) {
            setCerotina003(cerotina003Dao.getById(idRotinaEscolhida, emf));
            retorno = "cerotina003SomenteLeitura";
        }
        if (rotinaEscolhida.equals("Rotina 004 - Estadual")) {
            setCeRotina004(cerotina004Dao.getById(idRotinaEscolhida, emf));
            retorno = "cerotina004SomenteLeitura";
        }

        return retorno;
    }

    public String visualizarComprovante() {
        String retorno = "Rotina001Salva";
        disabled = true;

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        if (rotinaEscolhida.equals("Rotina 001")) {
            setRotina001(rotina001Dao.getById(idRotinaEscolhida, emf));
            rotina001_ObterListQ4(rotina001);
            setUsuarioResponsavel(rotina001.getUsuario().getNome());
            setCpfResponsavel(rotina001.getUsuario().getCpf());
            if (rotina001.getDadosEditados().equals("1")) {
                Usuario usuario = usuarioDAO.getById(emf, rotina001.getUsrResponsavelEdicao());
                setUsuarioEditor(usuario.getNome());
            }
            retorno = "Rotina001Salva";
        }

        if (rotinaEscolhida.equals("Rotina 002")) {
            setRotina002(rotina002Dao.getById(idRotinaEscolhida, emf));
            setUsuarioResponsavel(rotina002.getUsuario().getNome());
            setCpfResponsavel(rotina002.getUsuario().getCpf());
            if (rotina002.getDadosEditados().equals("1")) {
                Usuario usuario = usuarioDAO.getById(emf, rotina002.getUsrResponsavelEdicao());
                setUsuarioEditor(usuario.getNome());
            }
            retorno = "Rotina002Salva";
        }

        if (rotinaEscolhida.equals("Rotina 002 - Perfil Educadores")) {
            setRotina002PerfilEducadores(rotina002Dao.getPerfilEducadoresById(idRotinaEscolhida, emf));

            obterComponenteCurricular(rotina002PerfilEducadores);
            rotina002PerfilEducadores_ObterListQ8(rotina002PerfilEducadores);
            rotina002PerfilEducadores_ObterListQ11(rotina002PerfilEducadores);
            rotina002PerfilEducadores_ObterListQ13(rotina002PerfilEducadores);
            rotina002PerfilEducadores_ObterListQ14(rotina002PerfilEducadores);

            setUsuarioResponsavel(rotina002PerfilEducadores.getUsuario().getNome());
            setCpfResponsavel(rotina002PerfilEducadores.getUsuario().getCpf());
            if (rotina002PerfilEducadores.getDadosEditados().equals("1")) {
                Usuario usuario = usuarioDAO.getById(emf, rotina002PerfilEducadores.getUsrResponsavelEdicao());
                setUsuarioEditor(usuario.getNome());
            }
            retorno = "Rotina002PerfilEducadoresSalva";
        }

        if (rotinaEscolhida.equals("Rotina 002 - Perfil Formadores")) {
            setRotina002PerfilFormadores(rotina002Dao.getPerfilFormadoresById(idRotinaEscolhida, emf));
            obterComponenteCurricular(cerotina002);
            rotina002Ce_ObterListQ5(cerotina002);
            rotina002Ce_ObterListQ7(cerotina002);
            rotina002Ce_ObterListQ8(cerotina002);

            setUsuarioResponsavel(rotina002PerfilFormadores.getUsuario().getNome());
            setCpfResponsavel(rotina002PerfilFormadores.getUsuario().getCpf());
            if (rotina002PerfilFormadores.getDadosEditados().equals("1")) {
                Usuario usuario = usuarioDAO.getById(emf, rotina002PerfilFormadores.getUsrResponsavelEdicao());
                setUsuarioEditor(usuario.getNome());
            }
            retorno = "Rotina002PerfilFormadoresSalva";
        }

        if (rotinaEscolhida.equals("Rotina 003")) {
            setRotina003(rotina003Dao.getById(idRotinaEscolhida, emf));

            setUsuarioResponsavel(rotina003.getUsuario().getNome());
            setCpfResponsavel(rotina003.getUsuario().getCpf());
            if (rotina003.getDadosEditados().equals("1")) {
                Usuario usuario = usuarioDAO.getById(emf, rotina003.getUsrResponsavelEdicao());
                setUsuarioEditor(usuario.getNome());
            }
            this.listaFichas = rotina003.getListaFichas();
            retorno = "Rotina003Salva";
        }

        if (rotinaEscolhida.equals("Rotina 004V2")) {
            setRotina004V2(rotina004Dao.getByIdV2(idRotinaEscolhida, emf));

            setUsuarioResponsavel(rotina004V2.getUsuario().getNome());
            setCpfResponsavel(rotina004V2.getUsuario().getCpf());
            if (rotina004V2.getDadosEditados().equals("1")) {
                Usuario usuario = usuarioDAO.getById(emf, rotina004V2.getUsrResponsavelEdicao());
                setUsuarioEditor(usuario.getNome());
            }

            retorno = "Rotina004V2Salva";
        }

        if (rotinaEscolhida.equals("Rotina 004")) {
            setRotina004(rotina004Dao.getById(idRotinaEscolhida, emf));

            setUsuarioResponsavel(rotina004.getUsuario().getNome());
            setCpfResponsavel(rotina004.getUsuario().getCpf());
            if (rotina004.getDadosEditados().equals("1")) {
                Usuario usuario = usuarioDAO.getById(emf, rotina004.getUsrResponsavelEdicao());
                setUsuarioEditor(usuario.getNome());
            }

            retorno = "Rotina004Salva";
        }

        if (rotinaEscolhida.equals("Rotina 005")) {
            setRotina005(rotina005Dao.getById(idRotinaEscolhida, emf));

            setUsuarioResponsavel(rotina005.getUsuario().getNome());
            setCpfResponsavel(rotina005.getUsuario().getCpf());
            if (rotina005.getDadosEditados().equals("1")) {
                Usuario usuario = usuarioDAO.getById(emf, rotina005.getUsrResponsavelEdicao());
                setUsuarioEditor(usuario.getNome());
            }

            retorno = "Rotina005Salva";
        }

        if (rotinaEscolhida.equals("Rotina 006 - Arcos Ocupacionais")) {
            setRotina006ArcosOcupacionais(rotina006Dao.getArcosOcupacionaisById(idRotinaEscolhida, emf));

            this.materiais = rotina006ArcosOcupacionais.getQ55();

            this.isArcoAFechado.add("false");
            this.isArcoBFechado.add("false");
            this.isArcoCFechado.add("false");
            this.isArcoDFechado.add("false");
            this.isArcoEFechado.add("false");

            if (rotina006ArcosOcupacionais.getQ9Fechado() != null && rotina006ArcosOcupacionais.getQ9Fechado().equals("true")) {
                this.isArcoAFechado.add("fechado");
            }
            if (rotina006ArcosOcupacionais.getQ10Fechado() != null && rotina006ArcosOcupacionais.getQ10Fechado().equals("true")) {
                this.isArcoBFechado.add("true");
            }
            if (rotina006ArcosOcupacionais.getQ11Fechado() != null && rotina006ArcosOcupacionais.getQ11Fechado().equals("true")) {
                this.isArcoCFechado.add("true");
            }
            if (rotina006ArcosOcupacionais.getQ12Fechado() != null && rotina006ArcosOcupacionais.getQ12Fechado().equals("true")) {
                this.isArcoDFechado.add("true");
            }
            if (rotina006ArcosOcupacionais.getQ13Fechado() != null && rotina006ArcosOcupacionais.getQ13Fechado().equals("true")) {
                this.isArcoEFechado.add("true");
            }

            setUsuarioResponsavel(rotina006ArcosOcupacionais.getUsuario().getNome());
            setCpfResponsavel(rotina006ArcosOcupacionais.getUsuario().getCpf());
            if (rotina006ArcosOcupacionais.getDadosEditados().equals("1")) {
                Usuario usuario = usuarioDAO.getById(emf, rotina006ArcosOcupacionais.getUsrResponsavelEdicao());
                setUsuarioEditor(usuario.getNome());
            }

            retorno = "Rotina006ArcosOcupacionaisSalva";
        }

        if (rotinaEscolhida.equals("Rotina 006 - Arcos OcupacionaisV3")) {
            setRotina006ArcosOcupacionaisV3(rotina006Dao.getArcosOcupacionaisV3ById(idRotinaEscolhida, emf));

            this.isArcoAFechado.add("false");
            this.isArcoBFechado.add("false");
            this.isArcoCFechado.add("false");
            this.isArcoDFechado.add("false");
            this.isArcoEFechado.add("false");

            if (rotina006ArcosOcupacionaisV3.getQ10Fechado() != null && rotina006ArcosOcupacionaisV3.getQ10Fechado().equals("true")) {
                this.isArcoAFechado.add("fechado");
            }
            if (rotina006ArcosOcupacionaisV3.getQ11Fechado() != null && rotina006ArcosOcupacionaisV3.getQ11Fechado().equals("true")) {
                this.isArcoBFechado.add("true");
            }
            if (rotina006ArcosOcupacionaisV3.getQ12Fechado() != null && rotina006ArcosOcupacionaisV3.getQ12Fechado().equals("true")) {
                this.isArcoCFechado.add("true");
            }
            if (rotina006ArcosOcupacionaisV3.getQ13Fechado() != null && rotina006ArcosOcupacionaisV3.getQ13Fechado().equals("true")) {
                this.isArcoDFechado.add("true");
            }
            if (rotina006ArcosOcupacionaisV3.getQ14Fechado() != null && rotina006ArcosOcupacionaisV3.getQ14Fechado().equals("true")) {
                this.isArcoEFechado.add("true");
            }

            setUsuarioResponsavel(rotina006ArcosOcupacionaisV3.getUsuario().getNome());
            setCpfResponsavel(rotina006ArcosOcupacionaisV3.getUsuario().getCpf());
            if (rotina006ArcosOcupacionaisV3.getDadosEditados().equals("1")) {
                Usuario usuario = usuarioDAO.getById(emf, rotina006ArcosOcupacionaisV3.getUsrResponsavelEdicao());
                setUsuarioEditor(usuario.getNome());
            }

            retorno = "Rotina006ArcosOcupacionaisV3Salva";
        }

        if (rotinaEscolhida.equals("Rotina 006 - Coordenacao Local")) {
            System.out.println(rotinaEscolhida);
            setRotina006CoordenacaoLocal(rotina006Dao.getCoordenacaoLocalById(idRotinaEscolhida, emf));

            setUsuarioResponsavel(rotina006CoordenacaoLocal.getUsuario().getNome());
            setCpfResponsavel(rotina006CoordenacaoLocal.getUsuario().getCpf());
            if (rotina006CoordenacaoLocal.getDadosEditados().equals("1")) {
                Usuario usuario = usuarioDAO.getById(emf, rotina006CoordenacaoLocal.getUsrResponsavelEdicao());
                setUsuarioEditor(usuario.getNome());
            }

            retorno = "Rotina006CoordenacaoSalva";
        }

        if (rotinaEscolhida.equals("Rotina 007")) {
            setRotina007(rotina007Dao.getById(idRotinaEscolhida, emf));
            obterComponenteCurricular(rotina007);
            rotina007_ObterListQ6(rotina007);

            setUsuarioResponsavel(rotina007.getUsuario().getNome());
            setCpfResponsavel(rotina007.getUsuario().getCpf());
            if (rotina007.getDadosEditados().equals("1")) {
                Usuario usuario = usuarioDAO.getById(emf, rotina007.getUsrResponsavelEdicao());
                setUsuarioEditor(usuario.getNome());
            }

            retorno = "Rotina007Salva";
        }

        if (rotinaEscolhida.equals("Rotina 001 - Estadual")) {
            setCerotina001(cerotina001Dao.getById(idRotinaEscolhida, emf));

            setUsuarioResponsavel(cerotina001.getUsuario().getNome());
            setCpfResponsavel(cerotina001.getUsuario().getCpf());
            if (cerotina001.getDadosEditados().equals("1")) {
                Usuario usuario = usuarioDAO.getById(emf, cerotina001.getUsrResponsavelEdicao());
                setUsuarioEditor(usuario.getNome());
            }

            retorno = "CeRotina001Salva";
        }
        if (rotinaEscolhida.equals("Rotina 002 - Estadual")) {
            setCerotina002(cerotina002Dao.getById(idRotinaEscolhida, emf));
            obterComponenteCurricular(cerotina002);
            rotina002Ce_ObterListQ5(cerotina002);
            rotina002Ce_ObterListQ7(cerotina002);
            rotina002Ce_ObterListQ8(cerotina002);

            setUsuarioResponsavel(cerotina002.getUsuario().getNome());
            setCpfResponsavel(cerotina002.getUsuario().getCpf());
            if (cerotina002.getDadosEditados().equals("1")) {
                Usuario usuario = usuarioDAO.getById(emf, cerotina002.getUsrResponsavelEdicao());
                setUsuarioEditor(usuario.getNome());
            }

            retorno = "CeRotina002Salva";
        }

        if (rotinaEscolhida.equals("Rotina 003 - Estadual")) {
            setCerotina003(cerotina003Dao.getById(idRotinaEscolhida, emf));
            
            setUsuarioResponsavel(cerotina003.getUsuario().getNome());
            setCpfResponsavel(cerotina003.getUsuario().getCpf());
            if (cerotina003.getDadosEditados().equals("1")) {
                Usuario usuario = usuarioDAO.getById(emf, cerotina003.getUsrResponsavelEdicao());
                setUsuarioEditor(usuario.getNome());
            }

            retorno = "CeRotina003Salva";
        }
        if (rotinaEscolhida.equals("Rotina 004 - Estadual")) {
            setCeRotina004(cerotina004Dao.getById(idRotinaEscolhida, emf));

            setUsuarioResponsavel(ceRotina004.getUsuario().getNome());
            setCpfResponsavel(ceRotina004.getUsuario().getCpf());
            if (ceRotina004.getDadosEditados().equals("1")) {
                Usuario usuario = usuarioDAO.getById(emf, ceRotina004.getUsrResponsavelEdicao());
                setUsuarioEditor(usuario.getNome());
            }

            retorno = "CeRotina004Salva";
        }

        return retorno;
    }

    public String editar() {
    String retorno = "rotina001SomenteLeitura";
    disabled = false;
    if (rotinaEscolhida.equals("Rotina 001")) {
    setRotina001(rotina001Dao.getById(idRotinaEscolhida, emf));
    rotina001_ObterListQ4(rotina001);

    retorno = "rotina001SomenteLeitura";
    }

    if (rotinaEscolhida.equals("Rotina 002")) {
    setRotina002(rotina002Dao.getById(idRotinaEscolhida, emf));
    retorno = "rotina002SomenteLeitura";
    }

    if (rotinaEscolhida.equals("Rotina 002 - Perfil Educadores")) {
    setRotina002PerfilEducadores(rotina002Dao.getPerfilEducadoresById(idRotinaEscolhida, emf));

    obterComponenteCurricular(rotina002PerfilEducadores);
    rotina002PerfilEducadores_ObterListQ8(rotina002PerfilEducadores);
    rotina002PerfilEducadores_ObterListQ11(rotina002PerfilEducadores);
    rotina002PerfilEducadores_ObterListQ13(rotina002PerfilEducadores);
    rotina002PerfilEducadores_ObterListQ14(rotina002PerfilEducadores);

    retorno = "rotina002PerfilEducadoresSomenteLeitura";
    }

    if (rotinaEscolhida.equals("Rotina 002 - Perfil Formadores")) {
    setRotina002PerfilFormadores(rotina002Dao.getPerfilFormadoresById(idRotinaEscolhida, emf));
    retorno = "rotina002PerfilFormadoresSomenteLeitura";
    }

    if (rotinaEscolhida.equals("Rotina 003")) {
    setRotina003(rotina003Dao.getById(idRotinaEscolhida, emf));
    this.listaFichas = rotina003.getListaFichas();
    retorno = "rotina003SomenteLeitura";
    }

    if (rotinaEscolhida.equals("Rotina 004V2")) {
    setRotina004V2(rotina004Dao.getByIdV2(idRotinaEscolhida, emf));
    retorno = "rotina004V2SomenteLeitura";
    }

    if (rotinaEscolhida.equals("Rotina 004")) {
    setRotina004(rotina004Dao.getById(idRotinaEscolhida, emf));
    retorno = "rotina004SomenteLeitura";
    }

    if (rotinaEscolhida.equals("Rotina 005")) {
    setRotina005(rotina005Dao.getById(idRotinaEscolhida, emf));
    retorno = "rotina005SomenteLeitura";
    }

    if (rotinaEscolhida.equals("Rotina 006 - Arcos Ocupacionais")) {
        setRotina006ArcosOcupacionais(rotina006Dao.getArcosOcupacionaisById(idRotinaEscolhida, emf));
        this.isArcoAFechado.add("false");
        this.isArcoBFechado.add("false");
        this.isArcoCFechado.add("false");
        this.isArcoDFechado.add("false");
        this.isArcoEFechado.add("false");

        if (rotina006ArcosOcupacionais.getQ9Fechado() != null && rotina006ArcosOcupacionais.getQ9Fechado().equals("true")) {
            this.isArcoAFechado.add("fechado");
        }
        if (rotina006ArcosOcupacionais.getQ10Fechado() != null && rotina006ArcosOcupacionais.getQ10Fechado().equals("true")) {
            this.isArcoBFechado.add("fechado");
        }
        if (rotina006ArcosOcupacionais.getQ11Fechado() != null && rotina006ArcosOcupacionais.getQ11Fechado().equals("true")) {
            this.isArcoCFechado.add("fechado");
        }
        if (rotina006ArcosOcupacionais.getQ12Fechado() != null && rotina006ArcosOcupacionais.getQ12Fechado().equals("true")) {
            this.isArcoDFechado.add("fechado");
        }
        if (rotina006ArcosOcupacionais.getQ13Fechado() != null && rotina006ArcosOcupacionais.getQ13Fechado().equals("true")) {
            this.isArcoEFechado.add("fechado");
        }

        this.materiais = rotina006ArcosOcupacionais.getQ55();
        retorno = "rotina006ArcosOcupacionaisSomenteLeitura";
    }

    if (rotinaEscolhida.equals("Rotina 006 - Arcos OcupacionaisV3")) {
        setRotina006ArcosOcupacionaisV3(rotina006Dao.getArcosOcupacionaisV3ById(idRotinaEscolhida, emf));
        this.isArcoAFechado.add("false");
        this.isArcoBFechado.add("false");
        this.isArcoCFechado.add("false");
        this.isArcoDFechado.add("false");
        this.isArcoEFechado.add("false");

        if (rotina006ArcosOcupacionaisV3.getQ10Fechado() != null && rotina006ArcosOcupacionaisV3.getQ10Fechado().equals("true")) {
            this.isArcoAFechado.add("fechado");
        }
        if (rotina006ArcosOcupacionaisV3.getQ11Fechado() != null && rotina006ArcosOcupacionaisV3.getQ11Fechado().equals("true")) {
            this.isArcoBFechado.add("fechado");
        }
        if (rotina006ArcosOcupacionaisV3.getQ12Fechado() != null && rotina006ArcosOcupacionaisV3.getQ12Fechado().equals("true")) {
            this.isArcoCFechado.add("fechado");
        }
        if (rotina006ArcosOcupacionaisV3.getQ13Fechado() != null && rotina006ArcosOcupacionaisV3.getQ13Fechado().equals("true")) {
            this.isArcoDFechado.add("fechado");
        }
        if (rotina006ArcosOcupacionaisV3.getQ14Fechado() != null && rotina006ArcosOcupacionaisV3.getQ14Fechado().equals("true")) {
            this.isArcoEFechado.add("fechado");
        }

        retorno = "rotina006ArcosOcupacionaisV3SomenteLeitura";
    }

    if (rotinaEscolhida.equals("Rotina 006 - Coordenacao Local")) {
    setRotina006CoordenacaoLocal(rotina006Dao.getCoordenacaoLocalById(idRotinaEscolhida, emf));
    retorno = "rotina006CoordenacaoLocalSomenteLeitura";
    }

    if (rotinaEscolhida.equals("Rotina 007")) {
    setRotina007(rotina007Dao.getById(idRotinaEscolhida, emf));
    obterComponenteCurricular(rotina007);
    rotina007_ObterListQ6(rotina007);
    retorno = "rotina007SomenteLeitura";
    }

    if (rotinaEscolhida.equals("Rotina 001 - Estadual")) {
    setCerotina001(cerotina001Dao.getById(idRotinaEscolhida, emf));
    retorno = "cerotina001SomenteLeitura";
    }
    if (rotinaEscolhida.equals("Rotina 002 - Estadual")) {
    setCerotina002(cerotina002Dao.getById(idRotinaEscolhida, emf));
    obterComponenteCurricular(cerotina002);
    rotina002Ce_ObterListQ5(cerotina002);
    rotina002Ce_ObterListQ7(cerotina002);
    rotina002Ce_ObterListQ8(cerotina002);
    retorno = "cerotina002SomenteLeitura";
    }
    if (rotinaEscolhida.equals("Rotina 003 - Estadual")) {
    setCerotina003(cerotina003Dao.getById(idRotinaEscolhida, emf));
    retorno = "cerotina003SomenteLeitura";
    }
    if (rotinaEscolhida.equals("Rotina 004 - Estadual")) {
    setCeRotina004(cerotina004Dao.getById(idRotinaEscolhida, emf));
    retorno = "cerotina004SomenteLeitura";
    }

    return retorno;
    }
    
    public String salvar() {
        String retorno = "";

        if (rotinaEscolhida.equals("Rotina 001")) {


            rotina001 = ValidacaoR001.tratarListas(rotina001);

            UsuarioDAO usuarioDAO = new UsuarioDAO();


            Rotina001DAO rotinaDao = new Rotina001DAO();
            retorno = "";
            if (ValidacaoR001.validaRotina(rotina001)) {
                try {
                    rotina001.setUsrResponsavelEdicao(controller.obterUsuarioLogado().getId());
                    rotinaDao.saveRotina001(rotina001, emf, utx);
                    setUsuarioResponsavel(rotina001.getUsuario().getNome());
                    setCpfResponsavel(rotina001.getUsuario().getCpf());
                    if (rotina001.getDadosEditados().equals("1")) {
                        Usuario usuario = usuarioDAO.getById(emf, rotina001.getUsrResponsavelEdicao());
                        setUsuarioEditor(usuario.getNome());
                    }
                    retorno = "Rotina001Salva";
                } catch (Exception ex) {
                    String message = "Houve um erro na gravação dos dados. Sua rotia não foi salva. Por favor, tente novamente.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    ex.printStackTrace();
                    Logger.getLogger(Rotina001Bean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        if (rotinaEscolhida.equals("Rotina 002")) {

            Rotina002DAO rotinaDao = new Rotina002DAO();

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            if (ValidacaoR002.validaRotina(rotina002)) {
                try {
                    rotina002.setUsrResponsavelEdicao(controller.obterUsuarioLogado().getId());
                    rotinaDao.saveRotina002(rotina002, emf, utx);
                    setUsuarioResponsavel(rotina002.getUsuario().getNome());
                    setCpfResponsavel(rotina002.getUsuario().getCpf());
                    if (rotina002.getDadosEditados().equals("1")) {
                        Usuario usuario = usuarioDAO.getById(emf, rotina002.getUsrResponsavelEdicao());
                        setUsuarioEditor(usuario.getNome());
                    }
                    retorno = "Rotina002Salva";
                } catch (Exception ex) {
                    String message = "Houve um erro na gravação dos dados. Sua rotia não foi salva. Por favor, tente novamente.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    ex.printStackTrace();
                    Logger.getLogger(Rotina002Bean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        if (rotinaEscolhida.equals("Rotina 002 - Perfil Educadores")) {

            rotina002PerfilEducadores = ValidacaoPerfilEducadores.tratarListas(rotina002PerfilEducadores);

            Rotina002DAO rotinaDao = new Rotina002DAO();

            UsuarioDAO usuarioDAO = new UsuarioDAO();

            if (ValidacaoPerfilEducadores.validaRotina(rotina002PerfilEducadores)) {
                try {
                    rotina002PerfilEducadores.setUsrResponsavelEdicao(controller.obterUsuarioLogado().getId());
                    rotinaDao.saveRotina002PerfilEducadoresBean(rotina002PerfilEducadores, emf, utx);
                    setUsuarioResponsavel(rotina002PerfilEducadores.getUsuario().getNome());
                    setCpfResponsavel(rotina002PerfilEducadores.getUsuario().getCpf());
                    if (rotina002PerfilEducadores.getDadosEditados().equals("1")) {
                        Usuario usuario = usuarioDAO.getById(emf, rotina002PerfilEducadores.getUsrResponsavelEdicao());
                        setUsuarioEditor(usuario.getNome());
                    }
                    retorno = "Rotina002PerfilEducadoresSalva";
                } catch (Exception ex) {
                    String message = "Houve um erro na gravação dos dados. Sua rotia não foi salva. Por favor, tente novamente.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    ex.printStackTrace();
                }
            }
        }

        if (rotinaEscolhida.equals("Rotina 002 - Perfil Formadores")) {
            Rotina002DAO rotinaDao = new Rotina002DAO();

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            if (ValidacaoPerfilFormadores.validaRotina(rotina002PerfilFormadores)) {
                try {
                    rotina002PerfilFormadores.setUsrResponsavelEdicao(controller.obterUsuarioLogado().getId());
                    rotinaDao.saveRotina002PerfilFormadoresBean(rotina002PerfilFormadores, emf, utx);
                    setUsuarioResponsavel(rotina002PerfilFormadores.getUsuario().getNome());
                    setCpfResponsavel(rotina002PerfilFormadores.getUsuario().getCpf());
                    if (rotina002PerfilFormadores.getDadosEditados().equals("1")) {
                        Usuario usuario = usuarioDAO.getById(emf, rotina002PerfilFormadores.getUsrResponsavelEdicao());
                        setUsuarioEditor(usuario.getNome());
                    }
                    retorno = "Rotina002PerfilFormadoresSalva";
                } catch (Exception ex) {
                    String message = "Houve um erro na gravação dos dados. Sua rotia não foi salva. Por favor, tente novamente.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    ex.printStackTrace();

                }
            }


        }

        if (rotinaEscolhida.equals("Rotina 003")) {
            Rotina003DAO rotinaDao = new Rotina003DAO();

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            if (ValidacaoR003.validaRotina(rotina003)) {
                try {
                    rotina003.setUsrResponsavelEdicao(controller.obterUsuarioLogado().getId());
                    rotinaDao.saveRotina003(rotina003, emf, utx);
                    setUsuarioResponsavel(rotina003.getUsuario().getNome());
                    setCpfResponsavel(rotina003.getUsuario().getCpf());
                    if (rotina003.getDadosEditados().equals("1")) {
                        Usuario usuario = usuarioDAO.getById(emf, rotina003.getUsrResponsavelEdicao());
                        setUsuarioEditor(usuario.getNome());
                    }
                    retorno = "Rotina003Salva";
                } catch (Exception ex) {
                    String message = "Houve um erro na gravação dos dados. Sua rotia não foi salva. Por favor, tente novamente.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    ex.printStackTrace();

                }
            }
        }

        if (rotinaEscolhida.equals("Rotina 004V2")) {
            Rotina004DAO rotinaDao = new Rotina004DAO();

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            if (ValidacaoR004V2.validaRotina(rotina004V2)) {
                try {
                    rotina004V2.setUsrResponsavelEdicao(controller.obterUsuarioLogado().getId());
                    rotinaDao.saveRotina004V2(rotina004V2, emf, utx);
                    setUsuarioResponsavel(rotina004V2.getUsuario().getNome());
                    setCpfResponsavel(rotina004V2.getUsuario().getCpf());
                    if (rotina004V2.getDadosEditados().equals("1")) {
                        Usuario usuario = usuarioDAO.getById(emf, rotina004V2.getUsrResponsavelEdicao());
                        setUsuarioEditor(usuario.getNome());
                    }
                    retorno = "Rotina004V2Salva";
                } catch (Exception ex) {
                    String message = "Houve um erro na gravação dos dados. Sua rotina não foi salva. Por favor, tente novamente.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    ex.printStackTrace();
                    Logger.getLogger(Rotina004BeanV2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        if (rotinaEscolhida.equals("Rotina 004")) {
            Rotina004DAO rotinaDao = new Rotina004DAO();

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            if (ValidacaoR004.validaRotina(rotina004)) {
                try {
                    rotina004.setUsrResponsavelEdicao(controller.obterUsuarioLogado().getId());
                    rotinaDao.saveRotina004(rotina004, emf, utx);
                    setUsuarioResponsavel(rotina004.getUsuario().getNome());
                    setCpfResponsavel(rotina004.getUsuario().getCpf());
                    if (rotina004.getDadosEditados().equals("1")) {
                        Usuario usuario = usuarioDAO.getById(emf, rotina004.getUsrResponsavelEdicao());
                        setUsuarioEditor(usuario.getNome());
                    }
                    retorno = "Rotina004Salva";
                } catch (Exception ex) {
                    String message = "Houve um erro na gravação dos dados. Sua rotina não foi salva. Por favor, tente novamente.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    ex.printStackTrace();
                    Logger.getLogger(Rotina004BeanV2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        if (rotinaEscolhida.equals("Rotina 005")) {
            Rotina005DAO rotinaDao = new Rotina005DAO();

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            if (ValidacaoR005.validaRotina(rotina005)) {
                try {
                    rotina005.setUsrResponsavelEdicao(controller.obterUsuarioLogado().getId());
                    rotinaDao.saveRotina005(rotina005, emf, utx);
                    setUsuarioResponsavel(rotina005.getUsuario().getNome());
                    setCpfResponsavel(rotina005.getUsuario().getCpf());
                    if (rotina005.getDadosEditados().equals("1")) {
                        Usuario usuario = usuarioDAO.getById(emf, rotina005.getUsrResponsavelEdicao());
                        setUsuarioEditor(usuario.getNome());
                    }
                    retorno = "Rotina005Salva";
                } catch (Exception ex) {
                    String message = "Houve um erro na gravação dos dados. Sua rotina não foi salva. Por favor, tente novamente.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    ex.printStackTrace();

                }
            }
        }

        if (rotinaEscolhida.equals("Rotina 006 - Arcos Ocupacionais")) {
            Rotina006DAO rotinaDao = new Rotina006DAO();

            UsuarioDAO usuarioDAO = new UsuarioDAO();

            rotina006ArcosOcupacionais.setQ55(materiais);

            rotina006ArcosOcupacionais.setQ9Fechado("false");
            rotina006ArcosOcupacionais.setQ10Fechado("false");
            rotina006ArcosOcupacionais.setQ11Fechado("false");
            rotina006ArcosOcupacionais.setQ12Fechado("false");
            rotina006ArcosOcupacionais.setQ13Fechado("false");

            if (isArcoAFechado != null && isArcoAFechado.size() > 0 && isArcoAFechado.get(0).equals("fechado")) {
            rotina006ArcosOcupacionais.setQ9Fechado("true");
            }
            if (isArcoBFechado != null && isArcoBFechado.size() > 0 && isArcoBFechado.get(0).equals("fechado")) {
            rotina006ArcosOcupacionais.setQ10Fechado("true");
            }
            if (isArcoCFechado != null && isArcoCFechado.size() > 0 && isArcoCFechado.get(0).equals("fechado")) {
            rotina006ArcosOcupacionais.setQ11Fechado("true");
            }
            if (isArcoDFechado != null && isArcoDFechado.size() > 0 && isArcoDFechado.get(0).equals("fechado")) {
            rotina006ArcosOcupacionais.setQ12Fechado("true");
            }
            if (isArcoEFechado != null && isArcoEFechado.size() > 0 && isArcoEFechado.get(0).equals("fechado")) {
            rotina006ArcosOcupacionais.setQ13Fechado("true");
            }
            
            if (ValidacaoArcosOcupacionais.validaRotina(rotina006ArcosOcupacionais)) {
                try {
                    rotina006ArcosOcupacionais.setUsrResponsavelEdicao(controller.obterUsuarioLogado().getId());
                    rotinaDao.saveRotinaQPArcosOcupacionais(rotina006ArcosOcupacionais, emf, utx);
                    setUsuarioResponsavel(rotina006ArcosOcupacionais.getUsuario().getNome());
                    setCpfResponsavel(rotina006ArcosOcupacionais.getUsuario().getCpf());
                    if (rotina006ArcosOcupacionais.getDadosEditados().equals("1")) {
                        Usuario usuario = usuarioDAO.getById(emf, rotina006ArcosOcupacionais.getUsrResponsavelEdicao());
                        setUsuarioEditor(usuario.getNome());
                    }
                    retorno = "Rotina006ArcosOcupacionaisSalva";
                } catch (Exception ex) {
                    String message = "Houve um erro na gravação dos dados. Sua rotia não foi salva. Por favor, tente novamente.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    ex.printStackTrace();

                }
            }
        }

        if (rotinaEscolhida.equals("Rotina 006 - Arcos OcupacionaisV3")) {
            Rotina006DAO rotinaDao = new Rotina006DAO();

            UsuarioDAO usuarioDAO = new UsuarioDAO();


            rotina006ArcosOcupacionaisV3.setQ10Fechado("false");
            rotina006ArcosOcupacionaisV3.setQ11Fechado("false");
            rotina006ArcosOcupacionaisV3.setQ12Fechado("false");
            rotina006ArcosOcupacionaisV3.setQ13Fechado("false");
            rotina006ArcosOcupacionaisV3.setQ14Fechado("false");

            if (isArcoAFechado != null && isArcoAFechado.size() > 0 && isArcoAFechado.get(0).equals("fechado")) {
            rotina006ArcosOcupacionaisV3.setQ10Fechado("true");
            }
            if (isArcoBFechado != null && isArcoBFechado.size() > 0 && isArcoBFechado.get(0).equals("fechado")) {
            rotina006ArcosOcupacionaisV3.setQ11Fechado("true");
            }
            if (isArcoCFechado != null && isArcoCFechado.size() > 0 && isArcoCFechado.get(0).equals("fechado")) {
            rotina006ArcosOcupacionaisV3.setQ12Fechado("true");
            }
            if (isArcoDFechado != null && isArcoDFechado.size() > 0 && isArcoDFechado.get(0).equals("fechado")) {
            rotina006ArcosOcupacionaisV3.setQ13Fechado("true");
            }
            if (isArcoEFechado != null && isArcoEFechado.size() > 0 && isArcoEFechado.get(0).equals("fechado")) {
            rotina006ArcosOcupacionaisV3.setQ14Fechado("true");
            }

            rotina006ArcosOcupacionaisV3.setQuestionarioEducador(rotina006ArcosOcupacionaisV3.getQuestionarioEducador());

            if (ValidacaoArcosOcupacionaisV3.validaRotina(rotina006ArcosOcupacionaisV3)) {
                try {
                    rotina006ArcosOcupacionaisV3.setUsrResponsavelEdicao(controller.obterUsuarioLogado().getId());
                    rotinaDao.saveRotinaQPArcosOcupacionaisV3(rotina006ArcosOcupacionaisV3, emf, utx);
                    setUsuarioResponsavel(rotina006ArcosOcupacionaisV3.getUsuario().getNome());
                    setCpfResponsavel(rotina006ArcosOcupacionaisV3.getUsuario().getCpf());
                    if (rotina006ArcosOcupacionaisV3.getDadosEditados().equals("1")) {
                        Usuario usuario = usuarioDAO.getById(emf, rotina006ArcosOcupacionaisV3.getUsrResponsavelEdicao());
                        setUsuarioEditor(usuario.getNome());
                    }
                    retorno = "Rotina006ArcosOcupacionaisV3Salva";
                } catch (Exception ex) {
                    String message = "Houve um erro na gravação dos dados. Sua rotia não foi salva. Por favor, tente novamente.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    ex.printStackTrace();

                }
            }
        }

        if (rotinaEscolhida.equals("Rotina 006 - Coordenacao Local")) {
            Rotina006DAO rotinaDao = new Rotina006DAO();

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            if (ValidacaoCoordenacaoLocal.validaRotina(rotina006CoordenacaoLocal)) {
                try {
                    rotina006CoordenacaoLocal.setUsrResponsavelEdicao(controller.obterUsuarioLogado().getId());
                    rotinaDao.saveRotinaQPCoordenacaoLocal(rotina006CoordenacaoLocal, emf, utx);
                    setUsuarioResponsavel(rotina006CoordenacaoLocal.getUsuario().getNome());
                    setCpfResponsavel(rotina006CoordenacaoLocal.getUsuario().getCpf());
                    if (rotina006CoordenacaoLocal.getDadosEditados().equals("1")) {
                        Usuario usuario = usuarioDAO.getById(emf, rotina006CoordenacaoLocal.getUsrResponsavelEdicao());
                        setUsuarioEditor(usuario.getNome());
                    }
                    retorno = "Rotina006CoordenacaoSalva";
                } catch (Exception ex) {
                    String message = "Houve um erro na gravação dos dados. Sua rotina não foi salva. Por favor, tente novamente.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    ex.printStackTrace();

                }
            }
        }

        if (rotinaEscolhida.equals("Rotina 007")) {
            Rotina007DAO rotinaDao = new Rotina007DAO();

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            if (ValidacaoR007.validaRotina(rotina007)) {
                try {
                    rotina007.setUsrResponsavelEdicao(controller.obterUsuarioLogado().getId());
                    rotinaDao.saveRotina007(rotina007, emf, utx);
                    setUsuarioResponsavel(rotina007.getUsuario().getNome());
                    setCpfResponsavel(rotina007.getUsuario().getCpf());
                    if (rotina007.getDadosEditados().equals("1")) {
                        Usuario usuario = usuarioDAO.getById(emf, rotina007.getUsrResponsavelEdicao());
                        setUsuarioEditor(usuario.getNome());
                    }
                    retorno = "Rotina007Salva";
                } catch (Exception ex) {
                    String message = "Houve um erro na gravação dos dados. Sua rotina não foi salva. Por favor, tente novamente.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    ex.printStackTrace();

                }
            }

        }

        if (rotinaEscolhida.equals("Rotina 001 - Estadual")) {
            CeRotina001DAO rotinaDao = new CeRotina001DAO();

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            if (ValidacaoCeR001.validaRotina(cerotina001)) {
                try {
                    cerotina001.setUsrResponsavelEdicao(controller.obterUsuarioLogado().getId());
                    rotinaDao.saveCeRotina001(cerotina001, emf, utx);
                    setUsuarioResponsavel(cerotina001.getUsuario().getNome());
                    setCpfResponsavel(cerotina001.getUsuario().getCpf());
                    if (cerotina001.getDadosEditados().equals("1")) {
                        Usuario usuario = usuarioDAO.getById(emf, cerotina001.getUsrResponsavelEdicao());
                        setUsuarioEditor(usuario.getNome());
                    }
                    retorno = "CeRotina001Salva";
                } catch (Exception ex) {
                    String message = "Houve um erro na gravação dos dados. Sua rotia não foi salva. Por favor, tente novamente.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    ex.printStackTrace();

                }
            }

        }
        if (rotinaEscolhida.equals("Rotina 002 - Estadual")) {
            CeRotina002DAO rotinaDao = new CeRotina002DAO();

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            if (ValidacaoCeR002.validaRotina(cerotina002)) {
                try {
                    cerotina002.setUsrResponsavelEdicao(controller.obterUsuarioLogado().getId());
                    rotinaDao.saveCeRotina002Bean(cerotina002, emf, utx);
                    setUsuarioResponsavel(cerotina002.getUsuario().getNome());
                    setCpfResponsavel(cerotina002.getUsuario().getCpf());
                    if (cerotina002.getDadosEditados().equals("1")) {
                        Usuario usuario = usuarioDAO.getById(emf, cerotina002.getUsrResponsavelEdicao());
                        setUsuarioEditor(usuario.getNome());
                    }
                    retorno = "CeRotina002Salva";
                } catch (Exception ex) {
                    String message = "Houve um erro na gravação dos dados. Sua rotia não foi salva. Por favor, tente novamente.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    ex.printStackTrace();

                }
            }
        }
        if (rotinaEscolhida.equals("Rotina 003 - Estadual")) {
            CeRotina003DAO rotinaDao = new CeRotina003DAO();

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            if (ValidacaoCeR003.validaRotina(cerotina003)) {
                try {
                    cerotina003.setUsrResponsavelEdicao(controller.obterUsuarioLogado().getId());
                    rotinaDao.saveCeRotina003(cerotina003, emf, utx);
                    setUsuarioResponsavel(cerotina003.getUsuario().getNome());
                    setCpfResponsavel(cerotina003.getUsuario().getCpf());
                    if (cerotina003.getDadosEditados().equals("1")) {
                        Usuario usuario = usuarioDAO.getById(emf, cerotina003.getUsrResponsavelEdicao());
                        setUsuarioEditor(usuario.getNome());
                    }
                    retorno = "CeRotina003Salva";
                } catch (Exception ex) {
                    String message = "Houve um erro na gravação dos dados. Sua rotia não foi salva. Por favor, tente novamente.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    ex.printStackTrace();

                }
            }
        }
        if (rotinaEscolhida.equals("Rotina 004 - Estadual")) {
            CeRotina004DAO rotinaDao = new CeRotina004DAO();

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            if (ValidacaoCeR004.validaRotina(ceRotina004)) {
                try {
                    ceRotina004.setUsrResponsavelEdicao(controller.obterUsuarioLogado().getId());
                    rotinaDao.saveCeRotina004(ceRotina004, emf, utx);
                    setUsuarioResponsavel(ceRotina004.getUsuario().getNome());
                    setCpfResponsavel(ceRotina004.getUsuario().getCpf());
                    if (ceRotina004.getDadosEditados().equals("1")) {
                        Usuario usuario = usuarioDAO.getById(emf, ceRotina004.getUsrResponsavelEdicao());
                        setUsuarioEditor(usuario.getNome());
                    }
                    retorno = "CeRotina004Salva";
                } catch (Exception ex) {
                    String message = "Houve um erro na gravação dos dados. Sua rotia não foi salva. Por favor, tente novamente.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    ex.printStackTrace();

                }
            }
        }

        return retorno;
    }

    public void liberarBotao() {
        setRenderedBotaoGerar(true);
    }

    public String gerarRelatorio() {
        FiltrosVo filtros = new FiltrosVo();
        filtros.setCoordenacaoEscolhida(coordenacaoEscolhida);
        filtros.setDataFinalEscolhida(dataFinalEscolhida);
        filtros.setDataInicialEscolhida(dataInicialEscolhida);
        filtros.setEntradaEscolhida(entradaEscolhida);
        filtros.setIrEscolhida(irEscolhida);
        filtros.setSupervisorEscolhida(supervisorEscolhida);
        filtros.setRotinaEscolhida(rotinaEscolhida);
        filtros.setRotinaAguardandoValidacao(rotinaAguardandoValidacao);
        filtros.setMunicipioEscolhida(municipioEscolhida);

        String retorno = "";

        setListaRotinasLancadasVO(rotinasDao.getRotinasVOByFiltros(filtros, emf));
        //String message = "Não existem dados para estes filtros.";
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));

        retorno = "relatorioRotinasLancadas";

        return retorno;
    }

    public void atualizarValidacao() {

        if (rotinaEscolhida.equals("Rotina 001")) {
            getRotina001Bean().validarDados(getValidacao(), idRotinaEscolhida, emf, utx);
        }
        if (rotinaEscolhida.equals("Rotina 002")) {
            getRotina002Bean().validarDados(getValidacao(), idRotinaEscolhida, emf, utx);
        }
        if (rotinaEscolhida.equals("Rotina 002 - Perfil Educadores")) {
            getRotina002PerfilEducadoresBean().validarDados(getValidacao(), idRotinaEscolhida, emf, utx);
        }
        if (rotinaEscolhida.equals("Rotina 002 - Perfil Formadores")) {
            getRotina002PerfilFormadoresBean().validarDados(getValidacao(), idRotinaEscolhida, emf, utx);
        }
        if (rotinaEscolhida.equals("Rotina 003")) {
            getRotina003Bean().validarDados(getValidacao(), idRotinaEscolhida, emf, utx);
        }
        if (rotinaEscolhida.equals("Rotina 004v2")) {
            getRotina004V2Bean().validarDados(getValidacao(), idRotinaEscolhida, emf, utx);
        }
        if (rotinaEscolhida.equals("Rotina 004")) {
            getRotina004Bean().validarDados(getValidacao(), idRotinaEscolhida, emf, utx);
        }
        if (rotinaEscolhida.equals("Rotina 005")) {
            getRotina005Bean().validarDados(getValidacao(), idRotinaEscolhida, emf, utx);
        }
        if (rotinaEscolhida.equals("Rotina 006 - Arcos Ocupacionais")) {
            getRotina006ArcosOcupacionaisBean().validarDados(getValidacao(), idRotinaEscolhida, emf, utx);
        }
        if (rotinaEscolhida.equals("Rotina 006 - Arcos OcupacionaisV3")) {
            getRotina006ArcosOcupacionaisV3Bean().validarDados(getValidacao(), idRotinaEscolhida, emf, utx);
        }
        if (rotinaEscolhida.equals("Rotina 006 - Coordenacao Local")) {
            getRotina006CoordenacaoLocalBean().validarDados(getValidacao(), idRotinaEscolhida, emf, utx);
        }
        if (rotinaEscolhida.equals("Rotina 007")) {
            getRotina007Bean().validarDados(getValidacao(), idRotinaEscolhida, emf, utx);
        }
        if (rotinaEscolhida.equals("Rotina 001 - Estadual")) {
            getCerotina001Bean().validarDados(getValidacao(), idRotinaEscolhida, emf, utx);
        }
        if (rotinaEscolhida.equals("Rotina 002 - Estadual")) {
            getCerotina002Bean().validarDados(getValidacao(), idRotinaEscolhida, emf, utx);
        }
        if (rotinaEscolhida.equals("Rotina 003 - Estadual")) {
            getCerotina003Bean().validarDados(getValidacao(), idRotinaEscolhida, emf, utx);
        }
        if (rotinaEscolhida.equals("Rotina 004 - Estadual")) {
            getCeRotina004Bean().validarDados(getValidacao(), idRotinaEscolhida, emf, utx);
        }

        FiltrosVo filtros = new FiltrosVo();
        filtros.setCoordenacaoEscolhida(coordenacaoEscolhida);
        filtros.setDataFinalEscolhida(dataFinalEscolhida);
        filtros.setDataInicialEscolhida(dataInicialEscolhida);
        filtros.setEntradaEscolhida(entradaEscolhida);
        filtros.setIrEscolhida(irEscolhida);
        filtros.setSupervisorEscolhida(supervisorEscolhida);
        filtros.setRotinaAguardandoValidacao(rotinaAguardandoValidacao);

        setListaRotinasLancadasVO(rotinasDao.getListaRotinas());
        for (int i = 0; i <= listaRotinasLancadasVO.size(); i++) {
            if (listaRotinasLancadasVO.get(i).getIdRotina().equals(idRotinaEscolhida) && listaRotinasLancadasVO.get(i).getRotina().equals(rotinaEscolhida)) {
                listaRotinasLancadasVO.get(i).setDadosValidos(getValidacao());
                if (getValidacao().equals("2")) {
                    listaRotinasLancadasVO.remove(i);
                }
                break;
            }
        }
        //setListaRotinasLancadasVO(rotinasDao.getRotinasVOByFiltros(filtros, emf));
    }

    /**
     * @return the entradas
     */
    public List<SelectItem> getIrs() {
        if (irs != null && irs.size() == 0) {
            List<String> irsPossiveis = new ArrayList<String>();
            irsPossiveis = nucleoDao.obtemIrs(emf);
            for (String ir : irsPossiveis) {
                irs.add(new SelectItem(ir, ir));
            }
        }
        return irs;
    }

    /**
     * @return the irEscolhida
     */
    public String getIrEscolhida() {
        return irEscolhida;
    }

    /**
     * @param irEscolhida the irEscolhida to set
     */
    public void setIrEscolhida(String irEscolhida) {
        this.irEscolhida = irEscolhida;
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
     * @return the listaRotinasLancadasVO
     */
    public List<RotinasLancadasVO> getListaRotinasLancadasVO() {
        return listaRotinasLancadasVO;
    }

    /**
     * @param listaRotinasLancadasVO the listaRotinasLancadasVO to set
     */
    public void setListaRotinasLancadasVO(List<RotinasLancadasVO> listaRotinasLancadasVO) {
        this.listaRotinasLancadasVO = listaRotinasLancadasVO;
    }

    /**
     * @return the idRotinaEscolhida
     */
    public Integer getIdRotinaEscolhida() {
        return idRotinaEscolhida;
    }

    /**
     * @param idRotinaEscolhida the idRotinaEscolhida to set
     */
    public void setIdRotinaEscolhida(Integer idRotinaEscolhida) {
        this.idRotinaEscolhida = idRotinaEscolhida;
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

    /**
     * @return the rotina001
     */
    public Rotina001 getRotina001() {
        return rotina001;
    }

    /**
     * @param rotina001 the rotina001 to set
     */
    public void setRotina001(Rotina001 rotina001) {
        this.rotina001 = rotina001;
    }

    /**
     * @return the rotina002
     */
    public Rotina002 getRotina002() {
        return rotina002;
    }

    /**
     * @param rotina002 the rotina002 to set
     */
    public void setRotina002(Rotina002 rotina002) {
        this.rotina002 = rotina002;
    }

    /**
     * @return the rotina002PerfilEducadores
     */
    public Rotina002PerfilEducadores getRotina002PerfilEducadores() {
        return rotina002PerfilEducadores;
    }

    /**
     * @param rotina002PerfilEducadores the rotina002PerfilEducadores to set
     */
    public void setRotina002PerfilEducadores(Rotina002PerfilEducadores rotina002PerfilEducadores) {
        this.rotina002PerfilEducadores = rotina002PerfilEducadores;
    }

    /**
     * @return the rotina002PerfilFormadores
     */
    public Rotina002PerfilFormadores getRotina002PerfilFormadores() {
        return rotina002PerfilFormadores;
    }

    /**
     * @param rotina002PerfilFormadores the rotina002PerfilFormadores to set
     */
    public void setRotina002PerfilFormadores(Rotina002PerfilFormadores rotina002PerfilFormadores) {
        this.rotina002PerfilFormadores = rotina002PerfilFormadores;
    }

    /**
     * @return the rotina003
     */
    public Rotina003 getRotina003() {
        return rotina003;
    }

    /**
     * @param rotina003 the rotina003 to set
     */
    public void setRotina003(Rotina003 rotina003) {
        this.rotina003 = rotina003;
    }

    /**
     * @return the rotina004
     */
    public Rotina004 getRotina004() {
        return rotina004;
    }

    /**
     * @param rotina004 the rotina004 to set
     */
    public void setRotina004(Rotina004 rotina004) {
        this.rotina004 = rotina004;
    }

    /**
     * @return the rotina005
     */
    public Rotina005 getRotina005() {
        return rotina005;
    }

    /**
     * @param rotina005 the rotina005 to set
     */
    public void setRotina005(Rotina005 rotina005) {
        this.rotina005 = rotina005;
    }

    /**
     * @return the rotina006ArcosOcupacionais
     */
    public Rotina006ArcosOcupacionais getRotina006ArcosOcupacionais() {
        return rotina006ArcosOcupacionais;
    }

    /**
     * @param rotina006ArcosOcupacionais the rotina006ArcosOcupacionais to set
     */
    public void setRotina006ArcosOcupacionais(Rotina006ArcosOcupacionais rotina006ArcosOcupacionais) {
        this.rotina006ArcosOcupacionais = rotina006ArcosOcupacionais;
    }

    /**
     * @return the rotina006CoordenacaoLocal
     */
    public Rotina006CoordenacaoLocal getRotina006CoordenacaoLocal() {
        return rotina006CoordenacaoLocal;
    }

    /**
     * @param rotina006CoordenacaoLocal the rotina006CoordenacaoLocal to set
     */
    public void setRotina006CoordenacaoLocal(Rotina006CoordenacaoLocal rotina006CoordenacaoLocal) {
        this.rotina006CoordenacaoLocal = rotina006CoordenacaoLocal;
    }

    /**
     * @return the rotina007
     */
    public Rotina007 getRotina007() {
        return rotina007;
    }

    /**
     * @param rotina007 the rotina007 to set
     */
    public void setRotina007(Rotina007 rotina007) {
        this.rotina007 = rotina007;
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
     * @return the entradas
     */
    public List<SelectItem> getEntradas() {
        return entradas;
    }

    /**
     * @param entradas the entradas to set
     */
    public void setEntradas(List<SelectItem> entradas) {
        this.entradas = entradas;
    }

    /**
     * @return the supervidores
     */
    public List<SelectItem> getSupervidores() {
        if (supervidores == null) {
            if (!usuarioLogado.getPerfil().equals("1")) {
                supervidores = usuarioDao.getByIrAndPerfil(emf, usuarioLogado.getIr());
            }
        }


        return supervidores;
    }

    /**
     * @param supervidores the supervidores to set
     */
    public void setSupervidores(List<SelectItem> supervidores) {
        this.supervidores = supervidores;
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
     * @return the supervisorEscolhida
     */
    public String getSupervisorEscolhida() {
        return supervisorEscolhida;
    }

    /**
     * @param supervisorEscolhida the supervisorEscolhida to set
     */
    public void setSupervisorEscolhida(String supervisorEscolhida) {
        this.supervisorEscolhida = supervisorEscolhida;
    }

    /**
     * @return the dataInicialEscolhida
     */
    public String getDataInicialEscolhida() {
        return dataInicialEscolhida;
    }

    /**
     * @param dataInicialEscolhida the dataInicialEscolhida to set
     */
    public void setDataInicialEscolhida(String dataInicialEscolhida) {
        this.dataInicialEscolhida = dataInicialEscolhida;
    }

    /**
     * @return the dataFinalEscolhida
     */
    public String getDataFinalEscolhida() {
        return dataFinalEscolhida;
    }

    /**
     * @param dataFinalEscolhida the dataFinalEscolhida to set
     */
    public void setDataFinalEscolhida(String dataFinalEscolhida) {
        this.dataFinalEscolhida = dataFinalEscolhida;
    }

    /**
     * @return the validacao
     */
    public String getValidacao() {
        return validacao;
    }

    /**
     * @param validacao the validacao to set
     */
    public void setValidacao(String validacao) {
        this.validacao = validacao;
    }

    /**
     * @return the rotina001Bean
     */
    public Rotina001Bean getRotina001Bean() {
        return rotina001Bean;
    }

    /**
     * @param rotina001Bean the rotina001Bean to set
     */
    public void setRotina001Bean(Rotina001Bean rotina001Bean) {
        this.rotina001Bean = rotina001Bean;
    }

    /**
     * @return the rotina002Bean
     */
    public Rotina002Bean getRotina002Bean() {
        return rotina002Bean;
    }

    /**
     * @param rotina002Bean the rotina002Bean to set
     */
    public void setRotina002Bean(Rotina002Bean rotina002Bean) {
        this.rotina002Bean = rotina002Bean;
    }

    /**
     * @return the rotina002PerfilFormadoresBean
     */
    public Rotina002PerfilFormadoresBean getRotina002PerfilFormadoresBean() {
        return rotina002PerfilFormadoresBean;
    }

    /**
     * @param rotina002PerfilFormadoresBean the rotina002PerfilFormadoresBean to set
     */
    public void setRotina002PerfilFormadoresBean(Rotina002PerfilFormadoresBean rotina002PerfilFormadoresBean) {
        this.rotina002PerfilFormadoresBean = rotina002PerfilFormadoresBean;
    }

    /**
     * @return the rotina002PerfilEducadoresBean
     */
    public Rotina002PerfilEducadoresBean getRotina002PerfilEducadoresBean() {
        return rotina002PerfilEducadoresBean;
    }

    /**
     * @param rotina002PerfilEducadoresBean the rotina002PerfilEducadoresBean to set
     */
    public void setRotina002PerfilEducadoresBean(Rotina002PerfilEducadoresBean rotina002PerfilEducadoresBean) {
        this.rotina002PerfilEducadoresBean = rotina002PerfilEducadoresBean;
    }

    /**
     * @return the rotina003Bean
     */
    public Rotina003Bean getRotina003Bean() {
        return rotina003Bean;
    }

    /**
     * @param rotina003Bean the rotina003Bean to set
     */
    public void setRotina003Bean(Rotina003Bean rotina003Bean) {
        this.rotina003Bean = rotina003Bean;
    }

    /**
     * @return the rotina004BeanV2
     */
    public Rotina004BeanV2 getRotina004V2Bean() {
        return rotina004BeanV2;
    }

    /**
     * @param rotina004BeanV2 the rotina004BeanV2 to set
     */
    public void setRotina004V2Bean(Rotina004BeanV2 rotina004BeanV2) {
        this.rotina004BeanV2 = rotina004BeanV2;
    }

    /**
     * @return the rotina005Bean
     */
    public Rotina005Bean getRotina005Bean() {
        return rotina005Bean;
    }

    /**
     * @param rotina005Bean the rotina005Bean to set
     */
    public void setRotina005Bean(Rotina005Bean rotina005Bean) {
        this.rotina005Bean = rotina005Bean;
    }

    /**
     * @return the rotina006ArcosOcupacionaisBean
     */
    public Rotina006ArcosOcupacionaisBean getRotina006ArcosOcupacionaisBean() {
        return rotina006ArcosOcupacionaisBean;
    }

    /**
     * @param rotina006ArcosOcupacionaisBean the rotina006ArcosOcupacionaisBean to set
     */
    public void setRotina006ArcosOcupacionaisBean(Rotina006ArcosOcupacionaisBean rotina006ArcosOcupacionaisBean) {
        this.rotina006ArcosOcupacionaisBean = rotina006ArcosOcupacionaisBean;
    }

    /**
     * @return the rotina006CoordenacaoLocalBean
     */
    public Rotina006CoordenacaoLocalBean getRotina006CoordenacaoLocalBean() {
        return rotina006CoordenacaoLocalBean;
    }

    /**
     * @param rotina006CoordenacaoLocalBean the rotina006CoordenacaoLocalBean to set
     */
    public void setRotina006CoordenacaoLocalBean(Rotina006CoordenacaoLocalBean rotina006CoordenacaoLocalBean) {
        this.rotina006CoordenacaoLocalBean = rotina006CoordenacaoLocalBean;
    }

    /**
     * @return the rotina007Bean
     */
    public Rotina007Bean getRotina007Bean() {
        return rotina007Bean;
    }

    /**
     * @param rotina007Bean the rotina007Bean to set
     */
    public void setRotina007Bean(Rotina007Bean rotina007Bean) {
        this.rotina007Bean = rotina007Bean;
    }

    /**
     * @return the cerotina001Dao
     */
    public CeRotina001DAO getCerotina001Dao() {
        return cerotina001Dao;
    }

    /**
     * @param cerotina001Dao the cerotina001Dao to set
     */
    public void setCerotina001Dao(CeRotina001DAO cerotina001Dao) {
        this.cerotina001Dao = cerotina001Dao;
    }

    /**
     * @return the cerotina002Dao
     */
    public CeRotina002DAO getCerotina002Dao() {
        return cerotina002Dao;
    }

    /**
     * @param cerotina002Dao the cerotina002Dao to set
     */
    public void setCerotina002Dao(CeRotina002DAO cerotina002Dao) {
        this.cerotina002Dao = cerotina002Dao;
    }

    /**
     * @return the cerotina003Dao
     */
    public CeRotina003DAO getCerotina003Dao() {
        return cerotina003Dao;
    }

    /**
     * @param cerotina003Dao the cerotina003Dao to set
     */
    public void setCerotina003Dao(CeRotina003DAO cerotina003Dao) {
        this.cerotina003Dao = cerotina003Dao;
    }

    /**
     * @return the cerotina001
     */
    public CeRotina001 getCerotina001() {
        return cerotina001;
    }

    /**
     * @param cerotina001 the cerotina001 to set
     */
    public void setCerotina001(CeRotina001 cerotina001) {
        this.cerotina001 = cerotina001;
    }

    /**
     * @return the cerotina002
     */
    public CeRotina002 getCerotina002() {
        return cerotina002;
    }

    /**
     * @param cerotina002 the cerotina002 to set
     */
    public void setCerotina002(CeRotina002 cerotina002) {
        this.cerotina002 = cerotina002;
    }

    /**
     * @return the cerotina003
     */
    public CeRotina003 getCerotina003() {
        return cerotina003;
    }

    /**
     * @param cerotina003 the cerotina003 to set
     */
    public void setCerotina003(CeRotina003 cerotina003) {
        this.cerotina003 = cerotina003;
    }

    /**
     * @return the cerotina001Bean
     */
    public CeRotina001Bean getCerotina001Bean() {
        return cerotina001Bean;
    }

    /**
     * @param cerotina001Bean the cerotina001Bean to set
     */
    public void setCerotina001Bean(CeRotina001Bean cerotina001Bean) {
        this.cerotina001Bean = cerotina001Bean;
    }

    /**
     * @return the cerotina002Bean
     */
    public CeRotina002Bean getCerotina002Bean() {
        return cerotina002Bean;
    }

    /**
     * @param cerotina002Bean the cerotina002Bean to set
     */
    public void setCerotina002Bean(CeRotina002Bean cerotina002Bean) {
        this.cerotina002Bean = cerotina002Bean;
    }

    /**
     * @return the cerotina003Bean
     */
    public CeRotina003Bean getCerotina003Bean() {
        return cerotina003Bean;
    }

    /**
     * @param cerotina003Bean the cerotina003Bean to set
     */
    public void setCerotina003Bean(CeRotina003Bean cerotina003Bean) {
        this.cerotina003Bean = cerotina003Bean;
    }

    /**
     * @return the rotinaAguardandoValidacao
     */
    public boolean getRotinaAguardandoValidacao() {
        return rotinaAguardandoValidacao;
    }

    /**
     * @param rotinaAguardandoValidacao the rotinaAguardandoValidacao to set
     */
    public void setRotinaAguardandoValidacao(boolean rotinaAguardandoValidacao) {
        this.rotinaAguardandoValidacao = rotinaAguardandoValidacao;
    }

    /**
     * @return the listRotinaAguardandoValidacao
     */
    public List<String> getListRotinaAguardandoValidacao() {
        return listRotinaAguardandoValidacao;
    }

    /**
     * @param listRotinaAguardandoValidacao the listRotinaAguardandoValidacao to set
     */
    public void setListRotinaAguardandoValidacao(List<String> listRotinaAguardandoValidacao) {
        this.listRotinaAguardandoValidacao = listRotinaAguardandoValidacao;
    }

    public CeRotina004 getCeRotina004() {
        return ceRotina004;
    }

    public void setCeRotina004(CeRotina004 ceRotina004) {
        this.ceRotina004 = ceRotina004;
    }

    public CeRotina004Bean getCeRotina004Bean() {
        return ceRotina004Bean;
    }

    public void setCeRotina004Bean(CeRotina004Bean ceRotina004Bean) {
        this.ceRotina004Bean = ceRotina004Bean;
    }

    /**
     * @return the disabled
     */
    public boolean isDisabled() {
        return disabled;
    }

    /**
     * @param disabled the disabled to set
     */
    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    private void rotina002PerfilEducadores_ObterListQ8(Rotina002PerfilEducadores rotina002PerfilEducadores) {
        if (rotina002PerfilEducadores.getQ8NuncaLecionei() != null && rotina002PerfilEducadores.getQ8NuncaLecionei().equals("Sim")) {
            rotina002PerfilEducadores.getListQ8().add("Q8NuncaLecionei");
        }
        if (rotina002PerfilEducadores.getQ8EducacaoInfantil() != null && rotina002PerfilEducadores.getQ8EducacaoInfantil().equals("Sim")) {
            rotina002PerfilEducadores.getListQ8().add("Q8EducacaoInfantil");
        }
        if (rotina002PerfilEducadores.getQ8EnsinoFundamental() != null && rotina002PerfilEducadores.getQ8EnsinoFundamental().equals("Sim")) {
            rotina002PerfilEducadores.getListQ8().add("Q8EnsinoFundamental");
        }
        if (rotina002PerfilEducadores.getQ8EnsinoMedio() != null && rotina002PerfilEducadores.getQ8EnsinoMedio().equals("Sim")) {
            rotina002PerfilEducadores.getListQ8().add("Q8EnsinoMedio");
        }
        if (rotina002PerfilEducadores.getQ8EducacaoJovensAdultos() != null && rotina002PerfilEducadores.getQ8EducacaoJovensAdultos().equals("Sim")) {
            rotina002PerfilEducadores.getListQ8().add("Q8EducacaoJovensAdultos");
        }
        if (rotina002PerfilEducadores.getQ8EnsinoTecnicoProfissionalizante() != null && rotina002PerfilEducadores.getQ8EnsinoTecnicoProfissionalizante().equals("Sim")) {
            rotina002PerfilEducadores.getListQ8().add("Q8EnsinoTecnicoProfissionalizante");
        }
        if (rotina002PerfilEducadores.getQ8EnsinoSuperior() != null && rotina002PerfilEducadores.getQ8EnsinoSuperior().equals("Sim")) {
            rotina002PerfilEducadores.getListQ8().add("Q8EnsinoSuperior");
        }
        if (rotina002PerfilEducadores.getQ8Outros() != null && rotina002PerfilEducadores.getQ8Outros().equals("Sim")) {
            rotina002PerfilEducadores.getListQ8().add("Q8Outros");
        }

    }

    private void rotina002Ce_ObterListQ5(CeRotina002 rotina002) {
        if (rotina002.getQ5NuncaLecionei() != null && rotina002.getQ5NuncaLecionei().equals("Sim")) {
            rotina002.getListQ5().add("Q5NuncaLecionei");
        }
        if (rotina002.getQ5EducacaoInfantil() != null && rotina002.getQ5EducacaoInfantil().equals("Sim")) {
            rotina002.getListQ5().add("Q5EducacaoInfantil");
        }
        if (rotina002.getQ5EnsinoFundamental() != null && rotina002.getQ5EnsinoFundamental().equals("Sim")) {
            rotina002.getListQ5().add("Q5EnsinoFundamental");
        }
        if (rotina002.getQ5EnsinoMedio() != null && rotina002.getQ5EnsinoMedio().equals("Sim")) {
            rotina002.getListQ5().add("Q5EnsinoMedio");
        }
        if (rotina002.getQ5EducacaoJovensAdultos() != null && rotina002.getQ5EducacaoJovensAdultos().equals("Sim")) {
            rotina002.getListQ5().add("Q5EducacaoJovensAdultos");
        }
        if (rotina002.getQ5EnsinoTecnicoProfissionalizante() != null && rotina002.getQ5EnsinoTecnicoProfissionalizante().equals("Sim")) {
            rotina002.getListQ5().add("Q5EnsinoTecnicoProfissionalizante");
        }
        if (rotina002.getQ5EnsinoSuperior() != null && rotina002.getQ5EnsinoSuperior().equals("Sim")) {
            rotina002.getListQ5().add("Q5EnsinoSuperior");
        }
        if (rotina002.getQ5Outros() != null && rotina002.getQ5Outros().equals("Sim")) {
            rotina002.getListQ5().add("Q5Outros");
        }

    }

    private void obterComponenteCurricular(Rotina002PerfilEducadores rotina002PerfilEducadores) {
        if (rotina002PerfilEducadores.getComponenteCurricularLinguaPortuguesa() != null && rotina002PerfilEducadores.getComponenteCurricularLinguaPortuguesa().equals("Sim")) {
            rotina002PerfilEducadores.getListComponenteCurricular().add("componenteCurricularLinguaPortuguesa");
        }
        if (rotina002PerfilEducadores.getComponenteCurricularMatematica() != null && rotina002PerfilEducadores.getComponenteCurricularMatematica().equals("Sim")) {
            rotina002PerfilEducadores.getListComponenteCurricular().add("componenteCurricularMatematica");
        }
        if (rotina002PerfilEducadores.getComponenteCurricularCienciasNatureza() != null && rotina002PerfilEducadores.getComponenteCurricularCienciasNatureza().equals("Sim")) {
            rotina002PerfilEducadores.getListComponenteCurricular().add("componenteCurricularCienciasNatureza");
        }
        if (rotina002PerfilEducadores.getComponenteCurricularQualificacaoProfissional() != null && rotina002PerfilEducadores.getComponenteCurricularQualificacaoProfissional().equals("Sim")) {
            rotina002PerfilEducadores.getListComponenteCurricular().add("componenteCurricularQualificacaoProfissional");
        }
        if (rotina002PerfilEducadores.getComponenteCurricularLinguaEstrangeira() != null && rotina002PerfilEducadores.getComponenteCurricularLinguaEstrangeira().equals("Sim")) {
            rotina002PerfilEducadores.getListComponenteCurricular().add("componenteCurricularLinguaEstrangeira");
        }
        if (rotina002PerfilEducadores.getComponenteCurricularCienciasHumanas() != null && rotina002PerfilEducadores.getComponenteCurricularCienciasHumanas().equals("Sim")) {
            rotina002PerfilEducadores.getListComponenteCurricular().add("componenteCurricularCienciasHumanas");
        }
        if (rotina002PerfilEducadores.getComponenteCurricularParticipacaoCidada() != null && rotina002PerfilEducadores.getComponenteCurricularParticipacaoCidada().equals("Sim")) {
            rotina002PerfilEducadores.getListComponenteCurricular().add("componenteCurricularParticipacaoCidada");
        }
    }

    private void obterComponenteCurricular(CeRotina002 rotina002) {
        if (rotina002.getComponenteCurricularLinguaPortuguesa() != null && rotina002.getComponenteCurricularLinguaPortuguesa().equals("Sim")) {
            rotina002.getListComponenteCurricular().add("componenteCurricularLinguaPortuguesa");
        }
        if (rotina002.getComponenteCurricularMatematica() != null && rotina002.getComponenteCurricularMatematica().equals("Sim")) {
            rotina002.getListComponenteCurricular().add("componenteCurricularMatematica");
        }
        if (rotina002.getComponenteCurricularCienciasNatureza() != null && rotina002.getComponenteCurricularCienciasNatureza().equals("Sim")) {
            rotina002.getListComponenteCurricular().add("componenteCurricularCienciasNatureza");
        }
        if (rotina002.getComponenteCurricularQualificacaoProfissional() != null && rotina002.getComponenteCurricularQualificacaoProfissional().equals("Sim")) {
            rotina002.getListComponenteCurricular().add("componenteCurricularQualificacaoProfissional");
        }
        if (rotina002.getComponenteCurricularLinguaEstrangeira() != null && rotina002.getComponenteCurricularLinguaEstrangeira().equals("Sim")) {
            rotina002.getListComponenteCurricular().add("componenteCurricularLinguaEstrangeira");
        }
        if (rotina002.getComponenteCurricularCienciasHumanas() != null && rotina002.getComponenteCurricularCienciasHumanas().equals("Sim")) {
            rotina002.getListComponenteCurricular().add("componenteCurricularCienciasHumanas");
        }
        if (rotina002.getComponenteCurricularParticipacaoCidada() != null && rotina002.getComponenteCurricularParticipacaoCidada().equals("Sim")) {
            rotina002.getListComponenteCurricular().add("componenteCurricularParticipacaoCidada");
        }
    }

    private void obterComponenteCurricular(Rotina007 rotina007) {
        if (rotina007.getComponenteCurricularLinguaPortuguesa() != null && rotina007.getComponenteCurricularLinguaPortuguesa().equals("Sim")) {
            rotina007.getListComponenteCurricular().add("componenteCurricularLinguaPortuguesa");
        }
        if (rotina007.getComponenteCurricularMatematica() != null && rotina007.getComponenteCurricularMatematica().equals("Sim")) {
            rotina007.getListComponenteCurricular().add("componenteCurricularMatematica");
        }
        if (rotina007.getComponenteCurricularCienciasNatureza() != null && rotina007.getComponenteCurricularCienciasNatureza().equals("Sim")) {
            rotina007.getListComponenteCurricular().add("componenteCurricularCienciasNatureza");
        }
        if (rotina007.getComponenteCurricularQualificacaoProfissional() != null && rotina007.getComponenteCurricularQualificacaoProfissional().equals("Sim")) {
            rotina007.getListComponenteCurricular().add("componenteCurricularQualificacaoProfissional");
        }
        if (rotina007.getComponenteCurricularLinguaEstrangeira() != null && rotina007.getComponenteCurricularLinguaEstrangeira().equals("Sim")) {
            rotina007.getListComponenteCurricular().add("componenteCurricularLinguaEstrangeira");
        }
        if (rotina007.getComponenteCurricularCienciasHumanas() != null && rotina007.getComponenteCurricularCienciasHumanas().equals("Sim")) {
            rotina007.getListComponenteCurricular().add("componenteCurricularCienciasHumanas");
        }
        if (rotina007.getComponenteCurricularParticipacaoCidada() != null && rotina007.getComponenteCurricularParticipacaoCidada().equals("Sim")) {
            rotina007.getListComponenteCurricular().add("componenteCurricularParticipacaoCidada");
        }
    }

    private void rotina002PerfilEducadores_ObterListQ11(Rotina002PerfilEducadores rotina002PerfilEducadores) {
        if (rotina002PerfilEducadores.getQ11Convite() != null && rotina002PerfilEducadores.getQ11Convite().equals("Sim")) {
            rotina002PerfilEducadores.getListQ11().add("Q11Convite");
        }
        if (rotina002PerfilEducadores.getQ11AvaliacaoCurrículo() != null && rotina002PerfilEducadores.getQ11AvaliacaoCurrículo().equals("Sim")) {
            rotina002PerfilEducadores.getListQ11().add("Q11AvaliacaoCurrículo");
        }
        if (rotina002PerfilEducadores.getQ11Entrevista() != null && rotina002PerfilEducadores.getQ11Entrevista().equals("Sim")) {
            rotina002PerfilEducadores.getListQ11().add("Q11Entrevista");
        }
        if (rotina002PerfilEducadores.getQ11ProvaEscrita() != null && rotina002PerfilEducadores.getQ11ProvaEscrita().equals("Sim")) {
            rotina002PerfilEducadores.getListQ11().add("Q11ProvaEscrita");
        }
        if (rotina002PerfilEducadores.getQ11Desempenho() != null && rotina002PerfilEducadores.getQ11Desempenho().equals("Sim")) {
            rotina002PerfilEducadores.getListQ11().add("Q11Desempenho");
        }
    }

    private void rotina002Ce_ObterListQ7(CeRotina002 rotina002) {
        if (rotina002.getQ7Convite() != null && rotina002.getQ7Convite().equals("Sim")) {
            rotina002.getListQ7().add("Q7Convite");
        }
        if (rotina002.getQ7AvaliacaoCurrículo() != null && rotina002.getQ7AvaliacaoCurrículo().equals("Sim")) {
            rotina002.getListQ7().add("Q7AvaliacaoCurrículo");
        }
        if (rotina002.getQ7Entrevista() != null && rotina002.getQ7Entrevista().equals("Sim")) {
            rotina002.getListQ7().add("Q7Entrevista");
        }
        if (rotina002.getQ7ProvaEscrita() != null && rotina002.getQ7ProvaEscrita().equals("Sim")) {
            rotina002.getListQ7().add("Q7ProvaEscrita");
        }
        if (rotina002.getQ7Desempenho() != null && rotina002.getQ7Desempenho().equals("Sim")) {
            rotina002.getListQ7().add("Q7Desempenho");
        }
    }

    private void rotina002PerfilEducadores_ObterListQ13(Rotina002PerfilEducadores rotina002PerfilEducadores) {
        if (rotina002PerfilEducadores.getQ13a() != null && rotina002PerfilEducadores.getQ13a().equals("Sim")) {
            rotina002PerfilEducadores.getListQ13().add("a");
        }
        if (rotina002PerfilEducadores.getQ13b() != null && rotina002PerfilEducadores.getQ13b().equals("Sim")) {
            rotina002PerfilEducadores.getListQ13().add("b");
        }
        if (rotina002PerfilEducadores.getQ13c() != null && rotina002PerfilEducadores.getQ13c().equals("Sim")) {
            rotina002PerfilEducadores.getListQ13().add("c");
        }
        if (rotina002PerfilEducadores.getQ13d() != null && rotina002PerfilEducadores.getQ13d().equals("Sim")) {
            rotina002PerfilEducadores.getListQ13().add("d");
        }
        if (rotina002PerfilEducadores.getQ13e() != null && rotina002PerfilEducadores.getQ13e().equals("Sim")) {
            rotina002PerfilEducadores.getListQ13().add("e");
        }

    }

    private void rotina002PerfilEducadores_ObterListQ14(Rotina002PerfilEducadores rotina002PerfilEducadores) {
        if (rotina002PerfilEducadores.getQ14a() != null && rotina002PerfilEducadores.getQ14a().equals("Sim")) {
            rotina002PerfilEducadores.getListQ14().add("a");
        }
        if (rotina002PerfilEducadores.getQ14b() != null && rotina002PerfilEducadores.getQ14b().equals("Sim")) {
            rotina002PerfilEducadores.getListQ14().add("b");
        }
        if (rotina002PerfilEducadores.getQ14c() != null && rotina002PerfilEducadores.getQ14c().equals("Sim")) {
            rotina002PerfilEducadores.getListQ14().add("c");
        }
        if (rotina002PerfilEducadores.getQ14d() != null && rotina002PerfilEducadores.getQ14d().equals("Sim")) {
            rotina002PerfilEducadores.getListQ14().add("d");
        }
        if (rotina002PerfilEducadores.getQ14e() != null && rotina002PerfilEducadores.getQ14e().equals("Sim")) {
            rotina002PerfilEducadores.getListQ14().add("e");
        }
        if (rotina002PerfilEducadores.getQ14f() != null && rotina002PerfilEducadores.getQ14f().equals("Sim")) {
            rotina002PerfilEducadores.getListQ14().add("f");
        }
        if (rotina002PerfilEducadores.getQ14g() != null && rotina002PerfilEducadores.getQ14g().equals("Sim")) {
            rotina002PerfilEducadores.getListQ14().add("g");
        }
        if (rotina002PerfilEducadores.getQ14h() != null && rotina002PerfilEducadores.getQ14h().equals("Sim")) {
            rotina002PerfilEducadores.getListQ14().add("h");
        }
        if (rotina002PerfilEducadores.getQ14i() != null && rotina002PerfilEducadores.getQ14i().equals("Sim")) {
            rotina002PerfilEducadores.getListQ14().add("i");
        }
    }

    private void rotina002Ce_ObterListQ8(CeRotina002 rotina002) {
        if (rotina002.getQ8a() != null && rotina002.getQ8a().equals("Sim")) {
            rotina002.getListQ8().add("a");
        }
        if (rotina002.getQ8b() != null && rotina002.getQ8b().equals("Sim")) {
            rotina002.getListQ8().add("b");
        }
        if (rotina002.getQ8c() != null && rotina002.getQ8c().equals("Sim")) {
            rotina002.getListQ8().add("c");
        }
        if (rotina002.getQ8d() != null && rotina002.getQ8d().equals("Sim")) {
            rotina002.getListQ8().add("d");
        }
        if (rotina002.getQ8e() != null && rotina002.getQ8e().equals("Sim")) {
            rotina002.getListQ8().add("e");
        }
        if (rotina002.getQ8f() != null && rotina002.getQ8f().equals("Sim")) {
            rotina002.getListQ8().add("f");
        }
        if (rotina002.getQ8g() != null && rotina002.getQ8g().equals("Sim")) {
            rotina002.getListQ8().add("g");
        }
        if (rotina002.getQ8h() != null && rotina002.getQ8h().equals("Sim")) {
            rotina002.getListQ8().add("h");
        }
        if (rotina002.getQ8i() != null && rotina002.getQ8i().equals("Sim")) {
            rotina002.getListQ8().add("i");
        }
    }

    private void rotina007_ObterListQ6(Rotina007 rotina007) {
        if (rotina007.getQ6a() != null && rotina007.getQ6a().equals("Sim")) {
            rotina007.getListQ6().add("a");
        }
        if (rotina007.getQ6b() != null && rotina007.getQ6b().equals("Sim")) {
            rotina007.getListQ6().add("b");
        }
        if (rotina007.getQ6c() != null && rotina007.getQ6c().equals("Sim")) {
            rotina007.getListQ6().add("c");
        }
        if (rotina007.getQ6d() != null && rotina007.getQ6d().equals("Sim")) {
            rotina007.getListQ6().add("d");
        }
        if (rotina007.getQ6e() != null && rotina007.getQ6e().equals("Sim")) {
            rotina007.getListQ6().add("e");
        }
        if (rotina007.getQ6f() != null && rotina007.getQ6f().equals("Sim")) {
            rotina007.getListQ6().add("f");
        }
        if (rotina007.getQ6g() != null && rotina007.getQ6g().equals("Sim")) {
            rotina007.getListQ6().add("g");
        }

    }

    private void rotina001_ObterListQ4(Rotina001 rotina001) {
        if (rotina001.getQ4InternetBandaLarga() != null && rotina001.getQ4InternetBandaLarga().equals("Sim")) {
            rotina001.getListQ4().add("bandaLarga");
        }
        if (rotina001.getQ4InternetDiscada() != null && rotina001.getQ4InternetDiscada().equals("Sim")) {
            rotina001.getListQ4().add("discada");
        }
        if (rotina001.getQ4NaoHavia() != null && rotina001.getQ4NaoHavia().equals("Sim")) {
            rotina001.getListQ4().add("naoHavia");
        }
        if (rotina001.getQ4OutrasFormas() != null && rotina001.getQ4OutrasFormas().equals("Sim")) {
            rotina001.getListQ4().add("outras");
        }
    }

    /**
     * @return the usuarioResponsavel
     */
    public String getUsuarioResponsavel() {
        return usuarioResponsavel;
    }

    /**
     * @param usuarioResponsavel the usuarioResponsavel to set
     */
    public void setUsuarioResponsavel(String usuarioResponsavel) {
        this.usuarioResponsavel = usuarioResponsavel;
    }

    /**
     * @return the cpfResponsavel
     */
    public String getCpfResponsavel() {
        return cpfResponsavel;
    }

    /**
     * @param cpfResponsavel the cpfResponsavel to set
     */
    public void setCpfResponsavel(String cpfResponsavel) {
        this.cpfResponsavel = cpfResponsavel;
    }

    /**
     * @return the usuarioEditor
     */
    public String getUsuarioEditor() {
        return usuarioEditor;
    }

    /**
     * @param usuarioEditor the usuarioEditor to set
     */
    public void setUsuarioEditor(String usuarioEditor) {
        this.usuarioEditor = usuarioEditor;
    }

    /**
     * @return the materilUtilizado
     */
    public MaterialUtilizado getMaterilUtilizado() {
        return materilUtilizado;
    }

    /**
     * @param materilUtilizado the materilUtilizado to set
     */
    public void setMaterilUtilizado(MaterialUtilizado materilUtilizado) {
        this.materilUtilizado = materilUtilizado;
    }

    /**
     * @return the nucleo
     */
    public Nucleo getNucleo() {
        return nucleo;
    }

    /**
     * @param nucleo the nucleo to set
     */
    public void setNucleo(Nucleo nucleo) {
        this.nucleo = nucleo;
    }

    /**
     * @return the listaMaterialUtilizado
     */
    public List<MaterialUtilizado> getListaMaterialUtilizado() {
        return listaMaterialUtilizado;
    }

    /**
     * @param listaMaterialUtilizado the listaMaterialUtilizado to set
     */
    public void setListaMaterialUtilizado(List<MaterialUtilizado> listaMaterialUtilizado) {
        this.listaMaterialUtilizado = listaMaterialUtilizado;
    }

    /**
     * @return the isArcoAFechado
     */
    public List<String> getIsArcoAFechado() {
        return isArcoAFechado;
    }

    /**
     * @param isArcoAFechado the isArcoAFechado to set
     */
    public void setIsArcoAFechado(List<String> isArcoAFechado) {
        this.isArcoAFechado = isArcoAFechado;
    }

    /**
     * @return the isArcoBFechado
     */
    public List<String> getIsArcoBFechado() {
        return isArcoBFechado;
    }

    /**
     * @param isArcoBFechado the isArcoBFechado to set
     */
    public void setIsArcoBFechado(List<String> isArcoBFechado) {
        this.isArcoBFechado = isArcoBFechado;
    }

    /**
     * @return the isArcoCFechado
     */
    public List<String> getIsArcoCFechado() {
        return isArcoCFechado;
    }

    /**
     * @param isArcoCFechado the isArcoCFechado to set
     */
    public void setIsArcoCFechado(List<String> isArcoCFechado) {
        this.isArcoCFechado = isArcoCFechado;
    }

    /**
     * @return the isArcoDFechado
     */
    public List<String> getIsArcoDFechado() {
        return isArcoDFechado;
    }

    /**
     * @param isArcoDFechado the isArcoDFechado to set
     */
    public void setIsArcoDFechado(List<String> isArcoDFechado) {
        this.isArcoDFechado = isArcoDFechado;
    }

    /**
     * @return the isArcoEFechado
     */
    public List<String> getIsArcoEFechado() {
        return isArcoEFechado;
    }

    /**
     * @param isArcoEFechado the isArcoEFechado to set
     */
    public void setIsArcoEFechado(List<String> isArcoEFechado) {
        this.isArcoEFechado = isArcoEFechado;
    }

    /**
     * @return the arcoOcupacionalMaterial
     */
    public Rotina006ArcosOcupacionaisMateriais getArcoOcupacionalMaterial() {
        return arcoOcupacionalMaterial;
    }

    /**
     * @param arcoOcupacionalMaterial the arcoOcupacionalMaterial to set
     */
    public void setArcoOcupacionalMaterial(Rotina006ArcosOcupacionaisMateriais arcoOcupacionalMaterial) {
        this.arcoOcupacionalMaterial = arcoOcupacionalMaterial;
    }

    public List<Rotina006ArcosOcupacionaisMateriais> getMateriais() {
        return materiais;
    }

    public void setMateriais(List<Rotina006ArcosOcupacionaisMateriais> materiais) {
        this.materiais = materiais;
    }

    public boolean isDisableMunicipio() {
        if  ((coordenacaoEscolhida != null && coordenacaoEscolhida.isEmpty()) || coordenacaoEscolhida == null) {
            disableMunicipio = true;
        } else {
            if(municipios.size() == 1){
                disableMunicipio = true;
                setMunicipioEscolhida(municipios.get(0).getLabel());
            }else{
                disableMunicipio = false;
            }
        }
        return disableMunicipio;
    }

    public void setDisableMunicipio(boolean disableMunicipio) {
        this.disableMunicipio = disableMunicipio;
    }

    public String getMunicipioEscolhida() {
        return municipioEscolhida;
    }

    public void setMunicipioEscolhida(String municipioEscolhida) {
        this.municipioEscolhida = municipioEscolhida;
    }

    public List<SelectItem> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<SelectItem> municipios) {
        this.municipios = municipios;
    }

    /**
     * @return the ficha
     */
    public Rotina003Ficha getFicha() {
        return ficha;
    }

    /**
     * @param ficha the ficha to set
     */
    public void setFicha(Rotina003Ficha ficha) {
        this.ficha = ficha;
    }

    /**
     * @return the listaFichas
     */
    public List<Rotina003Ficha> getListaFichas() {
        return listaFichas;
    }

    /**
     * @param listaFichas the listaFichas to set
     */
    public void setListaFichas(List<Rotina003Ficha> listaFichas) {
        this.listaFichas = listaFichas;
    }

    /**
     * @return the rotina006ArcosOcupacionaisV3
     */
    public Rotina006ArcosOcupacionaisV3 getRotina006ArcosOcupacionaisV3() {
        return rotina006ArcosOcupacionaisV3;
    }

    /**
     * @param rotina006ArcosOcupacionaisV3 the rotina006ArcosOcupacionaisV3 to set
     */
    public void setRotina006ArcosOcupacionaisV3(Rotina006ArcosOcupacionaisV3 rotina006ArcosOcupacionaisV3) {
        this.rotina006ArcosOcupacionaisV3 = rotina006ArcosOcupacionaisV3;
    }

    /**
     * @return the rotina006ArcosOcupacionaisV3Bean
     */
    public Rotina006ArcosOcupacionaisV3Bean getRotina006ArcosOcupacionaisV3Bean() {
        return rotina006ArcosOcupacionaisV3Bean;
    }

    /**
     * @param rotina006ArcosOcupacionaisV3Bean the rotina006ArcosOcupacionaisV3Bean to set
     */
    public void setRotina006ArcosOcupacionaisV3Bean(Rotina006ArcosOcupacionaisV3Bean rotina006ArcosOcupacionaisV3Bean) {
        this.rotina006ArcosOcupacionaisV3Bean = rotina006ArcosOcupacionaisV3Bean;
    }

    /**
     * @return the rotina004V2
     */
    public Rotina004V2 getRotina004V2() {
        return rotina004V2;
    }

    /**
     * @param rotina004V2 the rotina004V2 to set
     */
    public void setRotina004V2(Rotina004V2 rotina004V2) {
        this.rotina004V2 = rotina004V2;
    }

    /**
     * @return the rotina004Bean
     */
    public Rotina004Bean getRotina004Bean() {
        return rotina004Bean;
    }

    /**
     * @param rotina004Bean the rotina004Bean to set
     */
    public void setRotina004Bean(Rotina004Bean rotina004Bean) {
        this.rotina004Bean = rotina004Bean;
    }



}