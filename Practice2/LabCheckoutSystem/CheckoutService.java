package CU.Practice.LabCheckoutSystem;

import java.util.HashMap;

public class CheckoutService {

    HashMap<String, Student> students;
    AssetStore store;

    public CheckoutService(HashMap<String, Student> students, AssetStore store) {
        this.students = students;
        this.store = store;
    }

    public String checkout(CheckoutRequest req)
            throws IllegalArgumentException, IllegalStateException,
                   SecurityException, NullPointerException {

        ValidationUtil.validateUid(req.uid);
        ValidationUtil.validateAssetId(req.assetId);
        ValidationUtil.validateHours(req.hoursRequested);

        Student s = students.get(req.uid);
        if (s == null)
            throw new NullPointerException("Student not found");

        Asset a = store.findAsset(req.assetId);

        if (s.fineAmount > 0)
            throw new IllegalStateException("Outstanding fine exists");

        if (s.currentBorrowCount >= 2)
            throw new IllegalStateException("Borrow limit reached");

        if (!a.available)
            throw new IllegalStateException("Asset unavailable");

        if (a.securityLevel == 3 && !s.uid.startsWith("KRG"))
            throw new SecurityException("Restricted asset");

        // Realistic constraints
        if (req.hoursRequested == 6) {
            System.out.println("Note: Max duration selected.");
        }

        if (a.assetName.contains("Cable") && req.hoursRequested > 3) {
            req.hoursRequested = 3;
            System.out.println("Policy applied: Cables max 3 hours.");
        }

        store.markBorrowed(a);
        s.currentBorrowCount++;

        return "TXN-20260221-" + a.assetId + "-" + s.uid;
    }
}