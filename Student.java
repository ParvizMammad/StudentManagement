import java.util.Random;
import java.util.Scanner;

public class Student {

    private String name;
   private String surname;
    private int gradeYear;
    private String studentID;
    private String courses ;
    private int tuitionBalance = 0;
    private static int castOfCourse = 600;

    private static int id = 1000;


    // Constructor: prompt user to enter student's name and year

    public Student() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student name: ");
        this.name = scanner.nextLine();
        System.out.println("Enter the surname: ");
        this.surname = scanner.nextLine();
        System.out.println("1 - Freshmen\n2 - Sophmore\n3 - Junior\n4 - Senior\nEnter student class level: ");
        this.gradeYear = scanner.nextInt();
        if (1 <= gradeYear && gradeYear <= 4 ){
            System.out.println(gradeYear);
        }else { throw new NumberFormatException("Invalid grade year");}

        setStudentID();
//        System.out.println(name + " " + surname + " " + gradeYear + " " + studentID);


    }

    // Generate an ID

    private void setStudentID() {
        // Grade level + ID
        id++;
        this.studentID = gradeYear + "" + id;
    }

    // Enroll in courses

    public void enroll() {
        // Get inside a loop, user hits 0
        do {


            System.out.print("Enter course to enroll (Q to quit): ");
            Scanner scanner = new Scanner(System.in);
            String course = scanner.nextLine();
            if (!course.equals("Q")) {
                courses = courses + "\n" + course;
                tuitionBalance = tuitionBalance + castOfCourse;
            } else {

                break;
            }
        } while (1 != 0);
//        System.out.println("Enrolled in: " + courses);
//        System.out.println("Tuition balance: " + tuitionBalance);
    }


    // View balance

    public void viewBalance() {
        System.out.println("Your balance is: $" + tuitionBalance  );
    }

    // Pay Tuition
public void payTuition(){
        viewBalance();
        System.out.println("Enter you payment: $");
        Scanner scanner = new Scanner(System.in);
        int payment = scanner.nextInt();
        tuitionBalance = tuitionBalance - payment;
    System.out.println("Thank you for your payment of $ " + payment);
    viewBalance();
}
    //Show status
    public String showInfo(){
        return "Name: " + name + " " + surname +
                "\nGrade Level: " + gradeYear +
                "\nStudent ID: " + studentID +
                "\nCourses Enrolled: " +
                "\nBalance: $" + tuitionBalance;
    }


}