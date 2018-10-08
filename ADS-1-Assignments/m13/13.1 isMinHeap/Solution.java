import java.util.Scanner;
final class Solution {
	public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String dataType = scan.nextLine();
        int noOfTestCases = Integer.parseInt(scan.nextLine());
        MinPQ checkObj = new MinPQ();
        switch (dataType) {
        case "String":
            while (scan.hasNext()) {
                String[] array = scan.nextLine().split(",");
                String[] strArr = new String[array.length + 1];
                int index1 = 0;
                for (int index = 1; index <= array.length; index++) {
                    strArr[index] = array[index1];
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
                }
                System.out.println(checkObj.check(floatArr));
            }
            break;
        default:
        }
    }
}
class MinPQ<E extends Comparable<E>> {
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