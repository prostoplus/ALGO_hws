public class Program {

    public static void main(String[] args) {

        Graph graph = new Graph(10);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 5);
        graph.addEdge(2, 4);
        graph.addEdge(4, 6);
        graph.addEdge(6, 7);
        graph.addEdge(5, 7);
        graph.addEdge(7, 8);
        graph.addEdge(7, 9);
        graph.addEdge(8, 9);

        BreadthFirstSearch bfs = new BreadthFirstSearch(graph, 7);

        System.out.println(bfs.hasPathTo(3));
        System.out.println(bfs.pathTo(3));
        System.out.println(bfs.distTo(3));

        /*
        Вроде бы как всё понятно, вроде бы и не сильно сложно, но над каждым движением думаю по 30 минут)
        ЕСЛИ ВОЗМОЖНО, очень большая просьба уделить время сложным местам в теме про Графы, т.к. заходит гораздо сложнее деревьев.
        В проге всё работает, в дебаге проверял каждую итерацию, чтобы понять алгоритм работы, но всё равно мало въезжаю.
        Так же хотелось бы уделить хотя бы минут 5 поиску кротчайшего пути, а то чисто на бумаге, когда себе рисую я понимаю, но
        в проге я совсем туплю, не могу научиться мыслить как программист(..
         */
    }
}