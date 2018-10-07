import java.util.Scanner;
/**
 * Class for quick.
 */
class Quick {
    private int cutoff;
    /**
     * Constructs the object.
     *
     * @param      cutof  The cutof
     */
    Quick(final int cutof) {
        this.cutoff = cutof;
    }
    /**
     * { compqres the numbers }.
     *
     * @param      a     { one parameter }
     * @param      b     { second parameter }
     *
     * @return     { returns the boolean value }
     */
    public boolean lesser(
        final Comparable a, final Comparable b) {
        return a.compareTo(b) < 0;
    }
    /**
     * { used for swapping}.
     *
     * @param      array  The array
     * @param      i      { one element }
     * @param      j      { second element }
     */
    public void swap(
        final Comparable[] array, final int i, final int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    /**
     * { function for insertion sort }.
     *
     * @param      array  The array
     * @param      low    The low
     * @param      high   The high
     */
    public void insertionSort(
        final Comparable[] array, final int low, final int high) {
        for (int i = low; i <= high; i++) {
            for (int j = i; j > low && lesser(array[j], array[j - 1]); j--) {
                swap(array, j, j - 1);
            }
        }
    }
    /**
     * { function calls when insertion sort is called }.
     *
     * @param      array  The array
     * @param      low    The low
     * @param      high   The high
     */
    public void sort(
        final Comparable[] array, final int low, final int high) {
        if (high - low + 1  <=  cutoff) {
            insertionSort(array, low, high);
            System.out.println("insertionSort called");
            return;
        }
        int j = partition(array, low, high);
        sort(array, low, j - 1);
        sort(array, j + 1, high);
    }
    /**
     * { parttions the elements }.
     *
     * @param      array  The array
     * @param      low    The low
     * @param      high   The high
     *
     * @return     { description_of_the_return_value }
     */
    public int partition(
        final Comparable[] array, final int low, final int high) {
        int start = low;
        int end = high + 1;
        Comparable pivot = array[low];
        while (true) {
            while (lesser(array[++start], pivot)) {
                if (start == high) {
                    break;
                }
            }
            while (lesser(pivot, array[--end])) {
                if (end == low) {
                    break;
                }
            }
            if (start >= end) {
                break;
            }
            swap(array, start, end);
        }
        swap(array, low, end);
        System.out.println(print(array));
        return end;
    }
    /**
     * { prints the output as string }.
     *
     * @param      arr   The arr
     *
     * @return     { returns the string }
     */
    public String print(final Comparable[] arr) {
        String str = "[";
        int i;
        for (i = 0; i < arr.length - 1; i++) {
            str += arr[i] + ", ";
        }
        str += arr[i] + "]";
        return str;
    }
}
/**
 * { main class }.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * { main  function}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputs = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < inputs; i++) {
            int cutoff = scan.nextInt();
            scan.nextLine();
            if (cutoff == 0) {
                System.out.println("[]");
            } else {
                String[] array = scan.nextLine().split(" ");
                Quick obj = new Quick(cutoff);
                obj.sort(array, 0, array.length - 1);
                System.out.println(obj.print(array));
            }
        }
    }
}