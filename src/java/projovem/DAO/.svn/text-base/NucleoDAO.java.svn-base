/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import projovem.entity.Usuario;
import projovem.nucleo.Nucleo;
import projovem.rotinas.R004.Rotina004;
import projovem.rotinas.R005.Rotina005;
import projovem.rotinas.R006.Rotina006ArcosOcupacionais;
import projovem.rotinas.R001.Rotina001;
import projovem.rotinas.R003.Rotina003;
import projovem.rotinas.R003.Rotina003Ficha;
//import projovem.rotinas.R003.Rotina003_Rotina003Ficha;
import projovem.rotinas.CE.R001.CeRotina001;
import projovem.rotinas.CE.R002.CeRotina002;
import projovem.rotinas.CE.R003.CeRotina003;
import projovem.rotinas.R007.Rotina007;
import projovem.rotinas.R002.Rotina002;
import projovem.rotinas.R002.Rotina002PerfilFormadores;
import projovem.rotinas.R002.Rotina002PerfilEducadores;
import projovem.rotinas.R004.Rotina004V2;

/**
 *
 * @author admprojovem
 */
public class NucleoDAO implements Serializable {

    public List<SelectItem> obtemCoordenacoesByUF(String ufEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        List<String> listaNucleo = null;
        List<SelectItem> listaCoordenacao = new ArrayList<SelectItem>();

        try {
            listaNucleo = em.createQuery("select distinct n.coordenacao from Nucleo as n " +
                    " where n.uf = :ufEscolhida and n.coordenacao like('%Municipal%') " +
                    " order by n.coordenacao").setParameter("ufEscolhida", ufEscolhida).getResultList();

        } finally {
            em.close();
        }
        for (String nucleo : listaNucleo) {
            SelectItem item = new SelectItem(nucleo, nucleo);
            listaCoordenacao.add(item);
        }

        return listaCoordenacao;
    }

    public List<SelectItem> obtemCoordenacoesEstaduaisByUF(String ufEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        List<String> listaNucleo = null;
        List<SelectItem> listaCoordenacao = new ArrayList<SelectItem>();

        try {
            listaNucleo = em.createQuery("select distinct n.coordenacao from Nucleo as n " +
                    " where n.uf = :ufEscolhida and n.coordenacao like('%Estadual%') " +
                    " order by n.coordenacao").setParameter("ufEscolhida", ufEscolhida).getResultList();

        } finally {
            em.close();
        }
        for (String nucleo : listaNucleo) {
            SelectItem item = new SelectItem(nucleo, nucleo);
            listaCoordenacao.add(item);
        }

        return listaCoordenacao;
    }

    public String obtemCoordenacaoByMunicipioAndUF(String municipioEscolhido, String uf, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        List<String> listaNucleo = null;
        String coordenacao = "";

        try {
            listaNucleo = em.createQuery("select distinct n.coordenacao from Nucleo as n " +
                    " where n.municipio=:municipio and n.uf=:uf" +
                    " order by n.coordenacao").setParameter("municipio", municipioEscolhido).setParameter("uf", uf).getResultList();

        } finally {
            em.close();
        }

        if (listaNucleo != null && listaNucleo.size() > 0) {
            coordenacao = listaNucleo.get(0);
        }

        return coordenacao;
    }

    public List<SelectItem> obtemCoordenacoesByIR(String irEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        List<String> listaNucleo = null;
        List<SelectItem> listaCoordenacao = new ArrayList<SelectItem>();

        try {
            listaNucleo = em.createQuery("select distinct n.coordenacao from Nucleo as n " +
                    " where n.ir = :irEscolhida " +
                    " order by n.coordenacao").setParameter("irEscolhida", irEscolhida).getResultList();

        } finally {
            em.close();
        }
        for (String nucleo : listaNucleo) {
            SelectItem item = new SelectItem(nucleo, nucleo);
            listaCoordenacao.add(item);
        }

        return listaCoordenacao;
    }

    public List<SelectItem> obtemCoordenacoesEstaduaisByIR(String irEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        List<String> listaNucleo = null;
        List<SelectItem> listaCoordenacao = new ArrayList<SelectItem>();

        try {
            listaNucleo = em.createQuery("select distinct n.coordenacao from Nucleo as n " +
                    " where n.ir = :irEscolhida and n.coordenacao like('%Estadual%') " +
                    " order by n.coordenacao").setParameter("irEscolhida", irEscolhida).getResultList();

        } finally {
            em.close();
        }
        for (String nucleo : listaNucleo) {
            SelectItem item = new SelectItem(nucleo, nucleo);
            listaCoordenacao.add(item);
        }

        return listaCoordenacao;
    }

