package presentation;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import business.Maze;
import framework.Model;



public class ControlView extends JPanel implements Observer {
//Control view is an observer because the movesLeft and exitLocation labels looks for changes in the maze.
//maze.addObserver(this) because observers look for changes in the maze.
	
	private Maze maze;
	private ActionListener listener;

	// Labels are not dynamic, exitsLeft and movesLeft are dynamic
	private JLabel exitLabel, movesLeftLabel, exitsLeft, movesLeft;
	private JButton northButton, eastButton, southButton, westButton, resetButton;

	ControlView(Maze maze, ActionListener listener) {
		this.maze = maze;
		maze.addObserver(this);

		this.listener = listener;
		setLayout(new GridLayout(7,1));
		// Initialize all the variables
		exitLabel = new JLabel("Exit Distance ");
		movesLeftLabel = new JLabel("Moves Left ");

		exitsLeft = new JLabel(Integer.toString(maze.distanceToExit())); // just changes the int to a string
		movesLeft = new JLabel(Integer.toString(maze.getNumMoves()));

		northButton = new JButton("North");
		eastButton = new JButton("East");
		southButton = new JButton("South");
		westButton = new JButton("West");
		resetButton = new JButton("Reset");

		// add listners to all the buttons, actionPerformed() in "" will handle them.
		northButton.addActionListener(listener);
		eastButton.addActionListener(listener);
		southButton.addActionListener(listener);
		westButton.addActionListener(listener);
		resetButton.addActionListener(listener);

		// exit panel
		JPanel p = new JPanel();
		p.add(exitLabel);
		p.add(exitsLeft);
		this.add(p);
		
		//movesLeft panel
		p = new JPanel();
		p.add(movesLeftLabel);
		p.add(movesLeft);
		this.add(p);
		
		//add commands in their own panels
		p = new JPanel();
		p.add(northButton);
		this.add(p);
		
		p = new JPanel();
		p.add(eastButton);
		this.add(p);
		
		p = new JPanel();
		p.add(southButton);
		this.add(p);
		
		p = new JPanel();
		p.add(westButton);
		this.add(p);
		
		p = new JPanel();
		p.add(resetButton);
		this.add(p);
		
	}
	
	

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Maze)
		{
				exitsLeft.setText(Integer.toString(maze.distanceToExit())); // just changes the int to a string
				movesLeft.setText(Integer.toString(maze.getNumMoves()));
		}
	}
}
