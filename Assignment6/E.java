import java.io.*;
import java.util.*;
public class E {
   public static void main (String[]args) throws Exception{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw=new PrintWriter(System.out);

    StringTokenizer s=new StringTokenizer(br.readLine());

    int N=Integer.parseInt(s.nextToken());
    int M=Integer.parseInt(s.nextToken());
    int S=Integer.parseInt(s.nextToken());
    int Q=Integer.parseInt(s.nextToken());

    ArrayList<Integer>[]adj=new ArrayList[N];

    for(int i=0;i<N;i++){ 
        adj[i]=new ArrayList<>();
    }

    for(int i=0;i<M;i++){ 
        StringTokenizer uv=new StringTokenizer(br.readLine());
        int u=Integer.parseInt(uv.nextToken());
        int v=Integer.parseInt(uv.nextToken());
        adj[u-1].add(v-1);
        adj[v-1].add(u-1);
    }

    StringTokenizer source=new StringTokenizer(br.readLine());

    Queue<Integer> q=new LinkedList<>();
    int[]vis=new int[N];
    int[]dis=new int[N];
    Arrays.fill(vis,-1);
    Arrays.fill(dis,-1);

    for(int i=0;i<S;i++){
        int ss=Integer.parseInt(source.nextToken());
        q.add(ss-1);
        vis[ss-1]=1;
        dis[ss-1]=0;
    }

    while(!q.isEmpty()){ 
        int u=q.remove();
        for(int i=0;i<adj[u].size();i++){
            int v=adj[u].get(i);
            if(vis[v]==-1){
                vis[v]=1;
                dis[v]=dis[u]+1;
                q.add(v);
            }
        }
    }

    StringTokenizer query=new StringTokenizer(br.readLine());

    while(Q-->0){
        int qq=Integer.parseInt(query.nextToken());
        pw.print(dis[qq-1]+" ");
    }
    pw.println();
    pw.flush();
   } 
}
