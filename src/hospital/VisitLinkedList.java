package hospital;

public class VisitLinkedList {
    private Visit head;

    public VisitLinkedList() {
        head = null;
    }

    // Add new visit at the front (most recent first)
    public void addVisit(int visitId, String date, String doctor, String diagnosis, String treatment) {
        Visit v = new Visit(visitId, date, doctor, diagnosis, treatment);
        v.next = head;
        head = v;
    }

    // Remove visit by visitId
    public boolean removeVisit(int visitId) {
        if (head == null) return false;
        if (head.visitId == visitId) {
            head = head.next;
            return true;
        }
        Visit prev = head;
        Visit cur = head.next;
        while (cur != null) {
            if (cur.visitId == visitId) {
                prev.next = cur.next;
                return true;
            }
            prev = cur;
            cur = cur.next;
        }
        return false;
    }

    // Find visit by id
    public Visit findVisit(int visitId) {
        Visit cur = head;
        while (cur != null) {
            if (cur.visitId == visitId) return cur;
            cur = cur.next;
        }
        return null;
    }

    // Display all visits
    public void displayVisits() {
        if (head == null) {
            System.out.println("  No visits recorded.");
            return;
        }
        Visit cur = head;
        while (cur != null) {
            cur.display();
            System.out.println("  --------------------");
            cur = cur.next;
        }
    }
}