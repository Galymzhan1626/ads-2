public class Main {
    public static void main(String[] args){
        MyArrayList<Object> myList=new MyArrayList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);
        myList.addFirst(7);

        System.out.println(myList.getFirst());
        System.out.println(myList.get(1));
        System.out.println(myList.getLast());
        System.out.println(myList.indexOf(7));
    }
}
