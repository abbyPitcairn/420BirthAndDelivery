package Archive.Iteration3;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * GUI application to demonstrate delivery registration use cases
 * including patient management, delivery recording, and medical history tracking.
 * 
 * This GUI provides buttons to interact with the backend logic
 * for a simulated delivery register system.
 * @author Birth and Delivery Team
 * @version 27 April, 2025
 */
public class UseCaseDemoGUI extends JFrame {

    private JTextArea outputArea;

    /**
     * Constructs the main GUI window with all buttons and output display.
     */
    public UseCaseDemoGUI() {
        setTitle("Delivery Register");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(240, 240, 240)); // Light gray background

        // ===== HEADER =====
        JLabel headerLabel = new JLabel("Delivery Register", SwingConstants.CENTER);
        headerLabel.setFont(new Font("SansSerif", Font.BOLD, 32));
        headerLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(headerLabel, BorderLayout.NORTH);

        // ===== CLEAR OUTPUT BUTTON =====
        JPanel clearPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        clearPanel.setBackground(new Color(240, 240, 240)); // Match background
        JButton clearButton = new JButton("Clear Output");
        clearButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
        clearButton.setFocusPainted(false);
        clearButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        clearButton.setBackground(Color.WHITE);
        clearButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true));
        clearButton.setContentAreaFilled(false);
        clearButton.setOpaque(true);

        // Hover effect for Clear button
        Color originalColor = clearButton.getBackground();
        Color hoverColor = new Color(255, 230, 230); // Light soft pinkish clear color

        clearButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                clearButton.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                clearButton.setBackground(originalColor);
            }
        });

        clearButton.addActionListener(e -> {
            outputArea.setText("");
        });

        clearPanel.add(clearButton);
        add(clearPanel, BorderLayout.AFTER_LAST_LINE);


        // ===== BUTTON PANEL =====
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 2, 20, 20)); // 4 rows, 2 columns, spacing 20px
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        buttonPanel.setBackground(new Color(240, 240, 240));

        // Buttons
        JButton createPatientButton = createStyledButton("Create or Fetch Patient");
        JButton saveDeliveryButton = createStyledButton("Save Delivery Info");
        JButton searchMotherButton = createStyledButton("Search for a Patient's Mother");
        JButton printReportButton = createStyledButton("Print Monthly Midwife Report");
        JButton testDeliveryRecordButton = createStyledButton("Test Delivery Record");
        JButton addMedicalHistoryButton = createStyledButton("Add Medical History to Patient");
        JButton viewAllPatientsButton = createStyledButton("View All Patients");
        JButton viewMedicalHistoryButton = createStyledButton("View Patient Medical History");


        // Add buttons to panel
        buttonPanel.add(createPatientButton);
        buttonPanel.add(saveDeliveryButton);
        buttonPanel.add(searchMotherButton);
        buttonPanel.add(printReportButton);
        buttonPanel.add(testDeliveryRecordButton);
        buttonPanel.add(addMedicalHistoryButton);
        buttonPanel.add(viewAllPatientsButton);
        buttonPanel.add(viewMedicalHistoryButton);


        add(buttonPanel, BorderLayout.WEST);

        // ===== OUTPUT AREA =====
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane, BorderLayout.CENTER);

        // ===== BUTTON ACTIONS =====
        createPatientButton.addActionListener(e -> demoUseCase3());
        saveDeliveryButton.addActionListener(e -> demoUseCase1());
        searchMotherButton.addActionListener(e -> demoUseCase4());
        printReportButton.addActionListener(e -> demoUseCase2());
        testDeliveryRecordButton.addActionListener(e -> testDeliveryRecord());
        addMedicalHistoryButton.addActionListener(e -> addMedicalHistory());
        viewAllPatientsButton.addActionListener(e -> viewAllPatients());
        viewMedicalHistoryButton.addActionListener(e -> viewPatientMedicalHistory());


        setVisible(true);
    }


/**
 * Creates a styled button with hover effects and consistent appearance.
 * 
 * @param text The label text for the button
 * @return A configured JButton
 */
