import java.io.*;
import java.util.*;

public class B {
    static class Edge implements Comparable<Edge>{
        int to;
        int w;
        Edge(int to,int w){
            this.to=to;
            this.w=w;
        }
        public int compareTo(Edge other){ 
            return Integer.compare(this.w,other.w);
    }
}
    public static void main (String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        StringTokenizer nmst=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(nmst.nextToken());
        int m=Integer.parseInt(nmst.nextToken());
        int s=Integer.parseInt(nmst.nextToken());
        int t=Integer.parseInt(nmst.nextToken());

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
        }

        int [] s1=Dijk(s-1,n,adj);
        int [] t1=Dijk(t-1,n,adj);

        int best_dis=(int)Double.POSITIVE_INFINITY;
        int bestidx=-1;
        for(int i=0;i<n;i++){
            int ss=s1[i];
            int tt=t1[i];
            if(ss!=(int)Double.POSITIVE_INFINITY && tt!=(int)Double.POSITIVE_INFINITY){
                int max=Math.max(ss,tt);
                if(best_dis>max){
                    best_dis=max;
                    bestidx=i+1;
                }
            }
        }

        if(bestidx==-1){ 
            pw.println(-1);
        }
        else{
           pw.println(best_dis+" "+bestidx); 
        }
        pw.flush();
    }

    public static int[] Dijk(int s,int n,ArrayList<Edge>[]adj){
        int [] dis=new int[n];
        int [] vis=new int[n];
        Arrays.fill(dis,(int)Double.POSITIVE_INFINITY);

        PriorityQueue<Edge> pq=new PriorityQueue<>();
        pq.add(new Edge(s,0));
        dis[s]=0;

        while(!pq.isEmpty()){ 
            Edge edg=pq.remove();
            int u=edg.to;

            if(vis[u]==1){
                continue;
            }

            vis[u]=1;

            for(int i=0;i<adj[u].size();i++){ 
                Edge e=adj[u].get(i);
                int v=e.to;
                int weight=e.w;
                if(dis[v]>dis[u]+ weight){ 
                    dis[v]=dis[u]+weight;
                    pq.add(new Edge(v,dis[v]));
                }
            }
        }

        return dis;
    }
}
