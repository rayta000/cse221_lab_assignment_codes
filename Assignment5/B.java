import java.io.*;
import java.util.*;

public class B {
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw=new PrintWriter(System.out);

    static int[]visited;
    static int idx=0;
    static int[] result;
    static ArrayList<Integer>[] adj;
    public static void main (String[]args)throws Exception{
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        adj=new ArrayList[N];

        for(int i=0;i<N;i++){
            adj[i]=new ArrayList<>();
        }

        StringTokenizer uu=new StringTokenizer(br.readLine());
        StringTokenizer vv=new StringTokenizer(br.readLine());

        visited=new int[N];
        result=new int[N];

        for(int i=0;i<M;i++){
           int u=Integer.parseInt(uu.nextToken());
           int v=Integer.parseInt(vv.nextToken());
           
           adj[u-1].add(v-1);
           adj[v-1].add(u-1);
        }

        DFS(0);

        for(int i=0;i<result.length;i++){
            pw.print(result[i]+" ");
        }

        pw.println();
        pw.flush();
    }

    public static void DFS(int u){
        visited[u]=1;
        result[idx]=u+1;
        idx++;

        for(int i=0;i<adj[u].size();i++){
            int v=adj[u].get(i);

            if(visited[v]==0){
                DFS(v);
            }
        }
        
    }
}
