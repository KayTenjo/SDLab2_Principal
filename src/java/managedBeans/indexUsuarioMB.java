/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import com.google.gson.Gson;
import java.util.Collection;
import javaClasses.listarArchivo;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import restBeans.factorialClient;
import restBeans.listFilesClient;

/**
 *
 * @author Kay
 */
@Named(value = "indexUsuarioMB")
@RequestScoped
public class indexUsuarioMB {

    private String base;
    private String resultado;
    private String nombre_usuario;
    private factorialClient fc;
    private Collection<listarArchivo> listaArchivos;
    private String oli;
    
    @Inject LoginConversationMB loginConversation;
    /**
     * Creates a new instance of indexUsuarioMB
     */
    @PostConstruct
    void init(){
        nombre_usuario= loginConversation.getUsername();
        listFilesClient lf = new listFilesClient();
        String lista = lf.listarArchivos(nombre_usuario);
        Gson gson = new Gson();
        listaArchivos = gson.fromJson(lista, Collection.class);
        oli = "http://localhost:8080/SDLab2_Archivos/webresources/download/kay/ppt";
    }
    public indexUsuarioMB() {
        
    }
    
    public void factorial(){
        System.out.println(this.base);
        System.out.println(this.fc.factorial(this.base));
        this.resultado = this.fc.factorial(this.base);
    }
    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public Collection<listarArchivo> getListaArchivos() {
        return listaArchivos;
    }

    public void setListaArchivos(Collection<listarArchivo> listaArchivos) {
        this.listaArchivos = listaArchivos;
    }

    public LoginConversationMB getLoginConversation() {
        return loginConversation;
    }

    public void setLoginConversation(LoginConversationMB loginConversation) {
        this.loginConversation = loginConversation;
    }

    public String getOli() {
        return oli;
    }

    public void setOli(String oli) {
        this.oli = oli;
    }
    
    
}
