/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projovem.relatorios.rotinaslancadas.vo;

import java.io.Serializable;

/**
 *
 * @author admprojovem
 */
public class RotinasLancadasVO implements Serializable {

    private Integer id;
    private String rotina;
    private String usuario;
    private String nucleo;
    private String coordenacao;
    private String municipio;
    private String uf;
    private String entrada;
    private Integer idRotina;
    private String dadosValidos;
    private String dataVisita;
    private String ciclo;
    private String identificaEntradaObservacao;

    public String getIdentificaEntradaObservacao() {
        return identificaEntradaObservacao;
    }

    public void setIdentificaEntradaObservacao(String identificaEntradaObservacao) {
        this.identificaEntradaObservacao = identificaEntradaObservacao;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    

    public String getCoordenacao() {
        return coordenacao;
    }

    public void setCoordenacao(String coordenacao) {
        this.coordenacao = coordenacao;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }


    
    public String getNucleo() {
        return nucleo;
    }

    public void setNucleo(String nucleo) {
        this.nucleo = nucleo;
    }

    public String getRotina() {
        return rotina;
    }

    public void setRotina(String rotina) {
        this.rotina = rotina;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the entrada
     */
    public String getEntrada() {
        return entrada;
    }

    /**
     * @param entrada the entrada to set
     */
    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    /**
     * @return the idRotina
     */
    public Integer getIdRotina() {
        return idRotina;
    }

    /**
     * @param idRotina the idRotina to set
     */
    public void setIdRotina(Integer idRotina) {
        this.idRotina = idRotina;
    }

    /**
     * @return the dadosValidos
     */
    public String getDadosValidos() {
        return dadosValidos;
    }

    /**
     * @param dadosValidos the dadosValidos to set
     */
    public void setDadosValidos(String dadosValidos) {
        this.dadosValidos = dadosValidos;
    }

    /**
     * @return the dataVisita
     */
    public String getDataVisita() {
        return dataVisita;
    }

    /**
     * @param dataVisita the dataVisita to set
     */
    public void setDataVisita(String dataVisita) {
        this.dataVisita = dataVisita;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

}
