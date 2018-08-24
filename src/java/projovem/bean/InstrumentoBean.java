

package projovem.bean;

import projovem.controller.InstrumentoController;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;
import projovem.dao.InstrumentoDAO;
import projovem.entity.ColetaDados;
import projovem.entity.Endereco;
import projovem.entity.Instrumento;
import projovem.entity.Questao;
import projovem.entity.RespostaDada;
import projovem.entity.RespostaMaterial;
import projovem.entity.Usuario;
import projovem.vo.LocalVO;
import projovem.vo.Navegacao;
import projovem.vo.TipoQuestao;
import projovem.vo.RespostasDadas;
import projovem.vo.RespostasPossiveis;
import projovem.vo.ResumoRespostas;


/**
 *
 * @author admprojovem
 */
public class InstrumentoBean implements Serializable{
    private static final long serialVersionUID = 6557036699866623829L;
    

    @Resource
    private UserTransaction utx ;
    @PersistenceUnit(unitName = "projovemPU")
    private EntityManagerFactory emf;

    private String numeroInstrumento;
    private String perguntaQuestaoAtual = new String();
    private String respostaSelecionada;
    private String tituloPanel = "Orientação";
    private String cidadeFiltrada;
    private String ufFiltrada;
    

    private boolean renderedMenuNavegacao           = false;
    private boolean renderedBotaoProximo            = false;
    private boolean renderedBotaoAnterior           = false;
    private boolean renderedBotaoFinalizar          = false;
    private boolean renderedOrientacaoQuestao       = false;
    private boolean renderedQuestaoMonovalorada     = false;
    private boolean renderedQuestaoMonovaloradaA4J  = false;
    private boolean renderedQuestaoMultivalorada    = false;
    private boolean renderedResumoRespostas         = false;
    private boolean renderedPesquisaLocais          = false;
    private boolean renderedQuestao                 = false;
    private boolean renderedNaoPodeGravar           = false;
    private boolean renderedInicioInstrumento       = true;
    private boolean renderedComprovante             = false;
    private boolean renderedCidade                  = false;
    private boolean renderedIncluirLocal            = false;
    private boolean renderedMultiplosNucleos        = false;
    private boolean renderedQuestaoMaterial         = false;



    private Instrumento instrumento                 = new Instrumento();
    private Questao questaoSelecionadaMenuNavegacao = new Questao();
    private ColetaDados coletaDados                 = new ColetaDados();
    private TipoQuestao tipoQuestao                 = new TipoQuestao();
    private LocalVO localEscolhido                  = new LocalVO();
    
    

    private List<SelectItem> respostasPossiveisQuestoesMonovaloradas    = new ArrayList<SelectItem>();
    private List<SelectItem> cidadesPossiveis                           = new ArrayList<SelectItem>();
    private List<SelectItem> ufPossiveis                                = new ArrayList<SelectItem>();
    private List<String> respostasDadasQuestoesMultivaloradas           = new ArrayList<String>();
    private List<RespostaDada> respostasPossiveisQuestoesTextuais       = new ArrayList<RespostaDada>();
    private List<Navegacao> navegacao                                   = new ArrayList<Navegacao>();
    private List<ResumoRespostas> resumo                                = new ArrayList<ResumoRespostas>();
    private List<LocalVO> locais                                        = new ArrayList<LocalVO>();
    private List<RespostaMaterial> materiais                            = new ArrayList<RespostaMaterial>();
    private RespostaMaterial respostaMaterialInformada                  = new RespostaMaterial();


    private InstrumentoController controller= new InstrumentoController();
    private InstrumentoDAO instrumentoDAO   = new InstrumentoDAO();




    public InstrumentoBean(){


    }

