

package projovem.controller;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;
import projovem.dao.ArcoDAO;
import projovem.dao.ColetaDadosDAO;
import projovem.dao.InstrumentoDAO;
import projovem.dao.LocalDAO;
import projovem.dao.QuestaoDAO;
import projovem.dao.RespostaDAO;
import projovem.dao.RespostaMaterialDAO;
import projovem.dao.UfDAO;
import projovem.dao.UsuarioDAO;
import projovem.entity.Arco;
import projovem.entity.ColetaDados;
import projovem.entity.Endereco;
import projovem.entity.InstituicaoRegional;
import projovem.entity.Instrumento;
import projovem.entity.Questao;
import projovem.entity.RenderedIfResposta;
import projovem.entity.Resposta;
import projovem.entity.RespostaDada;
import projovem.entity.RespostaMaterial;
import projovem.entity.RespostaMonovalorada;
import projovem.entity.RespostaTextual;
import projovem.entity.Usuario;
import projovem.vo.LocalVO;
import projovem.vo.Navegacao;
import projovem.vo.ResumoRespostas;
import projovem.vo.TipoQuestao;
import projovem.vo.RespostasDadas;
import projovem.vo.RespostasPossiveis;
import projovem.vo.ResumoRespostasSelectItem;

/**
 *
 * @author admprojovem
 */
public class InstrumentoController implements Serializable{
    private static final long serialVersionUID = -3067028637706378730L;
    


    private Questao questaoAtual;
    private TipoQuestao tipoQuestao = new TipoQuestao();


    private EntityManagerFactory emf;

    private QuestaoDAO questaoDAO           = new QuestaoDAO();
    private InstrumentoDAO instrumentoDAO   = new InstrumentoDAO();
    private RespostaDAO respostaDAO         = new RespostaDAO();
    private ColetaDadosDAO coletaDadosDAO   = new ColetaDadosDAO();
    private LocalDAO localDAO               = new LocalDAO();
    private UfDAO ufDAO                     = new UfDAO();
    private UsuarioDAO usuarioDAO           = new UsuarioDAO();
    private ArcoDAO arcoDAO                 = new ArcoDAO();
    private RespostaMaterialDAO respostaMaterialDAO                 = new RespostaMaterialDAO();

   public List<ResumoRespostas> adicionarPerguntasNaoRespondidas(List<ResumoRespostas> resumo, Instrumento instrumento, EntityManagerFactory emf2) {

        List <Resposta> respostas = respostaDAO.getByInstrumento(instrumento, emf2);
        

        for (Resposta resposta : respostas) {
            boolean questaoExiste = false;
            boolean respostaComTextualExiste = false;

            RespostaMonovalorada respostaMonovaloradaComTextual = respostaDAO.getRespostasMonovaloradaComTextuais(resposta.getQuestao().getId(),emf2);
            if(respostaMonovaloradaComTextual!=null){
                System.out.println("Achou");
                
                for (ResumoRespostas resumoRespostas : resumo) {
                    Integer numeroQuestao = resumoRespostas.getNumeroQuestao();
                    if(numeroQuestao.equals(respostaMonovaloradaComTextual.getQuestao().getNumero())){
                        if(!(resumoRespostas.getResposta().size()>1)){
                            respostaComTextualExiste = true;
                            Integer numeroOcorrencias = 0;
                            for (ResumoRespostas resumoResposta : resumo) {
                                Integer numero= resumoResposta.getNumeroQuestao();
                                if(numero.equals(resposta.getQuestao().getNumero())){
                                    numeroOcorrencias ++;
                                    if(numeroOcorrencias>1){
                                        respostaComTextualExiste = false;
                                        break;
                                    }
                                }
                            }
                            
                            break;
                        }
                        break;
                    }
                }
            }
            for (ResumoRespostas resumoRespostas : resumo) {

                Integer numeroQuestao = resumoRespostas.getNumeroQuestao();
                if(numeroQuestao.equals(resposta.getQuestao().getNumero())){
                    questaoExiste = true;
                    break;
                }
            }
            if(!questaoExiste || respostaComTextualExiste){
                ResumoRespostas resumoRespostas = new ResumoRespostas();
                resumoRespostas.setQuestao(resposta.getQuestao().getPergunta());
                resumoRespostas.setTitulo(resposta.getQuestao().getTitulo());
                Integer numeroQuestao = resposta.getQuestao().getNumero();
                resumoRespostas.setNumeroQuestao(numeroQuestao);
                ResumoRespostasSelectItem item = new ResumoRespostasSelectItem();
                    item.setOrdenacao(1);
                    item.setLabel("");
                    item.setValue("");
                resumoRespostas.getResposta().add(item);
                resumo.add(resumoRespostas);
            }
        }

        Collections.sort(resumo,new ResumoComparator());
        return resumo;
    }



