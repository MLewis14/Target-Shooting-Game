package TargetGame.TargetGameV1;
import java.util.Scanner;

public class InputValidation {
	private int xGuess, yGuess;
	private Scanner input;
	private GameBoard gBoard;
//Constructor for an InputValidation object
	public InputValidation(GameBoard gBoard) {
		this.gBoard = gBoard;
	}
//Checks whether input values are valid; If so, then returns a true value
	public boolean checkInput(int maxWidth, int maxHeight) {
		input = new Scanner(System.in);
		boolean validInput = false;
		
		System.out.println("Please enter an x value between 0 and " + maxWidth + ".");
		while(validInput == false) {
			if(input.hasNextInt()) {
				xGuess = input.nextInt();
				if(xGuess > 0 && xGuess < maxWidth) {
					validInput = true;
				}
				else if(xGuess <= 0 || xGuess >= maxWidth) {
					System.out.println("Invalid value, Please enter a number between 0 and " + maxWidth + ".");
					//input.next();
				}
			}
			else {
				System.out.println("Invalid entry, Please enter a numerical value between 0 and " + maxWidth + ".");
				input.next();
				validInput = false;
			}
		}
		validInput = false;
		System.out.println("Please enter a y value between 0 and " + maxHeight + ".");
		while(validInput == false) {
			if(input.hasNextInt()) {
				yGuess = input.nextInt();
				if(yGuess > 0 && yGuess < maxHeight) {
					validInput = true;
				}
				else if(yGuess <= 0 || yGuess >= maxHeight) {
					System.out.println("Invalid value, Please enter a number between 0 and " + maxHeight + ".");
					//input.next();
				}
			}
			else {
				System.out.println("Invalid entry, Please enter a numerical value between 0 and " + maxHeight + ".");
				input.next();
				validInput = false;
			}
		}
		System.out.println("xGuess is " + xGuess);
		System.out.println("yGuess is " + yGuess);
		
		if(gBoard.getCell(xGuess, yGuess) == 'X') {
			System.out.println("Congratulations! You won!");
			return true;
		}
		else {
			System.out.println("Sorry, not a match. Try again!");
			return false;
		}
	}
}
