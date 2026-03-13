package CU.Practice;

public class Thread {
    // public static void main(String[] args)
    // {
    //     MyThread t1 = new MyThread();
    //     // t1.start();
    //     try {
    //         // t1.start();
    //     } catch (InterruptedException e) {
    //         e.printStackTrace();
    //     }
    // }
    
}

class MyThread extends Thread{
    public void run()
    {
       for(int i=0; i<5; i++)
        {
            System.out.println("Thread is running:" + i);
        } 
    }
}
Package Structure
com.course
  ├── model
  ├── service
  ├── exception
  └── main
