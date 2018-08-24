/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.rotinas.R006;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author admprojovem
 */
@Entity
@Table
public class Rotina006CoordenacaoLocalLocais implements Serializable {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;
    @Column(nullable = true, length = 250)
    private String enderecoLocal;
    @Column(nullable = true, length = 250)
    private String numeroLocal;
    @Column(nullable = true, length = 250)
    private String complementoLocal;

    public String getComplementoLocal() {
        return complementoLocal;
    }

    public void setComplementoLocal(String complementoLocal) {
        this.complementoLocal = complementoLocal;
    }

    public String getNumeroLocal() {
        return numeroLocal;
    }

    public void setNumeroLocal(String numeroLocal) {
        this.numeroLocal = numeroLocal;
    }
    @Column(nullable = true, length = 250)
    private String telefoneLocal;
    @Column(nullable = true, length = 250)
    private String tipoLocal;
    @Column(nullable = true, length = 250)
    private String tipoLocalComplemento;

    public String getTipoLocalComplemento() {
        return tipoLocalComplemento;
    }

    public void setTipoLocalComplemento(String tipoLocalComplemento) {
        this.tipoLocalComplemento = tipoLocalComplemento;
    }

    @Column(nullable = true, length = 250)
    private String nucleosAtendido1;
    @Column(nullable = true, length = 250)
    private String nucleosAtendido2;
    @Column(nullable = true, length = 250)
    private String nucleosAtendido3;
    @Column(nullable = true, length = 250)
    private String nucleosAtendido4;
    @Column(nullable = true, length = 250)
    private String nucleosAtendido5;
    @Column(nullable = true, length = 250)
    private String nucleosAtendido6;
    @Column(nullable = true, length = 250)
    private String nucleosAtendido7;
    @Column(nullable = true, length = 250)
    private String nucleosAtendido8;
    @Column(nullable = true, length = 250)
    private String nucleosAtendido9;

    public String getNucleosAtendido1() {
        return nucleosAtendido1;
    }

    public void setNucleosAtendido1(String nucleosAtendido1) {
        this.nucleosAtendido1 = nucleosAtendido1;
    }

    public String getNucleosAtendido2() {
        return nucleosAtendido2;
    }

    public void setNucleosAtendido2(String nucleosAtendido2) {
        this.nucleosAtendido2 = nucleosAtendido2;
    }

    public String getNucleosAtendido3() {
        return nucleosAtendido3;
    }

    public void setNucleosAtendido3(String nucleosAtendido3) {
        this.nucleosAtendido3 = nucleosAtendido3;
    }

    public String getNucleosAtendido4() {
        return nucleosAtendido4;
    }

    public void setNucleosAtendido4(String nucleosAtendido4) {
        this.nucleosAtendido4 = nucleosAtendido4;
    }

    public String getNucleosAtendido5() {
        return nucleosAtendido5;
    }

    public void setNucleosAtendido5(String nucleosAtendido5) {
        this.nucleosAtendido5 = nucleosAtendido5;
    }

    public String getNucleosAtendido6() {
        return nucleosAtendido6;
    }

    public void setNucleosAtendido6(String nucleosAtendido6) {
        this.nucleosAtendido6 = nucleosAtendido6;
    }

    public String getNucleosAtendido7() {
        return nucleosAtendido7;
    }

    public void setNucleosAtendido7(String nucleosAtendido7) {
        this.nucleosAtendido7 = nucleosAtendido7;
    }

    public String getNucleosAtendido8() {
        return nucleosAtendido8;
    }

    public void setNucleosAtendido8(String nucleosAtendido8) {
        this.nucleosAtendido8 = nucleosAtendido8;
    }

    public String getNucleosAtendido9() {
        return nucleosAtendido9;
    }

    public void setNucleosAtendido9(String nucleosAtendido9) {
        this.nucleosAtendido9 = nucleosAtendido9;
    }


