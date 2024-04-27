import java.util.Iterator;

public class MyLinkedList<E> implements MyList<E>{
    private class MyNode {
        E item;
        MyNode next;
        MyNode prev;

        public MyNode(E item, MyNode prev, MyNode next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    @Override
    public void add(E item) {
        addLast(item);
    }

    @Override
    public void set(int index, E item) {
        checkIndex(index);
        MyNode current = getNode(index);
        current.item = item;
    }

    @Override
    public void add(int index, E item) {
        checkIndex(index);
        if (index == size) {
            addLast(item);
        } else if (index == 0) {
            addFirst(item);
        } else {
            MyNode prevNode = getNode(index - 1);
            MyNode newNode = new MyNode(item, prevNode, prevNode.next);
            prevNode.next.prev = newNode;
            prevNode.next = newNode;
            size++;
        }
    }

    @Override
    public void addFirst(E item) {
        if (size == 0) {
            head = tail = new MyNode(item, null, null);
        } else {
            MyNode newNode = new MyNode(item, null, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(E item) {
        if (size == 0) {
            head = tail = new MyNode(item, null, null);
        } else {
            MyNode newNode = new MyNode(item, tail, null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        MyNode current = getNode(index);
        return current.item;
    }

    @Override
    public E getFirst() {
        return null;
    }

    @Override
    public E getLast() {
        return null;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removelast() {

    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object object) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object object) {
        return 0;
    }

    @Override
    public boolean exists(Object object) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is not correct");
        }
    }
    private MyNode getNode(int index) {
        checkIndex(index);
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}
