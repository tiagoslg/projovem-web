


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.rotinas.CE.R001;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import projovem.entity.Usuario;
import projovem.nucleo.Nucleo;

/**
 *
 * @author admprojovem
 */
@Entity
@Table
public class CeRotina001 implements Serializable {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;
    //Cabeçalho
    @OneToOne
    private Usuario usuario;
    @OneToOne
    private Nucleo nucleo;

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
    @Column(nullable = true, length = 3)
    private String identificaEntradaObservacao;

    @Column(nullable = true)
    private String dataVisita;
    @Column(nullable = true, length = 250)
    private String horaInicioVisita;
    @Column(nullable = true, length = 250)
    private String horaTerminoVisita;
    @Column(nullable = true, length = 250)
    private String Q1;
    @Column(nullable = true, length = 250)
    private String Q2;

    @Column(nullable = true, length = 250)
    private String Q3a;
    @Column(nullable = true, length = 250)
    private String Q3b;
    @Column(nullable = true, length = 250)
    private String Q4;
    @Column(nullable = true, length = 250)
    private String Q5;
    @Column(nullable = true, length = 250)
    private String Q6;
    @Column(nullable = true, length = 250)
    private String Q7;
    @Column(nullable = true, length = 250)
    private String Q8;
    @Column(nullable = true, length = 1000)
    private String Q8Complemento;
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
    private String Q28;
    @Column(nullable = true, length = 250)
    private String Q29;
    @Column(nullable = true, length = 250)
    private String Q30;
    @Column(nullable = true, length = 250)
    private String Q31;
    @Column(nullable = true, length = 250)
    private String Q32;
    @Column(nullable = true, length = 250)
    private String Q33;
    @Column(nullable = true, length = 250)
    private String Q34;
    @Column(nullable = true, length = 250)
    private String Q35;
    @Column(nullable = true, length = 250)
    private String Q36;
    @Column(nullable = true, length = 250)
    private String Q37;
    @Column(nullable = true, length = 250)
    private String Q38;
    @Column(nullable = true, length = 250)
    private String Q39;
    @Column(nullable = true, length = 250)
    private String Q40;
    @Column(nullable = true, length = 250)
    private String Q41;
    @Column(nullable = true, length = 250)
    private String Q42;
    @Column(nullable = true, length = 250)
    private String Q43;
    @Column(nullable = true, length = 250)
    private String Q44;
    @Column(nullable = true, length = 250)
    private String Q45;
    @Column(nullable = true, length = 250)
    private String Q46;
    @Column(nullable = true, length = 250)
    private String Q47;
    @Column(nullable = true, length = 250)
    private String Q48;
    @Column(nullable = true, length = 250)
    private String Q49;
    @Column(nullable = true, length = 250)
    private String Q50;
    @Column(nullable = true, length = 250)
    private String Q51;
    @Column(nullable = true, length = 250)
    private String Q52;
    @Column(nullable = true, length = 250)
    private String Q53;
    @Column(nullable = true, length = 250)
    private String Q54;
    @Column(nullable = true, length = 250)
    private String Q55;
    @Column(nullable = true, length = 250)
    private String Q56;
    @Column(nullable = true, length = 250)
    private String Q57;
    @Column(nullable = true, length = 250)
    private String Q58;
    @Column(nullable = true, length = 250)
    private String Q59;
    @Column(nullable = true, length = 250)
    private String Q60;
    @Column(nullable = true, length = 250)
    private String Q61;
    @Column(nullable = true, length = 250)
    private String Q62;
    @Column(nullable = true, length = 250)
    private String Q63;
    @Column(nullable = true, length = 250)
    private String Q64;
    @Column(nullable = true, length = 250)
    private String Q65;
    @Column(nullable = true, length = 250)
    private String Q66;
    @Column(nullable = true, length = 250)
    private String Q67;
    @Column(nullable = true, length = 1000)
    private String Q67Complemento;
    @Column(nullable = true, length = 250)
    private String Q68;
    @Column(nullable = true, length = 1000)
    private String Q68Complemento;
    @Column(nullable = true, length = 250)
    private String Q69;
    @Column(nullable = true, length = 1000)
    private String Q69Complemento;
    @Column(nullable = true, length = 250)
    private String Q70;
    @Column(nullable = true, length = 1000)
    private String Q70Complemento;
    @Column(nullable = true, length = 250)
    private String Q71;
    @Column(nullable = true, length = 1000)
    private String Q71Complemento;
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

