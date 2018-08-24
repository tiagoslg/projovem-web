/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projovem.rotinas.R001;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import projovem.entity.Usuario;

/**
 *
 * @author admprojovem
 */
@Entity
@Table
public class Rotina001 implements Serializable{
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;

    //Cabeçalho
    @OneToOne
    private Usuario usuario;

    @Column(nullable = true)
    private String dataInsercao;
    @Column(nullable = true)
    private String horaInsercao;

    @Column(nullable = true, length = 250)
    private String identificaEntradaUf;
    @Column(nullable = true, length = 250)
    private String identificaEntradaCoordenacao;
    @Column(nullable = true, length = 250)
    private String identificaEntradaMunicipio;
    @Column(nullable = true, length = 250)
    private String identificaEntradaEntrada;
    

    @Column(nullable = true)
    private String dataVisita;
    @Column(nullable = true, length = 250)
    private String horaInicioVisita;
    @Column(nullable = true, length = 250)
    private String horaTerminoVisita;
    @Column(nullable = true, length = 250)
    private String nomeLocal;
    @Column(nullable = true, length = 250)
    private String enderecoLocal;
    @Column(nullable = true, length = 250)
    private String bairroLocal;
    @Column(nullable = true, length = 250)
    private String numeroLocal;
    @Column(nullable = true, length = 250)
    private String complementoLocal;
    @Column(nullable = true, length = 250)
    private String cidadeLocal;
    @Column(nullable = true, length = 250)
    private String ufLocal;
    @Column(nullable = true, length = 250)
    private String cepLocal;
    @Column(nullable = true, length = 250)
    private String telefoneLocal;
    @Column(nullable = true, length = 250)
    private String classificacaoLocal;
    @Column(nullable = true, length = 250)
    private String classificacaoLocalComplemento;

    @Column(nullable = true, length = 250)
    private String funcionavaAnteriormenteEmOutroLocal;
    @Column(nullable = true, length = 250)
    private String funcionavaAnteriormenteEmOutroLocalComplemento;

    @Column(nullable = true, length = 250)
    private String Q1Aabertura;
    @Column(nullable = true, length = 250)
    private String Q1Afechamento;
    @Column(nullable = true, length = 250)
    private String Q1Babertura;
    @Column(nullable = true, length = 250)
    private String Q1Bfechamento;
    @Column(nullable = true, length = 250)
    private String Q1Cabertura;
    @Column(nullable = true, length = 250)
    private String Q1Cfechamento;

    @Column(nullable = true, length = 250)
    private String Q2;
    @Column(nullable = true, length = 250)
    private String Q3;

    @Transient
    private List<String> listQ4 = new ArrayList<String>();
    @Column(nullable = true, length = 250)
    private String Q4InternetBandaLarga;
    @Column(nullable = true, length = 250)
    private String Q4InternetDiscada;
    @Column(nullable = true, length = 250)
    private String Q4OutrasFormas;
    @Column(nullable = true, length = 250)
    private String Q4NaoHavia;

    @Column(nullable = true, length = 250)
    private String Q5;
    @Column(nullable = true, length = 250)
    private String Q6a;
    @Column(nullable = true, length = 250)
    private String Q6b;
    @Column(nullable = true, length = 250)
    private String Q6c;
    @Column(nullable = true, length = 250)
    private String Q7a;
    @Column(nullable = true, length = 250)
    private String Q7b;
    @Column(nullable = true, length = 250)
    private String Q7c;
    @Column(nullable = true, length = 250)
    private String Q7d;
    @Column(nullable = true, length = 250)
    private String Q8a;
    @Column(nullable = true, length = 250)
    private String Q8b;
    @Column(nullable = true, length = 250)
    private String Q9;
    @Column(nullable = true, length = 250)
    private String Q10;
    @Column(nullable = true, length = 250)
    private String Q11;
    @Column(nullable = true, length = 1000)
    private String Q11Complemento;
    @Column(nullable = true, length = 250)
    private String Q12;
    @Column(nullable = true, length = 1000)
    private String Q12Complemento;
    @Column(nullable = true, length = 250)
    private String Q13;
    @Column(nullable = true, length = 1000)
    private String Q13Complemento;
    @Column(nullable = true, length = 250)
    private String Q14;
    @Column(nullable = true, length = 1000)
    private String Q14Complemento;
    @Column(nullable = true, length = 250)
    private String Q15;
    @Column(nullable = true, length = 1000)
    private String Q15Complemento;
    @Column(nullable = true, length = 250)
    private String Q16;
    @Column(nullable = true, length = 1000)
    private String Q16Complemento;
    @Column(nullable = true, length = 250)
    private String Q17;
    @Column(nullable = true, length = 1000)
    private String Q17Complemento;

