package presentation;

import framework.AppFrame;

public class MazeRunner {

	public static void main (String[] args)
	{
		AppFrame app = new AppFrame( new MazeFactory());
		app.pack();
		app.setVisible(true);
	}
}
