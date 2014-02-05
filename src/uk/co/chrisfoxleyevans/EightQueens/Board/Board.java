package uk.co.chrisfoxleyevans.EightQueens.Board;

/**
 * 
 * @author Chris Foxley-Evans
 * This is a class that models a NxN grid 
 * could be used for games such as Chess and Tic-Tac-Toe
 * 
 */

public class Board
{
	//*********** Instance Variables ***********/ 
	
	/**
	 * Variable to hold the number of rows in the Board 
	 */
	private int numRows;
	
	/**
	 * Variable to hold the number of columns in the Board
	 */
	private int numCols;
	
	/**
	 * Variable to hold the number of the current player 
	 */
	private int currentPlayer;
	
	/**
	 * Variable to hold the default String used to fill the Board 
	 */
	private String defString;
	
	/**
	 * Variable to hold the actual Board  
	 */
	protected String[][] board;
	
	//*********** Constructors ***********/
	
	/**
	 * Default constructor will set numRows and numCols to 2 and defChar to "-" 
	 */
	public Board()
	{
		this.numRows = 2;
		this.numCols = 2;
		this.defString = "--";
		this.board = new String[2][2];
		this.initBoard();
	}
	
	/**
	 * Additional constructor that constructs a Board using the values provided
	 * @param rows The number of rows that the Board is to have
	 * @param cols The number of columns that the Board is to have
	 * @param marker The default String used to fill all of the Board cells
	 */
	public Board(int rows, int cols, String marker)
	{
		this.numRows = rows;
		this.numCols = cols;
		this.defString = marker;
		this.board = new String[this.numRows][this.numCols];
		this.initBoard();
	}

	//*********** Public Methods ***********/
	
	/**
	 * Method used to print to current state of the Board to the console 
	 */
	public void printBoard()
	{
		//code to print the game board
		for (int i = 0; i < this.numRows; i++)
		{
			for (int j = 0; j <  this.numCols; j++)
				System.out.print(this.board[i][j] + " ");		
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * Method used to initialize the Board 
	 */
	public void initBoard()
	{
		//code to set up the game board
		for (int i= 0; i < this.numRows; i++)
			for (int j = 0; j < this.numCols; j++)
				this.board[i][j] = this.defString;
	}
	
	/**
	 * Method used to check if the provided coord is valid
	 * @param row The row Number of the coord
	 * @param col The column number of the coord
	 * @return True is returned provided coord is valid false if not
	 */
	public boolean isCoordValid(int row, int col)
	{
		//code to check if the corod is valid
		if (row > (this.numRows - 1) || col > (this.numCols - 1))
		{
			return false;
		}
		else
			return true;
	}
	
	/**
	 * Method used to check if a cell is already occupied
	 * @param row The row number of the coord
	 * @param col The column number of the coord
	 * @return If the cell is occupied returns true else false
	 */
	public boolean isOccupied(int row, int col)
	{
		//code to check if the cell is occupied
		if (board[row][col] != this.defString)
			return true;
		else 
			return false;
	}
	
	/**
	 * Method used to switch from player 1/2
	 */
	public void switchPlayers()
	{
		//code to switch player
		if ( this.currentPlayer == 1 )
			this.currentPlayer = 2;
		else
			this.currentPlayer = 1;
	}
	
	/**
	 * Method used to set a square to the String marker
	 * @param row The row number of the coord
	 * @param col The column number of the coord
	 * @param marker The marker that is used to fill the cell
	 * @return Returns true if the marker has been set else false
	 */
	public boolean setCell(int row, int col, String marker)
	{
		//code to set a cell to a given value
		if (isCoordValid(row, col) && !isOccupied(row, col))
		{
			this.board[row][col] = marker;
			return true;
		}
		else
		{
			System.out.println(row + "," + col + " Cannot Be Set At This Time...");
			return false;
		}
		
	}
	
	/**
	 * Method used to get the content of a cell
	 * @param row The row number of the coord
	 * @param col The column number of the coord
	 * @return
	 */
	public String getCell(int row, int col)
	{
		//code to get the content of given cell
		return this.board[row][col];
	}
	
	/**
	 * Method used to get the number of rows on the Board
	 * @return The number of rows on the Board
	 */
	public int getRows()
	{
		//code to get the number of rows for this board
		return this.numRows;
	}
	
	/**
	 * Method used to get the number of columns on the Board
	 * @return the number of columns on the Board
	 */
	public int getCols()
	{//code to get the number of cols for this board
		return this.numCols;
	}
	
	/**
	 * Method used to get the default string
	 * @return The default string being used on the board
	 */
	public String getDefString()
	{
		//code to get the default string for this board
		return this.defString;
	}
	
	/**
	 * Method used to get current player
	 * @return The value of the current player
	 */
	public int getCurrentPlayer()
	{
		//code to get the current player
		return this.currentPlayer;
	}
}
