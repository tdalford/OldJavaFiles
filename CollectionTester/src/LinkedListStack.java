import java.util.LinkedList;


public class LinkedListStack<E> implements APStack<E>
{
	private LinkedList<E> queue;
	
	public LinkedListStack ()
	{
		queue = new LinkedList<E>();
	}
	
	/**
	* Puts object obj onto the top of the stack.
	* @param object to add to the stack
	*/
	public void push(E obj)
	{
		queue.add(0, obj);
	}

	
	/**
	* Removes and returns the top elements of the stack.
	* @return the top element of the stack
	*/
	public E pop()
	{
		E obj = queue.remove(0);
		return obj;
	}

	/**
	* Returns (without removing) the top elements of the stack.
	* @return the top element of the stack
	*/
	public E peek()
	{
		E obj = queue.get(0);
		return obj;
	}

	/**
	* Returns true if the stack contains no elements, 
	* false otherwise.
	* @return true if stack is empty, false if it is not
	*/
	public boolean isEmpty()
	{
		if (queue.size() == 0)
		{
			return true;
		}
		return false;
	}
	
}
