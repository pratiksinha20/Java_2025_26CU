package CU.Practice.LabCheckoutSystem;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        HashMap<String, Student> students = new HashMap<>();
        students.put("KRG20281", new Student("KRG20281", "Pratik", 0, 0));
        students.put("ABC12345", new Student("ABC12345", "Rahul", 100, 1));

        AssetStore store = new AssetStore();
        store.addAsset(new Asset("LAB-101", "HDMI Cable", true, 1));
        store.addAsset(new Asset("LAB-202", "Projector", true, 3));
        store.addAsset(new Asset("LAB-303", "Mouse", false, 1));

        CheckoutService service = new CheckoutService(students, store);

        CheckoutRequest[] requests = {
                new CheckoutRequest("KRG20281", "LAB-101", 5),  // success
                new CheckoutRequest("KRG20281", "LAB-XYZ", 2),  // invalid
                new CheckoutRequest("ABC12345", "LAB-202", 4)   // policy fail
        };

        for (CheckoutRequest req : requests) {

            try {
                String receipt = service.checkout(req);
                System.out.println("SUCCESS: " + receipt);
            }
            catch (IllegalArgumentException e) {
                AuditLogger.logError(e);
            }
            catch (NullPointerException e) {
                AuditLogger.logError(e);
            }
            catch (SecurityException e) {
                AuditLogger.logError(e);
            }
            catch (IllegalStateException e) {
                AuditLogger.logError(e);
            }
            finally {
                AuditLogger.log("Audit: attempt finished for UID=" +
                        req.uid + ", asset=" + req.assetId);
            }
        }
    }
}