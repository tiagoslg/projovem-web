package projovem.filter;

import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;
import projovem.entity.Usuario;

public class AuthorizationListener implements PhaseListener {

    public void afterPhase(PhaseEvent event) {

        FacesContext facesContext = event.getFacesContext();
        String currentPage = facesContext.getViewRoot().getViewId();

        boolean isLoginPage = false;
        if (currentPage.equals("/pages/login.xhtml")) {
            isLoginPage = true;
        }


        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        Object currentUser = session.getAttribute("currentUser");
        NavigationHandler nh = facesContext.getApplication().getNavigationHandler();

        if (!isLoginPage && currentUser == null) {

            nh.handleNavigation(facesContext, null, "loginPage");
        } else {
            if (currentPage.equals("/caed")) {
                nh.handleNavigation(facesContext, null, "utilitarios");
            }
            if (currentUser != null) {
                currentPage = facesContext.getViewRoot().getViewId();
                if (!currentPage.equals("/utilitario.xhtml")) {
                    Usuario usuarioLogado = (Usuario) currentUser;
                    if (usuarioLogado.getSenha().equals(String.valueOf(usuarioLogado.getCpf().hashCode()))) {
                        nh.handleNavigation(facesContext, null, "utilitarios");
                        String message = "Sua senha não poderá mais ser igual ao seu CPF. É necessário altera-la.";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                    }
                }
            }
        }
    }

    public void beforePhase(PhaseEvent event) {
    }

    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
}
