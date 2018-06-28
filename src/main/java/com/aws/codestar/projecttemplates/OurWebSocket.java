/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.codestar.projecttemplates;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author dexter
 */
public class OurWebSocket 
{

       
    public static void main (String [] args)
    {
           ServerSocket s;
           try {
               s = new ServerSocket (8189);
               Socket incoming = s.accept();
               
               /*everything the server sends to the output stream becomes the
               input to the client program and the output from the client ends up
               in the server input stream*/
               InputStream inStream = incoming.getInputStream();
               OutputStream outStream = incoming.getOutputStream();
               
               Scanner in = new Scanner (inStream, "UTF-8");
               PrintWriter out = new PrintWriter (new OutputStreamWriter (outStream, "UTF-8"), true);
               
             //may need handshaking
               
               incoming.close();
           } catch (IOException ex) {
               Logger.getLogger(OurWebSocket.class.getName()).log(Level.SEVERE, null, ex);
           }
        
    }
      

}
