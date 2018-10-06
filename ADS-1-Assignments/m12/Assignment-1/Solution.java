import java.util.Scanner;
import java.util.Collections;
import java.util.Arrays;
import java.util.ArrayList;
/**
 * Class for solution.
 */
class Solution {
    /**
     * Constructs the object.
     */
    Solution() {
    }
    /**
     * { main function}.
     *
     * @param      args  The arguments
     */
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
/**
 * Class for student.
 */
class Student {
    private String name;
    private String birth;
    private int s1;
    private int s2;
    private int s3;
    private int total;
    private String category;
    /**
     * Constructs the object.
     *
     * @param      student   The student
     * @param      birth     The birth
     * @param      s1        The s 1
     * @param      s2        The s 2
     * @param      s3        The s 3
     * @param      total     The total
     * @param      category  The category
     */
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
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Gets the s 1.
     *
     * @return     The s 1.
     */
    public int getS1() {
        return this.s1;
    }
    /**
     * Gets the s 2.
     *
     * @return     The s 2.
     */
    public int getS2() {
        return this.s2;
    }
    /**
     * Gets the s 3.
     *
     * @return     The s 3.
     */
    public int getS3() {
        return this.s3;
    }
    /**
     * Gets the total.
     *
     * @return     The total.
     */
    public int getTotal() {
        return this.total;
    }
    /**
     * Gets the category.
     *
     * @return     The category.
     */
    public String getCategory() {
        return this.category;
    }
    /**
     * Gets the age.
     *
     * @return     The age.
     */
    public int getAge() {
        String[] age = this.birth.split("-");
        int month = Integer.parseInt(age[1]);
        return month;
    }
}
/**
 * Class for adding data.
 */
class addingData {
    private ArrayList<Student> list;
    /**
     * Constructs the object.
     */
    addingData() {
        list = new ArrayList<Student>();
    }
    /**
     * Adds a data.
     *
     * @param      obj   The object
     */
    public void addData(final Student obj) {
        list.add(obj);
    }
    /**
     * { compares the object }.
     *
     * @param      name1  The name 1
     * @param      name2  The name 2
     *
     * @return     { description_of_the_return_value }
     */
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
    /**
     * { sorts the elements}.
     */
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
    /**
     * { prints the output }.
     */
    public void print() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName() + "," + list.get(i).getTotal() + "," + list.get(i).getCategory());
        }
        System.out.println();
    }
    /**
     * { tells the alloted seats}.
     *
     * @param      vacancies          The vacancies
     * @param      opencategorySeats  The opencategory seats
     * @param      BCseats            The b cseats
     * @param      SCseats            The s cseats
     * @param      STseats            The s tseats
     */
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
        for (int i = 0; i < alloted.size(); i++) {
            System.out.println(alloted.get(i).getName() + "," + alloted.get(i).getTotal() + "," + alloted.get(i).getCategory());
        }
    }
}
