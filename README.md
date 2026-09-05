
 # Mini Hospital Emergency System

 A console-based Java application for managing hospital patients, emergency
 queues, treatment records, and patient visit histories.

 ## Features

 - Add, search, delete, and list patients by ID.
 - Store patients in a binary search tree (BST).
 - Add patients to and process patients from a FIFO emergency queue.
 - Record and complete treatments using a LIFO stack.
 - Add, remove, search, and display visits using a singly linked list.
 - Automatically record the date for new visits and treatments.

 ## Requirements

 - Java Development Kit (JDK) 9 or later, because the project uses Java modules.

 ## Compile and Run

 From the project root, run:

 ```text
 javac -d bin src/module-info.java src/hospital/*.java
 java --module-path bin --module MiniHospitalProject/hospital.Main
 ```

 ## Main Menu

1. Patient Records (Binary Search Tree - BST)
2. Emergency Patient Queue (FIFO)
3. Treatment History (Stack - LIFO)
4. Patient Visit History (Singly Linked List)
5. Exit

 Select a menu number and follow the prompts. Patients must be added to the
 patient records before they can be placed in the emergency queue or assigned
 treatment and visit records.

 ## Project Structure

 ```text
 src/
	 module-info.java
	 hospital/
		 Main.java              Console menus and application entry point
		 Patient.java           Patient data and BST links
		 PatientBST.java        Patient record search tree
		 EmergencyQueue.java    FIFO emergency queue
		 TreatmentRecord.java   Treatment details
		 TreatmentStack.java    LIFO treatment history
		 Visit.java             Visit data
		 VisitLinkedList.java   Patient visit history
 ```

 Data is kept in memory while the application is running; closing the program
 clears the current records.

