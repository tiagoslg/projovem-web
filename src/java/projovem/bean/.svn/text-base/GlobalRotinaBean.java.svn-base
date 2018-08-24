/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.bean;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;
import projovem.controller.InstrumentoController;
import projovem.dao.ColetaDadosDAO;
import projovem.dao.RespostaDAO;
import projovem.entity.ColetaDados;
import projovem.entity.Instrumento;
import projovem.entity.Local;
import projovem.entity.Resposta;
import projovem.entity.RespostaDada;
import projovem.entity.RespostaMonovalorada;
import projovem.entity.RespostaTextual;
import projovem.vo.Relatorio;
import projovem.vo.ResumoRespostas;
import projovem.vo.ResumoRespostasSelectItem;
import projovem.vo.TipoQuestao;

/**
 *
 * @author admprojovem
 */
public class GlobalRotinaBean implements Serializable {

    @Resource
    private UserTransaction utx;
    @PersistenceUnit(unitName = "projovemPU")
    private EntityManagerFactory emf;
    private List<ColetaDados> coletaDados = new ArrayList<ColetaDados>();
    private ColetaDadosDAO coletaDadosDAO = new ColetaDadosDAO();
    private InstrumentoController controller = new InstrumentoController();
    private List<ColetaDadosVO> listColeta = new ArrayList<ColetaDadosVO>();
    private List<Relatorio> relatorios = new ArrayList<Relatorio>();
    private TipoQuestao tipoQuestao = new TipoQuestao();
    private List<objeto> listaJaAdicionada = new ArrayList<objeto>();
    private List<objeto> listaJaAdicionadaPositiva = new ArrayList<objeto>();
    private List<objeto> listaJaAdicionadaNegativa = new ArrayList<objeto>();
    private boolean renderedRespostas;
    private List<Local> listaLocal = new ArrayList<Local>();
    private Integer listaLocalSize;
    private String cordenacao;
    private String hoje;

    public void exibirRespostas() {
    }

    /**
     * @return the coletaDados
     */
    public List<ColetaDados> getColetaDados() {

        return coletaDados;
    }

    /**
     * @param coletaDados the coletaDados to set
     */
    public void setColetaDados(List<ColetaDados> coletaDados) {
        this.coletaDados = coletaDados;
    }

    /**
     * @return the coletaDadosDAO
     */
    public ColetaDadosDAO getColetaDadosDAO() {
        return coletaDadosDAO;
    }

