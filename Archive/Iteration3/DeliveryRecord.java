package Archive.Iteration3;

import java.util.ArrayList;

public class DeliveryRecord {
    private String facilityName;
    private String subDistrict;
    private int sNo;
    private String date;
    private int nhisRegNumber;
    private int choID;
    private String whoDeliveredBaby;
    private int motherPatientID;
    private String pregnancyDuration;
    private String deliveryDate;
    private String dischargeDate;
    private String referredDate;
    private ArrayList<BabyRecord> babyRecords;

    private String bp;
    private String pulse;
    private String temp;
    private double weight;
    private double height;
    private double bloodLoss;

    private boolean motherAlive;
    private boolean episiotomy;
    private boolean tear;
    private boolean oxytocin;
    private boolean ergometrine;
    private boolean placentaExamined;
    private String comments;

    public DeliveryRecord(String facilityName, String subDistrict, int sNo, String date, int nhisRegNumber, int choID,
                          String whoDeliveredBaby, int motherPatientID, String pregnancyDuration, String deliveryDate,
                          String dischargeDate, String referredDate, ArrayList<BabyRecord> babyRecords,
                          String bp, String pulse, String temp, double weight, double height, double bloodLoss,
                          boolean motherAlive, boolean episiotomy, boolean tear, boolean oxytocin,
                          boolean ergometrine, boolean placentaExamined, String comments) {

        this.facilityName = facilityName;
        this.subDistrict = subDistrict;
        this.sNo = sNo;
        this.date = date;
        this.nhisRegNumber = nhisRegNumber;
        this.choID = choID;
        this.whoDeliveredBaby = whoDeliveredBaby;
        this.motherPatientID = motherPatientID;
        this.pregnancyDuration = pregnancyDuration;
        this.deliveryDate = deliveryDate;
        this.dischargeDate = dischargeDate;
        this.referredDate = referredDate;
        this.babyRecords = babyRecords != null ? babyRecords : new ArrayList<>();
        this.bp = bp;
        this.pulse = pulse;
        this.temp = temp;
        this.weight = weight;
        this.height = height;
        this.bloodLoss = bloodLoss;
        this.motherAlive = motherAlive;
        this.episiotomy = episiotomy;
        this.tear = tear;
        this.oxytocin = oxytocin;
        this.ergometrine = ergometrine;
        this.placentaExamined = placentaExamined;
        this.comments = comments;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Delivery Record:\n");
        sb.append("Facility Name: ").append(facilityName).append("\n");
        sb.append("Sub-district: ").append(subDistrict).append("\n");
        sb.append("Serial No: ").append(sNo).append("\n");
        sb.append("Date: ").append(date).append("\n");
        sb.append("NHIS Registration Number: ").append(nhisRegNumber).append("\n\n");

        sb.append("Mother Patient ID: ").append(motherPatientID).append("\n\n");

        sb.append("Pregnancy Info:\n");
        sb.append("Pregnancy Duration: ").append(pregnancyDuration).append("\n");
        sb.append("Delivery Date: ").append(deliveryDate).append("\n");
        sb.append("Discharge Date: ").append(dischargeDate).append("\n");
        sb.append("Referred Date: ").append(referredDate).append("\n\n");

        sb.append("Baby Records:\n");
        for (int i = 0; i < babyRecords.size(); i++) {
            String babyInformation = babyRecords.get(i).toString();
            sb.append("Baby ").append(i + 1).append(":\n").append(babyInformation).append("\n");
        }

        sb.append("\nCHO Info:\n");
        sb.append("CHO ID: ").append(choID).append(", Delivered by: ").append(whoDeliveredBaby).append("\n\n");

        sb.append("Mother Health Info:\n");
        sb.append("BP: ").append(bp).append(", Pulse: ").append(pulse).append(", Temp: ").append(temp).append("\n");
        sb.append("Weight: ").append(weight).append(" kg, Height: ").append(height).append(" m\n");
        sb.append("Blood Loss: ").append(bloodLoss).append(" ml\n\n");

        sb.append("Perineal Care:\n");
        sb.append("Alive: ").append(motherAlive).append(", Episiotomy: ").append(episiotomy)
          .append(", Tear: ").append(tear).append("\n");
        sb.append("Oxytocin: ").append(oxytocin).append(", Ergometrine: ").append(ergometrine)
          .append(", Placenta Examined: ").append(placentaExamined).append("\n\n");

        sb.append("Comments: ").append(comments).append("\n");
        return sb.toString();
    }
}
