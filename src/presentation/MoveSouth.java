package presentation;

import business.Heading;
import business.Maze;
import framework.Command;
import framework.Model;


public class MoveSouth extends Command {

	private Maze maze;

	public MoveSouth(Model maze)
	{
		this.maze = (Maze) maze;
	}

	@Override
	public void execute() {
		maze.move(Heading.SOUTH);
	}
	
}
