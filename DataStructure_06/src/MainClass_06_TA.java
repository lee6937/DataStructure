import java.util.Scanner;

public class MainClass_06_TA {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        CircularArrayQueue queue = new CircularArrayQueue();
        System.out.println(" :: Program Start :: ");
        System.out.println("[ Start to Input Character. ]");
        String string;
        while (true) {
            System.out.print("- Please Input Character : ");
            string = scanner.nextLine();
            if ("!".equals(string)) {
                System.out.println("[End to Input Character]");
                queue.removes(queue.size());
                break;
            }
            switch (string) {
                case "#":
                    System.out.println("[Size] The Queue has " + queue.size() + " of Element(s).");
                    break;
                case "/":
                    System.out.println("[Queue] <Front> " + queue.printQueue() + "<Rear> ");
                    break;
                case "^":
                    System.out.println("[Front] The First Element is '" + queue.front() + "'. ");
                    break;
                case "-":
                    String dequeue = queue.deQueue();
                    if (!"".equals(dequeue))
                        System.out.println("[DeQueue] The Deleted Element is '" + dequeue + "'.");
                    break;
                case "0":
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                    System.out.println(string + " Of Element(s) will be Deleted");
                    queue.removes(Integer.parseInt(string));
                    break;
                default:
                    if (queue.enQueue(string))
                        System.out.println("[Enqueue] The Inserted Element is " + string + ".");
                    break;
            }

        }
        System.out.println("\n :: Program End :: ");
    }
}
