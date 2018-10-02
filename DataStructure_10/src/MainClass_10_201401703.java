import java.util.Scanner;

public class MainClass_10_201401703 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==== ========= ====");
        System.out.println("==== HEAP TEST ====");

        int num = 0;

        MaxHeap maxHeap = new MaxHeap();
        while (num != 9) {
            System.out.println("1.add numbers :: 2.remove max :: 3.heapsort");
            System.out.println("4.increase key :: 5.print heap");
            System.out.print("9.exit ");
            num = scanner.nextInt();
            System.out.println();
            switch (num) {
                case 1: {
                    scanner.nextLine();
                    System.out.print("Input numbers : ");
                    String numbers = scanner.nextLine();
                    String[] nums = numbers.split(" ");
                    int[] ns = new int[nums.length];
                    for (int i = 0; i < nums.length; ++i) {
                        ns[i] = Integer.parseInt(nums[i]);
                    }
                    for (int n : ns) {
                        maxHeap.add(n);
                        System.out.println("Add number : " + n);
                    }
                    break;
                }
                case 2: {
                    System.out.print("Remove number is : ");
                    int max = maxHeap.removeMax();
                    System.out.println(max);
                    break;
                }
                case 3: {
                    scanner.nextLine();
                    System.out.print("Input numbers : ");
                    String numbers = scanner.nextLine();
                    String[] nums = numbers.split(" ");
                    int[] ns = new int[nums.length];
                    for (int i = 0; i < nums.length; ++i) {
                        ns[i] = Integer.parseInt(nums[i]);
                    }
                    int[] maxs = MaxHeap.heapSort(ns, ns.length);
                    for (int i : maxs) {
                        System.out.print(i + " ");
                    }
                    System.out.println();
                    break;
                }
                case 4: {
                    System.out.print("Input target number : ");
                    int target = scanner.nextInt();
                    System.out.print("Input  number : ");
                    int next = scanner.nextInt();
                    if (maxHeap.increaseKey(target, next))
                        System.out.println("Success");
                    else
                        System.out.println("Failed");
                    break;
                }
                case 5: {
                    System.out.println(maxHeap);
                    break;
                }
                default: {
                    break;
                }
            }
            System.out.println();
        }

        System.out.println("=== HEAP END ===");
        System.out.println("=== ======== ===");
    }
}