    public List<SelectItem> obtemEntradasByMunicipio(String municipioEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        List<String> listaNucleo = null;
        List<SelectItem> listaEntradas = new ArrayList<SelectItem>();

        try {
            listaNucleo = em.createQuery("select distinct n.entrada from Nucleo as n " +
                    " where n.municipio = :municipioEscolhida " +
                    " order by n.entrada").setParameter("municipioEscolhida", municipioEscolhida).getResultList();

        } finally {
            em.close();
        }
        for (String nucleo : listaNucleo) {
            SelectItem item = new SelectItem(nucleo, nucleo + " Entrada");
            listaEntradas.add(item);
        }

        return listaEntradas;
    }

    public List<SelectItem> obtemEntradasByCoordenacao(String coordenacaoEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        List<String> listaNucleo = null;
        List<SelectItem> listaEntradas = new ArrayList<SelectItem>();

        try {
            listaNucleo = em.createQuery("select distinct n.entrada from Nucleo as n " +
                    " where n.coordenacao = :coordenacaoEscolhida " +
                    " order by n.entrada").setParameter("coordenacaoEscolhida", coordenacaoEscolhida).getResultList();

        } finally {
            em.close();
        }
        for (String nucleo : listaNucleo) {
            SelectItem item = new SelectItem(nucleo, nucleo + " Entrada");
            listaEntradas.add(item);
        }

        return listaEntradas;
    }

    public List<SelectItem> obtemEntradasByIR(String irEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        List<String> listaNucleo = null;
        List<SelectItem> listaEntradas = new ArrayList<SelectItem>();

        try {
            listaNucleo = em.createQuery("select distinct n.entrada from Nucleo as n " +
                    " where n.ir = :irEscolhida " +
                    " order by n.entrada").setParameter("irEscolhida", irEscolhida).getResultList();

        } finally {
            em.close();
        }
        for (String nucleo : listaNucleo) {
            SelectItem item = new SelectItem(nucleo, nucleo + " Entrada");
            listaEntradas.add(item);
        }

        return listaEntradas;
    }

    public List<SelectItem> obtemMunicipiosByCoordenacao(String coordenacaoEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        List<String> listaNucleo = null;
        List<SelectItem> listaMunicipio = new ArrayList<SelectItem>();

        try {
            listaNucleo = em.createQuery("select distinct n.municipio from Nucleo as n " +
                    " where n.coordenacao = :coordenacaoEscolhida " +
                    " order by n.municipio").setParameter("coordenacaoEscolhida", coordenacaoEscolhida).getResultList();

        } finally {
            em.close();
        }
        for (String nucleo : listaNucleo) {
            SelectItem item = new SelectItem(nucleo.toUpperCase(), nucleo.toUpperCase());

            listaMunicipio.add(item);


        }

        return listaMunicipio;
    }

    public List<Nucleo> obtemNucleosByCoordenacao(String coordenacaoEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        List<Nucleo> listaNucleo = null;


        try {
            listaNucleo = em.createQuery("select n from Nucleo as n " +
                    " where n.coordenacao = :coordenacaoEscolhida " +
                    " order by n.referencia").setParameter("coordenacaoEscolhida", coordenacaoEscolhida).getResultList();

        } finally {
            em.close();
        }


        return listaNucleo;
    }

    public List<Nucleo> obtemTodosNucleos(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        System.out.println("Entrou");
        List<Nucleo> listaNucleo = null;


        try {
            listaNucleo = em.createQuery("select  n from Nucleo as n ").getResultList();

        } finally {
            em.close();
        }
        System.out.println("Size = " + listaNucleo.size());
        return listaNucleo;
    }

    public List<SelectItem> obterUfPossiveis(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioLogado = usuarioDAO.getUsuarioLogado();
        List<String> listaUf = new ArrayList<String>();
        List<SelectItem> ufs = new ArrayList<SelectItem>();

        try {
            listaUf = em.createQuery("select distinct n.uf from Nucleo as n " +
                    " where n.ir =:ir").setParameter("ir", usuarioLogado.getIr()).getResultList();

        } finally {
            em.close();
        }
        for (String uf : listaUf) {
            SelectItem item = new SelectItem(uf, uf);
            ufs.add(item);
        }

        return ufs;

    }