    @Column(nullable = true)
    private String dadosValidos;
    @Column(nullable = true)
    private Integer usrResponsavelValidacao;
    @Column(nullable = true)
    private String dataValidacao;
    @Column(nullable = true)
    private String horaValidacao;

    @Column(nullable = true)
    private String dadosEditados;
    @Column(nullable = true)
    private Integer usrResponsavelEdicao;
    @Column(nullable = true)
    private String dataEdicao;
    @Column(nullable = true)
    private String horaEdicao;

    @Column(nullable = true)
    private Integer versaoFormulario;

    public Integer getVersaoFormulario() {
        return versaoFormulario;
    }

    public void setVersaoFormulario(Integer versaoFormulario) {
        this.versaoFormulario = versaoFormulario;
    }

    public String getQ10() {
        return Q10;
    }

    public void setQ10(String Q10) {
        this.Q10 = Q10;
    }

    public String getQ11() {
        return Q11;
    }

    public void setQ11(String Q11) {
        this.Q11 = Q11;
    }

    public String getQ11Complemento() {
        return Q11Complemento;
    }

    public void setQ11Complemento(String Q11Complemento) {
        this.Q11Complemento = Q11Complemento;
    }

    public String getQ12() {
        return Q12;
    }

    public void setQ12(String Q12) {
        this.Q12 = Q12;
    }

    public String getQ12Complemento() {
        return Q12Complemento;
    }

    public void setQ12Complemento(String Q12Complemento) {
        this.Q12Complemento = Q12Complemento;
    }

    public String getQ13() {
        return Q13;
    }

    public void setQ13(String Q13) {
        this.Q13 = Q13;
    }

    public String getQ13Complemento() {
        return Q13Complemento;
    }

    public void setQ13Complemento(String Q13Complemento) {
        this.Q13Complemento = Q13Complemento;
    }

    public String getQ14() {
        return Q14;
    }

    public void setQ14(String Q14) {
        this.Q14 = Q14;
    }

    public String getQ14Complemento() {
        return Q14Complemento;
    }

    public void setQ14Complemento(String Q14Complemento) {
        this.Q14Complemento = Q14Complemento;
    }

    public String getQ15() {
        return Q15;
    }

    public void setQ15(String Q15) {
        this.Q15 = Q15;
    }

    public String getQ15Complemento() {
        return Q15Complemento;
    }

    public void setQ15Complemento(String Q15Complemento) {
        this.Q15Complemento = Q15Complemento;
    }

    public String getQ16() {
        return Q16;
    }

    public void setQ16(String Q16) {
        this.Q16 = Q16;
    }

    public String getQ16Complemento() {
        return Q16Complemento;
    }

    public void setQ16Complemento(String Q16Complemento) {
        this.Q16Complemento = Q16Complemento;
    }

    public String getQ17() {
        return Q17;
    }

    public void setQ17(String Q17) {
        this.Q17 = Q17;
    }

    public String getQ17Complemento() {
        return Q17Complemento;
    }

    public void setQ17Complemento(String Q17Complemento) {
        this.Q17Complemento = Q17Complemento;
    }

    public String getQ1Aabertura() {
        return Q1Aabertura;
    }

