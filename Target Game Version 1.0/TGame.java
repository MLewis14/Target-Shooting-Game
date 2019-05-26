package TargetGame.TargetGameV1;

import java.util.Random;
import java.util.Scanner;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class TGame {
	//difficultLevel will be 1 by default unless specified by constructor
	/*
	 * 
	 *  changed width and height variables to accept new values from command-line parser
	 *  git updated
	 */
	private int Game_Target_Area_Width;
	private int Game_Target_Area_Height;
	private int difficultyLevel;
	private Random rng;
	private Scanner in;
	private int guessAmt;
	public int maxGuess; //Possibly keep maxGuess in this class
	//Set it up so when 7 guesses have been made the difficult level 
	//moves up to 2. Following that, set the cell visibility to invisible
	
	GameBoard gameBoard;
	GameDisplay gameDisplay;
	InputValidation input;
	
	// Default constructor
	public TGame() {
		
		gameBoard = new GameBoard(Game_Target_Area_Height, Game_Target_Area_Width);
		gameDisplay = new GameDisplay(gameBoard);
		input = new InputValidation(gameBoard);
		rng = new Random();
		guessAmt = 0;
		maxGuess = 10 + rng.nextInt(15);
		in = new Scanner(System.in);
		in.useDelimiter("(\\p{javaWhitespace}|,)+");
	}
	
	/*
	 * 
	 *  Another constructor to handle command-line parser
	 *  seems to be working
	 */
	public TGame( ApacheParser cli ) {
		/*
		 * 
		 *  set Game target area height and width variables from command-line
		 */
		Game_Target_Area_Height = cli.getGameHeight();
		Game_Target_Area_Width= cli.getGameWidth();
		difficultyLevel= cli.getGameLevel();

		gameBoard = new GameBoard(Game_Target_Area_Height, Game_Target_Area_Width);
		gameDisplay = new GameDisplay(gameBoard);
		input = new InputValidation(gameBoard);
		rng = new Random();
		maxGuess = rng.nextInt(15);
		in = new Scanner(System.in);
		in.useDelimiter("(\\p{javaWhitespace}|,)+");
	}


	public void play() {
		System.out.println("Currently in play method.");
		boolean won = false;
		setTarget();
		gameBoard.plotBorder();
		gameBoard.writeText(0, Game_Target_Area_Height + 1, "Enter your target position (x, y):");
		
		while(!won) {
			if(difficultyLevel == 1) {
				gameDisplay.draw();
				won = input.checkInput(Game_Target_Area_Width, Game_Target_Area_Height); //checkInput method will look for valid inputs and return false if not at target
				guessAmt++;
				}
			else if(difficultyLevel == 2) {
				gameDisplay.drawInvis();
				won = input.checkInput(Game_Target_Area_Width, Game_Target_Area_Height);
				guessAmt++;
				}
			if(guessAmt >= maxGuess / 2) {
				this.setDifficulty();
			}
		}
	}
	
	public void setDifficulty() {
		difficultyLevel = 2;
	}
	
	private void setTarget() {
		System.out.println("Currently in setTarget method.");
		/*
		*
		* variables x and y are declared twice
		* 
		*/
		int x = rng.nextInt(Game_Target_Area_Width - 2) + 1;
		int y = rng.nextInt(Game_Target_Area_Height - 2) + 1;

		// test purposes
//		int x = rng.nextInt(Game_Target_Area_Width - 1) + 1;
//		int y = rng.nextInt(Game_Target_Area_Height - 1) + 1;
		
//		 if the x or y value is 0 or the maximum value -1 (lets say max width is 10 so 9) , the target does not get printed since the border overrides it
//		 extending the border by 1 and keeping the "playzone" the same might be an easier solution
//		 with the above changes, I still receive 0 and 9 for height which blocks the target marker
		
		System.out.println("Game target " +  x + ", " + y);
		gameBoard.setCell(x, y, 'X');
	}
}
