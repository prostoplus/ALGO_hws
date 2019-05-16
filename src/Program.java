public class Program {

    public static void main(String[] args) {

        System.out.println(expo(5, 4));
        System.out.println(expoRec(5, 4));
        hanoiRec(4, 1, 2, 3);
    }

    public static int expoRec(int n, int x) {
        if (x == 0) return 1;
        if (x % 2 == 1) return expoRec(n, x - 1) * n;
        else {
            int b = expoRec(n, x / 2);
            return b * b;
        }
    }

    public static int expo(int n, int x) {
        int result = n;
        if (x == 0) return 1;
        if (x == 1) return n;
        while (x > 1) {
            result *= n;
            --x;
        }
        return result;
    }

    public static void hanoiRec(int n, int from, int to, int additional) {
        if (n == 0) return;
        hanoiRec(n - 1, from, additional, to);
        System.out.println(from + " " + to);
        hanoiRec(n - 1, additional, to, from);
    }

    public static void hanoi() {
        int n = 4;
        int from = 0;
        int to = 2;
        int additional = 1;

        /*
        сначало облазил пол интернета в поиске помощи, потом почитал я логику нерекурсивного метода вот здесь:
        http://algolist.manual.ru/maths/combinat/hanoi.php
        и в итоге понял, что это тяжело для меня пока что. смысл я понимаю полностью, но как реализовать это
        я просто без понятия..
        я так понял, что нам нужно будет использоваить стэк, который будем обновлять
        после каждой итерации(перекладывания кольца).
         */

    }

}
