/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.relatorios.sintesesupervisao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import javax.persistence.EntityManagerFactory;
import projovem.dao.NucleoDAO;
import projovem.relatorios.sintesesupervisao.vo.Rotina007SinteseSupervisaoVo;
import projovem.rotinas.R007.Rotina007;

/**
 *
 * @author admprojovem
 */
public class SinteseSupervisaoRotina007 implements Serializable {

    private NucleoDAO nucleoDao = new NucleoDAO();
    private Rotina007SinteseSupervisaoVo contagem = new Rotina007SinteseSupervisaoVo();

    public Rotina007SinteseSupervisaoVo gerarRelatorio(String coordenacaoEscolhida, String entradaEscolhida, String observacaoEscolhida, String municipioEscolhida, EntityManagerFactory emf) {

        List<Rotina007> listaRotina007 = nucleoDao.obtemNucleosByCoordenacaoAndEntradaAndRotina007(coordenacaoEscolhida, entradaEscolhida, observacaoEscolhida, municipioEscolhida, emf);
        contagem.setListaRotina007(listaRotina007);


        for (Rotina007 rotina : listaRotina007) {

                if (rotina.getQ1() != null && rotina.getQ1().equals("sim")) {
                    contagem.setQ1a(contagem.getQ1a() + 1);
                }
                if (rotina.getQ1() != null && rotina.getQ1().equals("parcialmente")) {
                    contagem.setQ1b(contagem.getQ1b() + 1);
                    contagem.setNegativo(contagem.getNegativo() + 1);
                }
                if (rotina.getQ1() != null && rotina.getQ1().equals("nao")) {
                    contagem.setQ1c(contagem.getQ1c() + 1);
                    contagem.setNegativo(contagem.getNegativo() + 1);
                }

                if (rotina.getQ2() != null && rotina.getQ2().equals("fundamental")) {
                    contagem.setQ2a(contagem.getQ2a() + 1);
                    contagem.setNegativo(contagem.getNegativo() + 1);
                }
                if (rotina.getQ2() != null && rotina.getQ2().equals("medio/tecnico")) {
                    contagem.setQ2b(contagem.getQ2b() + 1);
                    contagem.setNegativo(contagem.getNegativo() + 1);
                }
                if (rotina.getQ2() != null && rotina.getQ2().equals("medio/magisterio")) {
                    contagem.setQ2c(contagem.getQ2c() + 1);
                    contagem.setNegativo(contagem.getNegativo() + 1);
                }
                if (rotina.getQ2() != null && rotina.getQ2().equals("superiorIncompleto")) {
                    contagem.setQ2d(contagem.getQ2d() + 1);
                    contagem.setNegativo(contagem.getNegativo() + 1);
                }
                if (rotina.getQ2() != null && rotina.getQ2().equals("superiorCompletoTecnologico")) {
                    contagem.setQ2e(contagem.getQ2e() + 1);
                }
                if (rotina.getQ2() != null && rotina.getQ2().equals("superiorCompletoLicenciatura")) {
                    contagem.setQ2f(contagem.getQ2f() + 1);
                }
                if (rotina.getQ2() != null && rotina.getQ2().equals("superiorCompletoBacharelado")) {
                    contagem.setQ2g(contagem.getQ2g() + 1);
                }
                if (rotina.getQ2() != null && rotina.getQ2().equals("latoSensu")) {
                    contagem.setQ2h(contagem.getQ2h() + 1);
                    contagem.setPositivo(contagem.getPositivo() + 1);
                }
                if (rotina.getQ2() != null && rotina.getQ2().equals("Mestrado")) {
                    contagem.setQ2i(contagem.getQ2i() + 1);
                    contagem.setPositivo(contagem.getPositivo() + 1);
                }
                if (rotina.getQ2() != null && rotina.getQ2().equals("Doutorado")) {
                    contagem.setQ2j(contagem.getQ2j() + 1);
                    contagem.setPositivo(contagem.getPositivo() + 1);
                }

                if (rotina.getQ3() != null && rotina.getQ3().equals("NaoConcluí")) {
                    contagem.setQ3a(contagem.getQ3a() + 1);
                    contagem.setNegativo(contagem.getNegativo() + 1);
                }
                if (rotina.getQ3() != null && rotina.getQ3().equals("Tecnologo")) {
                    contagem.setQ3b(contagem.getQ3b() + 1);
                }
                if (rotina.getQ3() != null && rotina.getQ3().equals("Educacao")) {
                    contagem.setQ3c(contagem.getQ3c() + 1);
                }
                if (rotina.getQ3() != null && rotina.getQ3().equals("Letras")) {
                    contagem.setQ3d(contagem.getQ3d() + 1);
                }
                if (rotina.getQ3() != null && rotina.getQ3().equals("Humanas")) {
                    contagem.setQ3e(contagem.getQ3e() + 1);
                }
                if (rotina.getQ3() != null && rotina.getQ3().equals("Exatas")) {
                    contagem.setQ3f(contagem.getQ3f() + 1);
                }
                if (rotina.getQ3() != null && rotina.getQ3().equals("Biologicas")) {
                    contagem.setQ3g(contagem.getQ3g() + 1);
                }

                if (rotina.getQ6a() != null && rotina.getQ6a().equals("Sim")) {
                    contagem.setQ6asim(contagem.getQ6asim() + 1);
                }
                if (rotina.getQ6a() != null && rotina.getQ6a().equals("Nao")) {
                    contagem.setQ6anao(contagem.getQ6anao() + 1);
                    contagem.setNegativo(contagem.getNegativo() + 1);
                }

                if (rotina.getQ6b() != null && rotina.getQ6b().equals("Sim")) {
                    contagem.setQ6bsim(contagem.getQ6bsim() + 1);
                }
                if (rotina.getQ6b() != null && rotina.getQ6b().equals("Nao")) {
                    contagem.setQ6bnao(contagem.getQ6bnao() + 1);
                    contagem.setNegativo(contagem.getNegativo() + 1);
                }

                if (rotina.getQ6c() != null && rotina.getQ6c().equals("Sim")) {
                    contagem.setQ6csim(contagem.getQ6csim() + 1);
                }
                if (rotina.getQ6c() != null && rotina.getQ6c().equals("Nao")) {
                    contagem.setQ6cnao(contagem.getQ6cnao() + 1);
                    contagem.setNegativo(contagem.getNegativo() + 1);
                }

                if (rotina.getQ6d() != null && rotina.getQ6d().equals("Sim")) {
                    contagem.setQ6dsim(contagem.getQ6dsim() + 1);
                }
                if (rotina.getQ6d() != null && rotina.getQ6d().equals("Nao")) {
                    contagem.setQ6dnao(contagem.getQ6dnao() + 1);
                    contagem.setNegativo(contagem.getNegativo() + 1);
                }

                if (rotina.getQ6e() != null && rotina.getQ6e().equals("Sim")) {
                    contagem.setQ6esim(contagem.getQ6esim() + 1);
                }
                if (rotina.getQ6e() != null && rotina.getQ6e().equals("Nao")) {
                    contagem.setQ6enao(contagem.getQ6enao() + 1);
                    contagem.setNegativo(contagem.getNegativo() + 1);
                }

                if (rotina.getQ6f() != null && rotina.getQ6f().equals("Sim")) {
                    contagem.setQ6fsim(contagem.getQ6fsim() + 1);
                }
                if (rotina.getQ6f() != null && rotina.getQ6f().equals("Nao")) {
                    contagem.setQ6fnao(contagem.getQ6fnao() + 1);
                    contagem.setNegativo(contagem.getNegativo() + 1);
                }

                if (rotina.getQ6g() != null && rotina.getQ6g().equals("Sim")) {
                    contagem.setQ6gsim(contagem.getQ6gsim() + 1);
                }
                if (rotina.getQ6g() != null && rotina.getQ6g().equals("Nao")) {
                    contagem.setQ6gnao(contagem.getQ6gnao() + 1);
                    contagem.setNegativo(contagem.getNegativo() + 1);
                }

                if (rotina.getQ7SoftwaresTexto() != null && rotina.getQ7SoftwaresTexto().equals("naoSei")) {
                    contagem.setQ7aa(contagem.getQ7aa() + 1);
                    contagem.setNegativo(contagem.getNegativo() + 1);
                }
                if (rotina.getQ7SoftwaresTexto() != null && rotina.getQ7SoftwaresTexto().equals("basico")) {
                    contagem.setQ7ab(contagem.getQ7ab() + 1);
                }
                if (rotina.getQ7SoftwaresTexto() != null && rotina.getQ7SoftwaresTexto().equals("avancado")) {
                    contagem.setQ7ac(contagem.getQ7ac() + 1);
                }

                if (rotina.getQ7ConfeccaoPlanilhas() != null && rotina.getQ7ConfeccaoPlanilhas().equals("naoSei")) {
                    contagem.setQ7ba(contagem.getQ7ba() + 1);
                    contagem.setNegativo(contagem.getNegativo() + 1);
                }
                if (rotina.getQ7ConfeccaoPlanilhas() != null && rotina.getQ7ConfeccaoPlanilhas().equals("basico")) {
                    contagem.setQ7bb(contagem.getQ7bb() + 1);
                }
                if (rotina.getQ7ConfeccaoPlanilhas() != null && rotina.getQ7ConfeccaoPlanilhas().equals("avancado")) {
                    contagem.setQ7bc(contagem.getQ7bc() + 1);
                }

                if (rotina.getQ7Internet() != null && rotina.getQ7Internet().equals("naoSei")) {
                    contagem.setQ7ca(contagem.getQ7ca() + 1);
                    contagem.setNegativo(contagem.getNegativo() + 1);
                }
                if (rotina.getQ7Internet() != null && rotina.getQ7Internet().equals("basico")) {
                    contagem.setQ7cb(contagem.getQ7cb() + 1);
                }
                if (rotina.getQ7Internet() != null && rotina.getQ7Internet().equals("avancado")) {
                    contagem.setQ7cc(contagem.getQ7cc() + 1);
                }

                if (rotina.getQ9() != null && rotina.getQ9().equals("12mais")) {
                    contagem.setQ9a(contagem.getQ9a() + 1);
                }
                if (rotina.getQ9() != null && rotina.getQ9().equals("12menos")) {
                    contagem.setQ9b(contagem.getQ9b() + 1);
                }
                if (rotina.getQ9() != null && rotina.getQ9().equals("nao")) {
                    contagem.setQ9c(contagem.getQ9c() + 1);
                    contagem.setNegativo(contagem.getNegativo() + 1);
                }

                if (rotina.getQ11() != null && rotina.getQ11().equals("sempre")) {
                    contagem.setQ11a(contagem.getQ11a() + 1);
                    contagem.setPositivo(contagem.getPositivo() + 1);
                }
                if (rotina.getQ11() != null && rotina.getQ11().equals("asVezes")) {
                    contagem.setQ11b(contagem.getQ11b() + 1);
                }
                if (rotina.getQ11() != null && rotina.getQ11().equals("raramente")) {
                    contagem.setQ11c(contagem.getQ11c() + 1);
                }
                if (rotina.getQ11() != null && rotina.getQ11().equals("nao")) {
                    contagem.setQ11d(contagem.getQ11d() + 1);
                }

                if (rotina.getQ12() != null && rotina.getQ12().equals("sim")) {
                    contagem.setQ12a(contagem.getQ12a() + 1);
                }
                if (rotina.getQ12() != null && rotina.getQ12().equals("nao")) {
                    contagem.setQ12b(contagem.getQ12b() + 1);
                    contagem.setNegativo(contagem.getNegativo() + 1);
                }
                if (rotina.getQ12() != null && rotina.getQ12().equals("naoSaoRealizadas")) {
                    contagem.setQ12c(contagem.getQ12c() + 1);
                }

                if (rotina.getQ14() != null && rotina.getQ14().equals("sim")) {
                    contagem.setQ14sim(contagem.getQ14sim() + 1);
                }
                if (rotina.getQ14() != null && rotina.getQ14().equals("nao")) {
                    contagem.setQ14nao(contagem.getQ14nao() + 1);
                    contagem.setNegativo(contagem.getNegativo() + 1);
                }

                if (rotina.getQ15() != null && rotina.getQ15().equals("sim")) {
                    contagem.setQ15sim(contagem.getQ15sim() + 1);
                }
                if (rotina.getQ15() != null && rotina.getQ15().equals("nao")) {
                    contagem.setQ15nao(contagem.getQ15nao() + 1);
                    contagem.setNegativo(contagem.getNegativo() + 1);
                }

                if (rotina.getQ16() != null && rotina.getQ16().equals("Frequentemente")) {
                    contagem.setQ16a(contagem.getQ16a() + 1);
                }
                if (rotina.getQ16() != null && rotina.getQ16().equals("Raramente")) {
                    contagem.setQ16b(contagem.getQ16b() + 1);
                }
                if (rotina.getQ16() != null && rotina.getQ16().equals("Nunca")) {
                    contagem.setQ16c(contagem.getQ16c() + 1);
                    contagem.setNegativo(contagem.getNegativo() + 1);
                }

                if (rotina.getQ17() != null && rotina.getQ17().equals("Frequentemente")) {
                    contagem.setQ17a(contagem.getQ17a() + 1);
                }
                if (rotina.getQ17() != null && rotina.getQ17().equals("Raramente")) {
                    contagem.setQ17b(contagem.getQ17b() + 1);
                }
                if (rotina.getQ17() != null && rotina.getQ17().equals("Nunca")) {
                    contagem.setQ17c(contagem.getQ17c() + 1);
                    contagem.setNegativo(contagem.getNegativo() + 1);
                }

                if (rotina.getQ18() != null && rotina.getQ18().equals("Frequentemente")) {
                    contagem.setQ18a(contagem.getQ18a() + 1);
                }
                if (rotina.getQ18() != null && rotina.getQ18().equals("Raramente")) {
                    contagem.setQ18b(contagem.getQ18b() + 1);
                }
                if (rotina.getQ18() != null && rotina.getQ18().equals("Nunca")) {
                    contagem.setQ18c(contagem.getQ18c() + 1);
                    contagem.setNegativo(contagem.getNegativo() + 1);
                }

                if (rotina.getQ19() != null && rotina.getQ19().equals("Frequentemente")) {
                    contagem.setQ19a(contagem.getQ19a() + 1);
                }
                if (rotina.getQ19() != null && rotina.getQ19().equals("Raramente")) {
                    contagem.setQ19b(contagem.getQ19b() + 1);
                }
                if (rotina.getQ19() != null && rotina.getQ19().equals("Nunca")) {
                    contagem.setQ19c(contagem.getQ19c() + 1);
                    contagem.setNegativo(contagem.getNegativo() + 1);
                }

                if (rotina.getQ20() != null && rotina.getQ20().equals("Frequentemente")) {
                    contagem.setQ20a(contagem.getQ20a() + 1);
                }
                if (rotina.getQ20() != null && rotina.getQ20().equals("Raramente")) {
                    contagem.setQ20b(contagem.getQ20b() + 1);
                }
                if (rotina.getQ20() != null && rotina.getQ20().equals("Nunca")) {
                    contagem.setQ20c(contagem.getQ20c() + 1);
                    contagem.setNegativo(contagem.getNegativo() + 1);
                }

                if (rotina.getQ21() != null && rotina.getQ21().equals("Frequentemente")) {
                    contagem.setQ21a(contagem.getQ21a() + 1);
                }
                if (rotina.getQ21() != null && rotina.getQ21().equals("Raramente")) {
                    contagem.setQ21b(contagem.getQ21b() + 1);
                }
                if (rotina.getQ21() != null && rotina.getQ21().equals("Nunca")) {
                    contagem.setQ21c(contagem.getQ21c() + 1);
                    contagem.setNegativo(contagem.getNegativo() + 1);
                }

                if (rotina.getQ22() != null && rotina.getQ22().equals("Frequentemente")) {
                    contagem.setQ22a(contagem.getQ22a() + 1);
                }
                if (rotina.getQ22() != null && rotina.getQ22().equals("Raramente")) {
                    contagem.setQ22b(contagem.getQ22b() + 1);
                }
                if (rotina.getQ22() != null && rotina.getQ22().equals("Nunca")) {
                    contagem.setQ22c(contagem.getQ22c() + 1);
                    contagem.setNegativo(contagem.getNegativo() + 1);
                }

                if (rotina.getQ23() != null && rotina.getQ23().equals("Frequentemente")) {
                    contagem.setQ23a(contagem.getQ23a() + 1);
                }
                if (rotina.getQ23() != null && rotina.getQ23().equals("Raramente")) {
                    contagem.setQ23b(contagem.getQ23b() + 1);
                }
                if (rotina.getQ23() != null && rotina.getQ23().equals("Nunca")) {
                    contagem.setQ23c(contagem.getQ23c() + 1);
                    contagem.setNegativo(contagem.getNegativo() + 1);
                }

                if (rotina.getQ24() != null && rotina.getQ24().equals("Frequentemente")) {
                    contagem.setQ24a(contagem.getQ24a() + 1);
                }
                if (rotina.getQ24() != null && rotina.getQ24().equals("Raramente")) {
                    contagem.setQ24b(contagem.getQ24b() + 1);
                }
                if (rotina.getQ24() != null && rotina.getQ24().equals("Nunca")) {
                    contagem.setQ24c(contagem.getQ24c() + 1);
                    contagem.setNegativo(contagem.getNegativo() + 1);
                }

                if (rotina.getQ25() != null && rotina.getQ25().equals("Frequentemente")) {
                    contagem.setQ25a(contagem.getQ25a() + 1);
                }
                if (rotina.getQ25() != null && rotina.getQ25().equals("Raramente")) {
                    contagem.setQ25b(contagem.getQ25b() + 1);
                }
                if (rotina.getQ25() != null && rotina.getQ25().equals("Nunca")) {
                    contagem.setQ25c(contagem.getQ25c() + 1);
                    contagem.setNegativo(contagem.getNegativo() + 1);
                }

                if (rotina.getQ26() != null && rotina.getQ26().equals("Frequentemente")) {
                    contagem.setQ26a(contagem.getQ26a() + 1);
                }
                if (rotina.getQ26() != null && rotina.getQ26().equals("Raramente")) {
                    contagem.setQ26b(contagem.getQ26b() + 1);
                }
                if (rotina.getQ26() != null && rotina.getQ26().equals("Nunca")) {
                    contagem.setQ26c(contagem.getQ26c() + 1);
                    contagem.setNegativo(contagem.getNegativo() + 1);
                }

                if (rotina.getQ27() != null && rotina.getQ27().equals("Frequentemente")) {
                    contagem.setQ27a(contagem.getQ27a() + 1);
                }
                if (rotina.getQ27() != null && rotina.getQ27().equals("Raramente")) {
                    contagem.setQ27b(contagem.getQ27b() + 1);
                }
                if (rotina.getQ27() != null && rotina.getQ27().equals("Nunca")) {
                    contagem.setQ27c(contagem.getQ27c() + 1);
                    contagem.setNegativo(contagem.getNegativo() + 1);
                }
        }

        Integer totalElementos = listaRotina007.size();

        if (contagem.getQ1a() != null && contagem.getQ1a() != 0) {
            contagem.setQ1a((contagem.getQ1a() * 100) / totalElementos);
        }
        if (contagem.getQ1b() != null && contagem.getQ1b() != 0) {
            contagem.setQ1b((contagem.getQ1b() * 100) / totalElementos);
        }
        if (contagem.getQ1c() != null && contagem.getQ1c() != 0) {
            contagem.setQ1c((contagem.getQ1c() * 100) / totalElementos);
        }

        if (contagem.getQ2a() != null && contagem.getQ2a() != 0) {
            contagem.setQ2a((contagem.getQ2a() * 100) / totalElementos);
        }
        if (contagem.getQ2b() != null && contagem.getQ2b() != 0) {
            contagem.setQ2b((contagem.getQ2b() * 100) / totalElementos);
        }
        if (contagem.getQ2c() != null && contagem.getQ2c() != 0) {
            contagem.setQ2c((contagem.getQ2c() * 100) / totalElementos);
        }
        if (contagem.getQ2d() != null && contagem.getQ2d() != 0) {
            contagem.setQ2d((contagem.getQ2d() * 100) / totalElementos);
        }
        if (contagem.getQ2e() != null && contagem.getQ2e() != 0) {
            contagem.setQ2e((contagem.getQ2e() * 100) / totalElementos);
        }
        if (contagem.getQ2f() != null && contagem.getQ2f() != 0) {
            contagem.setQ2f((contagem.getQ2f() * 100) / totalElementos);
        }
        if (contagem.getQ2g() != null && contagem.getQ2g() != 0) {
            contagem.setQ2g((contagem.getQ2g() * 100) / totalElementos);
        }
        if (contagem.getQ2h() != null && contagem.getQ2h() != 0) {
            contagem.setQ2h((contagem.getQ2h() * 100) / totalElementos);
        }
        if (contagem.getQ2i() != null && contagem.getQ2i() != 0) {
            contagem.setQ2i((contagem.getQ2i() * 100) / totalElementos);
        }
        if (contagem.getQ2j() != null && contagem.getQ2j() != 0) {
            contagem.setQ2j((contagem.getQ2j() * 100) / totalElementos);
        }

        if (contagem.getQ3a() != null && contagem.getQ3a() != 0) {
            contagem.setQ3a((contagem.getQ3a() * 100) / totalElementos);
        }
        if (contagem.getQ3b() != null && contagem.getQ3b() != 0) {
            contagem.setQ3b((contagem.getQ3b() * 100) / totalElementos);
        }
        if (contagem.getQ3c() != null && contagem.getQ3c() != 0) {
            contagem.setQ3c((contagem.getQ3c() * 100) / totalElementos);
        }
        if (contagem.getQ3d() != null && contagem.getQ3d() != 0) {
            contagem.setQ3d((contagem.getQ3d() * 100) / totalElementos);
        }
        if (contagem.getQ3e() != null && contagem.getQ3e() != 0) {
            contagem.setQ3e((contagem.getQ3e() * 100) / totalElementos);
        }
        if (contagem.getQ3f() != null && contagem.getQ3f() != 0) {
            contagem.setQ3f((contagem.getQ3f() * 100) / totalElementos);
        }
        if (contagem.getQ3g() != null && contagem.getQ3g() != 0) {
            contagem.setQ3g((contagem.getQ3g() * 100) / totalElementos);
        }

        if (contagem.getQ6asim() != null && contagem.getQ6asim() != 0) {
            contagem.setQ6asim((contagem.getQ6asim() * 100) / totalElementos);
        }
        if (contagem.getQ6anao() != null && contagem.getQ6anao() != 0) {
            contagem.setQ6anao((contagem.getQ6anao() * 100) / totalElementos);
        }

        if (contagem.getQ6bsim() != null && contagem.getQ6bsim() != 0) {
            contagem.setQ6bsim((contagem.getQ6bsim() * 100) / totalElementos);
        }
        if (contagem.getQ6bnao() != null && contagem.getQ6bnao() != 0) {
            contagem.setQ6bnao((contagem.getQ6bnao() * 100) / totalElementos);
        }

        if (contagem.getQ6csim() != null && contagem.getQ6csim() != 0) {
            contagem.setQ6csim((contagem.getQ6csim() * 100) / totalElementos);
        }
        if (contagem.getQ6cnao() != null && contagem.getQ6cnao() != 0) {
            contagem.setQ6cnao((contagem.getQ6cnao() * 100) / totalElementos);
        }

        if (contagem.getQ6dsim() != null && contagem.getQ6dsim() != 0) {
            contagem.setQ6dsim((contagem.getQ6dsim() * 100) / totalElementos);
        }
        if (contagem.getQ6dnao() != null && contagem.getQ6dnao() != 0) {
            contagem.setQ6dnao((contagem.getQ6dnao() * 100) / totalElementos);
        }

        if (contagem.getQ6esim() != null && contagem.getQ6esim() != 0) {
            contagem.setQ6esim((contagem.getQ6esim() * 100) / totalElementos);
        }
        if (contagem.getQ6enao() != null && contagem.getQ6enao() != 0) {
            contagem.setQ6enao((contagem.getQ6enao() * 100) / totalElementos);
        }

        if (contagem.getQ6fsim() != null && contagem.getQ6fsim() != 0) {
            contagem.setQ6fsim((contagem.getQ6fsim() * 100) / totalElementos);
        }
        if (contagem.getQ6fnao() != null && contagem.getQ6fnao() != 0) {
            contagem.setQ6fnao((contagem.getQ6fnao() * 100) / totalElementos);
        }

        if (contagem.getQ6gsim() != null && contagem.getQ6gsim() != 0) {
            contagem.setQ6gsim((contagem.getQ6gsim() * 100) / totalElementos);
        }
        if (contagem.getQ6gnao() != null && contagem.getQ6gnao() != 0) {
            contagem.setQ6gnao((contagem.getQ6gnao() * 100) / totalElementos);
        }

        if (contagem.getQ7aa() != null && contagem.getQ7aa() != 0) {
            contagem.setQ7aa((contagem.getQ7aa() * 100) / totalElementos);
        }
        if (contagem.getQ7ab() != null && contagem.getQ7ab() != 0) {
            contagem.setQ7ab((contagem.getQ7ab() * 100) / totalElementos);
        }
        if (contagem.getQ7ac() != null && contagem.getQ7ac() != 0) {
            contagem.setQ7ac((contagem.getQ7ac() * 100) / totalElementos);
        }

        if (contagem.getQ7ba() != null && contagem.getQ7ba() != 0) {
            contagem.setQ7ba((contagem.getQ7ba() * 100) / totalElementos);
        }
        if (contagem.getQ7bb() != null && contagem.getQ7bb() != 0) {
            contagem.setQ7bb((contagem.getQ7bb() * 100) / totalElementos);
        }
        if (contagem.getQ7bc() != null && contagem.getQ7bc() != 0) {
            contagem.setQ7bc((contagem.getQ7bc() * 100) / totalElementos);
        }

        if (contagem.getQ7ca() != null && contagem.getQ7ca() != 0) {
            contagem.setQ7ca((contagem.getQ7ca() * 100) / totalElementos);
        }
        if (contagem.getQ7cb() != null && contagem.getQ7cb() != 0) {
            contagem.setQ7cb((contagem.getQ7cb() * 100) / totalElementos);
        }
        if (contagem.getQ7cc() != null && contagem.getQ7cc() != 0) {
            contagem.setQ7cc((contagem.getQ7cc() * 100) / totalElementos);
        }

        if (contagem.getQ9a() != null && contagem.getQ9a() != 0) {
            contagem.setQ9a((contagem.getQ9a() * 100) / totalElementos);
        }
        if (contagem.getQ9b() != null && contagem.getQ9b() != 0) {
            contagem.setQ9b((contagem.getQ9b() * 100) / totalElementos);
        }
        if (contagem.getQ9c() != null && contagem.getQ9c() != 0) {
            contagem.setQ9c((contagem.getQ9c() * 100) / totalElementos);
        }

        if (contagem.getQ11a() != null && contagem.getQ11a() != 0) {
            contagem.setQ11a((contagem.getQ11a() * 100) / totalElementos);
        }
        if (contagem.getQ11b() != null && contagem.getQ11b() != 0) {
            contagem.setQ11b((contagem.getQ11b() * 100) / totalElementos);
        }
        if (contagem.getQ11c() != null && contagem.getQ11c() != 0) {
            contagem.setQ11c((contagem.getQ11c() * 100) / totalElementos);
        }
        if (contagem.getQ11d() != null && contagem.getQ11d() != 0) {
            contagem.setQ11d((contagem.getQ11d() * 100) / totalElementos);
        }

        if (contagem.getQ12a() != null && contagem.getQ12a() != 0) {
            contagem.setQ12a((contagem.getQ12a() * 100) / totalElementos);
        }
        if (contagem.getQ12b() != null && contagem.getQ12b() != 0) {
            contagem.setQ12b((contagem.getQ12b() * 100) / totalElementos);
        }
        if (contagem.getQ12c() != null && contagem.getQ12c() != 0) {
            contagem.setQ12c((contagem.getQ12c() * 100) / totalElementos);
        }

        if (contagem.getQ14sim() != null && contagem.getQ14sim() != 0) {
            contagem.setQ14sim((contagem.getQ14sim() * 100) / totalElementos);
        }
        if (contagem.getQ14nao() != null && contagem.getQ14nao() != 0) {
            contagem.setQ14nao((contagem.getQ14nao() * 100) / totalElementos);
        }

        if (contagem.getQ15sim() != null && contagem.getQ15sim() != 0) {
            contagem.setQ15sim((contagem.getQ15sim() * 100) / totalElementos);
        }
        if (contagem.getQ15nao() != null && contagem.getQ15nao() != 0) {
            contagem.setQ15nao((contagem.getQ15nao() * 100) / totalElementos);
        }

        if (contagem.getQ16a() != null && contagem.getQ16a() != 0) {
            contagem.setQ16a((contagem.getQ16a() * 100) / totalElementos);
        }
        if (contagem.getQ16b() != null && contagem.getQ16b() != 0) {
            contagem.setQ16b((contagem.getQ16b() * 100) / totalElementos);
        }
        if (contagem.getQ16c() != null && contagem.getQ16c() != 0) {
            contagem.setQ16c((contagem.getQ16c() * 100) / totalElementos);
        }

        if (contagem.getQ17a() != null && contagem.getQ17a() != 0) {
            contagem.setQ17a((contagem.getQ17a() * 100) / totalElementos);
        }
        if (contagem.getQ17b() != null && contagem.getQ17b() != 0) {
            contagem.setQ17b((contagem.getQ17b() * 100) / totalElementos);
        }
        if (contagem.getQ17c() != null && contagem.getQ17c() != 0) {
            contagem.setQ17c((contagem.getQ17c() * 100) / totalElementos);
        }

        if (contagem.getQ18a() != null && contagem.getQ18a() != 0) {
            contagem.setQ18a((contagem.getQ18a() * 100) / totalElementos);
        }
        if (contagem.getQ18b() != null && contagem.getQ18b() != 0) {
            contagem.setQ18b((contagem.getQ18b() * 100) / totalElementos);
        }
        if (contagem.getQ18c() != null && contagem.getQ18c() != 0) {
            contagem.setQ18c((contagem.getQ18c() * 100) / totalElementos);
        }

        if (contagem.getQ19a() != null && contagem.getQ19a() != 0) {
            contagem.setQ19a((contagem.getQ19a() * 100) / totalElementos);
        }
        if (contagem.getQ19b() != null && contagem.getQ19b() != 0) {
            contagem.setQ19b((contagem.getQ19b() * 100) / totalElementos);
        }
        if (contagem.getQ19c() != null && contagem.getQ19c() != 0) {
            contagem.setQ19c((contagem.getQ19c() * 100) / totalElementos);
        }

        if (contagem.getQ20a() != null && contagem.getQ20a() != 0) {
            contagem.setQ20a((contagem.getQ20a() * 100) / totalElementos);
        }
        if (contagem.getQ20b() != null && contagem.getQ20b() != 0) {
            contagem.setQ20b((contagem.getQ20b() * 100) / totalElementos);
        }
        if (contagem.getQ20c() != null && contagem.getQ20c() != 0) {
            contagem.setQ20c((contagem.getQ20c() * 100) / totalElementos);
        }

        if (contagem.getQ21a() != null && contagem.getQ21a() != 0) {
            contagem.setQ21a((contagem.getQ21a() * 100) / totalElementos);
        }
        if (contagem.getQ21b() != null && contagem.getQ21b() != 0) {
            contagem.setQ21b((contagem.getQ21b() * 100) / totalElementos);
        }
        if (contagem.getQ21c() != null && contagem.getQ21c() != 0) {
            contagem.setQ21c((contagem.getQ21c() * 100) / totalElementos);
        }

        if (contagem.getQ22a() != null && contagem.getQ22a() != 0) {
            contagem.setQ22a((contagem.getQ22a() * 100) / totalElementos);
        }
        if (contagem.getQ22b() != null && contagem.getQ22b() != 0) {
            contagem.setQ22b((contagem.getQ22b() * 100) / totalElementos);
        }
        if (contagem.getQ22c() != null && contagem.getQ22c() != 0) {
            contagem.setQ22c((contagem.getQ22c() * 100) / totalElementos);
        }

        if (contagem.getQ23a() != null && contagem.getQ23a() != 0) {
            contagem.setQ23a((contagem.getQ23a() * 100) / totalElementos);
        }
        if (contagem.getQ23b() != null && contagem.getQ23b() != 0) {
            contagem.setQ23b((contagem.getQ23b() * 100) / totalElementos);
        }
        if (contagem.getQ23c() != null && contagem.getQ23c() != 0) {
            contagem.setQ23c((contagem.getQ23c() * 100) / totalElementos);
        }

        if (contagem.getQ24a() != null && contagem.getQ24a() != 0) {
            contagem.setQ24a((contagem.getQ24a() * 100) / totalElementos);
        }
        if (contagem.getQ24b() != null && contagem.getQ24b() != 0) {
            contagem.setQ24b((contagem.getQ24b() * 100) / totalElementos);
        }
        if (contagem.getQ24c() != null && contagem.getQ24c() != 0) {
            contagem.setQ24c((contagem.getQ24c() * 100) / totalElementos);
        }

        if (contagem.getQ25a() != null && contagem.getQ25a() != 0) {
            contagem.setQ25a((contagem.getQ25a() * 100) / totalElementos);
        }
        if (contagem.getQ25b() != null && contagem.getQ25b() != 0) {
            contagem.setQ25b((contagem.getQ25b() * 100) / totalElementos);
        }
        if (contagem.getQ25c() != null && contagem.getQ25c() != 0) {
            contagem.setQ25c((contagem.getQ25c() * 100) / totalElementos);
        }

        if (contagem.getQ26a() != null && contagem.getQ26a() != 0) {
            contagem.setQ26a((contagem.getQ26a() * 100) / totalElementos);
        }
        if (contagem.getQ26b() != null && contagem.getQ26b() != 0) {
            contagem.setQ26b((contagem.getQ26b() * 100) / totalElementos);
        }
        if (contagem.getQ26c() != null && contagem.getQ26c() != 0) {
            contagem.setQ26c((contagem.getQ26c() * 100) / totalElementos);
        }

        if (contagem.getQ27a() != null && contagem.getQ27a() != 0) {
            contagem.setQ27a((contagem.getQ27a() * 100) / totalElementos);
        }
        if (contagem.getQ27b() != null && contagem.getQ27b() != 0) {
            contagem.setQ27b((contagem.getQ27b() * 100) / totalElementos);
        }
        if (contagem.getQ27c() != null && contagem.getQ27c() != 0) {
            contagem.setQ27c((contagem.getQ27c() * 100) / totalElementos);
        }

        Locale locale = new Locale("pt", "BR");
        GregorianCalendar calendar = new GregorianCalendar();
        SimpleDateFormat formatador = new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy' - 'HH':'mm'h'", locale);
        contagem.setDataatual(formatador.format(calendar.getTime()));
        System.out.println(formatador.format(calendar.getTime()));
        return contagem;
    }
}
