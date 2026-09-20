
import java.io.*;
import java.util.*;

public class F {
    static class Edge implements Comparable<Edge>{
        int to;
        long weight;
        Edge (int to,long w){
            this.to=to;
            weight=w;
        }
        public int compareTo(Edge other){ 
            return Long.compare(this.weight, other.weight);
        }
    }
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        StringTokenizer nmsd=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(nmsd.nextToken());
        int m=Integer.parseInt(nmsd.nextToken());
        int s=Integer.parseInt(nmsd.nextToken());
        int d=Integer.parseInt(nmsd.nextToken());

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

        long [] dis1=new long[n];
        long [] dis2=new long[n];
        Arrays.fill(dis1,Long.MAX_VALUE);
        Arrays.fill(dis2,Long.MAX_VALUE);

        PriorityQueue<Edge> pq=new PriorityQueue<>();
        pq.add(new Edge(s-1,0));
        dis1[s-1]=0;


        while(!pq.isEmpty()){ 
            Edge e=pq.remove();
            int u=e.to;
            long w=e.weight;

            for(int i=0;i<adj[u].size();i++){
                Edge ee=adj[u].get(i);
                int v=ee.to;
                long w1=ee.weight;
                long new_d=w1+w;

                if(new_d<dis1[v]){
                    dis2[v]=dis1[v];
                    dis1[v]=new_d;
                    if(dis2[v]!=Long.MAX_VALUE){
                        pq.add(new Edge(v,dis2[v]));
                    }
                    pq.add(new Edge(v,dis1[v]));
                }
                else if(new_d>dis1[v] && new_d<dis2[v] ){
                    dis2[v]=new_d;
                    pq.add(new Edge(v,dis2[v]));
                }
            }
        }

        if(dis2[d-1]!=Long.MAX_VALUE){
            pw.println(dis2[d-1]);
        }
        else{
            pw.println(-1);
        }
    
        pw.flush();
        
    }
}
