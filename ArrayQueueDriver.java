// ArrayQueueDriver.java
// Starter file for the Queue portion of the Data Structures assignment.
// DO NOT change the class name or the signature of main().
// Implement ONLY the method for your assigned task (e.g., runQ2_CallCenterQueue).

public class ArrayQueueDriver {

    public static void main(String[] args) {
        // TODO: Uncomment EXACTLY ONE of the following lines,
        // then implement that method below.

        //runQ1_PrintQueue();
        //runQ2_CallCenterQueue();
        //runQ3_ThemeParkRideLine();
        //runQ4_CustomerServiceTickets();
        //runQ5_TaskSchedulingQueue();
        //runQ6_CheckoutLine();
        //runQ7_MessageQueueChatApp();
        //runQ8_PrintSpoolingBurst();
        runQ9_RoundRobinService();
    }

    // Q1 – Print Queue
    private static void runQ1_PrintQueue() {
        // TODO: Implement task Q1 here.
        //Queue
        ArrayQueue<String> printQueue = new ArrayQueue<>();
        //Send docs
        String[] documents = { "Doc1", "Doc2", "Doc3", "Doc4", "Doc5" };
        for (String doc : documents) {
            printQueue.offer(doc);
            System.out.println(doc + " Added to queue");
        }
        System.out.println("Printing Docs: ");
        while (!printQueue.isEmpty()) {
            String printedDoc = printQueue.poll();
            System.out.println(printedDoc + " Printed");
        }
    }

    // Q2 – Call Center Queue
    private static void runQ2_CallCenterQueue() {
        // TODO: Implement task Q2 here.
        //Queue
        ArrayQueue<String> callQueue = new ArrayQueue<>();
        //Add calls
        String[] callers = { "Bob", "John", "Joe", "Carl"};
        for (String caller : callers) {
            callQueue.offer(caller);
            System.out.println(caller + " Added to queue");
        }
        System.out.println("Answering Calls: ");
        while (!callQueue.isEmpty()) {
            System.out.println(callQueue.poll());
        }
    }

    // Q3 – Theme Park Ride Line
    private static void runQ3_ThemeParkRideLine() {
        // TODO: Implement task Q3 here.
        //Queue
        ArrayQueue<String> line = new ArrayQueue<>();
        //Add riders
        String[] riders = { "Bob", "John", "Joe", "Carl"};
        for (String rider : riders) {
            line.offer(rider);
            System.out.println(rider + " got in line");
        }
        System.out.println("Getting on ride: ");
        while (line.size() > 0) {
            String rider = line.poll();
            System.out.println(rider + " got on ride");
        }
    }

    // Q4 – Customer Service Tickets
    private static void runQ4_CustomerServiceTickets() {
        // TODO: Implement task Q4 here.
        //Queue
        ArrayQueue<String> ticket = new ArrayQueue<>();
        //Add ticket numbers
        String [] tickets = { "Ticket001", "Ticket002", "Ticket003", "Ticket004", "Ticket005" };
        for (String ticketId : tickets) {
            ticket.offer(ticketId);
            System.out.println(ticketId + " added to queue");
        }
        System.out.println("Being assisted: ");
        while (ticket.size() > 0) {
            String ticketId = ticket.poll();
            System.out.println(ticketId + " Assisted");
        }
    }

    // Q5 – Task Scheduling Queue
    private static void runQ5_TaskSchedulingQueue() {
        // TODO: Implement task Q5 here.
        //Queue
        ArrayQueue<String> taskQueue = new ArrayQueue<>();
        //Add tasks
        String [] tasks = { "Load File", "Compile Program", "Run Program"};
        for (String task : tasks) {
            taskQueue.offer(task);
            System.out.println(task + " added to queue");
        }
        System.out.println("\nDoing task: ");
        while (taskQueue.size() > 0) {
            String task = taskQueue.poll();
            System.out.println(task + " Task completed");
        }
    }

    // Q6 – Checkout Line at a Store
    private static void runQ6_CheckoutLine() {
        // TODO: Implement task Q6 here.
        //Queue
        ArrayQueue<String> checkoutQueue = new ArrayQueue<>();
        //Add customers
        String[] customers = { "Bob", "John", "Joe", "Carl"};
        for (String customer : customers) {
            checkoutQueue.offer(customer);
            System.out.println(customer + " got in line to checkout");
        }
        System.out.println("\nChecking out: ");
        while (checkoutQueue.size() > 0) {
            String customer = checkoutQueue.poll();
            System.out.println(customer + " Checked out");
        }
    }

    // Q7 – Message Queue in a Chat App
    private static void runQ7_MessageQueueChatApp() {
        // TODO: Implement task Q7 here.
        //Queue
        ArrayQueue<String> messageQueue = new ArrayQueue<>();
        //Add messages
        String [] messages = { "(Hey!)", "(How's it going?)", "(Do you have a chance to chat?)"};
        for (String message : messages) {
            messageQueue.offer(message);
            System.out.println(message + " sent");
        }
        System.out.println("\nBeing Delivered: ");
        while (messageQueue.size() > 0) {
            String message = messageQueue.poll();
            System.out.println(message + " delivered");
        }
    }

    // Q8 – Print Spooling with Burst of Jobs
    private static void runQ8_PrintSpoolingBurst() {
        // TODO: Implement task Q8 here.
        //Queue
        ArrayQueue<String> spoolingQueue = new ArrayQueue<>();
        //Add jobs
        String [] jobs = { "job1", "job2", "job3", "job4", "job5" };
        for (String job : jobs) {
            spoolingQueue.offer(job);
            System.out.println(job + " added to queue");
        }
        System.out.println("\nPrinting Jobs: ");
        while (spoolingQueue.size() > 0) {
            String job = spoolingQueue.poll();
            System.out.println(job + " printed");
        }
    }

    // Q9 – Round-Robin Service (Single Queue Version)
    private static void runQ9_RoundRobinService() {
        // TODO: Implement task Q9 here.
        //Queue
        ArrayQueue<String> serviceQueue = new ArrayQueue<>();
        //Add people
        String [] people = {"Bob", "John", "Joe", "Carl"};
        for (String p : people) {
            serviceQueue.offer(p);
            System.out.println(p + " added to queue");
        }
        int rounds = 2;
        System.out.println("\nServing:");
        for (int i = 0; i < rounds; i++) {
            int currentQueueSize = serviceQueue.size();
            for (int j = 0; j < currentQueueSize; j++) {
                String p = serviceQueue.poll();
                System.out.println(p + " served in round " + (i + 1) );
                serviceQueue.offer(p);
            }
        }
    }
}
