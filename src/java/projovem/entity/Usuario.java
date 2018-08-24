/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author admprojovem
 */
@Entity
@Table
public class Usuario implements Serializable {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, length = 250)
    private String cpf;
    @Column(nullable = true, length = 250)
    private String ir;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String senha;
    @Column(nullable = true)
    private String perfil;
    @Column(nullable = false, length = 255)
    private String Cordenacao;
    @Transient
    private String dataAtual;
    @Transient
    private String horaAtual;

    public String getDataAtual() {
        Locale locale = new Locale("pt", "BR");
        GregorianCalendar dataHoje = new GregorianCalendar();
        SimpleDateFormat formata =  new SimpleDateFormat("dd'/'MM'/'yyyy", locale);
        Date data = dataHoje.getTime();
        String resultado = formata.format(data);
        dataAtual = resultado;
        return dataAtual;
    }

    public void setDataAtual(String dataAtual) {
        this.dataAtual = dataAtual;
    }

    public String getHoraAtual() {
        Locale locale = new Locale("pt", "BR");
        GregorianCalendar dataHoje = new GregorianCalendar();
        SimpleDateFormat formata =  new SimpleDateFormat("HH':'mm", locale);
        Date data = dataHoje.getTime();
        String resultado = formata.format(data);
        horaAtual = resultado;
        return horaAtual;
    }

    public void setHoraAtual(String horaAtual) {
        this.horaAtual = horaAtual;
    }

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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }


    public String getIr() {
        return ir;
    }

    public void setIr(String ir) {
        this.ir = ir;
    }

    /**
     * @return the perfil
     */
    public String getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    /**
     * @return the perfil
     */
    public String getCordenacao() {
        return Cordenacao;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setCordenacao(String Cordenacao) {
        this.Cordenacao = Cordenacao;
    }
}