    public void setQ1Aabertura(String Q1Aabertura) {
        this.Q1Aabertura = Q1Aabertura;
    }

    public String getQ1Afechamento() {
        return Q1Afechamento;
    }

    public void setQ1Afechamento(String Q1Afechamento) {
        this.Q1Afechamento = Q1Afechamento;
    }

    public String getQ1Babertura() {
        return Q1Babertura;
    }

    public void setQ1Babertura(String Q1Babertura) {
        this.Q1Babertura = Q1Babertura;
    }

    public String getQ1Bfechamento() {
        return Q1Bfechamento;
    }

    public void setQ1Bfechamento(String Q1Bfechamento) {
        this.Q1Bfechamento = Q1Bfechamento;
    }

    public String getQ1Cabertura() {
        return Q1Cabertura;
    }

    public void setQ1Cabertura(String Q1Cabertura) {
        this.Q1Cabertura = Q1Cabertura;
    }

    public String getQ1Cfechamento() {
        return Q1Cfechamento;
    }

    public void setQ1Cfechamento(String Q1Cfechamento) {
        this.Q1Cfechamento = Q1Cfechamento;
    }

    public String getQ2() {
        return Q2;
    }

    public void setQ2(String Q2) {
        this.Q2 = Q2;
    }

    public String getQ3() {
        return Q3;
    }

    public void setQ3(String Q3) {
        this.Q3 = Q3;
    }

    public String getQ4InternetBandaLarga() {
        return Q4InternetBandaLarga;
    }

    public void setQ4InternetBandaLarga(String Q4InternetBandaLarga) {
        this.Q4InternetBandaLarga = Q4InternetBandaLarga;
    }

    public String getQ4InternetDiscada() {
        return Q4InternetDiscada;
    }

    public void setQ4InternetDiscada(String Q4InternetDiscada) {
        this.Q4InternetDiscada = Q4InternetDiscada;
    }

    public String getQ4NaoHavia() {
        return Q4NaoHavia;
    }

    public void setQ4NaoHavia(String Q4NaoHavia) {
        this.Q4NaoHavia = Q4NaoHavia;
    }

    public String getQ4OutrasFormas() {
        return Q4OutrasFormas;
    }

    public void setQ4OutrasFormas(String Q4OutrasFormas) {
        this.Q4OutrasFormas = Q4OutrasFormas;
    }



    public String getQ5() {
        return Q5;
    }

    public void setQ5(String Q5) {
        this.Q5 = Q5;
    }

    public String getQ6a() {
        return Q6a;
    }

    public void setQ6a(String Q6a) {
        this.Q6a = Q6a;
    }

    public String getQ6b() {
        return Q6b;
    }

    public void setQ6b(String Q6b) {
        this.Q6b = Q6b;
    }

    public String getQ6c() {
        return Q6c;
    }

    public void setQ6c(String Q6c) {
        this.Q6c = Q6c;
    }

    public String getQ7a() {
        return Q7a;
    }

    public void setQ7a(String Q7a) {
        this.Q7a = Q7a;
    }

    public String getQ7b() {
        return Q7b;
    }

    public void setQ7b(String Q7b) {
        this.Q7b = Q7b;
    }

    public String getQ7c() {
        return Q7c;
    }

    public void setQ7c(String Q7c) {
        this.Q7c = Q7c;
    }

    public String getQ7d() {
        return Q7d;
    }

    public void setQ7d(String Q7d) {
        this.Q7d = Q7d;
    }

    public String getQ8a() {
        return Q8a;
    }

    public void setQ8a(String Q8a) {
        this.Q8a = Q8a;
    }

    public String getQ8b() {
        return Q8b;
    }

    public void setQ8b(String Q8b) {
        this.Q8b = Q8b;
    }

    public String getQ9() {
        return Q9;
    }

    public void setQ9(String Q9) {
        this.Q9 = Q9;
    }

    public String getBairroLocal() {
        return bairroLocal;
    }

    public void setBairroLocal(String bairroLocal) {
        this.bairroLocal = bairroLocal;
    }

