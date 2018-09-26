import java.util.Scanner;
import java.util.Arrays;
/**
 * { program to give number of sums which is zero for three numbers}.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { main function }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int count =  Integer.parseInt(sc.nextLine());
        int[] list;
        int ans = 0;
        list = new int[count];
        for (int i = 0; i < count; i++) {
            int a =  Integer.parseInt(sc.nextLine());
            list[i] = a;
        }
        Arrays.sort(list);
        final int three = 3;
        for (int i = 0; i < count - three; i++) {
            int j = i + 1;
            int k = count - 1;
            while (k > j) {
                int sum = list[i] + list[j] + list[k];
                if (sum == 0) {
                    ans++;
                }
                if (sum > 0) {
                    k--;
                } else {
                    j++;
                }

            }
        }
        System.out.println(ans);
    }
}