    @Column(nullable = true, length = 250)
    private String arcosAOferecido;
    @Transient
    List<String> isArcosAOferecido = new ArrayList<String>();
    @Column(nullable = true, length = 250)
    private String arcosBOferecido;
    @Transient
    List<String> isArcosBOferecido = new ArrayList<String>();
    @Column(nullable = true, length = 250)
    private String arcosCOferecido;
    @Transient
    List<String> isArcosCOferecido = new ArrayList<String>();
    @Column(nullable = true, length = 250)
    private String arcosDOferecido;
    @Transient
    List<String> isArcosDOferecido = new ArrayList<String>();
    @Column(nullable = true, length = 250)
    private String arcosEOferecido;
    @Transient
    List<String> isArcosEOferecido = new ArrayList<String>();
    @Column(nullable = true)
    private String diaFuncionamentoArcoADomingo;
    @Transient
    List<String> isFuncionamentoArcoADomingo = new ArrayList<String>();
    @Column(nullable = true)
    private String diaFuncionamentoArcoASegunda;
    @Transient
    List<String> isFuncionamentoArcoASegunda = new ArrayList<String>();
    @Column(nullable = true)
    private String diaFuncionamentoArcoATerca;
    @Transient
    List<String> isFuncionamentoArcoATerca = new ArrayList<String>();
    @Column(nullable = true)
    private String diaFuncionamentoArcoAQuarta;
    @Transient
    List<String> isFuncionamentoArcoAQuarta = new ArrayList<String>();
    @Column(nullable = true)
    private String diaFuncionamentoArcoAQuinta;
    @Transient
    List<String> isFuncionamentoArcoAQuinta = new ArrayList<String>();
    @Column(nullable = true)
    private String diaFuncionamentoArcoASexta;
    @Transient
    List<String> isFuncionamentoArcoASexta = new ArrayList<String>();
    @Column(nullable = true)
    private String diaFuncionamentoArcoASabado;
    @Transient
    List<String> isFuncionamentoArcoASabado = new ArrayList<String>();
    @Column(nullable = true)
    private String diaFuncionamentoArcoBDomingo;
    @Transient
    List<String> isFuncionamentoArcoBDomingo = new ArrayList<String>();
    @Column(nullable = true)
    private String diaFuncionamentoArcoBSegunda;
    @Transient
    List<String> isFuncionamentoArcoBSegunda = new ArrayList<String>();
    @Column(nullable = true)
    private String diaFuncionamentoArcoBTerca;
    @Transient
    List<String> isFuncionamentoArcoBTerca = new ArrayList<String>();
    @Column(nullable = true)
    private String diaFuncionamentoArcoBQuarta;
    @Transient
    List<String> isFuncionamentoArcoBQuarta = new ArrayList<String>();
    @Column(nullable = true)
    private String diaFuncionamentoArcoBQuinta;
    @Transient
    List<String> isFuncionamentoArcoBQuinta = new ArrayList<String>();
    @Column(nullable = true)
    private String diaFuncionamentoArcoBSexta;
    @Transient
    List<String> isFuncionamentoArcoBSexta = new ArrayList<String>();
    @Column(nullable = true)
    private String diaFuncionamentoArcoBSabado;
    @Transient
    List<String> isFuncionamentoArcoBSabado = new ArrayList<String>();
    @Column(nullable = true)
    private String diaFuncionamentoArcoCDomingo;
    @Transient
    List<String> isFuncionamentoArcoCDomingo = new ArrayList<String>();
    @Column(nullable = true)
    private String diaFuncionamentoArcoCSegunda;
    @Transient
    List<String> isFuncionamentoArcoCSegunda = new ArrayList<String>();
    @Column(nullable = true)
    private String diaFuncionamentoArcoCTerca;
    @Transient
    List<String> isFuncionamentoArcoCTerca = new ArrayList<String>();
    @Column(nullable = true)
    private String diaFuncionamentoArcoCQuarta;
    @Transient
    List<String> isFuncionamentoArcoCQuarta = new ArrayList<String>();
    @Column(nullable = true)
    private String diaFuncionamentoArcoCQuinta;
    @Transient
    List<String> isFuncionamentoArcoCQuinta = new ArrayList<String>();
    @Column(nullable = true)
    private String diaFuncionamentoArcoCSexta;
    @Transient
    List<String> isFuncionamentoArcoCSexta = new ArrayList<String>();
    @Column(nullable = true)
    private String diaFuncionamentoArcoCSabado;
    @Transient
    List<String> isFuncionamentoArcoCSabado = new ArrayList<String>();
    @Column(nullable = true)
    private String diaFuncionamentoArcoDDomingo;
    @Transient
    List<String> isFuncionamentoArcoDDomingo = new ArrayList<String>();
    @Column(nullable = true)
    private String diaFuncionamentoArcoDSegunda;
    @Transient
    List<String> isFuncionamentoArcoDSegunda = new ArrayList<String>();
    @Column(nullable = true)
    private String diaFuncionamentoArcoDTerca;
    @Transient
    List<String> isFuncionamentoArcoDTerca = new ArrayList<String>();
    @Column(nullable = true)
    private String diaFuncionamentoArcoDQuarta;
    @Transient
    List<String> isFuncionamentoArcoDQuarta = new ArrayList<String>();
    @Column(nullable = true)
    private String diaFuncionamentoArcoDQuinta;
    @Transient
    List<String> isFuncionamentoArcoDQuinta = new ArrayList<String>();
    @Column(nullable = true)
    private String diaFuncionamentoArcoDSexta;
    @Transient
    List<String> isFuncionamentoArcoDSexta = new ArrayList<String>();
    @Column(nullable = true)
    private String diaFuncionamentoArcoDSabado;
    @Transient
    List<String> isFuncionamentoArcoDSabado = new ArrayList<String>();
    @Column(nullable = true)
    private String diaFuncionamentoArcoEDomingo;
    @Transient
    List<String> isFuncionamentoArcoEDomingo = new ArrayList<String>();
    @Column(nullable = true)
    private String diaFuncionamentoArcoESegunda;
    @Transient
    List<String> isFuncionamentoArcoESegunda = new ArrayList<String>();
    @Column(nullable = true)
    private String diaFuncionamentoArcoETerca;
    @Transient
    List<String> isFuncionamentoArcoETerca = new ArrayList<String>();
    @Column(nullable = true)
    private String diaFuncionamentoArcoEQuarta;
    @Transient
    List<String> isFuncionamentoArcoEQuarta = new ArrayList<String>();
    @Column(nullable = true)
    private String diaFuncionamentoArcoEQuinta;
    @Transient
    List<String> isFuncionamentoArcoEQuinta = new ArrayList<String>();
    @Column(nullable = true)
    private String diaFuncionamentoArcoESexta;
    @Transient
    List<String> isFuncionamentoArcoESexta = new ArrayList<String>();
    @Column(nullable = true)
    private String diaFuncionamentoArcoESabado;
    @Transient
    List<String> isFuncionamentoArcoESabado = new ArrayList<String>();