    public void editar(){
        
    }
    public void adicionarMaterial(){
        if(!materiais.contains(respostaMaterialInformada)){
            materiais.add(respostaMaterialInformada);
        }
        respostaMaterialInformada = new RespostaMaterial();
    }
    public void removerMaterial(){
        materiais.remove(respostaMaterialInformada);
        respostaMaterialInformada = new RespostaMaterial();
    }
    public void cadastrarLocal(){
        renderedIncluirLocal=true;
        renderedPesquisaLocais= false;
    }
    public void pesquisar(){
        locais = controller.pesquisarLocais(instrumento,cidadeFiltrada);
        renderedPesquisaLocais=true;
    }
    public String inicializar() {
        tituloPanel = "Identificar Local";
        getController().setEmf(emf);
        coletaDados.setInstrumento(instrumento);
        setNavegacao(controller.obterMenuNavegacao(instrumento, coletaDados));
        setUfPossiveis(controller.obterUfPossiveis());
        if(instrumento.getPermiteSelecaoDeMultiplosNucleos() != null && instrumento.getPermiteSelecaoDeMultiplosNucleos().equals("S")){
            renderedMultiplosNucleos=true;
        }
        
        return "iniciarInstrumento";
    }

    public void obtemCidadesDoEstado(){
        setRenderedCidade(true);
        setCidadesPossiveis(controller.obterCidadesPossiveis(ufFiltrada,instrumento));
    }
    public String iniciarPerguntas(){
        
        List<Endereco> enderecoLocal = new ArrayList<Endereco>();
        enderecoLocal = definirLocalSelecionado(locais);
        
        coletaDados.setEnderecoLocal(localEscolhido.getEndereco());
        coletaDados.setMultiplosEnderecosLocal(enderecoLocal);



        List<RespostaDada> listaRespostas = new ArrayList<RespostaDada>();
        if(coletaDados.getRespostasDadas()== null){
            coletaDados.setRespostasDadas(listaRespostas);
        }


        int numeroPrimeiraQuestao = 1;
        Questao questaoInicial = new Questao();
        questaoInicial.setInstrumento(instrumento);
        questaoInicial.setNumero(numeroPrimeiraQuestao);

        questaoSelecionadaMenuNavegacao = questaoInicial;
        goToQuestao();


        setRenderedMenuNavegacao(true);
        setRenderedBotaoFinalizar(true);
        renderedQuestao = true;
        setRenderedInicioInstrumento(false);
        return null;
        
    }




    public void cordenaDisabled(){
        respostasPossiveisQuestoesTextuais = controller.cordenaDisabled(respostasPossiveisQuestoesTextuais,respostaSelecionada);
    }

     private void coordenaBotaoAnteriorProximo(){
        int numeroQuestaoSelecionada = getController().getQuestaoAtual().getNumero();
        Navegacao maiorQuestao = getNavegacao().get(getNavegacao().size()-1);
        int numeroMaiorQuestao = maiorQuestao.getQuestao().getNumero();
        if(numeroQuestaoSelecionada==numeroMaiorQuestao){
            setRenderedBotaoProximo(false);
        }else{
            setRenderedBotaoProximo(true);
        }

        if(numeroQuestaoSelecionada==1){
            setRenderedBotaoAnterior(false);
        }else{
            setRenderedBotaoAnterior(true);
        }
    }

    private List<Endereco> definirLocalSelecionado(List<LocalVO> locais) {
        List<Endereco> enderecoLocal = new ArrayList<Endereco>();
        for (LocalVO localVO : locais) {
            if(localVO.getSelecionado() !=null && localVO.getSelecionado().equals("true")){
                enderecoLocal.add(localVO.getEndereco());
            }
        }
        if(localEscolhido.getId()!=null){
            enderecoLocal.add(localEscolhido.getEndereco());
        }
        return enderecoLocal;
    }



    private void obterRespostasPossiveis(){
        RespostasPossiveis respostasPossiveis = new RespostasPossiveis();
        respostasPossiveis                      = getController().obterRespostasPossiveis(coletaDados);
        setRespostasPossiveisQuestoesMonovaloradas(respostasPossiveis.getQuestoesMonovaloradas());
        setRespostasPossiveisQuestoesTextuais(respostasPossiveis.getQuestoesTextuais());
    }

    private void obterRespostasDadas(){
        RespostasDadas respostasDadas           = new RespostasDadas();
        respostasDadas                          = getController().obterRespostaDada(coletaDados);
        respostaSelecionada                     = respostasDadas.getRespostasMonovaloradas();
        if(respostasDadas.getRespostasTextuais().size()>0){
            setRespostasPossiveisQuestoesTextuais(respostasDadas.getRespostasTextuais());
        }
    }



