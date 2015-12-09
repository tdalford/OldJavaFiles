import java.util.LinkedList;


public class LinkedListQueue<E> implements APQueue<E>
{
private LinkedList<E> queue;
	
	public LinkedListQueue ()
	{
		queue = new LinkedList<E>();
	}
	public void enqueue(E obj)
	{
		queue.add(obj);
	}
	public E dequeue()
	{
		E obj = queue.remove(0);
		return obj;
	}
	public E peekFront()
	{
		E obj = queue.get(0);
		return obj;
	}
	public boolean isEmpty()
	{
		if (queue.size() == 0)
		{
			return true;
		}
		return false;
	}
	
	public static void main(String[] args)
	{
	long startTime = System.nanoTime();
	LinkedListStack<String> list = new LinkedListStack<String>();
	list.push("Bob");
	list.push("Josh");
	list.push("Brice");
	while(!list.isEmpty())
	{
	System.out.println(list.peek());
	System.out.println(list.pop());
	System.out.println();
	}
	long endTime = System.nanoTime();
	System.out.println(endTime - startTime);
	}
}
