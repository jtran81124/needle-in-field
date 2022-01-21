package presentation;

import business.Heading;
import business.Maze;
import framework.Command;
import framework.Model;


public class MoveWest extends Command {

	private Maze maze;

	public MoveWest(Model maze)
	{
		this.maze = (Maze) maze;
	}

	@Override
	public void execute() {
		maze.move(Heading.WEST);
		
	}
	
}
