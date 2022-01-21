package presentation;

import java.awt.event.ActionListener;

import business.Maze;
import framework.*;


public class MazeFactory implements AppFactory {

	public MazeFactory()
	{
		//done
	}
		
	@Override //makes maze
	public Model makeModel() {
		Model maze = new Maze();
		return maze;
	}

	@Override //makes the panel under the FileMenu //NULL POINTER where?
	public AppPanel makePanel(Model model, ActionListener listener) {
			AppPanel appP = new MazePanel( (Maze) model, listener);
			return appP;
	}

	@Override
	public String[] getEditCommands() {
		
		return new String[] { "North", "East", "South", "West", "Reset" };
		//Under the Edit button, these strings appear.
	}
	
	@Override //convert commands to string
	public Command makeEditCommand(Model model, String type) {
		//needs to return type command
		Maze maze = (Maze) model;
		
		switch(type)
		{
		case "North":
			return new MoveNorth(maze);
			
		case "East":
			return new MoveEast(maze);
			
		case "South":
			return new MoveSouth(maze);
			
		case "West":
			return new MoveWest(maze);
			
		case "Reset":
			return new MoveReset(maze);
		}
		
		return null;
	}

	
	//Not sure if needed in Maze Challenge assignment.
	@Override
	public String getTitle() {
		
		
		return new String( "Maze Challenge");
	}

	
	@Override
	public String[] getHelp() {
		
		return new String[] {"About" , "Contents" };
		//After clicking help, these two string appear in the drop down menu.
	}

	@Override
	public String about() {
		return "Maze Challenge version: 1.0 by Mongoose " + Character.toString((char) 169) + " 2019" ;
		//The About info under Help.
	}

	@Override
	public String[] contents() {
		return new String[] { "Locate the escape room in the number of alloted moves" };
		//The contents infor under Help.
	}
}