    public List<SelectItem> obterUfPossiveis() {
        Usuario usuarioLogado = usuarioDAO.getUsuarioLogado();
//        InstituicaoRegional ir = usuarioLogado.getInstituicaoRegional();
        return null ;//ufDAO.getByIr(emf, ir);

    }
    public List<SelectItem> obterCidadesPossiveis(String ufFiltrada, Instrumento instrumento) {
        List<SelectItem> lista = new ArrayList<SelectItem>();
        lista=localDAO.getByUfAndTipoLocal(emf, ufFiltrada,instrumento.getAplicadoEmLocaisDoTipo());
        return lista;
    }



    public List<Navegacao> obterMenuNavegacao(Instrumento instrumento,
            ColetaDados coletaDados) {

        List<Questao> questoes;
        List<Navegacao> navegacao = new ArrayList<Navegacao>();

        questoes        = questaoDAO.getByInstrumento(instrumento, emf);
        
        for(Questao questao: questoes){
            boolean questaoValida = true;

            questaoValida = verificaSeQuestaoAtualValida(questao, coletaDados);
            if(questaoValida){


                String status;
                status = verificaStatusQuestaoAtual(questao, coletaDados);
                if(questao.getTipoResposta().equals(tipoQuestao.getMaterial())){
                    status = "respondida";
                }
                Navegacao navegacaoQuestao = new Navegacao();
                navegacaoQuestao.setQuestao(questao);
                navegacaoQuestao.setStatus(status);
                navegacao.add(navegacaoQuestao);
            }
        }
        return navegacao;
    }

