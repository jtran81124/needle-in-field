package business;

import java.util.Random;

import framework.Model;
import framework.Utilities;

// Jacky 11/9 implemented: move and move tester
// Jacky completed Maze 11/9, edited Move() 11/13 added RESET in move.
// Jacky 11/13 added win and loose conditions with win and loose pop ups
	//numMoves, player and exit getters and setters.

//Collaborated 11/14 on copy() method, removed setModel() method
//this is because instead of appending and setting all observers to a model
//, the model with all the observers can copy to a newer model

public class Maze extends Model {


	public static int MAZE_SIZE = 20;

	int playerPosX;
	int playerPosY;
	int exitX;
	int exitY;
	int numMoves;


	public Maze() {
		super();
		setExit();
		playerPosX = 10;
		playerPosY = 10;
		numMoves = 50;
	}

	public void copy(Model other)
	{
		super.copy(other);
		Maze otherMze = (Maze) other;
		playerPosX =  otherMze.getPlayerX();
		playerPosY =  otherMze.getPlayerY();
		exitX = otherMze.getExitX();
		exitY = otherMze.getExitY();
		numMoves = otherMze.getNumMoves();
		changed();
	}

	public String getPlayerPos() // for testing purposes
	{
		String msg = playerPosX + " " + playerPosY;
		return msg;
	}

	public int getPlayerX() {return playerPosX;}
	public int getPlayerY() {return playerPosY;}
	public int getExitX() { return exitX;}
	public int getExitY() { return exitY;}
	public int getNumMoves(){return numMoves;}
	

	public void setExit() {
		Random rand = new Random();
		exitX = rand.nextInt(MAZE_SIZE);
		exitY = rand.nextInt(MAZE_SIZE);
	}
	
	public void move(Heading direction) {
		switch (direction) {

		case NORTH:
			if (playerPosY > 0 && numMoves > 0) {
				playerPosY -= 1;
				numMoves -=1;
				this.changed();
			}
			break;

		case SOUTH:
			if (playerPosY < 19 && numMoves > 0) {
				playerPosY += 1;
				numMoves -=1;
				this.changed();
			}
			break;

		case EAST:
			if (playerPosX < 19 && numMoves > 0) {
				playerPosX += 1;
				numMoves -=1;
				this.changed();
			}
			break;

		case WEST:
			if (playerPosX > 0 && numMoves > 0) {
				playerPosX -= 1;
				numMoves -=1;
				this.changed();
			}
			break;
			
		case RESET:
			playerPosX = 10;
			playerPosY = 10;
			setExit();
			numMoves = 50;
			this.changed();
			break;

		default:
			break;
		}

		//win loose conditions
		if (playerPosX == exitX && playerPosY == exitY ){
			Utilities.inform("You have won!");
			}
		else if (numMoves == 0)
		{
			Utilities.inform("You have lost!");
		}
	}

	public int distanceToExit() // pythagorean theorem
	{
		int x = playerPosX - exitX;
		x = x * x;
		int y = playerPosY - exitY;
		y = y * y;

		double function = Math.sqrt(x + y);
		double rounded = Math.round(function); // decimal is .0
		return (int) rounded;
	}

	// //tests move method.
	// public static void main(String[] args) {
	// 	Maze mze = new Maze();
	// 	System.out.println(mze.getPlayerPos());

	// 	mze.move(Heading.NORTH);
	// 	mze.move(Heading.NORTH);
	// 	System.out.println(mze.getPlayerPos());
	// }
}
