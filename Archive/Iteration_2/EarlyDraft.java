package Archive.Iteration_2;

import java.util.*;

/**
 * Early bones of the Patient class
 */
class Patient {

  String name;
  String patientID;
  String patientMotherID;
  ArrayList<String> records;




  Patient(String name) {
    this.name = name;
    this.patientID = UUID.randomUUID().toString();
    this.patientMotherID = null; // This can be set later
    this.records = null; // Placeholder for records

  }


  Patient(String name, String ID) {
    this.name = name;
    this.patientID = ID;
    this.patientMotherID = null; // This can be set later
    records = new ArrayList<>();
  }

  String getName() {
    return name;
  }

  /**
   * Previously used for Use Case 5, but no longer fits the Patient Architecture; commented out for now.
   */
  // void addMedicalCondition(String condition, boolean isHereditary) {
  //   medicalHistory.put(condition, isHereditary);
  // }

  // Map<String, Boolean> getMedicalHistory() {
  //   return medicalHistory;
  // }

  class Record {
    String date;
    String bloodPressure;
    int pulse;
    double bodyTemp;
    double weight;
    String respiration;
    String caseStatus;
    String[] conditionHistory;
    String principalCondition;
    String additionalDiagnosis;
    String treatment;
    boolean referralStatus;
    double treatmentCost;
    String remarks;

    public Record(String date, String bloodPressure, int pulse, double bodyTemp,
        double weight, String respiration, String caseStatus,
        String[] conditionHistory, String principalCondition,
        String additionalDiagnosis, String treatment, boolean referralStatus,
        double treatmentCost, String remarks) {
      this.date = date;
      this.bloodPressure = bloodPressure;
      this.pulse = pulse;
      this.bodyTemp = bodyTemp;
      this.weight = weight;
      this.respiration = respiration;
      this.caseStatus = caseStatus;
      this.conditionHistory = conditionHistory;
      this.principalCondition = principalCondition;
      this.additionalDiagnosis = additionalDiagnosis;
      this.treatment = treatment;
      this.referralStatus = referralStatus;
      this.treatmentCost = treatmentCost;
      this.remarks = remarks;
    }
  }
  class Clinic {
    int clinicID;
    String facilityZone;
    String district;
    String subDistrict;

    public Clinic(int clinicID, String facilityZone, String district,
        String subDistrict) {
      this.clinicID = clinicID;
      this.facilityZone = facilityZone;
      this.district = district;
      this.subDistrict = subDistrict;
    }
  }
}

/**
 * Early bones of the Delivery class
 */
class Delivery {

  Patient mother;
  Patient baby;
  String outcome;

  Delivery(Patient mother, Patient baby, String outcome) {
    this.mother = mother;
    this.baby = baby;
    this.outcome = outcome;
  }
}

/**
 * Use Case 1:Nurse enters delivery info. It is saved to a list.
 */
class UseCase1 {

  static List<Delivery> deliveries = new ArrayList<>();

  static void saveDelivery(Patient mother, Patient baby, String outcome) {
    Delivery d = new Delivery(mother, baby, outcome);
    deliveries.add(d);
    System.out.println(
      "Delivery added for: " + mother.name + " and baby " + baby.name
    );
  }
}

/**
 * Use Case 2: Show simple version of monthly report
 */
class UseCase2 {

  static void printReport() {
    System.out.println("*** Monthly Midwife Report ***"); //This can be changed later on if needed
    int entry = 1;
    for (Delivery d : UseCase1.deliveries) {
      System.out.println("Entry #" + entry++);
      System.out.println("Mother: " + d.mother.name); 
      System.out.println("Baby: " + d.baby.name);
      System.out.println("Outcome: " +d.outcome); 
    }
    System.out.println("*** End of Report ***");
  }
}

/**
 * Use Case 3: Check if patient exists, if not create a new one.
 */
class UseCase3 {

  static Map<String, Patient> patientMap = new HashMap<>();

