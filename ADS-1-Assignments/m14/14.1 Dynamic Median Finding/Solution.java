import java.util.Scanner;
class DynamicMedian {
    private MinPQ<Double> minObj;
    private MaxPQ<Double> maxObj;
    DynamicMedian() {
        minObj = new MinPQ<Double>();
        maxObj = new MaxPQ<Double>();
    }
    public void insertAtMin(final double item) {
        minObj.insert(item);
    }
    public void insertAtMax(final double item) {
        maxObj.insert(item);
    }
    public double getMin() {
        return minObj.min();
    }
    public double getMax() {
        return maxObj.max();
    }
    public double delMax() {
        return maxObj.delMax();
    }
    public double delMin() {
        return minObj.delMin();
    }
    public int getMinSize() {
        return minObj.size();
    }
    public int getMaxSize() {
        return maxObj.size();
    }
}
final class Solution {
    private Solution() {
    }
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