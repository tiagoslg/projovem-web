/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.rotinas.R006;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;import javax.persistence.OneToMany;
;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
public class Rotina006ArcosOcupacionaisV3 implements Serializable {

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
    @Column(nullable = true, length = 3)
    private String identificaEntradaObservacao;


    //Cabeçalho
    @OneToOne
    private Usuario usuario;
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
    @Column(nullable = true, length = 1000)
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
    private String nomeAplicador;

    @Column(nullable = true, length = 2)
    private String Q1;

    @Column(nullable = true, length = 2)
    private String Q2;

    @Column(nullable = true, length = 2)
    private String Q3;

    @Column(nullable = true, length = 250)
    private String Q4Aarco;
    @Column(nullable = true, length = 250)
    private String Q4AdataObservacao;
    @Column(nullable = true, length = 250)
    private String Q4AhoraInicio;
    @Column(nullable = true, length = 250)
    private String Q4AhoraTermino;

    @Column(nullable = true, length = 250)
    private String Q4Barco;
    @Column(nullable = true, length = 250)
    private String Q4BdataObservacao;
    @Column(nullable = true, length = 250)
    private String Q4BhoraInicio;
    @Column(nullable = true, length = 250)
    private String Q4BhoraTermino;

    @Column(nullable = true, length = 250)
    private String Q4Carco;
    @Column(nullable = true, length = 250)
    private String Q4CdataObservacao;
    @Column(nullable = true, length = 250)
    private String Q4ChoraInicio;
    @Column(nullable = true, length = 250)
    private String Q4ChoraTermino;

    @Column(nullable = true, length = 250)
    private String Q4Darco;
    @Column(nullable = true, length = 250)
    private String Q4DdataObservacao;
    @Column(nullable = true, length = 250)
    private String Q4DhoraInicio;
    @Column(nullable = true, length = 250)
    private String Q4DhoraTermino;

    @Column(nullable = true, length = 250)
    private String Q4Earco;
    @Column(nullable = true, length = 250)
    private String Q4EdataObservacao;
    @Column(nullable = true, length = 250)
    private String Q4EhoraInicio;
    @Column(nullable = true, length = 250)
    private String Q4EhoraTermino;

    //Os Alunos tem aulas / atividades referentes ao Arco Ocupacional
    @Column(nullable = true, length = 250)
    private String Q5;
    @Column(nullable = true, length = 250)
    private String Q6;
    @Column(nullable = true, length = 250)
    private String Q7;
    @Column(nullable = true, length = 250)
    private String Q8;
    @Column(nullable = true, length = 250)
    private String Q9;

    //Horário de Funcionamento das atividades por arco
    @Column(nullable = true, length = 250)
    private String Q10InicioAtividades;
    @Column(nullable = true, length = 250)
    private String Q10FinalAtividades;
    @Column(nullable = true, length = 250)
    private String Q10Fechado;

    @Column(nullable = true, length = 250)
    private String Q11InicioAtividades;
    @Column(nullable = true, length = 250)
    private String Q11FinalAtividades;
    @Column(nullable = true, length = 250)
    private String Q11Fechado;

    @Column(nullable = true, length = 250)
    private String Q12InicioAtividades;
    @Column(nullable = true, length = 250)
    private String Q12FinalAtividades;
    @Column(nullable = true, length = 250)
    private String Q12Fechado;

    @Column(nullable = true, length = 250)
    private String Q13InicioAtividades;
    @Column(nullable = true, length = 250)
    private String Q13FinalAtividades;
    @Column(nullable = true, length = 250)
    private String Q13Fechado;

    @Column(nullable = true, length = 250)
    private String Q14InicioAtividades;
    @Column(nullable = true, length = 250)
    private String Q14FinalAtividades;
    @Column(nullable = true, length = 250)
    private String Q14Fechado;

    //Horario em local Visivel
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

    //Horário estava sendo cumprido
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

    //Quanto Educadores e Alunos presentes
    @Column(nullable = true, length = 250)
    private String Q25Educadores;
    @Column(nullable = true, length = 250)
    private String Q25AlunosI;
    @Column(nullable = true, length = 250)
    private String Q25Alunos;
    @Column(nullable = true, length = 250)
    private String Q26Educadores;
    @Column(nullable = true, length = 250)
    private String Q26AlunosI;
    @Column(nullable = true, length = 250)
    private String Q26Alunos;
    @Column(nullable = true, length = 250)
    private String Q27Educadores;
    @Column(nullable = true, length = 250)
    private String Q27AlunosI;
    @Column(nullable = true, length = 250)
    private String Q27Alunos;
    @Column(nullable = true, length = 250)
    private String Q28Educadores;
    @Column(nullable = true, length = 250)
    private String Q28AlunosI;
    @Column(nullable = true, length = 250)
    private String Q28Alunos;
    @Column(nullable = true, length = 250)
    private String Q29Educadores;
    @Column(nullable = true, length = 250)
    private String Q29AlunosI;
    @Column(nullable = true, length = 250)
    private String Q29Alunos;

    //Tipo de Atividade
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

    //Há material de consumo
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

    //Há material permanente
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

