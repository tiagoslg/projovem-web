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
public class FiltrosVo implements Serializable{

    private Integer idRotinaEscolhida;
    private String rotinaEscolhida;
    private boolean rotinaAguardandoValidacao;
    private String irEscolhida;
    private String coordenacaoEscolhida;
    private String municipioEscolhida;
    private String entradaEscolhida;
    private String supervisorEscolhida;
    private String dataInicialEscolhida;
    private String dataFinalEscolhida;

    public String getCoordenacaoEscolhida() {
        return coordenacaoEscolhida;
    }

    public void setCoordenacaoEscolhida(String coordenacaoEscolhida) {
        this.coordenacaoEscolhida = coordenacaoEscolhida;
    }

    public String getDataFinalEscolhida() {
        return dataFinalEscolhida;
    }

    public void setDataFinalEscolhida(String dataFinalEscolhida) {
        this.dataFinalEscolhida = dataFinalEscolhida;
    }

    public String getDataInicialEscolhida() {
        return dataInicialEscolhida;
    }

    public void setDataInicialEscolhida(String dataInicialEscolhida) {
        this.dataInicialEscolhida = dataInicialEscolhida;
    }

    public String getEntradaEscolhida() {
        return entradaEscolhida;
    }

    public void setEntradaEscolhida(String entradaEscolhida) {
        this.entradaEscolhida = entradaEscolhida;
    }

    public Integer getIdRotinaEscolhida() {
        return idRotinaEscolhida;
    }

    public void setIdRotinaEscolhida(Integer idRotinaEscolhida) {
        this.idRotinaEscolhida = idRotinaEscolhida;
    }

    public String getIrEscolhida() {
        return irEscolhida;
    }

    public void setIrEscolhida(String irEscolhida) {
        this.irEscolhida = irEscolhida;
    }

    public String getRotinaEscolhida() {
        return rotinaEscolhida;
    }

    public void setRotinaEscolhida(String rotinaEscolhida) {
        this.rotinaEscolhida = rotinaEscolhida;
    }

    public String getSupervisorEscolhida() {
        return supervisorEscolhida;
    }

    public void setSupervisorEscolhida(String supervisorEscolhida) {
        this.supervisorEscolhida = supervisorEscolhida;
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

    public String getMunicipioEscolhida() {
        return municipioEscolhida;
    }

    public void setMunicipioEscolhida(String municipioEscolhida) {
        this.municipioEscolhida = municipioEscolhida;
    }

    
    
}
