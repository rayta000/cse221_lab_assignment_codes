
import java.io.*;
import java.util.*;

public class C {
    static class Edge implements Comparable<Edge>{
        int to;
        int weight;
        Edge (int to,int w){
            this.to=to;
            weight=w;
        }
        public int compareTo(Edge other){ 
            return Integer.compare(this.weight, other.weight);
        }
    }
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        StringTokenizer nm=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(nm.nextToken());
        int m=Integer.parseInt(nm.nextToken());

        ArrayList<Edge>[]adj=new ArrayList[n];

        for(int i=0;i<n;i++){ 
            adj[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){ 
            StringTokenizer uvw=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(uvw.nextToken());
            int v=Integer.parseInt(uvw.nextToken());
            int w=Integer.parseInt(uvw.nextToken());
            adj[u-1].add(new Edge(v-1,w));
            adj[v-1].add(new Edge(u-1,w));
        }

        int [] dis=new int[n];
        int [] vis=new int[n];
        Arrays.fill(dis,(int)Double.POSITIVE_INFINITY);

        PriorityQueue<Edge> pq=new PriorityQueue<>();
        pq.add(new Edge(0,0));
        dis[0]=0;

        while(!pq.isEmpty()){ 
            Edge e=pq.remove();
            int u=e.to;
            int danger=e.weight;

            if(vis[u]==1){
                continue;
            }
            vis[u]=1;

            for(int i=0;i<adj[u].size();i++){
                Edge ee=adj[u].get(i);
                int v=ee.to;
                int d=ee.weight;

                int new_danger=Math.max(danger,d);

                if(new_danger<dis[v]){
                    dis[v]=new_danger;
                    pq.add(new Edge(v,new_danger));
                }
            }

        }

        for(int i=0;i<n;i++){
            if(dis[i]!=(int)Double.POSITIVE_INFINITY){
                pw.print(dis[i]+" ");
            }
            else{
                pw.print(-1+" ");
            }
        }
    
        pw.println();
        pw.flush();
        
    }
}
