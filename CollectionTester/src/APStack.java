public interface APStack<E>
{
	/**
	* Puts object obj onto the top of the stack.
	* @param object to add to the stack
	*/
	public void push(E obj);

	/**
	* Removes and returns the top elements of the stack.
	* @return the top element of the stack
	*/
	public E pop();

	/**
	* Returns (without removing) the top elements of the stack.
	* @return the top element of the stack
	*/
	public E peek();

	/**
	* Returns true if the stack contains no elements, 
	* false otherwise.
	* @return true if stack is empty, false if it is not
	*/
	public boolean isEmpty();
}