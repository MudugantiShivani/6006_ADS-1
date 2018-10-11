import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
/**
 *this class stores the student info.
 */
class Student {
    /**
     *name of the student.
     */
    private String name;
    /**
     *DOB of the student.
     */
    private String birth;
    /**
     *mark1 of the student.
     */
    private int sub1;
    /**
     *mark2 of the student.
     */
    private int sub2;
    /**
     *mark3 of the student.
     */
    private int sub3;
    /**
     *total marks.
     */
    private int total;
    /**
     *category of the student.
     */
    private String category;
    /**
     * to initialize the data od student.
     *
     * @param      student   The student
     * @param      dob     The birth
     * @param      s1    The sub one
     * @param      s2    The sub two
     * @param      s3  The sub three
     * @param      tot     The total
     * @param      categorie  The category
     */
    Student(final String student,
            final String dob, final String s1,
            final String s2, final String s3,
            final String tot, final String categorie) {
        this.name = student;
        this.birth = dob;
        this.sub1 = Integer.parseInt(s1);
        this.sub2 = Integer.parseInt(s2);
        this.sub3 = Integer.parseInt(s3);
        this.total = Integer.parseInt(tot);
        this.category = categorie;
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
     * Gets the subone marks.
     *
     * @return     The sub o ne.
     */
    public int getSubOne() {
        return this.sub1;
    }
    /**
     * Gets the sub two marks.
     *
     * @return     The sub two.
     */
    public int getSubTwo() {
        return this.sub2;
    }
    /**
     * Gets the sub three marks.
     *
     * @return     The sub three.
     */
    public int getSubThree() {
        return this.sub3;
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
    /**
     * Gets the age.
     *
     * @return  year.
     */
    public int getYear() {
        String[] age = this.birth.split("-");
        int year = Integer.parseInt(age[2]);
        return year;
    }
}
/**
 * Class for Studentdetails.
 */
class Studentdetails {
    /**
     * arraylist of objects to store.
     * all students as objects.
     */
    private ArrayList<Student> list;
    /**
     * to initialize the object.
     */
    Studentdetails() {
        list = new ArrayList<Student>();
    }
    /**
     *to add the object.
     *
     * @param      obj   The object
     * is student here.
     */
    public void addData(final Student obj) {
        list.add(obj);
    }
    /**
     * this method compares in the descending.
     * order of merit for two students
     *
     * @param      name1  The student one
     * @param      name2  The student two
     *
     * @return if it is lesser returns -1
     * or else 1
     */
    public int compareTo(
        final Student name1,
        final Student name2) {
        if (name1.getTotal()
                < name2.getTotal()) {
            return  -1;
        } else if (name1.getTotal()
                   > name2.getTotal()) {
            return 1;
        } else {
            if (name1.getSubThree()
                    < name2.getSubThree()) {
                return -1;
            } else if (name1.getSubThree()
                       > name2.getSubThree()) {
                return 1;
            } else {
                if (name1.getSubTwo()
                        < name2.getSubTwo()) {
                    return -1;
                } else if (name1.getSubTwo()
                           > name2.getSubTwo()) {
                    return 1;
                } else {
                    if (name1.getYear()
                     > name2.getYear()) {
                        return 1;
                    } else if (name1.getYear()
                     < name2.getYear()) {
                        return -1;
                    } else {
                    if (name1.getAge()
                            > name2.getAge()) {
                        return 1;
                    } else if (name1.getAge()
                               < name2.getAge()) {
                        return -1;
                    }
                }
                }
            }
        }
        return 0;
    }
    /**
     *the method is to sort the objects.The time complexity will be N^2/ 2
     *because every time it iterates throughout the array.
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
     *the method is to sort the objects.The time complexity will be N^2/ 2
     *because every time it iterates throughout the array.
     *@param list1 of alloted seats.
     */
    public void sorting(final ArrayList<Student> list1) {
        int max = 0;
        int flag = 0;
        for (int i = 0; i < list1.size(); i++) {
            max = i;
            for (int j = i + 1; j < list1.size(); j++) {
                flag = compareTo(list1.get(max), list1.get(j));
                if (flag == -1) {
                    max = j;
                }
            }
            Collections.swap(list1, i, max);
        }
    }
    /**
     *it prints the arrayList.
     */
    public void print() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName()
                               + "," + list.get(i).getTotal()
                               + "," + list.get(i).getCategory());
        }
        System.out.println();
    }
    /**
     * the method is for allotment of candidates.
     *
     * @param      vac  The vacancies
     * @param      openS  The open seats
     * @param      bcS    The bc seats
     * @param      scS    The screen seats
     * @param      stS    The st seats
     */
    public void allotment(final int vac,
                          final int openS, final int bcS,
                          final int scS, final int stS) {
        int vacancies = vac;
        int openSeats = openS;
        int bcSeats = bcS;
        int scSeats = scS;
        int stSeats = stS;
        ArrayList<Student> alloted
            = new ArrayList<Student>();
        int count = 0;
        for (int i = 0; i < list.size()
                && openSeats > 0 && vacancies > 0; i++) {
            alloted.add(list.get(i));
            openSeats--;
            count++;
            vacancies--;
        }
        for (int i = count; i < list.size()
                && vacancies > 0; i++) {
            if (list.get(i).getCategory().equals("BC")
                    && bcSeats > 0) {
                alloted.add(list.get(i));
                bcSeats--;
                count++;
                vacancies--;
            }
            if (list.get(i).getCategory().equals("ST")
                    && stSeats > 0) {
                alloted.add(list.get(i));
                stSeats--;
                count++;
                vacancies--;
            }
            if (list.get(i).getCategory().equals("SC")
                    && scSeats > 0) {
                alloted.add(list.get(i));
                scSeats--;
                count++;
                vacancies--;
            }
        }
        int reserved = bcSeats + scSeats + stSeats;
        for (int i = 0; i < list.size(); i++) {
            if (reserved > 0) {
                if (alloted.contains(list.get(i))) {
                    int sum = 0;
                } else {
                alloted.add(list.get(i));
                reserved--;
                }
            }
        }
        sorting(alloted);
        for (int i = 0; i < alloted.size(); i++) {
            System.out.println(alloted.get(i).getName()
                               + "," + alloted.get(i).getTotal() + ","
                               + alloted.get(i).getCategory());
        }
    }
}
/**
 *this the class for main.
 */
final class Solution {
    /**
     *empty constructor.
     */
    private Solution() {
    }
    /**
     * the main to read the input.
     *
     * @param  args  The arguments
     */
    public static void main(final String[] args) {
        Student obj;
        final int three = 3;
        final int four = 4;
        final int five = 5;
        final int six = 6;
        Scanner scan = new Scanner(System.in);
        Studentdetails object = new Studentdetails();
        int totalQualified = scan.nextInt();
        int vacancies = scan.nextInt();
        int openSeats = scan.nextInt();
        int bcSeats = scan.nextInt();
        int scSeats = scan.nextInt();
        int stSeats = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < totalQualified; i++) {
            String line  =  scan.nextLine();
            String[] tokens = line.split(",");
            obj = new Student(
                tokens[0], tokens[1], tokens[2],
                tokens[three], tokens[four],
                tokens[five], tokens[six]);
            object.addData(obj);
        }
        object.sorting();
        object.print();
        object.allotment(vacancies,
                         openSeats, bcSeats, scSeats, stSeats);
    }
}