  static Patient getOrCreatePatient(String name, String ID) {
    if (!patientMap.containsKey(ID)) {
      patientMap.put(ID, new Patient(name, ID));
      System.out.println("New patient added: " + name);
    }
    return patientMap.get(ID);
  }
}

/*
 * Use Case 4: Nurse searches for a specific mother. 
 * System displays past medical conditions linked to her profile to add to baby's profile.
 */
 class UseCase4 {
  static void searchMother(String ID) {
    System.out.println("Searching for mother of patient with ID: [" + ID + "]...");
    if (!UseCase3.patientMap.containsKey(ID)) {
      System.out.println("Patient with ID: [" + ID + "] not found.");
      return;
    }
    Patient cur = UseCase3.patientMap.get(ID);
    if (cur.patientMotherID != null) {
      Patient mother = UseCase3.patientMap.get(cur.patientMotherID);
      System.out.println("Patient's mother found: " + mother.getName()+" with ID: " + mother.patientID);
      System.out.println("Mother's Medical History:");
      for (int i=0; i<mother.records.size(); i++) {
        System.out.println((i+1)+". "+mother.records.get(i));
      }
      System.out.println("Do you wish to add any of these medical conditions to the newborn's medical history? \nIf so, please enter the corresponding number, separate them by commas if needed (e.g. 1,3,4) or type 'no' to skip:");
      Scanner scanner = new Scanner(System.in);
      String response = scanner.nextLine();
      if (!response.equalsIgnoreCase("no")) {
        String[] indices = response.split(",");
        for (String index : indices) {
          try {
            int idx = Integer.parseInt(index.trim()) - 1;
            if (idx >= 0 && idx < mother.records.size()) {
              String condition = mother.records.get(idx);
              cur.records.add(condition+
                " [POSSIBLY INHERITED]"); // Mark as possibly inherited
              System.out.println("Added condition: " + condition + " to newborn's medical history.");
            } else {
              System.out.println("Invalid index: " + index);
            }
          } catch (NumberFormatException e) {
            System.out.println("Invalid input: " + index);
          }
        }
      } else {
        System.out.println("No conditions added.");
      }
      scanner.close();
    } else {
      System.out.println("FAILED to find Mother of Patient with ID: " + ID);
    }
  }
 }

 /*
  * CURRENTLY COMMENTED OUT SINCE THIS USE CASE NO LONGER FITS THE NEW PATIENT ARCHITECTURE.
  * Use Case 5: Possible hereditary red flags from the mother's medical history (such as genetic defects) 
  * are included on the newborn's newly created medical history
  */
  // class UseCase5 {
  //   static void checkHereditaryConditions(Patient mother, Patient baby) {
  //     for (Map.Entry<String, Boolean> entry : mother.getMedicalHistory().entrySet()) {
  //       if (entry.getValue()) {
  //         baby.addMedicalCondition("[POSSIBLY INHERITED]: "+entry.getKey(), true);
  //       }
  //     }
  //   }
  // }

/**
 * Main method to show the use cases working
 */
public class EarlyDraft {

  public static void main(String[] args) {

    demoUseCase4();

  }


  public static void demoUseCase4() {
    System.out.println("--------------------------------------------------------");
    Patient mother = UseCase3.getOrCreatePatient("Test Mom 1", "123");
    Patient baby = UseCase3.getOrCreatePatient("Test Baby 1", "456");
    /*
     * Typically, the mother's ID would be set when the baby is created, and she would already have
     * medical records without the need to add them here, but this is just for demo purposes.
     */
    baby.patientMotherID = mother.patientID; // Set the mother's ID for the baby

    mother.records.add("Heart Disease");   // Example records
    mother.records.add("Back Pain");
    mother.records.add("Diabetes");
    mother.records.add("Asthma");

    System.out.println("-----------DEMO: SEARCH FOR PATIENT'S MOTHER------------");
    UseCase4.searchMother("test");  // Test case for non-existing patient
    UseCase4.searchMother(baby.patientID);
    System.out.println("Baby Patient's records: "+baby.records.toString());
  }
}
