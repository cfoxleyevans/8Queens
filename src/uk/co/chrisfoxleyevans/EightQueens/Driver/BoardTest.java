package uk.co.chrisfoxleyevans.EightQueens.Driver;
import uk.co.chrisfoxleyevans.EightQueens.Board.GUI.GUI;

/**
 * 
 * @author Chris Foxley-Evans
 * Class that instants a new GUI object so that the game can be played
 * @param args Any arguments that have to be passed to the program from the console
 * 
 */

public class BoardTest
{
	public static void main(String[] args)
	{
		//create new instance of GUI and initialize it
		GUI g1 = new GUI();
		g1.initGraphicBoard();
	}
}