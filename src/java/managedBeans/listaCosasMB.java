/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Kay
 */
@Named(value = "listaCosasMB")
@RequestScoped
public class listaCosasMB {
    
@Inject LoginConversationMB loginConversation;
   
private String username;

    public listaCosasMB() {
    }
    
    @PostConstruct
    void init(){
        username= loginConversation.getUsername();
    }
    
    /*    public void printUsername(){
     * System.out.println(username);
     * }
     */
    public LoginConversationMB getLoginConversation() {
        return loginConversation;
    }

    public void setLoginConversation(LoginConversationMB loginConversation) {
        this.loginConversation = loginConversation;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