    public String getArcosAOferecido() {
        return arcosAOferecido;
    }

    public void setArcosAOferecido(String arcosAOferecido) {
        this.arcosAOferecido = arcosAOferecido;
    }

    public String getArcosBOferecido() {
        return arcosBOferecido;
    }

    public void setArcosBOferecido(String arcosBOferecido) {
        this.arcosBOferecido = arcosBOferecido;
    }

    public String getArcosCOferecido() {
        return arcosCOferecido;
    }

    public void setArcosCOferecido(String arcosCOferecido) {
        this.arcosCOferecido = arcosCOferecido;
    }

    public String getArcosDOferecido() {
        return arcosDOferecido;
    }

    public void setArcosDOferecido(String arcosDOferecido) {
        this.arcosDOferecido = arcosDOferecido;
    }

    public String getArcosEOferecido() {
        return arcosEOferecido;
    }

    public void setArcosEOferecido(String arcosEOferecido) {
        this.arcosEOferecido = arcosEOferecido;
    }

    public String getDiaFuncionamentoArcoADomingo() {
        return diaFuncionamentoArcoADomingo;
    }

    public void setDiaFuncionamentoArcoADomingo(String diaFuncionamentoArcoADomingo) {
        this.diaFuncionamentoArcoADomingo = diaFuncionamentoArcoADomingo;
    }

    public String getDiaFuncionamentoArcoAQuarta() {
        return diaFuncionamentoArcoAQuarta;
    }

    public void setDiaFuncionamentoArcoAQuarta(String diaFuncionamentoArcoAQuarta) {
        this.diaFuncionamentoArcoAQuarta = diaFuncionamentoArcoAQuarta;
    }

    public String getDiaFuncionamentoArcoAQuinta() {
        return diaFuncionamentoArcoAQuinta;
    }

    public void setDiaFuncionamentoArcoAQuinta(String diaFuncionamentoArcoAQuinta) {
        this.diaFuncionamentoArcoAQuinta = diaFuncionamentoArcoAQuinta;
    }

    public String getDiaFuncionamentoArcoASabado() {
        return diaFuncionamentoArcoASabado;
    }

    public void setDiaFuncionamentoArcoASabado(String diaFuncionamentoArcoASabado) {
        this.diaFuncionamentoArcoASabado = diaFuncionamentoArcoASabado;
    }

    public String getDiaFuncionamentoArcoASegunda() {
        return diaFuncionamentoArcoASegunda;
    }

    public void setDiaFuncionamentoArcoASegunda(String diaFuncionamentoArcoASegunda) {
        this.diaFuncionamentoArcoASegunda = diaFuncionamentoArcoASegunda;
    }

    public String getDiaFuncionamentoArcoASexta() {
        return diaFuncionamentoArcoASexta;
    }

    public void setDiaFuncionamentoArcoASexta(String diaFuncionamentoArcoASexta) {
        this.diaFuncionamentoArcoASexta = diaFuncionamentoArcoASexta;
    }