    private void acoesRealizadasAoMudarDeQuestao(String acao){

        coletaDados = getController().gravarRespostaDadaParaQuestaoAtual(respostaSelecionada,respostasPossiveisQuestoesTextuais,respostasDadasQuestoesMultivaloradas,coletaDados);
        if(acao.equals("NAVEGACAO")){
            getController().setQuestaoAtual(questaoSelecionadaMenuNavegacao);
        }

        setNavegacao(getController().defineQuestaoAtual(acao, coletaDados));

        obterRespostasPossiveis();

        obterRespostasDadas();

        coordenaBotaoAnteriorProximo();
        cordenaDisabled();
        tituloPanel = "Questão "+controller.getQuestaoAtual().getNumero();
    }

    public void goToQuestao(){
        acoesRealizadasAoMudarDeQuestao("NAVEGACAO");
    }
    public void proxima(){
        acoesRealizadasAoMudarDeQuestao("PROXIMO");
    }

    public void anterior(){
        acoesRealizadasAoMudarDeQuestao("ANTERIOR");
    }



    public void gravarColeta(){

        if(renderedBotaoProximo){
            proxima();
        }else{
            anterior();
        }
        Usuario currentUser = controller.obterUsuarioLogado();
        
        coletaDados.setUsuario(currentUser);


        

        boolean podeGravar = verificaSeTodasQuestoesRespondidas();
        if(podeGravar){
            resumo = controller.obterResumoDasRespostas(coletaDados);
        }else{
            setRenderedNaoPodeGravar(true);
        }
        

        renderedMenuNavegacao   = false;
        renderedQuestao         = false;
        renderedResumoRespostas = true;
//        coletaDados = getController().gravarRespostaDadaParaQuestaoAtual(getRespostaSelecionada(),getRespostasPossiveisQuestoesTextuais(),coletaDados);
        //coletaDadosDAO.saveColetaDados(coletaDados,emf,utx);
    }

    public void desfazerGravarColeta(){
        renderedMenuNavegacao   = true;
        renderedQuestao         = true;
        renderedResumoRespostas = false;
        renderedNaoPodeGravar   = false;
    }
    
    /**
     * @return the respostaTextual
     */
    public List<RespostaDada> getRespostaTextual() {
        return getRespostasPossiveisQuestoesTextuais();
    }

    /**
     * @param respostaTextual the respostaTextual to set
     */
    public void setRespostaTextual(List<RespostaDada> respostaTextual) {
        this.setRespostasPossiveisQuestoesTextuais(respostaTextual);
    }

    /**
     * @return the renderedBotaoFinalizar
     */
    public boolean isRenderedBotaoFinalizar() {
        return renderedBotaoFinalizar;
    }

    /**
     * @param renderedBotaoFinalizar the renderedBotaoFinalizar to set
     */
    public void setRenderedBotaoFinalizar(boolean renderedBotaoFinalizar) {
        this.renderedBotaoFinalizar = renderedBotaoFinalizar;
    }


    /**
     * @return the numeroInstrumento
     */
    public String getNumeroInstrumento() {

        return numeroInstrumento;
    }

    /**
     * @param numeroInstrumento the numeroInstrumento to set
     */

    public void setNumeroInstrumento(String numeroInstrumento) {

        this.numeroInstrumento = numeroInstrumento;

    }



    /**
     * @return the instrumento
     */
    public Instrumento getInstrumento() {
        
        if(numeroInstrumento!=null){
            Instrumento instrumentoAtual = instrumentoDAO.getByCodigo(numeroInstrumento, emf);
            setInstrumento(instrumentoAtual);
        }
        return instrumento;
    }

    /**
     * @param instrumento the instrumento to set
     */
    public void setInstrumento(Instrumento instrumento) {
        this.instrumento = instrumento;
    }

    /**
     * @return the perguntaQuestaoAtual
     */
    public String getPerguntaQuestaoAtual() {
        perguntaQuestaoAtual =  getController().getQuestaoAtual().getPergunta();
        return perguntaQuestaoAtual;
    }

    /**
     * @param perguntaQuestaoAtual the perguntaQuestaoAtual to set
     */
    public void setPerguntaQuestaoAtual(String perguntaQuestaoAtual) {
        this.perguntaQuestaoAtual = perguntaQuestaoAtual;
    }

