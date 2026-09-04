package hospital;

public class EmergencyQueue {
    private static class Node {
        Patient patient;
        Node next;
        Node(Patient p) { this.patient = p; this.next = null; }
    }

    private Node front;
    private Node rear;

    public EmergencyQueue() {
        front = rear = null;
    }

    public void enqueue(Patient p) {
        Node node = new Node(p);
        if (rear == null) {
            front = rear = node;
            return;
        }
        rear.next = node;
        rear = node;
    }

    public Patient dequeue() {
        if (front == null) return null;
        Patient p = front.patient;
        front = front.next;
        if (front == null) rear = null;
        return p;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Emergency queue is empty.");
            return;
        }
        System.out.println("Emergency Queue (front -> rear):");
        Node cur = front;
        while (cur != null) {
            System.out.println("  ID:" + cur.patient.id + " Name:" + cur.patient.name + " Condition:" + cur.patient.condition);
            cur = cur.next;
        }
    }
}