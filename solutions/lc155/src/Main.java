import java.util.ArrayDeque;

class MinStack {

    protected ArrayDeque<Node> queue = new ArrayDeque();

    public MinStack() {

    }

    public void push(int val) {
        int minVal;
        if (queue.isEmpty()) {
            minVal = val;
        } else {
            minVal = queue.getFirst().minValue;
            if (minVal > val) {
                minVal = val;
            }
        }
        Node newNode = new Node(val, minVal);
        queue.addFirst(newNode);
    }

    public void pop() {
        queue.removeFirst();
    }

    public int top() {
        Node first = queue.getFirst();
        return first.value;
    }

    public int getMin() {
        Node first = queue.getFirst();
        return first.minValue;
    }
}

class Node {
    public int value;
    public int minValue;

    public Node(int value, int minValue) {
        this.value = value;
        this.minValue = minValue;
    }
}