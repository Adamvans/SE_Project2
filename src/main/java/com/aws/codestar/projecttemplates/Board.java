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
    boolean runGame;
    Square gameBoard [][];
    
    public Square[][] getBoard()
    {
        return gameBoard;
    }
    
    public Square getSquare(int x, int y)
    {
        return gameBoard[x][y];
    }
    //default constructor
    public Board()
    {
        gameBoard = new Square[22][22];
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
    
    public void startStopGame (boolean flag)
    {
        runGame = flag;
    }
    //on click, pass in x and y of mouse
    public void setPosition (int x, int y, String color)
    {
        this.x = x;
        this.y = y;
        //assume that it is an on click
        translateToIndex(x, y);
        if (gameBoard[indexX][indexY].isSelected())
        {
            gameBoard[indexX][indexY].deselectSquare();
            gameBoard[indexX][indexY].setColor("white");
        }
        else if (!gameBoard[indexX][indexY].isSelected() &&!gameBoard[indexX][indexY].isEdge())
        {
            gameBoard[indexX][indexY].selectSquare();
            gameBoard[indexX][indexY].setColor(color);
        }
    }
   
    //main run method
    public void runGame()
    {    
        Square temp [][] = new Square[22][22];
        while (runGame)
        {
            try        
            {
                Thread.sleep(500);
            } 
            catch(InterruptedException ex) 
            {
                Thread.currentThread().interrupt();
            }
            
            //copy temp
            for (int i = 1; i < 21; i++) //1 and 21 to skip the edges
            {
                for (int j = 1; j < 21; i++)
                {
                    temp [i][j] = gameBoard[i][j];
                }
            }            
            
            for (int i = 1; i < 21; i++)
            {
                for (int j = 1; j < 21; j++)
                {
                    if (temp[i][j].isSelected())
                    {
                       if (shouldDie (i,j))
                       {
                           temp[i][j].deselectSquare();
                       }
                    }
                    else //not selected
                    {
                        if(shouldLive(i,j))
                        {
                            temp[i][j].selectSquare();
                            setIntersectColor(i,j);
                        }
                    }
                }//inner for
            }//outer for
            
            //copy temp back to the game board
            for (int i = 1; i < 21; i++)
            {
                for (int j = 1; j < 21; i++)
                {
                    gameBoard [i][j] = temp[i][j];
                }
            }
        }//while
    }
    
    //covert x/y of the mouse to the array index
    private void translateToIndex (int x, int y)
    {
        //integer division should drop the remainder
        indexX = (x / 10);
        indexY = (y / 10);
        indexX++;
        indexY++;
       
    }
    
    //sets color of the square
    public void setIntersectColor (int x, int y) // do not call unless translateToIndex has been run
    {
        if (gameBoard[x][y].isEdge())
        {
            return;
        } 
        boolean red = false;
        boolean yellow = false; 
        boolean blue = false;
        String color = "";
        if(gameBoard[x+1][y].isSelected())
        {
           color = gameBoard[x+1][y].getColor();
           if (color.equalsIgnoreCase("red"))
                red = true;
           if (color.equalsIgnoreCase("blue"))
                blue = true;
            if (color.equalsIgnoreCase("yellow"))
                yellow = true;
        }
        if(gameBoard[x-1][y].isSelected())
        {
            color = gameBoard[x-1][y].getColor();
           if (color.equalsIgnoreCase("red"))
                red = true;
           if (color.equalsIgnoreCase("blue"))
                blue = true;
            if (color.equalsIgnoreCase("yellow"))
                yellow = true;
        }
        if(gameBoard[x][y+1].isSelected())
        {
             color = gameBoard[x][y+1].getColor();
           if (color.equalsIgnoreCase("red"))
                red = true;
           if (color.equalsIgnoreCase("blue"))
                blue = true;
            if (color.equalsIgnoreCase("yellow"))
                yellow = true;
        }
        if(gameBoard[x][y-1].isSelected())
        {
             color = gameBoard[x][y-1].getColor();
           if (color.equalsIgnoreCase("red"))
                red = true;
           if (color.equalsIgnoreCase("blue"))
                blue = true;
            if (color.equalsIgnoreCase("yellow"))
                yellow = true;
        }
        
         if(gameBoard[x-1][y+1].isSelected())
        {
             color = gameBoard[x-1][y+1].getColor();
           if (color.equalsIgnoreCase("red"))
                red = true;
           if (color.equalsIgnoreCase("blue"))
                blue = true;
            if (color.equalsIgnoreCase("yellow"))
                yellow = true;
        }
        if(gameBoard[x-1][y-1].isSelected())
        {
             color = gameBoard[x-1][y-1].getColor();
           if (color.equalsIgnoreCase("red"))
                red = true;
           if (color.equalsIgnoreCase("blue"))
                blue = true;
            if (color.equalsIgnoreCase("yellow"))
                yellow = true;
        }
        if(gameBoard[x+1][y+1].isSelected())
        {
             color = gameBoard[x+1][y+1].getColor();
           if (color.equalsIgnoreCase("red"))
                red = true;
           if (color.equalsIgnoreCase("blue"))
                blue = true;
            if (color.equalsIgnoreCase("yellow"))
                yellow = true;
        }
        if(gameBoard[x+1][y-1].isSelected())
        {
             color = gameBoard[x+1][y-1].getColor();
           if (color.equalsIgnoreCase("red"))
                red = true;
           if (color.equalsIgnoreCase("blue"))
                blue = true;
            if (color.equalsIgnoreCase("yellow"))
                yellow = true;
        }
        
        if (red)
        {
            gameBoard[x][y].setColor("red");
        }
        if (blue)
        {
             gameBoard[x][y].setColor("blue");
        }
        if (yellow)
        {
         gameBoard[x][y].setColor("yellow");
        }
        if (red && yellow)
        {
             gameBoard[x][y].setColor("orange");
        }
        if (red && blue)
        {
            gameBoard[x][y].setColor("purple");
        }
        if (blue && yellow)
        {
            gameBoard[x][y].setColor("green");
        }
        if (blue && red && yellow)
        {
            gameBoard[x][y].setColor("brown");
        }
            
    }
    
    //tells you if a square should die or not
    private boolean shouldDie(int x, int y)
    {
        int neighbors = 0;
        
        //check if it is an edge
        if (gameBoard[x][y].isEdge())
        {
            return false;
        }
        
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
        
        if(gameBoard[x-1][y+1].isSelected())
        {
            neighbors++;
        }
        if(gameBoard[x-1][y-1].isSelected())
        {
            neighbors++;
        }
        if(gameBoard[x+1][y+1].isSelected())
        {
            neighbors++;
        }
        if(gameBoard[x+1][y-1].isSelected())
        {
            neighbors++;
        }
        
        if(neighbors > 1 && neighbors < 4)
        {
           return false; 
        }
        return true;        
    }
    
    private boolean shouldLive(int x, int y)
    {
        int neighbors = 0;
        
        //check if it is an edge
        if (gameBoard[x][y].isEdge())
        {
            return false;
        }
        
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
        
         if(gameBoard[x-1][y+1].isSelected())
        {
            neighbors++;
        }
        if(gameBoard[x-1][y-1].isSelected())
        {
            neighbors++;
        }
        if(gameBoard[x+1][y+1].isSelected())
        {
            neighbors++;
        }
        if(gameBoard[x+1][y-1].isSelected())
        {
            neighbors++;
        }
        if(neighbors > 3)
        {
           return true; 
        }
        return false;
    }
}