    //Elogiaram a QP
    @Column(nullable = true, length = 250)
    private String Q45;
    @Column(nullable = true, columnDefinition = "TEXT")
    private String Q45Complemento;
    @Column(nullable = true, length = 250)
    private String Q46;
    @Column(nullable = true, columnDefinition = "TEXT")
    private String Q46Complemento;
    @Column(nullable = true, length = 250)
    private String Q47;
    @Column(nullable = true, columnDefinition = "TEXT")
    private String Q47Complemento;
    @Column(nullable = true, length = 250)
    private String Q48;
    @Column(nullable = true, columnDefinition = "TEXT")
    private String Q48Complemento;
    @Column(nullable = true, length = 250)
    private String Q49;
    @Column(nullable = true, columnDefinition = "TEXT")
    private String Q49Complemento;

    //Reclaramaram da QP
    @Column(nullable = true, length = 250)
    private String Q50;
    @Column(nullable = true, columnDefinition = "TEXT")
    private String Q50Complemento;
    @Column(nullable = true, length = 250)
    private String Q51;
    @Column(nullable = true, columnDefinition = "TEXT")
    private String Q51Complemento;
    @Column(nullable = true, length = 250)
    private String Q52;
    @Column(nullable = true, columnDefinition = "TEXT")
    private String Q52Complemento;
    @Column(nullable = true, length = 250)
    private String Q53;
    @Column(nullable = true, columnDefinition = "TEXT")
    private String Q53Complemento;
    @Column(nullable = true, length = 250)
    private String Q54;
    @Column(nullable = true, columnDefinition = "TEXT")
    private String Q54Complemento;

    //Registros Complementarem
    @Column(nullable = true, length = 250)
    private String Q55;
    @Column(nullable = true, columnDefinition = "TEXT")
    private String Q55Complemento;

    //Numero de visitas
    @Column(nullable = true, length = 250)
    private String Q56;

    //Variaveis Internas
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

    @OneToMany(fetch=FetchType.LAZY)
    private List<Rotina006ArcosQuest> questionarioEducador;

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
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
     * @return the horaInicioVisita
     */
    public String getHoraInicioVisita() {
        return horaInicioVisita;
    }

    /**
     * @param horaInicioVisita the horaInicioVisita to set
     */
    public void setHoraInicioVisita(String horaInicioVisita) {
        this.horaInicioVisita = horaInicioVisita;
    }

    /**
     * @return the horaTerminoVisita
     */
    public String getHoraTerminoVisita() {
        return horaTerminoVisita;
    }

    /**
     * @param horaTerminoVisita the horaTerminoVisita to set
     */
    public void setHoraTerminoVisita(String horaTerminoVisita) {
        this.horaTerminoVisita = horaTerminoVisita;
    }

    /**
     * @return the nomeLocal
     */
    public String getNomeLocal() {
        return nomeLocal;
    }

    /**
     * @param nomeLocal the nomeLocal to set
     */
    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    /**
     * @return the enderecoLocal
     */
    public String getEnderecoLocal() {
        return enderecoLocal;
    }

    /**
     * @param enderecoLocal the enderecoLocal to set
     */
    public void setEnderecoLocal(String enderecoLocal) {
        this.enderecoLocal = enderecoLocal;
    }

    /**
     * @return the bairroLocal
     */
    public String getBairroLocal() {
        return bairroLocal;
    }

    /**
     * @param bairroLocal the bairroLocal to set
     */
    public void setBairroLocal(String bairroLocal) {
        this.bairroLocal = bairroLocal;
    }

    /**
     * @return the numeroLocal
     */
    public String getNumeroLocal() {
        return numeroLocal;
    }

    /**
     * @param numeroLocal the numeroLocal to set
     */
    public void setNumeroLocal(String numeroLocal) {
        this.numeroLocal = numeroLocal;
    }

    /**
     * @return the complementoLocal
     */
    public String getComplementoLocal() {
        return complementoLocal;
    }

    /**
     * @param complementoLocal the complementoLocal to set
     */
    public void setComplementoLocal(String complementoLocal) {
        this.complementoLocal = complementoLocal;
    }

    /**
     * @return the cidadeLocal
     */
    public String getCidadeLocal() {
        return cidadeLocal;
    }

    /**
     * @param cidadeLocal the cidadeLocal to set
     */
    public void setCidadeLocal(String cidadeLocal) {
        this.cidadeLocal = cidadeLocal;
    }

    /**
     * @return the ufLocal
     */
    public String getUfLocal() {
        return ufLocal;
    }

    /**
     * @param ufLocal the ufLocal to set
     */
    public void setUfLocal(String ufLocal) {
        this.ufLocal = ufLocal;
    }

    /**
     * @return the cepLocal
     */
    public String getCepLocal() {
        return cepLocal;
    }

    /**
     * @param cepLocal the cepLocal to set
     */
    public void setCepLocal(String cepLocal) {
        this.cepLocal = cepLocal;
    }

    /**
     * @return the telefoneLocal
     */
    public String getTelefoneLocal() {
        return telefoneLocal;
    }

    /**
     * @param telefoneLocal the telefoneLocal to set
     */
    public void setTelefoneLocal(String telefoneLocal) {
        this.telefoneLocal = telefoneLocal;
    }

    /**
     * @return the nomeAplicador
     */
    public String getNomeAplicador() {
        return nomeAplicador;
    }

