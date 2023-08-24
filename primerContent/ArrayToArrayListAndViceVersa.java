package primerContent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToArrayListAndViceVersa {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5};

        // Convert array to ArrayList
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(arr));

        // Print the ArrayList
        System.out.println(arrayList1);

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        // Convert ArrayList to array
        Integer[] arr2 = arrayList.toArray(new Integer[arrayList.size()]);

        // Print the array
        for (Integer num : arr2) {
            System.out.print(num + " ");
        }
//        Arrays.asList use case with List interface not ArrayList Concrete Class
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

    }
}
