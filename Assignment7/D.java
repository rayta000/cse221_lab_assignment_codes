import java.io.*;
import java.util.*;

public class D {
    public static void main (String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        StringTokenizer nmsd=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(nmsd.nextToken());
        int m=Integer.parseInt(nmsd.nextToken());
        int s=Integer.parseInt(nmsd.nextToken());
        int d=Integer.parseInt(nmsd.nextToken());

        StringTokenizer w=new StringTokenizer(br.readLine());

        long [] weight=new long[n];
        for(int i=0;i<n;i++){
            weight[i]=Long.parseLong(w.nextToken());
        }

        ArrayList<Integer>[]adj=new ArrayList[n];

        for(int i=0;i<n;i++){ 
            adj[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){ 
            StringTokenizer uv=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(uv.nextToken());
            int v=Integer.parseInt(uv.nextToken());
            adj[u-1].add(v-1);
        }

        long [] best=new long[n];
        Arrays.fill(best,Long.MAX_VALUE);
        int [] vis=new int[n];
        PriorityQueue<long[]> pq=new PriorityQueue<>(Comparator.comparingLong(a->a[1]));
        pq.add(new long[]{s-1,weight[s-1]});
        best[s-1]=weight[s-1];

        while(!pq.isEmpty()){ 
            long[]cell=pq.remove();
            long u=cell[0];
            long w1=cell[1];
        
            if(vis[(int)u]==1){
                continue;
            }
            vis[(int)u]=1;

            for(int i=0;i<adj[(int)u].size();i++){ 
                int v=adj[(int)u].get(i);
                if(weight[v]+w1<best[v]){
                    best[v]=weight[v]+w1;
                    pq.add(new long[]{v,best[v]});
                }
            }
        }

        if(best[d-1]!=Long.MAX_VALUE){ 
            pw.println(best[d-1]);
        }
        else{
           pw.println(-1); 
        }

        pw.flush();
    }
}