    public String getDiaFuncionamentoArcoATerca() {
        return diaFuncionamentoArcoATerca;
    }

    public void setDiaFuncionamentoArcoATerca(String diaFuncionamentoArcoATerca) {
        this.diaFuncionamentoArcoATerca = diaFuncionamentoArcoATerca;
    }

    public String getDiaFuncionamentoArcoBDomingo() {
        return diaFuncionamentoArcoBDomingo;
    }

    public void setDiaFuncionamentoArcoBDomingo(String diaFuncionamentoArcoBDomingo) {
        this.diaFuncionamentoArcoBDomingo = diaFuncionamentoArcoBDomingo;
    }

    public String getDiaFuncionamentoArcoBQuarta() {
        return diaFuncionamentoArcoBQuarta;
    }

    public void setDiaFuncionamentoArcoBQuarta(String diaFuncionamentoArcoBQuarta) {
        this.diaFuncionamentoArcoBQuarta = diaFuncionamentoArcoBQuarta;
    }

    public String getDiaFuncionamentoArcoBQuinta() {
        return diaFuncionamentoArcoBQuinta;
    }

    public void setDiaFuncionamentoArcoBQuinta(String diaFuncionamentoArcoBQuinta) {
        this.diaFuncionamentoArcoBQuinta = diaFuncionamentoArcoBQuinta;
    }

    public String getDiaFuncionamentoArcoBSabado() {
        return diaFuncionamentoArcoBSabado;
    }

    public void setDiaFuncionamentoArcoBSabado(String diaFuncionamentoArcoBSabado) {
        this.diaFuncionamentoArcoBSabado = diaFuncionamentoArcoBSabado;
    }

    public String getDiaFuncionamentoArcoBSegunda() {
        return diaFuncionamentoArcoBSegunda;
    }

    public void setDiaFuncionamentoArcoBSegunda(String diaFuncionamentoArcoBSegunda) {
        this.diaFuncionamentoArcoBSegunda = diaFuncionamentoArcoBSegunda;
    }

    public String getDiaFuncionamentoArcoBSexta() {
        return diaFuncionamentoArcoBSexta;
    }

    public void setDiaFuncionamentoArcoBSexta(String diaFuncionamentoArcoBSexta) {
        this.diaFuncionamentoArcoBSexta = diaFuncionamentoArcoBSexta;
    }

    public String getDiaFuncionamentoArcoBTerca() {
        return diaFuncionamentoArcoBTerca;
    }

    public void setDiaFuncionamentoArcoBTerca(String diaFuncionamentoArcoBTerca) {
        this.diaFuncionamentoArcoBTerca = diaFuncionamentoArcoBTerca;
    }

    public String getDiaFuncionamentoArcoCDomingo() {
        return diaFuncionamentoArcoCDomingo;
    }

    public void setDiaFuncionamentoArcoCDomingo(String diaFuncionamentoArcoCDomingo) {
        this.diaFuncionamentoArcoCDomingo = diaFuncionamentoArcoCDomingo;
    }

    public String getDiaFuncionamentoArcoCQuarta() {
        return diaFuncionamentoArcoCQuarta;
    }

    public void setDiaFuncionamentoArcoCQuarta(String diaFuncionamentoArcoCQuarta) {
        this.diaFuncionamentoArcoCQuarta = diaFuncionamentoArcoCQuarta;
    }

    public String getDiaFuncionamentoArcoCQuinta() {
        return diaFuncionamentoArcoCQuinta;
    }

    public void setDiaFuncionamentoArcoCQuinta(String diaFuncionamentoArcoCQuinta) {
        this.diaFuncionamentoArcoCQuinta = diaFuncionamentoArcoCQuinta;
    }

    public String getDiaFuncionamentoArcoCSabado() {
        return diaFuncionamentoArcoCSabado;
    }

    public void setDiaFuncionamentoArcoCSabado(String diaFuncionamentoArcoCSabado) {
        this.diaFuncionamentoArcoCSabado = diaFuncionamentoArcoCSabado;
    }

    public String getDiaFuncionamentoArcoCSegunda() {
        return diaFuncionamentoArcoCSegunda;
    }

    public void setDiaFuncionamentoArcoCSegunda(String diaFuncionamentoArcoCSegunda) {
        this.diaFuncionamentoArcoCSegunda = diaFuncionamentoArcoCSegunda;
    }

    public String getDiaFuncionamentoArcoCSexta() {
        return diaFuncionamentoArcoCSexta;
    }

    public void setDiaFuncionamentoArcoCSexta(String diaFuncionamentoArcoCSexta) {
        this.diaFuncionamentoArcoCSexta = diaFuncionamentoArcoCSexta;
    }