    public String obtemUfByCoordenacoesEstaduais(String coordenacaoEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        String ufEscolhida = null;
        List<String> listaUF = null;

        try {
            listaUF = em.createQuery("select distinct n.uf from Nucleo as n " +
                    " where n.coordenacao = :coordenacaoEscolhida " +
                    " order by n.uf").setParameter("coordenacaoEscolhida", coordenacaoEscolhida).getResultList();

        } finally {
            em.close();
        }
        for (String nucleo : listaUF) {
            ufEscolhida = nucleo;
        }

        return ufEscolhida;
    }

    public void saveNucleo(Nucleo nucleo, EntityManagerFactory emf, UserTransaction utx) {

        EntityManager em = emf.createEntityManager();

        try {
            utx.begin();
            em.joinTransaction();
            em.persist(nucleo);
            utx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (IllegalStateException ex) {
                ex.printStackTrace();
            } catch (SecurityException ex) {
                ex.printStackTrace();
            } catch (SystemException ex) {
                ex.printStackTrace();
            }
        } finally {
            em.close();
        }

    }

    public List<String> obtemCoordenacoesByEntrada(String entrada, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        List<String> listaCoordenacao = null;


        try {
            listaCoordenacao = em.createQuery("select distinct n.coordenacao from Nucleo as n " +
                    " where n.entrada = :entrada " +
                    " order by n.coordenacao").setParameter("entrada", entrada).getResultList();

        } finally {
            em.close();
        }


        return listaCoordenacao;
    }

    public List<SelectItem> obtemCoordenacoesByEntradaandIR(String entrada, String ir, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        List<String> listaNucleo = null;
        List<SelectItem> listaCoordenacao = new ArrayList<SelectItem>();

        try {
            listaNucleo = em.createQuery("select distinct n.coordenacao from Nucleo as n " +
                    " where n.entrada = :entrada and n.ir = :ir " +
                    " order by n.coordenacao").setParameter("entrada", entrada).setParameter("ir", ir).getResultList();

        } finally {
            em.close();
        }
        for (String nucleo : listaNucleo) {
            SelectItem item = new SelectItem(nucleo, nucleo);
            listaCoordenacao.add(item);
        }

        return listaCoordenacao;
    }

    public List<SelectItem> obtemMunicipiosByCoordenacaoAndEntrada(String entrada, String coordenacaoEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        List<String> listaNucleo = null;
        List<SelectItem> listaMunicipio = new ArrayList<SelectItem>();

        try {
            listaNucleo = em.createQuery("select distinct n.municipio from Nucleo as n " +
                    " where n.coordenacao = :coordenacaoEscolhida and n.entrada = :entrada " +
                    " order by n.municipio").setParameter("coordenacaoEscolhida", coordenacaoEscolhida).setParameter("entrada", entrada).getResultList();

        } finally {
            em.close();
        }
        for (String nucleo : listaNucleo) {
            SelectItem item = new SelectItem(nucleo.toUpperCase(), nucleo.toUpperCase());

            listaMunicipio.add(item);


        }

        return listaMunicipio;
    }

    public List<String> obtemEntradas(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        List<String> listaEntradas = null;


        try {
            listaEntradas = em.createQuery("select distinct n.entrada from Nucleo as n where n.entrada <> 0 order by n.entrada ").getResultList();

        } finally {
            em.close();
        }


        return listaEntradas;
    }

    public List<Rotina001> obtemNucleosByCoordenacaoAndEntradaAndRotina001(String coordenacaoEscolhida, String entradaEscolhida, String municipioEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        List<Nucleo> listaNucleo = null;
        List<Rotina001> listaRespostaRotina001 = null;
        String listaIdNucleos = "";

        try {
            if(municipioEscolhida.equals("0")){
                listaRespostaRotina001 = em.createQuery("select r from  Rotina001 as r " +
                    " where dadosValidos = '1' and r.identificaEntradaCoordenacao = :identificaEntradaCoordenacao and r.identificaEntradaEntrada = :identificaEntradaEntrada").setParameter("identificaEntradaCoordenacao", coordenacaoEscolhida).setParameter("identificaEntradaEntrada", entradaEscolhida).getResultList();
            }else{
                listaRespostaRotina001 = em.createQuery("select r from  Rotina001 as r " +
                    " where dadosValidos = '1' and r.identificaEntradaCoordenacao = :identificaEntradaCoordenacao and r.identificaEntradaEntrada = :identificaEntradaEntrada and r.identificaEntradaMunicipio = :identificaEntradaMunicipio").setParameter("identificaEntradaCoordenacao", coordenacaoEscolhida).setParameter("identificaEntradaEntrada", entradaEscolhida).setParameter("identificaEntradaMunicipio", municipioEscolhida).getResultList();
            }

        } finally {
            em.close();
        }


        return listaRespostaRotina001;
    }

