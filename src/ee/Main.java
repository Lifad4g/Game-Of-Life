package ee;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String[] args) throws IOException//main class that runs the program
	{
		
	int guiSize = 10; //create int for the size of the gui
		
		GUI gui = new GUI(guiSize,guiSize); //links the GUI class with this class
		
				//Main array
				ArrayList<Integer> array = new ArrayList<Integer>();
				int twoArray[][] = new int[guiSize][guiSize];

				//Secondary Array
				int twoArray2[][] = new int[guiSize][guiSize];
				
				//Stores number of alive neighbours
				while(true)
				{
					//Creates the file and writes the iterations and neighbour counts like we did in our lab5
					File file = new File("D:\\Temp\\IterationAndNeighbourCounts.txt"); 
					FileWriter writeHandle = new FileWriter(file);
					BufferedWriter writer = new BufferedWriter(writeHandle);

					//creates boolean for the reset button
					while(gui.getGameWorking())
					{
						if(gui.bool2 == true) 
						{
							randomValue(twoArray);
							gui.iteration = 0;
						}

						if(gui.bool2 == true)
							gui.bool2 = false;

						array.clear(); //clears the array
						
						//creates the file filled with the data
						for (int i = 0; i < twoArray.length; i++) 
						{
							for (int j = 0; j < twoArray[i].length; j++) 
							{
								System.out.print(twoArray[i][j]);
								writer.write(String.valueOf(twoArray[i][j]));
							}
							writer.newLine();
							System.out.println();
						}

						System.out.println("");
						writer.write("");
						writer.newLine();

					//makes the cells change color by using the loop and "colorChange" object
					for(int i = 0; i < twoArray2.length; i++) 
					{
						for (int j = 0; j < twoArray[i].length; j++)
						{
						gui.grid[i][j].aliveCells = twoArray[i][j];
						gui.grid[i][j].colorChange();
						}
					}

					
					for (int i = 0; i < twoArray.length; i++)
					{
						for (int j = 0; j < twoArray[i].length; j++) 
						{
							
							int aliveCells = 0;
							//First Row
							if(i == 0)
							{
								//First Column
								if(j == 0)
								{
									for(int k = i; k <= i + 1; k++)
									{
										for(int l = j; l <= j + 1; l++)
										{
											if(twoArray[k][l] == 1)  aliveCells++;
										}
									}
									
									for(int l = j; l <= j + 1; l++) //two bottom go to top to join to the top left
									{
										if((twoArray[twoArray.length - 1][l] == 1)) aliveCells++;
									}
									
									for(int k = i; k <= i + 1; k++) //side cells join to the left
									{
										if((twoArray[k][twoArray[i].length - 1] == 1)) aliveCells++;
									}
									
									if(twoArray[twoArray.length - 1][twoArray[i].length - 1] == 1) aliveCells++; //to get the corner
									if(aliveCells == 3 && twoArray[i][j] == 0) twoArray2[i][j] = 1;
									else if(aliveCells < 3 && twoArray[i][j] == 1) twoArray2[i][j] = 0;
									else if(aliveCells > 4 && twoArray[i][j] == 1) twoArray2[i][j] = 0;
									else twoArray2[i][j] = twoArray[i][j];
								}
								
								//Last Column
								else if(j == twoArray[i].length - 1)
								{
									for(int k = i; k <= i + 1; k++) //first row to second
									{
										for(int l = j - 1; l <= j; l++) //from last column to the one before
										{
											if(twoArray[k][l] == 1) aliveCells++;
										}
									}
									//two bottom go to top to join to the top right
									for(int l = j - 1; l <= j; l++)
									{
										if((twoArray[twoArray.length - 1][l] == 1)) aliveCells++;
									}
									//side cells join to the right
									for(int k = i; k <= i + 1; k++)
									{
										if((twoArray[k][0] == 1)) aliveCells++;
									}
									
									if(twoArray[twoArray.length - 1][0] == 1) aliveCells++; //to get the corner
									
									if(aliveCells == 3 && twoArray[i][j] == 0) twoArray2[i][j] = 1;
									else if(aliveCells < 3 && twoArray[i][j] == 1) twoArray2[i][j] = 0;
									else if(aliveCells > 4 && twoArray[i][j] == 1) twoArray2[i][j] = 0;
									else twoArray2[i][j] = twoArray[i][j];
								}
								//Works for the Neither first or last column, between
								else
								{
									for(int k = i; k <= i + 1; k++) //from position [0][0] to 
									{
										for(int l = j - 1; l <= j + 1; l++)
										{
											if(twoArray[k][l] == 1) aliveCells++;
										}
									}
									//for lower cells when we join them with top
									for(int l = j - 1; l <= j + 1; l++)
									{
										if((twoArray[twoArray.length - 1][l] == 1)) aliveCells++;
									}
									if(aliveCells == 3 && twoArray[i][j] == 0) twoArray2[i][j] = 1;
									else if(aliveCells < 3 && twoArray[i][j] == 1) twoArray2[i][j] = 0;
									else if(aliveCells > 4 && twoArray[i][j] == 1) twoArray2[i][j] = 0;
									else twoArray2[i][j] = twoArray[i][j];
								}
							}
							//Last Row
							else if(i == (twoArray.length - 1))
							{
								//First Coloumn
								if(j == 0)
								{
									for(int k = i - 1; k <= i; k++)  //first row to second
									{
										for(int l = j; l <= j + 1; l++) //from last column to the one before
										{
											if(twoArray[k][l] == 1) aliveCells++;
										}
									}
									//two top go to bottom to join to the top 
									for(int l = j; l <= j + 1; l++)
									{
										if((twoArray[0][l] == 1)) aliveCells++;
									}
									//side cells join to the right
									for(int k = i - 1; k <= i; k++)
									{
										if((twoArray[k][twoArray[i].length - 1] == 1)) aliveCells++;
									}
									
									if(twoArray[0][twoArray[i].length - 1] == 1) aliveCells++; //to get the corner
									
									if(aliveCells == 3 && twoArray[i][j] == 0) twoArray2[i][j] = 1;
									else if(aliveCells < 3 && twoArray[i][j] == 1) twoArray2[i][j] = 0;
									else if(aliveCells > 4 && twoArray[i][j] == 1) twoArray2[i][j] = 0;
									else twoArray2[i][j] = twoArray[i][j];
								}
								//Last Coloumn
								else if(j == twoArray[i].length - 1)
								{
									for(int k = i - 1; k <= i; k++) //first row to second
									{
										for(int l = j - 1; l <= j; l++) //from last column to the one before
										{
											if(twoArray[k][l] == 1) aliveCells++;
										}
									}
									//two top go to bottom to join to the top 
									for(int l = j - 1; l <= j; l++)
									{
										if((twoArray[0][l] == 1)) aliveCells++;
									}
									//side cells join to the right
									for(int k = i - 1; k <= i; k++)
									{
										if((twoArray[k][0] == 1)) aliveCells++;
									}
									
									if(twoArray[0][0] == 1) aliveCells++;
									
									if(aliveCells == 3 && twoArray[i][j] == 0) twoArray2[i][j] = 1;
									else if(aliveCells < 3 && twoArray[i][j] == 1) twoArray2[i][j] = 0;
									else if(aliveCells > 4 && twoArray[i][j] == 1) twoArray2[i][j] = 0;
									else twoArray2[i][j] = twoArray[i][j];
								}
								//Neither First or Last Coloumn
								else
								{
									for(int k = i - 1; k <= i; k++)
									{
										for(int l = j - 1; l <= j + 1; l++)
										{
											if(twoArray[k][l] == 1) aliveCells++;
										}
									}
									for(int l = j - 1; l <= j + 1; l++)
									{
										if((twoArray[0][l] == 1)) aliveCells++;
									}
									if(aliveCells == 3 && twoArray[i][j] == 0) twoArray2[i][j] = 1;
									else if(aliveCells < 3 && twoArray[i][j] == 1) twoArray2[i][j] = 0;
									else if(aliveCells > 4 && twoArray[i][j] == 1) twoArray2[i][j] = 0;
									else twoArray2[i][j] = twoArray[i][j];
								}
							}
							//Middle Rows
							else{
								//First Coloumn
								if(j == 0)
								{ 
									for(int k = i - 1; k <= i + 1; k++)
									{
										for(int l = j; l <= j + 1; l++)
										{
											if(twoArray[k][l] == 1) aliveCells++;
										}
									}
									for(int k = i - 1; k <= i + 1; k++){
										if((twoArray[k][twoArray[i].length - 1] == 1)) aliveCells++;
									}
									if(aliveCells == 3 && twoArray[i][j] == 0) twoArray2[i][j] = 1;
									else if(aliveCells < 3 && twoArray[i][j] == 1) twoArray2[i][j] = 0;
									else if(aliveCells > 4 && twoArray[i][j] == 1) twoArray2[i][j] = 0;
									else twoArray2[i][j] = twoArray[i][j];
								}
								
								//Works for the @Last Coloumn@
								else if(j == (twoArray[i].length - 1))
								{
									for(int k = i - 1; k <= i + 1; k++)
									{
										for(int l = j - 1; l <= j; l++)
										{
											if(twoArray[k][l] == 1) aliveCells++;
										}
									}
									for(int k = i - 1; k <= i + 1; k++){
										if((twoArray[k][0] == 1)) aliveCells++;
									}
									if(aliveCells == 3 && twoArray[i][j] == 0) twoArray2[i][j] = 1;
									else if(aliveCells < 3 && twoArray[i][j] == 1) twoArray2[i][j] = 0;
									else if(aliveCells > 4 && twoArray[i][j] == 1) twoArray2[i][j] = 0;
									else twoArray2[i][j] = twoArray[i][j];
								}
								//Works for the @Middle Coloumns@
								else{
									for(int k = i - 1; k <= i + 1; k++)
									{
										for(int l = j - 1; l <= j + 1; l++)
										{
											if(twoArray[k][l] == 1)  aliveCells++;
										}
									}
									if(aliveCells == 3 && twoArray[i][j] == 0) twoArray2[i][j] = 1;
									else if(aliveCells < 3 && twoArray[i][j] == 1) twoArray2[i][j] = 0;
									else if(aliveCells > 4 && twoArray[i][j] == 1) twoArray2[i][j] = 0;
									else twoArray2[i][j] = twoArray[i][j];
								}
							}
						}
					}
					
					//Storing everything from the second array to first array
					for (int i = 0; i < twoArray2.length; i++) 
					{
						for (int j = 0; j < twoArray2[i].length; j++) 
						{
							twoArray[i][j] = twoArray2[i][j];
						}
					}
					
					//Prints the main array
					for (int i = 0; i < twoArray2.length; i++) 
					{
						for (int j = 0; j < twoArray2[i].length; j++) 
						{
							System.out.print(twoArray[i][j]);
						}
						System.out.println();
					}
					
					//Makes program sleep for 1 second and adds the iteration to the menubar
					try 
					{
						Thread.sleep(1000);
						gui.addIteration();
						
					} 
					
					catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
					
				

					}

				}

	}
	
		private static void randomValue(int[][] twoArray) 
		{
		Random random = new Random();

		for (int i = 0; i < twoArray.length; i++) 
		{
			for (int j = 0; j < twoArray.length; j++)
			{
				twoArray[i][j] = random.nextInt(2);
			}
		}
	}
}