    public String getDiaFuncionamentoArcoCTerca() {
        return diaFuncionamentoArcoCTerca;
    }

    public void setDiaFuncionamentoArcoCTerca(String diaFuncionamentoArcoCTerca) {
        this.diaFuncionamentoArcoCTerca = diaFuncionamentoArcoCTerca;
    }

    public String getDiaFuncionamentoArcoDDomingo() {
        return diaFuncionamentoArcoDDomingo;
    }

    public void setDiaFuncionamentoArcoDDomingo(String diaFuncionamentoArcoDDomingo) {
        this.diaFuncionamentoArcoDDomingo = diaFuncionamentoArcoDDomingo;
    }

    public String getDiaFuncionamentoArcoDQuarta() {
        return diaFuncionamentoArcoDQuarta;
    }

    public void setDiaFuncionamentoArcoDQuarta(String diaFuncionamentoArcoDQuarta) {
        this.diaFuncionamentoArcoDQuarta = diaFuncionamentoArcoDQuarta;
    }

    public String getDiaFuncionamentoArcoDQuinta() {
        return diaFuncionamentoArcoDQuinta;
    }

    public void setDiaFuncionamentoArcoDQuinta(String diaFuncionamentoArcoDQuinta) {
        this.diaFuncionamentoArcoDQuinta = diaFuncionamentoArcoDQuinta;
    }

    public String getDiaFuncionamentoArcoDSabado() {
        return diaFuncionamentoArcoDSabado;
    }

    public void setDiaFuncionamentoArcoDSabado(String diaFuncionamentoArcoDSabado) {
        this.diaFuncionamentoArcoDSabado = diaFuncionamentoArcoDSabado;
    }

    public String getDiaFuncionamentoArcoDSegunda() {
        return diaFuncionamentoArcoDSegunda;
    }

    public void setDiaFuncionamentoArcoDSegunda(String diaFuncionamentoArcoDSegunda) {
        this.diaFuncionamentoArcoDSegunda = diaFuncionamentoArcoDSegunda;
    }

    public String getDiaFuncionamentoArcoDSexta() {
        return diaFuncionamentoArcoDSexta;
    }

    public void setDiaFuncionamentoArcoDSexta(String diaFuncionamentoArcoDSexta) {
        this.diaFuncionamentoArcoDSexta = diaFuncionamentoArcoDSexta;
    }

    public String getDiaFuncionamentoArcoDTerca() {
        return diaFuncionamentoArcoDTerca;
    }

    public void setDiaFuncionamentoArcoDTerca(String diaFuncionamentoArcoDTerca) {
        this.diaFuncionamentoArcoDTerca = diaFuncionamentoArcoDTerca;
    }

    public String getDiaFuncionamentoArcoEDomingo() {
        return diaFuncionamentoArcoEDomingo;
    }

    public void setDiaFuncionamentoArcoEDomingo(String diaFuncionamentoArcoEDomingo) {
        this.diaFuncionamentoArcoEDomingo = diaFuncionamentoArcoEDomingo;
    }

    public String getDiaFuncionamentoArcoEQuarta() {
        return diaFuncionamentoArcoEQuarta;
    }

    public void setDiaFuncionamentoArcoEQuarta(String diaFuncionamentoArcoEQuarta) {
        this.diaFuncionamentoArcoEQuarta = diaFuncionamentoArcoEQuarta;
    }

    public String getDiaFuncionamentoArcoEQuinta() {
        return diaFuncionamentoArcoEQuinta;
    }

    public void setDiaFuncionamentoArcoEQuinta(String diaFuncionamentoArcoEQuinta) {
        this.diaFuncionamentoArcoEQuinta = diaFuncionamentoArcoEQuinta;
    }

    public String getDiaFuncionamentoArcoESabado() {
        return diaFuncionamentoArcoESabado;
    }

    public void setDiaFuncionamentoArcoESabado(String diaFuncionamentoArcoESabado) {
        this.diaFuncionamentoArcoESabado = diaFuncionamentoArcoESabado;
    }

    public String getDiaFuncionamentoArcoESegunda() {
        return diaFuncionamentoArcoESegunda;
    }

    public void setDiaFuncionamentoArcoESegunda(String diaFuncionamentoArcoESegunda) {
        this.diaFuncionamentoArcoESegunda = diaFuncionamentoArcoESegunda;
    }

    public String getDiaFuncionamentoArcoESexta() {
        return diaFuncionamentoArcoESexta;
    }

