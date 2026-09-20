import java.io.*;
import java.util.*;

public class A {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw=new PrintWriter(System.out);

    static int N,M;

    static int[] colour;

   public static void main (String[] args)throws Exception{

    StringTokenizer st1=new StringTokenizer(br.readLine());

    N=Integer.parseInt(st1.nextToken());
    M=Integer.parseInt(st1.nextToken());

    colour=new int[N];

    ArrayList<Integer>[] adj= new ArrayList[N];

        for(int i=0;i<N;i++){  
            adj[i]=new ArrayList<>();
        }
        
        for(int i=0;i<M;i++){
            StringTokenizer s=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(s.nextToken());
            int v=Integer.parseInt(s.nextToken());
            adj[u-1].add(v-1);
            adj[v-1].add(u-1);
        }

        //BFS
        Queue<Integer> q=new LinkedList<>();

        q.add(0);
        colour[0]=1;

        while(!q.isEmpty()){
            int u=q.remove();
            pw.print((u+1)+" ");

            for(int i=0;i<adj[u].size();i++){
                int v=adj[u].get(i);

                if(colour[v]==0){
                    colour[v]=1;
                    q.add(v);
                }
            }
        }
        pw.println();
        pw.flush();
    } 
}