/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.rotinas.CE.R002;

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
import projovem.nucleo.Nucleo;

/**
 *
 * @author admprojovem
 */
@Entity
@Table
public class CeRotina002 implements Serializable {

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

    @OneToOne
    private Nucleo nucleo;
    //Cabeçalho
    @OneToOne
    private Usuario usuario;
    @Column(nullable = true)
    private String dataAplicacao;
    @Column(nullable = true)
    private String nome;
    @Column(nullable = true)
    private String motivo;
    @Column(nullable = true)
    private String motivoComplemento;
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
    @Transient
    List<String> listQ5 = new ArrayList<String>();
    @Column(nullable = true, length = 250)
    private String Q5NuncaLecionei;
    @Column(nullable = true, length = 250)
    private String Q5EducacaoInfantil;
    @Column(nullable = true, length = 250)
    private String Q5EnsinoFundamental;
    @Column(nullable = true, length = 250)
    private String Q5EnsinoMedio;
    @Column(nullable = true, length = 250)
    private String Q5EducacaoJovensAdultos;
    @Column(nullable = true, length = 250)
    private String Q5EnsinoTecnicoProfissionalizante;
    @Column(nullable = true, length = 250)
    private String Q5EnsinoSuperior;
    @Column(nullable = true, length = 250)
    private String Q5Outros;
    @Column(nullable = true, length = 250)
    private String Q5OutrosComplemento;
    @Column(nullable = true, length = 250)
    private String Q6;
    @Transient
    List<String> listQ7 = new ArrayList<String>();
    @Column(nullable = true, length = 250)
    private String Q7Convite;
    @Column(nullable = true, length = 250)
    private String Q7AvaliacaoCurrículo;
    @Column(nullable = true, length = 250)
    private String Q7Entrevista;
    @Column(nullable = true, length = 250)
    private String Q7ProvaEscrita;
    @Column(nullable = true, length = 250)
    private String Q7Desempenho;
    @Transient
    List<String> listQ8 = new ArrayList<String>();
    @Column(nullable = true, length = 250)
    private String Q8a;
    @Column(nullable = true, length = 250)
    private String Q8b;
    @Column(nullable = true, length = 250)
    private String Q8c;
    @Column(nullable = true, length = 250)
    private String Q8d;
    @Column(nullable = true, length = 250)
    private String Q8e;
    @Column(nullable = true, length = 250)
    private String Q8f;
    @Column(nullable = true, length = 250)
    private String Q8g;
    @Column(nullable = true, length = 250)
    private String Q8h;
    @Column(nullable = true, length = 250)
    private String Q8i;
    @Column(nullable = true, length = 250)
    private String Q9SoftwaresTexto;
    @Column(nullable = true, length = 250)
    private String Q9ConfeccaoPlanilhas;
    @Column(nullable = true, length = 250)
    private String Q9Internet;
    @Column(nullable = true, length = 250)
    private String Q10;
    @Column(nullable = true, length = 250)
    private String Q11a;
    @Column(nullable = true, length = 250)
    private String Q11b;
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
    private String Q20Complemento;
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
    private String Q28;
    @Column(nullable = true, length = 250)
    private String Q29;
    @Column(nullable = true, length = 250)
    private String Q30;
    @Column(nullable = true, length = 250)
    private String Q31;
    @Column(nullable = true, length = 250)
    private String Q32;

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

    public String getQ5EducacaoInfantil() {
        return Q5EducacaoInfantil;
    }

    public void setQ5EducacaoInfantil(String Q5EducacaoInfantil) {
        this.Q5EducacaoInfantil = Q5EducacaoInfantil;
    }

    public String getQ5EducacaoJovensAdultos() {
        return Q5EducacaoJovensAdultos;
    }

    public void setQ5EducacaoJovensAdultos(String Q5EducacaoJovensAdultos) {
        this.Q5EducacaoJovensAdultos = Q5EducacaoJovensAdultos;
    }

    public String getQ5EnsinoFundamental() {
        return Q5EnsinoFundamental;
    }

    public void setQ5EnsinoFundamental(String Q5EnsinoFundamental) {
        this.Q5EnsinoFundamental = Q5EnsinoFundamental;
    }

    public String getQ5EnsinoMedio() {
        return Q5EnsinoMedio;
    }

    public void setQ5EnsinoMedio(String Q5EnsinoMedio) {
        this.Q5EnsinoMedio = Q5EnsinoMedio;
    }

    public String getQ5EnsinoSuperior() {
        return Q5EnsinoSuperior;
    }

    public void setQ5EnsinoSuperior(String Q5EnsinoSuperior) {
        this.Q5EnsinoSuperior = Q5EnsinoSuperior;
    }

    public String getQ5EnsinoTecnicoProfissionalizante() {
        return Q5EnsinoTecnicoProfissionalizante;
    }

    public void setQ5EnsinoTecnicoProfissionalizante(String Q5EnsinoTecnicoProfissionalizante) {
        this.Q5EnsinoTecnicoProfissionalizante = Q5EnsinoTecnicoProfissionalizante;
    }

    public String getQ5NuncaLecionei() {
        return Q5NuncaLecionei;
    }

