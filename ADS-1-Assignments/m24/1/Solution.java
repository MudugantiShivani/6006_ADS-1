import java.util.Scanner;
public final class Solution {
	private Solution() {
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = Integer.parseInt(scan.nextLine());
		LinearProbingHashST<Integer, String> lph = new LinearProbingHashST<Integer, String>();
		for (int i = 0; i<N; i++) {
			String[] tokens = scan.nextLine().split(",");
      		String str = tokens[1] + "," + tokens[2];
      		lph.put(Integer.parseInt(tokens[0]), str);
		}
		int P = Integer.parseInt(scan.nextLine());
		for (int i = 0; i<P; i++) {
			String[] tokens1 = scan.nextLine().split(" ");
      		String str = lph.get(Integer.parseInt(tokens1[1]));
      		if (str != null) {
      			String[] tokens2 = str.split(",");
        		if (Integer.parseInt(tokens1[2]) == 1) {
          			System.out.println(tokens2[0]);
        		} else {
          			System.out.println(Double.parseDouble(tokens2[1]));
        		}
        	}
		}
	}
}