    /**
     * @return the renderedMenuNavegacao
     */
    public boolean isRenderedMenuNavegacao() {
        return renderedMenuNavegacao;
    }

    /**
     * @param renderedMenuNavegacao the renderedMenuNavegacao to set
     */
    public void setRenderedMenuNavegacao(boolean renderedMenuNavegacao) {
        this.renderedMenuNavegacao = renderedMenuNavegacao;
    }


    /**
     * @return the renderedBotaoProximo
     */
    public boolean isRenderedBotaoProximo() {
        return renderedBotaoProximo;
    }

    /**
     * @param renderedBotaoProximo the renderedBotaoProximo to set
     */
    public void setRenderedBotaoProximo(boolean renderedBotaoProximo) {
        this.renderedBotaoProximo = renderedBotaoProximo;
    }

    /**
     * @return the renderedBotaoAnterior
     */
    public boolean isRenderedBotaoAnterior() {
        return renderedBotaoAnterior;
    }

    /**
     * @param renderedBotaoAnterior the renderedBotaoAnterior to set
     */
    public void setRenderedBotaoAnterior(boolean renderedBotaoAnterior) {
        this.renderedBotaoAnterior = renderedBotaoAnterior;
    }

    /**
     * @return the questaoSelecionadaMenuNavegacao
     */
    public Questao getQuestaoSelecionadaMenuNavegacao() {
        return questaoSelecionadaMenuNavegacao;
    }

    /**
     * @param questaoSelecionadaMenuNavegacao the questaoSelecionadaMenuNavegacao to set
     */
    public void setQuestaoSelecionadaMenuNavegacao(Questao questaoSelecionadaMenuNavegacao) {
        this.questaoSelecionadaMenuNavegacao = questaoSelecionadaMenuNavegacao;
    }



    /**
     * @param respostasPossiveis the respostasPossiveis to set
     */
    public void setRespostasPossiveis(List<SelectItem> respostasPossiveis) {
        this.setRespostasPossiveisQuestoesMonovaloradas(respostasPossiveis);
    }

    /**
     * @return the coletaDados
     */
    public ColetaDados getColetaDados() {
        return coletaDados;
    }

    /**
     * @param coletaDados the coletaDados to set
     */
    public void setColetaDados(ColetaDados coletaDados) {
        this.coletaDados = coletaDados;
    }

    /**
     * @return the respostaSelecionada
     */
    public String getRespostaSelecionada() {
        return respostaSelecionada;
    }

    /**
     * @param respostaSelecionada the respostaSelecionada to set
     */
    public void setRespostaSelecionada(String respostaSelecionada) {
        this.respostaSelecionada = respostaSelecionada;
    }

     /**
     * @return the respostasPossiveis
     */
    public List<SelectItem> getRespostasPossiveis() {
        return getRespostasPossiveisQuestoesMonovaloradas();
    }

    /**
     * @return the controller
     */
    public InstrumentoController getController() {
        return controller;
    }

    /**
     * @param controller the controller to set
     */
    public void setController(InstrumentoController controller) {
        this.controller = controller;
    }

    /**
     * @return the respostasPossiveisQuestoesMonovaloradas
     */
    public List<SelectItem> getRespostasPossiveisQuestoesMonovaloradas() {
        return respostasPossiveisQuestoesMonovaloradas;
    }

    /**
     * @param respostasPossiveisQuestoesMonovaloradas the respostasPossiveisQuestoesMonovaloradas to set
     */
    public void setRespostasPossiveisQuestoesMonovaloradas(List<SelectItem> respostasPossiveisQuestoesMonovaloradas) {
        this.respostasPossiveisQuestoesMonovaloradas = respostasPossiveisQuestoesMonovaloradas;
    }

    /**
     * @return the respostasPossiveisQuestoesTextuais
     */
    public List<RespostaDada> getRespostasPossiveisQuestoesTextuais() {
        return respostasPossiveisQuestoesTextuais;
    }

    /**
     * @param respostasPossiveisQuestoesTextuais the respostasPossiveisQuestoesTextuais to set
     */
    public void setRespostasPossiveisQuestoesTextuais(List<RespostaDada> respostasPossiveisQuestoesTextuais) {
        this.respostasPossiveisQuestoesTextuais = respostasPossiveisQuestoesTextuais;
    }

