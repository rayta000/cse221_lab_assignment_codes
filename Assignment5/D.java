import java.io.*;
import java.util.*;
public class D {
    public static void main (String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int S=Integer.parseInt(st.nextToken());
        int D=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] adj=new ArrayList[N];

        for(int i=0;i<N;i++){  
            adj[i]=new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            StringTokenizer uv=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(uv.nextToken());
            int v=Integer.parseInt(uv.nextToken());
            adj[u-1].add(v-1);
        }


        //BFS1
        int[]dis=new int[N];
        int[]par=new int[N];
        int[]vis=new int[N];

        for(int i=0;i<par.length;i++){
        par[i]=-1;
        dis[i]=-1;
        vis[i]=-1;
        }

        Queue<Integer> q=new LinkedList<>();
        q.add(S-1);
        vis[S-1]=1;
        dis[S-1]=0;

        while(!q.isEmpty()){
            int u=q.remove();
            for(int i=0;i<adj[u].size();i++){
            int v=adj[u].get(i);
                if(vis[v]==-1){
                    vis[v]=1;
                    par[v]=u;
                    dis[v]=dis[u]+1;
                    q.add(v);
                }
            }
        }

        //BFS2
        int[]dis1=new int[N];
        int[]par1=new int[N];
        int[]vis1=new int[N];

        for(int i=0;i<par.length;i++){
            par1[i]=-1;
            dis1[i]=-1;
            vis1[i]=-1;
        }

        Queue<Integer> q1=new LinkedList<>();
        q1.add(K-1);
        vis1[K-1]=1;
        dis1[K-1]=0;

        while(!q1.isEmpty()){
            int u=q1.remove();
            for(int i=0;i<adj[u].size();i++){
            int v=adj[u].get(i);
                if(vis1[v]==-1){
                    vis1[v]=1;
                    par1[v]=u;
                    dis1[v]=dis1[u]+1;
                    q1.add(v);
                }
            }
        }

        /////////////
        ArrayList<Integer> res=new ArrayList<>();

        if(vis[K-1]!=-1 && vis1[D-1]!=-1 ){
            
            pw.println(dis[K-1]+dis1[D-1]);
            int p=D-1;
            res.add(p+1);

            while(p!=(K-1)){ //D-->K
                p=par1[p];
                if(p!=(K-1)){
                res.add(p+1);
                }
            }
            
            p=K-1;
            if(D!=K){
                res.add(p+1);
            }
        
            while(p!=(S-1)){ //K-->S
                p=par[p];
                res.add(p+1);
            }
            Collections.reverse(res);
        }
        else{
          pw.println(-1);  
        }
        
        //output//
        for(int i=0;i<res.size();i++){
            pw.print(res.get(i)+" ");
        }

        pw.println();
        pw.flush();
    }
}
