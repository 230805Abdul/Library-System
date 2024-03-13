import java.util.ArrayList;

class Patient {
    private String name;
    private int id;
    private int age;
    private String medicalCondition;

    // Constructor
    public Patient(String name, int id, int age, String medicalCondition) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.medicalCondition = medicalCondition;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMedicalCondition() {
        return medicalCondition;
    }

    public void setMedicalCondition(String medicalCondition) {
        this.medicalCondition = medicalCondition;
    }

    // Method to display patient information
    public void displayPatientInfo() {
        System.out.println("Patient Name: " + name);
        System.out.println("Patient ID: " + id);
        System.out.println("Age: " + age);
        System.out.println("Medical Condition: " + medicalCondition);
    }
}

public class HospitalManager {
    private ArrayList<Patient> patientDatabase;

    public HospitalManager() {
        patientDatabase = new ArrayList<>();
    }

    // Method to add new patient
    public void addPatient(Patient patient) {
        patientDatabase.add(patient);
    }

    // Method to update medical condition
    public void updateMedicalCondition(int patientId, String newMedicalCondition) {
        for (Patient patient : patientDatabase) {
            if (patient.getId() == patientId) {
                patient.setMedicalCondition(newMedicalCondition);
                break;
            }
        }
    }

    // Method to search for patient by ID
    public Patient searchPatientById(int patientId) {
        for (Patient patient : patientDatabase) {
            if (patient.getId() == patientId) {
                return patient;
            }
        }
        return null; // Patient not found
    }

    // Method to display all patients' information
    public void displayAllPatients() {
        for (Patient patient : patientDatabase) {
            patient.displayPatientInfo();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        HospitalManager hospital = new HospitalManager();

        // Create patient objects and add them to the hospital database
        hospital.addPatient(new Patient("John Doe", 1001, 30, "Fever"));
        hospital.addPatient(new Patient("Jane Smith", 1002, 45, "Diabetes"));
        hospital.addPatient(new Patient("Michael Johnson", 1003, 55, "Heart Disease"));

        // Update medical condition of a patient
        hospital.updateMedicalCondition(1001, "Flu");

        // Search for a patient by ID and display patient details
        int searchId = 1002;
        Patient foundPatient = hospital.searchPatientById(searchId);
        if (foundPatient != null) {
            System.out.println("Patient Found:");
            foundPatient.displayPatientInfo();
        } else {
            System.out.println("Patient with ID " + searchId + " not found.");
        }

        // Display all patients' information
        System.out.println("\nAll Patients:");
        hospital.displayAllPatients();
    }
}
