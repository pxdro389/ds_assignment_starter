// ListStackDriver.java
// Starter file for the Stack portion of the Data Structures assignment.
// DO NOT change the class name or the signature of main().
// Implement ONLY the method for your assigned task (e.g., runS4_ReverseWord).

public class ListStackDriver {

    public static void main(String[] args) {
        // TODO: Uncomment EXACTLY ONE of the following lines,
        // then implement that method below.

        runS1_BrowserBackButton();
        //runS2_TextEditorUndo();
        //runS3_BalancedParentheses();
        //runS4_ReverseWord();
        //runS5_DirectoryNavigation();
        //runS6_CalculatorHistory();
        //runS7_PalindromeChecker();
        //runS8_FunctionCallStack();
        //runS9_StackOfPlates();
    }

    // S1 – Browser Back Button
    private static void runS1_BrowserBackButton() {
        // TODO: Implement task S1 here.
        //Stack
        ListStack<String> history = new ListStack<>();
        //Start page
        String currentPage = "home";
        //Push pages
        history.push(currentPage);
        currentPage = "google.com";
        history.push(currentPage);
        currentPage = "canvas.csun.edu";
        history.push(currentPage);
        currentPage = "github.com";
        history.push(currentPage);
        currentPage = "mail.google.com";
        history.push(currentPage);
        System.out.println("History:" + history);
        //Back button
        System.out.println("Back Button: ");
        if (!history.isEmpty()) currentPage = history.pop(); //Action: Back button once
        System.out.println(currentPage);
        System.out.println("Back Button: ");
        if (!history.isEmpty()) currentPage = history.pop(); //Action: Back button twice
        System.out.println(currentPage);
        //Updated history
        System.out.println("Updated history: " + history);
    }

    // S2 – Undo in a Text Editor
    private static void runS2_TextEditorUndo() {
        // TODO: Implement task S2 here.
        //Stack
        ListStack<String> text = new ListStack<>();
        //Empty doc
        String doc = "";
        System.out.println("Starting doc: \"" + doc + "\"");
        //First text
        text.push(doc);
        doc = "This is CS";
        System.out.println(doc);
        //Add text
        text.push(doc);
        doc = "This is CS 282";
        System.out.println(doc);
        //Add text
        text.push(doc);
        doc = "This is CS 282, Adv Data Struct!";
        System.out.println(doc);
        //Begin undo
        System.out.println("Undo: ");
        //Undo recent text
        if (!text.isEmpty()) doc = text.pop();
        System.out.println(doc);
        //Undo again
        if (!text.isEmpty()) doc = text.pop();
        System.out.println(doc);
    }

    // S3 – Checking Balanced Parentheses
    private static void runS3_BalancedParentheses() {
        // TODO: Implement task S3 here.
        String[] tests = {
                "(1 + 1)",
                "1 + 2)",
                "(1 * (2 + 3))",
                "((()))",
                ")(()))"
        };
        for (String expression : tests) {
            ListStack<Character> stack = new ListStack<>();
            boolean balanced = true;
            for (int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);
                if (ch == '(') {
                    stack.push(ch);
                } else if (ch == ')') {
                    if (stack.isEmpty()) {
                        balanced = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if (!stack.isEmpty()) {
                balanced = false;
            }
            System.out.println(expression + (balanced ? "Balanced" : "Not Balanced"));
        }
    }


    // S4 – Reversing a Word Using a Stack
    private static void runS4_ReverseWord() {
        // TODO: Implement task S4 here.
        String word = "Data";
        //Stack
        ListStack<Character> stack = new ListStack<>();
        //Push letters
        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }
        //Pop for reverse word
        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }
        System.out.println("Original: " + word);
        System.out.println("Reversed: " + reversed);
    }

