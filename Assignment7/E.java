
import java.io.*;
import java.util.*;

public class E {
    static class Edge implements Comparable<Edge>{
        int to;
        long weight;
        int p;
        Edge (int to,long w,int parity){
            this.to=to;
            weight=w;
            p=parity;
        }
        public int compareTo(Edge other){ 
            return Long.compare(this.weight, other.weight);
        }
    }
    public static void main(String[]args) throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        StringTokenizer nm=new StringTokenizer(br.readLine());
        StringTokenizer uu=new StringTokenizer(br.readLine());
        StringTokenizer vv=new StringTokenizer(br.readLine());
        StringTokenizer ww=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(nm.nextToken());
        int m=Integer.parseInt(nm.nextToken());

        ArrayList<Edge>[]adj=new ArrayList[n];

        for(int i=0;i<n;i++){ 
            adj[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){ 
            int u=Integer.parseInt(uu.nextToken());
            int v=Integer.parseInt(vv.nextToken());
            int w=Integer.parseInt(ww.nextToken());
            int pp=-1;
            if(w%2==0){
                pp=0;
            }
            else{
                pp=1;
            }
            adj[u-1].add(new Edge(v-1,w,pp));
        }


        long[] dis=new long[n];
        long[] dis2=new long[n];
        
        
        Arrays.fill(dis,Long.MAX_VALUE/4);
        Arrays.fill(dis2,Long.MAX_VALUE/4);

        PriorityQueue<Edge> pq=new PriorityQueue<>();
        pq.add(new Edge(0,0,0));
        pq.add(new Edge(0,0,1));
        dis[0]=0; //Even
        dis2[0]=0; //Odd
        

        while(!pq.isEmpty()){ 
            Edge e=pq.remove();
            int u=e.to;

            for(int i=0;i<adj[u].size();i++){
                Edge ee=adj[u].get(i);
                int v=ee.to;
                long w=ee.weight;
                int p=ee.p;
                
                if(p==0){
                    if(dis2[u]+w < dis[v]){
                        dis[v]=dis2[u]+w;
                        pq.add(new Edge(v,dis[v],p));
                    }
                }
                else{
                    if(dis[u]+w < dis2[v]){ 
                        dis2[v]=dis[u]+w;
                        pq.add(new Edge(v,dis2[v],p));
                    }

                }
            }
        }
        

        if(dis[n-1]==(Long.MAX_VALUE/4) && dis2[n-1]==(Long.MAX_VALUE/4)){
            pw.println(-1);
        }
        else{
            pw.println(Math.min(dis[n-1],dis2[n-1]));
        }
    
        pw.flush();
        
    }
}