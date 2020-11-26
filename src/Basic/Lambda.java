package Basic;
import java.util.*;

public class Lambda {
    public static void main(String[] args) {
        int[] a = new int[10];
        Arrays.fill(a, 1);
        int[] b = Arrays.stream(a).distinct().toArray();

        List<Integer> ml = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            ml.add(i);
        }

        List<Integer> ml2 = new ArrayList<>();
        ml.stream().distinct().forEach(ml2::add);
        System.out.println(ml.stream().skip(3).findFirst());
    }
}