    /**
     * @param coletaDadosDAO the coletaDadosDAO to set
     */
    public void setColetaDadosDAO(ColetaDadosDAO coletaDadosDAO) {
        this.coletaDadosDAO = coletaDadosDAO;
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

    public List<objeto> getListaJaAdicionada() {

        List<ColetaDadosVO> lista2 = getListColeta();

        List<ResumoRespostas> resumo2;
        List<ResumoRespostasSelectItem> respostasDoResumo;
        for (ColetaDadosVO coletaDadosVO : lista2) {
            Collections.sort(listaJaAdicionada, new RespComparator());
            resumo2 = coletaDadosVO.getResumo();
            for (ResumoRespostas resumoRespostas : resumo2) {
                respostasDoResumo = resumoRespostas.getResposta();

                String tipoResposta = tipoQuestao.getTextual();
                String textoAfirmativo = "";
                Integer peso = 0;

                if (resumoRespostas.getQuestaoObj() != null) {
                    tipoResposta = resumoRespostas.getQuestaoObj().getTipoResposta();
                    textoAfirmativo = resumoRespostas.getRespostaObj().getTextoAfirmativo();
                    peso = resumoRespostas.getRespostaObj().getPeso();
                }

                if (!tipoQuestao.getTextual().equals(tipoResposta) && peso != null && peso != 0) {
                    for (ResumoRespostasSelectItem resumoRespostasSelectItem : respostasDoResumo) {
                        boolean respostaAdicionada = false;

                        for (objeto object : listaJaAdicionada) {
                            if (resumoRespostasSelectItem.getOrdenacao() == object.getIdResposta() && (textoAfirmativo != null && !textoAfirmativo.isEmpty()) && !(resumoRespostasSelectItem.getLabel().isEmpty() && resumoRespostasSelectItem.getValue().isEmpty())) {

                                object.setQuantidade((Integer) (object.getQuantidade() + 1));
                                respostaAdicionada = true;
                                break;
                            }
                        }
                        if (!respostaAdicionada && (textoAfirmativo != null && !textoAfirmativo.isEmpty()) && !(resumoRespostasSelectItem.getLabel().isEmpty() && resumoRespostasSelectItem.getValue().isEmpty())) {
                            objeto obj = new objeto();
                            obj.setIdResposta(resumoRespostasSelectItem.getOrdenacao());
                            obj.setQuantidade((Integer) 1);
                            obj.setTexto(textoAfirmativo);
                            obj.setPeso(peso);
                            listaJaAdicionada.add(obj);
                        }
                    }
                }
            }


        }

        for (objeto object : listaJaAdicionada) {
            if (object.getPeso() != null && object.getPeso() > 0) {
                listaJaAdicionadaPositiva.add(object);
            } else {
                listaJaAdicionadaNegativa.add(object);
            }
        }


        return listaJaAdicionada;
    }

    /**
     * @return the listaJaAdicionadaPositiva
     */
    public List<objeto> getListaJaAdicionadaPositiva() {

        return listaJaAdicionadaPositiva;
    }

    /**
     * @param listaJaAdicionadaPositiva the listaJaAdicionadaPositiva to set
     */
    public void setListaJaAdicionadaPositiva(List<objeto> listaJaAdicionadaPositiva) {
        this.listaJaAdicionadaPositiva = listaJaAdicionadaPositiva;
    }

    /**
     * @return the listaJaAdicionadaNegativa
     */
    public List<objeto> getListaJaAdicionadaNegativa() {
        return listaJaAdicionadaNegativa;
    }

    /**
     * @param listaJaAdicionadaNegativa the listaJaAdicionadaNegativa to set
     */
    public void setListaJaAdicionadaNegativa(List<objeto> listaJaAdicionadaNegativa) {
        this.listaJaAdicionadaNegativa = listaJaAdicionadaNegativa;
    }

    /**
     * @return the listaLocal
     */
    public List<Local> getListaLocal() {

        return listaLocal;
    }

    /**
     * @param listaLocal the listaLocal to set
     */
    public void setListaLocal(List<Local> listaLocal) {
        this.listaLocal = listaLocal;
    }

    /**
     * @return the listaLocalSize
     */
    public Integer getListaLocalSize() {
        return listaLocal.size();
    }

    /**
     * @param listaLocalSize the listaLocalSize to set
     */
    public void setListaLocalSize(Integer listaLocalSize) {
        this.listaLocalSize = listaLocalSize;
    }

    /**
     * @return the cordenacao
     */
    public String getCordenacao() {
        getListaJaAdicionada();
        return cordenacao;
    }

    /**
     * @param cordenacao the cordenacao to set
     */
    public void setCordenacao(String cordenacao) {
        this.cordenacao = cordenacao;
    }

    /**
     * @return the hoje
     */
    public String getHoje() {
        Date data = new Date();
        Locale local = new Locale("pt", "BR");
        DateFormat dateFormat = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", local);
        return dateFormat.format(data);

    }

    /**
     * @param hoje the hoje to set
     */
    public void setHoje(String hoje) {
        this.hoje = hoje;
    }

    private class RespComparator implements Comparator<objeto> {

        public int compare(objeto m1, objeto m2) {

            Integer nomeM1 = m1.getIdResposta();
            Integer nomeM2 = m2.getIdResposta();

            return nomeM1.compareTo(nomeM2);
        }
    }

    /**
     * @param listaJaAdicionada the listaJaAdicionada to set
     */
    public void setListaJaAdicionada(List<objeto> listaJaAdicionada) {
        this.listaJaAdicionada = listaJaAdicionada;
    }

    public class objeto {

        private Integer idResposta;
        private Integer quantidade;
        private String texto;
        private Integer peso;

        /**
         * @return the idResposta
         */
        public Integer getIdResposta() {
            return idResposta;
        }

        /**
         * @param idResposta the idResposta to set
         */
        public void setIdResposta(Integer idResposta) {
            this.idResposta = idResposta;
        }

        /**
         * @return the quantidade
         */
        public Integer getQuantidade() {
            return quantidade;
        }

        /**
         * @param quantidade the quantidade to set
         */
        public void setQuantidade(Integer quantidade) {
            this.quantidade = quantidade;
        }

        /**
         * @return the texto
         */
        public String getTexto() {
            return texto;
        }

        /**
         * @param texto the texto to set
         */
        public void setTexto(String texto) {
            this.texto = texto;
        }

        /**
         * @return the peso
         */
        public Integer getPeso() {
            return peso;
        }

        /**
         * @param peso the peso to set
         */
        public void setPeso(Integer peso) {
            this.peso = peso;
        }
    }

    /**
     * @return the listColeta
     */
    public List<ColetaDadosVO> getListColeta() {
        Integer count = 0;
        List<ColetaDadosVO> lista = new ArrayList<ColetaDadosVO>();
        setColetaDados(getColetaDadosDAO().getByInstrumento(7, emf));
        setCordenacao("Municipal de Belém");
        //setColetaDados(getColetaDadosDAO().getByInstrumento(1, emf));
        List<ResumoRespostas> resumo;
        for (ColetaDados coleta : getColetaDados()) {
            /*
            if (!listaLocal.contains(coleta.getEnderecoLocal().getLocal())) {
                listaLocal.add(coleta.getEnderecoLocal().getLocal());
            }

*/
            count++;
            ColetaDadosVO coletaVO = new ColetaDadosVO();
            coletaVO.setColetaDados(coleta);
            resumo = getController().obterResumoDasRespostas(coleta);
            Instrumento instrumento = coleta.getInstrumento();
            resumo = getController().adicionarPerguntasNaoRespondidas(resumo, instrumento, emf);
            coletaVO.setResumo(resumo);
            coletaVO.setPosisao(count);
            lista.add(coletaVO);
        }
        listColeta = lista;
        setRenderedRespostas(true);








        return listColeta;
    }

    /**
     * @param listColeta the listColeta to set
     */
    public void setListColeta(List<ColetaDadosVO> listColeta) {
        this.listColeta = listColeta;
    }

    /**
     * @return the renderedRespostas
     */
    public boolean isRenderedRespostas() {
        return renderedRespostas;
    }

    /**
     * @param renderedRespostas the renderedRespostas to set
     */
    public void setRenderedRespostas(boolean renderedRespostas) {
        this.renderedRespostas = renderedRespostas;
    }

    /**
     * @return the relatorio
     */
    public List<Relatorio> getRelatorios() {
        RespostaDAO respostaDAO = new RespostaDAO();
        Instrumento instrumento = new Instrumento();
        instrumento.setId(4);

        List<Resposta> respostas = respostaDAO.getByInstrumento(instrumento, emf);

        for (Resposta resposta : respostas) {
            Relatorio rel = new Relatorio();
            rel.setQuestao(resposta.getQuestao());


            boolean adicionarQuestao = true;
            for (Relatorio paraVerificar : relatorios) {
                if (paraVerificar.getQuestao().getTitulo() != null && rel.getQuestao().getTitulo() != null) {
                    if (paraVerificar.getQuestao().getPergunta().equals(rel.getQuestao().getPergunta()) && paraVerificar.getQuestao().getTitulo().equals(rel.getQuestao().getTitulo())) {
                        adicionarQuestao = false;
                    }
                } else {
                    if (paraVerificar.getQuestao().getPergunta().equals(rel.getQuestao().getPergunta())) {
                        adicionarQuestao = false;
                    }

                }
            }
            if (adicionarQuestao) {
                ColetaDados coleta = new ColetaDados();
                coleta.setId(15);
                RespostaDada respostaDada = coletaDadosDAO.getByIdAndReposta(coleta, resposta, emf);
                rel.getRespostaDada().add(respostaDada);
                if (resposta.getQuestao().getTipoResposta().equals(tipoQuestao.getMonovalorada())) {
                    RespostaMonovalorada repostaMono = (RespostaMonovalorada) respostaDada.getResposta();
                    rel.getResposta().add(repostaMono);
                /*List<RespostaMonovalorada> respostaMono = null ;
                respostaMono = respostaDAO.getRespostaMonovaloradaByQuestao(resposta.getQuestao().getId(), emf);
                for (RespostaMonovalorada respostaMonovalorada : respostaMono) {
                rel.getResposta().add(respostaMonovalorada);
                }*/
                }

                if (resposta.getQuestao().getTipoResposta().equals(tipoQuestao.getTextual())) {
                    RespostaTextual repostaTextual = (RespostaTextual) respostaDada.getResposta();
                    rel.getResposta().add(repostaTextual);
                /* List<RespostaTextual> respostaTextual = null ;
                respostaTextual = respostaDAO.getRespostaTextualByQuestao(resposta.getQuestao().getId(), emf);
                for (RespostaTextual respostaText : respostaTextual) {
                rel.getResposta().add(respostaText);
                }*/
                }
                relatorios.add(rel);
            }
        }

        Collections.sort(relatorios, new ResumoComparator());
        return relatorios;
    }

    private class ResumoComparator implements Comparator<Relatorio> {

        public int compare(Relatorio m1, Relatorio m2) {

            Integer nomeM1 = m1.getQuestao().getNumero();
            Integer nomeM2 = m2.getQuestao().getNumero();

            return nomeM1.compareTo(nomeM2);
        }
    }

    /**
     * @param relatorio the relatorio to set
     */
    public void setRelatorios(List<Relatorio> relatorio) {
        this.relatorios = relatorio;
    }

    public class ColetaDadosVO {

        private ColetaDados coletaDados;
        private List<ResumoRespostas> resumo;
        private Integer posisao;

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
         * @return the posisao
         */
        public Integer getPosisao() {
            return posisao;
        }

        /**
         * @param posisao the posisao to set
         */
        public void setPosisao(Integer posisao) {
            this.posisao = posisao;
        }
    }
}
