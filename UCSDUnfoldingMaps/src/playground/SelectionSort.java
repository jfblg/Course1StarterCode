package playground;

public class SelectionSort {
    public static void main(String[] args) {
        int[] cisla = {1, 4, 3, 5, 2 };
        int[] cisl2 = {1, 4, 3, 5, 2 };

        selectionSortInt(cisla);

        for (int c : cisla)
            System.out.println(c);

        System.out.println("----------");

        insertionSort(cisl2);
        for (int c: cisl2)
            System.out.println(c);
}

    public static void selectionSortInt(int[] unsorted) {

        for(int j=0; j < unsorted.length-1; j++) {
            int indexMin = j;
            for(int i=j+1; i<unsorted.length; i++) {
                if (unsorted[i] < unsorted[indexMin])
                    indexMin = i;
            }
            swap(unsorted, j, indexMin);
        }
    }

    public static void insertionSort(int[] vals) {
        int currInd;

        for (int pos=1; pos < vals.length; pos++) {
            currInd = pos;
            while(currInd > 0 && vals[currInd] < vals[currInd-1]) {
                swap(vals, currInd, currInd-1);
                currInd = currInd -1;
            }
        }
    }

    public static void swap(int[] vals, int i, int j) {
        int tmp = vals[i];
        vals[i] = vals[j];
        vals[j] = tmp;
    }

}
