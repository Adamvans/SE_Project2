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
    
    Square()
    {
        selected = false;
        isEdge = false;
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
