// Fixing Temperature Records
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read full line (comma separated)
        String input = sc.nextLine().trim();

        if (input.length() == 0) {
            System.out.println(0);
            return;
        }

        String[] parts = input.split(",");

        int n = parts.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(parts[i].trim());
        }

        int left = -1, right = -1;

        // Find first violation from left
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                left = i;
                break;
            }
        }

        // If already sorted
        if (left == -1) {
            System.out.println(0);
            return;
        }

        // Find first violation from right
        for (int i = n - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                right = i;
                break;
            }
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = left; i <= right; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        // Expand left
        for (int i = 0; i < left; i++) {
            if (arr[i] > min) {
                left = i;
                break;
            }
        }

        // Expand right
        for (int i = n - 1; i > right; i--) {
            if (arr[i] < max) {
                right = i;
                break;
            }
        }

        System.out.println(right - left + 1);
    }
}
