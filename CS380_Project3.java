/******************* Program Identification ************************************************/
/* COURSE: CS 380		Data Structures 				                   */
/* PROJECT # : 	Project #3			                   			           */
/* DUE DATE :	3/3/16								                       */
/* SOURCE FILE :  CS380_Project3.java            				       */
/* ********************************************************************************************/

import java.util.Scanner;

public class CS380_Project3
{
	public static char[][] maze1 = {
		{'X','X','X','X','X','X','X','X','X','X'},
		{'X','.','.','.','.','.','.','.','.','X'}, 
		{'X','X','.','X','.','X','X','X','X','X'},
		{'X','.','.','X','.','X','.','.','.','X'},
		{'X','.','.','X','.','.','.','X','.','X'},
		{'X','X','X','X','.','X','X','X','.','X'},
		{'X','.','X','.','.','.','.','X','X','X'},
		{'X','.','.','X','X','.','X','X','.','X'},
		{'X','.','.','.','X','.','.','.','.','X'},
		{'X','X','X','X','X','X','X','X','X','X'}};

	public static char[][] maze2 = {
		{'X','X','X','X','X','X','X','X','X','X'},
		{'X','X','.','.','.','.','.','X','.','X'},
		{'X','X','.','X','X','.','X','X','.','X'},
		{'X','X','.','.','X','.','.','.','.','X'},
		{'X','X','.','X','.','X','X','X','X','X'},
		{'X','X','.','X','.','X','X','X','X','X'},
		{'X','.','.','X','X','.','.','X','.','X'},
		{'X','.','X','X','.','X','.','X','.','X'},
		{'X','.','.','.','.','.','.','.','.','X'},
		{'X','X','X','X','X','X','X','X','X','X'}};

	public static char[][] maze3 = {
		{'X','X','X','X','X','X','X','X','X','X'},
		{'X','X','X','X','X','.','.','X','.','X'},
		{'X','X','X','X','.','X','X','X','X','X'},
		{'X','X','.','.','.','.','.','.','.','X'},
		{'X','.','.','X','X','.','.','X','.','X'},
		{'X','X','.','X','X','.','X','X','.','X'},
		{'X','X','X','X','.','.','.','X','.','X'},
		{'X','.','.','X','.','X','.','X','.','X'},
		{'X','X','.','X','.','.','X','X','X','X'},
		{'X','X','X','X','X','X','X','X','X','X'}};


	/***************************************************************************/
	/* 				MAIN PROGRAM				                               */
	/***************************************************************************/
	
	public static void main(String[] args) 
	{
		heading();
		
		Scanner scan = new Scanner(System.in);
		
		StackMaze stackMaze = new StackMaze();
		QueueMaze queueMaze = new QueueMaze();		
		
		//Scans in the users desired maze and method 
		System.out.println("Please select a maze (1, 2, or 3): ");
		int maze = scan.nextInt();
		System.out.println("Please select a method (stack - 1, queue - 2): ");
		int method = scan.nextInt();
		
		//Goes through the desired maze with the desired method
		if(maze == 1)
		{
			Coord startCoord = new Coord(7,8);
			Coord endCoord = new Coord(1,8);
			
			System.out.println("Starting Coordinates: (7,8)");
			System.out.println("Ending Coordinates: (1,8)");
			
			if(method == 1)
			{
				stackMaze.stackPathExists(maze1, startCoord, endCoord);
			}
			if(method == 2)
			{
				queueMaze.queuePathExists(maze1, startCoord, endCoord); 
			}
		}
		else if(maze == 2)
		{
			Coord startCoord = new Coord(7,1);
			Coord endCoord = new Coord(6,2);
			
			System.out.println("Starting Coordinates: (7,1)");
			System.out.println("Ending Coordinates: (6,2)");
			
			if(method == 1)
			{
				stackMaze.stackPathExists(maze2, startCoord, endCoord);
			}
			if(method == 2)
			{
				queueMaze.queuePathExists(maze2, startCoord, endCoord); 
			}	
		}
		else if(maze == 3)
		{
			Coord startCoord = new Coord(8,4);
			Coord endCoord = new Coord(8,2);
			
			System.out.println("Starting Coordinates: (8,4)");
			System.out.println("Ending Coordinates: (8,2)");
			
			if(method == 1)
			{
				stackMaze.stackPathExists(maze3, startCoord, endCoord);
			}
			if(method == 2)
			{
				queueMaze.queuePathExists(maze3, startCoord, endCoord); 
			}	
		}
		footing();
	}
	
	/*			FUNCTION HEADING	 	                                  */
	/**********************************************************************/
	public static void heading()
	{                         // Function heading 
		System.out.println();
		System.out.println ( "Ali Citta     CS 380  ");
		System.out.println ( "Spring 2016   Project #3");
		System.out.println ();
		System.out.println ();
		return;
	}   // Function heading 
	/*************************************************************************/    
	/*************************************************************************/
	/*			FUNCTION FOOTING	 	                                     */
	/*************************************************************************/
	public static void footing()
	{                        // Function footing 
		System.out.println ();
		System.out.println ();
		System.out.println ( "END OF OUTPUT");
		System.out.println ();
		return;
	}   // Function footing
	/***************************************************************************/
}