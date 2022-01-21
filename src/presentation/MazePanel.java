package presentation;

import java.awt.GridLayout;
import java.awt.event.ActionListener;


import business.Maze;
import framework.AppPanel;
import framework.Model;
import framework.View;



public class MazePanel extends AppPanel{

	private static final long serialVersionUID = 1L;

	private Maze maze;
	private ControlView ctrlView;
	private MazeView mazeView;
		
	public MazePanel(Model model, ActionListener listener) {
		super(model, listener);
		this.maze = (Maze) model;
		setLayout(new GridLayout (1,2)); // 1x2 grid layout
	
		//add ControlView first then add MazeView
		
		ctrlView = new ControlView(maze, listener);
		this.add(ctrlView);
		mazeView = new MazeView(maze);
		this.add( mazeView);
		//maze.addObserver(ctrlView);  not needed because subclasses do addObservers
		// for (View view: views) 
		// { this.add(view);}
		
	}
}
