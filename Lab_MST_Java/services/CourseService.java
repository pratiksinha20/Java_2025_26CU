package CU.Lab_MST_Java.services;

import CU.Lab_MST_Java.model.Course;
import CU.Lab_MST_Java.model.Student;
import CU.Lab_MST_Java.exception.*;

import java.io.*;
import java.util.*;

public class CourseService {

    private List<Course> courses = new ArrayList<>();
    private Map<Integer, Set<Integer>> enrollmentMap = new HashMap<>();

    public void addCourse(Course c) {
        courses.add(c);
    }

    public void enrollStudent(int courseId, Student s)
            throws CourseNotFoundException, CourseFullException, DuplicateEnrollmentException {

        Course course = null;

        for (Course c : courses) {
            if (c.getCourseId() == courseId) {
                course = c;
                break;
            }
        }

        if (course == null) {
            throw new CourseNotFoundException("Course not found!");
        }

        if (course.getEnrolledStudents() >= course.getMaxSeats()) {
            throw new CourseFullException("Course is full!");
        }

        enrollmentMap.putIfAbsent(courseId, new HashSet<>());

        if (enrollmentMap.get(courseId).contains(s.getStudentId())) {
            throw new DuplicateEnrollmentException("Student already enrolled!");
        }

        enrollmentMap.get(courseId).add(s.getStudentId());

        course.setEnrolledStudents(course.getEnrolledStudents() + 1);

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("courses.txt", true));

            bw.write(courseId + "," + s.getStudentId() + "," + s.getStudentName());
            bw.newLine();

            bw.close();

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    public void viewCourses() {

        for (Course c : courses) {
            c.displayCourse();
        }

        System.out.println("\nEnrollment Records (File):");

        try {

            BufferedReader br = new BufferedReader(new FileReader("courses.txt"));

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("No records found.");
        }
    }
}