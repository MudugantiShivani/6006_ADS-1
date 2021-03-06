import java.util.Scanner;
/**
 * {solution class}.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        /**
         * { empty constructor}.
         */

    }
    /**
     * { main class for solution}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList linkobj = new LinkedList();
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(" ");
            switch (line[0]) {
            case "insertAt":
                try {
    linkobj.insertAt(Integer.parseInt(line[1]), new Node(line[2]));
                    linkobj.display();
                } catch (Exception e) {
                    System.out.println("Can't insert at this position.");

                }
                break;
            case "reverse":
                try {
                    linkobj.reverse();
                    linkobj.display();
                } catch (Exception e) {
                    System.out.println("No elements to reverse.");
                }
                break;
            default:
                break;

            }
        }
    }
}



