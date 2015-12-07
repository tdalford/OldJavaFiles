import java.util.ArrayList;
public class ArrayListQueue<E> implements APQueue<E>
{
	private ArrayList<E> queue;
	
	public ArrayListQueue ()
	{
		queue = new ArrayList<E>();
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
	ArrayListQueue<String> list = new ArrayListQueue<String>();
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
