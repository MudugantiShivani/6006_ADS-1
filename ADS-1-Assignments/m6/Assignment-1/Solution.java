import java.util.Scanner;
class AddLargeNumbers {
    static LinkedList objct;
    public static LinkedList numberToDigits(String number) {
    	objct = new LinkedList();
    	String[] result = number.split("",number.length());
    	for (int i=0;i<result.length;i++) {
    		objct.insertEnd(Integer.parseInt(result[i]));
    	}
    	return objct;
    }

    public static String digitsToNumber(final LinkedList list) {
    	// String str = "";
     //    while (list.size != 0) {
     //        str = str + list.deleteStart();
     //    }
        return null;
    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
    	return null;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input){
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            case "addLargeNumbers":
                pDigits = AddLargeNumbers.numberToDigits(p);
                qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
        }
    }
    
}
