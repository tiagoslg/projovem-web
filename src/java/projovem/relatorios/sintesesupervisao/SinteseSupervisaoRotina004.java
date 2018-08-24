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
import projovem.relatorios.sintesesupervisao.vo.Rotina004V2SinteseSupervisaoVo;
import projovem.rotinas.R004.Rotina004V2;

/**
 *
 * @author admprojovem
 */
public class SinteseSupervisaoRotina004 implements Serializable {

    private NucleoDAO nucleoDao = new NucleoDAO();
    private Rotina004V2SinteseSupervisaoVo contagem = new Rotina004V2SinteseSupervisaoVo();

    public Rotina004V2SinteseSupervisaoVo gerarRelatorio(String coordenacaoEscolhida, String entradaEscolhida, String observacaoEscolhida, String municipioEscolhida, EntityManagerFactory emf) {

        List<Rotina004V2> listaRotina004 = nucleoDao.obtemNucleosByCoordenacaoAndEntradaAndRotina004V2(coordenacaoEscolhida, entradaEscolhida, observacaoEscolhida, municipioEscolhida, emf);
        contagem.setListaRotina004(listaRotina004);


        for (Rotina004V2 rotina : listaRotina004) {

            Integer totalDeAlunos = 0;
            Integer totalDeSalasComAlunos = 0;


            if (rotina.getQ21() != null && !rotina.getQ21().isEmpty() && Integer.parseInt(rotina.getQ21()) > 0) {
                totalDeSalasComAlunos++;
                totalDeAlunos += Integer.parseInt(rotina.getQ21());
            }
            if (rotina.getQ27() != null && !rotina.getQ27().isEmpty() && Integer.parseInt(rotina.getQ27()) > 0) {
                totalDeSalasComAlunos++;
                totalDeAlunos += Integer.parseInt(rotina.getQ27());
            }
            if (rotina.getQ33() != null && !rotina.getQ33().isEmpty() && Integer.parseInt(rotina.getQ33()) > 0) {
                totalDeSalasComAlunos++;
                totalDeAlunos += Integer.parseInt(rotina.getQ33());
            }
            if (rotina.getQ39() != null && !rotina.getQ39().isEmpty() && Integer.parseInt(rotina.getQ39()) > 0) {
                totalDeSalasComAlunos++;
                totalDeAlunos += Integer.parseInt(rotina.getQ39());
            }
            if (rotina.getQ45() != null && !rotina.getQ45().isEmpty() && Integer.parseInt(rotina.getQ45()) > 0) {
                totalDeSalasComAlunos++;
                totalDeAlunos += Integer.parseInt(rotina.getQ45());
            }




            if (rotina.getQ2() != null && rotina.getQ2().equals("sim")) {
                contagem.setQ2sim(contagem.getQ2sim() + 1);
            }
            if (rotina.getQ2() != null && rotina.getQ2().equals("nao")) {
                contagem.setQ2nao(contagem.getQ2nao() + 1);
            }

            if (rotina.getQ3() != null && rotina.getQ3().equals("sim")) {
                contagem.setQ3sim(contagem.getQ3sim() + 1);
            }
            if (rotina.getQ3() != null && rotina.getQ3().equals("nao")) {
                contagem.setQ3nao(contagem.getQ3nao() + 1);
                contagem.setNegativo(contagem.getNegativo() + 1);
            }

            Integer horaInicial = 0;
            if (rotina.getQ4a() != null && !rotina.getQ4a().isEmpty()) {
                horaInicial = Integer.parseInt(rotina.getQ4a().substring(0, 2));
            }


            Integer horaFinal = 0;
            if (rotina.getQ4b() != null && !rotina.getQ4b().isEmpty()) {
                horaFinal = Integer.parseInt(rotina.getQ4b().substring(0, 2));
            }

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

            Integer totalBebedouros = 1;
            if (rotina.getQ5() != null && rotina.getQ5().equals("1")) {
                totalBebedouros = 1;
            }
            if (rotina.getQ5() != null && rotina.getQ5().equals("2")) {
                totalBebedouros = 2;
            }
            if (rotina.getQ5() != null && rotina.getQ5().equals("3")) {
                totalBebedouros = 3;
            }
            if (rotina.getQ5() != null && rotina.getQ5().equals("4")) {
                totalBebedouros = 4;
            }
            if (rotina.getQ5() != null && rotina.getQ5().equals("5ouMais")) {
                totalBebedouros = 5;
            }

            Integer alunosPorBebedouro = totalDeAlunos / totalBebedouros;

            if (alunosPorBebedouro < 50) {
                contagem.setQ5sim(contagem.getQ5sim() + 1);
            } else {
                contagem.setQ5nao(contagem.getQ5nao() + 1);
                contagem.setNegativo(contagem.getNegativo() + 1);
            }

            Integer totalBanheiros = 1;
            if (rotina.getQ17() != null && rotina.getQ17().equals("1")) {
                totalBanheiros = 1;
            }
            if (rotina.getQ17() != null && rotina.getQ17().equals("2")) {
                totalBanheiros = 2;
            }
            if (rotina.getQ17() != null && rotina.getQ17().equals("3")) {
                totalBanheiros = 3;
            }
            if (rotina.getQ17() != null && rotina.getQ17().equals("4")) {
                totalBanheiros = 4;
            }
            if (rotina.getQ17() != null && rotina.getQ17().equals("5ouMais")) {
                totalBanheiros = 5;
            }

            Integer alunosPorBanheiro = totalDeAlunos / totalBanheiros;

            if (alunosPorBanheiro > 50) {
                contagem.setQ17nao(contagem.getQ17nao() + 1);
                contagem.setNegativo(contagem.getNegativo() + 1);
            } else {
                contagem.setQ17sim(contagem.getQ17sim() + 1);
            }

            if (rotina.getQ6() != null && rotina.getQ6().equals("sim")) {
                contagem.setQ6a(contagem.getQ6a() + 1);
                contagem.setPositivo(contagem.getPositivo() + 1);
            }
            if (rotina.getQ6() != null && rotina.getQ6().equals("nao")) {
                contagem.setQ6b(contagem.getQ6b() + 1);
            }
            if (rotina.getQ6() != null && rotina.getQ6().equals("naoBiblioteca")) {
                contagem.setQ6c(contagem.getQ6c() + 1);
            }

            if (rotina.getQ8() != null && rotina.getQ8().equals("sim")) {
                contagem.setQ8sim(contagem.getQ8sim() + 1);
            }
            if (rotina.getQ8() != null && rotina.getQ8().equals("nao")) {
                contagem.setQ8nao(contagem.getQ8nao() + 1);
                contagem.setNegativo(contagem.getNegativo() + 1);
            }

            if (rotina.getQ11() != null && rotina.getQ11().equals("sim")) {
                contagem.setQ11a(contagem.getQ11a() + 1);
            }
            if (rotina.getQ11() != null && rotina.getQ11().equals("nao")) {
                contagem.setQ11b(contagem.getQ11b() + 1);
            }

            if (rotina.getQ10() != null && rotina.getQ10().equals("sim")) {
                contagem.setQ10sim(contagem.getQ10sim() + 1);
            }

            if (rotina.getQ12() != null && rotina.getQ12().equals("sim")) {
                contagem.setQ12sim(contagem.getQ12sim() + 1);
            }
            if (rotina.getQ12() != null && rotina.getQ12().equals("nao")) {
                contagem.setQ12nao(contagem.getQ12nao() + 1);
                contagem.setNegativo(contagem.getNegativo() + 1);
            }

            if (rotina.getQ13() != null && rotina.getQ13().equals("sim")) {
                contagem.setQ13sim(contagem.getQ13sim() + 1);
            }
            if (rotina.getQ13() != null && rotina.getQ13().equals("nao")) {
                contagem.setQ13nao(contagem.getQ13nao() + 1);
                contagem.setNegativo(contagem.getNegativo() + 1);
            }

            if (rotina.getQ14() != null && rotina.getQ14().equals("sim")) {
                contagem.setQ14sim(contagem.getQ14sim() + 1);
                contagem.setPositivo(contagem.getPositivo() + 1);
            }
            if (rotina.getQ14() != null && rotina.getQ14().equals("nao")) {
                contagem.setQ14nao(contagem.getQ14nao() + 1);
            }

            if (rotina.getQ15() != null && rotina.getQ15().equals("sim")) {
                contagem.setQ15sim(contagem.getQ15sim() + 1);
            }
            if (rotina.getQ15() != null && rotina.getQ15().equals("nao")) {
                contagem.setQ15nao(contagem.getQ15nao() + 1);
            }

            if (rotina.getQ16() != null && rotina.getQ16().equals("sim")) {
                contagem.setQ16sim(contagem.getQ16sim() + 1);
            }
            if (rotina.getQ16() != null && rotina.getQ16().equals("nao")) {
                contagem.setQ16nao(contagem.getQ16nao() + 1);
            }


            if (rotina.getQ18() != null && rotina.getQ18().equals("sim")) {
                contagem.setQ18sim(contagem.getQ18sim() + 1);
            }
            if (rotina.getQ18() != null && rotina.getQ18().equals("nao")) {
                contagem.setQ18nao(contagem.getQ18nao() + 1);
                contagem.setNegativo(contagem.getNegativo() + 1);
            }


            Integer mediaDeAlunosPorSala = 0;
            if (totalDeSalasComAlunos > 0) {
                mediaDeAlunosPorSala = totalDeAlunos / totalDeSalasComAlunos;
            }


            if (mediaDeAlunosPorSala >= 25) {
                contagem.setQ19a(contagem.getQ19a() + 1);
            }
            if (mediaDeAlunosPorSala >= 10 && mediaDeAlunosPorSala < 25) {
                contagem.setQ19b(contagem.getQ19b() + 1);
                contagem.setNegativo(contagem.getNegativo() + 1);
            }
            if (mediaDeAlunosPorSala < 10) {
                contagem.setQ19c(contagem.getQ19c() + 1);
                contagem.setNegativo(contagem.getNegativo() + 1);
            }


            Integer totalDeSalasComAlunosSemCarteira = 0;
            if (rotina.getQ22() != null && !rotina.getQ22().isEmpty() && Integer.parseInt(rotina.getQ22()) > 0) {
                totalDeSalasComAlunosSemCarteira++;
            }
            if (rotina.getQ28() != null && !rotina.getQ28().isEmpty() && Integer.parseInt(rotina.getQ28()) > 0) {
                totalDeSalasComAlunosSemCarteira++;
            }
            if (rotina.getQ34() != null && !rotina.getQ34().isEmpty() && Integer.parseInt(rotina.getQ34()) > 0) {
                totalDeSalasComAlunosSemCarteira++;
            }
            if (rotina.getQ40() != null && !rotina.getQ40().isEmpty() && Integer.parseInt(rotina.getQ40()) > 0) {
                totalDeSalasComAlunosSemCarteira++;
            }
            if (rotina.getQ46() != null && !rotina.getQ46().isEmpty() && Integer.parseInt(rotina.getQ46()) > 0) {
                totalDeSalasComAlunosSemCarteira++;
            }

            if (totalDeSalasComAlunosSemCarteira > 0) {
                contagem.setQ20nao(contagem.getQ20nao() + 1);
                contagem.setNegativo(contagem.getNegativo() + 1);
            } else {
                contagem.setQ20sim(contagem.getQ20sim() + 1);
            }

            Integer totalDeSalasComCarteiraInadequada = 0;
            if (rotina.getQ23() != null && !rotina.getQ23().isEmpty() && rotina.getQ23().equals("sim")) {
                totalDeSalasComCarteiraInadequada++;
            }
            if (rotina.getQ29() != null && !rotina.getQ29().isEmpty() && rotina.getQ29().equals("sim")) {
                totalDeSalasComCarteiraInadequada++;
            }
            if (rotina.getQ35() != null && !rotina.getQ35().isEmpty() && rotina.getQ35().equals("sim")) {
                totalDeSalasComCarteiraInadequada++;
            }
            if (rotina.getQ41() != null && !rotina.getQ41().isEmpty() && rotina.getQ41().equals("sim")) {
                totalDeSalasComCarteiraInadequada++;
            }
            if (rotina.getQ47() != null && !rotina.getQ47().isEmpty() && rotina.getQ47().equals("sim")) {
                totalDeSalasComCarteiraInadequada++;
            }

            if (totalDeSalasComCarteiraInadequada > 0) {
                contagem.setQ21sim(contagem.getQ21sim() + 1);
            } else {
                contagem.setQ21nao(contagem.getQ21nao() + 1);
                contagem.setNegativo(contagem.getNegativo() + 1);
            }

            Integer totalDeSalasComCadeiraParaEducador = 0;
            if (rotina.getQ24() != null && !rotina.getQ24().isEmpty() && rotina.getQ24().equals("sim")) {
                totalDeSalasComCadeiraParaEducador++;
            }
            if (rotina.getQ30() != null && !rotina.getQ30().isEmpty() && rotina.getQ30().equals("sim")) {
                totalDeSalasComCadeiraParaEducador++;
            }
            if (rotina.getQ36() != null && !rotina.getQ36().isEmpty() && rotina.getQ36().equals("sim")) {
                totalDeSalasComCadeiraParaEducador++;
            }
            if (rotina.getQ42() != null && !rotina.getQ42().isEmpty() && rotina.getQ42().equals("sim")) {
                totalDeSalasComCadeiraParaEducador++;
            }
            if (rotina.getQ48() != null && !rotina.getQ48().isEmpty() && rotina.getQ48().equals("sim")) {
                totalDeSalasComCadeiraParaEducador++;
            }

            if (totalDeSalasComCadeiraParaEducador > 0) {
                contagem.setQ22sim(contagem.getQ22sim() + 1);
            } else {
                contagem.setQ22nao(contagem.getQ22nao() + 1);
                contagem.setNegativo(contagem.getNegativo() + 1);
            }

            Integer totalDeSalasComMesaParaEducador = 0;
            if (rotina.getQ25() != null && !rotina.getQ25().isEmpty() && rotina.getQ25().equals("sim")) {
                totalDeSalasComMesaParaEducador++;
            }
            if (rotina.getQ31() != null && !rotina.getQ31().isEmpty() && rotina.getQ31().equals("sim")) {
                totalDeSalasComMesaParaEducador++;
            }
            if (rotina.getQ37() != null && !rotina.getQ37().isEmpty() && rotina.getQ37().equals("sim")) {
                totalDeSalasComMesaParaEducador++;
            }
            if (rotina.getQ43() != null && !rotina.getQ43().isEmpty() && rotina.getQ43().equals("sim")) {
                totalDeSalasComMesaParaEducador++;
            }
            if (rotina.getQ49() != null && !rotina.getQ49().isEmpty() && rotina.getQ49().equals("sim")) {
                totalDeSalasComMesaParaEducador++;
            }

            if (totalDeSalasComMesaParaEducador > 0) {
                contagem.setQ23sim(contagem.getQ23sim() + 1);
            } else {
                contagem.setQ23nao(contagem.getQ23nao() + 1);
                contagem.setNegativo(contagem.getNegativo() + 1);
            }

            Integer totalDeSalasComQuadro = 0;
            Integer totalDeSalasComQuadroPrecario = 0;
            Integer totalDeSalasSemQuadro = 0;
            if (rotina.getQ26() != null && !rotina.getQ26().isEmpty()) {
                if (rotina.getQ26().equals("simEmCondicoesDeUso")) {
                    totalDeSalasComQuadro++;
                }
                if (rotina.getQ26().equals("simEmCondicoesPrecarias")) {
                    totalDeSalasComQuadroPrecario++;
                }
                if (rotina.getQ26().equals("nao")) {
                    totalDeSalasSemQuadro++;
                }
            }
            if (rotina.getQ32() != null && !rotina.getQ32().isEmpty()) {
                if (rotina.getQ32().equals("simEmCondicoesDeUso")) {
                    totalDeSalasComQuadro++;
                }
                if (rotina.getQ32().equals("simEmCondicoesPrecarias")) {
                    totalDeSalasComQuadroPrecario++;
                }
                if (rotina.getQ32().equals("nao")) {
                    totalDeSalasSemQuadro++;
                }
            }
            if (rotina.getQ38() != null && !rotina.getQ38().isEmpty()) {
                if (rotina.getQ38().equals("simEmCondicoesDeUso")) {
                    totalDeSalasComQuadro++;
                }
                if (rotina.getQ38().equals("simEmCondicoesPrecarias")) {
                    totalDeSalasComQuadroPrecario++;
                }
                if (rotina.getQ38().equals("nao")) {
                    totalDeSalasSemQuadro++;
                }
            }
            if (rotina.getQ44() != null && !rotina.getQ44().isEmpty()) {
                if (rotina.getQ44().equals("simEmCondicoesDeUso")) {
                    totalDeSalasComQuadro++;
                }
                if (rotina.getQ44().equals("simEmCondicoesPrecarias")) {
                    totalDeSalasComQuadroPrecario++;
                }
                if (rotina.getQ44().equals("nao")) {
                    totalDeSalasSemQuadro++;
                }
            }
            if (rotina.getQ50() != null && !rotina.getQ50().isEmpty()) {
                if (rotina.getQ50().equals("simEmCondicoesDeUso")) {
                    totalDeSalasComQuadro++;
                }
                if (rotina.getQ50().equals("simEmCondicoesPrecarias")) {
                    totalDeSalasComQuadroPrecario++;
                }
                if (rotina.getQ50().equals("nao")) {
                    totalDeSalasSemQuadro++;
                }
            }


            if (totalDeSalasSemQuadro > 0) {
                contagem.setQ25c(contagem.getQ25c() + 1);
                contagem.setNegativo(contagem.getNegativo() + 1);
            } else {
                if (totalDeSalasComQuadroPrecario > 0) {
                    contagem.setQ25b(contagem.getQ25b() + 1);
                    contagem.setNegativo(contagem.getNegativo() + 1);
                } else {
                    if (totalDeSalasComQuadro > 0) {
                        contagem.setQ25a(contagem.getQ25a() + 1);
                    }
                }
            }

            /*

             * OLhar com Juliana
            ve[Q_quadro_ensino][Q_quadro_ensino_1] = 'Em XXX dos n&uacute;cleos observados a sala de aula possui quadro para o ensino em condi&ccedil;&otilde;es de uso.';	$matriz_chave[Q_quadro_ensino][Q_quadro_ensino_1_PESO] = '0';	$matriz_chave[Q_quadro_ensino][Q_quadro_ensino_1_STATUS] = 'NEUTRO';
            $matriz_chave[Q_quadro_ensino][Q_quadro_ensino_2] = 'Em XXX dos n&uacute;cleos observados a sala de aula possui quadro para o ensino em condi&ccedil;&otilde;es prec&aacute;rias de uso.';	$matriz_chave[Q_quadro_ensino][Q_quadro_ensino_2_PESO] = '-1';	$matriz_chave[Q_quadro_ensino][Q_quadro_ensino_2_STATUS] = 'NEGATIVO';
            $matriz_chave[Q_quadro_ensino][Q_quadro_ensino_3] = 'Em XXX dos n&uacute;cleos observados a sala de aula n&atilde;o possui quadro para o ensino.';	$matriz_chave[Q_quadro_ensino][Q_quadro_ensino_3_PESO] = '-2';	$matriz_chave[Q_quadro_ensino][Q_quadro_ensino_3_STATUS] = 'NEGATIVO';

             */






            if (rotina.getQ51() != null && rotina.getQ51().equals("sim")) {
                contagem.setQ24aA(contagem.getQ24aA() + 1);
            }
            if (rotina.getQ51() != null && rotina.getQ51().equals("naoEducadorContratado")) {
                contagem.setQ24aB(contagem.getQ24aB() + 1);
            }
            if (rotina.getQ51() != null && rotina.getQ51().equals("naoEducadorNaoContratado")) {
                contagem.setQ24aC(contagem.getQ24aC() + 1);
                contagem.setNegativo(contagem.getNegativo() + 1);
            }

            if (rotina.getQ52() != null && rotina.getQ52().equals("sim")) {
                contagem.setQ24bA(contagem.getQ24bA() + 1);
            }
            if (rotina.getQ52() != null && rotina.getQ52().equals("naoEducadorContratado")) {
                contagem.setQ24bB(contagem.getQ24bB() + 1);
            }
            if (rotina.getQ52() != null && rotina.getQ52().equals("naoEducadorNaoContratado")) {
                contagem.setQ24bC(contagem.getQ24bC() + 1);
                contagem.setNegativo(contagem.getNegativo() + 1);
            }

            if (rotina.getQ53() != null && rotina.getQ53().equals("sim")) {
                contagem.setQ24cA(contagem.getQ24cA() + 1);
            }
            if (rotina.getQ53() != null && rotina.getQ53().equals("naoEducadorContratado")) {
                contagem.setQ24cB(contagem.getQ24cB() + 1);
            }
            if (rotina.getQ53() != null && rotina.getQ53().equals("naoEducadorNaoContratado")) {
                contagem.setQ24cC(contagem.getQ24cC() + 1);
                contagem.setNegativo(contagem.getNegativo() + 1);
            }

            if (rotina.getQ54() != null && rotina.getQ54().equals("sim")) {
                contagem.setQ24dA(contagem.getQ24dA() + 1);
            }
            if (rotina.getQ54() != null && rotina.getQ54().equals("naoEducadorContratado")) {
                contagem.setQ24dB(contagem.getQ24dB() + 1);
            }
            if (rotina.getQ54() != null && rotina.getQ54().equals("naoEducadorNaoContratado")) {
                contagem.setQ24dC(contagem.getQ24dC() + 1);
                contagem.setNegativo(contagem.getNegativo() + 1);
            }

            if (rotina.getQ55() != null && rotina.getQ55().equals("sim")) {
                contagem.setQ24eA(contagem.getQ24eA() + 1);
            }
            if (rotina.getQ55() != null && rotina.getQ55().equals("naoEducadorContratado")) {
                contagem.setQ24eB(contagem.getQ24eB() + 1);
            }
            if (rotina.getQ55() != null && rotina.getQ55().equals("naoEducadorNaoContratado")) {
                contagem.setQ24eC(contagem.getQ24eC() + 1);
                contagem.setNegativo(contagem.getNegativo() + 1);
            }

            if (rotina.getQ56() != null && rotina.getQ56().equals("sim")) {
                contagem.setQ24fA(contagem.getQ24fA() + 1);
            }
            if (rotina.getQ56() != null && rotina.getQ56().equals("naoEducadorContratado")) {
                contagem.setQ24fB(contagem.getQ24fB() + 1);
            }
            if (rotina.getQ56() != null && rotina.getQ56().equals("naoEducadorNaoContratado")) {
                contagem.setQ24fC(contagem.getQ24fC() + 1);
                contagem.setNegativo(contagem.getNegativo() + 1);
            }

            if (rotina.getQ57() != null && rotina.getQ57().equals("sim")) {
                contagem.setQ24gA(contagem.getQ24gA() + 1);
            }
            if (rotina.getQ57() != null && rotina.getQ57().equals("naoEducadorContratado")) {
                contagem.setQ24gB(contagem.getQ24gB() + 1);
            }
            if (rotina.getQ57() != null && rotina.getQ57().equals("naoEducadorNaoContratado")) {
                contagem.setQ24gC(contagem.getQ24gC() + 1);
                contagem.setNegativo(contagem.getNegativo() + 1);
            }

            if (rotina.getQ58() != null && rotina.getQ58().equals("sim")) {
                contagem.setQ58sim(contagem.getQ58sim() + 1);
            }
            if (rotina.getQ58() != null && rotina.getQ58().equals("nao")) {
                contagem.setQ58nao(contagem.getQ58nao() + 1);
                contagem.setNegativo(contagem.getNegativo() + 1);
            }

            if (rotina.getQ59() != null && rotina.getQ59().equals("sim")) {
                contagem.setQ59sim(contagem.getQ59sim() + 1);
            }
            if (rotina.getQ59() != null && rotina.getQ59().equals("nao")) {
                contagem.setQ59nao(contagem.getQ59nao() + 1);
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
