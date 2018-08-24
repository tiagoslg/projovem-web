/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import projovem.relatorios.rotinaslancadas.vo.FiltrosVo;
import projovem.relatorios.rotinaslancadas.vo.RotinasLancadasVO;
import projovem.rotinas.R001.Rotina001;
import projovem.rotinas.R002.Rotina002;
import projovem.rotinas.R002.Rotina002PerfilEducadores;
import projovem.rotinas.R002.Rotina002PerfilFormadores;
import projovem.rotinas.R003.Rotina003;
import projovem.rotinas.R004.Rotina004;
import projovem.rotinas.R004.Rotina004V2;
import projovem.rotinas.R005.Rotina005;
import projovem.rotinas.R006.Rotina006ArcosOcupacionais;
import projovem.rotinas.R006.Rotina006ArcosOcupacionaisV3;
import projovem.rotinas.R006.Rotina006CoordenacaoLocal;
import projovem.rotinas.R007.Rotina007;
import projovem.rotinas.CE.R001.CeRotina001;
import projovem.rotinas.CE.R002.CeRotina002;
import projovem.rotinas.CE.R003.CeRotina003;
import projovem.rotinas.apoio.CicloUtil;

/**
 *
 * @author admprojovem
 */
public class RotinasDAO implements Serializable {

    private List<RotinasLancadasVO> listaRotinas = new ArrayList<RotinasLancadasVO>();

