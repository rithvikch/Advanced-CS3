
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.Timer;

public class LifeModel implements ActionListener
{

	/*
	 *  This is the Model component.
	 */

	private static int SIZE = 60;
	private LifeCell[][] grid;
	
	LifeView myView;
	Timer timer;
	
	/** Construct a new model using a particular file */
	public LifeModel(LifeView view, String fileName) throws IOException
	{       
		int r, c;
		grid = new LifeCell[SIZE][SIZE];
		for ( r = 0; r < SIZE; r++ )
			for ( c = 0; c < SIZE; c++ )
				grid[r][c] = new LifeCell();

		if ( fileName == null ) //use random population
		{                                           
			for ( r = 0; r < SIZE; r++ )
			{
				for ( c = 0; c < SIZE; c++ )
				{
					if ( Math.random() > 0.85) //15% chance of a cell starting alive
						grid[r][c].setAliveNow(true);
				}
			}
		}
		else
		{                 
			Scanner input = new Scanner(new File(fileName));
			int numInitialCells = input.nextInt();
			for (int count=0; count<numInitialCells; count++)
			{
				r = input.nextInt();
				c = input.nextInt();
				grid[r][c].setAliveNow(true);
			}
			input.close();
		}

		myView = view;
		myView.updateView(grid);

	}

	/** Constructor a randomized model */
	public LifeModel(LifeView view) throws IOException
	{
		this(view, null);
	}

	/** pause the simulation (the pause button in the GUI */
	public void pause()
	{
		timer.stop();
	}
	
	/** resume the simulation (the pause button in the GUI */
	public void resume()
	{
		timer.restart();
	}
	
	/** run the simulation (the pause button in the GUI */
	public void run()
	{
		timer = new Timer(50, this);
		timer.setCoalesce(true);
		timer.start();
	}

	public void reset()
	{
		
		int r, c;
		for (int i = 0; i < SIZE; i++){
			for (int j = 0; j < SIZE; j++){
				grid[i][j].setAliveNow(false);
			}
		}
		for ( r = 0; r < SIZE; r++ )
			{
				for ( c = 0; c < SIZE; c++ )
				{
					if ( Math.random() > 0.85) //15% chance of a cell starting alive
						grid[r][c].setAliveNow(true);
				}
			}
		myView.updateView(grid);
		timer.stop();
		

	}
	public void color(){
		myView.toggleColor();
	}

	/** called each time timer fires */
	public void actionPerformed(ActionEvent e)
	{
		oneGeneration();
		myView.updateView(grid);
	}

	/** main logic method for updating the state of the grid / simulation */
	private void oneGeneration()
	{
		/* 
		 * student code here 
		 */
		
		int neighbors = 0;
		for (int i = 0; i < grid.length; i++){


			for (int j = 0; j < grid[i].length; j++){
				neighbors = 0;
				for (int x = -1; x < 2; x++){
					for (int y = -1; y < 2; y++){

						if (i+x >= 0 && i+x < SIZE && j+y >= 0 && j+y < SIZE) {


							if (grid[i + x][j + y].isAliveNow()) {
									neighbors++;
								}
						}


					}



				}
				if (grid[i][j].isAliveNow()){
					neighbors--;
				}
				
				if (grid[i][j].isAliveNow()){
					if (neighbors == 2 || neighbors == 3){
						grid[i][j].setAliveNext(true);
					}
					else {
						grid[i][j].setAliveNext(false);
					}
				}
				else {
					if (neighbors == 3){
						grid[i][j].setAliveNext(true);
					}
				}









			}
		}

		for (int i = 0; i < SIZE; i++){
			for (int j = 0; j < SIZE; j++){
				grid[i][j].setAliveNow(grid[i][j].isAliveNext());
			}
		}		
	}
}
