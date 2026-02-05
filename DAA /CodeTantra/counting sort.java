// You are given a task to sort an array of integers using the Counting Sort algorithm. Your program should follow these specifications:
// Input Format:
// The first line contains a single integer n, which represents the number of elements in the array.
//The second line contains n, space-separated integers, which are the elements of the array.
//Output Format:
// Print the sorted array on a single line, with elements separated by spaces.
// If the number of elements does not match n, print -1 and do not perform any sorting.

import java.util.*;

public class CountingSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());

        String[] tokens = sc.nextLine().trim().split("\\s+");

        if (tokens.length != n) {
            System.out.print("-1");
            return;
        }

        int[] arr = new int[n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
        }

        int range = max - min + 1;
        int[] count = new int[range];

        for (int i = 0; i < n; i++) {
            count[arr[i] - min]++;
        }

        boolean first = true;
        for (int i = 0; i < range; i++) {
            while (count[i] > 0) {
                if (!first) System.out.print(" ");
                System.out.print(i + min);
                first = false;
                count[i]--;
            }
        }
    }
}
