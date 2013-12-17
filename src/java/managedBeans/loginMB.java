/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import entity.Usuario;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Kay
 */
@Named(value = "loginMB")
@RequestScoped

public class loginMB {

    @Inject LoginConversationMB loginConversation;
    
    private String username;
    private String password;
    
    @PersistenceContext(unitName = "SDLab2PU")
    private EntityManager em;
    
    @Resource
    private javax.transaction.UserTransaction utx;
    
    public loginMB() {
    }
  
    public void login(){
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        try {
            if (request.getRemoteUser() == null) {
                try {
                    request.login(username, password);
                    request.getRemoteUser();
                    this.loginConversation.beginConversation();
                    this.loginConversation.setUsername(username);
                    System.out.println(username);
                    redirect("/faces/usuario/index.xhtml?cid=".concat(this.loginConversation.getConnversation().getId().toString()));
                   // redirect("/faces/usuario/index.xhtml");
                } catch (ServletException e) {
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario y/o contraseña incorrecta", "Login inválido"));
                }
            }
            else {
                System.out.println("Error, Usuario ya conectado");
            }
        }
        catch (Exception e) {
            System.out.println("error(loginMB-login): "+e.getMessage());
        }
    }
    
    public String logout() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        if (request.getUserPrincipal()!= null) {
            try {
                request.logout();
                
                redirectLogin(request);
            } catch (ServletException e) {
                System.out.println("Ha ocurrido un error, no se ha podido desloguear" + e.getMessage());
                return "";
            }
        
        }
        System.out.println("mal el logout");
        return "";
    }
    public boolean isLogin(){
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();      
        if (request.getRemoteUser() == null) {
            return false;
        }
        else{
            return true;
        }
    }
    
    public void redirect(String page){
        ExternalContext extcon = FacesContext.getCurrentInstance().getExternalContext();
        try{
            extcon.redirect(extcon.getRequestContextPath() + page);
        }
        catch(IOException ex){
            System.out.println("No se ha podido redirigir a la página ".concat(page));            
        }
    }
    
    private void redirectLogin(HttpServletRequest request){
        ExternalContext extcon = FacesContext.getCurrentInstance().getExternalContext();
        String page = "";
        try{
            page = page.concat("/faces/index.xhtml");
            extcon.redirect(extcon.getRequestContextPath() + page);
        }
        catch(IOException ex){
            System.out.println("No se ha podido redirigir a la página ".concat(page));            
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
    
}

