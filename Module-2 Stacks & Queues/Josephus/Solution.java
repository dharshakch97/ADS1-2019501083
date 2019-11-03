/**
 * @author Dharshak
 * Solving Josephus problem for the given inputs 'a' and 'b'
 */
import java.util.*;
class Solution {
	/**
	 * @param a input size of the queue
	 * @param b bth value to be remmoved from the queue 
	 */
    public static String Josephus(int a, int b) {
		String s = "";
		//creating object for the Queue<Integer>
		Queue<Integer> queue = new Queue<Integer>(a); 
        for(int i = 0; i < a; i++)
            queue.enqueue(i); // enqueue 0..a
        while(!queue.isEmpty()) { // checks for queue is not empty
        	for(int i = 1; i < b; i++) {
				if(queue.getSize() == 1) 
					break;
            	queue.enqueue(queue.dequeue());
        	}
			s = s + queue.dequeue() + " ";
    	}
    	return s.trim();
	}
}
	
