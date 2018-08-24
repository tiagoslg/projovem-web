/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.rotinas.R007;

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
public class Rotina007 implements Serializable {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;

        @Column(nullable = true)
    private String dataInsercao;
    @Column(nullable = true)
    private String horaInsercao;

    //Cabeçalho
    @OneToOne
    private Usuario usuario;
    @Column(nullable = true)
    private String dataAplicacao;
    @Column(nullable = true)
    private String nome;

           @Column(nullable = true, length = 250)
    private String identificaEntradaUf;
    @Column(nullable = true, length = 250)
    private String identificaEntradaCoordenacao;
    @Column(nullable = true, length = 250)
    private String identificaEntradaMunicipio;
    @Column(nullable = true, length = 250)
    private String identificaEntradaEntrada;
    @Column(nullable = true, length = 3)
    private String identificaEntradaObservacao;

    //Componente Curricular
    @Transient
    List<String> listComponenteCurricular = new ArrayList<String>();
    @Column(nullable = true, length = 250)
    private String componenteCurricularLinguaPortuguesa;
    @Column(nullable = true, length = 250)
    private String componenteCurricularMatematica;
    @Column(nullable = true, length = 250)
    private String componenteCurricularCienciasNatureza;
    @Column(nullable = true, length = 250)
    private String componenteCurricularQualificacaoProfissional;
    @Column(nullable = true, length = 250)
    private String componenteCurricularLinguaEstrangeira;
    @Column(nullable = true, length = 250)
    private String componenteCurricularCienciasHumanas;
    @Column(nullable = true, length = 250)
    private String componenteCurricularParticipacaoCidada;

    @Column(nullable = true, length = 250)
    private String Q1;
    @Column(nullable = true, length = 250)
    private String Q2;
    @Column(nullable = true, length = 250)
    private String Q3;
    @Column(nullable = true, length = 250)
    private String Q4;
    @Column(nullable = true, length = 250)
    private String Q5;

     @Transient
    List<String> listQ6 = new ArrayList<String>();
    @Column(nullable = true, length = 250)
    private String Q6a;
    @Column(nullable = true, length = 250)
    private String Q6b ;
    @Column(nullable = true, length = 250)
    private String Q6c;
    @Column(nullable = true, length = 250)
    private String Q6d;
    @Column(nullable = true, length = 250)
    private String Q6e;
    @Column(nullable = true, length = 250)
    private String Q6f;
    @Column(nullable = true, length = 250)
    private String Q6g;
    

    @Column(nullable = true, length = 250)
    private String Q7SoftwaresTexto;
    @Column(nullable = true, length = 250)
    private String Q7ConfeccaoPlanilhas;
    @Column(nullable = true, length = 250)
    private String Q7Internet;

    @Column(nullable = true, length = 250)
    private String Q8;
    @Column(nullable = true, length = 250)
    private String Q9;
    @Column(nullable = true, length = 250)
    private String Q10;
    @Column(nullable = true, length = 250)
    private String Q11;
    @Column(nullable = true, length = 250)
    private String Q12;
    @Column(nullable = true, length = 250)
    private String Q13;
    @Column(nullable = true, length = 250)
    private String Q14;
    @Column(nullable = true, length = 250)
    private String Q15;
    @Column(nullable = true, length = 250)
    private String Q16;
    @Column(nullable = true, length = 250)
    private String Q17;
    @Column(nullable = true, length = 250)
    private String Q18;
    @Column(nullable = true, length = 250)
    private String Q19;
    @Column(nullable = true, length = 250)
    private String Q20;
    @Column(nullable = true, length = 250)
    private String Q21;
    @Column(nullable = true, length = 250)
    private String Q22;
    @Column(nullable = true, length = 250)
    private String Q23;
    @Column(nullable = true, length = 250)
    private String Q24;
    @Column(nullable = true, length = 250)
    private String Q25;
    @Column(nullable = true, length = 250)
    private String Q26;
    @Column(nullable = true, length = 250)
    private String Q27;

