// public class Percolation {
//    public Percolation(int n)                // create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)    // open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public     int numberOfOpenSites()       // number of open sites
//    public boolean percolates()              // does the system percolate?
// }


// You can implement the above API to solve the problem
import java.util.Scanner;
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
    public boolean isOpen(final int row, final int col) {
        if (grid[row - 1][col - 1] == 1) {
            return true;
        }
        return false;
    }
    
    public int numberOfOpenSites() {
        return openNsize;
    }
    
    public int index(final int i, final int j) {
        return (i * arraySize) + j;
    }
    
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
   
    public int find(final int p) {
        int a = p;
        while (a != parent[a]) {
            a = parent[a];
        }
        return a;
    }
    
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


