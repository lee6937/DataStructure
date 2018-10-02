import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("==== Graph ====");
        System.out.println("==== Start ====");
        int num;
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input Graph's vertex size: ");
        int size = scanner.nextInt();
        if (size > 0) {
            Graph graph = new Graph(size);

            while (true) {
                System.out.println("1: Add Edge :: 2: Remove Edge :: 3: BFS ");
                System.out.println("4: DFS :: 5: print :: 6: READ FILE \n7: Kruskal :: 8:Prim :: 9: Exit ");
                num = scanner.nextInt();
                switch (num) {
                    case 1: {
                        int src, dst;
                        System.out.print("Input src : ");
                        src = scanner.nextInt();
                        System.out.print("Input dst : ");
                        dst = scanner.nextInt();
                        graph.addEdge(src, dst);
                        break;
                    }
                    case 2: {
                        int src, dst;
                        System.out.print("Input src : ");
                        src = scanner.nextInt();
                        System.out.print("Input dst : ");
                        dst = scanner.nextInt();
                        graph.removeEdge(src, dst);
                        break;
                    }
                    case 3: {
                        System.out.print("Input vertex : ");
                        int vertex = scanner.nextInt();
                        graph.bfs(vertex);
                        System.out.println();
                        break;
                    }
                    case 4: {
                        System.out.print("Input vertex : ");
                        int vertex = scanner.nextInt();
                        graph.dfs(new boolean[graph.size()], vertex);
                        System.out.println();
                        break;
                    }
                    case 5: {
                        graph.print();
                        break;
                    }
                    case 6: {
                        graph.readGraph(new File("C:\\Users\\dkfma\\eclipse-workspace\\DataStructure_12\\src\\sample.txt"));
                    	break;
                    }
                    case 7: {
                        graph.kruskalAlgorithm();
                        break;
                    }
                    case 8: {
                        System.out.print("Input vertex : ");
                        int vertex = scanner.nextInt();
                        graph.primAlgorithm(vertex);
                        break;
                    }
                    case 9: {
                        System.out.println("==== END ====");
                        return;
                    }
                    default:
                        break;
                }
            }
        }
    }
}