    public List<Rotina002> obtemNucleosByCoordenacaoAndEntradaAndRotina002(String coordenacaoEscolhida, String entradaEscolhida, String municipioEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        List<Rotina002> listaRespostaRotina002 = null;

        try {
            if(municipioEscolhida.equals("0")){
                listaRespostaRotina002 = em.createQuery("select r from Rotina002 as r " +
                    " where r.dadosValidos = '1' and r.identificaEntradaCoordenacao = :identificaEntradaCoordenacao and r.identificaEntradaEntrada = :identificaEntradaEntrada").setParameter("identificaEntradaCoordenacao", coordenacaoEscolhida).setParameter("identificaEntradaEntrada", entradaEscolhida).getResultList();
            }else{
                listaRespostaRotina002 = em.createQuery("select r from Rotina002 as r " +
                    " where r.dadosValidos = '1' and r.identificaEntradaCoordenacao = :identificaEntradaCoordenacao and r.identificaEntradaEntrada = :identificaEntradaEntrada and r.identificaEntradaMunicipio = :identificaEntradaMunicipio").setParameter("identificaEntradaCoordenacao", coordenacaoEscolhida).setParameter("identificaEntradaEntrada", entradaEscolhida).setParameter("identificaEntradaMunicipio", municipioEscolhida).getResultList();
            }

        } finally {
            em.close();
        }


        return listaRespostaRotina002;
    }

    public List<Rotina002PerfilFormadores> obtemNucleosByCoordenacaoAndEntradaAndRotina002PerfilFormadores(String coordenacaoEscolhida, String entradaEscolhida, String municipioEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        List<Rotina002PerfilFormadores> listaRespostaRotina002PerfilFormadores = null;

        try {
            if(municipioEscolhida.equals("0")){
                listaRespostaRotina002PerfilFormadores = em.createQuery("select r from Rotina002PerfilFormadores as r " +
                    " where r.dadosValidos = '1' and r.identificaEntradaCoordenacao = :identificaEntradaCoordenacao and r.identificaEntradaEntrada = :identificaEntradaEntrada").setParameter("identificaEntradaCoordenacao", coordenacaoEscolhida).setParameter("identificaEntradaEntrada", entradaEscolhida).getResultList();
            }else{
                listaRespostaRotina002PerfilFormadores = em.createQuery("select r from Rotina002PerfilFormadores as r " +
                    " where r.dadosValidos = '1' and r.identificaEntradaCoordenacao = :identificaEntradaCoordenacao and r.identificaEntradaEntrada = :identificaEntradaEntrada and r.identificaEntradaMunicipio = :identificaEntradaMunicipio").setParameter("identificaEntradaCoordenacao", coordenacaoEscolhida).setParameter("identificaEntradaEntrada", entradaEscolhida).setParameter("identificaEntradaMunicipio", municipioEscolhida).getResultList();
            }

        } finally {
            em.close();
        }


        return listaRespostaRotina002PerfilFormadores;
    }

    public List<Rotina002PerfilEducadores> obtemNucleosByCoordenacaoAndEntradaAndRotina002PerfilEducadores(String coordenacaoEscolhida, String entradaEscolhida, String municipioEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        List<Rotina002PerfilEducadores> listaRespostaRotina002PerfilEducadores = null;

        try {
            if(municipioEscolhida.equals("0")){
                listaRespostaRotina002PerfilEducadores = em.createQuery("select r from Rotina002PerfilEducadores as r " +
                    " where r.dadosValidos = '1' and r.identificaEntradaCoordenacao = :identificaEntradaCoordenacao and r.identificaEntradaEntrada = :identificaEntradaEntrada").setParameter("identificaEntradaCoordenacao", coordenacaoEscolhida).setParameter("identificaEntradaEntrada", entradaEscolhida).getResultList();
            }else{
                listaRespostaRotina002PerfilEducadores = em.createQuery("select r from Rotina002PerfilEducadores as r " +
                    " where r.dadosValidos = '1' and r.identificaEntradaCoordenacao = :identificaEntradaCoordenacao and r.identificaEntradaEntrada = :identificaEntradaEntrada and r.identificaEntradaMunicipio = :identificaEntradaMunicipio").setParameter("identificaEntradaCoordenacao", coordenacaoEscolhida).setParameter("identificaEntradaEntrada", entradaEscolhida).setParameter("identificaEntradaMunicipio", municipioEscolhida).getResultList();
            }

        } finally {
            em.close();
        }


        return listaRespostaRotina002PerfilEducadores;
    }