    public String getQ33() {
        return Q33;
    }

    public void setQ33(String Q33) {
        this.Q33 = Q33;
    }

    public String getQ34() {
        return Q34;
    }

    public void setQ34(String Q34) {
        this.Q34 = Q34;
    }

    public String getQ35() {
        return Q35;
    }

    public void setQ35(String Q35) {
        this.Q35 = Q35;
    }

    public String getQ36() {
        return Q36;
    }

    public void setQ36(String Q36) {
        this.Q36 = Q36;
    }

    public String getQ37() {
        return Q37;
    }

    public void setQ37(String Q37) {
        this.Q37 = Q37;
    }

    public String getQ38() {
        return Q38;
    }

    public void setQ38(String Q38) {
        this.Q38 = Q38;
    }

    public String getQ39() {
        return Q39;
    }

    public void setQ39(String Q39) {
        this.Q39 = Q39;
    }

    public String getQ3a() {
        return Q3a;
    }

    public void setQ3a(String Q3a) {
        this.Q3a = Q3a;
    }

    public String getQ3b() {
        return Q3b;
    }

    public void setQ3b(String Q3b) {
        this.Q3b = Q3b;
    }

    public String getQ40() {
        return Q40;
    }

    public void setQ40(String Q40) {
        this.Q40 = Q40;
    }

    public String getQ41() {
        return Q41;
    }

    public void setQ41(String Q41) {
        this.Q41 = Q41;
    }

    public String getQ42() {
        return Q42;
    }

    public void setQ42(String Q42) {
        this.Q42 = Q42;
    }

    public String getQ43() {
        return Q43;
    }

    public void setQ43(String Q43) {
        this.Q43 = Q43;
    }

    public String getQ44() {
        return Q44;
    }

    public void setQ44(String Q44) {
        this.Q44 = Q44;
    }

    public String getQ45() {
        return Q45;
    }

    public void setQ45(String Q45) {
        this.Q45 = Q45;
    }

    public String getQ46() {
        return Q46;
    }

    public void setQ46(String Q46) {
        this.Q46 = Q46;
    }

    public String getQ47() {
        return Q47;
    }

    public void setQ47(String Q47) {
        this.Q47 = Q47;
    }

    public String getQ48() {
        return Q48;
    }

    public void setQ48(String Q48) {
        this.Q48 = Q48;
    }

    public String getQ49() {
        return Q49;
    }

    public void setQ49(String Q49) {
        this.Q49 = Q49;
    }

    public String getQ5() {
        return Q5;
    }

    public void setQ5(String Q5) {
        this.Q5 = Q5;
    }

    public String getQ50() {
        return Q50;
    }

    public void setQ50(String Q50) {
        this.Q50 = Q50;
    }

    public String getQ51() {
        return Q51;
    }

    public void setQ51(String Q51) {
        this.Q51 = Q51;
    }

    public String getQ52() {
        return Q52;
    }

    public void setQ52(String Q52) {
        this.Q52 = Q52;
    }

    public String getQ53() {
        return Q53;
    }

    public void setQ53(String Q53) {
        this.Q53 = Q53;
    }

    public String getQ54() {
        return Q54;
    }

    public void setQ54(String Q54) {
        this.Q54 = Q54;
    }

    public String getQ55() {
        return Q55;
    }

    public void setQ55(String Q55) {
        this.Q55 = Q55;
    }

    public String getQ56() {
        return Q56;
    }

    public void setQ56(String Q56) {
        this.Q56 = Q56;
    }

    public String getQ57() {
        return Q57;
    }

    public void setQ57(String Q57) {
        this.Q57 = Q57;
    }

    public String getQ58() {
        return Q58;
    }

    public void setQ58(String Q58) {
        this.Q58 = Q58;
    }

    public String getQ59() {
        return Q59;
    }

    public void setQ59(String Q59) {
        this.Q59 = Q59;
    }

    public String getQ6() {
        return Q6;
    }

