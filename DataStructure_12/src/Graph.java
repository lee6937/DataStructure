import javax.swing.*;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeSet;

class Graph {
    private int[][] edge;
    private int size;

    public Graph(int size) {
        this.size = size;
        this.edge = new int[size][size];
    }

    public int size(){
        return size;
    }

    public void addEdge(int src, int dst) { //���� �� �߰� �Լ�	
    	edge[src][dst] = 1; // �� vertex�� 1�� ����     
    }

    public void removeEdge(int src, int dst) { //���� �� ���� �Լ�
    	edge[src][dst] = 0; // �� vertex�� 0���� ������
    }

    public void readGraph(File file) throws IOException {
        if (file == null) {
            String currentPath = Paths.get(".", "src").toString();
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setCurrentDirectory(new File(currentPath));
            jFileChooser.showOpenDialog(new JFrame());
            file = jFileChooser.getSelectedFile();
        }
        if (file != null) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            this.size = Integer.parseInt(br.readLine());
            this.edge = new int[size][size];
            for (int i = 0; i < size; ++i) {
                String[] temps = br.readLine().split(" ");
                for (int j = 0; j < temps.length; ++j) {
                    edge[i][j] = Integer.parseInt(temps[j]);
                }
            }
            System.out.println("File selected!");
        } else {
            System.out.println("No file Selected");
        }
    }
    public void print() {
        System.out.println("This Graph ::\n");
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                System.out.print(edge[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void bfs(int vertex) { //�ʺ� �켱 Ž��

    	 Queue <Integer> q = new <Integer> LinkedList(); //ť��� �÷��� ��� => ��üȭ
         boolean visit[] = new boolean[this.size]; //�湮 �ߴ��� Ȯ���ϴ� �迭 ����
         q.offer(vertex); //queue�� ó�� vertex ����
         visit[vertex] = true; //queue�� �־����� �湮�ߴٰ� ǥ�� => true��
         
         while(!q.isEmpty()){ //queue�� ������� ���� �ݺ�
             int temp = q.poll(); //queue�� ���� ������ ������ ����
             System.out.print(temp+ " -> "); //���� ���
             
             for(int j = 0; j < this.size; j++){ //��������� �ݺ�
                 if(edge[temp][j] == 1 && visit[j] == false){ //2�����迭�� �������� ������ 1�̰�(����Ǿ��ְ�) �湮���� �ʾ��� ���
                     q.offer(j); //������ ��� queue�� ����
                     visit[j] = true; // queue�� �־����� �湮�ߴٰ� ǥ��
                     }
                 }// �ݺ��ϸ鼭 �� ���� ������ queue�� ���� 
             }//�����鼭 Ž���� �Ѵ�. => queue�� ������� ������    
    }

    public void dfs(boolean[] isFounds, int vertex) { //���� �켱 Ž��

    	 isFounds[vertex] = true;   // �湮�ߴٰ� ǥ��
         System.out.print(vertex+ " -> "); //�湮�� vertex ���
         
         for(int j = 0; j < this.size; j++){ //��������� �ݺ�
             if(edge[vertex][j] == 1 && isFounds[j] == false){  // 2�����迭�� �������� ������ 1�̰�(����Ǿ��ְ�) �湮���� �ʾ��� ���
                 dfs(isFounds,j); //���� ���� ���� �켱Ž���Ѵ�. => ����Լ�
             } //����Ǿ� �ִ� ���� ��� ���� Ž���ϰ� �� ���� ���� Ž���ϴ� �˰���
         }
    }

    class Edge{ //���� Ŭ���� ����
        int start; //���� vertex�� ����Ű�� ����
        int finish; //���� vertex�� ����Ű�� ����
        int weight; //����ġ�� ��Ÿ���� ����
        
        Edge(int start, int finish, int weight){ //�Ű����� ������
           this.start = start; 
           this.finish = finish; 
           this.weight = weight; //�Ű������� ���� ����
        }
     }
    
    public void kruskalAlgorithm() { //ũ�罺Į �˰���
    	  ArrayList<Edge> edges = new ArrayList<Edge>(); //ArrayList�÷��� ��ü ���� 
          int [] union = new int[this.size]; //union �迭 ����
          int count = 0; //�� ����ġ ���� �����ִ� ���� ����
          for(int i = 0; i < this.size; i++) { 
             for(int j = i+1; j < this.size; j++) { //���� for�� �����鼭 => 2�����迭
                if(edge[i][j] != 0) edges.add(new Edge(i, j, edge[i][j])); 
             } //����ġ�� �ִٸ� ArrayList�� ���۰� �� vertex�� ����ġ�� edge���·� �߰�
             union[i] = i; //�� vertex�� �������� ����
          } //���μ� ���� �ʱ�ȭ 
          edges.sort( new Comparator<Edge>() { //����ġ �ִ� �迭���� ����
             @Override
             public int compare(Edge o1, Edge o2) { //Comparator�� �Լ��� ��������
                // TODO Auto-generated method stub
                if(o1.weight > o2.weight) return 1; 
                else if(o1.weight < o2.weight) return -1; 
                else return 0;
             } // ������������ ����
          });
          // �ʱ�ȭ
          
          while(!edges.isEmpty()) { //����ġ �迭���� ������� ���� ���� �ݺ�
             Edge temp = edges.remove(0); //�Ǿտ� ���� �� ������ ���� => ����ġ�� ���� ���� �� �������
             int p = union[temp.start]; //union�迭�� start�ε������� p�� ����  
             int q = union[temp.finish]; //union�迭�� start�ε������� q�� ���� 
             if(p != q) { //�� union������ ���� ���� �ʴٸ� => �ΰ��� �ٸ� �����̶��
                count += temp.weight; //����ġ�� ������ count������ ����
                for(int a = 0; a < this.size; a++) { //��������� �ݺ��ϸ鼭
                   if(union[a] == q) { //q�� ���� union �迭��
                      union[a] = p; //p�� ���� ���� => ���� ���� �����Ͽ� ���� �������� �������
                   } 
                }
                System.out.println(p +" -> "+ q +" : "+temp.weight); //vertex�� ����ġ ���
             }
          }
          System.out.printf("Total cost : %d\n", count); //�� �� ���
    }

    public void primAlgorithm(int start) {
        ArrayList<Integer> arr = new ArrayList<Integer>(); // ����� vertex�� �����ϱ� ���� ArrayList
        int [] key = new int[this.size]; // ������ vertex�� weight ����
        for(int i = 0; i < this.size; i++) key[i] = Integer.MAX_VALUE; // ���� ū ������ �ʱ�ȭ
        key[start] = 0; // �������� weight�� 0���� ����
        int cost = 0, min = Integer.MAX_VALUE; // cost�� MST�� �� ����� ���ϱ� ���� ����
        arr.add(start); // ���� vertex ����
        while(arr.size() != this.size) { // ���� ��� vertex�� �����ϴ� MST�� ����� ���� �ʴ´ٸ� ��� �ݺ��� ����
           int temp, priv = 0, next = 0; 
           // ���� MST�� ����� vertex�� Ž���ϱ� ���� temp ����
           // edge�� ����� priv / edge�� ������ next
           min = Integer.MAX_VALUE; // weight�� �ּҰ��� edge ã�� ���� min
           for(int i = 0; i < arr.size(); i++) { // ���� MST�� �̷�� vertex�� ����ŭ ������ edge�� ������� �ϹǷ�
              temp = arr.get(i); // ������ vertex
              for(int j = 0; j < this.size; j++) { // �������ŭ �ݺ��ϸ鼭
                 if(edge[temp][j] != 0 && (edge[temp][j] < min && edge[temp][j] < key[j] )) {
                	// ����Ǿ� �ְ�, �ּҰ����� ������, �ش� vertex�� ����ִ� ����ġ������ ���� ��
                    if(key[temp] == edge[temp][j]) continue; // �ߺ��Ǿ��� ��� �Ѿ
                    min = edge[temp][j]; // �ּҰ��� �ٽ� ����
                    next = j; //����� vertex ����
                    priv = temp; //������ vertex ����
                 }
              }
           }
           cost += min; //����� ����ġ�� ��
           key[next] = min; //�ּҰ��� �ش� vertex�� ����ġ �迭�� ����
           arr.add(next); //List���� �߰�
           System.out.printf("%d -> %d : %d\n", priv, next, min);
        }
        System.out.printf("Total cost %d\n", cost);
    }
    }