    public String getCepLocal() {
        return cepLocal;
    }

    public void setCepLocal(String cepLocal) {
        this.cepLocal = cepLocal;
    }

    public String getCidadeLocal() {
        return cidadeLocal;
    }

    public void setCidadeLocal(String cidadeLocal) {
        this.cidadeLocal = cidadeLocal;
    }

    public String getClassificacaoLocal() {
        return classificacaoLocal;
    }

    public void setClassificacaoLocal(String classificacaoLocal) {
        this.classificacaoLocal = classificacaoLocal;
    }

    public String getClassificacaoLocalComplemento() {
        return classificacaoLocalComplemento;
    }

    public void setClassificacaoLocalComplemento(String classificacaoLocalComplemento) {
        this.classificacaoLocalComplemento = classificacaoLocalComplemento;
    }

    public String getComplementoLocal() {
        return complementoLocal;
    }

    public void setComplementoLocal(String complementoLocal) {
        this.complementoLocal = complementoLocal;
    }

    public String getDataVisita() {
        return dataVisita;
    }

    public void setDataVisita(String dataVisita) {
        this.dataVisita = dataVisita;
    }

    public String getEnderecoLocal() {
        return enderecoLocal;
    }

    public void setEnderecoLocal(String enderecoLocal) {
        this.enderecoLocal = enderecoLocal;
    }

    public String getFuncionavaAnteriormenteEmOutroLocal() {
        return funcionavaAnteriormenteEmOutroLocal;
    }

    public void setFuncionavaAnteriormenteEmOutroLocal(String funcionavaAnteriormenteEmOutroLocal) {
        this.funcionavaAnteriormenteEmOutroLocal = funcionavaAnteriormenteEmOutroLocal;
    }

    public String getFuncionavaAnteriormenteEmOutroLocalComplemento() {
        return funcionavaAnteriormenteEmOutroLocalComplemento;
    }

    public void setFuncionavaAnteriormenteEmOutroLocalComplemento(String funcionavaAnteriormenteEmOutroLocalComplemento) {
        this.funcionavaAnteriormenteEmOutroLocalComplemento = funcionavaAnteriormenteEmOutroLocalComplemento;
    }

    public String getHoraInicioVisita() {
        return horaInicioVisita;
    }

    public void setHoraInicioVisita(String horaInicioVisita) {
        this.horaInicioVisita = horaInicioVisita;
    }

    public String getHoraTerminoVisita() {
        return horaTerminoVisita;
    }

