package hospital;

public class PatientBST {
    private Patient root;

    public PatientBST() {
        root = null;
    }

    public void insert(Patient p) {
        root = insertRec(root, p);
    }

    private Patient insertRec(Patient node, Patient p) {
        if (node == null) return p;
        if (p.id < node.id) node.left = insertRec(node.left, p);
        else if (p.id > node.id) node.right = insertRec(node.right, p);
        else {
            // duplicate ID - you could update record or ignore; here we update
            node.name = p.name;
            node.age = p.age;
            node.contact = p.contact;
            node.condition = p.condition;
        }
        return node;
    }

    public Patient search(int id) {
        return searchRec(root, id);
    }

    private Patient searchRec(Patient node, int id) {
        if (node == null) return null;
        if (id == node.id) return node;
        if (id < node.id) return searchRec(node.left, id);
        else return searchRec(node.right, id);
    }

    public void delete(int id) {
        root = deleteRec(root, id);
    }

    private Patient deleteRec(Patient node, int id) {
        if (node == null) return null;
        if (id < node.id) node.left = deleteRec(node.left, id);
        else if (id > node.id) node.right = deleteRec(node.right, id);
        else {

            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Patient succ = minValue(node.right);
            node.id = succ.id;
            node.name = succ.name;
            node.age = succ.age;
            node.contact = succ.contact;
            node.condition = succ.condition;
            node.visits = succ.visits;
            node.right = deleteRec(node.right, succ.id);
        }
        return node;
    }

    private Patient minValue(Patient node) {
        Patient current = node;
        while (current.left != null) current = current.left;
        return current;
    }

    // In-order traversal
    public void displayInOrder() {
        if (root == null) {
            System.out.println("No patients in records.");
            return;
        }
        System.out.println("Patients (in-order by ID):");
        inOrderRec(root);
    }

    private void inOrderRec(Patient node) {
        if (node != null) {
            inOrderRec(node.left);
            node.display();
            System.out.println("-------------------------");
            inOrderRec(node.right);
        }
    }
}