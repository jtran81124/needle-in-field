package framework;

import business.Maze;
import presentation.MoveNorth;
import presentation.MoveSouth;


public class CommandProcessor {

	//this line is used when??????
	public static CommandProcessor theCommandProcessor =  new CommandProcessor();
    
	public CommandProcessor() 
	{

    }
	public static void execute(Command cmmd) 
	{
        cmmd.execute();
    }

}




 //below: If commanprocessor used Command as an interface

// public class CommandProcessor {
	
// 	static Command slot;
	
// 	public CommandProcessor(){	
// 	}
	
// 	public static void executeCmmd(Command cmmd) {
// 		slot = cmmd;
// 		slot.execute();
// 	}

// }


//how to use:

//maze.executeCommand(new MoveNorth(maze));

