    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projovem.rotinas.R006;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Rotina006ArcosOcupacionais implements Serializable{
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

    @Column(nullable = true, length = 250)
    private String Q1Aarco;
    @Column(nullable = true, length = 250)
    private String Q1AdataObservacao;
    @Column(nullable = true, length = 250)
    private String Q1AhoraInicio;
    @Column(nullable = true, length = 250)
    private String Q1AhoraTermino;

    @Column(nullable = true, length = 250)
    private String Q1Barco;
    @Column(nullable = true, length = 250)
    private String Q1BdataObservacao;
    @Column(nullable = true, length = 250)
    private String Q1BhoraInicio;
    @Column(nullable = true, length = 250)
    private String Q1BhoraTermino;

    @Column(nullable = true, length = 250)
    private String Q1Carco;
    @Column(nullable = true, length = 250)
    private String Q1CdataObservacao;
    @Column(nullable = true, length = 250)
    private String Q1ChoraInicio;
    @Column(nullable = true, length = 250)
    private String Q1ChoraTermino;

    @Column(nullable = true, length = 250)
    private String Q1Darco;
    @Column(nullable = true, length = 250)
    private String Q1DdataObservacao;
    @Column(nullable = true, length = 250)
    private String Q1DhoraInicio;
    @Column(nullable = true, length = 250)
    private String Q1DhoraTermino;

    @Column(nullable = true, length = 250)
    private String Q1Earco;
    @Column(nullable = true, length = 250)
    private String Q1EdataObservacao;
    @Column(nullable = true, length = 250)
    private String Q1EhoraInicio;
    @Column(nullable = true, length = 250)
    private String Q1EhoraTermino;

    @Column(nullable = true, length = 250)
    private String Q2;

    @ManyToMany
    private List<Nucleo> Q3;

    @ManyToMany(fetch=FetchType.LAZY)
    private List<Nucleo> nucleoAtendido;

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

    @Column(nullable = true, length = 250)
    private String Q9InicioAtividades;
    @Column(nullable = true, length = 250)
    private String Q9FinalAtividades;
    @Column(nullable = true, length = 250)
    private String Q9Fechado;

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
    private String Q24Educadores;
    @Column(nullable = true, length = 250)
    private String Q24Alunos;
    @Column(nullable = true, length = 250)
    private String Q25Educadores;
    @Column(nullable = true, length = 250)
    private String Q25Alunos;
    @Column(nullable = true, length = 250)
    private String Q26Educadores;
    @Column(nullable = true, length = 250)
    private String Q26Alunos;
    @Column(nullable = true, length = 250)
    private String Q27Educadores;
    @Column(nullable = true, length = 250)
    private String Q27Alunos;
    @Column(nullable = true, length = 250)
    private String Q28Educadores;
    @Column(nullable = true, length = 250)
    private String Q28Alunos;

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
    private String Q54Complemento;

    @ManyToMany
    private List<Rotina006ArcosOcupacionaisMateriais> Q55;

    @Column(nullable = true, length = 250)
    private String Q56;

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

    public String getQ10Fechado() {
        return Q10Fechado;
    }

    public void setQ10Fechado(String Q10Fechado) {
        this.Q10Fechado = Q10Fechado;
    }

    public String getQ10FinalAtividades() {
        return Q10FinalAtividades;
    }

    public void setQ10FinalAtividades(String Q10FinalAtividades) {
        this.Q10FinalAtividades = Q10FinalAtividades;
    }

    public String getQ10InicioAtividades() {
        return Q10InicioAtividades;
    }

    public void setQ10InicioAtividades(String Q10InicioAtividades) {
        this.Q10InicioAtividades = Q10InicioAtividades;
    }

    public String getQ11Fechado() {
        return Q11Fechado;
    }

    public void setQ11Fechado(String Q11Fechado) {
        this.Q11Fechado = Q11Fechado;
    }

    public String getQ11FinalAtividades() {
        return Q11FinalAtividades;
    }

    public void setQ11FinalAtividades(String Q11FinalAtividades) {
        this.Q11FinalAtividades = Q11FinalAtividades;
    }

    public String getQ11InicioAtividades() {
        return Q11InicioAtividades;
    }

    public void setQ11InicioAtividades(String Q11InicioAtividades) {
        this.Q11InicioAtividades = Q11InicioAtividades;
    }

    public String getQ12Fechado() {
        return Q12Fechado;
    }

    public void setQ12Fechado(String Q12Fechado) {
        this.Q12Fechado = Q12Fechado;
    }

    public String getQ12FinalAtividades() {
        return Q12FinalAtividades;
    }

    public void setQ12FinalAtividades(String Q12FinalAtividades) {
        this.Q12FinalAtividades = Q12FinalAtividades;
    }

    public String getQ12InicioAtividades() {
        return Q12InicioAtividades;
    }

    public void setQ12InicioAtividades(String Q12InicioAtividades) {
        this.Q12InicioAtividades = Q12InicioAtividades;
    }

    public String getQ13Fechado() {
        return Q13Fechado;
    }

    public void setQ13Fechado(String Q13Fechado) {
        this.Q13Fechado = Q13Fechado;
    }

    public String getQ13FinalAtividades() {
        return Q13FinalAtividades;
    }

    public void setQ13FinalAtividades(String Q13FinalAtividades) {
        this.Q13FinalAtividades = Q13FinalAtividades;
    }

    public String getQ13InicioAtividades() {
        return Q13InicioAtividades;
    }

    public void setQ13InicioAtividades(String Q13InicioAtividades) {
        this.Q13InicioAtividades = Q13InicioAtividades;
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

    public String getQ1Aarco() {
        return Q1Aarco;
    }

    public void setQ1Aarco(String Q1Aarco) {
        this.Q1Aarco = Q1Aarco;
    }

    public String getQ1AdataObservacao() {
        return Q1AdataObservacao;
    }

    public void setQ1AdataObservacao(String Q1AdataObservacao) {
        this.Q1AdataObservacao = Q1AdataObservacao;
    }

    public String getQ1AhoraInicio() {
        return Q1AhoraInicio;
    }

    public void setQ1AhoraInicio(String Q1AhoraInicio) {
        this.Q1AhoraInicio = Q1AhoraInicio;
    }

    public String getQ1AhoraTermino() {
        return Q1AhoraTermino;
    }

    public void setQ1AhoraTermino(String Q1AhoraTermino) {
        this.Q1AhoraTermino = Q1AhoraTermino;
    }

    public String getQ1Barco() {
        return Q1Barco;
    }

    public void setQ1Barco(String Q1Barco) {
        this.Q1Barco = Q1Barco;
    }

    public String getQ1BdataObservacao() {
        return Q1BdataObservacao;
    }

    public void setQ1BdataObservacao(String Q1BdataObservacao) {
        this.Q1BdataObservacao = Q1BdataObservacao;
    }

    public String getQ1BhoraInicio() {
        return Q1BhoraInicio;
    }

    public void setQ1BhoraInicio(String Q1BhoraInicio) {
        this.Q1BhoraInicio = Q1BhoraInicio;
    }

    public String getQ1BhoraTermino() {
        return Q1BhoraTermino;
    }

    public void setQ1BhoraTermino(String Q1BhoraTermino) {
        this.Q1BhoraTermino = Q1BhoraTermino;
    }

    public String getQ1Carco() {
        return Q1Carco;
    }

    public void setQ1Carco(String Q1Carco) {
        this.Q1Carco = Q1Carco;
    }

    public String getQ1CdataObservacao() {
        return Q1CdataObservacao;
    }

    public void setQ1CdataObservacao(String Q1CdataObservacao) {
        this.Q1CdataObservacao = Q1CdataObservacao;
    }

    public String getQ1ChoraInicio() {
        return Q1ChoraInicio;
    }

    public void setQ1ChoraInicio(String Q1ChoraInicio) {
        this.Q1ChoraInicio = Q1ChoraInicio;
    }

    public String getQ1ChoraTermino() {
        return Q1ChoraTermino;
    }

    public void setQ1ChoraTermino(String Q1ChoraTermino) {
        this.Q1ChoraTermino = Q1ChoraTermino;
    }

    public String getQ1Darco() {
        return Q1Darco;
    }

    public void setQ1Darco(String Q1Darco) {
        this.Q1Darco = Q1Darco;
    }

    public String getQ1DdataObservacao() {
        return Q1DdataObservacao;
    }

    public void setQ1DdataObservacao(String Q1DdataObservacao) {
        this.Q1DdataObservacao = Q1DdataObservacao;
    }

    public String getQ1DhoraInicio() {
        return Q1DhoraInicio;
    }

    public void setQ1DhoraInicio(String Q1DhoraInicio) {
        this.Q1DhoraInicio = Q1DhoraInicio;
    }

    public String getQ1DhoraTermino() {
        return Q1DhoraTermino;
    }

    public void setQ1DhoraTermino(String Q1DhoraTermino) {
        this.Q1DhoraTermino = Q1DhoraTermino;
    }

    public String getQ1Earco() {
        return Q1Earco;
    }

    public void setQ1Earco(String Q1Earco) {
        this.Q1Earco = Q1Earco;
    }

    public String getQ1EdataObservacao() {
        return Q1EdataObservacao;
    }

    public void setQ1EdataObservacao(String Q1EdataObservacao) {
        this.Q1EdataObservacao = Q1EdataObservacao;
    }

    public String getQ1EhoraInicio() {
        return Q1EhoraInicio;
    }

    public void setQ1EhoraInicio(String Q1EhoraInicio) {
        this.Q1EhoraInicio = Q1EhoraInicio;
    }

    public String getQ1EhoraTermino() {
        return Q1EhoraTermino;
    }

    public void setQ1EhoraTermino(String Q1EhoraTermino) {
        this.Q1EhoraTermino = Q1EhoraTermino;
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

    public String getQ24Alunos() {
        return Q24Alunos;
    }

    public void setQ24Alunos(String Q24Alunos) {
        this.Q24Alunos = Q24Alunos;
    }

    public String getQ24Educadores() {
        return Q24Educadores;
    }

    public void setQ24Educadores(String Q24Educadores) {
        this.Q24Educadores = Q24Educadores;
    }

    public String getQ25Alunos() {
        return Q25Alunos;
    }

    public void setQ25Alunos(String Q25Alunos) {
        this.Q25Alunos = Q25Alunos;
    }

    public String getQ25Educadores() {
        return Q25Educadores;
    }

    public void setQ25Educadores(String Q25Educadores) {
        this.Q25Educadores = Q25Educadores;
    }

    public String getQ26Alunos() {
        return Q26Alunos;
    }

    public void setQ26Alunos(String Q26Alunos) {
        this.Q26Alunos = Q26Alunos;
    }

    public String getQ26Educadores() {
        return Q26Educadores;
    }

    public void setQ26Educadores(String Q26Educadores) {
        this.Q26Educadores = Q26Educadores;
    }

    public String getQ27Alunos() {
        return Q27Alunos;
    }

    public void setQ27Alunos(String Q27Alunos) {
        this.Q27Alunos = Q27Alunos;
    }

    public String getQ27Educadores() {
        return Q27Educadores;
    }

    public void setQ27Educadores(String Q27Educadores) {
        this.Q27Educadores = Q27Educadores;
    }

    public String getQ28Alunos() {
        return Q28Alunos;
    }

    public void setQ28Alunos(String Q28Alunos) {
        this.Q28Alunos = Q28Alunos;
    }

    public String getQ28Educadores() {
        return Q28Educadores;
    }

    public void setQ28Educadores(String Q28Educadores) {
        this.Q28Educadores = Q28Educadores;
    }

    public String getQ29() {
        return Q29;
    }

    public void setQ29(String Q29) {
        this.Q29 = Q29;
    }

    public List<Nucleo> getQ3() {
        return Q3;
    }

    public void setQ3(List<Nucleo> Q3) {
        this.Q3 = Q3;
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

    public String getQ4() {
        return Q4;
    }

    public void setQ4(String Q4) {
        this.Q4 = Q4;
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

    public String getQ54Complemento() {
        return Q54Complemento;
    }

    public void setQ54Complemento(String Q54Complemento) {
        this.Q54Complemento = Q54Complemento;
    }

    public List<Rotina006ArcosOcupacionaisMateriais> getQ55() {
        return Q55;
    }

    public void setQ55(List<Rotina006ArcosOcupacionaisMateriais> Q55) {
        this.Q55 = Q55;
    }

    public String getQ56() {
        return Q56;
    }

    public void setQ56(String Q56) {
        this.Q56 = Q56;
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

    public String getQ8() {
        return Q8;
    }

    public void setQ8(String Q8) {
        this.Q8 = Q8;
    }

    public String getQ9Fechado() {
        return Q9Fechado;
    }

    public void setQ9Fechado(String Q9Fechado) {
        this.Q9Fechado = Q9Fechado;
    }

    public String getQ9FinalAtividades() {
        return Q9FinalAtividades;
    }

    public void setQ9FinalAtividades(String Q9FinalAtividades) {
        this.Q9FinalAtividades = Q9FinalAtividades;
    }

    public String getQ9InicioAtividades() {
        return Q9InicioAtividades;
    }

    public void setQ9InicioAtividades(String Q9InicioAtividades) {
        this.Q9InicioAtividades = Q9InicioAtividades;
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

    public String getNomeAplicador() {
        return nomeAplicador;
    }

    public void setNomeAplicador(String nomeAplicador) {
        this.nomeAplicador = nomeAplicador;
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
     * @return the nucleoAtendido
     */
    public List<Nucleo> getNucleoAtendido() {
        return nucleoAtendido;
    }

    /**
     * @param nucleoAtendido the nucleoAtendido to set
     */
    public void setNucleoAtendido(List<Nucleo> nucleoAtendido) {
        this.nucleoAtendido = nucleoAtendido;
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