    /**
     * @param nomeAplicador the nomeAplicador to set
     */
    public void setNomeAplicador(String nomeAplicador) {
        this.nomeAplicador = nomeAplicador;
    }

    /**
     * @return the Q1
     */
    public String getQ1() {
        return Q1;
    }

    /**
     * @param Q1 the Q1 to set
     */
    public void setQ1(String Q1) {
        this.Q1 = Q1;
    }

    /**
     * @return the Q2
     */
    public String getQ2() {
        return Q2;
    }

    /**
     * @param Q2 the Q2 to set
     */
    public void setQ2(String Q2) {
        this.Q2 = Q2;
    }

    /**
     * @return the Q3
     */
    public String getQ3() {
        return Q3;
    }

    /**
     * @param Q3 the Q3 to set
     */
    public void setQ3(String Q3) {
        this.Q3 = Q3;
    }

    /**
     * @return the Q4Aarco
     */
    public String getQ4Aarco() {
        return Q4Aarco;
    }

    /**
     * @param Q4Aarco the Q4Aarco to set
     */
    public void setQ4Aarco(String Q4Aarco) {
        this.Q4Aarco = Q4Aarco;
    }

    /**
     * @return the Q4AdataObservacao
     */
    public String getQ4AdataObservacao() {
        return Q4AdataObservacao;
    }

    /**
     * @param Q4AdataObservacao the Q4AdataObservacao to set
     */
    public void setQ4AdataObservacao(String Q4AdataObservacao) {
        this.Q4AdataObservacao = Q4AdataObservacao;
    }

    /**
     * @return the Q4AhoraInicio
     */
    public String getQ4AhoraInicio() {
        return Q4AhoraInicio;
    }

    /**
     * @param Q4AhoraInicio the Q4AhoraInicio to set
     */
    public void setQ4AhoraInicio(String Q4AhoraInicio) {
        this.Q4AhoraInicio = Q4AhoraInicio;
    }

    /**
     * @return the Q4AhoraTermino
     */
    public String getQ4AhoraTermino() {
        return Q4AhoraTermino;
    }

    /**
     * @param Q4AhoraTermino the Q4AhoraTermino to set
     */
    public void setQ4AhoraTermino(String Q4AhoraTermino) {
        this.Q4AhoraTermino = Q4AhoraTermino;
    }

    /**
     * @return the Q4Barco
     */
    public String getQ4Barco() {
        return Q4Barco;
    }

    /**
     * @param Q4Barco the Q4Barco to set
     */
    public void setQ4Barco(String Q4Barco) {
        this.Q4Barco = Q4Barco;
    }

    /**
     * @return the Q4BdataObservacao
     */
    public String getQ4BdataObservacao() {
        return Q4BdataObservacao;
    }

    /**
     * @param Q4BdataObservacao the Q4BdataObservacao to set
     */
    public void setQ4BdataObservacao(String Q4BdataObservacao) {
        this.Q4BdataObservacao = Q4BdataObservacao;
    }

    /**
     * @return the Q4BhoraInicio
     */
    public String getQ4BhoraInicio() {
        return Q4BhoraInicio;
    }

    /**
     * @param Q4BhoraInicio the Q4BhoraInicio to set
     */
    public void setQ4BhoraInicio(String Q4BhoraInicio) {
        this.Q4BhoraInicio = Q4BhoraInicio;
    }

    /**
     * @return the Q4BhoraTermino
     */
    public String getQ4BhoraTermino() {
        return Q4BhoraTermino;
    }

    /**
     * @param Q4BhoraTermino the Q4BhoraTermino to set
     */
    public void setQ4BhoraTermino(String Q4BhoraTermino) {
        this.Q4BhoraTermino = Q4BhoraTermino;
    }

    /**
     * @return the Q4Carco
     */
    public String getQ4Carco() {
        return Q4Carco;
    }

    /**
     * @param Q4Carco the Q4Carco to set
     */
    public void setQ4Carco(String Q4Carco) {
        this.Q4Carco = Q4Carco;
    }

    /**
     * @return the Q4CdataObservacao
     */
    public String getQ4CdataObservacao() {
        return Q4CdataObservacao;
    }

    /**
     * @param Q4CdataObservacao the Q4CdataObservacao to set
     */
    public void setQ4CdataObservacao(String Q4CdataObservacao) {
        this.Q4CdataObservacao = Q4CdataObservacao;
    }

    /**
     * @return the Q4ChoraInicio
     */
    public String getQ4ChoraInicio() {
        return Q4ChoraInicio;
    }

    /**
     * @param Q4ChoraInicio the Q4ChoraInicio to set
     */
    public void setQ4ChoraInicio(String Q4ChoraInicio) {
        this.Q4ChoraInicio = Q4ChoraInicio;
    }

    /**
     * @return the Q4ChoraTermino
     */
    public String getQ4ChoraTermino() {
        return Q4ChoraTermino;
    }

    /**
     * @param Q4ChoraTermino the Q4ChoraTermino to set
     */
    public void setQ4ChoraTermino(String Q4ChoraTermino) {
        this.Q4ChoraTermino = Q4ChoraTermino;
    }

