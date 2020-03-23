package playground;

import java.util.*;

public class SortBuildInToJava {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> numsToSort = new ArrayList<>();

        for (int i=0; i<5; i++) {
            numsToSort.add(random.nextInt(100));
        }

        System.out.println(numsToSort);
        Collections.sort(numsToSort);
        System.out.println(numsToSort);

    }

}
