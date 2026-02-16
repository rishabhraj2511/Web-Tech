// Given n items, each with a given weight and value, you need to determine the maximum total value 
// that can be obtained by placing these items into a knapsack with a capacity of w.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), W = sc.nextInt();
        double[][] items = new double[n][2];

        for (int i = 0; i < n; i++) {
            items[i][0] = sc.nextDouble(); // value
            items[i][1] = sc.nextDouble(); // weight
        }

        Arrays.sort(items, (a, b) -> 
            Double.compare(b[0]/b[1], a[0]/a[1])
        );

        double total = 0;

        for (int i = 0; i < n && W > 0; i++) {
            if (items[i][1] <= W) {
                total += items[i][0];
                W -= items[i][1];
            } else {
                total += (items[i][0] / items[i][1]) * W;
                W = 0;
            }
        }

        System.out.printf("%.6f", total);
    }
}