    /**
     * @return the Q4Darco
     */
    public String getQ4Darco() {
        return Q4Darco;
    }

    /**
     * @param Q4Darco the Q4Darco to set
     */
    public void setQ4Darco(String Q4Darco) {
        this.Q4Darco = Q4Darco;
    }

    /**
     * @return the Q4DdataObservacao
     */
    public String getQ4DdataObservacao() {
        return Q4DdataObservacao;
    }

    /**
     * @param Q4DdataObservacao the Q4DdataObservacao to set
     */
    public void setQ4DdataObservacao(String Q4DdataObservacao) {
        this.Q4DdataObservacao = Q4DdataObservacao;
    }

    /**
     * @return the Q4DhoraInicio
     */
    public String getQ4DhoraInicio() {
        return Q4DhoraInicio;
    }

    /**
     * @param Q4DhoraInicio the Q4DhoraInicio to set
     */
    public void setQ4DhoraInicio(String Q4DhoraInicio) {
        this.Q4DhoraInicio = Q4DhoraInicio;
    }

    /**
     * @return the Q4DhoraTermino
     */
    public String getQ4DhoraTermino() {
        return Q4DhoraTermino;
    }

    /**
     * @param Q4DhoraTermino the Q4DhoraTermino to set
     */
    public void setQ4DhoraTermino(String Q4DhoraTermino) {
        this.Q4DhoraTermino = Q4DhoraTermino;
    }

    /**
     * @return the Q4Earco
     */
    public String getQ4Earco() {
        return Q4Earco;
    }

    /**
     * @param Q4Earco the Q4Earco to set
     */
    public void setQ4Earco(String Q4Earco) {
        this.Q4Earco = Q4Earco;
    }

    /**
     * @return the Q4EdataObservacao
     */
    public String getQ4EdataObservacao() {
        return Q4EdataObservacao;
    }

    /**
     * @param Q4EdataObservacao the Q4EdataObservacao to set
     */
    public void setQ4EdataObservacao(String Q4EdataObservacao) {
        this.Q4EdataObservacao = Q4EdataObservacao;
    }

    /**
     * @return the Q4EhoraInicio
     */
    public String getQ4EhoraInicio() {
        return Q4EhoraInicio;
    }

    /**
     * @param Q4EhoraInicio the Q4EhoraInicio to set
     */
    public void setQ4EhoraInicio(String Q4EhoraInicio) {
        this.Q4EhoraInicio = Q4EhoraInicio;
    }

    /**
     * @return the Q4EhoraTermino
     */
    public String getQ4EhoraTermino() {
        return Q4EhoraTermino;
    }

    /**
     * @param Q4EhoraTermino the Q4EhoraTermino to set
     */
    public void setQ4EhoraTermino(String Q4EhoraTermino) {
        this.Q4EhoraTermino = Q4EhoraTermino;
    }

    /**
     * @return the Q5
     */
    public String getQ5() {
        return Q5;
    }

    /**
     * @param Q5 the Q5 to set
     */
    public void setQ5(String Q5) {
        this.Q5 = Q5;
    }

    /**
     * @return the Q6
     */
    public String getQ6() {
        return Q6;
    }

    /**
     * @param Q6 the Q6 to set
     */
    public void setQ6(String Q6) {
        this.Q6 = Q6;
    }

    /**
     * @return the Q7
     */
    public String getQ7() {
        return Q7;
    }

    /**
     * @param Q7 the Q7 to set
     */
    public void setQ7(String Q7) {
        this.Q7 = Q7;
    }

    /**
     * @return the Q8
     */
    public String getQ8() {
        return Q8;
    }

    /**
     * @param Q8 the Q8 to set
     */
    public void setQ8(String Q8) {
        this.Q8 = Q8;
    }

    /**
     * @return the Q9
     */
    public String getQ9() {
        return Q9;
    }

    /**
     * @param Q9 the Q9 to set
     */
    public void setQ9(String Q9) {
        this.Q9 = Q9;
    }

    /**
     * @return the Q10InicioAtividades
     */
    public String getQ10InicioAtividades() {
        return Q10InicioAtividades;
    }

    /**
     * @param Q10InicioAtividades the Q10InicioAtividades to set
     */
    public void setQ10InicioAtividades(String Q10InicioAtividades) {
        this.Q10InicioAtividades = Q10InicioAtividades;
    }

    /**
     * @return the Q10FinalAtividades
     */
    public String getQ10FinalAtividades() {
        return Q10FinalAtividades;
    }

    /**
     * @param Q10FinalAtividades the Q10FinalAtividades to set
     */
    public void setQ10FinalAtividades(String Q10FinalAtividades) {
        this.Q10FinalAtividades = Q10FinalAtividades;
    }

    /**
     * @return the Q10Fechado
     */
    public String getQ10Fechado() {
        return Q10Fechado;
    }

    /**
     * @param Q10Fechado the Q10Fechado to set
     */
    public void setQ10Fechado(String Q10Fechado) {
        this.Q10Fechado = Q10Fechado;
    }

    /**
     * @return the Q11InicioAtividades
     */
    public String getQ11InicioAtividades() {
        return Q11InicioAtividades;
    }

