import java.io.*;
import java.util.*;

public class A{
    static class Edge implements Comparable<Edge>{
        int to;
        int w;
        Edge(int to,int w){ 
            this.to=to;
            this.w=w;
        }
        public int compareTo(Edge other){ 
            return Integer.compare(this.w, other.w);
        }
    }
    public static void main (String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        StringTokenizer nmsd=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(nmsd.nextToken());
        int m=Integer.parseInt(nmsd.nextToken());
        int s=Integer.parseInt(nmsd.nextToken());
        int d=Integer.parseInt(nmsd.nextToken());

        ArrayList<Edge>[] adj=new ArrayList[n];

        for(int i=0;i<n;i++){  
            adj[i]=new ArrayList<>();
        }
        StringTokenizer uu=new StringTokenizer(br.readLine());
        StringTokenizer vv=new StringTokenizer(br.readLine());
        StringTokenizer ww=new StringTokenizer(br.readLine());

        for(int i=0;i<m;i++){ 
            int f=Integer.parseInt(uu.nextToken());
            int t=Integer.parseInt(vv.nextToken());
            int w=Integer.parseInt(ww.nextToken());
            adj[f-1].add(new Edge(t,w));
        }

        int [] dis=new int[n];
        Arrays.fill(dis,(int)Double.POSITIVE_INFINITY);
        int [] par=new int[n];
        Arrays.fill(par,-1);
        int [] vis=new int[n];

        PriorityQueue<Edge> q=new PriorityQueue<>();
        q.add(new Edge(s,0));
        dis[s-1]=0;

        while(!q.isEmpty()){ 
            Edge e=q.remove();
            int u=e.to-1;
            //int dis_u=e.w;

            if(vis[u]==1){
                continue;
            }
            vis[u]=1;
            /*if(dis_u>dis[u]){
                continue;
            }*/
            for (int i=0;i<adj[u].size();i++) {
                Edge edg=adj[u].get(i);
                int v=edg.to-1;
                int w=edg.w;

                if(dis[v]>dis[u]+w){ 
                    dis[v]=dis[u]+w;
                    par[v]=u;
                    q.add(new Edge(v+1,dis[v]));
                }
            }
        }


        if(dis[d-1]==(int)Double.POSITIVE_INFINITY){ 
            pw.println(-1);
        }
        else{
            pw.println(dis[d-1]);

            ArrayList<Integer> path=new ArrayList<>();
            int cur=d-1;
            while(cur!=-1){ 
                path.add(cur+1);
                cur=par[cur];
            }
            Collections.reverse(path);

            for(int i=0;i<path.size();i++){ 
                pw.print(path.get(i)+" ");
            }
            pw.println();
        }

        pw.flush();
    }
}