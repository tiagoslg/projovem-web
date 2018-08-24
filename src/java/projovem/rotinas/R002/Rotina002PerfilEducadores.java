/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.rotinas.R002;

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
public class Rotina002PerfilEducadores implements Serializable {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;
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
    //Cabeçalho
    @OneToOne
    private Usuario usuario;
    @Column(nullable = true)
    private String dataAplicacao;
    @Column(nullable = true)
    private String nome;
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
    @Column(nullable = true, length = 250)
    private String Q6;
    @Column(nullable = true, length = 250)
    private String Q7;
    @Transient
    List<String> listQ8 = new ArrayList<String>();
    @Column(nullable = true, length = 250)
    private String Q8NuncaLecionei;
    @Column(nullable = true, length = 250)
    private String Q8EducacaoInfantil;
    @Column(nullable = true, length = 250)
    private String Q8EnsinoFundamental;
    @Column(nullable = true, length = 250)
    private String Q8EnsinoMedio;
    @Column(nullable = true, length = 250)
    private String Q8EducacaoJovensAdultos;
    @Column(nullable = true, length = 250)
    private String Q8EnsinoTecnicoProfissionalizante;
    @Column(nullable = true, length = 250)
    private String Q8EnsinoSuperior;
    @Column(nullable = true, length = 250)
    private String Q8Outros;
    @Column(nullable = true, length = 250)
    private String Q8OutrosComplemento;
    @Column(nullable = true, length = 250)
    private String Q9SoftwaresTexto;
    @Column(nullable = true, length = 250)
    private String Q9ConfeccaoPlanilhas;
    @Column(nullable = true, length = 250)
    private String Q9Internet;
    @Column(nullable = true, length = 250)
    private String Q10;
    @Transient
    List<String> listQ11 = new ArrayList<String>();
    @Column(nullable = true, length = 250)
    private String Q11Convite;
    @Column(nullable = true, length = 250)
    private String Q11AvaliacaoCurrículo;
    @Column(nullable = true, length = 250)
    private String Q11Entrevista;
    @Column(nullable = true, length = 250)
    private String Q11ProvaEscrita;
    @Column(nullable = true, length = 250)
    private String Q11Desempenho;
    @Column(nullable = true, length = 250)
    private String Q12;
    @Transient
    List<String> listQ13 = new ArrayList<String>();
    @Column(nullable = true, length = 250)
    private String Q13a;
    @Column(nullable = true, length = 250)
    private String Q13b;
    @Column(nullable = true, length = 250)
    private String Q13c;
    @Column(nullable = true, length = 250)
    private String Q13d;
    @Column(nullable = true, length = 250)
    private String Q13e;
    @Transient
    List<String> listQ14 = new ArrayList<String>();
    @Column(nullable = true, length = 250)
    private String Q14a;
    @Column(nullable = true, length = 250)
    private String Q14b;
    @Column(nullable = true, length = 250)
    private String Q14c;
    @Column(nullable = true, length = 250)
    private String Q14d;
    @Column(nullable = true, length = 250)
    private String Q14e;
    @Column(nullable = true, length = 250)
    private String Q14f;
    @Column(nullable = true, length = 250)
    private String Q14g;
    @Column(nullable = true, length = 250)
    private String Q14h;
    @Column(nullable = true, length = 250)
    private String Q14i;
    @Column(nullable = true, length = 250)
    private String Q15;

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

    public String getQ11AvaliacaoCurrículo() {
        return Q11AvaliacaoCurrículo;
    }

    public void setQ11AvaliacaoCurrículo(String Q11AvaliacaoCurrículo) {
        this.Q11AvaliacaoCurrículo = Q11AvaliacaoCurrículo;
    }

    public String getQ11Convite() {
        return Q11Convite;
    }

    public void setQ11Convite(String Q11Convite) {
        this.Q11Convite = Q11Convite;
    }

    public String getQ11Desempenho() {
        return Q11Desempenho;
    }

    public void setQ11Desempenho(String Q11Desempenho) {
        this.Q11Desempenho = Q11Desempenho;
    }

    public String getQ11Entrevista() {
        return Q11Entrevista;
    }

    public void setQ11Entrevista(String Q11Entrevista) {
        this.Q11Entrevista = Q11Entrevista;
    }

    public String getQ11ProvaEscrita() {
        return Q11ProvaEscrita;
    }

    public void setQ11ProvaEscrita(String Q11ProvaEscrita) {
        this.Q11ProvaEscrita = Q11ProvaEscrita;
    }

    public String getQ12() {
        return Q12;
    }

    public void setQ12(String Q12) {
        this.Q12 = Q12;
    }

    public String getQ13a() {
        return Q13a;
    }

    public void setQ13a(String Q13a) {
        this.Q13a = Q13a;
    }

    public String getQ13b() {
        return Q13b;
    }

    public void setQ13b(String Q13b) {
        this.Q13b = Q13b;
    }

    public String getQ13c() {
        return Q13c;
    }

    public void setQ13c(String Q13c) {
        this.Q13c = Q13c;
    }

    public String getQ13d() {
        return Q13d;
    }

    public void setQ13d(String Q13d) {
        this.Q13d = Q13d;
    }

    public String getQ13e() {
        return Q13e;
    }

    public void setQ13e(String Q13e) {
        this.Q13e = Q13e;
    }

    public String getQ14a() {
        return Q14a;
    }

