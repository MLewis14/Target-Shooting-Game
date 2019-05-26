package TargetGame.TargetGameV1;

public class GameBoardCell {
	private int value;
	private boolean visible;

//Constructs a GameBoardCell 
	public GameBoardCell(int value, boolean visible) {
		this.value = value;
		this.visible = visible;
	}
//Returns value 	
	public int getValue() {
		return value;
	}
//Returns true or false value for boolean visible
	public boolean isVisible() {
		return visible;
	}
//Sets boolean visible to either true or false
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}
