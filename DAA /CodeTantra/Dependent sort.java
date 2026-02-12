// Magical Dependent Sort
import java.util.*;

public class DependentSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] A = new int[n];
        int[] B = new int[m];

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            B[i] = sc.nextInt();
        }

        // Frequency map of A
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : A) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        // Step 1: Follow order of B
        for (int num : B) {
            if (map.containsKey(num)) {
                int count = map.get(num);
                while (count-- > 0) {
                    result.add(num);
                }
                map.remove(num);
            }
        }

        // Step 2: Remaining elements
        List<Integer> remaining = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getKey();
            int count = entry.getValue();
            while (count-- > 0) {
                remaining.add(value);
            }
        }

        Collections.sort(remaining);

        result.addAll(remaining);

        // Print without trailing space
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i < result.size() - 1) {
                System.out.print(" ");
            }
        }
    }
}
