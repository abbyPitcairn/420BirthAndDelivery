package Archive.Iteration_1;

import java.util.ArrayList;
import java.util.Date;

public class DeliveryRecord {

    // Header information (possibly to be replaced with unique integer IDs)
    private String facilityName;
    private String subDistrict;

    // Form-specific information
    private int sNo;
    private Date date;
    private int nhisRegNumber;

    // Patient information
    private Patient mother;

    // Pregnancy information
    private String pregnancyDuration;
    private Date deliveryDate;
    private Date dischargeDate;
    private Date referredDate;

    // Delivery Summary
    private int numBabies;
    private ArrayList<Patient> totalBabies = new ArrayList<>(numBabies);

        // Baby health information: this will need to be attached to each baby in the list
        private int apgarScore;
        private double lengthOfBaby;
        private double babyHeadCircumference;
        private int latchScoreWithinHour; // Breastfeeding results within 1 hour of birth
        private int latchScoreAfterHour; // Breastfeeding results 1 hour after birth
    

    // Healthcare Official Information
    private int choID; // Certified healthcare official's unique ID 
    private String whoDeliveredBaby; // Name of CHO who delivered baby

    // Mother health information
    private String bp; //blood pressure
    private String pulse; 
    private String temp; 
    private double weight;
    private double height;
    private double bloodLoss; //measured 

    // Perineal care
    private boolean motherAlive;
    private boolean episiotomy; // yes/no, was this post-birth prodedure done
    private boolean tear; // yes/no, was their tearing during the birth
    private boolean oxytocin; // yes/no, was oxytocin administired
    private boolean ergometrine; // yes/no, was ergometrine administired
    private boolean placentaExamined;  // yes/no, was the placenta examined

    // Comments/Remarks
    private String comments;

    // Constructor
    public DeliveryRecord(String facilityName, String subDistrict, int sNo, Date date, int nhisRegNumber, Patient mother, ArrayList<Patient> babies) {
        this.facilityName = facilityName;
        this.subDistrict = subDistrict;
        this.sNo = sNo;
        this.date = date;
        this.nhisRegNumber = nhisRegNumber;
        this.mother = mother;
        this.totalBabies = babies;
        // Add some more here based on what is needed for midwife report?
    }
}

// Generic Patient class (placeholder only)
class Patient {
    private String name;
    private int age;
    private String gender;
    private String address;

    public Patient(String name, int age, String gender, String address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }
}

