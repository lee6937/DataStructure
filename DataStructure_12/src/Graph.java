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

    public void addEdge(int src, int dst) { //연결 고리 추가 함수	
    	edge[src][dst] = 1; // 두 vertex를 1로 연결     
    }

    public void removeEdge(int src, int dst) { //연결 고리 제거 함수
    	edge[src][dst] = 0; // 두 vertex를 0으로 끊어줌
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

    public void bfs(int vertex) { //너비 우선 탐색

    	 Queue <Integer> q = new <Integer> LinkedList(); //큐라는 컬렉션 사용 => 객체화
         boolean visit[] = new boolean[this.size]; //방문 했는지 확인하는 배열 생성
         q.offer(vertex); //queue에 처음 vertex 넣음
         visit[vertex] = true; //queue에 넣었으니 방문했다고 표시 => true로
         
         while(!q.isEmpty()){ //queue가 비어있을 동안 반복
             int temp = q.poll(); //queue의 값을 꺼내서 변수에 저장
             System.out.print(temp+ " -> "); //변수 출력
             
             for(int j = 0; j < this.size; j++){ //사이즈까지 반복
                 if(edge[temp][j] == 1 && visit[j] == false){ //2차원배열의 변수행의 열들이 1이고(연결되어있고) 방문하지 않았을 경우
                     q.offer(j); //열들을 모두 queue에 넣음
                     visit[j] = true; // queue에 넣었으니 방문했다고 표시
                     }
                 }// 반복하면서 한 행의 열들이 queue에 들어가고 
             }//꺼내면서 탐색을 한다. => queue가 비어있을 때까지    
    }

    public void dfs(boolean[] isFounds, int vertex) { //깊이 우선 탐색

    	 isFounds[vertex] = true;   // 방문했다고 표시
         System.out.print(vertex+ " -> "); //방문한 vertex 출력
         
         for(int j = 0; j < this.size; j++){ //사이즈까지 반복
             if(edge[vertex][j] == 1 && isFounds[j] == false){  // 2차원배열의 변수행의 열들이 1이고(연결되어있고) 방문하지 않았을 경우
                 dfs(isFounds,j); //열의 값을 깊이 우선탐색한다. => 재귀함수
             } //연결되어 있는 열을 계속 깊이 탐색하고 그 다음 열을 탐색하는 알고리즘
         }
    }

    class Edge{ //간선 클래스 생성
        int start; //시작 vertex를 가리키는 변수
        int finish; //끝의 vertex를 가리키는 변수
        int weight; //가중치를 나타내는 변수
        
        Edge(int start, int finish, int weight){ //매개변수 생성자
           this.start = start; 
           this.finish = finish; 
           this.weight = weight; //매개변수와 같게 설정
        }
     }
    
    public void kruskalAlgorithm() { //크루스칼 알고리즘
    	  ArrayList<Edge> edges = new ArrayList<Edge>(); //ArrayList컬렉션 객체 생성 
          int [] union = new int[this.size]; //union 배열 생성
          int count = 0; //총 가중치 합을 세어주는 변수 생성
          for(int i = 0; i < this.size; i++) { 
             for(int j = i+1; j < this.size; j++) { //이중 for문 돌리면서 => 2차원배열
                if(edge[i][j] != 0) edges.add(new Edge(i, j, edge[i][j])); 
             } //가중치가 있다면 ArrayList에 시작과 끝 vertex와 가중치를 edge형태로 추가
             union[i] = i; //각 vertex를 집합으로 만듬
          } //서로소 집합 초기화 
          edges.sort( new Comparator<Edge>() { //가중치 있는 배열들을 정렬
             @Override
             public int compare(Edge o1, Edge o2) { //Comparator의 함수를 재정의함
                // TODO Auto-generated method stub
                if(o1.weight > o2.weight) return 1; 
                else if(o1.weight < o2.weight) return -1; 
                else return 0;
             } // 오름차순으로 정렬
          });
          // 초기화
          
          while(!edges.isEmpty()) { //가중치 배열들이 비어있지 않을 동안 반복
             Edge temp = edges.remove(0); //맨앞에 제거 후 변수에 저장 => 가중치가 가장 작은 값 순서대로
             int p = union[temp.start]; //union배열의 start인덱스값을 p에 저장  
             int q = union[temp.finish]; //union배열의 start인덱스값을 q에 저장 
             if(p != q) { //두 union집합이 값이 같지 않다면 => 두개가 다른 집합이라면
                count += temp.weight; //가중치의 값들을 count변수에 저장
                for(int a = 0; a < this.size; a++) { //사이즈까지 반복하면서
                   if(union[a] == q) { //q와 같은 union 배열에
                      union[a] = p; //p의 값을 저장 => 같은 값을 저장하여 같은 집합으로 만들어줌
                   } 
                }
                System.out.println(p +" -> "+ q +" : "+temp.weight); //vertex와 가중치 출력
             }
          }
          System.out.printf("Total cost : %d\n", count); //총 합 출력
    }

    public void primAlgorithm(int start) {
        ArrayList<Integer> arr = new ArrayList<Integer>(); // 연결된 vertex를 저장하기 위한 ArrayList
        int [] key = new int[this.size]; // 각각의 vertex의 weight 저장
        for(int i = 0; i < this.size; i++) key[i] = Integer.MAX_VALUE; // 가장 큰 값으로 초기화
        key[start] = 0; // 시작점의 weight를 0으로 설정
        int cost = 0, min = Integer.MAX_VALUE; // cost는 MST의 총 비용을 구하기 위한 변수
        arr.add(start); // 시작 vertex 저장
        while(arr.size() != this.size) { // 만약 모든 vertex를 연결하는 MST가 만들어 지지 않는다면 계속 반복문 시행
           int temp, priv = 0, next = 0; 
           // 현재 MST에 연결된 vertex를 탐색하기 위한 temp 변수
           // edge의 출발점 priv / edge의 도착점 next
           min = Integer.MAX_VALUE; // weight가 최소값인 edge 찾기 위한 min
           for(int i = 0; i < arr.size(); i++) { // 현재 MST를 이루는 vertex의 수만큼 인접한 edge를 살펴봐야 하므로
              temp = arr.get(i); // 각각의 vertex
              for(int j = 0; j < this.size; j++) { // 각사이즈만큼 반복하면서
                 if(edge[temp][j] != 0 && (edge[temp][j] < min && edge[temp][j] < key[j] )) {
                	// 연결되어 있고, 최소값보다 작으며, 해당 vertex에 들어있는 가중치값보다 작을 때
                    if(key[temp] == edge[temp][j]) continue; // 중복되었을 경우 넘어감
                    min = edge[temp][j]; // 최소값을 다시 설정
                    next = j; //연결된 vertex 저장
                    priv = temp; //연결한 vertex 저장
                 }
              }
           }
           cost += min; //연결된 가중치의 합
           key[next] = min; //최소값을 해당 vertex의 가중치 배열에 저장
           arr.add(next); //List에도 추가
           System.out.printf("%d -> %d : %d\n", priv, next, min);
        }
        System.out.printf("Total cost %d\n", cost);
    }
    }
