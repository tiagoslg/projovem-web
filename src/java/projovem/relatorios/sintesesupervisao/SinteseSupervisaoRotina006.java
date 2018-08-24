
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
import projovem.relatorios.sintesesupervisao.auxilio.Rotina006ContagemArcoA;
import projovem.relatorios.sintesesupervisao.auxilio.Rotina006ContagemArcoB;
import projovem.relatorios.sintesesupervisao.auxilio.Rotina006ContagemArcoC;
import projovem.relatorios.sintesesupervisao.auxilio.Rotina006ContagemArcoD;
import projovem.relatorios.sintesesupervisao.auxilio.Rotina006ContagemArcoE;
import projovem.relatorios.sintesesupervisao.vo.Rotina006SinteseSupervisaoVo;
import projovem.rotinas.R006.Rotina006ArcosOcupacionais;

/**
 *
 * @author admprojovem
 */
public class SinteseSupervisaoRotina006 implements Serializable {

    private NucleoDAO nucleoDao = new NucleoDAO();
    private Rotina006SinteseSupervisaoVo contagem = new Rotina006SinteseSupervisaoVo();

    public Rotina006SinteseSupervisaoVo gerarRelatorio(String coordenacaoEscolhida, String entradaEscolhida, String observacaoEscolhida, String municipioEscolhida, EntityManagerFactory emf) {

        List<Rotina006ArcosOcupacionais> listaRotina006 = nucleoDao.obtemNucleosByCoordenacaoAndEntradaAndRotina006(coordenacaoEscolhida, entradaEscolhida, observacaoEscolhida, municipioEscolhida, emf);
        contagem.setListaRotina006(listaRotina006);


        for (Rotina006ArcosOcupacionais rotina : listaRotina006) {


            if (rotina.getQ4() != null) {
                if (rotina.getQ4().equals("nao")) {
                    contagem.setQ4nao(contagem.getQ4nao() + 1);
                }
            }
            if (rotina.getQ5() != null) {
                if (rotina.getQ5().equals("nao")) {
                    contagem.setQ5nao(contagem.getQ5nao() + 1);
                }
            }
            if (rotina.getQ6() != null) {
                if (rotina.getQ6().equals("nao")) {
                    contagem.setQ6nao(contagem.getQ6nao() + 1);
                }
            }
            if (rotina.getQ7() != null) {
                if (rotina.getQ7().equals("nao")) {
                    contagem.setQ7nao(contagem.getQ7nao() + 1);
                }
            }
            if (rotina.getQ8() != null) {
                if (rotina.getQ8().equals("nao")) {
                    contagem.setQ8nao(contagem.getQ8nao() + 1);
                }
            }



            if (rotina.getQ14() != null) {
                if (rotina.getQ14().equals("nao")) {
                    contagem.setQ14nao(contagem.getQ14nao() + 1);
                }
            }
            if (rotina.getQ15() != null) {
                if (rotina.getQ15().equals("nao")) {
                    contagem.setQ15nao(contagem.getQ15nao() + 1);
                }
            }
            if (rotina.getQ16() != null) {
                if (rotina.getQ16().equals("nao")) {
                    contagem.setQ16nao(contagem.getQ16nao() + 1);
                }
            }
            if (rotina.getQ17() != null) {
                if (rotina.getQ17().equals("nao")) {
                    contagem.setQ17nao(contagem.getQ17nao() + 1);
                }
            }
            if (rotina.getQ18() != null) {
                if (rotina.getQ18().equals("nao")) {
                    contagem.setQ18nao(contagem.getQ18nao() + 1);
                }
            }


            if (rotina.getQ19() != null) {
                if (rotina.getQ19().equals("nao")) {
                    contagem.setQ19nao(contagem.getQ19nao() + 1);
                }
            }
            if (rotina.getQ20() != null) {
                if (rotina.getQ20().equals("nao")) {
                    contagem.setQ20nao(contagem.getQ20nao() + 1);
                }
            }
            if (rotina.getQ21() != null) {
                if (rotina.getQ21().equals("nao")) {
                    contagem.setQ21nao(contagem.getQ21nao() + 1);
                }
            }
            if (rotina.getQ22() != null) {
                if (rotina.getQ22().equals("nao")) {
                    contagem.setQ22nao(contagem.getQ22nao() + 1);
                }
            }
            if (rotina.getQ23() != null) {
                if (rotina.getQ23().equals("nao")) {
                    contagem.setQ23nao(contagem.getQ23nao() + 1);
                }
            }


            if (rotina.getQ24Educadores() != null && !rotina.getQ24Educadores().isEmpty()) {
                contagem.setNumeroEducadores(Integer.parseInt(rotina.getQ24Educadores()));
            }
            if (contagem.getNumeroEducadores().equals(0)) {
                contagem.setQ24E(1);
            }
            if (rotina.getQ24Alunos() != null && !rotina.getQ24Alunos().isEmpty()) {
                contagem.setNumeroAlunos(Integer.parseInt(rotina.getQ24Alunos()));
            }
            if (contagem.getNumeroAlunos() > 10 && contagem.getNumeroAlunos() < 25) {
                contagem.setQ24AB(1);
            } else {
                if (contagem.getNumeroAlunos() <= 10) {
                    contagem.setQ24AC(1);
                }
            }

            contagem.setNumeroEducadores(0);
            contagem.setNumeroAlunos(0);

            if (rotina.getQ25Educadores() != null && !rotina.getQ25Educadores().isEmpty()) {
                contagem.setNumeroEducadores(Integer.parseInt(rotina.getQ25Educadores()));
            }
            if (contagem.getNumeroEducadores().equals(0)) {
                contagem.setQ24E(1);
            }
            if (rotina.getQ25Alunos() != null && !rotina.getQ25Alunos().isEmpty()) {
                contagem.setNumeroAlunos(Integer.parseInt(rotina.getQ25Alunos()));
            }
            if (contagem.getNumeroAlunos() > 10 && contagem.getNumeroAlunos() < 25) {
                contagem.setQ25AB(1);
            } else {
                if (contagem.getNumeroAlunos() <= 10) {
                    contagem.setQ25AC(1);
                }
            }

            contagem.setNumeroEducadores(0);
            contagem.setNumeroAlunos(0);

            if (rotina.getQ26Educadores() != null && !rotina.getQ26Educadores().isEmpty()) {
                contagem.setNumeroEducadores(Integer.parseInt(rotina.getQ26Educadores()));
            }
            if (contagem.getNumeroEducadores().equals(0)) {
                contagem.setQ26E(1);
            }
            if (rotina.getQ26Alunos() != null && !rotina.getQ26Alunos().isEmpty()) {
                contagem.setNumeroAlunos(Integer.parseInt(rotina.getQ26Alunos()));
            }
            if (contagem.getNumeroAlunos() > 10 && contagem.getNumeroAlunos() < 25) {
                contagem.setQ26AB(1);
            } else if (contagem.getNumeroAlunos() <= 10) {
                contagem.setQ26AC(1);
            }

            contagem.setNumeroEducadores(0);
            contagem.setNumeroAlunos(0);

            if (rotina.getQ27Educadores() != null && !rotina.getQ27Educadores().isEmpty()) {
                contagem.setNumeroEducadores(Integer.parseInt(rotina.getQ27Educadores()));
            }
            if (contagem.getNumeroEducadores().equals(0)) {
                contagem.setQ27E(1);
            }
            if (rotina.getQ27Alunos() != null && !rotina.getQ27Alunos().isEmpty()) {
                contagem.setNumeroAlunos(Integer.parseInt(rotina.getQ27Alunos()));
            }
            if (contagem.getNumeroAlunos() > 10 && contagem.getNumeroAlunos() < 25) {
                contagem.setQ27AB(1);
            } else if (contagem.getNumeroAlunos() <= 10) {
                contagem.setQ27AC(1);
            }

            contagem.setNumeroEducadores(0);
            contagem.setNumeroAlunos(0);

            if (rotina.getQ28Educadores() != null && !rotina.getQ28Educadores().isEmpty()) {
                contagem.setNumeroEducadores(Integer.parseInt(rotina.getQ28Educadores()));
            }
            if (contagem.getNumeroEducadores().equals(0)) {
                contagem.setQ24E(1);
            }
            if (rotina.getQ28Alunos() != null && !rotina.getQ28Alunos().isEmpty()) {
                contagem.setNumeroAlunos(Integer.parseInt(rotina.getQ28Alunos()));
            }
            if (contagem.getNumeroAlunos() > 10 && contagem.getNumeroAlunos() < 25) {
                contagem.setQ28AB(1);
            } else if (contagem.getNumeroAlunos() <= 10) {
                contagem.setQ28AC(1);
            }



            if (rotina.getQ29() != null) {
                if (rotina.getQ29().equals("nenhuma")) {
                    contagem.setQ29nao(1);
                }
            }
            if (rotina.getQ30() != null) {
                if (rotina.getQ30().equals("nenhuma")) {
                    contagem.setQ30nao(1);
                }
            }
            if (rotina.getQ31() != null) {
                if (rotina.getQ31().equals("nenhuma")) {
                    contagem.setQ31nao(1);
                }
            }
            if (rotina.getQ32() != null) {
                if (rotina.getQ32().equals("nenhuma")) {
                    contagem.setQ32nao(1);
                }
            }
            if (rotina.getQ33() != null) {
                if (rotina.getQ33().equals("nenhuma")) {
                    contagem.setQ33nao(1);
                }
            }


            if (rotina.getQ34() != null) {
                if (rotina.getQ34().equals("nao")) {
                    contagem.setQ34nao(1);
                }
            }
            if (rotina.getQ35() != null) {
                if (rotina.getQ35().equals("nao")) {
                    contagem.setQ35nao(1);
                }
            }
            if (rotina.getQ36() != null) {
                if (rotina.getQ36().equals("nao")) {
                    contagem.setQ36nao(1);
                }
            }
            if (rotina.getQ37() != null) {
                if (rotina.getQ37().equals("nao")) {
                    contagem.setQ37nao(1);
                }
            }
            if (rotina.getQ38() != null) {
                if (rotina.getQ38().equals("nao")) {
                    contagem.setQ38nao(1);
                }
            }


            if (rotina.getQ39() != null) {
                if (rotina.getQ39().equals("nao")) {
                    contagem.setQ39nao(1);
                }
            }
            if (rotina.getQ40() != null) {
                if (rotina.getQ40().equals("nao")) {
                    contagem.setQ40nao(1);
                }
            }
            if (rotina.getQ41() != null) {
                if (rotina.getQ41().equals("nao")) {
                    contagem.setQ41nao(1);
                }
            }
            if (rotina.getQ42() != null) {
                if (rotina.getQ42().equals("nao")) {
                    contagem.setQ42nao(1);
                }
            }
            if (rotina.getQ43() != null) {
                if (rotina.getQ43().equals("nao")) {
                    contagem.setQ43nao(1);
                }
            }



            if (rotina.getQ9InicioAtividades() != null && !rotina.getQ9InicioAtividades().isEmpty()) {
                contagem.setHoraInicial(Integer.parseInt(rotina.getQ9InicioAtividades().substring(0, 2)));
            }
            if (rotina.getQ9FinalAtividades() != null && !rotina.getQ9FinalAtividades().isEmpty()) {
                contagem.setHoraFinal(Integer.parseInt(rotina.getQ9FinalAtividades().substring(0, 2)));
            }





            if (rotina.getQ1Aarco().equals("Administração")) {
                contagem = Rotina006ContagemArcoA.contagemArcoAAdministracao(contagem);
            }
            if (rotina.getQ1Aarco().equals("Agroextrativismo")) {
                contagem = Rotina006ContagemArcoA.contagemArcoAAgroextrativismo(contagem);
            }
            if (rotina.getQ1Aarco().equals("Alimentação")) {
                contagem = Rotina006ContagemArcoA.contagemArcoAAlimentacao(contagem);
            }
            if (rotina.getQ1Aarco().equals("Arte e Cultura I")) {
                contagem = Rotina006ContagemArcoA.contagemArcoAArteECulturaI(contagem);
            }
            if (rotina.getQ1Aarco().equals("Arte e Cultura II")) {
                contagem = Rotina006ContagemArcoA.contagemArcoAArteECulturaII(contagem);
            }
            if (rotina.getQ1Aarco().equals("Construção e Reparos I (Revestimentos)")) {
                contagem = Rotina006ContagemArcoA.contagemArcoAConstrucaoEReparosI(contagem);
            }
            if (rotina.getQ1Aarco().equals("Construção e Reparos II (Instalações)")) {
                contagem = Rotina006ContagemArcoA.contagemArcoAConstrucaoEReparosII(contagem);
            }
            if (rotina.getQ1Aarco().equals("Educação")) {
                contagem = Rotina006ContagemArcoA.contagemArcoAEducacao(contagem);
            }
            if (rotina.getQ1Aarco().equals("Esporte e Lazer")) {
                contagem = Rotina006ContagemArcoA.contagemArcoAEsporteELazer(contagem);
            }
            if (rotina.getQ1Aarco().equals("Gestão Pública e Terceiro Setor")) {
                contagem = Rotina006ContagemArcoA.contagemArcoAGestaoPublicaETerceiroSetor(contagem);
            }
            if (rotina.getQ1Aarco().equals("Gráfica")) {
                contagem = Rotina006ContagemArcoA.contagemArcoAGrafica(contagem);
            }
            if (rotina.getQ1Aarco().equals("Joalheria")) {
                contagem = Rotina006ContagemArcoA.contagemArcoAJoalheria(contagem);
            }
            if (rotina.getQ1Aarco().equals("Madeira e Móveis")) {
                contagem = Rotina006ContagemArcoA.contagemArcoAMadeiraEMoveis(contagem);
            }
            if (rotina.getQ1Aarco().equals("Metalmecânica")) {
                contagem = Rotina006ContagemArcoA.contagemArcoAMetalmecanica(contagem);
            }
            if (rotina.getQ1Aarco().equals("Pesca e Piscicultura")) {
                contagem = Rotina006ContagemArcoA.contagemArcoAPescaEPiscicultura(contagem);
            }
            if (rotina.getQ1Aarco().equals("Saúde")) {
                contagem = Rotina006ContagemArcoA.contagemArcoASaude(contagem);
            }
            if (rotina.getQ1Aarco().equals("Serviços Domésticos I")) {
                contagem = Rotina006ContagemArcoA.contagemArcoAServicosDomesticosI(contagem);
            }
            if (rotina.getQ1Aarco().equals("Serviços Domésticos II")) {
                contagem = Rotina006ContagemArcoA.contagemArcoAServicosDomesticosII(contagem);
            }
            if (rotina.getQ1Aarco().equals("Serviços Pessoais")) {
                contagem = Rotina006ContagemArcoA.contagemArcoAServicosPessoais(contagem);
            }
            if (rotina.getQ1Aarco().equals("Telemática")) {
                contagem = Rotina006ContagemArcoA.contagemArcoATelematica(contagem);
            }
            if (rotina.getQ1Aarco().equals("Transporte")) {
                contagem = Rotina006ContagemArcoA.contagemArcoATransporte(contagem);
            }
            if (rotina.getQ1Aarco().equals("Turismo e Hospitalidade")) {
                contagem = Rotina006ContagemArcoA.contagemArcoATurismoEHospitalidade(contagem);
            }
            if (rotina.getQ1Aarco().equals("Vestuário")) {
                contagem = Rotina006ContagemArcoA.contagemArcoAVestuario(contagem);
            }

            contagem.setHoraInicial(0);
            contagem.setHoraFinal(0);

            if (rotina.getQ10InicioAtividades() != null && !rotina.getQ10InicioAtividades().isEmpty()) {
                contagem.setHoraInicial(Integer.parseInt(rotina.getQ10InicioAtividades().substring(0, 2)));
            }
            if (rotina.getQ10FinalAtividades() != null && !rotina.getQ10FinalAtividades().isEmpty()) {
                contagem.setHoraFinal(Integer.parseInt(rotina.getQ10FinalAtividades().substring(0, 2)));
            }




            if (rotina.getQ1Barco().equals("Administração")) {
                contagem = Rotina006ContagemArcoB.contagemArcoBAdministracao(contagem);
            }
            if (rotina.getQ1Barco().equals("Agroextrativismo")) {
                contagem = Rotina006ContagemArcoB.contagemArcoBAgroextrativismo(contagem);
            }
            if (rotina.getQ1Barco().equals("Alimentação")) {
                contagem = Rotina006ContagemArcoB.contagemArcoBAlimentacao(contagem);

            }
            if (rotina.getQ1Barco().equals("Arte e Cultura I")) {
                contagem = Rotina006ContagemArcoB.contagemArcoBArteECulturaI(contagem);
            }
            if (rotina.getQ1Barco().equals("Arte e Cultura II")) {
                contagem = Rotina006ContagemArcoB.contagemArcoBArteECulturaII(contagem);
            }
            if (rotina.getQ1Barco().equals("Construção e Reparos I (Revestimentos)")) {
                contagem = Rotina006ContagemArcoB.contagemArcoBConstrucaoEReparosI(contagem);
            }
            if (rotina.getQ1Barco().equals("Construção e Reparos II (Instalações)")) {
                contagem = Rotina006ContagemArcoB.contagemArcoBConstrucaoEReparosII(contagem);
            }
            if (rotina.getQ1Barco().equals("Educação")) {
                contagem = Rotina006ContagemArcoB.contagemArcoBEducacao(contagem);
            }
            if (rotina.getQ1Barco().equals("Esporte e Lazer")) {
                contagem = Rotina006ContagemArcoB.contagemArcoBEsporteELazer(contagem);
            }
            if (rotina.getQ1Barco().equals("Gestão Pública e Terceiro Setor")) {
                contagem = Rotina006ContagemArcoB.contagemArcoBGestaoPublicaETerceiroSetor(contagem);
            }
            if (rotina.getQ1Barco().equals("Gráfica")) {
                contagem = Rotina006ContagemArcoB.contagemArcoBGrafica(contagem);
            }
            if (rotina.getQ1Barco().equals("Joalheria")) {
                contagem = Rotina006ContagemArcoB.contagemArcoBJoalheria(contagem);
            }
            if (rotina.getQ1Barco().equals("Madeira e Móveis")) {
                contagem = Rotina006ContagemArcoB.contagemArcoBMadeiraEMoveis(contagem);
            }
            if (rotina.getQ1Barco().equals("Metalmecânica")) {
                contagem = Rotina006ContagemArcoB.contagemArcoBMetalmecanica(contagem);
            }
            if (rotina.getQ1Barco().equals("Pesca e Piscicultura")) {
                contagem = Rotina006ContagemArcoB.contagemArcoBPescaEPiscicultura(contagem);
            }
            if (rotina.getQ1Barco().equals("Saúde")) {
                contagem = Rotina006ContagemArcoB.contagemArcoBSaude(contagem);
            }
            if (rotina.getQ1Barco().equals("Serviços Domésticos I")) {
                contagem = Rotina006ContagemArcoB.contagemArcoBServicosDomesticosI(contagem);
            }
            if (rotina.getQ1Barco().equals("Serviços Domésticos II")) {
                contagem = Rotina006ContagemArcoB.contagemArcoBServicosDomesticosII(contagem);
            }
            if (rotina.getQ1Barco().equals("Serviços Pessoais")) {
                contagem = Rotina006ContagemArcoB.contagemArcoBServicosPessoais(contagem);
            }
            if (rotina.getQ1Barco().equals("Telemática")) {
                contagem = Rotina006ContagemArcoB.contagemArcoBTelematica(contagem);
            }
            if (rotina.getQ1Barco().equals("Transporte")) {
                contagem = Rotina006ContagemArcoB.contagemArcoBTransporte(contagem);
            }
            if (rotina.getQ1Barco().equals("Turismo e Hospitalidade")) {
                contagem = Rotina006ContagemArcoB.contagemArcoBTurismoEHospitalidade(contagem);
            }
            if (rotina.getQ1Barco().equals("Vestuário")) {
                contagem = Rotina006ContagemArcoB.contagemArcoBVestuario(contagem);
            }

            contagem.setHoraInicial(0);
            contagem.setHoraFinal(0);


            if (rotina.getQ11InicioAtividades() != null && !rotina.getQ11InicioAtividades().isEmpty()) {
                contagem.setHoraInicial(Integer.parseInt(rotina.getQ11InicioAtividades().substring(0, 2)));
            }
            if (rotina.getQ11FinalAtividades() != null && !rotina.getQ11FinalAtividades().isEmpty()) {
                contagem.setHoraFinal(Integer.parseInt(rotina.getQ11FinalAtividades().substring(0, 2)));
            }


            if (rotina.getQ1Carco().equals("Administração")) {
                contagem = Rotina006ContagemArcoC.contagemArcoCAdministracao(contagem);
            }
            if (rotina.getQ1Carco().equals("Agroextrativismo")) {
                contagem = Rotina006ContagemArcoC.contagemArcoCAgroextrativismo(contagem);
            }
            if (rotina.getQ1Carco().equals("Alimentação")) {
                contagem = Rotina006ContagemArcoC.contagemArcoCAlimentacao(contagem);

            }
            if (rotina.getQ1Carco().equals("Arte e Cultura I")) {
                contagem = Rotina006ContagemArcoC.contagemArcoCArteECulturaI(contagem);
            }
            if (rotina.getQ1Carco().equals("Arte e Cultura II")) {
                contagem = Rotina006ContagemArcoC.contagemArcoCArteECulturaII(contagem);
            }
            if (rotina.getQ1Carco().equals("Construção e Reparos I (Revestimentos)")) {
                contagem = Rotina006ContagemArcoC.contagemArcoCConstrucaoEReparosI(contagem);
            }
            if (rotina.getQ1Carco().equals("Construção e Reparos II (Instalações)")) {
                contagem = Rotina006ContagemArcoC.contagemArcoCConstrucaoEReparosII(contagem);
            }
            if (rotina.getQ1Carco().equals("Educação")) {
                contagem = Rotina006ContagemArcoC.contagemArcoCEducacao(contagem);
            }
            if (rotina.getQ1Carco().equals("Esporte e Lazer")) {
                contagem = Rotina006ContagemArcoC.contagemArcoCEsporteELazer(contagem);
            }
            if (rotina.getQ1Carco().equals("Gestão Pública e Terceiro Setor")) {
                contagem = Rotina006ContagemArcoC.contagemArcoCGestaoPublicaETerceiroSetor(contagem);
            }
            if (rotina.getQ1Carco().equals("Gráfica")) {
                contagem = Rotina006ContagemArcoC.contagemArcoCGrafica(contagem);
            }
            if (rotina.getQ1Carco().equals("Joalheria")) {
                contagem = Rotina006ContagemArcoC.contagemArcoCJoalheria(contagem);
            }
            if (rotina.getQ1Carco().equals("Madeira e Móveis")) {
                contagem = Rotina006ContagemArcoC.contagemArcoCMadeiraEMoveis(contagem);
            }
            if (rotina.getQ1Carco().equals("Metalmecânica")) {
                contagem = Rotina006ContagemArcoC.contagemArcoCMetalmecanica(contagem);
            }
            if (rotina.getQ1Carco().equals("Pesca e Piscicultura")) {
                contagem = Rotina006ContagemArcoC.contagemArcoCPescaEPiscicultura(contagem);
            }
            if (rotina.getQ1Carco().equals("Saúde")) {
                contagem = Rotina006ContagemArcoC.contagemArcoCSaude(contagem);
            }
            if (rotina.getQ1Carco().equals("Serviços Domésticos I")) {
                contagem = Rotina006ContagemArcoC.contagemArcoCServicosDomesticosI(contagem);
            }
            if (rotina.getQ1Carco().equals("Serviços Domésticos II")) {
                contagem = Rotina006ContagemArcoC.contagemArcoCServicosDomesticosII(contagem);
            }
            if (rotina.getQ1Carco().equals("Serviços Pessoais")) {
                contagem = Rotina006ContagemArcoC.contagemArcoCServicosPessoais(contagem);
            }
            if (rotina.getQ1Carco().equals("Telemática")) {
                contagem = Rotina006ContagemArcoC.contagemArcoCTelematica(contagem);
            }
            if (rotina.getQ1Carco().equals("Transporte")) {
                contagem = Rotina006ContagemArcoC.contagemArcoCTransporte(contagem);
            }
            if (rotina.getQ1Carco().equals("Turismo e Hospitalidade")) {
                contagem = Rotina006ContagemArcoC.contagemArcoCTurismoEHospitalidade(contagem);
            }
            if (rotina.getQ1Carco().equals("Vestuário")) {
                contagem = Rotina006ContagemArcoC.contagemArcoCVestuario(contagem);
            }



            contagem.setHoraInicial(0);
            contagem.setHoraFinal(0);


            if (rotina.getQ12InicioAtividades() != null && !rotina.getQ12InicioAtividades().isEmpty()) {
                contagem.setHoraInicial(Integer.parseInt(rotina.getQ12InicioAtividades().substring(0, 2)));
            }
            if (rotina.getQ12FinalAtividades() != null && !rotina.getQ12FinalAtividades().isEmpty()) {
                contagem.setHoraFinal(Integer.parseInt(rotina.getQ12FinalAtividades().substring(0, 2)));
            }



            if (rotina.getQ1Darco().equals("Administração")) {
                contagem = Rotina006ContagemArcoD.contagemArcoDAdministracao(contagem);
            }
            if (rotina.getQ1Darco().equals("Agroextrativismo")) {
                contagem = Rotina006ContagemArcoD.contagemArcoDAgroextrativismo(contagem);
            }
            if (rotina.getQ1Darco().equals("Alimentação")) {
                contagem = Rotina006ContagemArcoD.contagemArcoDAlimentacao(contagem);

            }
            if (rotina.getQ1Darco().equals("Arte e Cultura I")) {
                contagem = Rotina006ContagemArcoD.contagemArcoDArteECulturaI(contagem);
            }
            if (rotina.getQ1Darco().equals("Arte e Cultura II")) {
                contagem = Rotina006ContagemArcoD.contagemArcoDArteECulturaII(contagem);
            }
            if (rotina.getQ1Darco().equals("Construção e Reparos I (Revestimentos)")) {
                contagem = Rotina006ContagemArcoD.contagemArcoDConstrucaoEReparosI(contagem);
            }
            if (rotina.getQ1Darco().equals("Construção e Reparos II (Instalações)")) {
                contagem = Rotina006ContagemArcoD.contagemArcoDConstrucaoEReparosII(contagem);
            }
            if (rotina.getQ1Darco().equals("Educação")) {
                contagem = Rotina006ContagemArcoD.contagemArcoDEducacao(contagem);
            }
            if (rotina.getQ1Darco().equals("Esporte e Lazer")) {
                contagem = Rotina006ContagemArcoD.contagemArcoDEsporteELazer(contagem);
            }
            if (rotina.getQ1Darco().equals("Gestão Pública e Terceiro Setor")) {
                contagem = Rotina006ContagemArcoD.contagemArcoDGestaoPublicaETerceiroSetor(contagem);
            }
            if (rotina.getQ1Darco().equals("Gráfica")) {
                contagem = Rotina006ContagemArcoD.contagemArcoDGrafica(contagem);
            }
            if (rotina.getQ1Darco().equals("Joalheria")) {
                contagem = Rotina006ContagemArcoD.contagemArcoDJoalheria(contagem);
            }
            if (rotina.getQ1Darco().equals("Madeira e Móveis")) {
                contagem = Rotina006ContagemArcoD.contagemArcoDMadeiraEMoveis(contagem);
            }
            if (rotina.getQ1Darco().equals("Metalmecânica")) {
                contagem = Rotina006ContagemArcoD.contagemArcoDMetalmecanica(contagem);
            }
            if (rotina.getQ1Darco().equals("Pesca e Piscicultura")) {
                contagem = Rotina006ContagemArcoD.contagemArcoDPescaEPiscicultura(contagem);
            }
            if (rotina.getQ1Darco().equals("Saúde")) {
                contagem = Rotina006ContagemArcoD.contagemArcoDSaude(contagem);
            }
            if (rotina.getQ1Darco().equals("Serviços Domésticos I")) {
                contagem = Rotina006ContagemArcoD.contagemArcoDServicosDomesticosI(contagem);
            }
            if (rotina.getQ1Darco().equals("Serviços Domésticos II")) {
                contagem = Rotina006ContagemArcoD.contagemArcoDServicosDomesticosII(contagem);
            }
            if (rotina.getQ1Darco().equals("Serviços Pessoais")) {
                contagem = Rotina006ContagemArcoD.contagemArcoDServicosPessoais(contagem);
            }
            if (rotina.getQ1Darco().equals("Telemática")) {
                contagem = Rotina006ContagemArcoD.contagemArcoDTelematica(contagem);
            }
            if (rotina.getQ1Darco().equals("Transporte")) {
                contagem = Rotina006ContagemArcoD.contagemArcoDTransporte(contagem);
            }
            if (rotina.getQ1Darco().equals("Turismo e Hospitalidade")) {
                contagem = Rotina006ContagemArcoD.contagemArcoDTurismoEHospitalidade(contagem);
            }
            if (rotina.getQ1Darco().equals("Vestuário")) {
                contagem = Rotina006ContagemArcoD.contagemArcoDVestuario(contagem);
            }

            contagem.setHoraInicial(0);
            contagem.setHoraFinal(0);


            if (rotina.getQ12InicioAtividades() != null && !rotina.getQ12InicioAtividades().isEmpty()) {
                contagem.setHoraInicial(Integer.parseInt(rotina.getQ12InicioAtividades().substring(0, 2)));
            }
            if (rotina.getQ12FinalAtividades() != null && !rotina.getQ12FinalAtividades().isEmpty()) {
                contagem.setHoraFinal(Integer.parseInt(rotina.getQ12FinalAtividades().substring(0, 2)));
            }

            if (rotina.getQ1Earco().equals("Administração")) {
                contagem = Rotina006ContagemArcoE.contagemArcoEAdministracao(contagem);
            }
            if (rotina.getQ1Earco().equals("Agroextrativismo")) {
                contagem = Rotina006ContagemArcoE.contagemArcoEAgroextrativismo(contagem);
            }
            if (rotina.getQ1Earco().equals("Alimentação")) {
                contagem = Rotina006ContagemArcoE.contagemArcoEAlimentacao(contagem);

            }
            if (rotina.getQ1Earco().equals("Arte e Cultura I")) {
                contagem = Rotina006ContagemArcoE.contagemArcoEArteECulturaI(contagem);
            }
            if (rotina.getQ1Earco().equals("Arte e Cultura II")) {
                contagem = Rotina006ContagemArcoE.contagemArcoEArteECulturaII(contagem);
            }
            if (rotina.getQ1Earco().equals("Construção e Reparos I (Revestimentos)")) {
                contagem = Rotina006ContagemArcoE.contagemArcoEConstrucaoEReparosI(contagem);
            }
            if (rotina.getQ1Earco().equals("Construção e Reparos II (Instalações)")) {
                contagem = Rotina006ContagemArcoE.contagemArcoEConstrucaoEReparosII(contagem);
            }
            if (rotina.getQ1Earco().equals("Educação")) {
                contagem = Rotina006ContagemArcoE.contagemArcoEEducacao(contagem);
            }
            if (rotina.getQ1Earco().equals("Esporte e Lazer")) {
                contagem = Rotina006ContagemArcoE.contagemArcoEEsporteELazer(contagem);
            }
            if (rotina.getQ1Earco().equals("Gestão Pública e Terceiro Setor")) {
                contagem = Rotina006ContagemArcoE.contagemArcoEGestaoPublicaETerceiroSetor(contagem);
            }
            if (rotina.getQ1Earco().equals("Gráfica")) {
                contagem = Rotina006ContagemArcoE.contagemArcoEGrafica(contagem);
            }
            if (rotina.getQ1Earco().equals("Joalheria")) {
                contagem = Rotina006ContagemArcoE.contagemArcoEJoalheria(contagem);
            }
            if (rotina.getQ1Earco().equals("Madeira e Móveis")) {
                contagem = Rotina006ContagemArcoE.contagemArcoEMadeiraEMoveis(contagem);
            }
            if (rotina.getQ1Earco().equals("Metalmecânica")) {
                contagem = Rotina006ContagemArcoE.contagemArcoEMetalmecanica(contagem);
            }
            if (rotina.getQ1Earco().equals("Pesca e Piscicultura")) {
                contagem = Rotina006ContagemArcoE.contagemArcoEPescaEPiscicultura(contagem);
            }
            if (rotina.getQ1Earco().equals("Saúde")) {
                contagem = Rotina006ContagemArcoE.contagemArcoESaude(contagem);
            }
            if (rotina.getQ1Earco().equals("Serviços Domésticos I")) {
                contagem = Rotina006ContagemArcoE.contagemArcoEServicosDomesticosI(contagem);
            }
            if (rotina.getQ1Earco().equals("Serviços Domésticos II")) {
                contagem = Rotina006ContagemArcoE.contagemArcoEServicosDomesticosII(contagem);
            }
            if (rotina.getQ1Earco().equals("Serviços Pessoais")) {
                contagem = Rotina006ContagemArcoE.contagemArcoEServicosPessoais(contagem);
            }
            if (rotina.getQ1Earco().equals("Telemática")) {
                contagem = Rotina006ContagemArcoE.contagemArcoETelematica(contagem);
            }
            if (rotina.getQ1Earco().equals("Transporte")) {
                contagem = Rotina006ContagemArcoE.contagemArcoETransporte(contagem);
            }
            if (rotina.getQ1Earco().equals("Turismo e Hospitalidade")) {
                contagem = Rotina006ContagemArcoE.contagemArcoETurismoEHospitalidade(contagem);
            }
            if (rotina.getQ1Earco().equals("Vestuário")) {
                contagem = Rotina006ContagemArcoE.contagemArcoEVestuario(contagem);
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
