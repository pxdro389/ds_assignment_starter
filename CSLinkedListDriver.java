// CSLinkedListDriver.java
// Starter file for the Linked List portion of the Data Structures assignment.
// DO NOT change the class name or the signature of main().
// Implement ONLY the method for your assigned task (e.g., runLL3_CourseWai

import java.util.Comparator;

public class CSLinkedListDriver {

    public static void main(String[] args) {
        // TODO: Uncomment EXACTLY ONE of the following lines,
        // then implement that method below.

        //runLL1_Playlist();
        //runLL2_TodoList();
        //runLL3_CourseWaitlist();
        //runLL4_TextEditorLines();
        //runLL5_RecentlyContacted();
        //runLL6_ShoppingListAddAfter();
        //runLL7_BusRouteStops();
        //runLL8_EventScheduleSorted();
        //runLL9_BugTrackerRemoveById();
        //runLL10_PlaylistShuffleCopy();
    }

    // LL1 – Music Playlist Manager
    private static void runLL1_Playlist() {
        // TODO: Implement task LL1 here.
        // See the assignment handout for the scenario description.
        //LinkedList
        CSLinkedList<String> playlist = new CSLinkedList<>();
        //Add songs
        playlist.add("Song a");
        playlist.add("Song b");
        playlist.add("Song c");
        System.out.println(playlist);
        //Insert song at index 0
        playlist.add(0 , "New Song");
        System.out.println("After Adding New Song: " + playlist);
        //Remove song from middle(index 2)
        playlist.remove(2);
        System.out.println("After Removing Middle Song: " + playlist);
    }

    // LL2 – To-Do List with Priorities
    private static void runLL2_TodoList() {
        // TODO: Implement task LL2 here.
        //LinkedList
        CSLinkedList<String> todo = new CSLinkedList<>();
        //Add tasks
        todo.add("Wash car");
        todo.add("Walk dog");
        todo.add("Clean room");
        System.out.println(todo);
        //Add urgent tasks
        todo.add(0 , "Study");
        todo.add(0 , "Finish homework");
        System.out.println("After adding urgent tasks: " + todo);
        //Remove completed tasks
        todo.remove(2);
        System.out.println("After completing 1 task: " + todo);
    }

    // LL3 – Course Waitlist (No Duplicates)
    private static void runLL3_CourseWaitlist() {
        // TODO: Implement task LL3 here.
        // You may add a helper method addIfAbsent(E item) to CSLinkedList if needed.
        //LinkedList
        CSLinkedList<String> waitlist = new CSLinkedList<>();
        //Add to waitlist
        waitlist.addIfAbsent("Bob");
        waitlist.addIfAbsent("John");
        waitlist.addIfAbsent("Joe");
        waitlist.addIfAbsent("Carl");
        waitlist.addIfAbsent("John");//Duplicate
        //Print waitlist
        System.out.println(waitlist);
    }

