package hospital;

public class TreatmentStack {

    private static class Node {

        TreatmentRecord record;
        Node next;

        Node(TreatmentRecord r) {
            this.record = r;
            this.next = null;
        }
    }

    private Node top;

    public TreatmentStack() {
        top = null;
    }

    public void push(TreatmentRecord r) {
        Node n = new Node(r);
        n.next = top;
        top = n;
    }

    public TreatmentRecord pop() {
        if (top == null) {
            return null;
        }

        TreatmentRecord r = top.record;
        top = top.next;

        return r;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void displayStack() {

        if (isEmpty()) {
            System.out.println("No completed treatments.");
            return;
        }

        System.out.println("Completed Treatments (most recent first):");

        Node cur = top;

        while (cur != null) {
            cur.record.display();
            System.out.println("-------------------------");
            cur = cur.next;
        }
    }
}