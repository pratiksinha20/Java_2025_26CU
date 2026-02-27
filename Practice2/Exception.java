package CU.Practice;
import java.util.*;

public class Exception {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        try{
            System.out.println("Enter student name:");
            String name=sc.nextLine();
            System.out.println("Enter the marks out of 100:");
            int marks =sc.nextInt();
            if(marks<0 || marks>100)
            {
                throw new IllegalArgumentException("Marks must be between 0 and 100.");
            }
            
                if(marks>=90)
                {
                    System.out.println("Grade A");
                }
                else if(marks>=75)
                {
                    System.out.println("Grade B");
                }
                else if(marks>=60)
                {
                    System.out.println("Grade C");
                }
                else if(marks>=40)
                {
                    System.out.println("Grade D");
                }
                else
                {
                    System.out.println("Fail");
                }
           
        }
        catch(InputMismatchException e)
        {
            System.out.println("Invalid input. Please enter numeric marks only.");
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("Marks must be between 0 and 100.");
        }
        finally
        {
            System.out.println("Marks evaluation completed.");
        }
    
}
}