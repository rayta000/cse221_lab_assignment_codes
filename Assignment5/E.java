import java.io.*;
import java.util.*;

public class E {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int R=Integer.parseInt(st.nextToken());

        ArrayList<Integer> [] adj=new ArrayList[N];

        for(int i=0;i<N;i++){  
            adj[i]=new ArrayList<>();
        }

        for(int i=0;i<N-1;i++){
            StringTokenizer uv=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(uv.nextToken());
            int v=Integer.parseInt(uv.nextToken());
            adj[u-1].add(v-1);
            adj[v-1].add(u-1);
        }

        int Q=Integer.parseInt(br.readLine());

        //BFS
        Queue<Integer> q=new LinkedList<>();

        int[]par=new int[N];
        int[]vis=new int[N];

        for(int i=0;i<N;i++){  
            par[i]=-1;
            vis[i]=-1;
        }

        ArrayList<Integer> order=new ArrayList<>();

        q.add(R-1);
        vis[R-1]=1;

        while(!q.isEmpty()){
            int u=q.remove();
            order.add(u);

            for(int i=0;i<adj[u].size();i++){
                int v=adj[u].get(i);

                if(vis[v]==-1){
                    vis[v]=1;
                    par[v]=u;
                    q.add(v);
                }
            }
        }

        ////////////
        int [] size=new int[N];

        for(int i=0;i<size.length;i++){
            size[i]=1;
        }

        for(int i=order.size()-1;i>-1;i--){
            int u=order.get(i);
            if(u!=R-1){
                size[par[u]]+=size[u];
            }
        }

        for(int i=0;i<Q;i++){
            int a=Integer.parseInt(br.readLine());
            pw.println(size[a-1]);
        }

        pw.flush();

    }
}
