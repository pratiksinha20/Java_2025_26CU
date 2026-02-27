package CU;
import java.util.Scanner;

public class Try{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter base and exponent:");
        int n=sc.nextInt();
        System.out.println("Enter a floating number");
        float f=sc.nextFloat();
        System.out.println("Enter an string");
        String s=sc.next();
        System.out.println("Your output is :");
        System.out.println(n + " " + f+ " "+s);

    }
}