private JButton createStyledButton(String text) {
    JButton button = new JButton(text);
    button.setFont(new Font("SansSerif", Font.PLAIN, 18));
    button.setBackground(Color.WHITE);
    button.setFocusPainted(false);
    button.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true)); // Rounded border
    button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

    // Allow background color changes
    button.setContentAreaFilled(false);
    button.setOpaque(true);

    // === HOVER ANIMATION ===
    Color originalColor = button.getBackground();
    Color hoverColor = new Color(220, 220, 255); // Light blueish

    button.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            button.setBackground(hoverColor);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            button.setBackground(originalColor);
        }
    });

    return button;
}


    /**
     * Appends text to the output area with automatic scrolling to the bottom.
     * 
     * @param text The text to display
     */
    public void appendOutput(String text) {
        outputArea.append(text + "\n");
        outputArea.setCaretPosition(outputArea.getDocument().getLength()); // Auto-scroll
    }


    /**
    * Use Case 1:Nurse enters delivery info. It is saved to a list.
    */
    private void demoUseCase1() {
        String motherName = JOptionPane.showInputDialog(null, "Enter Mother's Name:");
        String motherID = JOptionPane.showInputDialog(null, "Enter Mother's Patient ID:");
        if (motherName == null || motherID == null) {
            appendOutput("Cancelled delivery creation.");
            return;
        }
    
        String babyCountStr = JOptionPane.showInputDialog(null, "Enter Number of Babies Delivered:");
        if (babyCountStr == null) {
            appendOutput("Cancelled delivery creation.");
            return;
        }
    
        int babyCount;
        try {
            babyCount = Integer.parseInt(babyCountStr.trim());
            if (babyCount <= 0) {
                appendOutput("Invalid number of babies.");
                return;
            }
        } catch (NumberFormatException e) {
            appendOutput("Invalid number format.");
            return;
        }
    
        Patient mother = UseCase3.getOrCreatePatient(motherName, motherID);
    
        for (int i = 1; i <= babyCount; i++) {
            String babyName = JOptionPane.showInputDialog(null, "Enter Baby #" + i + " Name:");
            String babyID = JOptionPane.showInputDialog(null, "Enter Baby #" + i + " Patient ID:");
            if (babyName != null && babyID != null) {
                Patient baby = UseCase3.getOrCreatePatient(babyName, babyID);
                baby.patientMotherID = motherID; // Link baby to mother
                String outcome = JOptionPane.showInputDialog(null, "Enter Delivery Outcome for " + babyName + " (e.g., Successful Birth):");
                if (outcome == null) {
                    outcome = "Unknown Outcome"; // Fallback
                }
                UseCase1.saveDelivery(mother, baby, outcome);
                appendOutput("Saved delivery for: " + mother.getName() + " and Baby #" + i + ": " + baby.getName() + " (" + outcome + ")");
            } else {
                appendOutput("Skipped Baby #" + i);
            }
        }
    }
    

    /**
     * Use Case 2: Show simple version of monthly report
     */
    private void demoUseCase2() {
        appendOutput("*** Monthly Midwife Report ***");
        int entry = 1;
        for (Delivery d : UseCase1.deliveries) {
            appendOutput("Entry #" + entry++);
            appendOutput("Mother: " + d.mother.name);
            appendOutput("Baby: " + d.baby.name);
            appendOutput("Outcome: " + d.outcome);
        }
        appendOutput("*** End of Report ***");
    }

    /**
    * Use Case 3: Check if patient exists, if not create a new one.
    */
    private void demoUseCase3() {
        String name = JOptionPane.showInputDialog(null, "Enter Patient Name:");
        String id = JOptionPane.showInputDialog(null, "Enter Patient ID:");

        if (name != null && id != null) {
            Patient patient = UseCase3.getOrCreatePatient(name, id);
            appendOutput("Patient created or fetched: " + patient.getName() + " (ID: " + patient.patientID + ")");
        } else {
            appendOutput("Cancelled patient creation.");
        }
    }

    /**
     * Use Case 4: Search for a patient's mother and add medical history.
     */
    private void demoUseCase4() {
        String babyID = JOptionPane.showInputDialog(null, "Enter Baby's Patient ID to Search for Mother:");
        if (babyID != null) {
            Patient baby = UseCase3.patientMap.get(babyID);
            if (baby != null) {
                if (baby.patientMotherID != null) {
                    Patient mother = UseCase3.patientMap.get(baby.patientMotherID);
                    if (mother != null) {
                        appendOutput("Mother found: " + mother.getName());

                        if (mother.records != null && !mother.records.isEmpty()) {
                            if (baby.records == null) {
                                baby.records = new ArrayList<>();
                            }

                            ArrayList<String> selected = selectMedicalConditions(mother.records);
                            for (String condition : selected) {
                                baby.records.add(condition + " [POSSIBLY INHERITED]");
                                appendOutput("Added to "+baby.getName()+": " + condition);
                            }

                            if (selected.isEmpty()) {
                                appendOutput("No conditions selected.");
                            }

                        } else {
                            appendOutput("Mother has no medical history.");
                        }
                    } else {
                        appendOutput("Mother not found in system.");
                    }
                } else {
                    appendOutput("This baby does not have a mother assigned.");
                }
            } else {
                appendOutput("No baby found with ID: " + babyID);
            }
        } else {
            appendOutput("Cancelled mother search.");
        }
    }

    /**
     * Displays a dialog to select medical conditions from the mother's history.
     * 
     * @param history The list of medical conditions
     * @return A list of selected conditions
     */
    private ArrayList<String> selectMedicalConditions(ArrayList<String> history) {
        ArrayList<JCheckBox> checkBoxes = new ArrayList<>();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (String condition : history) {
            JCheckBox checkBox = new JCheckBox(condition);
            checkBoxes.add(checkBox);
            panel.add(checkBox);
        }

        int result = JOptionPane.showConfirmDialog(null, panel, "Select Conditions to Add to Baby",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        ArrayList<String> selectedConditions = new ArrayList<>();
        if (result == JOptionPane.OK_OPTION) {
            for (JCheckBox box : checkBoxes) {
                if (box.isSelected()) {
                    selectedConditions.add(box.getText());
                }
            }
        }
        return selectedConditions;
    }

    /**
     * Test Delivery Record GUI
     */
    private void testDeliveryRecord() {
        new DeliveryRecordGUI(this);
    }

    /**
     * Adds medical history to a patient.
     */
    private void addMedicalHistory() {
        String patientID = JOptionPane.showInputDialog(null, "Enter Patient ID:");
        if (patientID == null || patientID.isEmpty()) {
            appendOutput("Cancelled medical history addition.");
            return;
        }

        Patient patient = UseCase3.patientMap.get(patientID);
        if (patient == null) {
            appendOutput("No patient found with ID: " + patientID);
            return;
        }

        String conditions = JOptionPane.showInputDialog(null, "Enter Medical Conditions (comma-separated):");
        if (conditions != null && !conditions.trim().isEmpty()) {
            if (patient.records == null) {
                patient.records = new ArrayList<>();
            }
            String[] conditionList = conditions.split(",");
            for (String condition : conditionList) {
                patient.records.add(condition.trim());
            }
            appendOutput("Added medical history to patient " + patient.getName() + ": " + conditions);
        } else {
            appendOutput("No conditions entered.");
        }
    }

    /**
     * Displays all patients in the system.
     */
    private void viewAllPatients() {
        if (UseCase3.patientMap.isEmpty()) {
            appendOutput("No patients found.");
            return;
        }
        appendOutput("=== List of All Patients ===");
        for (Patient p : UseCase3.patientMap.values()) {
            appendOutput("Name: " + p.getName() + " | ID: " + p.patientID);
        }
        appendOutput("============================");
    }

    /**
     * Displays the medical history of a specific patient.
     */
    private void viewPatientMedicalHistory() {
        String patientID = JOptionPane.showInputDialog(null, "Enter Patient ID to View Medical History:");
        if (patientID == null || patientID.isEmpty()) {
            appendOutput("Cancelled medical history view.");
            return;
        }
    
        Patient patient = UseCase3.patientMap.get(patientID);
        if (patient == null) {
            appendOutput("No patient found with ID: " + patientID);
            return;
        }
    
        appendOutput("=== Medical History for " + patient.getName() + " ===");
        if (patient.records == null || patient.records.isEmpty()) {
            appendOutput("No medical history available.");
        } else {
            for (int i = 0; i < patient.records.size(); i++) {
                appendOutput((i + 1) + ". " + patient.records.get(i));
            }
        }
        appendOutput("============================");
    }
    

    /**
     * Main method to run the GUI application.
     * 
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(UseCaseDemoGUI::new);
    }
}