    /**
     * @return the renderedOrientacaoQuestao
     */
    public boolean isRenderedOrientacaoQuestao() {
        if(getController().getQuestaoAtual() ==null ||
                getController().getQuestaoAtual().getTitulo() == null ||
                getController().getQuestaoAtual().getTitulo().isEmpty()){
            renderedOrientacaoQuestao = false;
        }else{
            renderedOrientacaoQuestao = true;
        }
        return renderedOrientacaoQuestao;
    }

    /**
     * @param renderedOrientacaoQuestao the renderedOrientacaoQuestao to set
     */
    public void setRenderedOrientacaoQuestao(boolean renderedOrientacaoQuestao) {
        this.renderedOrientacaoQuestao = renderedOrientacaoQuestao;
    }

    /**
     * @return the questaoMonovalorada
     */
    public boolean isRenderedQuestaoMonovalorada() {
        renderedQuestaoMonovalorada = false;
        if(getController().getQuestaoAtual() !=null){
            if(getController().getQuestaoAtual().getTipoResposta()
                    .equals(getTipoQuestao().getMonovalorada())){
                if(respostasPossiveisQuestoesTextuais.size()==0){
                    renderedQuestaoMonovalorada = true;
                }
            }
        }
        return renderedQuestaoMonovalorada;
    }

    /**
     * @param questaoMonovalorada the questaoMonovalorada to set
     */
    public void setRenderedQuestaoMonovalorada(boolean questaoMonovalorada) {
        this.renderedQuestaoMonovalorada = questaoMonovalorada;
    }

    /**
     * @return the renderedQuestaoMonovaloradaA4J
     */
    public boolean isRenderedQuestaoMonovaloradaA4J() {
        renderedQuestaoMonovaloradaA4J = false;
        if(getController().getQuestaoAtual() !=null){
            if(getController().getQuestaoAtual().getTipoResposta()
                    .equals(getTipoQuestao().getMonovalorada())){
                if(respostasPossiveisQuestoesTextuais.size()>0){
                    renderedQuestaoMonovaloradaA4J = true;
                }
            }
        }
        return renderedQuestaoMonovaloradaA4J;
    }

    /**
     * @param renderedQuestaoMonovaloradaA4J the renderedQuestaoMonovaloradaA4J to set
     */
    public void setRenderedQuestaoMonovaloradaA4J(boolean renderedQuestaoMonovaloradaA4J) {
        this.renderedQuestaoMonovaloradaA4J = renderedQuestaoMonovaloradaA4J;
    }

    /**
     * @return the navegacao
     */
    public List<Navegacao> getNavegacao() {
        return navegacao;
    }

    /**
     * @param navegacao the navegacao to set
     */
    public void setNavegacao(List<Navegacao> navegacao) {
        this.navegacao = navegacao;
    }

    /**
     * @return the respostasDadasQuestoesMultivaloradas
     */
    public List<String> getRespostasDadasQuestoesMultivaloradas() {
        return respostasDadasQuestoesMultivaloradas;
    }

    /**
     * @param respostasDadasQuestoesMultivaloradas the respostasDadasQuestoesMultivaloradas to set
     */
    public void setRespostasDadasQuestoesMultivaloradas(List<String> respostasDadasQuestoesMultivaloradas) {
        this.respostasDadasQuestoesMultivaloradas = respostasDadasQuestoesMultivaloradas;
    }

    /**
     * @return the renderedQuestaoMultivalorada
     */
    public boolean isRenderedQuestaoMultivalorada() {
        renderedQuestaoMultivalorada = false;
        if(getController().getQuestaoAtual() !=null){
            if(getController().getQuestaoAtual().getTipoResposta()
                    .equals(getTipoQuestao().getMultivalorada())){
                //if(respostasPossiveisQuestoesTextuais.size()>0){
                    renderedQuestaoMultivalorada = true;
                //}
            }
        }
        return renderedQuestaoMultivalorada;
    }

    /**
     * @param renderedQuestaoMultivalorada the renderedQuestaoMultivalorada to set
     */
    public void setRenderedQuestaoMultivalorada(boolean renderedQuestaoMultivalorada) {
        this.renderedQuestaoMultivalorada = renderedQuestaoMultivalorada;
    }

