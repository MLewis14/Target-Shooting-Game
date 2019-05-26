package TargetGame.TargetGameV1;

public class GameLauncher {
	//There are a few bugs to be worked out as well as needed additions
	//1) The GameDisplay now properly prints to the screen.
	//2) Have to add a difficulty level; this should most likely be implemented after the command line arguments are added; Set the difficulty in the command line,
	//then edit it depending on how many incorrect guesses have been made
	//3)(Michael) Currently working on the input validation, at first i implemented a separate class for that but I might just add it into the play method in the TGame class
	//4)(Claude) Is currently working on the command line argument parser, will implement it into the function when ready
	//5) Feel free to make any edits you think will help in general, don't forget to comment your changes/additions
	
	
 public static void main(String[] args) {
		System.out.println("Currently in main method.");
		//Possibly add command line argument parser here, then pass the difficult level value to TGame constructor
		//Another required step is the procedure to make the target invisible when difficultyLevel is equal to 2
		//Shouldn't be too hard, but if anyone wants to do it before I do, go for it
		
		ApacheParser cli = new ApacheParser(args);		
		TGame game = new TGame(cli);
		game.play();
	}
}
