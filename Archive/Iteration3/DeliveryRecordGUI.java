package Archive.Iteration3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * A GUI form to manually create a DeliveryRecord by entering field values.
 * 
 * Simulates filling out a delivery record form used in healthcare data systems.
 * 
 * @author Birth and Delivery Team
 * @version 27 April, 2025
 */
public class DeliveryRecordGUI extends JFrame {

    private JTextField facilityNameField;
    private JTextField subDistrictField;
    private JTextField sNoField;
    private JTextField dateField;
    private JTextField nhisRegNumberField;
    private JTextField choIDField;
    private JTextField whoDeliveredBabyField;
    private JTextField motherPatientIDField;
    private JTextField pregnancyDurationField;
    private JTextField deliveryDateField;
    private JTextField dischargeDateField;
    private JTextField referredDateField;
    private JTextField bpField;
    private JTextField pulseField;
    private JTextField tempField;
    private JTextField weightField;
    private JTextField heightField;
    private JTextField bloodLossField;
    private JCheckBox motherAliveCheck;
    private JCheckBox episiotomyCheck;
    private JCheckBox tearCheck;
    private JCheckBox oxytocinCheck;
    private JCheckBox ergometrineCheck;
    private JCheckBox placentaExaminedCheck;
    private JTextField commentsField;
    private JButton importBabyRecordsButton;
    
    private ArrayList<BabyRecord> babyRecords = new ArrayList<>();

    private UseCaseDemoGUI mainGUI; // Reference to outputArea

    private static FormMemory savedFormMemory = null;


