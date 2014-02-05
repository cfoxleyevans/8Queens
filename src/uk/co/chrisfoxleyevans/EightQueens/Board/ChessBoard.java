package uk.co.chrisfoxleyevans.EightQueens.Board;

/**
 * 
 * @author Chris Foxley-Evans
 * This is a class that will model a chess board
 * will include methods that will make it useful for applications around the 
 * eight queens problem
 *
 */

public class ChessBoard extends Board
{	
	//*********** Instance Variables ***********/ 
	
	/**
	 * Variable to hold the number of pieces already placed
	 */
	private int pieceNum = 0;	
	
	protected int gameType = 0;
	
	//*********** Constructors ***********/
	
	public ChessBoard()
	{
		super(8, 8, "-");
		this.initBoard();		
	}

	//*********** Public Methods ***********/
	
	/**
	 * Method used to place a rook on the board
	 * @param row The row number of the coord
	 * @param col The column number of the coord
	 * @return true if placement successful
	 */
	public boolean placeRook(int row, int col)
	{
		//code to place a rook on the board and add its possible moves
		if (this.setCell(row, col, "R"))
		{	
			//add horizontal rook moves for this placement
			for (int i = 0 ; i < this.getCols(); i++)
			{
				this.board[row][i] = "R";
			}
			//add vertical moves for this placement
			for (int i = 0; i < this.getRows(); i++)
			{
				this.board[i][col] = "R";
			}
			pieceNum++;
			return true;
		}
		else 
			return false;
	}
	
	/**
	 * Method used to place a bishop on the board
	 * @param row The row number of the coord
	 * @param col The column number of the coord
	 * @return true if placement successful
	 */
	public boolean placeBishop(int row, int col)
	{
		//code to place a bishop on the board and add its possible moves
		if (this.setCell(row, col, "B"))
		{
			//up left
			int startRow = row;
			int startCol = col;
			for(;row > -1 && col > -1; row--, col--) 
			{
				this.board[row][col] = "B";
			}
			
			//down left
			row = startRow;
			col = startCol;
			for(;row < this.getRows() && col > -1; row++, col--) 
			{
				this.board[row][col] = "B";
			}
			
			//up right
			row = startRow;
			col = startCol;
			for(;row > -1  && col < this.getCols(); row--, col++) 
			{
				this.board[row][col] = "B";
			}
			
			//down right
			row = startRow;
			col = startCol;
			for(;row < this.getRows() && col < this.getCols(); row++, col++) 
			{
				this.board[row][col] = "B";
			}

			pieceNum++;
		}
		return true;
	}
	
	/**
	 * Method used to place a queen on the board
	 * @param row The row number of the coord
	 * @param col The column number of the coord
	 * @return true if placement successful
	 */
	public boolean placeQueen(int row, int col)
	{
		//code to place a queen on the board and add its possible moves
		if (this.setCell(row, col, "Q"))
		{
			int startRow = row;
			int startCol = col;
			
			//add horizontal rook moves for this placement
			for (int i = 0 ; i < this.getCols(); i++)
			{
				this.board[row][i] = "Q";
			}
			
			//add vertical moves for this placement
			for (int i = 0; i < this.getRows(); i++)
			{
				this.board[i][col] = "Q";
			}
			
			//up left
			for(;row > -1 && col > -1; row--, col--) 
			{
				this.board[row][col] = "Q";
			}
			
			//down left
			row = startRow;
			col = startCol;
			for(;row < this.getRows() && col > -1; row++, col--) 
			{
				this.board[row][col] = "Q";
			}
			
			//up right
			row = startRow;
			col = startCol;
			for(;row > -1  && col < this.getCols(); row--, col++) 
			{
				this.board[row][col] = "Q";
			}
			
			//down right
			row = startRow;
			col = startCol;
			for(;row < this.getRows() && col < this.getCols(); row++, col++) 
			{
				this.board[row][col] = "Q";
			}

		}
		pieceNum++;
		return true;
	}

	/**
	 * Method used to check if the board is full
	 * @return returns true if board is full false if not
	 */
	public boolean boardFull()
	{
		//code to check if the board is full
		for (int i = 0; i < this.getRows(); i++)
			for (int j = 0; j < this.getCols(); j++)
			{
				if(this.board[i][j] == this.getDefString())
					return false;			
			}
		return true;
	}
		
	/**
	 * Method used to get the current number of pieces
	 * @return the current number of pieces that have been placed on the board
	 */
	public int getPieceNum()
	{
		//code to get the number of pieces that have been placed on the board
		return this.pieceNum;
	}
	
	/**
	 * Method used the set the number of pieces that have been placed on the board
	 * @param x The value to be set
	 */
	public void setPieceNum(int x)
	{
		//code to set the number of pieces that have been placed on the board
		this.pieceNum = x;
	}
	
	/**
	 * Method used to get the current game type
	 * @return the current game type
	 */
	public int getGameType()
	{
		//code to get the type of game that is currently being played
		return this.gameType;
	}

	/**
	 * Method used to set the current game type
	 * @param x the game that is to be set
	 */
	public void setGameType(int x)
	{
		//code to set the type of game that is currently being played
		this.gameType = x;
	}
}