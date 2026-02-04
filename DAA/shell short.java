//You are given a task to sort an array of integers using the Shell Sort algorithm. Your program should follow these specifications:
//Input Format:
//The first line contains a single integer n , which represents the number of elements in the array.
//The second line contains n space-separated integers, which are the elements of the array.
//Output Format:
// Print the sorted array on a single line, with elements separated by spaces.
// If the number of elements does not match n, print -1 and do not perform any sorting.


import java.util.*;
public class main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        String[] tokens = sc.nextLine().trim().split("\\s+");
        if (tokens.length != n) {
            System.out.print("-1");
            return;
        }
      int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                 while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n - 1) System.out.print(" ");
        }
    }
}
