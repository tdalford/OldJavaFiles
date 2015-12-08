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
	LinkedListQueue<String> list = new LinkedListQueue<String>();
	list.enqueue("Bob");
	list.enqueue("Josh");
	list.enqueue("Brice");
	while(!list.isEmpty())
	{
	System.out.println(list.peekFront());
	System.out.println(list.dequeue());
	System.out.println();
	}
	}
}