    public void setHoraTerminoVisita(String horaTerminoVisita) {
        this.horaTerminoVisita = horaTerminoVisita;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeLocal() {
        return nomeLocal;
    }

    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    public String getNumeroLocal() {
        return numeroLocal;
    }

    public void setNumeroLocal(String numeroLocal) {
        this.numeroLocal = numeroLocal;
    }

    public String getTelefoneLocal() {
        return telefoneLocal;
    }

    public void setTelefoneLocal(String telefoneLocal) {
        this.telefoneLocal = telefoneLocal;
    }

    public String getUfLocal() {
        return ufLocal;
    }

    public void setUfLocal(String ufLocal) {
        this.ufLocal = ufLocal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the listQ4
     */
    public List<String> getListQ4() {
        return listQ4;
    }

    /**
     * @param listQ4 the listQ4 to set
     */
    public void setListQ4(List<String> listQ4) {
        this.listQ4 = listQ4;
    }

    /**
     * @return the identificaEntradaUf
     */
    public String getIdentificaEntradaUf() {
        return identificaEntradaUf;
    }

    /**
     * @param identificaEntradaUf the identificaEntradaUf to set
     */
    public void setIdentificaEntradaUf(String identificaEntradaUf) {
        this.identificaEntradaUf = identificaEntradaUf;
    }

    /**
     * @return the identificaEntradaCoordenacao
     */
    public String getIdentificaEntradaCoordenacao() {
        return identificaEntradaCoordenacao;
    }

    /**
     * @param identificaEntradaCoordenacao the identificaEntradaCoordenacao to set
     */
    public void setIdentificaEntradaCoordenacao(String identificaEntradaCoordenacao) {
        this.identificaEntradaCoordenacao = identificaEntradaCoordenacao;
    }

    /**
     * @return the identificaEntradaMunicipio
     */
    public String getIdentificaEntradaMunicipio() {
        return identificaEntradaMunicipio;
    }

    /**
     * @param identificaEntradaMunicipio the identificaEntradaMunicipio to set
     */
    public void setIdentificaEntradaMunicipio(String identificaEntradaMunicipio) {
        this.identificaEntradaMunicipio = identificaEntradaMunicipio;
    }

    /**
     * @return the identificaEntradaEntrada
     */
    public String getIdentificaEntradaEntrada() {
        return identificaEntradaEntrada;
    }

    /**
     * @param identificaEntradaEntrada the identificaEntradaEntrada to set
     */
    public void setIdentificaEntradaEntrada(String identificaEntradaEntrada) {
        this.identificaEntradaEntrada = identificaEntradaEntrada;
    }

    /**
     * @return the dataInsercao
     */
    public String getDataInsercao() {
        return dataInsercao;
    }

    /**
     * @param dataInsercao the dataInsercao to set
     */
    public void setDataInsercao(String dataInsercao) {
        this.dataInsercao = dataInsercao;
    }

    /**
     * @return the horaInsercao
     */
    public String getHoraInsercao() {
        return horaInsercao;
    }

    /**
     * @param horaInsercao the horaInsercao to set
     */
    public void setHoraInsercao(String horaInsercao) {
        this.horaInsercao = horaInsercao;
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
     * @return the usrResponsavelValidacao
     */
    public Integer getUsrResponsavelValidacao() {
        return usrResponsavelValidacao;
    }

    /**
     * @param usrResponsavelValidacao the usrResponsavelValidacao to set
     */
    public void setUsrResponsavelValidacao(Integer usrResponsavelValidacao) {
        this.usrResponsavelValidacao = usrResponsavelValidacao;
    }

    /**
     * @return the dataValidacao
     */
    public String getDataValidacao() {
        return dataValidacao;
    }

    /**
     * @param dataValidacao the dataValidacao to set
     */
    public void setDataValidacao(String dataValidacao) {
        this.dataValidacao = dataValidacao;
    }

    /**
     * @return the horaValidacao
     */
    public String getHoraValidacao() {
        return horaValidacao;
    }

    /**
     * @param horaValidacao the horaValidacao to set
     */
    public void setHoraValidacao(String horaValidacao) {
        this.horaValidacao = horaValidacao;
    }

    /**
     * @return the dadosEditados
     */
    public String getDadosEditados() {
        return dadosEditados;
    }

    /**
     * @param dadosEditados the dadosEditados to set
     */
    public void setDadosEditados(String dadosEditados) {
        this.dadosEditados = dadosEditados;
    }

    /**
     * @return the usrResponsavelEdicao
     */
    public Integer getUsrResponsavelEdicao() {
        return usrResponsavelEdicao;
    }

    /**
     * @param usrResponsavelEdicao the usrResponsavelEdicao to set
     */
    public void setUsrResponsavelEdicao(Integer usrResponsavelEdicao) {
        this.usrResponsavelEdicao = usrResponsavelEdicao;
    }

    /**
     * @return the dataEdicao
     */
    public String getDataEdicao() {
        return dataEdicao;
    }

    /**
     * @param dataEdicao the dataEdicao to set
     */
    public void setDataEdicao(String dataEdicao) {
        this.dataEdicao = dataEdicao;
    }

    /**
     * @return the horaEdicao
     */
    public String getHoraEdicao() {
        return horaEdicao;
    }

    /**
     * @param horaEdicao the horaEdicao to set
     */
    public void setHoraEdicao(String horaEdicao) {
        this.horaEdicao = horaEdicao;
    }
    
}
