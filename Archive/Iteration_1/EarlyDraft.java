package Archive.Iteration_1;

import java.util.*;

/**
 * Early bones of the Patient class
 */
class Patient {

  String name;

  Patient(String name) {
    this.name = name;
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

/**
 * Main method to show the use cases working
 */
public class EarlyDraft {

  public static void main(String[] args) {
    // Create or get patients
    Patient mother = UseCase3.getOrCreatePatient("Test Mom 1");
    Patient baby = UseCase3.getOrCreatePatient("Test Baby 1");
    // Save delivery
    UseCase1.saveDelivery(mother, baby, "Successful Birth");
    // Print report
    UseCase2.printReport();
  }
}
