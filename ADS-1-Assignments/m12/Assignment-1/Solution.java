import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * { main function}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Student obj;
        Scanner scan = new Scanner(System.in);
        Addingdata object = new Addingdata();
        int totalQualified = scan.nextInt();
        int vacancies = scan.nextInt();
        int opencategorySeats = scan.nextInt();
        int bcSeats = scan.nextInt();
        int scSeats = scan.nextInt();
        int stSeats = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < totalQualified; i++) {
            String line  =  scan.nextLine();
            String[] tokens = line.split(",");
            final int three = 3;
            final int four = 4;
            final int five = 5;
            final int six = 6;
            obj = new Student(tokens[0], tokens[1], tokens[2],
                tokens[three], tokens[four], tokens[five], tokens[six]);
            object.addData(obj);
        }
        object.sorting();
        object.print();
        object.seatallot(vacancies, opencategorySeats, bcSeats, scSeats,
            stSeats);
    }
}
/**
 * Class for student.
 */
class Student {
    /**
     * { name of the student}.
     */
    private String name;
    /**
     * { date of birth }.
     */
    private String birth;
    /**
     * { subject one marks }.
     */
    private int s1;
    /**
     * { subject two marks }.
     */
    private int s2;
    /**
     * { subject three marks }.
     */
    private int s3;
    /**
     * { total marks }.
     */
    private int total;
    /**
     * { category of the student }.
     */
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
            final String birth1, final String sub1, final String sub2,
            final String sub3, final String total1, final String category1) {
             this.name = student;
             this.birth = birth1;
             this.s1 = Integer.parseInt(sub1);
             this.s2 = Integer.parseInt(sub2);
             this.s3 = Integer.parseInt(sub3);
             this.total = Integer.parseInt(total1);
             this.category = category1;
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
class Addingdata {
    /**
     * { initialising array list}.
     */
    private ArrayList<Student> list;
    /**
     * Constructs the object.
     */
    Addingdata() {
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
            System.out.println(list.get(i).getName() + ","
                + list.get(i).getTotal() + "," + list.get(i).getCategory());
        }
        System.out.println();
    }
    /**
     * { tells the alloted seats}.
     *
     * @param      vacancies          The vacancies
     * @param      opencategorySeats  The opencategory seats
     * @param      bcSeats            The b cseats
     * @param      scSeats            The s cseats
     * @param      stSeats            The s tseats
     */
    public void seatallot(int vacancies, int opencategorySeats, int bcSeats,
        int scSeats, int stSeats) {
        ArrayList<Student> alloted = new ArrayList<Student>();
        int count = 0;
        for (int i = 0; i < list.size() && opencategorySeats > 0 && vacancies > 0; i++) {
            alloted.add(list.get(i));
            opencategorySeats--;
            count++;
            vacancies--;
        }
        for (int i = count; i < list.size()  && vacancies > 0; i++) {
            if (list.get(i).getCategory().equals("ST") && stSeats > 0) {
                alloted.add(list.get(i));
                stSeats--;
                count++;
                vacancies--;
            }
            if (list.get(i).getCategory().equals("SC") && scSeats > 0) {
                alloted.add(list.get(i));
                scSeats--;
                count++;
                vacancies--;
            }
            if (list.get(i).getCategory().equals("BC") && bcSeats > 0) {
                alloted.add(list.get(i));
                bcSeats--;
                count++;
                vacancies--;
            }


        }
        for (int i = 0; i < alloted.size(); i++) {
            System.out.println(alloted.get(i).getName() + ","
                + alloted.get(i).getTotal() + "," + alloted.get(i).getCategory());
        }
    }
}
