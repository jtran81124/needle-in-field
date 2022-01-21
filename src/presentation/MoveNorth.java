package presentation;

import business.Heading;
import business.Maze;
import framework.Command;
import framework.Model;

public class MoveNorth extends Command {

	private Maze maze;

	//Needs to take in a model to make AppFrame happy
	public MoveNorth(Model maze)
	{
		this.maze = (Maze) maze;
	}

	@Override
	public void execute() {
		maze.move(Heading.NORTH);		
	}
	
}
