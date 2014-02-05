package uk.co.chrisfoxleyevans.EightQueens.Board.GUI;

/**
 * 
 * @author Chris Foxley-Evans
 * This is a GUI for the coursework based on the eight queens problem
 * 
 */

import javax.swing.*;

import uk.co.chrisfoxleyevans.EightQueens.Board.ChessBoard;


import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener
{
	//*********** Instance Variables ***********/
	
	/**
	 * Variable to hold the current state of the board in memory 
	 */
	private ChessBoard gameBoard = new ChessBoard();
	
	/**
	 * Component to hold the messages displayed to the user
	 */
	private JTextField messagesTextField;
	
	/**
	 * Component to hold the game info text
	 */
	private JTextArea gameinfoTextArea;
	
	/**
	 * Component for the games reset button
	 */
	private JButton resetBtn;
	
	/**
	 * component for the games rooks button
	 */
	private JButton rooksBtn;
	
	/**
	 * component for the games bishops button
	 */
	private JButton bishopsBtn;
	
	/**
	 * component for the games queen button
	 */
	private JButton queensBtn;
	
	/**
	 * Variable that will hold the array of buttons that will
	 * Illustrate the current state of the game board 
	 */
	private JButton graphicBoard[][];	
	
	/**
	 * Variable that will hold the image for the rook 
	 */
	private ImageIcon rookImg;
	
	/**
	 * Variable that will hole the image for the rook 
	 */
	private ImageIcon bishopImg;
	
	/**
	 * Variable that will hold the image for the rook
	 */
	private ImageIcon queenImg;
	
	//*********** Constructors ***********/

	/**
	 * Default constructor will set up all of the components  
	 */
	public GUI()
	{
		//load images
		rookImg = new ImageIcon("images/rook.png");
		bishopImg = new ImageIcon("images/bishop.png");
		queenImg = new ImageIcon("images/queen.png");
		
		//set L & F so can use .setBackground
		setMetalLookAndFeel();
		
		this.setSize(400, 400);
		this.setTitle("Courswork 2 - Java - 8 Queens Problem");
		
		//set up main panel
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		this.setContentPane(mainPanel);
		
		//set up top panel
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		//add to main panel
		mainPanel.add(BorderLayout.NORTH, topPanel);
		//set up components on top panel
		topPanel.add(BorderLayout.NORTH, gameinfoTextArea = new JTextArea("This Is The Game Information....", 4, 0));
		gameinfoTextArea.setEditable(false);
				
		//set up button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 4));
		//add to top panel
		topPanel.add(BorderLayout.SOUTH, buttonPanel);
		//set up components on button panel
		buttonPanel.add(resetBtn = new JButton("Reset"));
		resetBtn.addActionListener(this);
		buttonPanel.add(rooksBtn = new JButton("Rooks"));
		rooksBtn.addActionListener(this);
		buttonPanel.add(bishopsBtn = new JButton("Bishops"));
		bishopsBtn.addActionListener(this);
		buttonPanel.add(queensBtn = new JButton("Queens"));
		queensBtn.addActionListener(this);
				
		//set up  grid panel 
		JPanel boardPanel = new JPanel();
		boardPanel.setLayout( new GridLayout(gameBoard.getRows(), gameBoard.getCols()));
		//add to main panel
		mainPanel.add(BorderLayout.CENTER, boardPanel);
		//set up components on grid panel
		graphicBoard = new JButton[gameBoard.getRows()][gameBoard.getCols()];
		for (int i = 0; i < gameBoard.getRows(); i++)
			for (int j = 0; j < gameBoard.getCols(); j++)
			{
				boardPanel.add(this.graphicBoard[i][j] = new JButton());
				//take copy of i,j to pass to methods
				final int row = i, col = j;
				this.graphicBoard[i][j].addActionListener(new ActionListener()
				{
					//implement action performed method here
					public void actionPerformed(ActionEvent e)
					{
						//check to see what game type is being used and the calls the correct methods 
						//based on this info
						 
						
						if (gameBoard.getGameType() == 0)
						{
							if (!gameBoard.placeRook(row, col))
								messagesTextField.setText(row + "," + col + " Cannot Be Set At This Time....");
							else
							{			
								messagesTextField.setText(gameBoard.getPieceNum() + " Pieces Placed.....");
								gameBoard.printBoard();
								
								if(e.getSource() instanceof JButton)
								{
									updateGraphicBoardRook(row, col);									
									((JButton)e.getSource()).setBackground(null);
									((JButton)e.getSource()).setIcon(rookImg);
									((JButton)e.getSource()).setText(null);	
								}
							}
						}
						
						if (gameBoard.getGameType() == 1)
						{
							if (!gameBoard.placeBishop(row, col))
								messagesTextField.setText(row + "," + col + " Cannot Be Set At This Time....");
							else
							{			
								messagesTextField.setText(gameBoard.getPieceNum() + " Pieces Placed.....");
								gameBoard.printBoard();
								
								if(e.getSource() instanceof JButton)
								{									
									updateGraphicBoardBishop(row, col);
									((JButton)e.getSource()).setBackground(null);
									((JButton)e.getSource()).setIcon(bishopImg);
									((JButton)e.getSource()).setText(null);									
								}
							}
						}
						
						if (gameBoard.getGameType() == 2)
						{
							if (!gameBoard.placeQueen(row, col))
								messagesTextField.setText(row + "," + col + " Cannot Be Set At This Time....");
							else
							{			
								messagesTextField.setText(gameBoard.getPieceNum() + " Pieces Placed.....");
								gameBoard.printBoard();
								
								if(e.getSource() instanceof JButton)
								{									
									updateGraphicBoardQueen(row, col);
									((JButton)e.getSource()).setBackground(null);
									((JButton)e.getSource()).setIcon(queenImg);
									((JButton)e.getSource()).setText(null);
									
								}
							}
						}
						
						//check for win fail
						if (gameBoard.boardFull() && gameBoard.getPieceNum() < 8)
							messagesTextField.setText("Sorry This Game Is Over....");
						else if (!gameBoard.boardFull() && gameBoard.getPieceNum() >= 8)
							messagesTextField.setText("Sorry This Game Is Over....");
						else if (gameBoard.boardFull() && gameBoard.getPieceNum() == 8)
							messagesTextField.setText("Congratulations You Are A Winner....");
					}
				});
			}
		
		//set up TextField for bottom of screen
		mainPanel.add(BorderLayout.SOUTH, messagesTextField = new JTextField());
		messagesTextField.setText("The Game Has Started Place The First Piece.....");
		messagesTextField.setEditable(false);
		
		//finalize frame
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	//*********** Public Methods ***********/
	
	/**
	 * Method used to set the look and feel to Metal 
	 */
	public static void setMetalLookAndFeel() 
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		}
		catch(Exception e)
		{
	      System.out.println("Error setting Metal L & F: " + e);
		}
	}

	/**
	 * Method used to initialize the Board 
	 */
	public void initGraphicBoard()
	{
		//code to set up graphic board
		for (int i = 0; i < gameBoard.getRows(); i++)
			for (int j = 0; j < gameBoard.getCols(); j++)
			{
				this.graphicBoard[i][j].setText(gameBoard.getDefString());
				this.graphicBoard[i][j].setEnabled(true);
				this.graphicBoard[i][j].setBackground(null);
				this.graphicBoard[i][j].setIcon(null);
			}
	}
	
	/**
	 * Method used to update the gui after rook has been placed
	 * @param row The row number of the coord
	 * @param col The column number of the coord
	 */
	public void updateGraphicBoardRook(int row, int col)
	{
		//code to add possible moves for the placed rook to the graphic board
		//add horizontal moves for this placement
		for (int i = 0 ; i < gameBoard.getCols(); i++)
		{
			this.graphicBoard[row][i].setEnabled(false);
			this.graphicBoard[row][i].setBackground(Color.BLUE);
		}
	
		//add vertical moves for this placement
		for (int i = 0; i < gameBoard.getRows(); i++)
		{
			this.graphicBoard[i][col].setEnabled(false);
			this.graphicBoard[i][col].setBackground(Color.BLUE);
		}
	}

	/**
	 * Method used to update the gui after bishop has been placed
	 * @param row The row number of the coord
	 * @param col The column number of the coord
	 */
	public void updateGraphicBoardBishop(int row, int col)
	{
		//code to add possible moves for the placed bishop to the graphic board
		//up left
		int startRow = row;
		int startCol = col;
		for(;row > -1 && col > -1; row--, col--) 
		{
			this.graphicBoard[row][col].setEnabled(false);
			this.graphicBoard[row][col].setBackground(Color.MAGENTA);
		}
		
		//down left
		row = startRow;
		col = startCol;
		for(;row < gameBoard.getRows() && col > -1; row++, col--) 
		{
			this.graphicBoard[row][col].setEnabled(false);
			this.graphicBoard[row][col].setBackground(Color.MAGENTA);
		}
		
		//up right
		row = startRow;
		col = startCol;
		for(;row > -1  && col < gameBoard.getCols(); row--, col++) 
		{
			this.graphicBoard[row][col].setEnabled(false);
			this.graphicBoard[row][col].setBackground(Color.MAGENTA);
		}
		
		//down right
		row = startRow;
		col = startCol;
		for(; row < gameBoard.getRows() && col < gameBoard.getCols(); row++, col++) 
		{
			this.graphicBoard[row][col].setEnabled(false);
			this.graphicBoard[row][col].setBackground(Color.MAGENTA);
		}
	}

	/**
	 * Method used to update the gui after queen has been placed
	 * @param row The row number of the coord
	 * @param col The column number of the coord
	 */
	public void updateGraphicBoardQueen(int row, int col)
	{
		//code to add possible moves for the placed queen to the graphic board
		int startRow = row;
		int startCol = col;
		
		//add horizontal moves for this placement
		for (int i = 0 ; i < gameBoard.getCols(); i++)
		{
			this.graphicBoard[row][i].setEnabled(false);
			this.graphicBoard[row][i].setBackground(Color.ORANGE);
		}

		//add vertical moves for this placement
		for (int i = 0; i < gameBoard.getRows(); i++)
		{
			this.graphicBoard[i][col].setEnabled(false);
			this.graphicBoard[i][col].setBackground(Color.ORANGE);

		}

		for(;row > -1 && col > -1; row--, col--) 
		{
			this.graphicBoard[row][col].setEnabled(false);
			this.graphicBoard[row][col].setBackground(Color.ORANGE);
		}
		
		//down left
		row = startRow;
		col = startCol;
		for(;row < gameBoard.getRows() && col > -1; row++, col--) 
		{
			this.graphicBoard[row][col].setEnabled(false);
			this.graphicBoard[row][col].setBackground(Color.ORANGE);
		}
		
		//up right
		row = startRow;
		col = startCol;
		for(;row > -1  && col < gameBoard.getCols(); row--, col++) 
		{
			this.graphicBoard[row][col].setEnabled(false);
			this.graphicBoard[row][col].setBackground(Color.ORANGE);
		}
		
		//down right
		row = startRow;
		col = startCol;
		for(; row < gameBoard.getRows() && col < gameBoard.getCols(); row++, col++) 
		{
			this.graphicBoard[row][col].setEnabled(false);
			this.graphicBoard[row][col].setBackground(Color.ORANGE);
		}
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e)
	{
		//code for the button on the button panel
		
		if (e.getSource() == resetBtn)
		{
			gameBoard.initBoard();
			initGraphicBoard();
			gameBoard.setPieceNum(0);
			messagesTextField.setText("The Game Has Been Reset....");		
			return;
		}
		
		if (e.getSource() == rooksBtn)
		{
			gameBoard.initBoard();
			initGraphicBoard();
			gameBoard.setPieceNum(0);
			gameBoard.setGameType(0);
			messagesTextField.setText("The Game Has Been Reset Playing As Rook....");
			return;			
		}
		
		if (e.getSource() == bishopsBtn)
		{
			gameBoard.initBoard();
			initGraphicBoard();
			gameBoard.setPieceNum(0);
			gameBoard.setGameType(1);
			messagesTextField.setText("The Game Has Been Reset Playing As Bishop....");
			return;			
		}
		
		if (e.getSource() == queensBtn)
		{
			gameBoard.initBoard();
			initGraphicBoard();
			gameBoard.setPieceNum(0);
			gameBoard.setGameType(2);
			messagesTextField.setText("The Game Has Been Reset Playing as Queen....");
			return;			
		}
	}
}