    public List<ResumoRespostas> obterResumoDasRespostas(ColetaDados coletaDados) {

        List<ResumoRespostas> listaResumo = new ArrayList<ResumoRespostas>();
        for(RespostaDada respostaDada : coletaDados.getRespostasDadas()){
            ResumoRespostas resumoRespostas = new ResumoRespostas();
            String pergunta ="";
            String titulo = "";
            Integer numeroQuestao =null;
            Questao questao = new Questao();
            Resposta resposta =null;
            if(respostaDada !=null && respostaDada.getResposta() !=null){
                numeroQuestao = respostaDada.getResposta().getQuestao().getNumero();
                pergunta = respostaDada.getResposta().getQuestao().getPergunta();
                titulo= respostaDada.getResposta().getQuestao().getTitulo();
                questao = respostaDada.getResposta().getQuestao();
                resposta = respostaDada.getResposta();
                boolean adicionarQuestao = true;
                for(ResumoRespostas resumoParaVerificar : listaResumo){
                    if(numeroQuestao.equals(resumoParaVerificar.getNumeroQuestao())){
                        resumoRespostas=resumoParaVerificar;
                        adicionarQuestao = false;
                    }
                }
                resumoRespostas.setQuestao(pergunta);
                resumoRespostas.setTitulo(titulo);
                resumoRespostas.setNumeroQuestao(numeroQuestao);
                resumoRespostas.setQuestaoObj(questao);
                resumoRespostas.setRespostaObj(resposta);

                List<ResumoRespostasSelectItem> listaDeRespostaAdicionadasParaEssaQuestao = resumoRespostas.getResposta();


                
                

                String tipoResposta = respostaDada.getResposta().getQuestao().getTipoResposta();
                if(tipoQuestao.getMonovalorada().equals(tipoResposta) ||
                        tipoQuestao.getMultivalorada().equals(tipoResposta)){
                    String label = "";
                    String value = "";
                    Integer numero;


                    try{
                        RespostaMonovalorada respostaMonovalorada = (RespostaMonovalorada) respostaDada.getResposta();
                        //label = respostaMonovalorada.getResposta();
                        value = respostaMonovalorada.getResposta();
                        if(respostaMonovalorada.getRespostaOpcional()!=null){
                            //value += "Essa tem observação";
                        }
//                        value = respostaMonovalorada.getResposta();
                        numero = respostaMonovalorada.getId();

                    }catch(Exception e){
                        RespostaTextual respostaTextual = (RespostaTextual) respostaDada.getResposta();
                        label = respostaTextual.getRespostaTextual();
                        value = respostaDada.getValor();
                        numero = respostaTextual.getId();

                    }
                    ResumoRespostasSelectItem item = new ResumoRespostasSelectItem();
                    item.setLabel(label);
                    item.setValue(value);
                    item.setOrdenacao(numero);

                    listaDeRespostaAdicionadasParaEssaQuestao.add(item);

                }
                if(tipoQuestao.getTextual().equals(tipoResposta)){
                    if(respostaDada.getValor() !=null){
                        if(respostaDada.getValor().isEmpty()){
                            adicionarQuestao = false;
                        }else{
                            RespostaTextual respostaTextual = (RespostaTextual) respostaDada.getResposta();

                            if(respostaTextual.getDataTypeResposta().equals(tipoQuestao.getDate())){
                                     String novoValor=null;
                                     String valorRespostaDada = respostaDada.getValor();
                                     if(valorRespostaDada !=null){
                                        try {


                                            Date date = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US).parse(valorRespostaDada);
                                            novoValor = new SimpleDateFormat("dd/MM/yyyy",Locale.US).format(date);
                                            respostaDada.setValor(novoValor);

                                        } catch (ParseException ex) {
                                            Logger.getLogger(InstrumentoController.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                     }


                                 }

                            if(respostaTextual.getDataTypeResposta().equals(tipoQuestao.getTime())){
                                String valorRespostaDada = respostaDada.getValor();
                                String novoValor=null;
                                if(valorRespostaDada !=null){
                                    if(valorRespostaDada.length()>5){
                                        novoValor = valorRespostaDada.substring(11, 16);
                                    }else{
                                        novoValor = valorRespostaDada;
                                    }
                                }
                                respostaDada.setValor(novoValor);
                            }

                            ResumoRespostasSelectItem item = new ResumoRespostasSelectItem();
                            item.setLabel(respostaTextual.getRespostaTextual());
                            item.setValue(respostaDada.getValor());
                            item.setOrdenacao(numeroQuestao);
                            listaDeRespostaAdicionadasParaEssaQuestao.add(item);
                        }
                    }else{
                        adicionarQuestao = false;
                    }
                }
                if(adicionarQuestao){
                    listaResumo.add(resumoRespostas);
                }
            }


        }
        for(ResumoRespostas resumoResposta: listaResumo){
            if(resumoResposta.getResposta().size()>1){
                List<ResumoRespostasSelectItem> subListaResumo = new ArrayList<ResumoRespostasSelectItem>();
                subListaResumo = resumoResposta.getResposta();
                Collections.sort(subListaResumo,new ResumoSubListaComparator());

            }
        }
        
        Collections.sort(listaResumo,new ResumoComparator());
        return listaResumo;
    }

    public Usuario obterUsuarioLogado() {
        return usuarioDAO.getUsuarioLogado();
        
    }

    public List<LocalVO> pesquisarLocais(Instrumento instrumento, String cidadeFiltrada) {
        List<LocalVO> listaLocais = new ArrayList<LocalVO>();
        listaLocais = localDAO.getByCidadeAndTipoLocal(emf,instrumento.getAplicadoEmLocaisDoTipo(),cidadeFiltrada);
        return listaLocais;
    }





     private class ResumoSubListaComparator implements Comparator<ResumoRespostasSelectItem>{

        public int compare(ResumoRespostasSelectItem m1, ResumoRespostasSelectItem m2) {

        Integer nomeM1 = m1.getOrdenacao();
        Integer nomeM2 = m2.getOrdenacao();

        return nomeM1.compareTo(nomeM2);
        }
    }

    private class ResumoComparator implements Comparator<ResumoRespostas>{

        public int compare(ResumoRespostas m1, ResumoRespostas m2) {

        Integer nomeM1 = m1.getNumeroQuestao();
        Integer nomeM2 = m2.getNumeroQuestao();

        return nomeM1.compareTo(nomeM2);
        }
    }
    private List<RespostaDada> gravarRespostaMultivalorada(List<RespostaDada> listaRespostas, List<String> respostasDadasQuestoesMultivaloradas) {
        List<RespostaDada> respostasDadas = new ArrayList<RespostaDada>();
        
        for(String repostaDada : respostasDadasQuestoesMultivaloradas){
            Integer idResposta = Integer.parseInt(repostaDada);
            RespostaMonovalorada resposta =new RespostaMonovalorada();
            RespostaDada respostaDada = new RespostaDada();
            resposta = (RespostaMonovalorada) respostaDAO.getById(idResposta, emf);
            respostaDada.setResposta(resposta);
            respostasDadas.add(respostaDada);
        }
        listaRespostas = gravarRespostaTextual(listaRespostas, respostasDadas);
        return listaRespostas;
    }

    private String verificaStatusQuestaoAtual(Questao questaoAtual, ColetaDados coletaDados) {
        String status = "naoRespondida";
        if(coletaDados != null && coletaDados.getRespostasDadas() !=null && questaoAtual != null){
            for(RespostaDada respostaDada : coletaDados.getRespostasDadas()){
                if(respostaDada != null && respostaDada.getResposta() !=null && questaoAtual !=null ){
                    if(respostaDada.getResposta().getQuestao().getId().equals(questaoAtual.getId())){
                        if((respostaDada.getResposta() != null && 
                                (respostaDada.getResposta().getQuestao().getTipoResposta().equals(tipoQuestao.getMonovalorada()) ||
                                respostaDada.getResposta().getQuestao().getTipoResposta().equals(tipoQuestao.getMultivalorada())))
                               || (respostaDada.getValor() != null && !respostaDada.getValor().isEmpty())){
                            status = "respondida";
                        }


                    }
                }
            }
        }
        return status;
    }


    public Instrumento defineInstrumentoAtual(String numeroInstrumento) {
        Instrumento instrumentoAtual = instrumentoDAO.getByCodigo(numeroInstrumento, emf);
        return instrumentoAtual;
    }

    public List<RespostaDada> cordenaDisabled(List<RespostaDada> respostasPossiveisQuestoesTextuais, String respostaSelecionada) {

        int numeroQuestaoAtual = getQuestaoAtual().getId();
        List<RespostaMonovalorada> respostaMonovalorada = respostaDAO.getRespostaMonovaloradaByQuestao(numeroQuestaoAtual, emf);
        boolean disabledAlterado = false;
        for(RespostaMonovalorada resposta : respostaMonovalorada){
            Integer idRepostaSelecionada;
            if(respostaSelecionada !=null && !respostaSelecionada.isEmpty()){
                idRepostaSelecionada = Integer.parseInt(respostaSelecionada);
                if(resposta.getId().equals(idRepostaSelecionada) &&
                        resposta.getRespostaOpcional() != null){
                    for(int x=0;x<respostasPossiveisQuestoesTextuais.size();x++){
                        RespostaDada respostaDada = respostasPossiveisQuestoesTextuais.get(x);
                        try{
                        RespostaTextual textual = (RespostaTextual) respostaDada.getResposta();
                        textual.setDisabled(false);
                        }catch(Exception e){
                            
                        }
                        
                        disabledAlterado = true;

                    }
                }
            }
        }
        if(!disabledAlterado && respostasPossiveisQuestoesTextuais!=null){
            for(int x=0;x<respostasPossiveisQuestoesTextuais.size();x++){
                RespostaDada respostaDada = respostasPossiveisQuestoesTextuais.get(x);
                RespostaTextual textual = (RespostaTextual) respostaDada.getResposta();
                if(getQuestaoAtual().getTipoResposta().equals(tipoQuestao.getMonovalorada())){
                    textual.setDisabled(true);
                }else{
                    textual.setDisabled(false);
                }

            }
        }

        return respostasPossiveisQuestoesTextuais;
    }






    private List<RespostaDada> respostaTextuaisPossiveis(ColetaDados coleta){

            List<RespostaDada> respostaTextual = new ArrayList<RespostaDada>();


            List<RespostaTextual> listRespostaTextual =
                    getRespostaDAO().getRespostaTextualByQuestao(getQuestaoAtual().getId(),getEmf());

            for(RespostaTextual textual : listRespostaTextual){
                RespostaDada respostaDada = new RespostaDada();
                respostaDada.setResposta(textual);
                
                List<SelectItem> list = new ArrayList<SelectItem>();
                if(textual.getDataTypeResposta().equals(tipoQuestao.getCombo())){
                    if(textual.getOrigemResposta().equals("ARCOS")){
                        list.add(new SelectItem("", ""));
                        List<Arco> listaArco = new ArrayList<Arco>();
                        listaArco = arcoDAO.getAll(emf);
                        for (Arco arco : listaArco) {
                            list.add(new SelectItem(arco.getNome(), arco.getNome()));
                        }
                    }
                    if(textual.getOrigemResposta().equals("NUCLEOSSELECIONADOS")){
                        List<Endereco> locais = new ArrayList<Endereco>();
                        locais = coleta.getMultiplosEnderecosLocal();
                        list.add(new SelectItem("", ""));
                        for (Endereco endereco : locais) {
                            if(endereco!=null && endereco.getLocal()!=null&&
                                    endereco.getLocal().getEnderecos()!=null
                                    && endereco.getLocal().getEnderecos().size()>0
                                    && endereco.getLocal().getEnderecos().get(0) !=null
                                    && endereco.getLocal().getEnderecos().get(0).getCep().getLogradouro() != null){

                                list.add(new SelectItem(endereco.getLocal().getId(),
                                    endereco.getLocal().getNome() +" | "
                                    +endereco.getLocal().getEnderecos().get(0).getCep().getLogradouro()));

                            }
                        }
                    }
                }
                respostaDada.setListSelectItem(list);
                respostaTextual.add(respostaDada);
            }

            return respostaTextual;

    }
    public RespostasPossiveis obterRespostasPossiveis(ColetaDados coleta) {

        RespostasPossiveis respostasPossiveis = new RespostasPossiveis();
        List<RespostaDada> respostasTextuais = new ArrayList<RespostaDada>();
        List<SelectItem> respostasMonovaloradas = new ArrayList<SelectItem>();

        String tipoQuestaoAtual = getQuestaoAtual().getTipoResposta();


        if(tipoQuestao.getMonovalorada().equals(tipoQuestaoAtual) ||
                tipoQuestao.getMultivalorada().equals(tipoQuestaoAtual)){
            List<RespostaMonovalorada> listaResposta = new ArrayList<RespostaMonovalorada>();
                listaResposta = getRespostaDAO().getRespostaMonovaloradaByQuestao(getQuestaoAtual().getId(),getEmf());

                for(RespostaMonovalorada resposta : listaResposta){
                    respostasMonovaloradas.add(new SelectItem(resposta.getId(), resposta.getResposta()));
                    if(resposta.getRespostaOpcional()!=null){
                        respostasTextuais = respostaTextuaisPossiveis(coleta);
                    }
                }
        }

        if(tipoQuestao.getTextual().equals(tipoQuestaoAtual)){
           respostasTextuais = respostaTextuaisPossiveis(coleta);
        }

        respostasPossiveis.setQuestoesMonovaloradas(respostasMonovaloradas);
        respostasPossiveis.setQuestoesTextuais(respostasTextuais);

        return respostasPossiveis;
    }


    private List<RespostaDada> removerRespostaDadaAnteriormenteParaQuestaoAtual(List<RespostaDada> listaRespostas) {
        for(int x = 0;x<listaRespostas.size();x++ ){
            Resposta resposta;
            if(listaRespostas.get(x) !=null){
                resposta = listaRespostas.get(x).getResposta();
                if(resposta !=null ){
                    Questao questaoRespostaDada = resposta.getQuestao();
                    if(questaoRespostaDada !=null && questaoRespostaDada.getId().equals(getQuestaoAtual().getId())){
                        listaRespostas.set(x, null);
                    }
                }
            }
        }

        return listaRespostas;
    }

    private List<RespostaDada> gravarRespostaTextual( List<RespostaDada> listaRespostas, List<RespostaDada> listRespostaSel){

        obterRespostaDadaParaAdicionarTipoTextual(listaRespostas);
        for(RespostaDada resposta : listRespostaSel){
            listaRespostas.add(resposta);
        }

        return listaRespostas;
    }

    public ColetaDados gravarRespostaDadaParaQuestaoAtual(String respostaSelecionada, List<RespostaDada> respostasPossiveisQuestoesTextuais, List<String> respostasDadasQuestoesMultivaloradas, ColetaDados coletaDados) {
        String tipoQuestaoAtual = "";

        if(getQuestaoAtual() !=null){
            tipoQuestaoAtual = getQuestaoAtual().getTipoResposta();
        }
        RespostaDada respostaSel = null;


        List<RespostaDada> listaRespostas = new ArrayList<RespostaDada>();
        listaRespostas =  coletaDados.getRespostasDadas();

        if(tipoQuestao.getTextual().equals(tipoQuestaoAtual)){
            listaRespostas = gravarRespostaTextual(listaRespostas, respostasPossiveisQuestoesTextuais);
        }

        if(tipoQuestao.getMultivalorada().equals(tipoQuestaoAtual)){
            listaRespostas = gravarRespostaMultivalorada(listaRespostas, respostasDadasQuestoesMultivaloradas);
        }
        if(tipoQuestao.getMonovalorada().equals(tipoQuestaoAtual)){
            respostaSel = obterRespostaDadaParaAdicionarTipoMonovalorada(respostaSelecionada,listaRespostas,respostasPossiveisQuestoesTextuais);
        }

        listaRespostas.add(respostaSel);

        coletaDados.setRespostasDadas(listaRespostas);

        return coletaDados;

    }

    private RespostasDadas obtemRespostaDadaTipoMonovalorada(List<RespostaDada> listaRespostas) {
        RespostasDadas respostasDadas = new RespostasDadas();
        List<RespostaDada> respostasTextuais = new ArrayList<RespostaDada>();
        String valorRespostaSelecionada = null;

        for(int x = 0;x<listaRespostas.size();x++ ){
            Resposta resposta ;
            if(listaRespostas.get(x) !=null){
                resposta = listaRespostas.get(x).getResposta();

                if(resposta!=null){
                    Integer idResposta = listaRespostas.get(x).getResposta().getId();
                    Questao questaoRespostaDada = resposta.getQuestao();
                    if( questaoRespostaDada !=null && questaoRespostaDada.getId().equals(getQuestaoAtual().getId())){
                       valorRespostaSelecionada= String.valueOf(idResposta);
                       RespostaMonovalorada respostaMonovalorada = new RespostaMonovalorada();
                       try{
                        respostaMonovalorada = (RespostaMonovalorada) resposta;
                       }catch (Exception e){
                           respostaMonovalorada = null;
                       }
                       if(respostaMonovalorada != null && respostaMonovalorada.getRespostaOpcional() !=null){
                           RespostasDadas respostaDadaParaQuestaoOpcional = new RespostasDadas();
                           respostaDadaParaQuestaoOpcional = obtemRespostaDadaTipoTextual(listaRespostas);
                           respostasTextuais = respostaDadaParaQuestaoOpcional.getRespostasTextuais();
                       }
                    }
                }
            }
        }

        respostasDadas.setRespostasMonovaloradas(valorRespostaSelecionada);
        respostasDadas.setRespostasTextuais(respostasTextuais);
        return respostasDadas;
    }


    private RespostasDadas obtemRespostaDadaTipoTextual(List<RespostaDada> listaRespostasDadas) {

        RespostasDadas respostasDadas = new RespostasDadas();
        List<RespostaDada> respostasTextuais = new ArrayList<RespostaDada>();
        String valorRespostaSelecionada = null;

        for(int x = 0;x<listaRespostasDadas.size();x++ ){
                Resposta resposta ;
               if(listaRespostasDadas.get(x) !=null){
                    resposta = listaRespostasDadas.get(x).getResposta();
                    if(resposta !=null ){
                        Questao questaoRespostaDada = resposta.getQuestao();
                        if( questaoRespostaDada !=null && questaoRespostaDada.getId().equals(getQuestaoAtual().getId())){


                            RespostaDada respostaDada = new RespostaDada();
                            respostaDada = listaRespostasDadas.get(x);
                            RespostaTextual respTestMulti = null;
                            
                            try{
                                respTestMulti = (RespostaTextual) respostaDada.getResposta();
                            }catch(Exception e){
                                respTestMulti = null;
                            }
                            
                            if(respTestMulti != null){
                                 if(respTestMulti.getDataTypeResposta().equals(tipoQuestao.getDate())){
                                     String novoValor=null;
                                     String valorRespostaDada = respostaDada.getValor();
                                     if(valorRespostaDada !=null){
                                        try {

                                            
                                            Date date = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US).parse(valorRespostaDada);
                                            novoValor = new SimpleDateFormat("dd/MM/yyyy",Locale.US).format(date);
                                            respostaDada.setValor(novoValor);

                                        } catch (ParseException ex) {
                                            Logger.getLogger(InstrumentoController.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                     }


                                 }
                                if(respTestMulti.getDataTypeResposta().equals(tipoQuestao.getTime())){
                                    String valorRespostaDada = respostaDada.getValor();
                                    String novoValor=null;
                                    if(valorRespostaDada !=null){

                                        if(valorRespostaDada.length()>5){
                                            novoValor = valorRespostaDada.substring(11, 16);
                                        }else{
                                            novoValor = valorRespostaDada;
                                        }
                                        
                                    }
                                    respostaDada.setValor(novoValor);
                                }

                                respostasTextuais.add(respostaDada);
                            }
                        }
                    }
               }
            }

        respostasDadas.setRespostasMonovaloradas(valorRespostaSelecionada);
        respostasDadas.setRespostasTextuais(respostasTextuais);
        return respostasDadas;

    }


    public RespostasDadas obterRespostaDada(ColetaDados coletaDados) {
        
        RespostasDadas respostasDadas = new RespostasDadas();

        List<RespostaDada> listaRespostas = new ArrayList<RespostaDada>();
        listaRespostas =  coletaDados.getRespostasDadas();

        

        String tipoQuestaoAtual = getQuestaoAtual().getTipoResposta();

        if(tipoQuestao.getMonovalorada().equals(tipoQuestaoAtual)){
            respostasDadas = obtemRespostaDadaTipoMonovalorada(listaRespostas);
        }

        if(tipoQuestao.getTextual().equals(tipoQuestaoAtual)){
            respostasDadas = obtemRespostaDadaTipoTextual(listaRespostas);
        }

        


        return respostasDadas;

    }

    private RespostaDada obterRespostaDadaParaAdicionarTipoMonovalorada(String idRespostaSelecionada, List<RespostaDada> listaRespostas, List<RespostaDada> respostasPossiveisQuestoesTextuais) {
        RespostaMonovalorada respostaSel = null;
        Integer numeroRespostaSelecionada=null;
        if(idRespostaSelecionada !=null){
            numeroRespostaSelecionada = Integer.parseInt(idRespostaSelecionada);
        }
        respostaSel = (RespostaMonovalorada) getRespostaDAO().getById(numeroRespostaSelecionada,getEmf());
        if(respostaSel !=null && respostaSel.getRespostaOpcional() !=null){
            gravarRespostaTextual(listaRespostas,respostasPossiveisQuestoesTextuais);
        }else{
            listaRespostas = removerRespostaDadaAnteriormenteParaQuestaoAtual(listaRespostas);
        }

        

        RespostaDada respostaDada = new RespostaDada();
        respostaDada.setResposta(respostaSel);

        return respostaDada;
    }


    private void obterRespostaDadaParaAdicionarTipoTextual(List<RespostaDada> listaRespostas) {

        listaRespostas = removerRespostaDadaAnteriormenteParaQuestaoAtual(listaRespostas);

    }

    public List<Navegacao> defineQuestaoAtual(String acao,  ColetaDados coletaDados){



        int numeroQuestaoAtual = getQuestaoAtual().getNumero();


        Questao proximaQuestao = new Questao();
        proximaQuestao.setNumero(numeroQuestaoAtual);
        proximaQuestao.setInstrumento(getQuestaoAtual().getInstrumento());


        Questao questao = getQuestaoDAO().getByInstrumentoAndNumeroQuestao(acao, proximaQuestao, getEmf());

        boolean questaoAtualValida = verificaSeQuestaoAtualValida(questao, coletaDados);

        
        setQuestaoAtual(questao);

        if(!questaoAtualValida){
            if(acao.equals("NAVEGACAO")){
                acao = "PROXIMO";
            }
            defineQuestaoAtual(acao, coletaDados);
        }

        List<Navegacao> questoes;
        questoes = obterMenuNavegacao(questaoAtual.getInstrumento(),coletaDados);
        return questoes;

    }


    private boolean verificaSeQuestaoAtualValida(Questao questao, ColetaDados coletaDados) {
        boolean questaoAtualValida = true;
        if(questao.getRenderedIfResposta() != null && questao.getRenderedIfResposta().size()>0){
            List<RenderedIfResposta> respostaPreNecessaria = questao.getRenderedIfResposta();
            List<Logica> lista = new ArrayList<Logica>();

            //Validações de Null - Não afeta na regra de negocio
            if(respostaPreNecessaria !=null && coletaDados != null && coletaDados.getRespostasDadas() !=null ){

                for(RenderedIfResposta resposta : respostaPreNecessaria){
                    Logica logica = new Logica();
                    if(resposta.isObrigatoria()){
                        logica.setObrigatorio(true);
                    }
                    for(RespostaDada respostaDada : coletaDados.getRespostasDadas()){
                        //Validações de Null - Não afeta na regra de negocio
                        if(respostaDada != null && respostaDada.getResposta() != null && respostaDada.getResposta().getId() != null){
                            if(respostaDada.getResposta().getId().equals(resposta.getResposta().getId())){
                                logica.setLocalizado(true);
                            }
                        }
                    }
                    lista.add(logica);
                }
            }

            for (Logica logica : lista) {
                if(logica.isObrigatorio() && ! logica.isLocalizado()){
                    questaoAtualValida = false;
                    break;
                }
                if(!logica.isObrigatorio() && logica.isLocalizado()){
                    questaoAtualValida = true;
                    break;
                }
                if(!logica.isObrigatorio() && !logica.isLocalizado()){
                    questaoAtualValida = false;
                }
            }

        }
        return questaoAtualValida;
    }
    public class Logica{
        private boolean localizado;
        private boolean obrigatorio;

        /**
         * @return the obrigatorio
         */
        public boolean isObrigatorio() {
            return obrigatorio;
        }

        /**
         * @param obrigatorio the obrigatorio to set
         */
        public void setObrigatorio(boolean obrigatorio) {
            this.obrigatorio = obrigatorio;
        }

        /**
         * @return the localizado
         */
        public boolean isLocalizado() {
            return localizado;
        }

        /**
         * @param localizado the localizado to set
         */
        public void setLocalizado(boolean localizado) {
            this.localizado = localizado;
        }

    }

    public void saveColetaDados(ColetaDados coletaDados,UserTransaction utx,List<RespostaMaterial> materiais){
        coletaDados.setDataLancamento(new Date());

        coletaDadosDAO.saveColetaDados(coletaDados, emf, utx);
        for (RespostaMaterial respostaMaterial : materiais) {
            respostaMaterial.setColeta(coletaDados);
        }
         respostaMaterialDAO.save(materiais, emf, utx);
    }

    /**
     * @return the questaoAtual
     */
    public Questao getQuestaoAtual() {
        return questaoAtual;
    }

    /**
     * @param questaoAtual the questaoAtual to set
     */
    public void setQuestaoAtual(Questao questaoAtual) {
        this.questaoAtual = questaoAtual;
    }

    private QuestaoDAO getQuestaoDAO() {
        return questaoDAO;
    }

    private void setQuestaoDAO(QuestaoDAO questaoDAO) {
        this.questaoDAO = questaoDAO;
    }

    private InstrumentoDAO getInstrumentoDAO() {
        return instrumentoDAO;
    }

    private void setInstrumentoDAO(InstrumentoDAO instrumentoDAO) {
        this.instrumentoDAO = instrumentoDAO;
    }

    private RespostaDAO getRespostaDAO() {
        return respostaDAO;
    }

    private void setRespostaDAO(RespostaDAO respostaDAO) {
        this.respostaDAO = respostaDAO;
    }

    private ColetaDadosDAO getColetaDadosDAO() {
        return coletaDadosDAO;
    }

    private void setColetaDadosDAO(ColetaDadosDAO coletaDadosDAO) {
        this.coletaDadosDAO = coletaDadosDAO;
    }

    /**
     * @return the emf
     */
    private EntityManagerFactory getEmf() {
        return emf;
    }

    /**
     * @param emf the emf to set
     */
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }



}