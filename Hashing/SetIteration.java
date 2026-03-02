import java.util.*;

public class SetIteration {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(10);
        set.add(2);
        set.add(3);
        set.add(8);

        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        for (Integer i : set) {
            System.out.println(i);
        }
    }
}