    /**
     * @param Q11InicioAtividades the Q11InicioAtividades to set
     */
    public void setQ11InicioAtividades(String Q11InicioAtividades) {
        this.Q11InicioAtividades = Q11InicioAtividades;
    }

    /**
     * @return the Q11FinalAtividades
     */
    public String getQ11FinalAtividades() {
        return Q11FinalAtividades;
    }

    /**
     * @param Q11FinalAtividades the Q11FinalAtividades to set
     */
    public void setQ11FinalAtividades(String Q11FinalAtividades) {
        this.Q11FinalAtividades = Q11FinalAtividades;
    }

    /**
     * @return the Q11Fechado
     */
    public String getQ11Fechado() {
        return Q11Fechado;
    }

    /**
     * @param Q11Fechado the Q11Fechado to set
     */
    public void setQ11Fechado(String Q11Fechado) {
        this.Q11Fechado = Q11Fechado;
    }

    /**
     * @return the Q12InicioAtividades
     */
    public String getQ12InicioAtividades() {
        return Q12InicioAtividades;
    }

    /**
     * @param Q12InicioAtividades the Q12InicioAtividades to set
     */
    public void setQ12InicioAtividades(String Q12InicioAtividades) {
        this.Q12InicioAtividades = Q12InicioAtividades;
    }

    /**
     * @return the Q12FinalAtividades
     */
    public String getQ12FinalAtividades() {
        return Q12FinalAtividades;
    }

    /**
     * @param Q12FinalAtividades the Q12FinalAtividades to set
     */
    public void setQ12FinalAtividades(String Q12FinalAtividades) {
        this.Q12FinalAtividades = Q12FinalAtividades;
    }

    /**
     * @return the Q12Fechado
     */
    public String getQ12Fechado() {
        return Q12Fechado;
    }

    /**
     * @param Q12Fechado the Q12Fechado to set
     */
    public void setQ12Fechado(String Q12Fechado) {
        this.Q12Fechado = Q12Fechado;
    }

    /**
     * @return the Q13InicioAtividades
     */
    public String getQ13InicioAtividades() {
        return Q13InicioAtividades;
    }

    /**
     * @param Q13InicioAtividades the Q13InicioAtividades to set
     */
    public void setQ13InicioAtividades(String Q13InicioAtividades) {
        this.Q13InicioAtividades = Q13InicioAtividades;
    }

    /**
     * @return the Q13FinalAtividades
     */
    public String getQ13FinalAtividades() {
        return Q13FinalAtividades;
    }

    /**
     * @param Q13FinalAtividades the Q13FinalAtividades to set
     */
    public void setQ13FinalAtividades(String Q13FinalAtividades) {
        this.Q13FinalAtividades = Q13FinalAtividades;
    }

    /**
     * @return the Q13Fechado
     */
    public String getQ13Fechado() {
        return Q13Fechado;
    }

    /**
     * @param Q13Fechado the Q13Fechado to set
     */
    public void setQ13Fechado(String Q13Fechado) {
        this.Q13Fechado = Q13Fechado;
    }

    /**
     * @return the Q14InicioAtividades
     */
    public String getQ14InicioAtividades() {
        return Q14InicioAtividades;
    }

    /**
     * @param Q14InicioAtividades the Q14InicioAtividades to set
     */
    public void setQ14InicioAtividades(String Q14InicioAtividades) {
        this.Q14InicioAtividades = Q14InicioAtividades;
    }

    /**
     * @return the Q14FinalAtividades
     */
    public String getQ14FinalAtividades() {
        return Q14FinalAtividades;
    }

    /**
     * @param Q14FinalAtividades the Q14FinalAtividades to set
     */
    public void setQ14FinalAtividades(String Q14FinalAtividades) {
        this.Q14FinalAtividades = Q14FinalAtividades;
    }

    /**
     * @return the Q14Fechado
     */
    public String getQ14Fechado() {
        return Q14Fechado;
    }

    /**
     * @param Q14Fechado the Q14Fechado to set
     */
    public void setQ14Fechado(String Q14Fechado) {
        this.Q14Fechado = Q14Fechado;
    }

    /**
     * @return the Q15
     */
    public String getQ15() {
        return Q15;
    }

    /**
     * @param Q15 the Q15 to set
     */
    public void setQ15(String Q15) {
        this.Q15 = Q15;
    }

    /**
     * @return the Q16
     */
    public String getQ16() {
        return Q16;
    }

    /**
     * @param Q16 the Q16 to set
     */
    public void setQ16(String Q16) {
        this.Q16 = Q16;
    }

    /**
     * @return the Q17
     */
    public String getQ17() {
        return Q17;
    }

    /**
     * @param Q17 the Q17 to set
     */
    public void setQ17(String Q17) {
        this.Q17 = Q17;
    }

    /**
     * @return the Q18
     */
    public String getQ18() {
        return Q18;
    }

    /**
     * @param Q18 the Q18 to set
     */
    public void setQ18(String Q18) {
        this.Q18 = Q18;
    }

    /**
     * @return the Q19
     */
    public String getQ19() {
        return Q19;
    }

    /**
     * @param Q19 the Q19 to set
     */
    public void setQ19(String Q19) {
        this.Q19 = Q19;
    }

    /**
     * @return the Q20
     */
    public String getQ20() {
        return Q20;
    }

