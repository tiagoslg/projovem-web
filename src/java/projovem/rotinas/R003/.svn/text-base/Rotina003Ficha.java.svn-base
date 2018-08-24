
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.rotinas.R003;

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
public class Rotina003Ficha implements Serializable {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = true, length = 250)
    private String numero;
    @Column(nullable = true, length = 250)
    private String nomeParticipante;
    @Column(nullable = true, length = 250)
    private String temCarteiraIdentidade;
    @Column(nullable = true, length = 250)
    private String temComprovanteResidencia;
    @Column(nullable = true, length = 250)
    private String temRegistroEscolar;
    @Column(nullable = true, length = 250)
    private String temTeste;

    @Transient
    List<String> atributos = new ArrayList<String>();

    public List<String> getAtributos() {
        return atributos;
    }

    public void setAtributos(List<String> atributos) {
        this.atributos = atributos;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeParticipante() {
        return nomeParticipante;
    }

    public void setNomeParticipante(String nomeParticipante) {
        this.nomeParticipante = nomeParticipante;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTemCarteiraIdentidade() {
        return temCarteiraIdentidade;
    }

    public void setTemCarteiraIdentidade(String temCarteiraIdentidade) {
        this.temCarteiraIdentidade = temCarteiraIdentidade;
    }

    public String getTemComprovanteResidencia() {
        return temComprovanteResidencia;
    }

    public void setTemComprovanteResidencia(String temComprovanteResidencia) {
        this.temComprovanteResidencia = temComprovanteResidencia;
    }

    public String getTemRegistroEscolar() {
        return temRegistroEscolar;
    }

    public void setTemRegistroEscolar(String temRegistroEscolar) {
        this.temRegistroEscolar = temRegistroEscolar;
    }

    public String getTemTeste() {
        return temTeste;
    }

    public void setTemTeste(String temTeste) {
        this.temTeste = temTeste;
    }

    
}
