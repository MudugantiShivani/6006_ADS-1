import java.util.Scanner;
/**
 * Class for add large numbers.
 */
class AddLargeNumbers {
    static LinkedList objct;
    static LinkedList objct1;
    /**
     * { function_description }.
     *
     * @param      number  The number
     *
     * @return     { description_of_the_return_value }
     */
    public static LinkedList numberToDigits(final String number) {
        objct = new LinkedList();
        String[] result = number.split("", number.length());
        for (int i = 0; i < result.length; i++) {
            objct.insertEnd(Integer.parseInt(result[i]));
        }
        return objct;
    }
    /**
     * { function_description }.
     *
     * @param      list  The list
     *
     * @return     { description_of_the_return_value }
     */
    public static String digitsToNumber(final LinkedList list) {
        String result = "";
        while (list.size != 0) {
            result = result + list.deleteStart();
        }
        return result;
    }
    /**
     * Adds large numbers.
     *
     * @param      list1  The list 1
     * @param      list2  The list 2
     *
     * @return     { description_of_the_return_value }
     */
    public static LinkedList addLargeNumbers(final LinkedList list1, final LinkedList list2) {
        objct1 = new LinkedList();
        int result = 0;
        int carry = 0;
        while (list1.size != 0 && list2.size != 0) {
            result = list1.deleteStart() + list2.deleteStart() + result;
            //objct1.insertStart((result));
            int sum = 0;
            sum = result + carry;

            result = sum % 10;
            objct1.insertStart(result);
            carry = sum / 10;

        }
        //objct1.insertStart(result);
        return objct1;
    }
}
/**
 * Class for solution.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch (input) {
        case "numberToDigits":
            LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
            LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
            System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
            System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
            break;

        case "addLargeNumbers":
            pDigits = AddLargeNumbers.numberToDigits(p);
            qDigits = AddLargeNumbers.numberToDigits(q);
            LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
            System.out.println(AddLargeNumbers.digitsToNumber(result));
            break;
        }
    }

}