    public List<Rotina003> obtemNucleosByCoordenacaoAndEntradaAndRotina003(String coordenacaoEscolhida, String entradaEscolhida, String municipioEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        List<Nucleo> listaNucleo = null;
        List<Rotina003> listaRespostaRotina003 = null;
        String listaIdNucleos = "";
        String municipio = "";
        if(!municipioEscolhida.equals("0")){
            municipio = "identificaEntradaMunicipio = '"+municipioEscolhida+"' and ";
        }

        try {
            listaRespostaRotina003 = em.createQuery("select r from  Rotina003 as r " +
                    " where "+municipio+"r.dadosValidos = '1' and r.identificaEntradaCoordenacao = :identificaEntradaCoordenacao and r.identificaEntradaEntrada = :identificaEntradaEntrada").setParameter("identificaEntradaCoordenacao", coordenacaoEscolhida).setParameter("identificaEntradaEntrada", entradaEscolhida).getResultList();

            for (Rotina003 rotina003 : listaRespostaRotina003) {
                rotina003.getListaFichas().size();
            }
        } finally {
            em.close();
        }


        return listaRespostaRotina003;
    }

    public List<Rotina003Ficha> obtemFichasByListaFichasId(String listaFichasId, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        List<Nucleo> listaNucleo = null;
        List<Rotina003Ficha> listaRespostaFichasRotina003 = null;
        String listaIdNucleos = "";

        try {
            listaRespostaFichasRotina003 = em.createQuery("select f from Rotina003Ficha as f " +
                    " where " + listaFichasId).getResultList();

        } finally {
            em.close();
        }


        return listaRespostaFichasRotina003;
    }

    public List<Rotina004> obtemNucleosByCoordenacaoAndEntradaAndRotina004(String coordenacaoEscolhida, String entradaEscolhida, String observacaoEscolhida, String municipioEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        List<Nucleo> listaNucleo = null;
        List<Rotina004> listaRespostaRotina004 = null;
        String listaIdNucleos = "";
        String municipio = "";
        if(!municipioEscolhida.equals("0")){
            municipio = "identificaEntradaMunicipio = '"+municipioEscolhida+"' and ";
        }

        try {
            if(coordenacaoEscolhida.equals("0")){
                listaRespostaRotina004 = em.createQuery("select r from  Rotina004 as r " +
                    " where "+municipio+"r.dadosValidos = '1' and r.nucleo.coordenacao = :coordenacaoEscolhida and r.nucleo.entrada = :entradaEscolhida " +
                    " order by r.nucleo.referencia").setParameter("coordenacaoEscolhida", coordenacaoEscolhida).setParameter("entradaEscolhida", entradaEscolhida).getResultList();
            }else{
                listaRespostaRotina004 = em.createQuery("select r from  Rotina004 as r " +
                    " where "+municipio+"r.dadosValidos = '1' and r.nucleo.coordenacao = :coordenacaoEscolhida and r.nucleo.entrada = :entradaEscolhida and r.identificaEntradaObservacao = :observacaoEscolhida" +
                    " order by r.nucleo.referencia").setParameter("coordenacaoEscolhida", coordenacaoEscolhida).setParameter("entradaEscolhida", entradaEscolhida).setParameter("observacaoEscolhida", observacaoEscolhida).getResultList();
            }
            /*
            for (Nucleo nucleo : listaNucleo) {
            listaIdNucleos += " or r.nucleo.id = " + nucleo.getId().toString();
            }


            listaRespostaRotina004 = em.createQuery("select r from rotina004 as r " +
            " where r.nucleo.id= 0 " + listaIdNucleos).getResultList();
             */


        } finally {
            em.close();
        }


        return listaRespostaRotina004;
    }