    // S5 – Directory Navigation (cd / cd ..)
    private static void runS5_DirectoryNavigation() {
        // TODO: Implement task S5 here.
        //Stack
        ListStack<String> path = new ListStack<>();
        //Create command
        String[] commands = {
                "cd user",
                "cd recent",
                "cd documents",
                "cd ..",
                "cd downloads"
        };
        for (String cmd : commands) {
            System.out.println("Command: " + cmd);
            if (cmd.startsWith("cd ")) {
                String folder = cmd.substring(3);
                if (folder.equals("..")) {
                    if (!path.isEmpty()) {
                        path.pop();
                    }
                } else {
                    path.push(folder);
                }
            }
            System.out.print("Current Directory: /");
            ListStack<String> temp = new ListStack<>();
            while (!path.isEmpty()) {
                temp.push(path.pop());
            }
            while (!temp.isEmpty()) {
                String folder = temp.pop();
                System.out.print(folder + "/");
                path.push(folder);
            }
            System.out.println();
        }
    }

    // S6 – History of Calculator Operations
    private static void runS6_CalculatorHistory() {
        // TODO: Implement task S6 here.
        //Stack
        ListStack<String> history = new ListStack<>();
        //Add operations
        String O1 = "5 + 5 = 10";
        String O2 = "2 * 2 = 4";
        String O3 = "6 - 3 = 3";
        //Push each operation
        history.push(O1);
        history.push(O2);
        history.push(O3);
        System.out.println("History: ");
        System.out.println(O1);
        System.out.println(O2);

        //Undo recent operation
        String undone = history.pop();
        System.out.println(undone);
        //Updated history
        System.out.println("Updated History: ");
        //Empty stack
        ListStack<String> temp = new ListStack<>();
        temp.push(history.pop());
        while (!history.isEmpty()) {
            temp.push(history.pop());
        }
        while (!temp.isEmpty()) {
            String op = temp.pop();
            System.out.println(op);
            history.push(op);
        }
    }

    // S7 – Palindrome Checker
    private static void runS7_PalindromeChecker() {
        // TODO: Implement task S7 here.
        //Add words
        String[] words = {
                "racecar",
                "civic",
                "comp",
                "level",
                "csun",
                "rotor"
        };
        for (String word : words) {
            ListStack<Character> stack = new ListStack<>();
            //Push to stack
            for (int i = 0; i < word.length(); i++) {
                stack.push(word.charAt(i));
            }
            //Reverse
            String reversed = "";
            while (!stack.isEmpty()) {
                reversed += stack.pop();
            }
            //Palindrome
            boolean isPalindrome = word.equals(reversed);
            System.out.println(word + " = " + (isPalindrome));
        }
    }

    // S8 – Function Call Stack Simulator
    private static void runS8_FunctionCallStack() {
        // TODO: Implement task S8 here.
        //Stack
        ListStack<String> stack = new ListStack<>();
        //Add calls
        String[] actions = {
                "call main method",
                "call function1",
                "return",
                "call function2",
                "return",
                "call function3",
                "return"
        };
        for (String action : actions) {
            System.out.println("Action: " + action);
            if (action.startsWith("call")) {
                String function = action.substring(5);
                stack.push(function);
            } else if (action.equals("return")) {
                if (!stack.isEmpty()) {
                    String function = stack.pop();
                    System.out.println("Returned From: " + function);
                } else {
                    System.out.println("Stack empty");
                }
            }
            System.out.print("Current Stack: ");
            ListStack<String> temp = new ListStack<>();
            while (!stack.isEmpty()) {
                temp.push(stack.pop());
            }
            while (!temp.isEmpty()) {
                String func = temp.pop();
                System.out.print(func + " ");
                stack.push(func);
            }
            System.out.println("\n");
        }
    }

    // S9 – Stack of Plates (Capacity-Limited Stack)
    private static void runS9_StackOfPlates() {
        // TODO: Implement task S9 here.
        //Determine capacity
        final int CAPACITY = 4;
        //Stack
        ListStack<String> stack = new ListStack<>();
        //Add plates
        String[] plates = {"Plate1", "Plate2", "Plate3", "Plate4", "Plate5", "Plate6"};
        for (String plate : plates) {
            if (stack.size() < CAPACITY) {
                stack.push(plate);
                System.out.println(plate);
            } else {
                System.out.println("Max capacity, can't push " + plate);
            }
        }
    }
}
