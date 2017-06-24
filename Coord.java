/******************* Program Identification ************************************************/
/* COURSE: CS 380		Data Structures 				                   */
/* PROJECT # : 	Project #3				                   			       */
/* DUE DATE :	3/3/16								                       */
/* SOURCE FILE :  Coord.java            				                   */
/* ********************************************************************************************/

public class Coord 
{
	private int m_row, m_col;
	Coord next, previous;
	
	//Constructor
	public Coord(int rrow, int ccol)
	{
		m_row = rrow;
		m_col = ccol;
		next = null;
		previous = null;
	}
	
	//Returns the row value
	public int getRow()
	{
		return m_row;
	}
	
	//Returns the column value
	public int getCol()
	{
		return m_col;
	}
	
	//Sets the new coordinate to the next node
	public void setNext(Coord newNode)
	{
		next = newNode;
	}
	
	//Returns the next node
	public Coord getNext()
	{
		return next;
	}
	
	//Sets the new coordinate to the previous node
	public void setPrevious(Coord newNode)
	{
		previous = newNode;
	}
	
	//Returns the previous node
	public Coord getPrevious()
	{
		return previous;
	}
}
