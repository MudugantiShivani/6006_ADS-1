import java.util.Arrays;
import java.util.Scanner;
/**
 * Class for binary search st.
 *
 * @param      <Keys>    The keys
 * @param      <Values>  The values
 */
class BinarySearchST<Keys extends Comparable<Keys>, Values> {
	/**
	 * {array to store keys}.
	 */
    private Keys[] keys;
    /**
     * {array to store to values}.
     */
    private Values[] values;
    /**
     * {gives size}.
     */
    private int size;
    /**
     * Constructs the object.
     */
    BinarySearchST() {
        keys = (Keys[]) new Comparable[10];
        values = (Values[]) new Comparable[10];
        size = 0;
    }
    /**
     * {method used to resize the array}.
     * order of complexity is O(1).
     */
    private void resize() {
        keys = Arrays.copyOf(keys, size + 1);
        values = Arrays.copyOf(values, size + 1);
    }
    /**
     * {method to store keys and values}.
     * complexity is O(logN)
     *
     * @param      key    The key
     * @param      value  The value
     */
    public void put(final Keys key, final Values value) {
        if (size == keys.length) {
            resize();
        }
        if (size == 0) {
            keys[0] = key;
            values[0] = value;
            size++;
            return;
        }
        int rank = rank(key);
        if (rank < size && keys[rank].compareTo(key) == 0) {
            values[rank] = value;
            return;
        }
        for (int i = size; i > rank; i--) {
            keys[i] = keys[i - 1];
            values[i] = values[i - 1];
        }
        keys[rank] = key;
        values[rank] = value;
        size++;
    }
    /**
     * {This method gives the rank of the key}.
     * Time complexity is O(logN)
     * @param      key   The key
     *
     * @return     {returns the keys rank}
     */
    public int rank(final Keys key) {
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key.compareTo(keys[mid]) < 0) {
                high = mid - 1;
            } else if (key.compareTo(keys[mid]) > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }
    /**
     * {this method is used to delete keys and values}.
     * order of complexity is O(logN)
     *
     * @param      key   The key
     */
    public void delete(final Keys key) {
        int rank = rank(key);
        for (int i = rank; i < size - 1; i++) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }
        size--;
    }
    /**
     * { gives size of array}.
     * Time complexity is O(1)
     * @return     { size of array}
     */
    public int size() {
        return size;
    }
    /**
     * Determines if empty.
     * Time complexity is O(1)
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    /**
     * {returns true if key is present in array else false}.
     * Time complexity is O(1)
     * @param      key   The key
     *
     * @return     {boolean value}
     */
    public boolean contains(final Keys key) {
        return get(key) != null;
    }
    /**
     * {returns value of key}.
     * Time complexity is O(1)
     * @param      key   The key
     *
     * @return     {return the value of key}
     */
    public Values get(final Keys key) {
        if (isEmpty()) {
            return null;
        }
        int rank = rank(key);
        if (rank < size && keys[rank].compareTo(key) == 0) {
            return values[rank];
        }
        return null;
    }
    /**
     * {deletes minimum element in keys array}.
     * Time complexity is O(1)
     */
    public void deleteMin() {
        delete(min());
    }
    /**
     * {deletes maximum element in keys array}.
     * Time complexity is O(1)
     */
    public void deleteMax() {
        delete(max());
    }
    /**
     * {returns minimum key element}.
     * Time complexity is O(1)
     * @return     {minimum key element}
     */
    public Keys min() {
        return keys[0];
    }
    /**
     * {returns maximum element}.
     * Time complexity is O(1)
     * @return     {maximum element}
     */
    public Keys max() {
        return keys[size - 1];
    }
    /**
     * {returns key in the index array}.
     * time complexity is O(1)
     * @param      index  The index
     *
     * @return     {returns key}
     */
    public Keys select(final int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return keys[index];
    }
    /**
     * {gives the immediate smallest key than the specified one}.
     * Time complexity is order of logN.
     * @param      key   The key
     *
     * @return     { key }
     */
    public Keys floor(final Keys key) {
        int rank = rank(key);
        if (rank <= 0) {
            return null;
        }
        if ((rank < size) && (key.compareTo(keys[rank])) == 0) {
            return keys[rank];
        }
        return keys[rank - 1];
    }
    /**
     * {returns immediate greatest key than specified}.
     * time complexity is O(logN).
     *
     * @param      key   The key
     *
     * @return     {key}
     */
    public Keys ceiling(final Keys key) {
        int rank = rank(key);
        return keys[rank];
    }
    /**
     * { gives keys and its values}.
     * time complexity is O(N).
     */
    public void keys() {
        for (int i = 0; i < size; i++) {
            System.out.println(keys[i] + " " + values[i]);
        }
    }
}
/**
 * {main class}.
 */
final class Solution {
	/**
	 * Constructs the object.
	 */
    private Solution() {

    }
    /**
     * {main funtion}.
     * time complexity is O(N).
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        BinarySearchST<String, Integer> obj = new BinarySearchST<>();
        Scanner scan = new Scanner(System.in);
        String[] tokens = scan.nextLine().split(" ");
        for (int i = 0; i < tokens.length; i++) {
            obj.put(tokens[i], i);
        }
        while (scan.hasNext()) {
            String[] input = scan.nextLine().split(" ");
            switch (input[0]) {
            case "deleteMin":
                obj.deleteMin();
                break;
            case "deleteMax":
                obj.deleteMax();
                break;
            case "max":
                System.out.println(obj.max());
                break;
            case "min":
                System.out.println(obj.min());
                break;
            case "rank":
                System.out.println(obj.rank(input[1]));
                break;
            case "contains":
                System.out.println(obj.contains(input[1]));
                break;
            case "get":
                System.out.println(obj.get(input[1]));
                break;
            case "keys":
                obj.keys();
                break;
            case "floor":
                System.out.println(obj.floor(input[1]));
                break;
            case "ceiling":
                System.out.println(obj.ceiling(input[1]));
                break;
            default:
                break;
            }
        }
    }
}