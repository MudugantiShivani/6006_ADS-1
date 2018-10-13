import java.util.Scanner;
class StockExchange {
	BST<Double, String> MaxObj;
	BST<Double, String> MinObj;
	StockExchange() {
		MaxObj = new BST<Double, String>();
		MinObj = new BST<Double, String>();
	}
	public void put(String name, String percentage) {
		MaxObj.put(Double.parseDouble(percentage), name);
		MinObj.put(Double.parseDouble(percentage), name);
	}
	public void print(){
		for (int i = 0; i < 5; i++) {
			Double min = MinObj.min();
			String minName = MinObj.get(min);
			MinObj.deleteMin();
			System.out.println(minName + " "+ min);
		}
		System.out.println();
		for (int i = 0; i < 5; i++) {
			Double tempMax = MaxObj.max();
			String nameMax = MaxObj.get(tempMax);
			MaxObj.deleteMax();
			System.out.println(nameMax + " "+ tempMax);
		}
		System.out.println();
	}
}
class Solution{
	Solution(){
	}
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		StockExchange obj = new StockExchange();
		int range = scan.nextInt();
		int numberOfhours = 6;
		scan.nextLine();
		while(numberOfhours > 0){
			for(int i = 0; i <= range; i++) {
				String line = scan.nextLine();
				String[] tokens = line.split(",");
				obj.put(tokens[0], tokens[1]);
			}
			obj.print();
			numberOfhours--;
		}
		int queries = scan.nextInt();
	}
}