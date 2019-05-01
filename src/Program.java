import java.util.Comparator;
import java.util.Collections;
import java.util.Random;

public class Program {

    public static void main(String[] args) {

        MyArrayList<Integer> list1 = new MyArrayList<>();
        MyArrayList<Integer> list2 = new MyArrayList<>();
        long a = System.currentTimeMillis();


        for (int i = 0; i < 101; i++) {
            list1.add((int) Math.round(Math.random() * 101));
        }

        System.out.println(list1);
        list1.selectionSort(new CharacterComparator());
        long b = System.currentTimeMillis();
        System.out.println(list1);
        System.out.println(b - a);

        for (int i = 0; i < 101; i++) {
            list2.add((int) Math.round(Math.random() * 101));
        }

        System.out.println(list2);
        list2.insertionSort(new CharacterComparator());
        System.out.println(list2);
        long c = System.currentTimeMillis();
        System.out.println(c - a);

    }

}

/*
Вместо таблицы:
1. 28     32
2. 26     30
3. 26     29
4 .24     27
5. 26     29
6. 27     30
7. 26     29
8. 25     28
9. 29     33
10.29     32
 */