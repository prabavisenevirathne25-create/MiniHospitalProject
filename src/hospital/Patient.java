package hospital;

public class Patient {

    public int id;
    public String name;
    public int age;
    public String contact;
    public String condition;

    // BST links
    public Patient left;
    public Patient right;

    // Patient visit history
    public VisitLinkedList visits;

    public Patient(int id, String name, int age,
                   String contact, String condition) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.condition = condition;

        this.left = null;
        this.right = null;

        this.visits = new VisitLinkedList();
    }

    public void display() {

        System.out.println("Patient ID : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Contact    : " + contact);
        System.out.println("Condition  : " + condition);
    }
}