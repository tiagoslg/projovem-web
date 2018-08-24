/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projovem.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import projovem.entity.Questao;
import projovem.entity.Resposta;

/**
 *
 * @author admprojovem
 */
public class ResumoRespostas implements Serializable {
    private Questao questaoObj;
    private Resposta respostaObj;
    private Integer numeroQuestao;
    private String questao;
    private String titulo;
    private List<ResumoRespostasSelectItem> resposta = new ArrayList<ResumoRespostasSelectItem>();


    /**
     * @return the questao
     */
    public String getQuestao() {
        return questao;
    }

    /**
     * @param questao the questao to set
     */
    public void setQuestao(String questao) {
        this.questao = questao;
    }

    /**
     * @return the resposta
     */
    public List<ResumoRespostasSelectItem> getResposta() {
        return resposta;
    }

    /**
     * @param resposta the resposta to set
     */
    public void setResposta(List<ResumoRespostasSelectItem> resposta) {
        this.resposta = resposta;
    }

    /**
     * @return the numeroQuestao
     */
    public Integer getNumeroQuestao() {
        return numeroQuestao;
    }

    /**
     * @param numeroQuestao the numeroQuestao to set
     */
    public void setNumeroQuestao(Integer numeroQuestao) {
        this.numeroQuestao = numeroQuestao;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the questaoObj
     */
    public Questao getQuestaoObj() {
        return questaoObj;
    }

    /**
     * @param questaoObj the questaoObj to set
     */
    public void setQuestaoObj(Questao questaoObj) {
        this.questaoObj = questaoObj;
    }

    /**
     * @return the respostaObj
     */
    public Resposta getRespostaObj() {
        return respostaObj;
    }

    /**
     * @param respostaObj the respostaObj to set
     */
    public void setRespostaObj(Resposta respostaObj) {
        this.respostaObj = respostaObj;
    }

}
