/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grid;

import com.aws.codestar.projecttemplates.Board;
import com.aws.codestar.projecttemplates.Square;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.spi.JsonProvider;
import javax.websocket.Session;

/**
 *
 * @author Ethgar
 */
public class SessionHandler {
    private final Set<Session> sessions = new HashSet();
    private final Board gameBoard = new Board();
    
    public void addSession(Session session) 
    {
        sessions.add(session);
        JsonObject addMessage = createMessage(gameBoard);
        sendToSession(session, addMessage);
        
    }
    
    private JsonObject createAddMessage(Board B) {
        JsonObjectBuilder builder = Json.createObjectBuilder();
        for(Square[] row: B.getBoard())
        {
            
        }
                
        JsonObject addMessage = builder.build();
        return addMessage;
    }
    
    public void removeSession(Session session) 
    {
        sessions.remove(session);
    }
    
    private void sendToAllConnectedSessions(JsonObject message) 
    {
        for (Session session : sessions) 
        {
            sendToSession(session, message);
        }
    }

    private void sendToSession(Session session, JsonObject message) 
    {
        try 
        {
            session.getBasicRemote().sendText(message.toString());
        } catch (IOException ex) 
        {
            sessions.remove(session);
            Logger.getLogger(SessionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    
     
    
}
