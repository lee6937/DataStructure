import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class MainClass_09_201401703 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        int menu, insert;
        BinaryNode find;
        System.out.println("===============Start BinarySearchTree Test================");
        System.out.println("1.InsertValue    2.Find    3.Delete    4.PrintTree    9.Exit");
        System.out.print("Insert Menu > ");
        menu = sc.nextInt();

        while (menu != 9) {

            switch (menu) {
                case 1:
                    System.out.println("Please Insert To Input Value");
                    insert = sc.nextInt();
                    bst.insertNode(bst.getRoot(), new BinaryNode(insert));
                    System.out.println("Inserting " + insert);
                    break;
                case 2:
                    System.out.println("Please Insert To Find Value");
                    insert = sc.nextInt();
                    find = bst.findNode(bst.getRoot(), insert, false);
                    if (find != null) 
                        System.out.println("Find : " + find.getValue());
                    else
                        System.out.println("Doesn't Exist Value " + insert);
                    break;
                case 3:
                    System.out.println("Please Insert To Delete value");
                    insert = sc.nextInt();
                    find = bst.findNode(bst.getRoot(), insert, true);
                    if (find != null)
                        System.out.println("Delete : " + find.getValue());
                    else 
                        System.out.println("Doesn't Exist Value " + insert);
                    break;
                case 4:
                    if (bst.getRoot() == null) {
                        System.out.println("Tree is Empty");
                    }
                    else
                        bst.printTree(bst.getRoot(), 0);
                    break;
            }
            System.out.println("\n\n1.InsertValue    2.Find    3.Delete    4.PrintTree    9.Exit");
            System.out.print("Insert Menu > ");
            menu = sc.nextInt();

        }
        System.out.println("===============End BinarySearchTree Test===============");
    }
}
