import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        List<MyTreeMap> treeList = new LinkedList<>();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < 20; i++) {
            MyTreeMap<Integer, Integer> myTreeMap = new MyTreeMap<>();
            for (int j = 0; j < random.nextInt(12); j++) {
                myTreeMap.put(j++, 100 - random.nextInt(201));
            }
            treeList.add(myTreeMap);
        }

        int count = 0;
        for (int i = 0; i < treeList.size(); i++) {
            count += treeList.get(i).isHeightBalanced() ? 1 : 0;
        }

        System.out.println(String.format("Total trees count: " + treeList.size()));
        System.out.println(String.format("Balanced: " + (count * 100 / treeList.size()) + " percent's"));
    }
}