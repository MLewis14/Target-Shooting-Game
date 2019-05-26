package TargetGame.TargetGameV1;

public class GameDisplay {
	private GameBoard gameBoard;
//Constructs a new GameDisplay with same gameBoard as input	
	public GameDisplay(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}
//Prints the game board on the screen
	public void draw(){
		System.out.println("Currently in draw method");
		for(int row[]: gameBoard.getBoard()){
			for(int cell: row) {
				System.out.print((char)cell);
			}
			System.out.println();
		}
	}
	
	public void drawInvis() {
		System.out.println("Currently in draw method");
		for(int row[]: gameBoard.getBoard()){
			for(int cell: row) {
				if((char)cell != 'X') {
					System.out.print((char)cell);
				}
				else if((char)cell == 'X') {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
