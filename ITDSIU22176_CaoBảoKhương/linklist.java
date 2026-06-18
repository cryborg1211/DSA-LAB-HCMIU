class Link {
    public int id;
    public double dd;
    public Link next;

    public Link(int id, double dd) {
        this.id = id;
        this.dd = dd;
    }
}

public class linklist {
    private Link first;

    public linklist() {
        first = null;
    }

    public void insertFirst(int id, double dd) {
        Link newLink = new Link(id, dd);
        newLink.next = first;
        first = newLink;
    }

    // The function for inserting a new link at any position in the linked list.
    public void insertAt(int index, int id, double dd) {
        if (index <= 0) {
            insertFirst(id, dd);
            return;
        }

        Link newLink = new Link(id, dd);
        Link current = first;
        int count = 0;

        while (current != null && count < index - 1) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Index out of bounds!");
            return;
        }

        newLink.next = current.next;
        current.next = newLink;
    }
}