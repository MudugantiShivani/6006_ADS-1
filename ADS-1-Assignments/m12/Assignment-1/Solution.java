import java.util.Scanner;
import java.util.Collections;
import java.util.Arrays;
import java.util.ArrayList;
class Solution{
	Solution(){
	}
	public static void main(final String[] args) {
		Student obj;
		Scanner scan = new Scanner(System.in);
		addingData object = new addingData();
		int totalQualified = scan.nextInt();
		int vacancies = scan.nextInt();
		int opencategorySeats = scan.nextInt();
		int BCseats = scan.nextInt();
		int SCseats = scan.nextInt();
		int STseats = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < totalQualified; i++) {
			String line  =  scan.nextLine();
			String[] tokens = line.split(",");
			obj = new Student(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], tokens[6]);
			object.addData(obj);
		}
		object.sorting();
		object.print();
		object.seatallot(vacancies, opencategorySeats, BCseats, SCseats, STseats);
	}
}

class Student{
	private String name;
	private String birth;
	private int s1;
	private int s2;
	private int s3;
	private int total;
	private String category;
	Student(final String student,
		final String birth, final String s1, final String s2, final String s3, final String total, final String category) {
		this.name = student;
		this.birth = birth;
		this.s1 = Integer.parseInt(s1);
		this.s2 = Integer.parseInt(s2);
		this.s3 = Integer.parseInt(s3);
		this.total = Integer.parseInt(total);
		this.category = category;
	}
	public String getName() {
		return this.name;
	}
	public int getS1() {
		return this.s1;
	}
	public int getS2() {
		return this.s2;
	}
	public int getS3() {
		return this.s3;
	}
	public int getTotal() {
		return this.total;
	}
	public String getCategory() {
		return this.category;
	}
	public int getAge() {
		String[] age = this.birth.split("-");
		int month = Integer.parseInt(age[1]);
		return month;
	}
}
class addingData{
	private ArrayList<Student> list;
	addingData() {
		list = new ArrayList<Student>();
	}
	public void addData(final Student obj) {
		list.add(obj);
	}
    public int compareTo(
        final Student name1, final Student name2) {
        if (name1.getTotal() > name2.getTotal()) {
            return  1;
        } else if (name1.getTotal() < name2.getTotal()) {
            return -1;
        } else {
            if (name1.getS3() > name2.getS3()) {
                return 1;
            } else if (name1.getS3() < name2.getS3()) {
                return -1;
            } else {
                if (name1.getS2() > name2.getS2()) {
                    return 1;
                } else if (name1.getS2() < name2.getS2()) {
                    return -1;
                } else  {
                	if (name1.getAge() < name2.getAge()) {
                		return -1;
                	}
                }
            }
        }
        return 0;
 }
    public void sorting() {
        int max = 0;
        int flag = 0;
        for (int i = 0; i < list.size(); i++) {
            max = i;
            for (int j = i + 1; j < list.size(); j++) {
                flag = compareTo(list.get(max), list.get(j));
                if (flag == -1) {
                    max = j;
                }
            }
            Collections.swap(list, i, max);
        }
    }
    public void print() {
        for (int i = 0; i < list.size(); i++) {
        	System.out.println(list.get(i).getName() + "," + list.get(i).getTotal() + "," + list.get(i).getCategory());
        }
        System.out.println();
    }
  	public void seatallot(int vacancies, int opencategorySeats, int BCseats, int SCseats, int STseats) {
  		ArrayList<Student> alloted = new ArrayList<Student>();
  		int count = 0;
  		for (int i = 0; i < list.size() && opencategorySeats > 0 && vacancies > 0; i++) {
  				alloted.add(list.get(i));
  				opencategorySeats--;
  				count++;
  				vacancies--;
  		}
  		 for (int i = count; i < list.size()  && vacancies > 0; i++) {
  		 	if (list.get(i).getCategory().equals("ST") && STseats > 0) {
  				alloted.add(list.get(i));
  				STseats--;
  				count++;
  				vacancies--;
  			}
  			if (list.get(i).getCategory().equals("SC") && SCseats > 0 ) {
  				alloted.add(list.get(i));
  				SCseats--;
  				count++;
  				vacancies--;
  			}
  		 	if (list.get(i).getCategory().equals("BC") && BCseats > 0) {
  				alloted.add(list.get(i));
  				BCseats--;
  				count++;
  				vacancies--;
  			}
  			
  			
  		}
  		for (int i = 0; i < alloted.size(); i++){
  		System.out.println(alloted.get(i).getName() + "," + alloted.get(i).getTotal() + "," + alloted.get(i).getCategory());
  		}
  	}
}
