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
        if (size == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        return head.item;
    }

    @Override
    public E getLast() {
        if (size == 0) {
        throw new IndexOutOfBoundsException("List is empty");
    }
        return tail.item;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        MyNode current = getNode(index);
        if (current.prev == null) {
            head = current.next;
        } else {
            current.prev.next = current.next;
        }
        if (current.next == null) {
            tail = current.prev;
        } else {
            current.next.prev = current.prev;
        }
        size--;
    }

    @Override
    public void removeFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        size--;
    }

    @Override
    public void removelast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        tail = tail.prev;
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
        size--;
    }

    @Override
    public void sort() {
    }

    @Override
    public int indexOf(Object object) {
        int index = 0;
        MyNode current = head;
        while (current != null) {
            if (current.item.equals(object)) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int lastIndex = -1;
        int index = 0;
        MyNode current = head;
        while (current != null) {
            if (current.item.equals(object)) {
                lastIndex = index;
            }
            index++;
            current = current.next;
        }
        return lastIndex;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        MyNode current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.item;
            current = current.next;
        }
        return array;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
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