    /**
     * Constructor to create the DeliveryRecord GUI.
     * 
     * @param mainGUI Reference to the main GUI for output display.
     */
    public DeliveryRecordGUI(UseCaseDemoGUI mainGUI) {
        this.mainGUI = mainGUI;

        setTitle("Create Delivery Record");
        setSize(600, 800);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JScrollPane scrollPane = new JScrollPane(panel);

        facilityNameField = addLabeledField(panel, "Facility Name:");
        subDistrictField = addLabeledField(panel, "Sub District:");
        sNoField = addLabeledField(panel, "Serial Number:");
        dateField = addLabeledField(panel, "Date:");
        nhisRegNumberField = addLabeledField(panel, "NHIS Registration Number:");
        choIDField = addLabeledField(panel, "CHO ID:");
        whoDeliveredBabyField = addLabeledField(panel, "Who Delivered Baby:");
        motherPatientIDField = addLabeledField(panel, "Mother Patient ID:");
        pregnancyDurationField = addLabeledField(panel, "Pregnancy Duration:");
        deliveryDateField = addLabeledField(panel, "Delivery Date:");
        dischargeDateField = addLabeledField(panel, "Discharge Date:");
        referredDateField = addLabeledField(panel, "Referred Date:");
        bpField = addLabeledField(panel, "Blood Pressure:");
        pulseField = addLabeledField(panel, "Pulse (BPM):");
        tempField = addLabeledField(panel, "Temperature:");
        weightField = addLabeledField(panel, "Weight:");
        heightField = addLabeledField(panel, "Height:");
        bloodLossField = addLabeledField(panel, "Blood Loss (ml):");
        
        motherAliveCheck = addLabeledCheck(panel, "Mother Alive?");
        episiotomyCheck = addLabeledCheck(panel, "Episiotomy?");
        tearCheck = addLabeledCheck(panel, "Tear?");
        oxytocinCheck = addLabeledCheck(panel, "Oxytocin Given?");
        ergometrineCheck = addLabeledCheck(panel, "Ergometrine Given?");
        placentaExaminedCheck = addLabeledCheck(panel, "Placenta Examined?");
        
        commentsField = addLabeledField(panel, "Comments:");

        if (savedFormMemory != null) {
            facilityNameField.setText(savedFormMemory.facilityName);
            subDistrictField.setText(savedFormMemory.subDistrict);
            sNoField.setText(savedFormMemory.sNo);
            dateField.setText(savedFormMemory.date);
            nhisRegNumberField.setText(savedFormMemory.nhisRegNumber);
            choIDField.setText(savedFormMemory.choID);
            whoDeliveredBabyField.setText(savedFormMemory.whoDeliveredBaby);
            motherPatientIDField.setText(savedFormMemory.motherPatientID);
            pregnancyDurationField.setText(savedFormMemory.pregnancyDuration);
            deliveryDateField.setText(savedFormMemory.deliveryDate);
            dischargeDateField.setText(savedFormMemory.dischargeDate);
            referredDateField.setText(savedFormMemory.referredDate);
            bpField.setText(savedFormMemory.bp);
            pulseField.setText(savedFormMemory.pulse);
            tempField.setText(savedFormMemory.temp);
            weightField.setText(savedFormMemory.weight);
            heightField.setText(savedFormMemory.height);
            bloodLossField.setText(savedFormMemory.bloodLoss);
            motherAliveCheck.setSelected(savedFormMemory.motherAlive);
            episiotomyCheck.setSelected(savedFormMemory.episiotomy);
            tearCheck.setSelected(savedFormMemory.tear);
            oxytocinCheck.setSelected(savedFormMemory.oxytocin);
            ergometrineCheck.setSelected(savedFormMemory.ergometrine);
            placentaExaminedCheck.setSelected(savedFormMemory.placentaExamined);
            commentsField.setText(savedFormMemory.comments);
        }
        

        importBabyRecordsButton = new JButton("Import Baby Records (Demo)");
        importBabyRecordsButton.addActionListener(e -> {
            // For demo purposes, just add two dummy BabyRecords
            babyRecords.clear();
            babyRecords.add(new BabyRecord(1, 8, 50.5, 35.0, 3.5, 7, 9));
            babyRecords.add(new BabyRecord(2, 9, 52.0, 36.0, 3.8, 8, 10));
            JOptionPane.showMessageDialog(this, "Dummy BabyRecords imported!");
        });
        panel.add(importBabyRecordsButton);
        
        // Save and Submit Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton saveButton = new JButton("Save");
        JButton submitButton = new JButton("Submit");
        JButton clearFormButton = new JButton("Clear");

        saveButton.addActionListener(e -> {
            savedFormMemory = new FormMemory();
            savedFormMemory.facilityName = facilityNameField.getText();
            savedFormMemory.subDistrict = subDistrictField.getText();
            savedFormMemory.sNo = sNoField.getText();
            savedFormMemory.date = dateField.getText();
            savedFormMemory.nhisRegNumber = nhisRegNumberField.getText();
            savedFormMemory.choID = choIDField.getText();
            savedFormMemory.whoDeliveredBaby = whoDeliveredBabyField.getText();
            savedFormMemory.motherPatientID = motherPatientIDField.getText();
            savedFormMemory.pregnancyDuration = pregnancyDurationField.getText();
            savedFormMemory.deliveryDate = deliveryDateField.getText();
            savedFormMemory.dischargeDate = dischargeDateField.getText();
            savedFormMemory.referredDate = referredDateField.getText();
            savedFormMemory.bp = bpField.getText();
            savedFormMemory.pulse = pulseField.getText();
            savedFormMemory.temp = tempField.getText();
            savedFormMemory.weight = weightField.getText();
            savedFormMemory.height = heightField.getText();
            savedFormMemory.bloodLoss = bloodLossField.getText();
            savedFormMemory.motherAlive = motherAliveCheck.isSelected();
            savedFormMemory.episiotomy = episiotomyCheck.isSelected();
            savedFormMemory.tear = tearCheck.isSelected();
            savedFormMemory.oxytocin = oxytocinCheck.isSelected();
            savedFormMemory.ergometrine = ergometrineCheck.isSelected();
            savedFormMemory.placentaExamined = placentaExaminedCheck.isSelected();
            savedFormMemory.comments = commentsField.getText();
        
            JOptionPane.showMessageDialog(this, "Form data saved!");
        });
        

        submitButton.addActionListener(e -> {
            DeliveryRecord record = buildDeliveryRecord();
            if (record != null) {
                mainGUI.appendOutput(record.toString());
                JOptionPane.showMessageDialog(this, "DeliveryRecord submitted!");
                clearForm(); // Reset fields after submission
                this.dispose();
            }
        });

        clearFormButton.addActionListener(e -> clearForm());


        buttonPanel.add(saveButton);
        buttonPanel.add(submitButton);
        buttonPanel.add(clearFormButton);
        panel.add(buttonPanel);

        add(scrollPane);
        setVisible(true);
    }

