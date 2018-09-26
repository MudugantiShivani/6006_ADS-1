import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
final class Solution {
    private Solution() {

    }
    static String getlow(final List arr) {
        String high = "";
        high = "" + arr.get(0);
        for (int i = 0; i < arr.size(); i++) {
            if (Integer.parseInt("" + arr.get(i)) < Integer.parseInt(high)) {
                high = "" + arr.get(i);
            }
        }
        return high;
	}
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int sizeA = sc.nextInt();
        int sizeB = sc.nextInt();
        sc.nextLine();
        String[] arrA = sc.nextLine().split(",");
        String[] arrB = sc.nextLine().split(",");
        String[] ans = new String[(sizeA + sizeB)];
        System.arraycopy(arrA, 0, ans, 0, sizeA);
        System.arraycopy(arrB, 0, ans, sizeA, sizeB);
        List<String> ans1 = new ArrayList<String>();
        Collections.addAll(ans1, ans);
        while (ans1.size() > 0) {
            String high = getlow(ans1);
            if (ans1.size() == 1) {
                System.out.print(high);

            }// else {
            //     System.out.print(high + ",");
            // }
            ans1.remove(high);
        }

    }
}