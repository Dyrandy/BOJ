package com.company.dfs_bfs;
import java.util.*;

class Graph {
   int count = 0;
   class Node{
       int data;
       LinkedList<Node> adjacent;
       boolean visited;
       Node(int data){
           this.data = data;
           this.visited = false;
           adjacent = new LinkedList<Node>();
       }
   }
   Node[] nodes;
   Graph(int size){
       nodes = new Node[size];
       for(int i = 0; i < size; i++){
           nodes[i] = new Node(i);
       }
   }
   void addEdge(int i1, int i2){
       Node n1 = nodes[i1];
       Node n2 = nodes[i2];
       if(!n1.adjacent.contains(n2)){
           n1.adjacent.add(n2);
       }
       if(!n2.adjacent.contains(n1)){
           n2.adjacent.add(n1);
       }
   }
   void bfs(){
       bfs(0);
   }
   void bfs(int index){
       Node root = nodes[index];
       LinkedList<Node> queue = new LinkedList<>();
       queue.add(root);
       root.visited = true;
       while(!queue.isEmpty()){
           Node r = queue.poll();
           for(Node n : r.adjacent){
               if(n.visited == false){
                   queue.add(n);
                   n.visited = true;
               }
           }
           visit(r);
       }
   }
   void dfs(){
       dfs(0);
   }
   void dfs(int index){
       Node root = nodes[index];
       Stack<Node> stack = new Stack<Node>();
       stack.push(root);
       root.visited = true;
       while(!stack.isEmpty()){
           Node r = stack.pop();
           for(Node n : r.adjacent){
               if(n.visited == false){
                   n.visited = true;
                   stack.push(n);
               }
           }
           visit(r);
       }
   }

   void visit(Node r){
       count++;
       //System.out.print(r.data + " ");
   }
}



public class BFS_DFS_Problem2606 {

   public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);

       int graphSize = scan.nextInt();
       int links = scan.nextInt();

       Graph graph = new Graph(graphSize);
       for(int i = 0; i < links; i++){
           int i1 = scan.nextInt();
           int i2 = scan.nextInt();
           graph.addEdge(i1 - 1, i2 - 1);
       }
       graph.bfs();
       System.out.println(graph.count - 1);
       scan.close();
   }
}
