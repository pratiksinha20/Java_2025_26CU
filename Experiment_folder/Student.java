import java.util.*;

class student{
    String name;
    int rollno;
    int section;
    
    student()
    {
        System.out.println("hello student");
    }
    student(String name, int rollno, int section){
     System.out.println("Name: " + name);
     System.out.println("Roll No: " + rollno);  
     System.out.println("Section: " + section);

    }
    

};
public class Student {
    public static void main(String[] args)
    {
     student s = new student();
     student s1= new student("Pratik", 10243, 711);  
    }
}