    /**
     * @return the renderedResumoRespostas
     */
    public boolean isRenderedResumoRespostas() {
        return renderedResumoRespostas;
    }

    /**
     * @param renderedResumoRespostas the renderedResumoRespostas to set
     */
    public void setRenderedResumoRespostas(boolean renderedResumoRespostas) {
        this.renderedResumoRespostas = renderedResumoRespostas;
    }

    /**
     * @return the resumo
     */
    public List<ResumoRespostas> getResumo() {
        return resumo;
    }

    /**
     * @param resumo the resumo to set
     */
    public void setResumo(List<ResumoRespostas> resumo) {
        this.resumo = resumo;
    }

    /**
     * @return the renderedPesquisaLocais
     */
    public boolean isRenderedPesquisaLocais() {
        return renderedPesquisaLocais;
    }

    /**
     * @param renderedPesquisaLocais the renderedPesquisaLocais to set
     */
    public void setRenderedPesquisaLocais(boolean renderedPesquisaLocais) {
        this.renderedPesquisaLocais = renderedPesquisaLocais;
    }

    /**
     * @return the locais
     */
    public List<LocalVO> getLocais() {
        return locais;
    }

    /**
     * @param locais the locais to set
     */
    public void setLocais(List<LocalVO> locais) {
        this.locais = locais;
    }

    /**
     * @return the tituloPanel
     */
    public String getTituloPanel() {
        return tituloPanel;
    }

    /**
     * @param tituloPanel the tituloPanel to set
     */
    public void setTituloPanel(String tituloPanel) {
        this.tituloPanel = tituloPanel;
    }

    /**
     * @return the renderedQuestao
     */
    public boolean isRenderedQuestao() {
        return renderedQuestao;
    }

    /**
     * @param renderedQuestao the renderedQuestao to set
     */
    public void setRenderedQuestao(boolean renderedQuestao) {
        this.renderedQuestao = renderedQuestao;
    }

    /**
     * @return the renderedInicioInstrumento
     */
    public boolean isRenderedInicioInstrumento() {
        return renderedInicioInstrumento;
    }

    /**
     * @param renderedInicioInstrumento the renderedInicioInstrumento to set
     */
    public void setRenderedInicioInstrumento(boolean renderedInicioInstrumento) {
        this.renderedInicioInstrumento = renderedInicioInstrumento;
    }



    /**
     * @return the tipoQuestao
     */
    public TipoQuestao getTipoQuestao() {
        return tipoQuestao;
    }

    /**
     * @param tipoQuestao the tipoQuestao to set
     */
    public void setTipoQuestao(TipoQuestao tipoQuestao) {
        this.tipoQuestao = tipoQuestao;
    }

    /**
     * @return the cidadeFiltrada
     */
    public String getCidadeFiltrada() {
        return cidadeFiltrada;
    }

    /**
     * @param cidadeFiltrada the cidadeFiltrada to set
     */
    public void setCidadeFiltrada(String cidadeFiltrada) {
        this.cidadeFiltrada = cidadeFiltrada;
    }

    /**
     * @return the cidadesPossiveis
     */
    public List<SelectItem> getCidadesPossiveis() {
        return cidadesPossiveis;
    }

    /**
     * @param cidadesPossiveis the cidadesPossiveis to set
     */
    public void setCidadesPossiveis(List<SelectItem> cidadesPossiveis) {
        this.cidadesPossiveis = cidadesPossiveis;
    }

    /**
     * @return the localEscolhido
     */
    public LocalVO getLocalEscolhido() {
        return localEscolhido;
    }

    /**
     * @param localEscolhido the localEscolhido to set
     */
    public void setLocalEscolhido(LocalVO localEscolhido) {
        this.localEscolhido = localEscolhido;
    }

