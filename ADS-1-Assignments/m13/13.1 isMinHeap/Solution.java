import java.util.Scanner;
/**
 * { main class solution }.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**here the orderof time complexity in the main method is O(N).
    */
    /**
     * { main function }.
     *
     * @param      args  The arguments
     */
    
    public static void main(final String[] args) {
        /**
         * { Scanner object to scan the input }.
         */
        Scanner scan = new Scanner(System.in);
        String dataType = scan.nextLine();
        int noOfTestCases = Integer.parseInt(scan.nextLine());
        MinPQ checkObj = new MinPQ();
        /**
         * input reading depending on the type of input
         * complexity: O(N)
         * string format is converted to respective dataType while reading
         */
        switch (dataType) {
        case "String":
            while (scan.hasNext()) {
                String[] array = scan.nextLine().split(",");
                String[] strArr = new String[array.length + 1];
                int index1 = 0;
                for (int index = 1; index <= array.length; index++) {
                    strArr[index] = array[index1];
                    index1++;
                }
                System.out.println(checkObj.check(strArr));
            }
            break;
        case "Integer":
            while (scan.hasNext()) {
                String[] array = scan.nextLine().split(",");
                Integer[] intArr = new Integer[array.length + 1];
                int index1 = 0;
                for (int index = 1; index <= array.length; index++) {
                    intArr[index] = Integer.parseInt(array[index1]);
                    index1++;
                }
                System.out.println(checkObj.check(intArr));
            }
            break;
        case "Double":
            while (scan.hasNext()) {
                String[] array = scan.nextLine().split(",");
                Double[] doubleArr = new Double[array.length + 1];
                int index1 = 0;
                for (int index = 1; index <= array.length; index++) {
                    doubleArr[index] = Double.parseDouble(array[index1]);
                    index1++;
                }
                System.out.println(checkObj.check(doubleArr));
            }
            break;
        case "Float":
            for (int index3 = 0; index3 < noOfTestCases; index3++) {
                String array1 = scan.nextLine();
                if (array1.length() == 0) {
                    System.out.println("false");
                    break;
                }
                String[] array = array1.split(",");
                Float[] floatArr = new Float[array.length + 1];
                int index1 = 0;
                for (int index = 1; index <= array.length; index++) {
                    floatArr[index] = Float.parseFloat(array[index1]);
                    index1++;
                }
                System.out.println(checkObj.check(floatArr));
            }
            break;
        default:
        }
    }
}
/**
 * Class for minimum pq.
 *
 * @param      <E>   { generic variable}
 */
class MinPQ<E extends Comparable<E>> {
    /**
     * {boolean function}.
     *
     * @param      arr   The arr
     *
     * @return     { returns the element boolean value }
     */
    public boolean check(final E[] arr) {
        int len = arr.length;
        for (int index = len - 1; index > 1; index--) {
            if (arr[index].compareTo(arr[index / 2]) < 0) {
                return false;
            }
        }
        return true;
    }
}