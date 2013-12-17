/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import javax.inject.Named;
import javax.enterprise.context.ConversationScoped;
import java.io.Serializable;
import javax.enterprise.context.Conversation;
import javax.inject.Inject;

/**
 *
 * @author Kay
 */
@Named(value = "loginConversation")
@ConversationScoped
public class LoginConversationMB implements Serializable {

    @Inject Conversation conversation;
    
    private String username;

    
    public LoginConversationMB() {
    }
     public void beginConversation(){
        if (conversation.isTransient()){
            conversation.begin();
        }
    }
    public void endConversation(){
        if(!conversation.isTransient()){
            conversation.end();
        }}
    public Conversation getConnversation() {
        return conversation;
    }

    public void setConnversation(Conversation conversation) {
        this.conversation = conversation;
    }

  

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
     
}
