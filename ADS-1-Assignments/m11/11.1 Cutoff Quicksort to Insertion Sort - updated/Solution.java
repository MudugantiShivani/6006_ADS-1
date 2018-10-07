import java.util.Scanner;
class Quick {
    private int cutoff;
    Quick(final int cutof) {
        this.cutoff = cutof;
    }
    public boolean lesser(
        final Comparable a, final Comparable b) {
        return a.compareTo(b) < 0;
    }
    public void swap(
        final Comparable[] array, final int i, final int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public void insertionSort(
        final Comparable[] array, final int low, final int high) {
        for (int i = low; i <= high; i++) {
            for (int j = i; j > low && lesser(array[j], array[j - 1]); j--) {
                swap(array, j, j - 1);
            }
        }
    }
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
final class Solution {
    private Solution() {
    }
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