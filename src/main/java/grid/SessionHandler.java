/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grid;

import com.aws.codestar.projecttemplates.Board;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.json.JsonObject;

/**
 *
 * @author Ethgar
 */
public class SessionHandler {
    private final Set sessions = new HashSet();
    private final Board current = new Board();
    private final Board next = new Board();
    
    
   
    
     public void addSession(javax.websocket.Session session) {
        sessions.add(session);
        
    }
    
}
