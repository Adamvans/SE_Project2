package grid;



import java.io.IOException;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.AsyncContext;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


/**
 *
 * @author Ethgar
 */

@ServerEndpoint("/WebSoc")
public class WebSocket{
   private static int cnt = 0;
   
   @Inject
   private SessionHandler sessionH;
   
   public WebSocket(){}
   
   public int getCount()
   {
       return cnt;
   }
   
   public void addC()
   {
       cnt++;
   }
   
    @OnOpen
    public void open(Session session) throws IOException 
    {  
        sessionH.addSession(session);
    }

    @OnClose
    public void close(Session session) 
    {
        sessionH.removeSession(session);
    }
    
    @OnError
    public void onError(Throwable error) 
    {
        Logger.getLogger(WebSocket.class.getName()).log(Level.SEVERE, null, error);
    }
    
    
    @OnMessage
    public void handleMessage(String message, Session session) throws IOException 
    {
        JsonReader reader = Json.createReader(new StringReader(message) {
            JsonObject jsonMessage = reader.readObject();

            if ("add".equals(jsonMessage.getString("action"))) {
                Device device = new Device();
                device.setName(jsonMessage.getString("name"));
                device.setDescription(jsonMessage.getString("description"));
                device.setType(jsonMessage.getString("type"));
                device.setStatus("Off");
                sessionH.addDevice(device);
            }

            if ("remove".equals(jsonMessage.getString("action"))) {
                int id = (int) jsonMessage.getInt("id");
                sessionH.removeDevice(id);
            }

            if ("toggle".equals(jsonMessage.getString("action"))) {
                int id = (int) jsonMessage.getInt("id");
                sessionH.toggleDevice(id);
            }
        }
    }
}
