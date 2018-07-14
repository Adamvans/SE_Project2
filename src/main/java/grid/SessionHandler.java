/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grid;

import com.aws.codestar.projecttemplates.Board;
import com.aws.codestar.projecttemplates.Square;
import java.io.IOException;
import java.math.BigDecimal;
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
        JsonObject addMessage = createMessage();
        sendToSession(session, addMessage); 

    }
    
    private JsonObject createMessage() {
        JsonObjectBuilder builder = Json.createObjectBuilder();
        for(int i = 1; i < 21; i++)
            {
            for(int j = 1; j < 21; j++)
            {
                builder.add("color", gameBoard.getSquare(i, j).getColor());
            }
        }
                
        JsonObject addMessage = builder.build();
        return addMessage;
    }
    
    public void updateBoard (int x, int y, String color)
    {

        gameBoard.setPosition(x, y, color);
    }
    
    public void startStop (String flag)
    {
        if (flag.equals("start"))
        {
          gameBoard.startStopGame(true);
          gameBoard.runGame();
        }
        else if (flag.equals("stop"))
        {
            gameBoard.startStopGame(false);
        }
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
