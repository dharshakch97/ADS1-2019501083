class Solution {
	public static String Josephus(int a, int b){
		// fill you code Here
        CircularDoubleLL josephus = new CircularDoubleLL();

        for (int i = 0; i < a; i++)
            josephus.add(i);
       josephus.formCircle();

       int p = 1;
       Node t = josephus.head;

       int e = 0;
       String toRet = "";

       while (e != a) {
           t = t.next;
           p++;

           if (p == b) {
               p = 1;
               toRet += t.data + " ";

               Node prevNode = t.prev;
               Node nextNode = t.next;

               prevNode.next = nextNode;
               nextNode.prev = prevNode;

               e++;
               t = t.next;
            }
       }
       toRet = toRet.trim();
       return toRet;
	}
}

        // String s = "";
        // // Queue queue = new Queue();
        // Queue queue = new Queue();
        // for (int i = 0; i < a; i++)
        //     queue.enqueue(i);

        // while (!queue.isEmpty()) {
        //     for (int i = 0; i < b-1; i++)
        //         queue.enqueue(queue.dequeue());
        //     // System.out.println(queue.dequeue() + " ");
        //     s = s + queue.dequeue() + " ";
        // } 
        // // System.out.println();
        // s += queue.dequeue();
		// return s;

