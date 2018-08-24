/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.nucleo;

import java.io.Serializable;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;
import projovem.controller.InstrumentoController;
import projovem.dao.NucleoDAO;
import projovem.entity.Usuario;
import projovem.rotinas.apoio.LocalReferenciaVO;

/**
 *
 * @author admprojovem
 */
public class CadastraNucleoBean implements Serializable {

    @Resource
    private UserTransaction utx;
    @PersistenceUnit(unitName = "projovemPU")
    private EntityManagerFactory emf;
    private InstrumentoController controller = new InstrumentoController();
    private Nucleo nucleo = new Nucleo();
    private NucleoDAO nucleoDAO = new NucleoDAO();
    private LocalReferenciaVO local = new LocalReferenciaVO();

    public String gravar() {
        Usuario currentUser = controller.obterUsuarioLogado();
        
        nucleo.setUsuario(currentUser);
        nucleo.setIr(currentUser.getIr());
        nucleoDAO.saveNucleo(nucleo, emf, utx);
        return "nucleoSalvo";
    }

    public Nucleo getNucleo() {
        return nucleo;
    }

    public void setNucleo(Nucleo nucleo) {
        this.nucleo = nucleo;
    }

    /**
     * @return the local
     */
    public LocalReferenciaVO getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(LocalReferenciaVO local) {
        this.local = local;
    }
}