    public List<RotinasLancadasVO> getRotinasVOByFiltros(FiltrosVo filtros, EntityManagerFactory emf) {

        EntityManager em = emf.createEntityManager();
        //List<RotinasLancadasVO> listaRotinas = new ArrayList<RotinasLancadasVO>();

        List<Rotina001> listaRotina001 = null;
        List<Rotina002> listaRotina002 = null;
        List<Rotina002PerfilEducadores> listaRotina002b = null;
        List<Rotina002PerfilFormadores> listaRotina002c = null;
        List<Rotina003> listaRotina003 = null;
        List<Rotina004V2> listaRotina004V2 = null;
        List<Rotina004> listaRotina004 = null;
        List<Rotina005> listaRotina005 = null;
        List<Rotina006ArcosOcupacionais> listaRotina006a = null;
        List<Rotina006ArcosOcupacionaisV3> listaRotina006aV3 = null;
        List<Rotina006CoordenacaoLocal> listaRotina006b = null;
        List<Rotina007> listaRotina007 = null;
        List<CeRotina001> listaCeRotina001 = null;
        List<CeRotina002> listaCeRotina002 = null;
        List<CeRotina003> listaCeRotina003 = null;

        String where = " where 1=1 ";
        if (filtros.getCoordenacaoEscolhida() != null && !filtros.getCoordenacaoEscolhida().isEmpty()) {
            where += " and r.identificaEntradaCoordenacao ='" + filtros.getCoordenacaoEscolhida() + "'";
        }
        if (filtros.getMunicipioEscolhida() != null && !filtros.getMunicipioEscolhida().isEmpty()) {
            where += " and r.identificaEntradaMunicipio ='" + filtros.getMunicipioEscolhida() + "'";
        }
        if (filtros.getEntradaEscolhida() != null && !filtros.getEntradaEscolhida().isEmpty()) {
            where += " and r.identificaEntradaEntrada ='" + filtros.getEntradaEscolhida() + "'";
        }
        if (filtros.getIrEscolhida() != null && !filtros.getIrEscolhida().isEmpty()) {
            where += " and r.usuario.ir ='" + filtros.getIrEscolhida() + "'";
        }
        if (filtros.getSupervisorEscolhida() != null && !filtros.getSupervisorEscolhida().isEmpty()) {
            where += " and r.usuario.nome ='" + filtros.getSupervisorEscolhida() + "'";
        }
        if (filtros.getRotinaAguardandoValidacao() == true) {
            where += " and (r.dadosValidos ='0' or r.dadosValidos ='-1')";
        }



        if (filtros.getRotinaEscolhida().equals("Rotina 001") ||
                filtros.getRotinaEscolhida().equals("Rotina 002") ||
                filtros.getRotinaEscolhida().equals("Rotina 003") ||
                filtros.getRotinaEscolhida().equals("Rotina 004") ||
                filtros.getRotinaEscolhida().equals("Rotina 004V2") ||
                filtros.getRotinaEscolhida().equals("Rotina 005") ||
                filtros.getRotinaEscolhida().equals("Rotina 006 - Arcos Ocupacionais") ||
                filtros.getRotinaEscolhida().equals("Rotina 006 - Arcos OcupacionaisV3") ||
                filtros.getRotinaEscolhida().equals("Rotina 006 - Coordenacao Local") ||
                filtros.getRotinaEscolhida().equals("Rotina 001 - Estadual") ||
                filtros.getRotinaEscolhida().equals("Rotina 002 - Estadual") ||
                filtros.getRotinaEscolhida().equals("Rotina 003 - Estadual") ||
                filtros.getRotinaEscolhida().equals("Rotina 007")) {
            if (filtros.getDataInicialEscolhida() != null && !filtros.getDataInicialEscolhida().isEmpty()) {
                where += " and SUBSTRING(r.dataVisita,7,4) >=" + filtros.getDataInicialEscolhida().substring(6, 10);
                where += " and SUBSTRING(r.dataVisita,4,2) >=" + filtros.getDataInicialEscolhida().substring(3, 5);
                where += " and SUBSTRING(r.dataVisita,1,2) >=" + filtros.getDataInicialEscolhida().substring(0, 2);
            }
            if (filtros.getDataFinalEscolhida() != null && !filtros.getDataFinalEscolhida().isEmpty()) {
                where += " and SUBSTRING(r.dataVisita,7,4) <=" + filtros.getDataFinalEscolhida().substring(6, 10);
                where += " and SUBSTRING(r.dataVisita,4,2) <=" + filtros.getDataFinalEscolhida().substring(3, 5);
                where += " and SUBSTRING(r.dataVisita,1,2) <=" + filtros.getDataFinalEscolhida().substring(0, 2);
            }
        }
        if (filtros.getRotinaEscolhida().equals("Rotina 002 - Perfil Educadores")) {
            if (filtros.getDataInicialEscolhida() != null && !filtros.getDataInicialEscolhida().isEmpty()) {
                where += " and SUBSTRING(r.dataAplicacao,7,4) >=" + filtros.getDataInicialEscolhida().substring(6, 10);
                where += " and SUBSTRING(r.dataAplicacao,4,2) >=" + filtros.getDataInicialEscolhida().substring(3, 5);
                where += " and SUBSTRING(r.dataAplicacao,1,2) >=" + filtros.getDataInicialEscolhida().substring(0, 2);
            }
            if (filtros.getDataFinalEscolhida() != null && !filtros.getDataFinalEscolhida().isEmpty()) {
                where += " and SUBSTRING(r.dataAplicacao,7,4) <=" + filtros.getDataFinalEscolhida().substring(6, 10);
                where += " and SUBSTRING(r.dataAplicacao,4,2) <=" + filtros.getDataFinalEscolhida().substring(3, 5);
                where += " and SUBSTRING(r.dataAplicacao,1,2) <=" + filtros.getDataFinalEscolhida().substring(0, 2);
            }
        }
        if (filtros.getRotinaEscolhida().equals("Rotina 002 - Perfil Formadores")) {
            if (filtros.getDataInicialEscolhida() != null && !filtros.getDataInicialEscolhida().isEmpty()) {
                where += " and SUBSTRING(r.dia,7,4) >=" + filtros.getDataInicialEscolhida().substring(6, 10);
                where += " and SUBSTRING(r.dia,4,2) >=" + filtros.getDataInicialEscolhida().substring(3, 5);
                where += " and SUBSTRING(r.dia,1,2) >=" + filtros.getDataInicialEscolhida().substring(0, 2);
            }
            if (filtros.getDataFinalEscolhida() != null && !filtros.getDataFinalEscolhida().isEmpty()) {
                where += " and SUBSTRING(r.dia,7,4) <=" + filtros.getDataFinalEscolhida().substring(6, 10);
                where += " and SUBSTRING(r.dia,4,2) <=" + filtros.getDataFinalEscolhida().substring(3, 5);
                where += " and SUBSTRING(r.dia,1,2) <=" + filtros.getDataFinalEscolhida().substring(0, 2);
            }
        }


        try {
            if (filtros.getRotinaEscolhida().equals("Rotina 001") || filtros.getRotinaEscolhida().equals("0")) {
                listaRotina001 = em.createQuery("select r from Rotina001 as r " + where + " and r.dadosValidos < 2").getResultList();
            }
            if (filtros.getRotinaEscolhida().equals("Rotina 002") || filtros.getRotinaEscolhida().equals("0")) {
                listaRotina002 = em.createQuery("select r from Rotina002 as r " + where + " and r.dadosValidos < 2").getResultList();
            }
            if (filtros.getRotinaEscolhida().equals("Rotina 002 - Perfil Educadores") || filtros.getRotinaEscolhida().equals("0")) {
                listaRotina002b = em.createQuery("select r from Rotina002PerfilEducadores as r " + where + " and r.dadosValidos < 2").getResultList();
            }
            if (filtros.getRotinaEscolhida().equals("Rotina 002 - Perfil Formadores") || filtros.getRotinaEscolhida().equals("0")) {
                listaRotina002c = em.createQuery("select r from Rotina002PerfilFormadores as r " + where + " and r.dadosValidos < 2").getResultList();
            }
            if (filtros.getRotinaEscolhida().equals("Rotina 003") || filtros.getRotinaEscolhida().equals("0")) {
                listaRotina003 = em.createQuery("select r from Rotina003 as r " + where + " and r.dadosValidos < 2").getResultList();
            }
            if (filtros.getRotinaEscolhida().equals("Rotina 004") || filtros.getRotinaEscolhida().equals("0")) {
                listaRotina004 = em.createQuery("select r from Rotina004 as r " + where + " and r.dadosValidos < 2").getResultList();
            }
            if (filtros.getRotinaEscolhida().equals("Rotina 004V2") || filtros.getRotinaEscolhida().equals("0")) {
                listaRotina004V2 = em.createQuery("select r from Rotina004V2 as r " + where + " and r.dadosValidos < 2").getResultList();
            }
            if (filtros.getRotinaEscolhida().equals("Rotina 005") || filtros.getRotinaEscolhida().equals("0")) {
                listaRotina005 = em.createQuery("select r from Rotina005 as r " + where + " and r.dadosValidos < 2").getResultList();
            }
            if (filtros.getRotinaEscolhida().equals("Rotina 006 - Arcos Ocupacionais") || filtros.getRotinaEscolhida().equals("0")) {
                listaRotina006a = em.createQuery("select r from Rotina006ArcosOcupacionais as r " + where + " and r.dadosValidos < 2").getResultList();
            }
            if (filtros.getRotinaEscolhida().equals("Rotina 006 - Arcos OcupacionaisV3") || filtros.getRotinaEscolhida().equals("0")) {
                listaRotina006aV3 = em.createQuery("select r from Rotina006ArcosOcupacionaisV3 as r " + where + " and r.dadosValidos < 2").getResultList();
            }

            if (filtros.getRotinaEscolhida().equals("Rotina 006 - Coordenacao Local") || filtros.getRotinaEscolhida().equals("0")) {
                listaRotina006b = em.createQuery("select r from Rotina006CoordenacaoLocal as r " + where + " and r.dadosValidos < 2").getResultList();
            }
            if (filtros.getRotinaEscolhida().equals("Rotina 007") || filtros.getRotinaEscolhida().equals("0")) {
                listaRotina007 = em.createQuery("select r from Rotina007 as r " + where + " and r.dadosValidos < 2").getResultList();
            }
            if (filtros.getRotinaEscolhida().equals("Rotina 001 - Estadual") || filtros.getRotinaEscolhida().equals("0")) {
                listaCeRotina001 = em.createQuery("select r from CeRotina001 as r " + where + " and r.dadosValidos < 2").getResultList();
            }
            if (filtros.getRotinaEscolhida().equals("Rotina 002 - Estadual") || filtros.getRotinaEscolhida().equals("0")) {
                listaCeRotina002 = em.createQuery("select r from CeRotina002 as r " + where + " and r.dadosValidos < 2").getResultList();
            }
            if (filtros.getRotinaEscolhida().equals("Rotina 003 - Estadual") || filtros.getRotinaEscolhida().equals("0")) {
                listaCeRotina003 = em.createQuery("select r from CeRotina003 as r " + where + " and r.dadosValidos < 2").getResultList();
            }
        } finally {
            em.close();
        }

        if (listaRotina001 != null && listaRotina001.size() > 0) {
            for (Rotina001 rotina : listaRotina001) {
                if (rotina.getUsuario().getPerfil().equals("4")) {
                    RotinasLancadasVO r = new RotinasLancadasVO();

                    r.setId(rotina.getId());
                    r.setNucleo(rotina.getNomeLocal());
                    r.setRotina("Rotina 001");
                    r.setUsuario(rotina.getUsuario().getNome());
                    r.setCoordenacao(rotina.getIdentificaEntradaCoordenacao());
                    r.setMunicipio(rotina.getIdentificaEntradaMunicipio());
                    r.setUf(rotina.getIdentificaEntradaUf());
                    r.setEntrada(rotina.getIdentificaEntradaEntrada());
                    r.setIdRotina(rotina.getId());
                    r.setDadosValidos(rotina.getDadosValidos());
                    r.setDataVisita(rotina.getDataVisita());
                    r.setIdentificaEntradaObservacao("NSA");
                    getListaRotinas().add(r);
                }
            }
        }

        if (listaRotina002 != null && listaRotina002.size() > 0) {
            for (Rotina002 rotina : listaRotina002) {
                if (rotina.getUsuario().getPerfil().equals("4")) {
                    RotinasLancadasVO r = new RotinasLancadasVO();
                    r.setId(rotina.getId());
                    r.setNucleo(rotina.getNomeLocal());
                    r.setRotina("Rotina 002");
                    r.setUsuario(rotina.getUsuario().getNome());
                    r.setCoordenacao(rotina.getIdentificaEntradaCoordenacao());
                    r.setMunicipio(rotina.getIdentificaEntradaMunicipio());
                    r.setUf(rotina.getIdentificaEntradaUf());
                    r.setEntrada(rotina.getIdentificaEntradaEntrada());
                    r.setIdRotina(rotina.getId());
                    r.setDadosValidos(rotina.getDadosValidos());
                    r.setDataVisita(rotina.getDataVisita());
                    r.setIdentificaEntradaObservacao("NSA");
                    getListaRotinas().add(r);
                }
            }
        }

        if (listaRotina002b != null && listaRotina002b.size() > 0) {
            for (Rotina002PerfilEducadores rotina : listaRotina002b) {
                if (rotina.getUsuario().getPerfil().equals("4")) {
                    RotinasLancadasVO r = new RotinasLancadasVO();
                    r.setId(rotina.getId());
                    r.setNucleo(" --- ");
                    r.setRotina("Rotina 002 - Perfil Educadores");
                    r.setUsuario(rotina.getUsuario().getNome());
                    r.setCoordenacao(rotina.getIdentificaEntradaCoordenacao());
                    r.setMunicipio(rotina.getIdentificaEntradaMunicipio());
                    r.setUf(rotina.getIdentificaEntradaUf());
                    r.setEntrada(rotina.getIdentificaEntradaEntrada());
                    r.setIdRotina(rotina.getId());
                    r.setDadosValidos(rotina.getDadosValidos());
                    r.setDataVisita(rotina.getDataAplicacao());
                    r.setIdentificaEntradaObservacao("NSA");
                    getListaRotinas().add(r);
                }
            }
        }

        if (listaRotina002c != null && listaRotina002c.size() > 0) {
            for (Rotina002PerfilFormadores rotina : listaRotina002c) {
                if (rotina.getUsuario().getPerfil().equals("4")) {
                    RotinasLancadasVO r = new RotinasLancadasVO();
                    r.setId(rotina.getId());
                    r.setNucleo(" --- ");
                    r.setRotina("Rotina 002 - Perfil Formadores");
                    r.setUsuario(rotina.getUsuario().getNome());
                    r.setCoordenacao(rotina.getIdentificaEntradaCoordenacao());
                    r.setMunicipio(rotina.getIdentificaEntradaMunicipio());
                    r.setUf(rotina.getIdentificaEntradaUf());
                    r.setEntrada(rotina.getIdentificaEntradaEntrada());
                    r.setIdRotina(rotina.getId());
                    r.setDadosValidos(rotina.getDadosValidos());
                    r.setDataVisita(rotina.getDia());
                    r.setIdentificaEntradaObservacao("NSA");
                    getListaRotinas().add(r);
                }
            }
        }

        if (listaRotina003 != null && listaRotina003.size() > 0) {
            for (Rotina003 rotina : listaRotina003) {
                if (rotina.getUsuario().getPerfil().equals("4")) {
                    RotinasLancadasVO r = new RotinasLancadasVO();
                    r.setId(rotina.getId());
                    r.setNucleo(rotina.getNomeLocal());
                    r.setRotina("Rotina 003");
                    r.setUsuario(rotina.getUsuario().getNome());
                    r.setCoordenacao(rotina.getIdentificaEntradaCoordenacao());
                    r.setMunicipio(rotina.getIdentificaEntradaMunicipio());
                    r.setUf(rotina.getIdentificaEntradaUf());
                    r.setEntrada(rotina.getIdentificaEntradaEntrada());
                    r.setIdRotina(rotina.getId());
                    r.setDadosValidos(rotina.getDadosValidos());
                    r.setDataVisita(rotina.getDataVisita());
                    r.setIdentificaEntradaObservacao("NSA");
                    getListaRotinas().add(r);
                }
            }
        }

        if (listaRotina004V2 != null && listaRotina004V2.size() > 0) {
            for (Rotina004V2 rotina : listaRotina004V2) {
                if (rotina.getUsuario().getPerfil().equals("4")) {
                    RotinasLancadasVO r = new RotinasLancadasVO();
                    r.setId(rotina.getId());
                    r.setNucleo(rotina.getNucleo().getReferencia());
                    r.setRotina("Rotina 004V2");
                    r.setUsuario(rotina.getUsuario().getNome());
                    r.setCoordenacao(rotina.getIdentificaEntradaCoordenacao());
                    r.setMunicipio(rotina.getIdentificaEntradaMunicipio());
                    r.setUf(rotina.getIdentificaEntradaUf());
                    r.setEntrada(rotina.getIdentificaEntradaEntrada());
                    r.setIdRotina(rotina.getId());
                    r.setDadosValidos(rotina.getDadosValidos());
                    r.setDataVisita(rotina.getDataVisita());
                    r.setIdentificaEntradaObservacao(rotina.getIdentificaEntradaObservacao());
                    getListaRotinas().add(r);
                }
            }
        }

        if (listaRotina004 != null && listaRotina004.size() > 0) {
            for (Rotina004 rotina : listaRotina004) {
                if (rotina.getUsuario().getPerfil().equals("4")) {
                    RotinasLancadasVO r = new RotinasLancadasVO();
                    r.setCiclo(CicloUtil.obterCiclo("Rotina 004", rotina.getDataVisita(), rotina.getIdentificaEntradaEntrada()));
                    r.setId(rotina.getId());
                    r.setNucleo(rotina.getNucleo().getReferencia());
                    r.setRotina("Rotina 004");
                    r.setUsuario(rotina.getUsuario().getNome());
                    r.setCoordenacao(rotina.getIdentificaEntradaCoordenacao());
                    r.setMunicipio(rotina.getIdentificaEntradaMunicipio());
                    r.setUf(rotina.getIdentificaEntradaUf());
                    r.setEntrada(rotina.getIdentificaEntradaEntrada());
                    r.setIdRotina(rotina.getId());
                    r.setDadosValidos(rotina.getDadosValidos());
                    r.setDataVisita(rotina.getDataVisita());
                    r.setIdentificaEntradaObservacao(rotina.getIdentificaEntradaObservacao());
                    getListaRotinas().add(r);
                }
            }
        }

        if (listaRotina005 != null && listaRotina005.size() > 0) {
            for (Rotina005 rotina : listaRotina005) {
                if (rotina.getUsuario().getPerfil().equals("4")) {
                    RotinasLancadasVO r = new RotinasLancadasVO();
                    if (rotina.getNucleo() != null) {
                        r.setNucleo(rotina.getNucleo().getReferencia());
                    } else {
                        r.setNucleo(" --- ");
                    }
                    r.setCiclo(CicloUtil.obterCiclo("Rotina 005", rotina.getDataVisita(), rotina.getIdentificaEntradaEntrada()));
                    r.setId(rotina.getId());
                    r.setRotina("Rotina 005");
                    r.setUsuario(rotina.getUsuario().getNome());
                    r.setCoordenacao(rotina.getIdentificaEntradaCoordenacao());
                    r.setMunicipio(rotina.getIdentificaEntradaMunicipio());
                    r.setUf(rotina.getIdentificaEntradaUf());
                    r.setEntrada(rotina.getIdentificaEntradaEntrada());
                    r.setIdRotina(rotina.getId());
                    r.setDadosValidos(rotina.getDadosValidos());
                    r.setDataVisita(rotina.getDataVisita());
                    r.setIdentificaEntradaObservacao(rotina.getIdentificaEntradaObservacao());
                    getListaRotinas().add(r);
                }
            }
        }

        if (listaRotina006a != null && listaRotina006a.size() > 0) {
            for (Rotina006ArcosOcupacionais rotina : listaRotina006a) {
                if (rotina.getUsuario().getPerfil().equals("4")) {
                    RotinasLancadasVO r = new RotinasLancadasVO();
                    r.setCiclo(CicloUtil.obterCiclo("Rotina 006", rotina.getDataVisita(), rotina.getIdentificaEntradaEntrada()));
                    r.setId(rotina.getId());
                    r.setNucleo(rotina.getNomeLocal());

                    r.setRotina("Rotina 006 - Arcos Ocupacionais");
                    r.setUsuario(rotina.getUsuario().getNome());
                    r.setCoordenacao(rotina.getIdentificaEntradaCoordenacao());
                    r.setMunicipio(rotina.getIdentificaEntradaMunicipio());
                    r.setUf(rotina.getIdentificaEntradaUf());
                    r.setEntrada(rotina.getIdentificaEntradaEntrada());
                    r.setIdRotina(rotina.getId());
                    r.setDadosValidos(rotina.getDadosValidos());
                    r.setDataVisita(rotina.getDataVisita());
                    r.setIdentificaEntradaObservacao(rotina.getIdentificaEntradaObservacao());
                    getListaRotinas().add(r);
                }
            }
        }
        if (listaRotina006aV3 != null && listaRotina006aV3.size() > 0) {
            for (Rotina006ArcosOcupacionaisV3 rotina : listaRotina006aV3) {
                if (rotina.getUsuario().getPerfil().equals("4")) {
                    RotinasLancadasVO r = new RotinasLancadasVO();
                    r.setCiclo(CicloUtil.obterCiclo("Rotina 006", rotina.getDataVisita(), rotina.getIdentificaEntradaEntrada()));
                    r.setId(rotina.getId());
                    r.setNucleo(rotina.getNomeLocal());

                    r.setRotina("Rotina 006 - Arcos OcupacionaisV3");
                    r.setUsuario(rotina.getUsuario().getNome());
                    r.setCoordenacao(rotina.getIdentificaEntradaCoordenacao());
                    r.setMunicipio(rotina.getIdentificaEntradaMunicipio());
                    r.setUf(rotina.getIdentificaEntradaUf());
                    r.setEntrada(rotina.getIdentificaEntradaEntrada());
                    r.setIdRotina(rotina.getId());
                    r.setDadosValidos(rotina.getDadosValidos());
                    r.setDataVisita(rotina.getDataVisita());
                    r.setIdentificaEntradaObservacao(rotina.getIdentificaEntradaObservacao());
                    getListaRotinas().add(r);
                }
            }
        }

        if (listaRotina006b != null && listaRotina006b.size() > 0) {
            for (Rotina006CoordenacaoLocal rotina : listaRotina006b) {
                if (rotina.getUsuario().getPerfil().equals("4")) {
                    RotinasLancadasVO r = new RotinasLancadasVO();
                    r.setId(rotina.getId());
                    r.setNucleo(rotina.getNomeLocal());
                    r.setRotina("Rotina 006 - Coordenacao Local");
                    r.setUsuario(rotina.getUsuario().getNome());
                    r.setCoordenacao(rotina.getIdentificaEntradaCoordenacao());
                    r.setMunicipio(rotina.getIdentificaEntradaMunicipio());
                    r.setUf(rotina.getIdentificaEntradaUf());
                    r.setEntrada(rotina.getIdentificaEntradaEntrada());
                    r.setIdRotina(rotina.getId());
                    r.setDadosValidos(rotina.getDadosValidos());
                    r.setDataVisita(rotina.getDataVisita());
                    r.setIdentificaEntradaObservacao("NSA");
                    getListaRotinas().add(r);
                }
            }
        }

        if (listaRotina007 != null && listaRotina007.size() > 0) {
            for (Rotina007 rotina : listaRotina007) {
                if (rotina.getUsuario().getPerfil().equals("4")) {
                    RotinasLancadasVO r = new RotinasLancadasVO();
                    r.setCiclo(CicloUtil.obterCiclo("Rotina 007", rotina.getDataAplicacao(), rotina.getIdentificaEntradaEntrada()));
                    r.setId(rotina.getId());
                    r.setNucleo(" --- ");
                    r.setRotina("Rotina 007");
                    r.setUsuario(rotina.getUsuario().getNome());
                    r.setCoordenacao(rotina.getIdentificaEntradaCoordenacao());
                    r.setMunicipio(rotina.getIdentificaEntradaMunicipio());
                    r.setUf(rotina.getIdentificaEntradaUf());
                    r.setEntrada(rotina.getIdentificaEntradaEntrada());
                    r.setIdRotina(rotina.getId());
                    r.setDadosValidos(rotina.getDadosValidos());
                    r.setDataVisita(rotina.getDataAplicacao());
                    r.setIdentificaEntradaObservacao(rotina.getIdentificaEntradaObservacao());
                    getListaRotinas().add(r);
                }
            }
        }

        if (listaCeRotina001 != null && listaCeRotina001.size() > 0) {
            for (CeRotina001 rotina : listaCeRotina001) {
                if (rotina.getUsuario().getPerfil().equals("4")) {
                    RotinasLancadasVO r = new RotinasLancadasVO();
                    r.setCiclo(CicloUtil.obterCiclo("Rotina 001 - Estadual", rotina.getDataVisita(), rotina.getIdentificaEntradaEntrada()));
                    r.setId(rotina.getId());
                    r.setNucleo(rotina.getNucleo().getReferencia());
                    r.setRotina("Rotina 001 - Estadual");
                    r.setUsuario(rotina.getUsuario().getNome());
                    r.setCoordenacao(rotina.getIdentificaEntradaCoordenacao());
                    r.setMunicipio(rotina.getIdentificaEntradaMunicipio());
                    r.setUf(rotina.getIdentificaEntradaUf());
                    r.setEntrada(rotina.getIdentificaEntradaEntrada());
                    r.setIdRotina(rotina.getId());
                    r.setDadosValidos(rotina.getDadosValidos());
                    r.setDataVisita(rotina.getDataVisita());
                    r.setIdentificaEntradaObservacao(rotina.getIdentificaEntradaObservacao());
                    getListaRotinas().add(r);
                }
            }
        }

        if (listaCeRotina002 != null && listaCeRotina002.size() > 0) {
            for (CeRotina002 rotina : listaCeRotina002) {
                if (rotina.getUsuario().getPerfil().equals("4")) {
                    RotinasLancadasVO r = new RotinasLancadasVO();
                    r.setCiclo(CicloUtil.obterCiclo("Rotina 002 - Estadual", rotina.getDataAplicacao(), rotina.getIdentificaEntradaEntrada()));
                    r.setId(rotina.getId());
                    r.setNucleo(rotina.getNucleo().getReferencia());
                    r.setRotina("Rotina 002 - Estadual");
                    r.setUsuario(rotina.getUsuario().getNome());
                    r.setCoordenacao(rotina.getIdentificaEntradaCoordenacao());
                    r.setMunicipio(rotina.getIdentificaEntradaMunicipio());
                    r.setUf(rotina.getIdentificaEntradaUf());
                    r.setEntrada(rotina.getIdentificaEntradaEntrada());
                    r.setIdRotina(rotina.getId());
                    r.setDadosValidos(rotina.getDadosValidos());
                    r.setDataVisita(rotina.getDataAplicacao());
                    r.setIdentificaEntradaObservacao("NSA");
                    getListaRotinas().add(r);
                }
            }
        }

        if (listaCeRotina003 != null && listaCeRotina003.size() > 0) {
            for (CeRotina003 rotina : listaCeRotina003) {
                if (rotina.getUsuario().getPerfil().equals("4")) {
                    RotinasLancadasVO r = new RotinasLancadasVO();
                    r.setCiclo(CicloUtil.obterCiclo("Rotina 003 - Estadual", rotina.getDataVisita(), rotina.getIdentificaEntradaEntrada()));
                    r.setId(rotina.getId());
                    r.setNucleo(rotina.getNomeLocal());
                    r.setRotina("Rotina 003 - Estadual");
                    r.setUsuario(rotina.getUsuario().getNome());
                    r.setCoordenacao(rotina.getIdentificaEntradaCoordenacao());
                    r.setMunicipio(rotina.getIdentificaEntradaMunicipio());
                    r.setUf(rotina.getIdentificaEntradaUf());
                    r.setEntrada(rotina.getIdentificaEntradaEntrada());
                    r.setIdRotina(rotina.getId());
                    r.setDadosValidos(rotina.getDadosValidos());
                    r.setDataVisita(rotina.getDataVisita());
                    r.setIdentificaEntradaObservacao(rotina.getIdentificaEntradaObservacao());
                    getListaRotinas().add(r);
                }
            }
        }

        System.out.println("Total" + getListaRotinas().size());
        return getListaRotinas();

    }

    /**
     * @return the listaRotinas
     */
    public List<RotinasLancadasVO> getListaRotinas() {
        return listaRotinas;
    }

    /**
     * @param listaRotinas the listaRotinas to set
     */
    public void setListaRotinas(List<RotinasLancadasVO> listaRotinas) {
        this.listaRotinas = listaRotinas;
    }
}