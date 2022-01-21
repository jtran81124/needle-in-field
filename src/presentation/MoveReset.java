package presentation;

import business.Heading;
import business.Maze;
import framework.Command;
import framework.Model;


public class MoveReset extends Command {

	private Maze maze;

	public MoveReset(Model maze)
	{
		this.maze = (Maze) maze;
	}

	@Override
	public void execute() {
		maze.move(Heading.RESET);
		
	}
}