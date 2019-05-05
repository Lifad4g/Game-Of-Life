package ee;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class GUI extends JFrame implements ActionListener
{
	
	
	public JMenuBar menuBar; //creates a bar in the top of gui
	public JMenu menu; //creates a menu on the bar
	public JMenuItem start,reset,pause,exit; //creates items in the menu 
	public colors [][] grid = new colors[50][50]; //

	public boolean bool1= true; //creates a global boolean
	public boolean bool2 = true; //creates a global boolean
	
	public JLabel iterationLabel = new JLabel(); //creates the label for iteration
	public int iteration = 0; //creates the iteration int
	
	public GUI(int width, int length) //creates the grid inside it
	{
		JFrame frame = new JFrame("Conways Game of Life");//creates a frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//closes the frame when you exit
	
		frame.setLocation(600, 600);// locates the frame on that coordinates 


		JPanel panel = new JPanel();//creates a panel
		frame.add(panel);//adds panel into the frame
		
		//creates the a menubar on top of frame
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		//creates a menu on the bar
		menu = new JMenu("Options");
		menuBar.add(menu); //adds it on the bar
		
		//adds iteration to the bar
		menuBar.add(iterationLabel);
		
		//Creating Start button
		start = new JMenuItem("Start");
		menu.add(start); //adds it to the menu

		//Creating reset button
		reset = new JMenuItem("Restart"); 
		menu.add(reset); //adds it to menu

		//Creating Pause button
		pause = new JMenuItem("Pause"); 
		menu.add(pause); //adds it to menu

		//Creating Exit button
		exit = new JMenuItem("Exit"); 
		menu.add(exit); //add it to menu
		

		panel.setLayout(new GridLayout(width,length));
	 //allocate the size of grid

		for(int y=0; y<length; y++)
		{
			for(int x=0; x<width; x++)
			{
				grid[x][y]=new colors(); //creates new button     
				panel.add(grid[x][y]); //adds button to grid
			}
		}
		frame.pack();
		frame.setVisible(true);//sets frame visible

		iterationLabel.setText("Iteration Number: " + "0"); //adds text to the label
		
		//adds action listener to the buttons
		exit.addActionListener(this);  
		start.addActionListener(this);
		pause.addActionListener(this);
		reset.addActionListener(this);

	}
	
	//method for counting the iteration
	public void addIteration() {
		this.iteration++;
		this.iterationLabel.setText("Generation: " + iteration);
	}
	
	//method for the boolean, for the pause button
	public boolean getGameWorking() {

		return this.bool1;
		}

	//creates the action listener for the choices in the menu
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource().equals(exit)) System.exit(0);
		
		else if (e.getSource().equals(reset)) bool2 = true;
			
		else if (e.getSource().equals(pause)) bool1 = false;

		else if (e.getSource().equals(start)) bool1=true;
			


	}
}


