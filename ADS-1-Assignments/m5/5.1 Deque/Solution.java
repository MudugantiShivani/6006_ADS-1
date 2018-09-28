import java.util.Scanner;
/**
 * Class for deque.
 */
class Deque {
    /**
     * { operation object}.
     */
    private Operations queueObject;
    /**
     * Constructs the object.
     */
    Deque() {
        queueObject = new Operations();
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        if (queueObject.size == 0) {
            return true;
        }
        return false;
    }
    /**
     * { returns the size }.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return queueObject.size;
    }
    /**
     * Pushes a left.
     *
     * @param      item  The item
     */
    public void pushLeft(final int item) {
        queueObject.insertStart(item);
        print();
    }
    /**
     * Pushes a right.
     *
     * @param      item  The item
     */
    public void pushRight(final int item) {
        queueObject.insertEnd(item);
        print();
    }
    /**
     * { pops the element in the left}.
     */
    public void popLeft() {
        if (queueObject.size == 0) {
            System.out.println("Deck is empty");
            return;
        }
        queueObject.deleteStart();
        print();
    }
    /**
     * {pops the element from the right }.
     */
    public void popRight() {
        if (queueObject.size == 0) {
            System.out.println("Deck is empty");
            return;
        }
        queueObject.deleteEnd();
        print();
    }
    /**
     * { prints the list }.
     */
    public void print() {
        System.out.println(queueObject.print());
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * {main function}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque obj = new Deque();
        while (scan.hasNext()) {
            String line = scan.nextLine();
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
                case "isEmpty":
                    System.out.println(obj.isEmpty());
                    break;
                case "size":
                    System.out.println(obj.size());
                    break;
                case "pushLeft":
                    obj.pushLeft(Integer.parseInt(
                        tokens[1]));
                    break;
                case "pushRight":
                    obj.pushRight(Integer.parseInt(
                        tokens[1]));
                    break;
                case "popLeft":
                    obj.popLeft();
                    break;
                case "popRight":
                    obj.popRight();
                    break;
                default : break;
            }

        }

    }
}
