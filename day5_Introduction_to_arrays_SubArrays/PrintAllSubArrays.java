package day5_Introduction_to_arrays_SubArrays;

public class PrintAllSubArrays {
    public static void printAllSubArrays(int arr[]) {
        int n = arr.length;
        // For loop for start index
        for (int i = 0; i < n; i++) {
            // For loop for end index
            for (int j = i; j < n; j++) {
                // For loop to print sub_array elements
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        printAllSubArrays(arr);
    }
}
