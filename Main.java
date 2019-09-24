import java.util.*;
public class Main {
	public static void main(String[]args) {
		Queue<Integer>queue = new PriorityQueue<Integer>();
		queue.add(0);
		queue.add(4);
		queue.add(3);
		queue.add(1);
		queue.add(2);
		List<Integer> list = new LinkedList<Integer>();
		list.addAll(queue);
		Collections.sort(list);
		Iterator<Integer> i = list.iterator();
		System.out.println("Ordered Queue:");
		while(i.hasNext()) {
			System.out.print(i.next()+" ");
		}
	}
}
