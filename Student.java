
import java.util.Scanner;
public class Student {

    private String name;
    private String surname;
    private int gradeYear;

    private String studentID;

    private String courses = "";
    private int tuitionBalance = 0;
    private int remainingDebt=0;
    private static int castOfCourse = 600;

    private static int id = 1000;


    // Constructor: prompt user to enter student's name and year

    public Student() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student name: ");
        this.name = scanner.nextLine();
        System.out.println("Enter the surname: ");
        this.surname = scanner.nextLine();
        System.out.println("1 - Freshmen\n2 - Sophomore\n3 - Junior\n4 - Senior\nEnter student class level: ");
        this.gradeYear = scanner.nextInt();

        if (1 <= gradeYear && gradeYear <= 4) {
            switch (gradeYear){
                case 1:
                    System.out.println("1 - Freshmen");
                    break;
                case 2:
                    System.out.println("2 - Sophomore");
                    break;
                case 3:
                    System.out.println("3 - Junior");
                    break;
                case 4:
                    System.out.println("4 - Senior");
                    break;
            }
        } else {
            throw new NumberFormatException("Invalid grade year");
        }

        setStudentID();
    }


    // Generate an ID

    private void setStudentID() {
        // Grade level + ID
        id++;
        this.studentID = gradeYear + "" + id;
    }

    // Enroll in courses

    public void enroll() {

        System.out.print("Enter course to enroll (Q to quit): ");
        System.out.println("\n1 - Math\n2 - English\n3 - History\n4 - Geography");

        // Get inside a loop, user hits 0
        do {
            Scanner scanner = new Scanner(System.in);
            String course = scanner.nextLine();
            if (!course.equals("Q")) {
                courses = courses + "\n" + course;
                tuitionBalance = tuitionBalance + castOfCourse;
            } else {
                break;
            }
        } while (1 != 0);
        System.out.println("Your choose courses: " + courses);
      System.out.println("Your Tuition balance: " + tuitionBalance + "$");
    }

    // Pay Tuition
    public void payTuition() {
        System.out.println("Enter your payment: ");
        Scanner scanner = new Scanner(System.in);
        int payment = scanner.nextInt();
        remainingDebt = tuitionBalance - payment;
        System.out.println("Your Remaining Debt: " + remainingDebt + "$");
        System.out.println("Thank you for your payment of " + payment + "$");
    }


    //Show status
    public String showInfo() {
        System.out.println("\nYour registration information: ");
        return "Name and Surname: " + name + " " + surname +
                "\nGrade Level: " + gradeYear +
                "\nStudent ID: " + studentID +
                "\nCourses Enrolled: " + courses +
                "\nRemaining Debt: " + remainingDebt + "$" ;
    }



}