    public void setDiaFuncionamentoArcoESexta(String diaFuncionamentoArcoESexta) {
        this.diaFuncionamentoArcoESexta = diaFuncionamentoArcoESexta;
    }

    public String getDiaFuncionamentoArcoETerca() {
        return diaFuncionamentoArcoETerca;
    }

    public void setDiaFuncionamentoArcoETerca(String diaFuncionamentoArcoETerca) {
        this.diaFuncionamentoArcoETerca = diaFuncionamentoArcoETerca;
    }

    public String getEnderecoLocal() {
        return enderecoLocal;
    }

    public void setEnderecoLocal(String enderecoLocal) {
        this.enderecoLocal = enderecoLocal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<String> getIsArcosAOferecido() {
        return isArcosAOferecido;
    }

    public void setIsArcosAOferecido(List<String> isArcosAOferecido) {
        this.isArcosAOferecido = isArcosAOferecido;
    }

    public List<String> getIsArcosBOferecido() {
        return isArcosBOferecido;
    }

    public void setIsArcosBOferecido(List<String> isArcosBOferecido) {
        this.isArcosBOferecido = isArcosBOferecido;
    }

    public List<String> getIsArcosCOferecido() {
        return isArcosCOferecido;
    }

    public void setIsArcosCOferecido(List<String> isArcosCOferecido) {
        this.isArcosCOferecido = isArcosCOferecido;
    }

    public List<String> getIsArcosDOferecido() {
        return isArcosDOferecido;
    }

    public void setIsArcosDOferecido(List<String> isArcosDOferecido) {
        this.isArcosDOferecido = isArcosDOferecido;
    }

    public List<String> getIsArcosEOferecido() {
        return isArcosEOferecido;
    }

    public void setIsArcosEOferecido(List<String> isArcosEOferecido) {
        this.isArcosEOferecido = isArcosEOferecido;
    }

    public List<String> getIsFuncionamentoArcoADomingo() {
        return isFuncionamentoArcoADomingo;
    }

    public void setIsFuncionamentoArcoADomingo(List<String> isFuncionamentoArcoADomingo) {
        this.isFuncionamentoArcoADomingo = isFuncionamentoArcoADomingo;
    }

    public List<String> getIsFuncionamentoArcoAQuarta() {
        return isFuncionamentoArcoAQuarta;
    }

    public void setIsFuncionamentoArcoAQuarta(List<String> isFuncionamentoArcoAQuarta) {
        this.isFuncionamentoArcoAQuarta = isFuncionamentoArcoAQuarta;
    }

    public List<String> getIsFuncionamentoArcoAQuinta() {
        return isFuncionamentoArcoAQuinta;
    }

    public void setIsFuncionamentoArcoAQuinta(List<String> isFuncionamentoArcoAQuinta) {
        this.isFuncionamentoArcoAQuinta = isFuncionamentoArcoAQuinta;
    }

    public List<String> getIsFuncionamentoArcoASabado() {
        return isFuncionamentoArcoASabado;
    }

    public void setIsFuncionamentoArcoASabado(List<String> isFuncionamentoArcoASabado) {
        this.isFuncionamentoArcoASabado = isFuncionamentoArcoASabado;
    }

    public List<String> getIsFuncionamentoArcoASegunda() {
        return isFuncionamentoArcoASegunda;
    }

    public void setIsFuncionamentoArcoASegunda(List<String> isFuncionamentoArcoASegunda) {
        this.isFuncionamentoArcoASegunda = isFuncionamentoArcoASegunda;
    }

    public List<String> getIsFuncionamentoArcoATerca() {
        return isFuncionamentoArcoATerca;
    }

    public void setIsFuncionamentoArcoATerca(List<String> isFuncionamentoArcoATerca) {
        this.isFuncionamentoArcoATerca = isFuncionamentoArcoATerca;
    }

    public List<String> getIsFuncionamentoArcoBDomingo() {
        return isFuncionamentoArcoBDomingo;
    }

    public void setIsFuncionamentoArcoBDomingo(List<String> isFuncionamentoArcoBDomingo) {
        this.isFuncionamentoArcoBDomingo = isFuncionamentoArcoBDomingo;
    }

    public List<String> getIsFuncionamentoArcoBQuarta() {
        return isFuncionamentoArcoBQuarta;
    }

    public void setIsFuncionamentoArcoBQuarta(List<String> isFuncionamentoArcoBQuarta) {
        this.isFuncionamentoArcoBQuarta = isFuncionamentoArcoBQuarta;
    }

    public List<String> getIsFuncionamentoArcoBQuinta() {
        return isFuncionamentoArcoBQuinta;
    }

    public void setIsFuncionamentoArcoBQuinta(List<String> isFuncionamentoArcoBQuinta) {
        this.isFuncionamentoArcoBQuinta = isFuncionamentoArcoBQuinta;
    }

    public List<String> getIsFuncionamentoArcoBSabado() {
        return isFuncionamentoArcoBSabado;
    }

    public void setIsFuncionamentoArcoBSabado(List<String> isFuncionamentoArcoBSabado) {
        this.isFuncionamentoArcoBSabado = isFuncionamentoArcoBSabado;
    }

    public List<String> getIsFuncionamentoArcoBSegunda() {
        return isFuncionamentoArcoBSegunda;
    }

    public void setIsFuncionamentoArcoBSegunda(List<String> isFuncionamentoArcoBSegunda) {
        this.isFuncionamentoArcoBSegunda = isFuncionamentoArcoBSegunda;
    }

    public List<String> getIsFuncionamentoArcoBTerca() {
        return isFuncionamentoArcoBTerca;
    }

    public void setIsFuncionamentoArcoBTerca(List<String> isFuncionamentoArcoBTerca) {
        this.isFuncionamentoArcoBTerca = isFuncionamentoArcoBTerca;
    }

    public List<String> getIsFuncionamentoArcoCDomingo() {
        return isFuncionamentoArcoCDomingo;
    }

    public void setIsFuncionamentoArcoCDomingo(List<String> isFuncionamentoArcoCDomingo) {
        this.isFuncionamentoArcoCDomingo = isFuncionamentoArcoCDomingo;
    }

    public List<String> getIsFuncionamentoArcoCQuarta() {
        return isFuncionamentoArcoCQuarta;
    }

    public void setIsFuncionamentoArcoCQuarta(List<String> isFuncionamentoArcoCQuarta) {
        this.isFuncionamentoArcoCQuarta = isFuncionamentoArcoCQuarta;
    }

    public List<String> getIsFuncionamentoArcoCQuinta() {
        return isFuncionamentoArcoCQuinta;
    }

    public void setIsFuncionamentoArcoCQuinta(List<String> isFuncionamentoArcoCQuinta) {
        this.isFuncionamentoArcoCQuinta = isFuncionamentoArcoCQuinta;
    }

    public List<String> getIsFuncionamentoArcoCSabado() {
        return isFuncionamentoArcoCSabado;
    }

    public void setIsFuncionamentoArcoCSabado(List<String> isFuncionamentoArcoCSabado) {
        this.isFuncionamentoArcoCSabado = isFuncionamentoArcoCSabado;
    }

    public List<String> getIsFuncionamentoArcoCSegunda() {
        return isFuncionamentoArcoCSegunda;
    }

    public void setIsFuncionamentoArcoCSegunda(List<String> isFuncionamentoArcoCSegunda) {
        this.isFuncionamentoArcoCSegunda = isFuncionamentoArcoCSegunda;
    }

    public List<String> getIsFuncionamentoArcoCTerca() {
        return isFuncionamentoArcoCTerca;
    }

    public void setIsFuncionamentoArcoCTerca(List<String> isFuncionamentoArcoCTerca) {
        this.isFuncionamentoArcoCTerca = isFuncionamentoArcoCTerca;
    }

    public List<String> getIsFuncionamentoArcoDDomingo() {
        return isFuncionamentoArcoDDomingo;
    }

    public void setIsFuncionamentoArcoDDomingo(List<String> isFuncionamentoArcoDDomingo) {
        this.isFuncionamentoArcoDDomingo = isFuncionamentoArcoDDomingo;
    }

    public List<String> getIsFuncionamentoArcoDQuarta() {
        return isFuncionamentoArcoDQuarta;
    }

    public void setIsFuncionamentoArcoDQuarta(List<String> isFuncionamentoArcoDQuarta) {
        this.isFuncionamentoArcoDQuarta = isFuncionamentoArcoDQuarta;
    }

    public List<String> getIsFuncionamentoArcoDQuinta() {
        return isFuncionamentoArcoDQuinta;
    }

    public void setIsFuncionamentoArcoDQuinta(List<String> isFuncionamentoArcoDQuinta) {
        this.isFuncionamentoArcoDQuinta = isFuncionamentoArcoDQuinta;
    }

    public List<String> getIsFuncionamentoArcoDSabado() {
        return isFuncionamentoArcoDSabado;
    }

    public void setIsFuncionamentoArcoDSabado(List<String> isFuncionamentoArcoDSabado) {
        this.isFuncionamentoArcoDSabado = isFuncionamentoArcoDSabado;
    }

    public List<String> getIsFuncionamentoArcoDSegunda() {
        return isFuncionamentoArcoDSegunda;
    }

    public void setIsFuncionamentoArcoDSegunda(List<String> isFuncionamentoArcoDSegunda) {
        this.isFuncionamentoArcoDSegunda = isFuncionamentoArcoDSegunda;
    }

    public List<String> getIsFuncionamentoArcoDTerca() {
        return isFuncionamentoArcoDTerca;
    }

    public void setIsFuncionamentoArcoDTerca(List<String> isFuncionamentoArcoDTerca) {
        this.isFuncionamentoArcoDTerca = isFuncionamentoArcoDTerca;
    }

    public List<String> getIsFuncionamentoArcoEDomingo() {
        return isFuncionamentoArcoEDomingo;
    }

    public void setIsFuncionamentoArcoEDomingo(List<String> isFuncionamentoArcoEDomingo) {
        this.isFuncionamentoArcoEDomingo = isFuncionamentoArcoEDomingo;
    }

    public List<String> getIsFuncionamentoArcoEQuarta() {
        return isFuncionamentoArcoEQuarta;
    }

    public void setIsFuncionamentoArcoEQuarta(List<String> isFuncionamentoArcoEQuarta) {
        this.isFuncionamentoArcoEQuarta = isFuncionamentoArcoEQuarta;
    }

    public List<String> getIsFuncionamentoArcoEQuinta() {
        return isFuncionamentoArcoEQuinta;
    }

    public void setIsFuncionamentoArcoEQuinta(List<String> isFuncionamentoArcoEQuinta) {
        this.isFuncionamentoArcoEQuinta = isFuncionamentoArcoEQuinta;
    }

    public List<String> getIsFuncionamentoArcoESabado() {
        return isFuncionamentoArcoESabado;
    }

    public void setIsFuncionamentoArcoESabado(List<String> isFuncionamentoArcoESabado) {
        this.isFuncionamentoArcoESabado = isFuncionamentoArcoESabado;
    }

    public List<String> getIsFuncionamentoArcoESegunda() {
        return isFuncionamentoArcoESegunda;
    }

    public void setIsFuncionamentoArcoESegunda(List<String> isFuncionamentoArcoESegunda) {
        this.isFuncionamentoArcoESegunda = isFuncionamentoArcoESegunda;
    }

    public List<String> getIsFuncionamentoArcoASexta() {
        return isFuncionamentoArcoASexta;
    }

    public void setIsFuncionamentoArcoASexta(List<String> isFuncionamentoArcoASexta) {
        this.isFuncionamentoArcoASexta = isFuncionamentoArcoASexta;
    }

    public List<String> getIsFuncionamentoArcoBSexta() {
        return isFuncionamentoArcoBSexta;
    }

    public void setIsFuncionamentoArcoBSexta(List<String> isFuncionamentoArcoBSexta) {
        this.isFuncionamentoArcoBSexta = isFuncionamentoArcoBSexta;
    }

    public List<String> getIsFuncionamentoArcoCSexta() {
        return isFuncionamentoArcoCSexta;
    }

    public void setIsFuncionamentoArcoCSexta(List<String> isFuncionamentoArcoCSexta) {
        this.isFuncionamentoArcoCSexta = isFuncionamentoArcoCSexta;
    }

    public List<String> getIsFuncionamentoArcoDSexta() {
        return isFuncionamentoArcoDSexta;
    }

    public void setIsFuncionamentoArcoDSexta(List<String> isFuncionamentoArcoDSexta) {
        this.isFuncionamentoArcoDSexta = isFuncionamentoArcoDSexta;
    }

    public List<String> getIsFuncionamentoArcoESexta() {
        return isFuncionamentoArcoESexta;
    }

    public void setIsFuncionamentoArcoESexta(List<String> isFuncionamentoArcoESexta) {
        this.isFuncionamentoArcoESexta = isFuncionamentoArcoESexta;
    }

    public List<String> getIsFuncionamentoArcoETerca() {
        return isFuncionamentoArcoETerca;
    }

    public void setIsFuncionamentoArcoETerca(List<String> isFuncionamentoArcoETerca) {
        this.isFuncionamentoArcoETerca = isFuncionamentoArcoETerca;
    }

    public String getTelefoneLocal() {
        return telefoneLocal;
    }

    public void setTelefoneLocal(String telefoneLocal) {
        this.telefoneLocal = telefoneLocal;
    }

    public String getTipoLocal() {
        return tipoLocal;
    }

    public void setTipoLocal(String tipoLocal) {
        this.tipoLocal = tipoLocal;
    }

    Rotina006CoordenacaoLocal obterDadosLocal(Rotina006CoordenacaoLocal rotina) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
