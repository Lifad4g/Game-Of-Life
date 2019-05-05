package ee;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class colors extends JButton implements ActionListener
{
	//creates int for alive cells
	public int aliveCells;
	
	//creates contructor for making boxes have white background
	public colors()
	{
		super();
		setBackground(Color.WHITE);
		aliveCells = 0;
		this.addActionListener(this);
	}
	
	//creates method for changing the color whether the alive cells are 0 or not
	public void colorChange()
	{
		if(aliveCells == 0)
		{
			this.setBackground(Color.white);
		}
		else 
		{
			this.setBackground(Color.yellow);
		}
	}

	//creates action listener for changing the color of box
	@Override
	public void actionPerformed(ActionEvent e) 
	{
	
		if(aliveCells == 0)
		{
			aliveCells = 1;
			this.setBackground(Color.yellow);
		}
		else
		{
			aliveCells = 0;
			this.setBackground(Color.WHITE);
		}
		
	}
}
