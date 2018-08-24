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
import projovem.rotinas.R005.Rotina005;
import projovem.relatorios.sintesesupervisao.vo.Rotina005SinteseSupervisaoVo;

/**
 *
 * @author admprojovem
 */
public class SinteseSupervisaoRotina005 implements Serializable {

    private NucleoDAO nucleoDao = new NucleoDAO();
    private Rotina005SinteseSupervisaoVo contagem = new Rotina005SinteseSupervisaoVo();

    public Rotina005SinteseSupervisaoVo gerarRelatorio(String coordenacaoEscolhida, String entradaEscolhida, String observacaoEscolhida, String municipioEscolhida, EntityManagerFactory emf) {

        List<Rotina005> listaRotina005 = nucleoDao.obtemNucleosByCoordenacaoAndEntradaAndRotina005(coordenacaoEscolhida, entradaEscolhida, observacaoEscolhida, municipioEscolhida, emf);
        contagem.setListaRotina005(listaRotina005);


        for (Rotina005 rotina : listaRotina005) {
            if (rotina.getQ2().equals("sim")) {
                contagem.setQ2sim(contagem.getQ2sim() + 1);
            }
            if (rotina.getQ2().equals("nao")) {
                contagem.setQ2nao(contagem.getQ2nao() + 1);
            }

            if (rotina.getQ3().equals("sim")) {
                contagem.setQ3sim(contagem.getQ3sim() + 1);
            }
            if (rotina.getQ3().equals("nao")) {
                contagem.setQ3nao(contagem.getQ3nao() + 1);
                contagem.setNegativo(contagem.getNegativo() + 1);
            }

            Integer horaInicial = Integer.parseInt(rotina.getQ4a().substring(0, 2));
            Integer horaFinal = Integer.parseInt(rotina.getQ4b().substring(0, 2));

            if (horaFinal - horaInicial >= 4) {
                contagem.setQ4a(contagem.getQ4a() + 1);
            }
            if (horaFinal - horaInicial >= 3 && horaFinal - horaInicial < 4) {
                contagem.setQ4b(contagem.getQ4b() + 1);
                contagem.setNegativo(contagem.getNegativo() + 1);
            }
            if (horaFinal - horaInicial < 3) {
                contagem.setQ4c(contagem.getQ4c() + 1);
                contagem.setNegativo(contagem.getNegativo() + 1);
            }


            Integer totalAlunosNasSalas = 0;
            Integer totalDeSalasComAlunos = 0;

            if (rotina.getQ6a() != null && !rotina.getQ6a().isEmpty() && Integer.parseInt(rotina.getQ6a()) > 0) {
                totalDeSalasComAlunos++;
                totalAlunosNasSalas += Integer.parseInt(rotina.getQ6a());
            }
            if (rotina.getQ6b() != null && !rotina.getQ6b().isEmpty() && Integer.parseInt(rotina.getQ6b()) > 0) {
                totalDeSalasComAlunos++;
                totalAlunosNasSalas += Integer.parseInt(rotina.getQ6b());
            }
            if (rotina.getQ6c() != null && !rotina.getQ6c().isEmpty() && Integer.parseInt(rotina.getQ6c()) > 0) {
                totalDeSalasComAlunos++;
                totalAlunosNasSalas += Integer.parseInt(rotina.getQ6c());
            }
            if (rotina.getQ6d() != null && !rotina.getQ6d().isEmpty() && Integer.parseInt(rotina.getQ6d()) > 0) {
                totalDeSalasComAlunos++;
                totalAlunosNasSalas += Integer.parseInt(rotina.getQ6d());
            }
            if (rotina.getQ6e() != null && !rotina.getQ6e().isEmpty() && Integer.parseInt(rotina.getQ6e()) > 0) {
                totalDeSalasComAlunos++;
                totalAlunosNasSalas += Integer.parseInt(rotina.getQ6e());
            }

            Integer mediaDeAlunosPorSala = totalAlunosNasSalas / totalDeSalasComAlunos;

            if (mediaDeAlunosPorSala >= 25) {
                contagem.setQ6a(contagem.getQ6a() + 1);
            }
            if (mediaDeAlunosPorSala >= 10 && mediaDeAlunosPorSala < 25) {
                contagem.setQ6b(contagem.getQ6b() + 1);
                contagem.setNegativo(contagem.getNegativo() + 1);
            }
            if (mediaDeAlunosPorSala < 10) {
                contagem.setQ6c(contagem.getQ6c() + 1);
                contagem.setNegativo(contagem.getNegativo() + 1);
            }

            if (rotina.getQ7().equals("sim")) {
                contagem.setQ7sim(contagem.getQ7sim() + 1);
                contagem.setPositivo(contagem.getPositivo() + 1);
            }
            if (rotina.getQ7().equals("nao")) {
                contagem.setQ7nao(contagem.getQ7nao() + 1);
            }

            if (rotina.getQ8a() != null && rotina.getQ8a().equals("sim")) {
                contagem.setQ8aA(contagem.getQ8aA() + 1);
            }
            if (rotina.getQ8a() != null && rotina.getQ8a().equals("naoEducadorContratado")) {
                contagem.setQ8aB(contagem.getQ8aB() + 1);
            }
            if (rotina.getQ8a() != null && rotina.getQ8a().equals("naoEducadorNaoContratado")) {
                contagem.setQ8aC(contagem.getQ8aC() + 1);
                contagem.setNegativo(contagem.getNegativo() + 1);
            }

            if (rotina.getQ8b() != null && rotina.getQ8b().equals("sim")) {
                contagem.setQ8bA(contagem.getQ8bA() + 1);
            }
            if (rotina.getQ8b() != null && rotina.getQ8b().equals("naoEducadorContratado")) {
                contagem.setQ8bB(contagem.getQ8bB() + 1);
            }
            if (rotina.getQ8b() != null && rotina.getQ8b().equals("naoEducadorNaoContratado")) {
                contagem.setQ8bC(contagem.getQ8bC() + 1);
                contagem.setNegativo(contagem.getNegativo() + 1);
            }

            if (rotina.getQ8c() != null && rotina.getQ8c().equals("sim")) {
                contagem.setQ8cA(contagem.getQ8cA() + 1);
            }
            if (rotina.getQ8c() != null && rotina.getQ8c().equals("naoEducadorContratado")) {
                contagem.setQ8cB(contagem.getQ8cB() + 1);
            }
            if (rotina.getQ8c() != null && rotina.getQ8c().equals("naoEducadorNaoContratado")) {
                contagem.setQ8cC(contagem.getQ8cC() + 1);
                contagem.setNegativo(contagem.getNegativo() + 1);
            }

            if (rotina.getQ8d() != null && rotina.getQ8d().equals("sim")) {
                contagem.setQ8dA(contagem.getQ8dA() + 1);
            }
            if (rotina.getQ8d() != null && rotina.getQ8d().equals("naoEducadorContratado")) {
                contagem.setQ8dB(contagem.getQ8dB() + 1);
            }
            if (rotina.getQ8d() != null && rotina.getQ8d().equals("naoEducadorNaoContratado")) {
                contagem.setQ8dC(contagem.getQ8dC() + 1);
                contagem.setNegativo(contagem.getNegativo() + 1);
            }

            if (rotina.getQ8e() != null && rotina.getQ8e().equals("sim")) {
                contagem.setQ8eA(contagem.getQ8eA() + 1);
            }
            if (rotina.getQ8e() != null && rotina.getQ8e().equals("naoEducadorContratado")) {
                contagem.setQ8eB(contagem.getQ8eB() + 1);
            }
            if (rotina.getQ8e() != null && rotina.getQ8e().equals("naoEducadorNaoContratado")) {
                contagem.setQ8eC(contagem.getQ8eC() + 1);
                contagem.setNegativo(contagem.getNegativo() + 1);
            }

            if (rotina.getQ8f() != null && rotina.getQ8f().equals("sim")) {
                contagem.setQ8fA(contagem.getQ8fA() + 1);
            }
            if (rotina.getQ8f() != null && rotina.getQ8f().equals("naoEducadorContratado")) {
                contagem.setQ8fB(contagem.getQ8fB() + 1);
            }
            if (rotina.getQ8f() != null && rotina.getQ8f().equals("naoEducadorNaoContratado")) {
                contagem.setQ8fC(contagem.getQ8fC() + 1);
                contagem.setNegativo(contagem.getNegativo() + 1);
            }

            if (rotina.getQ8g() != null && rotina.getQ8g().equals("sim")) {
                contagem.setQ8gA(contagem.getQ8gA() + 1);
            }
            if (rotina.getQ8g() != null && rotina.getQ8g().equals("naoEducadorContratado")) {
                contagem.setQ8gB(contagem.getQ8gB() + 1);
            }
            if (rotina.getQ8g() != null && rotina.getQ8g().equals("naoEducadorNaoContratado")) {
                contagem.setQ8gC(contagem.getQ8gC() + 1);
                contagem.setNegativo(contagem.getNegativo() + 1);
            }

            if (rotina.getQ9().equals("sim")) {
                contagem.setQ9sim(contagem.getQ9sim() + 1);
            }
            if (rotina.getQ9().equals("nao")) {
                contagem.setQ9nao(contagem.getQ9nao() + 1);
                contagem.setNegativo(contagem.getNegativo() + 1);
            }
        }
        Locale locale = new Locale("pt", "BR");
        GregorianCalendar calendar = new GregorianCalendar();
        SimpleDateFormat formatador = new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy' - 'HH':'mm'h'", locale);
        contagem.setDataatual(formatador.format(calendar.getTime()));
        System.out.println(formatador.format(calendar.getTime()));
        return contagem;
    }
}
