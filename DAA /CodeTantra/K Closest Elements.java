// Find k Closest Integers to c in a Sorted Array
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read size
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Read sorted array
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Read k and x
        int k = sc.nextInt();
        int x = sc.nextInt();

        // Two pointer approach
        int left = 0, right = n - 1;

        // Reduce window size until it becomes k
        while (right - left + 1 > k) {
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }

        // Print result (already sorted because original array is sorted)
        for (int i = left; i <= right; i++) {
            System.out.print(arr[i]);
            if (i < right) {
                System.out.print(" ");
            }
        }
    }
}
