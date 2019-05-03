public class Program {

    public static void main(String[] args) {
        Deque();
    }

    public static void Deque() {

        Reverser reverser = new Reverser();
        reverser.reverse(reverser.setString());


        Deque deque = new Deque(15);
        for (int i = 0; i < 15; i++) {
            deque.insertLeft(i);
        }
        System.out.println(deque);
        System.out.println(deque.removeLeft());
        System.out.println(deque.removeRight());
        System.out.println(deque.removeLeft());
        System.out.println(deque.removeRight());
        deque.insertLeft(10);
        System.out.println(deque.getStart());
        deque.insertLeft(11);
        System.out.println(deque.getStart());
        deque.insertLeft(12);
        System.out.println(deque.getStart());
        deque.insertRight(13);
        System.out.println(deque.getStart());
        System.out.println(deque);
        for (int i = 0; i < 15; i++) {
            deque.removeRight();
        }

        for (int i = 0; i < 15; i++) {
            deque.insertLeft(i + 10);
        }
        System.out.println(deque);

        System.out.println(deque.getCapacity() + " " + deque.getSize());
        System.out.println(deque.isFull());
        System.out.println(deque.isEmpty());
        System.out.println(deque.getStart() + " " + deque.getEnd());
        deque.removeRight();
        System.out.println(deque.getStart() + " " + deque.getEnd());
        deque.insertLeft(100);
        System.out.println(deque.getStart() + " " + deque.getEnd());
        System.out.println(deque);

    }

}