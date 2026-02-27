package CU.Practice;

public class MultiTryCatch {
    public static void main (String[] args)
    {
        try{
            int a=10/0;
        }
        catch(ArithmeticException e)
        {
            System.out.println("Arithmetic Exception caught: " + e.getMessage());
        }
        try{
            int arr[]=new int[5];
            arr[10]=50;
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Array Index Out of Bounds Exception caught: " + e.getMessage());

        }
        // int a=10;
        // int b=19;
        // System.out.println(a+b);
    }
}
