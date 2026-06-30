import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'twoStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER maxSum
     *  2. INTEGER_ARRAY a
     *  3. INTEGER_ARRAY b
     */

    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        // Push in reverse so that front of list is at top
        for (int i = a.size() - 1; i >= 0; i--) s1.push(a.get(i));
        for (int i = b.size() - 1; i >= 0; i--) s2.push(b.get(i));

        int sum = 0, ans = 0;
        int count = 0;

        // Track what we took from a
        Stack<Integer> takenA = new Stack<>();

        // Take as many as possible from stack a
        while (!s1.isEmpty() && sum + s1.peek() <= maxSum) {
            int val = s1.pop();
            sum += val;
            takenA.push(val);
            count++;
        }
        ans = count;

        // Now try adding from stack b
        while (!s2.isEmpty()) {
            sum += s2.pop();
            count++;

            // If sum exceeds maxSum, remove from what we took from a
            while (sum > maxSum && !takenA.isEmpty()) {
                sum -= takenA.pop();
                count--;
            }

            if (sum <= maxSum) {
                ans = Math.max(ans, count);
            }
        }

        return ans;
    }

}
public class gameOfTwoStacks {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, g).forEach(gItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int maxSum = Integer.parseInt(firstMultipleInput[2]);

                List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                int result = Result.twoStacks(maxSum, a, b);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
