package CU;
import java.io.File;
import java.io.FileWriter;



public class File1 {
    public static void main(String[] args) throws Exception
    {
        File file=new File("newfile.txt");
        if(file.createNewFile())
        {
            System.out.println("File created: "+file.getName());
        }
        else
        {
            System.out.println("File already exists.");
        }
        FileWriter writer=new FileWriter("newfile.txt");
        writer.write("Pratik Kumar Sinha");
        writer.write("\n");
        writer.write("hello pratik");
        writer.close();
    } 
    
}
