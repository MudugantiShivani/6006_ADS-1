import java.util.Scanner;
class Student implements Comparable<Student>{
	String name;
	double marks;
	
	Student() {

	}
	Student(String name1, String marks1) {
		this.name  = name1;
		this.marks = Double.parseDouble(marks1);
	}
	public int compareTo(Student student1) {
		if (this.marks > student1.marks) return 1;
		if (this.marks < student1.marks) return -1;
		if (this.name.compareTo(student1.name) > 0) return 1;
		if (this.name.compareTo(student1.name) < 0) return -1;
		return 0;
	}
}
class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int data = sc.nextInt();
		sc.nextLine();
		RedBlackBST<Student, Integer> rb = new RedBlackBST<>();
		Student s = new Student();
		int i = 0;
		while (i < data) {
			String str1 = sc.nextLine();
			String arr1[] = str1.split(",");
			s = new Student(arr1[1], arr1[2]);
			rb.put(s, Integer.parseInt(arr1[0]));
			i++;
		}
		int j = sc.nextInt();
		sc.nextLine();
		int k = 0;
		while (k < j) {
			String[] arr2 = sc.nextLine().split(" ");
			if (arr2[0].equals("BE")) {
				double from = Double.parseDouble(arr2[1]);
				double to = Double.parseDouble(arr2[2]);
				for (Student students : rb.keys()) {
					if (students.marks >= from && students.marks <= to) {
						System.out.println(students.name);
					}
				}

			} else if (arr2[0].equals("LE")) {
				double upto = Double.parseDouble(arr2[1]);
				for (Student students : rb.keys()) {
					if (students.marks <= upto) {
						System.out.println(students.name);
					}
				}
			} else if (arr2[0].equals("GE")) {
				double upto = Double.parseDouble(arr2[1]);
				for (Student students : rb.keys()) {
					if (students.marks >= upto) {
						System.out.println(students.name);
					}
				}
			}
			
		}
	}
}
