import java.util.Iterator;
import java.util.LinkedList;

public class Program {
    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addFirst(10);
        linkedList.addFirst(20);
        linkedList.addFirst(30);
        linkedList.addFirst(40);
        linkedList.addFirst(50);
        System.out.println(linkedList);
        System.out.println(linkedList.size());
        System.out.println(linkedList.get(3));
        linkedList.set(1, 100);
        System.out.println(linkedList.get(1));
        System.out.println(linkedList);
        linkedList.addFirst(60);
        linkedList.addLast(70);
        linkedList.add(2, 80);
        System.out.println(linkedList);
        linkedList.removeLast();
        linkedList.removeFirst();
        System.out.println(linkedList.size());
        System.out.println(linkedList);
        System.out.println(" ");

        for (Integer item :
                linkedList) {
            System.out.print(item + ", ");
        }

        LinkedList<Integer> list = new LinkedList<>();
        Iterator<Integer> iterator = list.iterator();
    }
}