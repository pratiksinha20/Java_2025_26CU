package CU.Lab_MST_Java.main;

import CU.Lab_MST_Java.model.*;
import CU.Lab_MST_Java.services.CourseService;
import CU.Lab_MST_Java.exception.*;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CourseService service = new CourseService();

        int choice;

        do {

            System.out.println("\n1 Add Course");
            System.out.println("2 Enroll Student");
            System.out.println("3 View Courses");
            System.out.println("4 Exit");

            choice = sc.nextInt();

            try {

                switch (choice) {

                    case 1:

                        System.out.print("Course ID: ");
                        int cid = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Course Name: ");
                        String cname = sc.nextLine();

                        System.out.print("Max Seats: ");
                        int seats = sc.nextInt();

                        Course c = new Course(cid, cname, seats);

                        service.addCourse(c);

                        break;

                    case 2:

                        System.out.print("Course ID: ");
                        int courseId = sc.nextInt();

                        System.out.print("Student ID: ");
                        int sid = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Student Name: ");
                        String sname = sc.nextLine();

                        Student s = new Student(sid, sname);

                        service.enrollStudent(courseId, s);

                        System.out.println("Enrollment successful!");

                        break;

                    case 3:

                        service.viewCourses();
                        break;

                }

            } catch (Exception e) {

                System.out.println("Error: " + e.getMessage());

            }

        } while (choice != 4);

        sc.close();
    }
    
}
