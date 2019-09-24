/*  Name: <Justin Yee>
 *  COSC 311  FA19
 *  hw0919 5a
 *  URL:  <https://github.com/j9y/COSC-311>
 */
import java.util.*;
public class queue2 {
	public static Queue<Integer> sortedQ(Queue<Integer> q){
		Queue<Integer> queue1 = new LinkedList<Integer>();
		Queue<Integer> queue2 = new LinkedList<Integer>();
		while (!q.isEmpty()){
			queue1.add(q.remove());
		}
		while (!queue1.isEmpty()) {
			int next = queue1.remove();
			while (!queue2.isEmpty()&& next < queue2.peek()) {
				if(next < queue2.peek()) {
					queue1.add(queue2.remove());
				}
			}
			queue2.add(next);
		}
		return queue2;
	}
	public static void main (String[]args) {
		Queue<Integer>queue = new LinkedList<Integer>();
		queue.add(2);
		queue.add(3);
		queue.add(1);
		System.out.println("Unsorted Queue: " +queue);
		System.out.println("Sorted Queue: "+sortedQ(queue));
	}
}
