import java.io.*;
import java.util.*;

public class F {
    static int[]vis;
    static int[]countId;
    static int count=1;

    static Queue<Integer> q=new LinkedList<>();
    static ArrayList<Integer> [] adj;
    public static void main (String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int Q=Integer.parseInt(st.nextToken());

        adj=new ArrayList[N];

        for(int i=0;i<adj.length;i++){
            adj[i]=new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            StringTokenizer uv=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(uv.nextToken());
            int v=Integer.parseInt(uv.nextToken());
            adj[u-1].add(v-1);
            adj[v-1].add(u-1);
        }
        //////////////
        vis=new int[N];
        countId=new int[N];
        
        for(int i=0;i<vis.length;i++){
            if(vis[i]==0){
               q.add(i);
               vis[i]=1;
               countId[i]=count;
               BFS();
               count++;
            }
        }

        for(int i=0;i<Q;i++){
            StringTokenizer s=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(s.nextToken());
            int v=Integer.parseInt(s.nextToken());

            if(countId[u-1]==countId[v-1]){
                pw.println("YES");
            }
            else{
                pw.println("NO");
            }
        }

        pw.flush();
    }

    public static void BFS(){
        
        while(!q.isEmpty()){
            int u=q.remove();
            for(int i=0;i<adj[u].size();i++){
                int v=adj[u].get(i);
                if(vis[v]==0){
                    vis[v]=1;
                    countId[v]=count;
                    q.add(v);
                }
            }
        }
    }


}
