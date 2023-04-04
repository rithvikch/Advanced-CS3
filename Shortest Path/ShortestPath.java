import java.util.*;
import java.io.*;
class Node
{
    public int ord;
    public ArrayList<Integer> con;




    double dist;
    int x;


    int y;

    public Node(int ord, int x, int y)
    {



        this.ord = ord;


        this.x = x;
        this.y = y;
        dist = Long.MAX_VALUE;
        con = new ArrayList<>();
    }
    public void setDist(Node other)
    {
        int x2 = other.x;
        int y2 = other.y;
       
       
       
        double distance = (Math.hypot(Math.abs(x-x2), Math.abs(y-y2)));
       
       
       
        other.dist = Math.min(dist+distance, other.dist);
    }
    public boolean getDist(Node other)
    {
        int x2 = other.x;


        int y2 = other.y;




        boolean yes = ((Math.hypot(Math.abs(x-x2), Math.abs(y-y2)))+dist)<other.dist;
        return yes;
    }
}

public class ShortestPath
{



    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner read = new Scanner(new File("input6.txt"));
        int V = read.nextInt();


        int E = read.nextInt();




        Node[] graph = new Node[V];
        for (int i = 0; i<V; i++)
            graph[i] = new Node(read.nextInt(), read.nextInt(), read.nextInt());
        
        
            for (int i = 0; i<E; i++)
          
        
        graph[read.nextInt()].con.add(read.nextInt());
        int start = read.nextInt();


        int end = read.nextInt();


        graph[start].dist = 0;
        System.out.printf("%.1f",shortestDist(graph, start, end, Integer.MAX_VALUE));
        System.out.println();
    }
    public static double shortestDist(Node[] graph, int cur, int end, double min)
    {
        if (cur==end)
            min = Math.min(graph[cur].dist, min);
       
        else
        {
            for (int i: graph[cur].con)
            {
                if (graph[cur].getDist(graph[i]))
                {
                    graph[cur].setDist(graph[i]);
                    min = Math.min(shortestDist(graph, i, end, min), min);
                }
            }
        }
        return min;
    }
}