    public void setQ5NuncaLecionei(String Q5NuncaLecionei) {
        this.Q5NuncaLecionei = Q5NuncaLecionei;
    }

    public String getQ5Outros() {
        return Q5Outros;
    }

    public void setQ5Outros(String Q5Outros) {
        this.Q5Outros = Q5Outros;
    }

    public String getQ5OutrosComplemento() {
        return Q5OutrosComplemento;
    }

    public void setQ5OutrosComplemento(String Q5OutrosComplemento) {
        this.Q5OutrosComplemento = Q5OutrosComplemento;
    }

    public String getQ6() {
        return Q6;
    }

    public void setQ6(String Q6) {
        this.Q6 = Q6;
    }

    public String getQ7AvaliacaoCurrículo() {
        return Q7AvaliacaoCurrículo;
    }

    public void setQ7AvaliacaoCurrículo(String Q7AvaliacaoCurrículo) {
        this.Q7AvaliacaoCurrículo = Q7AvaliacaoCurrículo;
    }

    public String getQ7Convite() {
        return Q7Convite;
    }

    public void setQ7Convite(String Q7Convite) {
        this.Q7Convite = Q7Convite;
    }

    public String getQ7Desempenho() {
        return Q7Desempenho;
    }

    public void setQ7Desempenho(String Q7Desempenho) {
        this.Q7Desempenho = Q7Desempenho;
    }

    public String getQ7Entrevista() {
        return Q7Entrevista;
    }

    public void setQ7Entrevista(String Q7Entrevista) {
        this.Q7Entrevista = Q7Entrevista;
    }

    public String getQ7ProvaEscrita() {
        return Q7ProvaEscrita;
    }

    public void setQ7ProvaEscrita(String Q7ProvaEscrita) {
        this.Q7ProvaEscrita = Q7ProvaEscrita;
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

    public String getQ8c() {
        return Q8c;
    }

    public void setQ8c(String Q8c) {
        this.Q8c = Q8c;
    }

    public String getQ8d() {
        return Q8d;
    }

    public void setQ8d(String Q8d) {
        this.Q8d = Q8d;
    }

    public String getQ8e() {
        return Q8e;
    }

    public void setQ8e(String Q8e) {
        this.Q8e = Q8e;
    }

    public String getQ8f() {
        return Q8f;
    }

    public void setQ8f(String Q8f) {
        this.Q8f = Q8f;
    }

    public String getQ8g() {
        return Q8g;
    }

    public void setQ8g(String Q8g) {
        this.Q8g = Q8g;
    }

    public String getQ8h() {
        return Q8h;
    }

    public void setQ8h(String Q8h) {
        this.Q8h = Q8h;
    }

    public String getQ8i() {
        return Q8i;
    }

    public void setQ8i(String Q8i) {
        this.Q8i = Q8i;
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

    public String getDataInsercao() {
        return dataInsercao;
    }

    public void setDataInsercao(String dataInsercao) {
        this.dataInsercao = dataInsercao;
    }

    public String getHoraInsercao() {
        return horaInsercao;
    }

    public void setHoraInsercao(String horaInsercao) {
        this.horaInsercao = horaInsercao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<String> getListComponenteCurricular() {
        return listComponenteCurricular;
    }

    public void setListComponenteCurricular(List<String> listComponenteCurricular) {
        this.listComponenteCurricular = listComponenteCurricular;
    }

    public List<String> getListQ5() {
        return listQ5;
    }

    public void setListQ5(List<String> listQ5) {
        this.listQ5 = listQ5;
    }

    public List<String> getListQ7() {
        return listQ7;
    }

    public void setListQ7(List<String> listQ7) {
        this.listQ7 = listQ7;
    }

    public List<String> getListQ8() {
        return listQ8;
    }

    public void setListQ8(List<String> listQ8) {
        this.listQ8 = listQ8;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
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

    public Nucleo getNucleo() {
        return nucleo;
    }

    public void setNucleo(Nucleo nucleo) {
        this.nucleo = nucleo;
    }

    public String getQ11a() {
        return Q11a;
    }

    public void setQ11a(String Q11a) {
        this.Q11a = Q11a;
    }

    public String getQ11b() {
        return Q11b;
    }

    public void setQ11b(String Q11b) {
        this.Q11b = Q11b;
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

    public String getQ31() {
        return Q31;
    }

    public void setQ31(String Q31) {
        this.Q31 = Q31;
    }

    public String getQ32() {
        return Q32;
    }

    public void setQ32(String Q32) {
        this.Q32 = Q32;
    }

    /**
     * @return the motivoComplemento
     */
    public String getMotivoComplemento() {
        return motivoComplemento;
    }

    /**
     * @param motivoComplemento the motivoComplemento to set
     */
    public void setMotivoComplemento(String motivoComplemento) {
        this.motivoComplemento = motivoComplemento;
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
     * @return the Q20Complemento
     */
    public String getQ20Complemento() {
        return Q20Complemento;
    }

    /**
     * @param Q20Complemento the Q20Complemento to set
     */
    public void setQ20Complemento(String Q20Complemento) {
        this.Q20Complemento = Q20Complemento;
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
