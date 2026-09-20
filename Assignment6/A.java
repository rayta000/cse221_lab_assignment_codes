import java.io.*;
import java.util.*;

public class A {
    public static void main (String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        int T=Integer.parseInt(br.readLine());
        int t=0;
        while(t<T){
            StringTokenizer nm=new StringTokenizer(br.readLine());
            int N=Integer.parseInt(nm.nextToken());
            int M=Integer.parseInt(nm.nextToken());
            ArrayList<Integer>[] adj=new ArrayList[N];

            for(int i=0;i<N;i++){ 
                adj[i]=new ArrayList<>();
            }

            int[]inDeg=new int[N];

            for(int i=0;i<M;i++){
                StringTokenizer s=new StringTokenizer(br.readLine());
                int a=Integer.parseInt(s.nextToken());
                int b=Integer.parseInt(s.nextToken());
                adj[a-1].add(b-1);
                inDeg[b-1]++;
            }

            Queue<Integer> q=new LinkedList<>();
            ArrayList<Integer> res=new ArrayList<>();

            for(int i=0;i<N;i++){
                if(inDeg[i]==0){
                    q.add(i);
                }
            }

                
            while(!q.isEmpty()){
                int u=q.remove();
                res.add(u+1);
                for(int i=0;i<adj[u].size();i++){
                    int v=adj[u].get(i);
                    inDeg[v]--;
                    if(inDeg[v]==0){
                        q.add(v);
                    }
                }
            }

            if(res.size()!=N){
                pw.print(-1);
            }
            else{
                for(int i=0;i<res.size();i++){
                    pw.print(res.get(i)+" ");
                }
            }
            pw.println();
    
            t++;
        }

        pw.flush();
    }
}
