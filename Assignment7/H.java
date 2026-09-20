import java.util.*;
import java.io.*;

public class H {
    static class Edge{
        int from;
        int to;
        int w;
        Edge(int from,int to,int w){ 
            this.from=from;
            this.to=to;
            this.w=w;
        }

    }
    public static void main (String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        int T=Integer.parseInt(br.readLine());

        int r=0;

        while(r<T){ 
            StringTokenizer nm=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(nm.nextToken());
            int m=Integer.parseInt(nm.nextToken());

            Edge[]adj=new Edge[m];

            for(int i=0;i<m;i++){ 
                StringTokenizer uvw=new StringTokenizer(br.readLine());
                int u=Integer.parseInt(uvw.nextToken());
                int v=Integer.parseInt(uvw.nextToken());
                int w=Integer.parseInt(uvw.nextToken());
                adj[i]=new Edge(u,v,w);
            }

            long[] dis=new long[n];
            Arrays.fill(dis,(long)Double.POSITIVE_INFINITY/4);

            dis[0]=0;

            for(int i=0;i<n-1;i++){
                boolean changed=false;
                for(int j=0;j<m;j++){ 
                    Edge ee=adj[j];
                    int frm=ee.from;
                    int to=ee.to;
                    int w=ee.w;
                    if(dis[frm-1]!=(long)Double.POSITIVE_INFINITY/4 && dis[frm-1]+w<dis[to-1]){ 
                        dis[to-1]=dis[frm-1]+w;
                        changed=true;
                    }
                }
                if(!changed){
                    break;
                }
            }

            pw.println(dis[n-1]);
            pw.flush();
            r++;
        }



    }
}