    /**
     * @param Q20 the Q20 to set
     */
    public void setQ20(String Q20) {
        this.Q20 = Q20;
    }

    /**
     * @return the Q21
     */
    public String getQ21() {
        return Q21;
    }

    /**
     * @param Q21 the Q21 to set
     */
    public void setQ21(String Q21) {
        this.Q21 = Q21;
    }

    /**
     * @return the Q22
     */
    public String getQ22() {
        return Q22;
    }

    /**
     * @param Q22 the Q22 to set
     */
    public void setQ22(String Q22) {
        this.Q22 = Q22;
    }

    /**
     * @return the Q23
     */
    public String getQ23() {
        return Q23;
    }

    /**
     * @param Q23 the Q23 to set
     */
    public void setQ23(String Q23) {
        this.Q23 = Q23;
    }

    /**
     * @return the Q24
     */
    public String getQ24() {
        return Q24;
    }

    /**
     * @param Q24 the Q24 to set
     */
    public void setQ24(String Q24) {
        this.Q24 = Q24;
    }

    /**
     * @return the Q25Educadores
     */
    public String getQ25Educadores() {
        return Q25Educadores;
    }

    /**
     * @param Q25Educadores the Q25Educadores to set
     */
    public void setQ25Educadores(String Q25Educadores) {
        this.Q25Educadores = Q25Educadores;
    }

    /**
     * @return the Q25AlunosI
     */
    public String getQ25AlunosI() {
        return Q25AlunosI;
    }

    /**
     * @param Q25AlunosI the Q25AlunosI to set
     */
    public void setQ25AlunosI(String Q25AlunosI) {
        this.Q25AlunosI = Q25AlunosI;
    }

    /**
     * @return the Q25Alunos
     */
    public String getQ25Alunos() {
        return Q25Alunos;
    }

    /**
     * @param Q25Alunos the Q25Alunos to set
     */
    public void setQ25Alunos(String Q25Alunos) {
        this.Q25Alunos = Q25Alunos;
    }

    /**
     * @return the Q26Educadores
     */
    public String getQ26Educadores() {
        return Q26Educadores;
    }

    /**
     * @param Q26Educadores the Q26Educadores to set
     */
    public void setQ26Educadores(String Q26Educadores) {
        this.Q26Educadores = Q26Educadores;
    }

    /**
     * @return the Q26AlunosI
     */
    public String getQ26AlunosI() {
        return Q26AlunosI;
    }

    /**
     * @param Q26AlunosI the Q26AlunosI to set
     */
    public void setQ26AlunosI(String Q26AlunosI) {
        this.Q26AlunosI = Q26AlunosI;
    }

    /**
     * @return the Q26Alunos
     */
    public String getQ26Alunos() {
        return Q26Alunos;
    }

    /**
     * @param Q26Alunos the Q26Alunos to set
     */
    public void setQ26Alunos(String Q26Alunos) {
        this.Q26Alunos = Q26Alunos;
    }

    /**
     * @return the Q27Educadores
     */
    public String getQ27Educadores() {
        return Q27Educadores;
    }

    /**
     * @param Q27Educadores the Q27Educadores to set
     */
    public void setQ27Educadores(String Q27Educadores) {
        this.Q27Educadores = Q27Educadores;
    }

    /**
     * @return the Q27AlunosI
     */
    public String getQ27AlunosI() {
        return Q27AlunosI;
    }

    /**
     * @param Q27AlunosI the Q27AlunosI to set
     */
    public void setQ27AlunosI(String Q27AlunosI) {
        this.Q27AlunosI = Q27AlunosI;
    }

    /**
     * @return the Q27Alunos
     */
    public String getQ27Alunos() {
        return Q27Alunos;
    }

    /**
     * @param Q27Alunos the Q27Alunos to set
     */
    public void setQ27Alunos(String Q27Alunos) {
        this.Q27Alunos = Q27Alunos;
    }

    /**
     * @return the Q28Educadores
     */
    public String getQ28Educadores() {
        return Q28Educadores;
    }

    /**
     * @param Q28Educadores the Q28Educadores to set
     */
    public void setQ28Educadores(String Q28Educadores) {
        this.Q28Educadores = Q28Educadores;
    }

    /**
     * @return the Q28AlunosI
     */
    public String getQ28AlunosI() {
        return Q28AlunosI;
    }

    /**
     * @param Q28AlunosI the Q28AlunosI to set
     */
    public void setQ28AlunosI(String Q28AlunosI) {
        this.Q28AlunosI = Q28AlunosI;
    }

    /**
     * @return the Q28Alunos
     */
    public String getQ28Alunos() {
        return Q28Alunos;
    }

    /**
     * @param Q28Alunos the Q28Alunos to set
     */
    public void setQ28Alunos(String Q28Alunos) {
        this.Q28Alunos = Q28Alunos;
    }

    /**
     * @return the Q29Educadores
     */
    public String getQ29Educadores() {
        return Q29Educadores;
    }

    /**
     * @param Q29Educadores the Q29Educadores to set
     */
    public void setQ29Educadores(String Q29Educadores) {
        this.Q29Educadores = Q29Educadores;
    }

    /**
     * @return the Q29AlunosI
     */
    public String getQ29AlunosI() {
        return Q29AlunosI;
    }

