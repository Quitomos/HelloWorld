package Basic;

import java.util.*;


public class Container {
    public static void main(String[] args) {
//        ArrayList As = new ArrayList();
//
//        As.add(new A(1));
//        As.add(new A(2));
//        As.add(0, new A(3));
//
//        A[] aa = (A[])As.toArray(new A[0]);
//
//        As.add(new HelloJava());
//
//        A a = (A)As.get(3);
//
//        HashMap<A, A> mm = new HashMap<>();
//        HashSet<A> ms = new HashSet<>();
//        System.out.println(As);

//        List<Integer> ml = new ArrayList<>();
//        for (int i = 0; i < 10; ++i) {
//            ml.add(i);
//        }
//        int n = 1000000;
//        int cnt = 0;
//        while (n-- != 0) {
//            Collections.shuffle(ml);
//            if (ml.get(0) == 3 && ml.get(1) == 1 && ml.get(2) == 4) ++cnt;
//        }
//        System.out.println(cnt / 1000000d);
        List<B> ml = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            ml.add(new B(i));
        }
        Comparator<A> cmp = new Comparator<A>() {
            @Override
            public int compare(A o1, A o2) {
                return o1.a < o2.a ? 1: -1;
            }
        };
        Comparator<Integer> cmp2 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2? 1: -1;
            }
        };
        Collections.sort(ml, (A o1, A o2) -> o1.a < o2.a? 1: -1);
        TreeSet<Integer> ms = new TreeSet<>();
        for (int i = 0; i < 10; ++i) {
            ms.add(i);
        }
        System.out.println(ml);

        int[] a = new int[101];

        Arrays.fill(a, 0);
        List<? super A> ml2 = new ArrayList<>();
        ml2.add(new A());

    }
}


