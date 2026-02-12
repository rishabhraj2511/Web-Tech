// Finding Student's Test Score Rank
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of students
        int n = sc.nextInt();
        int[] scores = new int[n];

        // Read scores
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        // Read target score
        int x = sc.nextInt();

        // Step 1: Sort scores in ascending order
        Arrays.sort(scores);

        // Step 2: Binary Search for LAST occurrence
        int left = 0, right = n - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (scores[mid] == x) {
                result = mid;      // store index
                left = mid + 1;    // move right to find last occurrence
            } 
            else if (scores[mid] < x) {
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}
