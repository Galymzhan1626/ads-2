import java.util.Iterator;

public class MyArrayList<T> implements MyListInterface{
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
    private void increaseBuffer() {
        T[] newArr = (T[]) new Object[arr.length*2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
    @Override
    public void set(int index, Object item) {
        arr[index]= (T) item;
    }

    @Override
    public void add(int index, Object item) {
        arr[index]= (T) item;
    }

    @Override
    public void addFirst(Object item) {
        for (int i = size-1; i < 0; i--) {
            arr[i+1]=arr[i];
        }
        arr[0]=(T) item;
    }

    @Override
    public void addLast(Object item) {
        arr[arr.length-1]= (T) item;
    }

    @Override
    public Object get(int index) {

        System.out.println( arr[index]);
        return null;
    }

    @Override
    public Object getFirst() {
        return arr[0];
    }

    @Override
    public Object getLast() {
        return arr[-1];
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
    public Iterator iterator() {
        return null;
    }
}