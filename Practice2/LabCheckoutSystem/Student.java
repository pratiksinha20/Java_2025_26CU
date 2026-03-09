package CU.Practice2.LabCheckoutSystem;

public class Student {

    String uid;
    String name;
    int fineAmount;
    int currentBorrowCount;

    public Student(String uid, String name, int fineAmount, int currentBorrowCount) {
        this.uid = uid;
        this.name = name;
        this.fineAmount = fineAmount;
        this.currentBorrowCount = currentBorrowCount;
    }
}
