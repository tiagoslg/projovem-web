/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projovem.bean;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;
import projovem.controller.InstrumentoController;
import projovem.dao.ColetaDadosDAO;
import projovem.entity.ColetaDados;
import projovem.entity.Usuario;
import projovem.vo.ResumoRespostas;

/**
 *
 * @author admprojovem
 */
public class MinhasRotinasBean {
    @Resource
    private UserTransaction utx;
    @PersistenceUnit(unitName = "projovemPU")
    private EntityManagerFactory emf;

    private List<ColetaDados> coletaDados = new ArrayList<ColetaDados>();
    private ColetaDadosDAO coletaDadosDAO = new ColetaDadosDAO();
    private List<ResumoRespostas> resumo  = new ArrayList<ResumoRespostas>();
    private InstrumentoController controller= new InstrumentoController();
    private ColetaDados coletaSelecionada = new ColetaDados();
    
    private Usuario usuarioLogado = new Usuario();

    private boolean renderedRespostas;

    public void exibirRespostas(){
        ColetaDados coleta =  new ColetaDados();
        coleta = coletaDadosDAO.getById(coletaSelecionada,emf);
        setResumo(controller.obterResumoDasRespostas(coleta));
        renderedRespostas = true;
    }
    
    public  MinhasRotinasBean(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        Object currentUser = session.getAttribute("currentUser");
        usuarioLogado = (Usuario) currentUser;
    }

    /**
     * @return the coletaDados
     */
    public List<ColetaDados> getColetaDados() {
        coletaDados = coletaDadosDAO.getByUsuario(usuarioLogado,emf);
        return coletaDados;
    }

    /**
     * @param coletaDados the coletaDados to set
     */
    public void setColetaDados(List<ColetaDados> coletaDados) {
        this.coletaDados = coletaDados;
    }

    /**
     * @return the resumo
     */
    public List<ResumoRespostas> getResumo() {
       
        
        return resumo;
    }

    /**
     * @param resumo the resumo to set
     */
    public void setResumo(List<ResumoRespostas> resumo) {
        this.resumo = resumo;
    }

    /**
     * @return the coletaSelecionada
     */
    public ColetaDados getColetaSelecionada() {
        return coletaSelecionada;
    }

    /**
     * @param coletaSelecionada the coletaSelecionada to set
     */
    public void setColetaSelecionada(ColetaDados coletaSelecionada) {
        this.coletaSelecionada = coletaSelecionada;
    }

    /**
     * @return the renderedRespostas
     */
    public boolean isRenderedRespostas() {
        return renderedRespostas;
    }

    /**
     * @param renderedRespostas the renderedRespostas to set
     */
    public void setRenderedRespostas(boolean renderedRespostas) {
        this.renderedRespostas = renderedRespostas;
    }

}
