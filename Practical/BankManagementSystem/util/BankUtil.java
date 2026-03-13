package CU.Practical.BankManagementSystem.util;

public class BankUtil {
    public static int generateAccountNumber() {
        return (int)(Math.random() * 100000);
    }

    public static void validateMinimumBalance(double balance) throws Exception {

        if(balance < 1000) {
            throw new Exception("Minimum balance must be ₹1000");
        }
    }    
    
}
