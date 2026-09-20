import java.io.*;
import java.util.*;
public class G {
    static int [] vis;
    static ArrayList<Integer> [] adj;
    static boolean res=false;
    public static void main (String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        adj=new ArrayList[N];
        for(int i=0;i<N;i++){  
            adj[i]=new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            StringTokenizer uv=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(uv.nextToken());
            int v=Integer.parseInt(uv.nextToken());
            adj[u-1].add(v-1);
        }
        vis=new int[N];

        for(int i=0;i<N;i++){
            if(vis[i]==0){
                DFS(i);
            }
            if(res){
                pw.println("YES");
                break;
            }
        }
        if(!res){
            pw.println("NO");
        }
        pw.flush();
    }

    public static void DFS(int p){
        vis[p]=1;

        for(int i=0;i<adj[p].size();i++){
            int v=adj[p].get(i);

            if(vis[v]==1){
                res=true;
                break;
            }
            if(vis[v]==0){
                DFS(v);
            }
        }
        vis[p]=2;
    }
}
