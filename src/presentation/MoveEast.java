package presentation;

import business.Heading;
import business.Maze;
import framework.Command;


public class MoveEast extends Command {

	private Maze maze;

	public MoveEast(Maze maze)
	{
		super();
		this.maze = maze;
	}

	@Override
	public void execute() {
		maze.move(Heading.EAST);	
	}
	
}
