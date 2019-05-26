package TargetGame.TargetGameV1;

//import org.slf4j.Logger;
//import org.slf4j.Logger.Factory;

public class GameBoard {
//	private static Logger logger;
	private int width, height;
	int[][] boardCells;
//Constructs a new game board, sets width/height, and fills in cells	
	public GameBoard(int height, int width) {
//		System.out.println("Game board width, height= " + width + ", " + height);
		this.width = width;
		this.height = height;
		boardCells = new int[height][width];
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				boardCells[i][j] = ' ';
			}
		}
	}
//Returns 2-Dimensional array of boardCells	
	public int[][] getBoard(){
		return boardCells;
	}
//Returns one ordered pair(x,y) in the boardCells	
	public int getCell(int x, int y) {
		return boardCells[y][x];
	}
//Sets the target cell in ordered pair(x,y)
	public void setCell(int x, int y, int target) {
		boardCells[y][x] = target;
	}
//Returns the width of the game board
	public int getWidth() {
		return width;
	}
//Returns the height of the game board
	public int getHeight() {
		return height;
	}
//Presets a visual representation of the game border	
	public void plotBorder() {
		for(int i = 0; i < width; i++) {
			boardCells[0][i] = '-';
			boardCells[height - 1][i] = '-';
		}
		for(int i = 0; i < height; i++) {
			boardCells[i][0] = '|';
			boardCells[i][width - 1] = '|';
		}
	}
//Presets the text to display and makes sure it is not outside of the game window
	public void writeText(int x, int y, String text) {
		if(x >= width || x < 0 || y < 0 || y >= height) {
//			logger.debug("Text is outside of the displaying area.");
			return;
		}
		for(int i = 0; i < text.length(); i++) {
			if(x + i < 0) {
//				logger.debug("Character " + text.charAt(i) + " in the text is outside of the displaying area.");
			}
			else {
				boardCells[y][x+i] = text.charAt(i);
			}
		}
	}
}
