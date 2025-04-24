package Archive.Iteration_2;

import java.util.ArrayList;

public class DeliveryRegister {

    ArrayList<DeliveryRecord> DeliveryRegister = new ArrayList<>();    

    public void addRecord(DeliveryRecord record){
        DeliveryRegister.add(record);
    }

    public boolean deleteRecord(DeliveryRecord record){
        return DeliveryRegister.remove(record);
    }

    public void editRecord(DeliveryRecord record){
        // find record; open record; allow changes to record; add record back to register
    }

    public void printRecord(DeliveryRecord record){
        System.out.println(record.toString());
    }

}