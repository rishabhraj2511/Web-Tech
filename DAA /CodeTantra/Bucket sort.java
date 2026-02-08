// You are given a task to sort an array of integers using the Bucket Sort algorithm. Your program should follow these specifications:

// input Format:
// The first line contains a single integer n, which represents the number of elements in the array.
// The second line contains n space-separated integers, which are the elements of the array.

// Output Format:
// Print the sorted array on a single line, with elements separated by spaces.
import java.util.*;

public class BucketSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of elements
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Apply Bucket Sort
        bucketSort(arr, n);

        // Print sorted array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
    }

    // Bucket Sort function
    static void bucketSort(int[] arr, int n) {
        if (n <= 0) return;

        // Find min and max values
        int min = arr[0], max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
        }

        // Create buckets
        int bucketCount = n;
        List<Integer>[] buckets = new ArrayList[bucketCount];

        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Distribute elements into buckets
        for (int i = 0; i < n; i++) {
            int index = (int)((long)(arr[i] - min) * (bucketCount - 1) / (max - min + 1));
            buckets[index].add(arr[i]);
        }

        // Sort individual buckets and merge
        int idx = 0;
        for (int i = 0; i < bucketCount; i++) {
            Collections.sort(buckets[i]);
            for (int value : buckets[i]) {
                arr[idx++] = value;
            }
        }
    }
}
