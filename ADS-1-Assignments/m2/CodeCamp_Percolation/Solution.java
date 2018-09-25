// You can implement the above API to solve the problem
import java.util.Scanner;
/**
 * Class for percolation.
 */
class Percolation {
    /**
     * initializing array size.
     */
    private int arraySize;
    /**
     * initializing open nodes size.
     */
    private int openNsize;
    /**
     * initializing array grid.
     */
    private int[][] grid;
    /**
     * initializing array parent.
     */
    private int[] parent;
    /**
     * initializing size.
     */
    private int[] size;
    /**
     * Constructs the object.
     *
     * @param      count  The count
     */
    Percolation(final int count) {
        arraySize = count;
        openNsize = 0;
        grid = new int[arraySize][arraySize];
        parent = new int[arraySize * arraySize];
        size = new int[arraySize * arraySize];
        for (int i = 0; i < arraySize * arraySize; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    /**
     * { function_description }.
     *
     * @param      row   The row
     * @param      col   The col
     */
    public void open(final int row, final int col) {
        grid[row - 1][col - 1] = 1;
        openNsize += 1;
        if (row - 2 > -1 && isOpen(row - 1, col)) {
            union(index(row - 1, col - 1),
                index(row - 2, col - 1));
        }
        if (row < arraySize && isOpen(row + 1, col)) {
            union(index(row - 1, col - 1),
                index(row, col - 1));
        }
        if (col - 2 > -1 && isOpen(row, col - 1)) {
            union(index(row - 1, col - 1),
                index(row - 1, col - 2));
        }
        if (col < arraySize && isOpen(row, col + 1)) {
            union(index(row - 1, col - 1),
                index(row - 1, col));
        }
    }
    /**
     * Determines if open.
     *
     * @param      row   The row
     * @param      col   The col
     *
     * @return     True if open, False otherwise.
     */
    public boolean isOpen(final int row, final int col) {
        if (grid[row - 1][col - 1] == 1) {
            return true;
        }
        return false;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public int numberOfOpenSites() {
        return openNsize;
    }
    /**
     * { function_description }.
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int index(final int i, final int j) {
        return (i * arraySize) + j;
    }
    /**
     * { function_description }.
     *
     * @param      p     { parameter_description }
     * @param      q     The quarter
     */
    public void union(final int p, final int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        // make smaller root point to larger one
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
    }
   /**
    * Searches for the first match.
    *
    * @param      p     { parameter_description }
    *
    * @return     { description_of_the_return_value }
    */
    public int find(final int p) {
        int a = p;
        while (a != parent[a]) {
            a = parent[a];
        }
        return a;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public boolean valididate() {
        if (openNsize > 0) {
            for (int i = (arraySize - 1)
                         * arraySize; i < arraySize
                    * arraySize; i++) {
                for (int j = 0; j < arraySize; j++) {
                    if (find(i) == find(j)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }
}
/**
 * { item_description }.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        Percolation objper = new Percolation(number);
        while (sc.hasNext()) {
            int one = sc.nextInt();
            int two = sc.nextInt();
            objper.open(one, two);
        }
        System.out.println(objper.valididate());
    }
}


