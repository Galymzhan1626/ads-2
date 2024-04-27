import com.sun.security.jgss.GSSUtil;

import java.util.Iterator;

public class MyArrayList<T> implements MyList{
    public T[] arr = (T[]) new Object[5];
    private int size;

    public MyArrayList(){
        size = 0;
    }
    @Override
    public void add(Object item) {
        if(size>=arr.length){
            increaseBuffer();
        }
        arr[size++] = (T) item;
    }
    @Override
    public void set(int index, Object item) {
        arr[index]= (T) item;
    }

    @Override
    public void add(int index, Object item) {
        checkIndex(index);
        if (size >= arr.length) {
            increaseBuffer();
        }
        for (int i = size - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }

        arr[index] = (T) item;
        size++;
    }


    @Override
    public void addFirst(Object item) {
        if (size >= arr.length) {
            increaseBuffer();
        }
        for (int i = size; i > 0; i--) {
            arr[i] = arr[i - 1];
        }

        arr[0] = (T) item;
        size++;
    }


    @Override
    public void addLast(Object item) {
        if (size >= arr.length) {
            increaseBuffer();
        }

        arr[size] = (T) item;
        size++;
    }


    @Override
    public T get(int index) {
        checkIndex(index);
        return arr[index];
    }

    @Override
    public T getFirst() {
        return arr[0];
    }

    @Override
    public T getLast() {
        return arr[size-1];
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size-1; i++) {
            arr[i]=arr[i+1];
        }
        size--;
    }

    @Override
    public void removeFirst() {
        if (size == 0) {
            System.out.println("List is empty");
        }
        remove(0);
    }

    @Override
    public void removelast() {
        if (size == 0) {
            System.out.println("List is empty");
        }
        remove(size - 1);
    }

    @Override
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (((Comparable<T>) arr[j]).compareTo((T) arr[j + 1]) > 0) {
                    T temp = (T) arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (arr[i]==object) {
                return i;
            }

        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
        if (arr[i]==object) {
            return i;
        }
    }
        return -1;

    }

    @Override
    public boolean exists(Object object) {
        for (int i = 0; i < size; i++) {
            if (arr[i]==object) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[size];
        for (int i = 0; i < size; i++) {
            newArray[i] = arr[i];
        }
        return newArray;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            arr[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void increaseBuffer() {
        T[] newArr = (T[]) new Object[arr.length*2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is not correct");
        }
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}