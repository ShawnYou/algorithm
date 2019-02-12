package com.ysl.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 数据结构：图
 */
public class Graph {
    //quantity of point
    private int v;

    private LinkedList<Integer> adj[];

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int s, int t){
        adj[s].add(t);
        adj[t].add(s);
    }

    // 广度优先搜索算法
    public void bfs(int s,int t){
        if(s == t){ return; }

        boolean[] visited = new boolean[v];
        visited[s] = true;

        int[] prev = new int[v];
        for (int i = 0; i < prev.length; i++) { prev[i] = -1; }

        Queue queue = new LinkedList();
        queue.add(s);

        while (queue.size()!= 0){
            int w = (int)queue.poll();
            LinkedList list = adj[w];
            for(int i =0;i<list.size();i++){
                int q = (int)list.get(i);
                if(!visited[q]){
                    prev[q] = w;
                    if(q == t){
                        print(prev,s,t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    boolean found = false;
    //深度优先搜索算法
    public void dfs(int s,int t){
        found = false;

        int[] prev = new int[v];
        for (int i = 0; i < prev.length; i++) {
            prev[i] = -1;
        }

        boolean[] visited = new boolean[v];

        recurDfs(s,t,visited,prev);
        print(prev,s,t);

    }

    public void recurDfs(int w,int t,boolean[] visited,int[] prev){
        if(found == true){ return;}

        visited[w] = true;

        if(w == t){ found = true; return;}

        LinkedList list = adj[w];

        for (int i = 0; i < list.size(); i++) {
            int q = (int)list.get(i);

            if(!visited[q]){
                prev[q] = w;

                recurDfs(q,t,visited,prev);
            }
        }
    }

    public void print(int[] prev, int s,int t){
        if(prev[t]!=-1&&t != s){
            print(prev,s,prev[t]);
        }
        System.out.println(t + " ");
    }

    public static void main(String[] args) {
        Graph graph = new Graph(9);
        graph.addEdge(1,2);
        graph.addEdge(1,4);

        graph.addEdge(2,5);
        graph.addEdge(2,3);
        graph.addEdge(3,6);
        graph.addEdge(4,5);
        graph.addEdge(5,6);
        graph.addEdge(5,7);
        graph.addEdge(6,8);
        graph.addEdge(7,8);

        //graph.bfs(3,7);
        graph.dfs(1,7);
    }
}
