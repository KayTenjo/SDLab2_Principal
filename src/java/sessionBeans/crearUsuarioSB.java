/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entity.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import managedBeans.crearUsuarioMB;

/**
 *
 * @author Kay
 */
@Stateless
public class crearUsuarioSB implements crearUsuarioSBLocal {
    
    @PersistenceContext(unitName = "SDLab2PU")
    private EntityManager em;
    
    

    public void persist(Object object) {
        em.persist(object);
    }

    public void crearUsuario(String username, String password){
    
    Usuario newUser = new Usuario();
   
            newUser.setUsuarioUsername(username);
            newUser.setUsuarioPassword(password);
            newUser.setUsuarioRol("Usuario");
    
    em.persist(newUser);
    em.flush();

    }
    
    }
    

