import java.io.*;
import java.util.*;

public class E {
    static class Edge{
        int to;
        Edge(int to){
            this.to=to;
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
        
        
        for(int i=0;i<M;i++){
            int u=Integer.parseInt(uu.nextToken());
            int v=Integer.parseInt(vv.nextToken());
            adj[u-1].add(new Edge(v-1));
        }

        int [] nodes=new int[N];

        for(int r=0;r<N;r++){  
            for(int c=0;c<adj[r].size();c++){
                Edge e=adj[r].get(c);
                nodes[r]-=1;
                nodes[e.to]+=1;
            }
        }

        for(int i=0;i<nodes.length;i++){
            pw.print(nodes[i]+" ");
        }

        pw.println();
        pw.flush();
    } 
    
}