    /**
     * Clears the form fields.
     */
    private void clearForm() {
        facilityNameField.setText("");
        subDistrictField.setText("");
        sNoField.setText("");
        dateField.setText("");
        nhisRegNumberField.setText("");
        choIDField.setText("");
        whoDeliveredBabyField.setText("");
        motherPatientIDField.setText("");
        pregnancyDurationField.setText("");
        deliveryDateField.setText("");
        dischargeDateField.setText("");
        referredDateField.setText("");
        bpField.setText("");
        pulseField.setText("");
        tempField.setText("");
        weightField.setText("");
        heightField.setText("");
        bloodLossField.setText("");
        motherAliveCheck.setSelected(false);
        episiotomyCheck.setSelected(false);
        tearCheck.setSelected(false);
        oxytocinCheck.setSelected(false);
        ergometrineCheck.setSelected(false);
        placentaExaminedCheck.setSelected(false);
        commentsField.setText("");
        babyRecords.clear();
    
        savedFormMemory = null; // Clear saved memory
    }
    
    

    /**
     * Adds a labeled text field to the panel.
     * 
     * @param panel The panel to add the field to.
     * @param label The label for the field.
     * @return The created JTextField.
     */
    private JTextField addLabeledField(JPanel panel, String label) {
        JLabel jlabel = new JLabel(label);
        JTextField textField = new JTextField(20);
        JPanel container = new JPanel(new FlowLayout(FlowLayout.LEFT));
        container.add(jlabel);
        container.add(textField);
        panel.add(container);
        return textField;
    }

    /**
     * Adds a labeled checkbox to the panel.
     * 
     * @param panel The panel to add the checkbox to.
     * @param label The label for the checkbox.
     * @return The created JCheckBox.
     */
    private JCheckBox addLabeledCheck(JPanel panel, String label) {
        JCheckBox checkBox = new JCheckBox(label);
        JPanel container = new JPanel(new FlowLayout(FlowLayout.LEFT));
        container.add(checkBox);
        panel.add(container);
        return checkBox;
    }

    /**
     * Builds a DeliveryRecord object from the input fields.
     * 
     * @return The created DeliveryRecord object.
     */
    private DeliveryRecord buildDeliveryRecord() {
        try {
            return new DeliveryRecord(
                facilityNameField.getText(),
                subDistrictField.getText(),
                Integer.parseInt(sNoField.getText()),
                dateField.getText(),
                Integer.parseInt(nhisRegNumberField.getText()),
                Integer.parseInt(choIDField.getText()),
                whoDeliveredBabyField.getText(),
                Integer.parseInt(motherPatientIDField.getText()),
                pregnancyDurationField.getText(),
                deliveryDateField.getText(),
                dischargeDateField.getText(),
                referredDateField.getText(),
                babyRecords,
                bpField.getText(),
                pulseField.getText(),
                tempField.getText(),
                Double.parseDouble(weightField.getText()),
                Double.parseDouble(heightField.getText()),
                Double.parseDouble(bloodLossField.getText()),
                motherAliveCheck.isSelected(),
                episiotomyCheck.isSelected(),
                tearCheck.isSelected(),
                oxytocinCheck.isSelected(),
                ergometrineCheck.isSelected(),
                placentaExaminedCheck.isSelected(),
                commentsField.getText()
            );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error creating DeliveryRecord: " + e.getMessage());
            return null;
        }
    }

    /**
     * Class to hold form data temporarily.
     */
    private static class FormMemory {
        String facilityName;
        String subDistrict;
        String sNo;
        String date;
        String nhisRegNumber;
        String choID;
        String whoDeliveredBaby;
        String motherPatientID;
        String pregnancyDuration;
        String deliveryDate;
        String dischargeDate;
        String referredDate;
        String bp;
        String pulse;
        String temp;
        String weight;
        String height;
        String bloodLoss;
        boolean motherAlive;
        boolean episiotomy;
        boolean tear;
        boolean oxytocin;
        boolean ergometrine;
        boolean placentaExamined;
        String comments;
    }
    
}