    // LL4 – Text Editor Line Manager
    private static void runLL4_TextEditorLines() {
        // TODO: Implement task LL4 here.
        //LinkedList
        CSLinkedList<String> lines = new CSLinkedList<>();
        lines.add("1: public class CSLinkedListDriver {");
        lines.add("2:     public static void main(String[] args) {");
        lines.add("3:        System.out.println(Comp 282)");
        lines.add("4:     }");
        lines.add("5: }");
        //Print OG lines
        printLines(lines);
        //Add new line
        lines.add(2 , "          CS282");
        printLines(lines);
        //Remove line
        lines.remove(3);
        //Print final output
        printLines(lines);
    }
    private static void printLines(CSLinkedList<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            System.out.println((i + 1) + ": " + lines.get(i));
        }
    }

    // LL5 – Recently Contacted Friends (Move to Front)
    private static void runLL5_RecentlyContacted() {
        // TODO: Implement task LL5 here.
        // You may add a helper method moveToFront(E item) to CSLinkedList if needed.
        //LinkedList
        CSLinkedList<String> contacts = new CSLinkedList<>();
        contacts.add("Bob");
        contacts.add("John");
        contacts.add("Joe");
        contacts.add("Carl");
        //Print initial contact list
        System.out.println("Initial List: " + contacts);
        //Action: contact friend(moves to top)
        contacts.moveToFront("Carl");
        System.out.println("After contacting Carl: " + contacts);
        contacts.moveToFront("Joe");
        System.out.println("After contacting Joe: " + contacts);
    }

    // LL6 – Shopping List: Insert After Item
    private static void runLL6_ShoppingListAddAfter() {
        // TODO: Implement task LL6 here.
        // You may add a helper method addAfter(E target, E newItem) to CSLinkedList if needed.
        //LinkedList
        CSLinkedList<String> shoppingList = new CSLinkedList<>();
        //Add shopping list
        shoppingList.add("Water");
        shoppingList.add("Coffee");
        shoppingList.add("Milk");
        System.out.println("Initial List: " + shoppingList);
        //Add item that goes with item in initial list
        shoppingList.addAfter("Coffee" , "Sugar");
        System.out.println("After getting Coffee, grab sugar: " + shoppingList);
        shoppingList.addAfter("Milk" , "Cereal");
        System.out.println("After getting Milk, grab Cereal: " + shoppingList);
    }

    // LL7 – Bus Route Stops
    private static void runLL7_BusRouteStops() {
        // TODO: Implement task LL7 here.
        //LinkedList
        CSLinkedList<String> stops = new CSLinkedList<>();
        //Add Stops
        stops.add("Stop 1");
        stops.add("Stop 2");
        stops.add("Stop 3");
        stops.add("Stop 4");
        //Print Initial Route
        System.out.println("Initial Route: " + stops);
        //Add a stop in the middle
        stops.add(2 , "Stop 2B");
        //Remove a closed stop
        int indexToRemove = stops.indexOf("Stop 3");
        if (indexToRemove != -1) {
            stops.remove(indexToRemove);
        }
        System.out.println("Updated Route: " + stops);
    }

    // LL8 – Event Schedule (Insert by Time)
    private static void runLL8_EventScheduleSorted() {
        // TODO: Implement task LL8 here.
        // You may add a helper method addInOrder(E item, Comparator<E> cmp) to CSLinkedList if needed.
        //LinkedList
        CSLinkedList<String> events = new CSLinkedList<>();
        //Comparator
        Comparator<String> timeCmp = (a , b) -> a.compareTo(b);
        //Add events to schedule
        events.addInOrder("09:00 Breakfast" , timeCmp);
        events.addInOrder("08:00 Make Bed" , timeCmp);
        events.addInOrder("12:00 Lunch" , timeCmp);
        //Print schedule
        System.out.println(events);
    }

    // LL9 – Bug Tracker List (Remove by ID)
    private static void runLL9_BugTrackerRemoveById() {
        // TODO: Implement task LL9 here.
        // You may add a helper method removeFirstOccurrence(E item) to CSLinkedList if needed.
        //LinkedList
        CSLinkedList<String> bugtracker = new CSLinkedList<>();
        //Add bugs
        bugtracker.add("Bug 1");
        bugtracker.add("Bug 2");
        bugtracker.add("Bug 3");
        bugtracker.add("Bug 2"); //duplicate
        bugtracker.add("Bug 4");
        //Print initial ID list
        System.out.println("Initial ID List: " + bugtracker);
        //Remove first occurrence of duplicate
        bugtracker.removeFirstOccurrence("Bug 2");
        System.out.println("After fixing Bug 2: " + bugtracker);
    }

    // LL10 – Playlist Shuffle Copy
    private static void runLL10_PlaylistShuffleCopy() {
        // TODO: Implement task LL10 here.
        // You may add a helper method copy() to CSLinkedList if needed.
        //OG LinkedList
        CSLinkedList<String> playlist = new CSLinkedList<>();
        playlist.add("Song a");
        playlist.add("Song b");
        playlist.add("Song c");
        System.out.println("OG Playlist: " + playlist);
        //Shuffled playlist
        CSLinkedList<String> shuffled = playlist.copy();
        //Swap songs
        String temp = shuffled.get(1);
        shuffled.set(1, shuffled.get(2));
        shuffled.set(2, temp);
        System.out.println("Shuffled Playlist: " + shuffled);
        //Show OG playlist did not change
        System.out.println("OG Playlist: " + playlist);
    }
}
