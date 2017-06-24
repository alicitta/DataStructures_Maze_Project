/******************* Program Identification ************************************************/
/* COURSE: CS 380		Data Structures 				                   */
/* PROJECT # : 	Project #3				                   			       */
/* DUE DATE :	3/3/16								                       */
/* SOURCE FILE :  StackMaze.java            				               */
/* ********************************************************************************************/

public class StackMaze 
{
	private Coord head;

	//Stack Constructor
	public StackMaze()
	{
		head = new Coord(-1, -1);
		head.setPrevious(head);
		head.setNext(head);
		return;
	}
	
	//Takes the coordinates at the end of the stack
	public Coord pop()
	{
		Coord newCoord = head.getPrevious();
		
		head.setPrevious(head.getPrevious().getPrevious());
		head.getPrevious().setNext(head);
		return newCoord;
	}
	
	//Adds coordinates to the end of the stack
	public void push(Coord newCoord)
	{
		newCoord.setNext(head);
		newCoord.setPrevious(head.getPrevious());
		head.getPrevious().setNext(newCoord);
		head.setPrevious(newCoord);
		return;
	}
	
	//Looks at the next coordinates to pop (the ones at the end of the stack)
	public Coord stackPeek()
	{
		return head.getPrevious();
	}
	
	//Checks if stack is empty
	public boolean isEmpty()
	{
		if(head == head.getNext())
		{
			return true;
		}
		return false;
	}
	
	//Checks if stack is full 
	public boolean isFull()
	{
		Coord temp = new Coord(-1, -1);
		
		if(temp == null)
		{
			return true;
		}
		return false;
	}
	
	//Checks to see if there is a path to get from start coordinates to end coordinates
	public boolean stackPathExists(char [][] maze, Coord startCoord, Coord endCoord)
	{	
		push(startCoord);
		maze[startCoord.getRow()][startCoord.getCol()] = '0';
		
		while(!isEmpty())
		{
			Coord temp = pop();
			
			if(temp.getRow() == endCoord.getRow())
			{
				if(temp.getCol() == endCoord.getCol())
				{
					System.out.println("The maze has been solved.");
					return true;
				}
			}
			//Checks North
			if(maze[temp.getRow() - 1][temp.getCol()] == '.')
			{
				Coord northCoord = new Coord(temp.getRow() - 1, temp.getCol());
				push(northCoord);
				maze[northCoord.getRow()][northCoord.getCol()] = '0';
				stackPrintMaze(maze);
			}
			//Checks East
			if(maze[temp.getRow()][temp.getCol() + 1] == '.')
			{
				Coord eastCoord = new Coord(temp.getRow(), temp.getCol() + 1);
				push(eastCoord);
				maze[eastCoord.getRow()][eastCoord.getCol()] = '0';
				stackPrintMaze(maze);
			}
			//Checks South
			if(maze[temp.getRow() + 1][temp.getCol()] == '.')
			{
				Coord southCoord = new Coord(temp.getRow() + 1, temp.getCol());
				push(southCoord);
				maze[southCoord.getRow()][southCoord.getCol()] = '0';
				stackPrintMaze(maze);
			}
			//Checks West
			if(maze[temp.getRow()][temp.getCol() - 1] == '.')
			{
				Coord westCoord = new Coord(temp.getRow(), temp.getCol() - 1);
				push(westCoord);
				maze[westCoord.getRow()][westCoord.getCol()] = '0';
				stackPrintMaze(maze);
			}
		}
		//If there is no possible way to get to the destination
		if(isEmpty())
		{
			System.out.println("No solution.");
		}
		return false;
	}
	
	//Prints current maze
	public void stackPrintMaze(char [][] maze)
	{
		for(int row = 0; row < maze.length; row++)
		{
			for(int col = 0; col < maze[row].length; col++)
			{
				System.out.print(maze[row][col]);
			}
			System.out.println();
		}
		

		try 
		{
			Thread.sleep(1200);
			System.out.println();
			System.out.println();
		} 
		catch (InterruptedException except) 
		{
			except.printStackTrace();
		}
	}
}
