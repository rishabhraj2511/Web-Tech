// You are given a task to sort an array of integers using the Radix Sort algorithm. Your program should follow these specifications:

// Input Format:
// The first line contains a single integer n, which represents the number of elements in the array.
// The second line contains n space-separated integers, which are the elements of the array.

// Output Format:
// Print the sorted array on a single line, with elements separated by spaces.
import java.util.*;

public class RadixSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read n
        int n = Integer.parseInt(sc.nextLine().trim());

        // Read full array line
        String[] tokens = sc.nextLine().trim().split("\\s+");

        // Validate count
        if (tokens.length != n) {
            System.out.print("-1");
            return;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }

        // Separate negative and non-negative numbers
        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();

        for (int x : arr) {
            if (x < 0) neg.add(-x);   // store absolute value
            else pos.add(x);
        }

        // Apply radix sort
        radixSort(pos);
        radixSort(neg);

        // Print result: negatives (reverse) then positives
        boolean first = true;

        for (int i = neg.size() - 1; i >= 0; i--) {
            if (!first) System.out.print(" ");
            System.out.print(-neg.get(i));
            first = false;
        }

        for (int x : pos) {
            if (!first) System.out.print(" ");
            System.out.print(x);
            first = false;
        }
    }

    // Radix Sort for non-negative integers
    private static void radixSort(List<Integer> list) {
        if (list.size() == 0) return;

        int max = Collections.max(list);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(list, exp);
        }
    }

    // Counting sort used by radix sort
    private static void countingSort(List<Integer> list, int exp) {
        int n = list.size();
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            int digit = (list.get(i) / exp) % 10;
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digit = (list.get(i) / exp) % 10;
            output[count[digit] - 1] = list.get(i);
            count[digit]--;
        }

        for (int i = 0; i < n; i++) {
            list.set(i, output[i]);
        }
    }
}