    @Column(nullable = true, length = 250)
    private String exclusivoResponsavelAplicacaoQ1;
    @Column(nullable = true, length = 250)
    private String exclusivoResponsavelAplicacaoQ2;
    @Column(nullable = true, length = 250)
    private String exclusivoResponsavelAplicacaoQ3;
    @Column(nullable = true, length = 250)
    private String exclusivoResponsavelAplicacaoQ3Complemento;

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

    //Itens adicionados na versão 3 deste questionario
    @Column(nullable = true)
    private Integer numeroNucleos;
    @Column(nullable = true)
    private Integer numeroTurmas;
    @Column(nullable = true)
    private String Q10Outros;
    @Column(nullable = true)
    private String Q16Outros;
    @Column(nullable = true)
    private String Q28;
    @Column(nullable = true)
    private String Q29;
    @Column(nullable = true)
    private String Q30;

    public String getQ10Outros() {
        return Q10Outros;
    }

    public void setQ10Outros(String Q10Outros) {
        this.Q10Outros = Q10Outros;
    }

    public String getQ16Outros() {
        return Q16Outros;
    }

    public void setQ16Outros(String Q16Outros) {
        this.Q16Outros = Q16Outros;
    }

    public String getQ28() {
        return Q28;
    }

    public void setQ28(String Q28) {
        this.Q28 = Q28;
    }

    public String getQ29() {
        return Q29;
    }

    public void setQ29(String Q29) {
        this.Q29 = Q29;
    }

    public String getQ30() {
        return Q30;
    }

    public void setQ30(String Q30) {
        this.Q30 = Q30;
    }

    public Integer getNumeroNucleos() {
        return numeroNucleos;
    }

    public void setNumeroNucleos(Integer numeroNucleos) {
        this.numeroNucleos = numeroNucleos;
    }

    public Integer getNumeroTurmas() {
        return numeroTurmas;
    }

    public void setNumeroTurmas(Integer numeroTurmas) {
        this.numeroTurmas = numeroTurmas;
    }


    public String getQ1() {
        return Q1;
    }

