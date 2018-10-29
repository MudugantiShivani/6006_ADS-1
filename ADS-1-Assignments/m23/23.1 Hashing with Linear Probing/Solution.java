/**
 * Solution file.
 */
 import java.util.Scanner;
 /**
  * Solution class.
  */
  final class Solution {
    /**
     * default constructor.
     */
    private Solution() {

    }
    /**
     * Main function.
     * @param args String.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        LinearProbingHashST<String, Integer> hash =
        new LinearProbingHashST<String, Integer>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] str = sc.nextLine().split(" ");
            switch (str[0]) {
                case "put":
                   hash.put(str[1], Integer.parseInt(str[2]));
                break;
                case "display":
                hash.display();
                break;
                case "get":
                  System.out.println(hash.get(str[1]));
                break;
                case "delete":
                hash.delete(str[1]);

                break;
                default:
                break;
            }
        }


    }
  }