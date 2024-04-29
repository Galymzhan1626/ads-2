public class MyQueue<E> {
    private class Node<E> {
        E data;
        Node<E> next;
        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }
    private Node<E> front;
    private Node<E> rear;
    private int size;
    public MyQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }
    public void enqueue(E item) {
    }
    public E dequeue() {
        return null;
    }
    public boolean isEmpty() {
        return false;
    }
    public int size() {
        return 0;
    }
}

