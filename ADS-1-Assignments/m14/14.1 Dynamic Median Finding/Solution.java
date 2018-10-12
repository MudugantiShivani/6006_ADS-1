import java.util.Scanner;
/**
 * Class for dynamic median.
 */
class DynamicMedian {
    /**
     * { object to access minheap }.
     */
    private MinPQ<Double> minObj;
    /**
     * { object to access maxheap }.
     */
    private MaxPQ<Double> maxObj;
    /**
     * Constructs the object.
     */
    DynamicMedian() {
        minObj = new MinPQ<Double>();
        maxObj = new MaxPQ<Double>();
    }
    /**
     * { insertion of element at min heap}.
     *
     * @param      item  The item
     */
    public void insertAtMin(final double item) {
        minObj.insert(item);
    }
    /**
     * { insertion of element at maxheap}.
     *
     * @param      item  The item
     */
    public void insertAtMax(final double item) {
        maxObj.insert(item);
    }
    /**
     * Gets the minimum from min heap
     *
     * @return     The minimum.
     */
    public double getMin() {
        return minObj.min();
    }
    /**
     * Gets the maximum.
     *
     * @return     The maximum.
     */
    public double getMax() {
        return maxObj.max();
    }
    /**
     * { deletes minimum element from max heap }.
     *
     * @return     { minimum value }
     */
    public double delMax() {
        return maxObj.delMax();
    }
    /**
     * { deletes maximum from min heap }.
     *
     * @return     { maximum element }
     */
    public double delMin() {
        return minObj.delMin();
    }
    /**
     * Gets the minimum size.
     *
     * @return     The minimum size.
     */
    public int getMinSize() {
        return minObj.size();
    }
    /**
     * Gets the maximum size.
     *
     * @return     The maximum size.
     */
    public int getMaxSize() {
        return maxObj.size();
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
     * { main class }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        DynamicMedian obj = new DynamicMedian();
        long inputs = scan.nextLong();
        double element = scan.nextDouble();
        obj.insertAtMin(element);
        double median = element;
        System.out.println(median);
        for (long i = 1; i < inputs; i++) {
            double input = scan.nextDouble();
            if (input > median) {
                obj.insertAtMin(input);
            } else if (input < median) {
                obj.insertAtMax(input);
            } else {
                obj.insertAtMin(input);
            }
            if (obj.getMinSize() - obj.getMaxSize() > 1) {
                obj.insertAtMax(obj.delMin());
            }
            if (obj.getMaxSize() - obj.getMinSize()  > 1) {
                obj.insertAtMin(obj.delMax());
            }
            if (Math.abs(obj.getMinSize() - obj.getMaxSize()) == 1) {
                if (obj.getMinSize() > obj.getMaxSize()) {
                    median = obj.getMin();
                    System.out.println(median);
                } else {
                    median = obj.getMax();
                    System.out.println(median);
                }
            }
            if (obj.getMinSize()  == obj.getMaxSize()) {
                double min = obj.getMin();
                double max = obj.getMax();
                median = (min + max) / 2.0;
                System.out.println(median);
            }
        }
    }
}