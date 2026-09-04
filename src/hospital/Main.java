package hospital;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    private static PatientBST bst = new PatientBST();

    private static EmergencyQueue eq = new EmergencyQueue();

    private static TreatmentStack ts = new TreatmentStack();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean running = true;

        System.out.println("======================================================");

        System.out.println("          MINI HOSPITAL EMERGENCY SYSTEM");

        System.out.println("======================================================");

        while (running) {

            printMainMenu();

            String choice = scanner.nextLine().trim();

            switch (choice) {

                case "1":

                    patientManagementMenu();

                    break;

                case "2":

                    visitManagementMenu();

                    break;

                case "3":

                    emergencyManagementMenu();

                    break;

                case "4":

                    treatmentManagementMenu();

                    break;

                case "0":

                    running = false;

                    System.out.println("\nThank you for using the system.");

                    break;

                default:

                    System.out.println("\nInvalid choice. Please try again.");

            }

        }

        scanner.close();

    }



    // MAIN MENU



    private static void printMainMenu() {

        System.out.println("\n======================================================");

        System.out.println("                     MAIN MENU");

        System.out.println("======================================================");

        System.out.println("1. Patient Records (Binary Search Tree - BST)");

        System.out.println("2. Emergency Patient Queue (FIFO)");

        System.out.println("3. Treatment History (Stack - LIFO)");

        System.out.println("4. Patient Visit History (Singly Linked List)");

        System.out.println("5. Exit");

        System.out.println("======================================================");

        System.out.print("Enter choice: ");

    }



    // 1. PATIENT MANAGEMENT



    private static void patientManagementMenu() {

        boolean back = false;

        while (!back) {

            System.out.println("======================================================");

            System.out.println("                 PATIENT MANAGEMENT");

            System.out.println("======================================================");

            System.out.println("1. Insert New Patient");

            System.out.println("2. Search Patient by ID");

            System.out.println("3. Delete Patient by ID");

            System.out.println("4. Display All Patients");

            System.out.println("5. Back to Main Menu");

            System.out.println("======================================================");

            System.out.print("Enter choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {

                case "1":

                    addPatient();

                    break;

                case "2":

                    searchPatient();

                    break;

                case "3":

                    deletePatient();

                    break;

                case "4":

                    displayAllPatients();

                    break;

                case "5":

                    back = true;

                    break;

                default:

                    System.out.println("Invalid choice. Please try again.");

            }

        }

    }



    // ADD PATIENT



    private static void addPatient() {

        try {

            System.out.println("\n========== ADD PATIENT ==========");

            System.out.print("Enter Patient ID: ");

            int id = Integer.parseInt(scanner.nextLine().trim());

            if (bst.search(id) != null) {

                System.out.println("Patient with ID " + id + " already exists.");

                return;

            }

            System.out.print("Enter Patient Name: ");

            String name = scanner.nextLine().trim();

            System.out.print("Enter Age: ");

            int age = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Enter Contact Number: ");

            String contact = scanner.nextLine().trim();

            System.out.print("Enter Medical Condition: ");

            String condition = scanner.nextLine().trim();

            Patient patient = new Patient(

                    id,

                    name,

                    age,

                    contact,

                    condition

            );

            bst.insert(patient);

            System.out.println("\nPatient added successfully.");

        } catch (NumberFormatException e) {

            System.out.println("Invalid number input.");

        }

    }



    // SEARCH PATIENT

    private static void searchPatient() {

        try {

            System.out.println("========== SEARCH PATIENT ==========");

            System.out.print("Enter Patient ID: ");

            int id = Integer.parseInt(scanner.nextLine().trim());

            Patient patient = bst.search(id);

            if (patient == null) {

                System.out.println("Patient not found.");

            } else {

                System.out.println("Patient found:");

                System.out.println("--------------------------------------");

                patient.display();

                System.out.println("--------------------------------------");

            }

        } catch (NumberFormatException e) {

            System.out.println("Invalid Patient ID.");

        }

    }



    // DELETE PATIENT

    private static void deletePatient() {

        try {

            System.out.println("========== DELETE PATIENT ==========");

            System.out.print("Enter Patient ID: ");

            int id = Integer.parseInt(scanner.nextLine().trim());

            Patient patient = bst.search(id);

            if (patient == null) {

                System.out.println("Patient not found.");

            } else {

                bst.delete(id);

                System.out.println(

                        "Patient with ID " + id +

                        " deleted successfully."

                );

            }

        } catch (NumberFormatException e) {

            System.out.println("Invalid Patient ID.");

        }

    }



    // DISPLAY ALL PATIENTS



    private static void displayAllPatients() {

        System.out.println("========== ALL PATIENTS ==========");

        bst.displayInOrder();

    }



    // 2. EMERGENCY MANAGEMENT



    private static void emergencyManagementMenu() {

        boolean back = false;

        while (!back) {

            System.out.println("======================================================");

            System.out.println("                 EMERGENCY MANAGEMENT");

            System.out.println("======================================================");

            System.out.println("1. Add Patient to Emergency Queue");

            System.out.println("2. Process Next Emergency Patient");

            System.out.println("3. Display Waiting Patients");

            System.out.println("4. Back to Main Menu");

            System.out.println("======================================================");

            System.out.print("Enter choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {

                case "1":

                    enqueuePatient();

                    break;

                case "2":

                    dequeuePatient();

                    break;

                case "3":

                    eq.displayQueue();

                    break;

                case "5":

                    back = true;

                    break;

                default:

                    System.out.println("Invalid choice. Please try again.");

            }

        }

    }



    // ENQUEUE PATIENT



    private static void enqueuePatient() {

        try {

            System.out.println("========== EMERGENCY QUEUE ==========");

            System.out.print("Enter Patient ID: ");

            int id = Integer.parseInt(scanner.nextLine().trim());

            Patient patient = bst.search(id);

            if (patient == null) {

                System.out.println(

                        "Patient not found. Please add the patient first."

                );

                return;

            }

            eq.enqueue(patient);

            System.out.println(

                    "Patient " + patient.name +

                    " added to emergency queue."

            );

        } catch (NumberFormatException e) {

            System.out.println("Invalid Patient ID.");

        }

    }



    // PROCESS NEXT EMERGENCY PATIENT



    private static void dequeuePatient() {

        Patient patient = eq.dequeue();

        if (patient == null) {

            System.out.println("Emergency queue is empty.");

            return;

        }

        System.out.println(

                "========== PROCESS EMERGENCY PATIENT =========="

        );

        patient.display();

        System.out.print("Record treatment now? (y/n): ");

        String answer =

                scanner.nextLine().trim().toLowerCase();

        if (answer.equals("y")) {

            addEmergencyTreatment(patient);

        }

    }



    // ADD EMERGENCY TREATMENT



    private static void addEmergencyTreatment(Patient patient) {

        System.out.print("Enter Treatment Type: ");

        String treatmentType = scanner.nextLine().trim();

        System.out.print("Enter Doctor Name: ");

        String doctorName = scanner.nextLine().trim();

        System.out.print("Enter Outcome: ");

        String outcome = scanner.nextLine().trim();

        String date = LocalDateTime.now().toString();



        TreatmentRecord record = new TreatmentRecord(

                patient.id,

                patient.id,

                date,

                doctorName,

                treatmentType + " - " + outcome

        );

        ts.push(record);

        int nextVisitId = getNextVisitId(patient);

        patient.visits.addVisit(

                nextVisitId,

                LocalDate.now().toString(),

                doctorName,

                patient.condition,

                treatmentType

        );

        System.out.println("Treatment record added.");

        System.out.println("Visit history updated.");

    }



    // GET NEXT VISIT ID



    private static int getNextVisitId(Patient patient) {

        int id = 1;

        while (patient.visits.findVisit(id) != null) {

            id++;

        }

        return id;

    }



    // 3. TREATMENT MANAGEMENT



    private static void treatmentManagementMenu() {

        boolean back = false;

        while (!back) {

            System.out.println("======================================================");

            System.out.println("                  TREATMENT MANAGEMENT");

            System.out.println("======================================================");

            System.out.println("1. Add Treatment Record");

            System.out.println("2. Complete Latest Treatment");

            System.out.println("3. Display Treatment History");

            System.out.println("4. Back to Main Menu");

            System.out.println("======================================================");

            System.out.print("Enter choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {

                case "1":

                    addTreatment();

                    break;

                case "2":

                    completeTreatment();

                    break;

                case "3":

                    ts.displayStack();

                    break;

                case "4":

                    back = true;

                    break;

                default:

                    System.out.println("Invalid choice. Please try again.");

            }

        }

    }



    // ADD TREATMENT



    private static void addTreatment() {

        try {

            System.out.println("========== ADD TREATMENT ==========");

            System.out.print("Enter Patient ID: ");

            int id = Integer.parseInt(scanner.nextLine().trim());

            Patient patient = bst.search(id);

            if (patient == null) {

                System.out.println("Patient not found.");

                return;

            }

            System.out.print("Enter Treatment Type: ");

            String treatmentType = scanner.nextLine().trim();

            System.out.print("Enter Doctor Name: ");

            String doctorName = scanner.nextLine().trim();

            System.out.print("Enter Outcome: ");

            String outcome = scanner.nextLine().trim();

            String date = LocalDateTime.now().toString();

            TreatmentRecord record = new TreatmentRecord(

                    patient.id,

                    patient.id,

                    date,

                    doctorName,

                    treatmentType + " - " + outcome

            );

            ts.push(record);

            System.out.println(

                    "Treatment record added successfully."

            );

        } catch (NumberFormatException e) {

            System.out.println("Invalid Patient ID.");

        }

    }



    // COMPLETE TREATMENT



    private static void completeTreatment() {

        if (ts.isEmpty()) {

            System.out.println("No treatment records available.");

            return;

        }

        TreatmentRecord record = ts.pop();

        System.out.println(

                "\n========== COMPLETED TREATMENT =========="

        );

        if (record != null) {

            record.display();

        }

    }



    // 4. VISIT MANAGEMENT



    private static void visitManagementMenu() {

        boolean back = false;

        while (!back) {

            System.out.println("======================================================");

            System.out.println("                  VISIT MANAGEMENT");

            System.out.println("======================================================");

            System.out.println("1. Add Visit");

            System.out.println("2. Remove Visit");

            System.out.println("3. Search Visit");

            System.out.println("4. Display Visit History");

            System.out.println("5. Back to Main Menu");

            System.out.println("======================================================");

            System.out.print("Enter choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {

                case "1":

                    addVisit();

                    break;

                case "2":

                    removeVisit();

                    break;

                case "3":

                    searchVisit();

                    break;

                case "4":

                    displayVisitHistory();

                    break;

                case "5":

                    back = true;

                    break;

                default:

                    System.out.println("Invalid choice. Please try again.");

            }

        }

    }



    // ADD VISIT

    private static void addVisit() {

        try {

            System.out.println("\n========== ADD PATIENT VISIT ==========");

            System.out.print("Enter Patient ID: ");

            int patientId = Integer.parseInt(scanner.nextLine().trim());

            Patient patient = bst.search(patientId);

            if (patient == null) {

                System.out.println("Patient not found.");

                return;

            }

            System.out.print("Enter Visit ID: ");

            int visitId = Integer.parseInt(scanner.nextLine().trim());

            if (patient.visits.findVisit(visitId) != null) {

                System.out.println(

                        "Visit ID already exists for this patient."

                );

                return;

            }

            System.out.print("Enter Doctor Name: ");

            String doctor = scanner.nextLine().trim();

            System.out.print("Enter Diagnosis: ");

            String diagnosis = scanner.nextLine().trim();

            System.out.print("Enter Treatment: ");

            String treatment = scanner.nextLine().trim();

            String date = LocalDate.now().toString();

            patient.visits.addVisit(

                    visitId,

                    date,

                    doctor,

                    diagnosis,

                    treatment

            );

            System.out.println("\nVisit added successfully.");

            System.out.println("Visit Date: " + date);

        } catch (NumberFormatException e) {

            System.out.println("Invalid number input.");

        }

    }



    // REMOVE VISIT



    private static void removeVisit() {

        try {

            System.out.println("========== REMOVE VISIT ==========");

            System.out.print("Enter Patient ID: ");

            int patientId = Integer.parseInt(scanner.nextLine().trim());

            Patient patient = bst.search(patientId);

            if (patient == null) {

                System.out.println("Patient not found.");

                return;

            }

            System.out.print("Enter Visit ID: ");

            int visitId = Integer.parseInt(scanner.nextLine().trim());

            boolean removed =

                    patient.visits.removeVisit(visitId);

            if (removed) {

                System.out.println("Visit removed successfully.");

            } else {

                System.out.println("Visit not found.");

            }

        } catch (NumberFormatException e) {

            System.out.println("Invalid number input.");

        }

    }



    // SEARCH VISIT



    private static void searchVisit() {

        try {

            System.out.println("========== SEARCH VISIT ==========");

            System.out.print("Enter Patient ID: ");

            int patientId = Integer.parseInt(scanner.nextLine().trim());

            Patient patient = bst.search(patientId);

            if (patient == null) {

                System.out.println("Patient not found.");

                return;

            }

            System.out.print("Enter Visit ID: ");

            int visitId = Integer.parseInt(scanner.nextLine().trim());

            Visit visit =

                    patient.visits.findVisit(visitId);

            if (visit == null) {

                System.out.println("Visit not found.");

            } else {

                System.out.println("Visit found:");

                System.out.println("--------------------------------------");

                visit.display();

                System.out.println("--------------------------------------");

            }

        } catch (NumberFormatException e) {

            System.out.println("Invalid number input.");

        }

    }



    // DISPLAY VISIT HISTORY



    private static void displayVisitHistory() {

        try {

            System.out.println("========== VISIT HISTORY ==========");

            System.out.print("Enter Patient ID: ");

            int patientId = Integer.parseInt(scanner.nextLine().trim());

            Patient patient = bst.search(patientId);

            if (patient == null) {

                System.out.println("Patient not found.");

                return;

            }

            System.out.println("Patient: " + patient.name);

            System.out.println("Patient ID: " + patient.id);

            System.out.println("--------------------------------------");

            patient.visits.displayVisits();

        } catch (NumberFormatException e) {

            System.out.println("Invalid Patient ID.");

        }

    }

}