    /**
     * @param Q29AlunosI the Q29AlunosI to set
     */
    public void setQ29AlunosI(String Q29AlunosI) {
        this.Q29AlunosI = Q29AlunosI;
    }

    /**
     * @return the Q29Alunos
     */
    public String getQ29Alunos() {
        return Q29Alunos;
    }

    /**
     * @param Q29Alunos the Q29Alunos to set
     */
    public void setQ29Alunos(String Q29Alunos) {
        this.Q29Alunos = Q29Alunos;
    }

    /**
     * @return the Q30
     */
    public String getQ30() {
        return Q30;
    }

    /**
     * @param Q30 the Q30 to set
     */
    public void setQ30(String Q30) {
        this.Q30 = Q30;
    }

    /**
     * @return the Q31
     */
    public String getQ31() {
        return Q31;
    }

    /**
     * @param Q31 the Q31 to set
     */
    public void setQ31(String Q31) {
        this.Q31 = Q31;
    }

    /**
     * @return the Q32
     */
    public String getQ32() {
        return Q32;
    }

    /**
     * @param Q32 the Q32 to set
     */
    public void setQ32(String Q32) {
        this.Q32 = Q32;
    }

    /**
     * @return the Q33
     */
    public String getQ33() {
        return Q33;
    }

    /**
     * @param Q33 the Q33 to set
     */
    public void setQ33(String Q33) {
        this.Q33 = Q33;
    }

    /**
     * @return the Q34
     */
    public String getQ34() {
        return Q34;
    }

    /**
     * @param Q34 the Q34 to set
     */
    public void setQ34(String Q34) {
        this.Q34 = Q34;
    }

    /**
     * @return the Q35
     */
    public String getQ35() {
        return Q35;
    }

    /**
     * @param Q35 the Q35 to set
     */
    public void setQ35(String Q35) {
        this.Q35 = Q35;
    }

    /**
     * @return the Q36
     */
    public String getQ36() {
        return Q36;
    }

    /**
     * @param Q36 the Q36 to set
     */
    public void setQ36(String Q36) {
        this.Q36 = Q36;
    }

    /**
     * @return the Q37
     */
    public String getQ37() {
        return Q37;
    }

    /**
     * @param Q37 the Q37 to set
     */
    public void setQ37(String Q37) {
        this.Q37 = Q37;
    }

    /**
     * @return the Q38
     */
    public String getQ38() {
        return Q38;
    }

    /**
     * @param Q38 the Q38 to set
     */
    public void setQ38(String Q38) {
        this.Q38 = Q38;
    }

    /**
     * @return the Q39
     */
    public String getQ39() {
        return Q39;
    }

    /**
     * @param Q39 the Q39 to set
     */
    public void setQ39(String Q39) {
        this.Q39 = Q39;
    }

    /**
     * @return the Q40
     */
    public String getQ40() {
        return Q40;
    }

    /**
     * @param Q40 the Q40 to set
     */
    public void setQ40(String Q40) {
        this.Q40 = Q40;
    }

    /**
     * @return the Q41
     */
    public String getQ41() {
        return Q41;
    }

    /**
     * @param Q41 the Q41 to set
     */
    public void setQ41(String Q41) {
        this.Q41 = Q41;
    }

    /**
     * @return the Q42
     */
    public String getQ42() {
        return Q42;
    }

    /**
     * @param Q42 the Q42 to set
     */
    public void setQ42(String Q42) {
        this.Q42 = Q42;
    }

    /**
     * @return the Q43
     */
    public String getQ43() {
        return Q43;
    }

    /**
     * @param Q43 the Q43 to set
     */
    public void setQ43(String Q43) {
        this.Q43 = Q43;
    }

    /**
     * @return the Q44
     */
    public String getQ44() {
        return Q44;
    }

    /**
     * @param Q44 the Q44 to set
     */
    public void setQ44(String Q44) {
        this.Q44 = Q44;
    }

    /**
     * @return the Q45
     */
    public String getQ45() {
        return Q45;
    }

    /**
     * @param Q45 the Q45 to set
     */
    public void setQ45(String Q45) {
        this.Q45 = Q45;
    }

    /**
     * @return the Q45Complemento
     */
    public String getQ45Complemento() {
        return Q45Complemento;
    }

    /**
     * @param Q45Complemento the Q45Complemento to set
     */
    public void setQ45Complemento(String Q45Complemento) {
        this.Q45Complemento = Q45Complemento;
    }

    /**
     * @return the Q46
     */
    public String getQ46() {
        return Q46;
    }

    /**
     * @param Q46 the Q46 to set
     */
    public void setQ46(String Q46) {
        this.Q46 = Q46;
    }

    /**
     * @return the Q46Complemento
     */
    public String getQ46Complemento() {
        return Q46Complemento;
    }

    /**
     * @param Q46Complemento the Q46Complemento to set
     */
    public void setQ46Complemento(String Q46Complemento) {
        this.Q46Complemento = Q46Complemento;
    }

    /**
     * @return the Q47
     */
    public String getQ47() {
        return Q47;
    }

    /**
     * @param Q47 the Q47 to set
     */
    public void setQ47(String Q47) {
        this.Q47 = Q47;
    }

