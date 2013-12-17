/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import restBeans.factorialClient;

/**
 *
 * @author Kay
 */
@Named(value = "indexUsuarioMB")
@RequestScoped
public class indexUsuarioMB {

    private String base;
    private String resultado;
    private factorialClient fc;
    
    /**
     * Creates a new instance of indexUsuarioMB
     */
    public indexUsuarioMB() {
        this.fc = new factorialClient();
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
    
    
}
