import java.io.*;
import java.util.*;

public class B {

    static class Edge{
        int to;
        int w;
        Edge(int to, int w){
            this.to=to;
            this.w=w;
        }
    }
   public static void main (String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        StringTokenizer st1=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st1.nextToken());
        int M=Integer.parseInt(st1.nextToken());
        ArrayList<Edge>[] adj=new ArrayList[N];
        for(int i=0;i<N;i++){  
            adj[i]=new ArrayList<>();
        }
        StringTokenizer uu=new StringTokenizer(br.readLine());
        StringTokenizer vv=new StringTokenizer(br.readLine());
        StringTokenizer ww=new StringTokenizer(br.readLine());
        
        for(int i=0;i<M;i++){
            int u=Integer.parseInt(uu.nextToken());
            int v=Integer.parseInt(vv.nextToken());
            int w=Integer.parseInt(ww.nextToken());
            adj[u-1].add(new Edge(v,w));
        }

        for(int i=0;i<adj.length;i++){
            pw.print((i+1)+":");
            for(int j=0;j<adj[i].size();j++){
                Edge e=adj[i].get(j);
                pw.print(" ("+e.to+","+e.w+") ");
            }
            pw.println();
        }

        pw.flush();
    } 
}
