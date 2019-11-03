class Stack {
    Node top;

    public  void push(char data) {
        if (top == null) {
            top = new Node(data);
            return;
        }
        else {
            Node node = new Node(data);
            node.next = top;
            top = node;
        }
    }

    public char pop() {
        char temp = top.data;
        top = top.next;
        return temp;
    }
    public char getTop(){
        if(top == null){
            return ' ';
        }
        return top.data;
    }

}

class Node {
    char data;
    Node next;

    Node(char d) {
        data = d;
        next = null;
    }
}