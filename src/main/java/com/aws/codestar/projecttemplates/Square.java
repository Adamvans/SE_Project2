/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.codestar.projecttemplates;

/**
 *
 * @author dexter
 */
public class Square 
{
    private boolean selected;
    private boolean isEdge;
    private String color;
    
    Square()
    {
        selected = false;
        isEdge = false;
        color = "white";
    }
    
    public void setColor(String newColor)
    {
        color = newColor;
    }
    public String getColor ()
    {
        return color;
    }
    public boolean getStatus()
    {
        return selected;
    }
    public void selectSquare ()
    {
        selected = true;
    }
    
    public void deselectSquare ()
    {
        selected = false;
    }
    
    public boolean isSelected()
    {
        return selected;
    }
    
    public void setAsEdge ()
    {
        isEdge = true;
    }
    
    public boolean isEdge ()
    {
        return isEdge;
    }
}
