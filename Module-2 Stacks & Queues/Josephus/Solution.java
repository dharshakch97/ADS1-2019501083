import java.util.*;
class Solution {
	public static String Josephus(int a, int b) {
		String s = "";
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0; i < a; i++) {
			queue.add(i);
		}  
		while(queue.size()>1) {
			for(int i = 0; i < b - 1; i++) {
				queue.add(queue.remove());
			}
			s = s + queue.remove() + " ";
		}
		s = s + queue.remove();
		return s;
	}
}
	