    public List<Rotina004V2> obtemNucleosByCoordenacaoAndEntradaAndRotina004V2(String coordenacaoEscolhida, String entradaEscolhida, String observacaoEscolhida, String municipioEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        List<Nucleo> listaNucleo = null;
        List<Rotina004V2> listaRespostaRotina004 = null;
        String listaIdNucleos = "";
        String municipio = "";
        if(!municipioEscolhida.equals("0")){
            municipio = "identificaEntradaMunicipio = '"+municipioEscolhida+"' and ";
        }

        try {
            if(coordenacaoEscolhida.equals("0")){
                listaRespostaRotina004 = em.createQuery("select r from  Rotina004V2 as r " +
                    " where "+municipio+"r.dadosValidos = '1' and r.nucleo.coordenacao = :coordenacaoEscolhida and r.nucleo.entrada = :entradaEscolhida " +
                    " order by r.nucleo.referencia").setParameter("coordenacaoEscolhida", coordenacaoEscolhida).setParameter("entradaEscolhida", entradaEscolhida).getResultList();
            }else{
                listaRespostaRotina004 = em.createQuery("select r from  Rotina004V2 as r " +
                    " where "+municipio+"r.dadosValidos = '1' and r.nucleo.coordenacao = :coordenacaoEscolhida and r.nucleo.entrada = :entradaEscolhida and r.identificaEntradaObservacao = :observacaoEscolhida" +
                    " order by r.nucleo.referencia").setParameter("coordenacaoEscolhida", coordenacaoEscolhida).setParameter("entradaEscolhida", entradaEscolhida).setParameter("observacaoEscolhida", observacaoEscolhida).getResultList();
            }
            /*
            for (Nucleo nucleo : listaNucleo) {
            listaIdNucleos += " or r.nucleo.id = " + nucleo.getId().toString();
            }


            listaRespostaRotina004 = em.createQuery("select r from rotina004 as r " +
            " where r.nucleo.id= 0 " + listaIdNucleos).getResultList();
             */


        } finally {
            em.close();
        }


        return listaRespostaRotina004;
    }

    public List<Rotina005> obtemNucleosByCoordenacaoAndEntradaAndRotina005(String coordenacaoEscolhida, String entradaEscolhida, String observacaoEscolhida, String municipioEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        List<Nucleo> listaNucleo = null;
        List<Rotina005> listaRespostaRotina005 = null;
        String listaIdNucleos = "(r.nucleo.id= 0";

        String municipio = "";
        if(!municipioEscolhida.equals("0")){
            municipio = "identificaEntradaMunicipio = '"+municipioEscolhida+"' and ";
        }

        try {
            listaNucleo = em.createQuery("select n from Nucleo as n " +
                    " where n.coordenacao = :coordenacaoEscolhida " +
                    " and n.entrada = :entradaEscolhida " +
                    " order by n.referencia").setParameter("coordenacaoEscolhida", coordenacaoEscolhida).setParameter("entradaEscolhida", entradaEscolhida).getResultList();

            for (Nucleo nucleo : listaNucleo) {
                listaIdNucleos += " or r.nucleo.id = " + nucleo.getId().toString();
            }

            if(observacaoEscolhida.equals("0")){
                listaRespostaRotina005 = em.createQuery("select r from Rotina005 as r " +
                    " where "+municipio+"r.dadosValidos = '1' and " + listaIdNucleos + ") ").getResultList();
            }else{
                listaRespostaRotina005 = em.createQuery("select r from Rotina005 as r " +
                    " where "+municipio+"r.identificaEntradaObservacao = :observacaoEscolhida and r.dadosValidos = '1' and " + listaIdNucleos + ") ").setParameter("observacaoEscolhida", observacaoEscolhida).getResultList();
            }
            



        } finally {
            em.close();
        }


        return listaRespostaRotina005;
    }

