package TargetGame.TargetGameV1;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class ApacheParser {

	// todo: updated Game errors 25 September
	
	private int gameWidth, gameHeight, gameLevel;
	private String[] args;

	// declare command Line Options object
	private Options ops;

	// declare command Line Parser object
	protected CommandLineParser parser;
	
	// declare Command Line object
	private CommandLine cmd;
	
	// construct accepts command line arguments from main method
	public ApacheParser(String[] args) {
		this.parser = new DefaultParser();
		this.cmd = null;
		this.ops = new Options();
		
		// String.clone() function performs a String copy to destination String argument
		this.args = args.clone();
		
		this.setOptions();
	}
	
	// add window and game command-line options
	private void setOptions() {
		// add window-width option
		ops.addOption("w", "window-width", true, "set window width");
		
		// add window-height option
		ops.addOption("h", "window-height", true, "set window height"); 	

		// add game level option
		ops.addOption("l", "level", true, "set difficulty level"); 	
		
		parseOptions();
	}
	
	private void parseOptions() {
		// parse command line arguments

		try {
			cmd = parser.parse( ops, this.args);

		} catch (ParseException e) {
			// message to user: invalid height, width or length
			System.out.println("Parser error: Using default game options");
			this.gameHeight = 10;
			this.gameWidth = 40;
			this.gameLevel = 1;		
		}
		validateOptions();
	}
	
	private void validateOptions() {
		// todo: print the values for height, width, and level for testing
		
		// try parsing game width
		if( cmd.hasOption( "w" )) {
			try {
				gameWidth = Integer.parseInt( cmd.getOptionValue( "w" ));
				if(gameWidth < 40 || gameWidth > 100) {
					System.out.println("Cannot accept game width: Using default");
					gameWidth = 40;
				}
				System.out.println( "width = " + gameWidth );
			}
			catch (NumberFormatException ex) {
				System.out.println("Command Line Input Parser error: Using default width [40]");
				gameWidth = 40;
			}
		}
		else {
			gameWidth = 40;
			System.out.println("Default width");
		}

		// try parsing game height
		if( cmd.hasOption("h")) {
			try {
				gameHeight = Integer.parseInt( cmd.getOptionValue( "h" ));
				if(gameHeight < 5 || gameHeight > 40) {
					System.out.println("Cannot accept game height: Using default");
					gameHeight = 25;
				}
				System.out.println( "height = " + gameHeight );
			}
			catch (NumberFormatException ex) {
				System.out.println("Command Line Input Parser error: Using default height [10]");
				gameHeight = 10;
			}
		}
		else {
			gameHeight = 10;
			System.out.println("Default height");
		}

		// try parsing game difficulty level
		if( cmd.hasOption("l")) {
			try {
				gameLevel = Integer.parseInt( cmd.getOptionValue( "l" ));
				if(gameLevel > 2 || gameLevel < 0) {
					System.out.println("Using default game level");
					gameLevel = 1;
				}
				System.out.println( "level = " + gameLevel );
			}
			catch (NumberFormatException ex) {
				System.out.println("Command Line Input Parser error: Using default level [1]");
				gameLevel = 1;				
			}
		}
		else {
			gameLevel = 1;
			System.out.println("Default level");
		}
	}

	public int getGameWidth() {
		return gameWidth;
	}

	public int getGameHeight() {
		return gameHeight;
	}

	public int getGameLevel() {
		return gameLevel;
	}
}
