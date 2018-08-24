/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.rotinas.R005;

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
public class Rotina005 implements Serializable {

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
    private String Q3;
    @Column(nullable = true, length = 250)
    private String Q4a;
    @Column(nullable = true, length = 250)
    private String Q4b;
    @Column(nullable = true, length = 250)
    private String Q5;
    @Column(nullable = true, length = 250)
    private String Q6a;
    @Column(nullable = true, length = 250)
    private String Q6b;
    @Column(nullable = true, length = 250)
    private String Q6c;
    @Column(nullable = true, length = 250)
    private String Q6d;
    @Column(nullable = true, length = 250)
    private String Q6e;
    @Column(nullable = true, length = 250)
    private String Q6aI;
    @Column(nullable = true, length = 250)
    private String Q6bI;
    @Column(nullable = true, length = 250)
    private String Q6cI;
    @Column(nullable = true, length = 250)
    private String Q6dI;
    @Column(nullable = true, length = 250)
    private String Q6eI;
    @Column(nullable = true, length = 250)
    private String Q7;
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
    private String Q9;
    @Column(nullable = true, length = 250)
    private String Q10;
    @Column(nullable = true, length = 1000)
    private String Q10Complemento;

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

    public String getQ10Complemento() {
        return Q10Complemento;
    }

    public void setQ10Complemento(String Q10Complemento) {
        this.Q10Complemento = Q10Complemento;
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

    public String getQ4a() {
        return Q4a;
    }

    public void setQ4a(String Q4a) {
        this.Q4a = Q4a;
    }

    public String getQ4b() {
        return Q4b;
    }

    public void setQ4b(String Q4b) {
        this.Q4b = Q4b;
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

    public String getQ7() {
        return Q7;
    }

    public void setQ7(String Q7) {
        this.Q7 = Q7;
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

    public String getQ9() {
        return Q9;
    }

    public void setQ9(String Q9) {
        this.Q9 = Q9;
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

    public String getQ6aI() {
        return Q6aI;
    }

    public void setQ6aI(String Q6aI) {
        this.Q6aI = Q6aI;
    }

    public String getQ6bI() {
        return Q6bI;
    }

    public void setQ6bI(String Q6bI) {
        this.Q6bI = Q6bI;
    }

    public String getQ6cI() {
        return Q6cI;
    }

    public void setQ6cI(String Q6cI) {
        this.Q6cI = Q6cI;
    }

    public String getQ6dI() {
        return Q6dI;
    }

    public void setQ6dI(String Q6dI) {
        this.Q6dI = Q6dI;
    }

    /**
     * @return the Q6eI
     */
    public String getQ6eI() {
        return Q6eI;
    }

    /**
     * @param Q6eI the Q6eI to set
     */
    public void setQ6eI(String Q6eI) {
        this.Q6eI = Q6eI;
    }

}