    public List<Rotina006ArcosOcupacionais> obtemNucleosByCoordenacaoAndEntradaAndRotina006(String coordenacaoEscolhida, String entradaEscolhida, String observacaoEscolhida, String municipioEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        List<Nucleo> listaNucleo = null;
        List<Rotina006ArcosOcupacionais> listaRespostaRotina006ArcosOcupacionais = null;
        String listaIdNucleos = "";

        String municipio = "";
        if(!municipioEscolhida.equals("0")){
            municipio = "identificaEntradaMunicipio = '"+municipioEscolhida+"' and ";
        }

        try {
            if(observacaoEscolhida.equals("0")){
                listaRespostaRotina006ArcosOcupacionais = em.createQuery("select r from Rotina006ArcosOcupacionais as r " +
                    " where "+municipio+"r.dadosValidos = '1' and r.identificaEntradaCoordenacao = :identificaEntradaCoordenacao and r.identificaEntradaEntrada = :identificaEntradaEntrada ").setParameter("identificaEntradaCoordenacao", coordenacaoEscolhida).setParameter("identificaEntradaEntrada", entradaEscolhida).getResultList();
            }else{
                listaRespostaRotina006ArcosOcupacionais = em.createQuery("select r from Rotina006ArcosOcupacionais as r " +
                    " where "+municipio+"r.dadosValidos = '1' and r.identificaEntradaCoordenacao = :identificaEntradaCoordenacao and r.identificaEntradaEntrada = :identificaEntradaEntrada and r.identificaEntradaObservacao = :observacaoEscolhida ").setParameter("identificaEntradaCoordenacao", coordenacaoEscolhida).setParameter("identificaEntradaEntrada", entradaEscolhida).setParameter("observacaoEscolhida", observacaoEscolhida).getResultList();
            }
        } finally {
            em.close();
        }


        return listaRespostaRotina006ArcosOcupacionais;
    }

    public List<Rotina007> obtemNucleosByCoordenacaoAndEntradaAndRotina007(String coordenacaoEscolhida, String entradaEscolhida, String observacaoEscolhida, String municipioEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        List<Rotina007> listaRespostaRotina007 = null;

        String municipio = "";
        if(!municipioEscolhida.equals("0")){
            municipio = "identificaEntradaMunicipio = '"+municipioEscolhida+"' and ";
        }

        try {
            if(observacaoEscolhida.equals("0")){
                listaRespostaRotina007 = em.createQuery("select r from Rotina007 as r " +
                    " where "+municipio+"r.dadosValidos = '1' and r.identificaEntradaCoordenacao = :identificaEntradaCoordenacao and r.identificaEntradaEntrada = :identificaEntradaEntrada ").setParameter("identificaEntradaCoordenacao", coordenacaoEscolhida).setParameter("identificaEntradaEntrada", entradaEscolhida).getResultList();
            }else{
                listaRespostaRotina007 = em.createQuery("select r from Rotina007 as r " +
                    " where "+municipio+"r.dadosValidos = '1' and r.identificaEntradaCoordenacao = :identificaEntradaCoordenacao and r.identificaEntradaEntrada = :identificaEntradaEntrada and r.identificaEntradaObservacao = :identificaEntradaObservacao ").setParameter("identificaEntradaCoordenacao", coordenacaoEscolhida).setParameter("identificaEntradaEntrada", entradaEscolhida).setParameter("identificaEntradaObservacao", observacaoEscolhida).getResultList();
            }
        } finally {
            em.close();
        }


        return listaRespostaRotina007;
    }

    public List<CeRotina001> obtemNucleosByCoordenacaoAndEntradaAndCeRotina001(String coordenacaoEscolhida, String entradaEscolhida, String observacaoEscolhida, String municipioEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        List<CeRotina001> listaRespostaCeRotina001 = null;

        String municipio = "";
        if(!municipioEscolhida.equals("0")){
            municipio = "identificaEntradaMunicipio = '"+municipioEscolhida+"' and ";
        }

        try {
            if(observacaoEscolhida.equals("0")){
                listaRespostaCeRotina001 = em.createQuery("select r from CeRotina001 as r " +
                    " where "+municipio+"r.dadosValidos = '1' and r.identificaEntradaCoordenacao = :identificaEntradaCoordenacao and r.identificaEntradaEntrada = :identificaEntradaEntrada ").setParameter("identificaEntradaCoordenacao", coordenacaoEscolhida).setParameter("identificaEntradaEntrada", entradaEscolhida).getResultList();
            }else{
                listaRespostaCeRotina001 = em.createQuery("select r from CeRotina001 as r " +
                    " where "+municipio+"r.dadosValidos = '1' and r.identificaEntradaCoordenacao = :identificaEntradaCoordenacao and r.identificaEntradaEntrada = :identificaEntradaEntrada and r.identificaEntradaObservacao = :identificaEntradaObservacao ").setParameter("identificaEntradaCoordenacao", coordenacaoEscolhida).setParameter("identificaEntradaEntrada", entradaEscolhida).setParameter("identificaEntradaObservacao", observacaoEscolhida).getResultList();
            }

        } finally {
            em.close();
        }


        return listaRespostaCeRotina001;
    }

