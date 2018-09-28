import java.util.Scanner;
class Deque {
    Operations queueObject;
    Deque() {
        queueObject = new Operations();
    }
    public boolean isEmpty() {
        if (queueObject.size == 0) {
            return true;
        }
        return false;
    }
    public int size() {
        return queueObject.size;
    }
    public void pushLeft(int item) {
        queueObject.insertStart(item);
        print();
    }
    public void pushRight(int item) {
        queueObject.insertEnd(item);
        print();
    }
    public void popLeft() {
        if (queueObject.size == 0) {
            System.out.println("Deck is empty");
            return;
        }
        queueObject.deleteStart();
        print();
    }
    public void popRight() {
        if (queueObject.size == 0) {
            System.out.println("Deck is empty");
            return;
        }
        queueObject.deleteEnd();
        print();
    }
    public void print() {
        System.out.println(queueObject.print());
    }
}
public class Solution {
    Solution() {
    }
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