package Archive.Iteration3;
import java.util.ArrayList;

public class DeliveryRecordTest {

    public static void testDeliveryRecord() {
        // Create BabyRecord objects
        BabyRecord baby1 = new BabyRecord(1, 8, 50.5, 35.0, 3.5, 7, 9);
        BabyRecord baby2 = new BabyRecord(2, 9, 52.0, 36.0, 3.8, 8, 10);

        // Add BabyRecord objects to a list
        ArrayList<BabyRecord> babyRecords = new ArrayList<>();
        babyRecords.add(baby1);
        babyRecords.add(baby2);

        // Create a DeliveryRecord object with necessary data
        DeliveryRecord deliveryRecord = new DeliveryRecord(
            "City Hospital",
            "North District",
            1001,
            "2025-04-14",
            123456,
            98765,
            "Dr. Jane Smith",
            1001,
            "38 weeks",
            "2025-04-14",
            "2025-04-15",
            "2025-04-16",
            babyRecords,
            "120/80 mmHg",
            "75 bpm",
            "37.0°C",
            70.0,
            1.65,
            500.0,
            true,
            true,
            false,
            true,
            true,
            true,
            "Healthy delivery"
        );

        // PRINT TEST:
        System.out.print(deliveryRecord);
    }
        
}