    public List<CeRotina002> obtemNucleosByCoordenacaoAndEntradaAndCeRotina002(String coordenacaoEscolhida, String entradaEscolhida, String municipioEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        List<CeRotina002> listaRespostaCeRotina002 = null;

        String municipio = "";
        if(!municipioEscolhida.equals("0")){
            municipio = "identificaEntradaMunicipio = '"+municipioEscolhida+"' and ";
        }

        try {
            listaRespostaCeRotina002 = em.createQuery("select r from CeRotina002 as r " +
                    " where "+municipio+"r.dadosValidos = '1' and r.identificaEntradaCoordenacao = :identificaEntradaCoordenacao and r.identificaEntradaEntrada = :identificaEntradaEntrada ").setParameter("identificaEntradaCoordenacao", coordenacaoEscolhida).setParameter("identificaEntradaEntrada", entradaEscolhida).getResultList();

        } finally {
            em.close();
        }


        return listaRespostaCeRotina002;
    }

    public List<CeRotina003> obtemNucleosByCoordenacaoAndEntradaAndCeRotina003(String coordenacaoEscolhida, String entradaEscolhida, String observacaoEscolhida, String municipioEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        List<CeRotina003> listaRespostaCeRotina003 = null;

        String municipio = "";
        if(!municipioEscolhida.equals("0")){
            municipio = "identificaEntradaMunicipio = '"+municipioEscolhida+"' and ";
        }

        try {
            if(observacaoEscolhida.equals("0")){
                listaRespostaCeRotina003 = em.createQuery("select r from CeRotina003 as r " +
                    " where "+municipio+"r.dadosValidos = '1' and r.identificaEntradaCoordenacao = :identificaEntradaCoordenacao and r.identificaEntradaEntrada = :identificaEntradaEntrada ").setParameter("identificaEntradaCoordenacao", coordenacaoEscolhida).setParameter("identificaEntradaEntrada", entradaEscolhida).getResultList();
            }else{
                listaRespostaCeRotina003 = em.createQuery("select r from CeRotina003 as r " +
                    " where "+municipio+"r.dadosValidos = '1' and r.identificaEntradaCoordenacao = :identificaEntradaCoordenacao and r.identificaEntradaEntrada = :identificaEntradaEntrada and r.identificaEntradaObservacao = :identificaEntradaObservacao ").setParameter("identificaEntradaCoordenacao", coordenacaoEscolhida).setParameter("identificaEntradaEntrada", entradaEscolhida).setParameter("identificaEntradaObservacao", observacaoEscolhida).getResultList();
            }

        } finally {
            em.close();
        }


        return listaRespostaCeRotina003;
    }

    public List<String> obtemIrs(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        List<String> listaIrs = null;


        try {
            listaIrs = em.createQuery("select distinct n.ir from Nucleo as n ").getResultList();

        } finally {
            em.close();
        }


        return listaIrs;
    }

    public List<SelectItem> obtemNucleosByMunicipioGer(String municipioEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        List<SelectItem> listaNucleo = null;


        try {
            listaNucleo = em.createQuery("select n from Nucleo as n " +
                    " where n.municipio = :municipioEscolhida " +
                    " order by n.referencia").setParameter("municipioEscolhida", municipioEscolhida).getResultList();

        } finally {
            em.close();
        }


        return listaNucleo;
    }

    public List<Nucleo> obtemNucleosByMunicipio(String municipioEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        List<Nucleo> listaNucleo = null;


        try {
            listaNucleo = em.createQuery("select n from Nucleo as n " +
                    " where n.municipio = :municipioEscolhida " +
                    " order by n.referencia").setParameter("municipioEscolhida", municipioEscolhida).getResultList();

        } finally {
            em.close();
        }


        return listaNucleo;
    }

    public List<Nucleo> obtemNucleosByCoordenacaoAndEntrada(String coordenacaoEscolhida, String entradaEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        List<Nucleo> listaNucleo = null;


        try {
            listaNucleo = em.createQuery("select n from Nucleo as n " +
                    " where n.coordenacao = :coordenacaoEscolhida " +
                    " and n.entrada= :entradaEscolhida" +
                    " order by n.referencia")
                    .setParameter("entradaEscolhida", entradaEscolhida)
                    .setParameter("coordenacaoEscolhida", coordenacaoEscolhida).getResultList();

        } finally {
            em.close();
        }


        return listaNucleo;
    }
}