    /**
     * @return the Q47Complemento
     */
    public String getQ47Complemento() {
        return Q47Complemento;
    }

    /**
     * @param Q47Complemento the Q47Complemento to set
     */
    public void setQ47Complemento(String Q47Complemento) {
        this.Q47Complemento = Q47Complemento;
    }

    /**
     * @return the Q48
     */
    public String getQ48() {
        return Q48;
    }

    /**
     * @param Q48 the Q48 to set
     */
    public void setQ48(String Q48) {
        this.Q48 = Q48;
    }

    /**
     * @return the Q48Complemento
     */
    public String getQ48Complemento() {
        return Q48Complemento;
    }

    /**
     * @param Q48Complemento the Q48Complemento to set
     */
    public void setQ48Complemento(String Q48Complemento) {
        this.Q48Complemento = Q48Complemento;
    }

    /**
     * @return the Q49
     */
    public String getQ49() {
        return Q49;
    }

    /**
     * @param Q49 the Q49 to set
     */
    public void setQ49(String Q49) {
        this.Q49 = Q49;
    }

    /**
     * @return the Q49Complemento
     */
    public String getQ49Complemento() {
        return Q49Complemento;
    }

    /**
     * @param Q49Complemento the Q49Complemento to set
     */
    public void setQ49Complemento(String Q49Complemento) {
        this.Q49Complemento = Q49Complemento;
    }

    /**
     * @return the Q50
     */
    public String getQ50() {
        return Q50;
    }

    /**
     * @param Q50 the Q50 to set
     */
    public void setQ50(String Q50) {
        this.Q50 = Q50;
    }

    /**
     * @return the Q50Complemento
     */
    public String getQ50Complemento() {
        return Q50Complemento;
    }

    /**
     * @param Q50Complemento the Q50Complemento to set
     */
    public void setQ50Complemento(String Q50Complemento) {
        this.Q50Complemento = Q50Complemento;
    }

    /**
     * @return the Q51
     */
    public String getQ51() {
        return Q51;
    }

    /**
     * @param Q51 the Q51 to set
     */
    public void setQ51(String Q51) {
        this.Q51 = Q51;
    }

    /**
     * @return the Q51Complemento
     */
    public String getQ51Complemento() {
        return Q51Complemento;
    }

    /**
     * @param Q51Complemento the Q51Complemento to set
     */
    public void setQ51Complemento(String Q51Complemento) {
        this.Q51Complemento = Q51Complemento;
    }

    /**
     * @return the Q52
     */
    public String getQ52() {
        return Q52;
    }

    /**
     * @param Q52 the Q52 to set
     */
    public void setQ52(String Q52) {
        this.Q52 = Q52;
    }

    /**
     * @return the Q52Complemento
     */
    public String getQ52Complemento() {
        return Q52Complemento;
    }

    /**
     * @param Q52Complemento the Q52Complemento to set
     */
    public void setQ52Complemento(String Q52Complemento) {
        this.Q52Complemento = Q52Complemento;
    }

    /**
     * @return the Q53
     */
    public String getQ53() {
        return Q53;
    }

    /**
     * @param Q53 the Q53 to set
     */
    public void setQ53(String Q53) {
        this.Q53 = Q53;
    }

    /**
     * @return the Q53Complemento
     */
    public String getQ53Complemento() {
        return Q53Complemento;
    }

    /**
     * @param Q53Complemento the Q53Complemento to set
     */
    public void setQ53Complemento(String Q53Complemento) {
        this.Q53Complemento = Q53Complemento;
    }

    /**
     * @return the Q54
     */
    public String getQ54() {
        return Q54;
    }

    /**
     * @param Q54 the Q54 to set
     */
    public void setQ54(String Q54) {
        this.Q54 = Q54;
    }

    /**
     * @return the Q54Complemento
     */
    public String getQ54Complemento() {
        return Q54Complemento;
    }

    /**
     * @param Q54Complemento the Q54Complemento to set
     */
    public void setQ54Complemento(String Q54Complemento) {
        this.Q54Complemento = Q54Complemento;
    }

    /**
     * @return the Q55
     */
    public String getQ55() {
        return Q55;
    }

    /**
     * @param Q55 the Q55 to set
     */
    public void setQ55(String Q55) {
        this.Q55 = Q55;
    }

    /**
     * @return the Q55Complemento
     */
    public String getQ55Complemento() {
        return Q55Complemento;
    }

    /**
     * @param Q55Complemento the Q55Complemento to set
     */
    public void setQ55Complemento(String Q55Complemento) {
        this.Q55Complemento = Q55Complemento;
    }

    /**
     * @return the Q56
     */
    public String getQ56() {
        return Q56;
    }

    /**
     * @param Q56 the Q56 to set
     */
    public void setQ56(String Q56) {
        this.Q56 = Q56;
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

    /**
     * @return the questionarioEducador
     */
    public List<Rotina006ArcosQuest> getQuestionarioEducador() {
        return questionarioEducador;
    }

    /**
     * @param questionarioEducador the questionarioEducador to set
     */
    public void setQuestionarioEducador(List<Rotina006ArcosQuest> questionarioEducador) {
        this.questionarioEducador = questionarioEducador;
    }

    
}
