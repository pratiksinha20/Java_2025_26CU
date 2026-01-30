import java.util.*;

class ShapeArea{
    
    void area()
    {
        System.out.println("Area of different shapes");
    }
    void area(int R)
    {
        System.out.println("Area of Circle: " + 3.14 * R * R);
    }
    void area(int L, int B)
    {
        System.out.println("Area of Rectangle: " + L * B);
    }
};
public class Area {
    public static void main(String[] args)
    {
        ShapeArea a= new ShapeArea();
        ShapeArea a1=new ShapeArea();
        a1.area(7);
        ShapeArea a2=new ShapeArea();
        a2.area(20,10);
    }
    
}
