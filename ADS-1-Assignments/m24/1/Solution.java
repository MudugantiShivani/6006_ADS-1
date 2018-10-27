import java.util.Scanner;
/**
 * { class for Solution where we use the files Queue and Linear probing
 * hashing tree to insert and search the elements in constant time}.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * { main class for the solution where we create objects for the files
     * we used and search the elements in constant time}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = Integer.parseInt(scan.nextLine());
        LinearProbingHashST<Integer, String> lph =
        new LinearProbingHashST<Integer, String>();
        for (int i = 0; i < a; i++) {
            String[] tokens = scan.nextLine().split(",");
            String str = tokens[1] + "," + tokens[2];
            lph.put(Integer.parseInt(tokens[0]), str);
        }
        int b = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < b; i++) {
            String[] tokens1 = scan.nextLine().split(" ");
            String str = lph.get(Integer.parseInt(tokens1[1]));
            if (str != null) {
                String[] tokens2 = str.split(",");
                if (Integer.parseInt(tokens1[2]) == 1) {
                    System.out.println(tokens2[0]);
                } else {
                    System.out.println(Double.parseDouble(tokens2[1]));
                }
            } else {
                    System.out.println("Student doesn't exists...");
            }
        }
    }
}