    public void setQ1(String Q1) {
        this.Q1 = Q1;
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

    public String getQ12() {
        return Q12;
    }

    public void setQ12(String Q12) {
        this.Q12 = Q12;
    }

    public String getQ13() {
        return Q13;
    }

    public void setQ13(String Q13) {
        this.Q13 = Q13;
    }

    public String getQ14() {
        return Q14;
    }

    public void setQ14(String Q14) {
        this.Q14 = Q14;
    }

    public String getQ15() {
        return Q15;
    }

    public void setQ15(String Q15) {
        this.Q15 = Q15;
    }

    public String getQ16() {
        return Q16;
    }

    public void setQ16(String Q16) {
        this.Q16 = Q16;
    }

    public String getQ17() {
        return Q17;
    }

    public void setQ17(String Q17) {
        this.Q17 = Q17;
    }

    public String getQ18() {
        return Q18;
    }

    public void setQ18(String Q18) {
        this.Q18 = Q18;
    }

    public String getQ19() {
        return Q19;
    }

    public void setQ19(String Q19) {
        this.Q19 = Q19;
    }

    public String getQ2() {
        return Q2;
    }

    public void setQ2(String Q2) {
        this.Q2 = Q2;
    }

    public String getQ20() {
        return Q20;
    }

    public void setQ20(String Q20) {
        this.Q20 = Q20;
    }

    public String getQ21() {
        return Q21;
    }

    public void setQ21(String Q21) {
        this.Q21 = Q21;
    }

    public String getQ22() {
        return Q22;
    }

    public void setQ22(String Q22) {
        this.Q22 = Q22;
    }

    public String getQ23() {
        return Q23;
    }

    public void setQ23(String Q23) {
        this.Q23 = Q23;
    }

    public String getQ24() {
        return Q24;
    }

    public void setQ24(String Q24) {
        this.Q24 = Q24;
    }

    public String getQ25() {
        return Q25;
    }

    public void setQ25(String Q25) {
        this.Q25 = Q25;
    }

    public String getQ26() {
        return Q26;
    }

    public void setQ26(String Q26) {
        this.Q26 = Q26;
    }

    public String getQ27() {
        return Q27;
    }

    public void setQ27(String Q27) {
        this.Q27 = Q27;
    }

    public String getQ3() {
        return Q3;
    }

    public void setQ3(String Q3) {
        this.Q3 = Q3;
    }

    public String getQ4() {
        return Q4;
    }

    public void setQ4(String Q4) {
        this.Q4 = Q4;
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

    public String getQ6d() {
        return Q6d;
    }

    public void setQ6d(String Q6d) {
        this.Q6d = Q6d;
    }

    public String getQ6e() {
        return Q6e;
    }

    public void setQ6e(String Q6e) {
        this.Q6e = Q6e;
    }

    public String getQ6f() {
        return Q6f;
    }

    public void setQ6f(String Q6f) {
        this.Q6f = Q6f;
    }

    public String getQ6g() {
        return Q6g;
    }

    public void setQ6g(String Q6g) {
        this.Q6g = Q6g;
    }

    public String getQ7ConfeccaoPlanilhas() {
        return Q7ConfeccaoPlanilhas;
    }

    public void setQ7ConfeccaoPlanilhas(String Q7ConfeccaoPlanilhas) {
        this.Q7ConfeccaoPlanilhas = Q7ConfeccaoPlanilhas;
    }

    public String getQ7Internet() {
        return Q7Internet;
    }

    public void setQ7Internet(String Q7Internet) {
        this.Q7Internet = Q7Internet;
    }

    public String getQ7SoftwaresTexto() {
        return Q7SoftwaresTexto;
    }

    public void setQ7SoftwaresTexto(String Q7SoftwaresTexto) {
        this.Q7SoftwaresTexto = Q7SoftwaresTexto;
    }

    public String getQ8() {
        return Q8;
    }

    public void setQ8(String Q8) {
        this.Q8 = Q8;
    }

    public String getQ9() {
        return Q9;
    }

    public void setQ9(String Q9) {
        this.Q9 = Q9;
    }



    public String getComponenteCurricularCienciasHumanas() {
        return componenteCurricularCienciasHumanas;
    }

    public void setComponenteCurricularCienciasHumanas(String componenteCurricularCienciasHumanas) {
        this.componenteCurricularCienciasHumanas = componenteCurricularCienciasHumanas;
    }

    public String getComponenteCurricularCienciasNatureza() {
        return componenteCurricularCienciasNatureza;
    }

    public void setComponenteCurricularCienciasNatureza(String componenteCurricularCienciasNatureza) {
        this.componenteCurricularCienciasNatureza = componenteCurricularCienciasNatureza;
    }

    public String getComponenteCurricularLinguaEstrangeira() {
        return componenteCurricularLinguaEstrangeira;
    }

    public void setComponenteCurricularLinguaEstrangeira(String componenteCurricularLinguaEstrangeira) {
        this.componenteCurricularLinguaEstrangeira = componenteCurricularLinguaEstrangeira;
    }

    public String getComponenteCurricularLinguaPortuguesa() {
        return componenteCurricularLinguaPortuguesa;
    }

    public void setComponenteCurricularLinguaPortuguesa(String componenteCurricularLinguaPortuguesa) {
        this.componenteCurricularLinguaPortuguesa = componenteCurricularLinguaPortuguesa;
    }

    public String getComponenteCurricularMatematica() {
        return componenteCurricularMatematica;
    }

    public void setComponenteCurricularMatematica(String componenteCurricularMatematica) {
        this.componenteCurricularMatematica = componenteCurricularMatematica;
    }

    public String getComponenteCurricularParticipacaoCidada() {
        return componenteCurricularParticipacaoCidada;
    }

    public void setComponenteCurricularParticipacaoCidada(String componenteCurricularParticipacaoCidada) {
        this.componenteCurricularParticipacaoCidada = componenteCurricularParticipacaoCidada;
    }

    public String getComponenteCurricularQualificacaoProfissional() {
        return componenteCurricularQualificacaoProfissional;
    }

    public void setComponenteCurricularQualificacaoProfissional(String componenteCurricularQualificacaoProfissional) {
        this.componenteCurricularQualificacaoProfissional = componenteCurricularQualificacaoProfissional;
    }

    public String getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(String dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public String getExclusivoResponsavelAplicacaoQ1() {
        return exclusivoResponsavelAplicacaoQ1;
    }

    public void setExclusivoResponsavelAplicacaoQ1(String exclusivoResponsavelAplicacaoQ1) {
        this.exclusivoResponsavelAplicacaoQ1 = exclusivoResponsavelAplicacaoQ1;
    }

    public String getExclusivoResponsavelAplicacaoQ2() {
        return exclusivoResponsavelAplicacaoQ2;
    }

    public void setExclusivoResponsavelAplicacaoQ2(String exclusivoResponsavelAplicacaoQ2) {
        this.exclusivoResponsavelAplicacaoQ2 = exclusivoResponsavelAplicacaoQ2;
    }

    public String getExclusivoResponsavelAplicacaoQ3() {
        return exclusivoResponsavelAplicacaoQ3;
    }

    public void setExclusivoResponsavelAplicacaoQ3(String exclusivoResponsavelAplicacaoQ3) {
        this.exclusivoResponsavelAplicacaoQ3 = exclusivoResponsavelAplicacaoQ3;
    }

    public String getExclusivoResponsavelAplicacaoQ3Complemento() {
        return exclusivoResponsavelAplicacaoQ3Complemento;
    }

    public void setExclusivoResponsavelAplicacaoQ3Complemento(String exclusivoResponsavelAplicacaoQ3Complemento) {
        this.exclusivoResponsavelAplicacaoQ3Complemento = exclusivoResponsavelAplicacaoQ3Complemento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<String> getListComponenteCurricular() {
        return listComponenteCurricular;
    }

    public void setListComponenteCurricular(List<String> listComponenteCurricular) {
        this.listComponenteCurricular = listComponenteCurricular;
    }

    public List<String> getListQ6() {
        return listQ6;
    }

    public void setListQ6(List<String> listQ6) {
        this.listQ6 = listQ6;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getIdentificaEntradaCoordenacao() {
        return identificaEntradaCoordenacao;
    }

    public void setIdentificaEntradaCoordenacao(String identificaEntradaCoordenacao) {
        this.identificaEntradaCoordenacao = identificaEntradaCoordenacao;
    }

    public String getIdentificaEntradaEntrada() {
        return identificaEntradaEntrada;
    }

    public void setIdentificaEntradaEntrada(String identificaEntradaEntrada) {
        this.identificaEntradaEntrada = identificaEntradaEntrada;
    }

    public String getIdentificaEntradaMunicipio() {
        return identificaEntradaMunicipio;
    }

    public void setIdentificaEntradaMunicipio(String identificaEntradaMunicipio) {
        this.identificaEntradaMunicipio = identificaEntradaMunicipio;
    }

    public String getIdentificaEntradaUf() {
        return identificaEntradaUf;
    }

    public void setIdentificaEntradaUf(String identificaEntradaUf) {
        this.identificaEntradaUf = identificaEntradaUf;
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
     * @return the identificaEntradaObservacao
     */
    public String getIdentificaEntradaObservacao() {
        return identificaEntradaObservacao;
    }

    /**
     * @param identificaEntradaObservacao the identificaEntradaObservacao to set
     */
    public void setIdentificaEntradaObservacao(String identificaEntradaObservacao) {
        this.identificaEntradaObservacao = identificaEntradaObservacao;
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

    /**
     * @return the versaoFormulario
     */
    public Integer getVersaoFormulario() {
        return versaoFormulario;
    }

    /**
     * @param versaoFormulario the versaoFormulario to set
     */
    public void setVersaoFormulario(Integer versaoFormulario) {
        this.versaoFormulario = versaoFormulario;
    }

    

}
