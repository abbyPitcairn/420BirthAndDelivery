package Archive.Iteration_1;

import java.util.*;

/**
 * Early bones of the Patient class
 */
class Patient {

  String name;
  Map<String, Boolean> medicalHistory;


  Patient(String name) {
    this.name = name;
    this.medicalHistory = new HashMap<>();

  }

  String getName() {
    return name;
  }

  void addMedicalCondition(String condition, boolean isHereditary) {
    medicalHistory.put(condition, isHereditary);
  }

  Map<String, Boolean> getMedicalHistory() {
    return medicalHistory;
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
    System.out.println("Monthly Midwife Report:"); //This can be changed later on if needed
    for (Delivery d : UseCase1.deliveries) {
      System.out.println(
        "Mother: " +
        d.mother.name +
        ", Baby: " +
        d.baby.name +
        ", Outcome: " +
        d.outcome
      );
    }
  }
}

/**
 * Use Case 3: Check if patient exists, if not create a new one.
 */
class UseCase3 {

  static Map<String, Patient> patientMap = new HashMap<>();

  static Patient getOrCreatePatient(String name) {
    if (!patientMap.containsKey(name)) {
      patientMap.put(name, new Patient(name));
      System.out.println("New patient added: " + name);
    }
    return patientMap.get(name);
  }
}

/*
 * Use Case 4: Nurse searches for a specific mother. 
 * System displays past delivery records and outcomes linked to her profile.
 */
 class UseCase4 {
  static void searchPatient(String name) {
    if (UseCase3.patientMap.containsKey(name)) {
      System.out.println("Patient found: " + name);
      for (Delivery d : UseCase1.deliveries) {
        if (d.mother.name.equals(name)) {
          System.out.println("Mother: " + d.mother.name + ", Baby: " + d.baby.name + ", Outcome: " + d.outcome);
        }
      }
    } else {
      System.out.println("Patient not found: " + name);
    }
  }
 }

 /*
  * Use Case 5: Possible hereditary red flags from the mother's medical history (such as genetic defects) 
  * are included on the newborn's newly created medical history
  */
  class UseCase5 {
    static void checkHereditaryConditions(Patient mother, Patient baby) {
      for (Map.Entry<String, Boolean> entry : mother.getMedicalHistory().entrySet()) {
        if (entry.getValue()) {
          baby.addMedicalCondition("[POSSIBLY INHERITED]: "+entry.getKey(), true);
        }
      }
    }
  }

/**
 * Main method to show the use cases working
 */
public class EarlyDraft {

  public static void main(String[] args) {
    // Create or get patients
    System.out.println("------------USE CASE 3------------");
    Patient mother = UseCase3.getOrCreatePatient("Test Mom 1");
    Patient baby = UseCase3.getOrCreatePatient("Test Baby 1");
    // Save delivery
    System.out.println("------------USE CASE 1------------");
    UseCase1.saveDelivery(mother, baby, "Successful Birth");
    // Print report
    System.out.println("------------USE CASE 2------------");
    UseCase2.printReport();

    // Search for patient
    System.out.println("------------USE CASE 4------------");
    UseCase4.searchPatient(mother.getName());
    UseCase4.searchPatient("test");

    // Add medical condition
    System.out.println("------------USE CASE 5------------");
    System.out.println("Baby's medical history before additions: " + baby.getMedicalHistory());
    mother.addMedicalCondition("Heart Disease", true);
    mother.addMedicalCondition("Back Pain", false);
    UseCase5.checkHereditaryConditions(mother, baby);
    System.out.println("Baby's medical history after additions: " + baby.getMedicalHistory());
  }
}
