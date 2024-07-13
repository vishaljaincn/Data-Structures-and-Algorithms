package day2_Introduction_to_arrays;

public class CheckIfThereExistsAPairSuchThat_AofI_Plus_AofJ_IsEqualTo_K {
    //    condition i!=j
    public static boolean checkSumBruteForce(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; i < n; j++) {
                if (i != j) {
                    if (arr[i] + arr[j] == k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkSumOptimisedUpperTriangle(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == k) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6,};
        System.out.println(checkSumBruteForce(arr, 5));
        System.out.println(checkSumOptimisedUpperTriangle(arr, 7));
    }
}
