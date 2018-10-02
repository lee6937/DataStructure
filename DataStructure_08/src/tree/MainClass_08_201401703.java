package tree;
import tree.BinaryNode;
import tree.BinaryTree;

import java.util.Scanner;

public class MainClass_08_201401703 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Start Tree Practice ===");
        System.out.print("> Insert String. : ");
        String string = scanner.nextLine();
        System.out.println();
        System.out.print("> Select Sorting Method.\n" + "Default is inorder.\n"+
                            "1: inorder 2:pre order, 3: post order 4: level order :");

        int order = scanner.nextInt();
        System.out.println();
        BinaryTree binaryTree = makeTree(string, order);

        while (true) {
            System.out.println("1: Input String 2: Change Order  3: Check String");
            System.out.print("4: View Tree 9: Exit : ");
            int num = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (num) {
                case 1:
                    System.out.print("> Input String. : ");
                    string = scanner.nextLine();
                    binaryTree = makeTree(string, order);
                    System.out.println();
                    break;
                case 2:
                    System.out.print("> Select Sorting Method.\n" + "Default is inorder.\n"+
                            "1: inorder 2:pre order, 3: post order 4: level order :");
                    order = scanner.nextInt();
                    binaryTree = makeTree(string, order);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Check String. : ");
                    System.out.println(binaryTree.getValue());
                    System.out.println();
                    break;
                case 4:
                    System.out.println("View Tree Shape. : ");
                    binaryTree.print();
                    System.out.println();
                    break;
                case 9:
                    System.out.println("=== End. ===");
                    return ;
            }
        }
    }

    private static BinaryTree makeTree(String string, int order) {
        switch (order) {
            case 2:
                return new BinaryTree(string, "preOrder");
            case 3:
                return new BinaryTree(string, "postOrder");
            case 4:
                return new BinaryTree(string, "levelOrder");
            default:
                return new BinaryTree(string, "inorder");
        }
    }

}
