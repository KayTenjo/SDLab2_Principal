/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import entity.Usuario;
import java.security.MessageDigest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sessionBeans.crearUsuarioSBLocal;

/**
 *
 * @author Kay
 */
@Named(value = "crearUsuarioMB")
@RequestScoped
public class crearUsuarioMB {
    
    @EJB
    private crearUsuarioSBLocal crearUsuarioSB;
    
   
    private String username;
    private String password;
    private String mensaje;
   
    
    public crearUsuarioMB() {
    }

    public void crearUsuario(){
        try {
            String passMD5= stringToMD5(password);
            crearUsuarioSB.crearUsuario(username, passMD5);
        } catch (Exception ex) {
            Logger.getLogger(crearUsuarioMB.class.getName()).log(Level.SEVERE, null, ex);
            mensaje ="Error en la creación del mensaje";
        }
        
         mensaje ="Usuario registrado con éxito";
    }
    
 
    
   public String stringToMD5(String clear) throws Exception {
    MessageDigest md = MessageDigest.getInstance("MD5");
    byte[] b = md.digest(clear.getBytes());

    int size = b.length;
    StringBuffer h = new StringBuffer(size);
    for (int i = 0; i < size; i++) {
    int u = b[i] & 255;
    if (u < 16) {
    h.append("0").append(Integer.toHexString(u));
    } else {
    h.append(Integer.toHexString(u));
    }
    }
    return h.toString();
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

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
}
