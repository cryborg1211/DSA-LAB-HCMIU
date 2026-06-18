package Exercises;

public class Exercise1 {
    static class Ticket {
        int priority;
        String createdAt;
        String id;
        
        public Ticket(int priority, String createdAt, String id) {
            this.priority = priority;
            this.createdAt = createdAt;
            this.id = id;
        }
        
        @Override
        public String toString() {
            return "(" + priority + "," + createdAt + "," + id + ")";
        }
    }
    
    // Stable MergeSort specifically for Tickets
    public static void mergeSortTickets(Ticket[] arr) {
        if(arr.length <= 1) return;
        Ticket[] temp = new Ticket[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }
    
    private static void mergeSort(Ticket[] arr, Ticket[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, temp, left, mid);
            mergeSort(arr, temp, mid + 1, right);
            merge(arr, temp, left, mid, right);
        }
    }
    
    private static void merge(Ticket[] arr, Ticket[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }
        
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (compare(temp[i], temp[j]) <= 0) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }
        while (i <= mid) {
            arr[k++] = temp[i++];
        }
    }
    
    private static int compare(Ticket t1, Ticket t2) {
        if (t1.priority != t2.priority) {
            return Integer.compare(t1.priority, t2.priority);
        } else {
            return t1.createdAt.compareTo(t2.createdAt); // Stable tie-breaker
        }
    }

    public static void main(String[] args) {
        Ticket[] tickets = {
            new Ticket(2, "10:02", "A"),
            new Ticket(1, "10:05", "B"),
            new Ticket(2, "10:01", "C")
        };
        
        System.out.println("Original:");
        for(int i = 0; i < tickets.length; i++) {
            System.out.print(tickets[i] + (i < tickets.length - 1 ? "," : ""));
        }
        System.out.println();
        
        mergeSortTickets(tickets);
        
        System.out.println("Sorted:");
        for(int i = 0; i < tickets.length; i++) {
            System.out.print(tickets[i] + (i < tickets.length - 1 ? "," : ""));
        }
        System.out.println();
    }
}