    public void setQ6(String Q6) {
        this.Q6 = Q6;
    }

    public String getQ60() {
        return Q60;
    }

    public void setQ60(String Q60) {
        this.Q60 = Q60;
    }

    public String getQ61() {
        return Q61;
    }

    public void setQ61(String Q61) {
        this.Q61 = Q61;
    }

    public String getQ62() {
        return Q62;
    }

    public void setQ62(String Q62) {
        this.Q62 = Q62;
    }

    public String getQ63() {
        return Q63;
    }

    public void setQ63(String Q63) {
        this.Q63 = Q63;
    }

    public String getQ64() {
        return Q64;
    }

    public void setQ64(String Q64) {
        this.Q64 = Q64;
    }

    public String getQ65() {
        return Q65;
    }

    public void setQ65(String Q65) {
        this.Q65 = Q65;
    }

    public String getQ66() {
        return Q66;
    }

    public void setQ66(String Q66) {
        this.Q66 = Q66;
    }

    public String getQ67() {
        return Q67;
    }

    public void setQ67(String Q67) {
        this.Q67 = Q67;
    }

    public String getQ67Complemento() {
        return Q67Complemento;
    }

    public void setQ67Complemento(String Q67Complemento) {
        this.Q67Complemento = Q67Complemento;
    }

    public String getQ68() {
        return Q68;
    }

    public void setQ68(String Q68) {
        this.Q68 = Q68;
    }

    public String getQ68Complemento() {
        return Q68Complemento;
    }

    public void setQ68Complemento(String Q68Complemento) {
        this.Q68Complemento = Q68Complemento;
    }

    public String getQ69() {
        return Q69;
    }

    public void setQ69(String Q69) {
        this.Q69 = Q69;
    }

    public String getQ69Complemento() {
        return Q69Complemento;
    }

    public void setQ69Complemento(String Q69Complemento) {
        this.Q69Complemento = Q69Complemento;
    }

    public String getQ7() {
        return Q7;
    }

    public void setQ7(String Q7) {
        this.Q7 = Q7;
    }

    public String getQ70() {
        return Q70;
    }

    public void setQ70(String Q70) {
        this.Q70 = Q70;
    }

    public String getQ70Complemento() {
        return Q70Complemento;
    }

    public void setQ70Complemento(String Q70Complemento) {
        this.Q70Complemento = Q70Complemento;
    }

    public String getQ71() {
        return Q71;
    }

    public void setQ71(String Q71) {
        this.Q71 = Q71;
    }

    public String getQ71Complemento() {
        return Q71Complemento;
    }

    public void setQ71Complemento(String Q71Complemento) {
        this.Q71Complemento = Q71Complemento;
    }

    public String getQ8() {
        return Q8;
    }

    public void setQ8(String Q8) {
        this.Q8 = Q8;
    }

    public String getQ8Complemento() {
        return Q8Complemento;
    }

    public void setQ8Complemento(String Q8Complemento) {
        this.Q8Complemento = Q8Complemento;
    }

    public String getQ9() {
        return Q9;
    }

    public void setQ9(String Q9) {
        this.Q9 = Q9;
    }

    public String getDataInsercao() {
        return dataInsercao;
    }

    public void setDataInsercao(String dataInsercao) {
        this.dataInsercao = dataInsercao;
    }

    public String getDataVisita() {
        return dataVisita;
    }

    public void setDataVisita(String dataVisita) {
        this.dataVisita = dataVisita;
    }

    public String getHoraInicioVisita() {
        return horaInicioVisita;
    }

    public void setHoraInicioVisita(String horaInicioVisita) {
        this.horaInicioVisita = horaInicioVisita;
    }

    public String getHoraInsercao() {
        return horaInsercao;
    }

    public void setHoraInsercao(String horaInsercao) {
        this.horaInsercao = horaInsercao;
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

    public Nucleo getNucleo() {
        return nucleo;
    }

    public void setNucleo(Nucleo nucleo) {
        this.nucleo = nucleo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the Q4
     */
    public String getQ4() {
        return Q4;
    }

    /**
     * @param Q4 the Q4 to set
     */
    public void setQ4(String Q4) {
        this.Q4 = Q4;
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
}
