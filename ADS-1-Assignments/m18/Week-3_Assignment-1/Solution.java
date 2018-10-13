import java.util.Scanner;
class Solution{
	Solution(){
	}
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int range = scan.nextInt();
		int numberof_hours = 6;
		scan.nextLine();
		while(numberof_hours > 0){
			StockOrder obj = new StockOrder();
			for(int i = 0; i < range; i++) {
				String line = scan.nextLine();
				String[] tokens = line.split(",");
				obj.put(tokens[0], tokens[1]);
			}
			obj.print();
			numberof_hours--;
		}
		int next = scan.nextInt();
	}
}
class StockOrder{
	BST<Double, String> maxObj;
	BST<Double, String> minObj;
	StockOrder(){
		maxObj = new BST<Double, String>();
		minObj = new BST<Double, String>();
	}
	public void put(String name, String percent){
		maxObj.put(Double.parseDouble(percent), name);
		minObj.put(Double.parseDouble(percent), name);
	}
	public void print(){
		for (int i = 0; i < 5; i++) {
			Double temporarymin = minObj.min();
			String minName = minObj.get(temporarymin);
			minObj.deleteMin();
			System.out.println(minName + " "+ temporarymin);
		}
		System.out.println();
		for (int i = 0; i < 5; i++) {
			Double temporarymax = maxObj.max();
			String maxName = maxObj.get(temporarymax);
			maxObj.deleteMax();
			System.out.println(maxName + " "+ temporarymax);
		}
		System.out.println();
		
	}

}