    public void setQ14a(String Q14a) {
        this.Q14a = Q14a;
    }

    public String getQ14b() {
        return Q14b;
    }

    public void setQ14b(String Q14b) {
        this.Q14b = Q14b;
    }

    public String getQ14c() {
        return Q14c;
    }

    public void setQ14c(String Q14c) {
        this.Q14c = Q14c;
    }

    public String getQ14d() {
        return Q14d;
    }

    public void setQ14d(String Q14d) {
        this.Q14d = Q14d;
    }

    public String getQ14e() {
        return Q14e;
    }

    public void setQ14e(String Q14e) {
        this.Q14e = Q14e;
    }

    public String getQ14f() {
        return Q14f;
    }

    public void setQ14f(String Q14f) {
        this.Q14f = Q14f;
    }

    public String getQ14g() {
        return Q14g;
    }

    public void setQ14g(String Q14g) {
        this.Q14g = Q14g;
    }

    public String getQ14h() {
        return Q14h;
    }

    public void setQ14h(String Q14h) {
        this.Q14h = Q14h;
    }

    public String getQ14i() {
        return Q14i;
    }

    public void setQ14i(String Q14i) {
        this.Q14i = Q14i;
    }

    public String getQ15() {
        return Q15;
    }

    public void setQ15(String Q15) {
        this.Q15 = Q15;
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

    public String getQ6() {
        return Q6;
    }

    public void setQ6(String Q6) {
        this.Q6 = Q6;
    }

    public String getQ7() {
        return Q7;
    }

    public void setQ7(String Q7) {
        this.Q7 = Q7;
    }

    public String getQ8EducacaoInfantil() {
        return Q8EducacaoInfantil;
    }

    public void setQ8EducacaoInfantil(String Q8EducacaoInfantil) {
        this.Q8EducacaoInfantil = Q8EducacaoInfantil;
    }

    public String getQ8EducacaoJovensAdultos() {
        return Q8EducacaoJovensAdultos;
    }

    public void setQ8EducacaoJovensAdultos(String Q8EducacaoJovensAdultos) {
        this.Q8EducacaoJovensAdultos = Q8EducacaoJovensAdultos;
    }

    public String getQ8EnsinoFundamental() {
        return Q8EnsinoFundamental;
    }

    public void setQ8EnsinoFundamental(String Q8EnsinoFundamental) {
        this.Q8EnsinoFundamental = Q8EnsinoFundamental;
    }

    public String getQ8EnsinoMedio() {
        return Q8EnsinoMedio;
    }

    public void setQ8EnsinoMedio(String Q8EnsinoMedio) {
        this.Q8EnsinoMedio = Q8EnsinoMedio;
    }

    public String getQ8EnsinoSuperior() {
        return Q8EnsinoSuperior;
    }

    public void setQ8EnsinoSuperior(String Q8EnsinoSuperior) {
        this.Q8EnsinoSuperior = Q8EnsinoSuperior;
    }

    public String getQ8EnsinoTecnicoProfissionalizante() {
        return Q8EnsinoTecnicoProfissionalizante;
    }

    public void setQ8EnsinoTecnicoProfissionalizante(String Q8EnsinoTecnicoProfissionalizante) {
        this.Q8EnsinoTecnicoProfissionalizante = Q8EnsinoTecnicoProfissionalizante;
    }

    public String getQ8NuncaLecionei() {
        return Q8NuncaLecionei;
    }

    public void setQ8NuncaLecionei(String Q8NuncaLecionei) {
        this.Q8NuncaLecionei = Q8NuncaLecionei;
    }

    public String getQ8Outros() {
        return Q8Outros;
    }

    public void setQ8Outros(String Q8Outros) {
        this.Q8Outros = Q8Outros;
    }

    public String getQ8OutrosComplemento() {
        return Q8OutrosComplemento;
    }

    public void setQ8OutrosComplemento(String Q8OutrosComplemento) {
        this.Q8OutrosComplemento = Q8OutrosComplemento;
    }

    public String getQ9ConfeccaoPlanilhas() {
        return Q9ConfeccaoPlanilhas;
    }

    public void setQ9ConfeccaoPlanilhas(String Q9ConfeccaoPlanilhas) {
        this.Q9ConfeccaoPlanilhas = Q9ConfeccaoPlanilhas;
    }

    public String getQ9Internet() {
        return Q9Internet;
    }

    public void setQ9Internet(String Q9Internet) {
        this.Q9Internet = Q9Internet;
    }

    public String getQ9SoftwaresTexto() {
        return Q9SoftwaresTexto;
    }

    public void setQ9SoftwaresTexto(String Q9SoftwaresTexto) {
        this.Q9SoftwaresTexto = Q9SoftwaresTexto;
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

    public List<String> getListQ11() {
        return listQ11;
    }

    public void setListQ11(List<String> listQ11) {
        this.listQ11 = listQ11;
    }

    public List<String> getListQ13() {
        return listQ13;
    }

    public void setListQ13(List<String> listQ13) {
        this.listQ13 = listQ13;
    }

    public List<String> getListQ14() {
        return listQ14;
    }

    public void setListQ14(List<String> listQ14) {
        this.listQ14 = listQ14;
    }

    public List<String> getListQ8() {
        return listQ8;
    }

    public void setListQ8(List<String> listQ8) {
        this.listQ8 = listQ8;
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
