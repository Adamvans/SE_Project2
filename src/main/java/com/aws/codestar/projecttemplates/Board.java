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
public class Board 
{
    private int x;
    private int y;
    private int indexX;
    private int indexY;
    boolean clickEvent;
    boolean runGame;
    Square gameBoard [][];
    
    //default constructor
    public Board()
    {
        gameBoard = new Square[22][22];
        clickEvent = false;
        runGame = false;
        for (int i = 0; i < 22; i++)
        {
            for (int j = 0; j < 22; j++)
            {
                gameBoard[i][j] = new Square();
                if (i == 0 || i == 21 || j == 0 || j == 21)
                {
                    gameBoard[i][j].isEdge();
                }
            }
        }
    }
    
    //on click, pass in x and y of mouse
    public void setPosition (int x, int y)
    {
        this.x = x;
        this.y = y;
        //assume that it is an on click
        translateToIndex(x, y);
         clickEvent = true;
        if (!runGame)
        {
            runGame = true;
            runGame();
        }
    }
   
    //main run method
    private void runGame()
    {
        Square temp [][] = new Square[22][22];
        while (runGame)
        {
            //copy temp
            for (int i = 0; i < 22; i++)
            {
                for (int j = 0; j < 22; i++)
                {
                    temp [i][j] = gameBoard[i][j];
                }
            }
            
        }//while
    }
    
    //covert x/y of the mouse to the array index
    private void translateToIndex (int x, int y)
    {
        //integer division should drop the remainder
        indexX = x / 10;
        indexY = y / 10;
       
    }
    
    //sets color of the square
    private void setColor () // do not call unless translateToIndex has been run
    {
        if (gameBoard[indexX][indexY].isEdge())
        {
            return;
        } 
    }
    
    //tells you if a square should die or not
    private boolean shouldDie(int x, int y)
    {
        int neighbors = 0;
        
        if(gameBoard[x+1][y].isSelected())
        {
            neighbors++;
        }
        if(gameBoard[x-1][y].isSelected())
        {
            neighbors++;
        }
        if(gameBoard[x][y+1].isSelected())
        {
            neighbors++;
        }
        if(gameBoard[x][y-1].isSelected())
        {
            neighbors++;
        }
        
        if(neighbors > 1 && neighbors < 4)
        {
           return false; 
        }
        return true;        
    }
}
