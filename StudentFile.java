package CU;
import  java.io.*;
import java.util.Scanner;

public class StudentFile {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

          
            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Roll Number: ");
            int roll = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Course: ");
            String course = sc.nextLine();

           
            FileWriter fw = new FileWriter("student.txt");

            fw.write("Student Name: " + name + "\n");
            fw.write("Roll Number: " + roll + "\n");
            fw.write("Course: " + course + "\n");

            fw.close();

            System.out.println("\nData written successfully.\n");

       
            System.out.println("Reading File Content:");

            BufferedReader br = new BufferedReader(new FileReader("student.txt"));

            String line;

            while((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        }

        catch(Exception e) {
            System.out.println(e);
        }

        sc.close();
    }
}