/******************* Program Identification ************************************************/
/* COURSE: CS 380		Data Structures 				                   */
/* PROJECT # : 	Project #3				                   			       */
/* DUE DATE :	3/3/16								                       */
/* SOURCE FILE :  QueueMaze.java            				               */
/* ********************************************************************************************/

public class QueueMaze 
{
	private Coord head;
	
	//Queue Constructor
	public QueueMaze()
	{
		head = new Coord(-1, -1);
		head.setPrevious(head);
		head.setNext(head);
		return;
	}
	
	//Removes the the coordinates from the beginning of the queue
	public Coord dequeue()
	{
		Coord newCoord = head.getNext();
		
		head.getNext().getNext().setPrevious(head);
		head.setNext(head.getNext().getNext());
		
		return newCoord;
	}
	
	//Adds the new coordinates to the end of the queue
	public void enqueue(Coord newCoord)
	{
		newCoord.setNext(head);
		newCoord.setPrevious(head.getPrevious());
		head.getPrevious().setNext(newCoord);
		head.setPrevious(newCoord);
	}
	
	//Looks at the next coordinates to dequeue (the ones at the beginning of the queue)
	public Coord queuePeek()
	{
		return head.getNext();
	}
	
	//Checks if the queue is empty
	public boolean isEmpty()
	{
		if(head == head.getNext())
		{
			return true;
		}
		return false;
	}
	
	//checks if the queue if full
	public boolean isFull()
	{
		Coord temp = new Coord(-1, -1);
		
		if(temp == null)
			return true;
		return false;
	}
	
	//Goes through the maze to see if a path exists from start to finish
	public boolean queuePathExists(char [][] maze, Coord startCoord, Coord endCoord)
	{
		queuePrintMaze(maze);
		
		enqueue(startCoord);
		maze[startCoord.getRow()][startCoord.getCol()] = '0';
		
		while(!isEmpty())
		{
			Coord temp = dequeue();
			
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
				enqueue(northCoord);
				maze[northCoord.getRow()][northCoord.getCol()] = '0';
				queuePrintMaze(maze);
			}
			//Checks East
			if(maze[temp.getRow()][temp.getCol() + 1] == '.')
			{
				Coord eastCoord = new Coord(temp.getRow(), temp.getCol() + 1);
				enqueue(eastCoord);
				maze[eastCoord.getRow()][eastCoord.getCol()] = '0';
				queuePrintMaze(maze);
			}
			//Checks South
			if(maze[temp.getRow() + 1][temp.getCol()] == '.')
			{
				Coord southCoord = new Coord(temp.getRow() + 1, temp.getCol());
				enqueue(southCoord);
				maze[southCoord.getRow()][southCoord.getCol()] = '0';
				queuePrintMaze(maze);
			}
			//Checks West
			if(maze[temp.getRow()][temp.getCol() - 1] == '.')
			{
				Coord westCoord = new Coord(temp.getRow(), temp.getCol() - 1);
				enqueue(westCoord);
				maze[westCoord.getRow()][westCoord.getCol()] = '0';
				queuePrintMaze(maze);
			}
		}
		//If there is no way to get to the destination
		if(isEmpty())
		{
			System.out.println("No solution.");
		}
		return false;
	}
	
	//Prints the current maze
	public void queuePrintMaze(char [][] maze)
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