    private boolean verificaSeTodasQuestoesRespondidas() {
        boolean podeGravar = true;
        for(Navegacao nav : navegacao){
            if(nav.getStatus().equals("naoRespondida")){
                podeGravar = false;
            }
        }
        return podeGravar;
    }
    public void confirmarGravarColeta(){
        controller.saveColetaDados(coletaDados, utx,materiais);
        renderedComprovante=true;
        renderedResumoRespostas=false;
        
    }
    public String finalizar(){
        return "newindex";
    }
    /**
     * @return the renderedNaoPodeGravar
     */
    public boolean isRenderedNaoPodeGravar() {
        return renderedNaoPodeGravar;
    }

    /**
     * @param renderedNaoPodeGravar the renderedNaoPodeGravar to set
     */
    public void setRenderedNaoPodeGravar(boolean renderedNaoPodeGravar) {
        this.renderedNaoPodeGravar = renderedNaoPodeGravar;
    }

    /**
     * @return the renderedComprovante
     */
    public boolean isRenderedComprovante() {
        return renderedComprovante;
    }

    /**
     * @param renderedComprovante the renderedComprovante to set
     */
    public void setRenderedComprovante(boolean renderedComprovante) {
        this.renderedComprovante = renderedComprovante;
    }

    /**
     * @return the ufPossiveis
     */
    public List<SelectItem> getUfPossiveis() {
        return ufPossiveis;
    }

    /**
     * @param ufPossiveis the ufPossiveis to set
     */
    public void setUfPossiveis(List<SelectItem> ufPossiveis) {
        this.ufPossiveis = ufPossiveis;
    }

    /**
     * @return the ufFiltrada
     */
    public String getUfFiltrada() {
        return ufFiltrada;
    }

    /**
     * @param ufFiltrada the ufFiltrada to set
     */
    public void setUfFiltrada(String ufFiltrada) {
        this.ufFiltrada = ufFiltrada;
    }

    /**
     * @return the renderedCidade
     */
    public boolean isRenderedCidade() {
        return renderedCidade;
    }

    /**
     * @param renderedCidade the renderedCidade to set
     */
    public void setRenderedCidade(boolean renderedCidade) {
        this.renderedCidade = renderedCidade;
    }

    /**
     * @return the renderedIncluirLocal
     */
    public boolean isRenderedIncluirLocal() {
        return renderedIncluirLocal;
    }

    /**
     * @param renderedIncluirLocal the renderedIncluirLocal to set
     */
    public void setRenderedIncluirLocal(boolean renderedIncluirLocal) {
        this.renderedIncluirLocal = renderedIncluirLocal;
    }

    /**
     * @return the renderedMultiplosNucleos
     */
    public boolean isRenderedMultiplosNucleos() {
        return renderedMultiplosNucleos;
    }

    /**
     * @param renderedMultiplosNucleos the renderedMultiplosNucleos to set
     */
    public void setRenderedMultiplosNucleos(boolean renderedMultiplosNucleos) {
        this.renderedMultiplosNucleos = renderedMultiplosNucleos;
    }

    /**
     * @return the materiais
     */
    public List<RespostaMaterial> getMateriais() {
        return materiais;
    }

    /**
     * @param materiais the materiais to set
     */
    public void setMateriais(List<RespostaMaterial> materiais) {
        this.materiais = materiais;
    }

    /**
     * @return the respostaMaterialInformada
     */
    public RespostaMaterial getRespostaMaterialInformada() {
        return respostaMaterialInformada;
    }

    /**
     * @param respostaMaterialInformada the respostaMaterialInformada to set
     */
    public void setRespostaMaterialInformada(RespostaMaterial respostaMaterialInformada) {
        this.respostaMaterialInformada = respostaMaterialInformada;
    }

    /**
     * @return the renderedQuestaoMaterial
     */
    public boolean isRenderedQuestaoMaterial() {
        renderedQuestaoMaterial = false;
        if(getController().getQuestaoAtual() !=null){
            if(getController().getQuestaoAtual().getTipoResposta()
                    .equals(getTipoQuestao().getMaterial())){
                //if(respostasPossiveisQuestoesTextuais.size()>0){
                    renderedQuestaoMaterial = true;
                //}
            }
        }
        return renderedQuestaoMaterial;
    }

    /**
     * @param renderedQuestaoMaterial the renderedQuestaoMaterial to set
     */
    public void setRenderedQuestaoMaterial(boolean renderedQuestaoMaterial) {
        this.renderedQuestaoMaterial = renderedQuestaoMaterial;
    }
}
