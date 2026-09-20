import java.util.*;
import java.io.*;
public class D{
    public static void main (String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        int N=Integer.parseInt(br.readLine());
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

        //BFS1
        Queue<Integer> q=new LinkedList<>();
        q.add(0);

        int [] dis=new int[N];
        int [] vis=new int[N];

        for(int i=0;i<N;i++){ 
            dis[i]=-1;
            vis[i]=-1;
        }

        dis[0]=0;
        vis[0]=1;

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

        ArrayList<Integer> longest=new ArrayList<>();

        int max=(int)Double.NEGATIVE_INFINITY;
        int max_idx=-1;
        for(int i=0;i<dis.length;i++){
            if(dis[i]>max){
                max=dis[i];
                max_idx=i;
            }
        }
        longest.add(max_idx);

        //BFS2
        Queue<Integer> q1=new LinkedList<>();
        q1.add(max_idx);

        int [] dis1=new int[N];
        int [] vis1=new int[N];

        for(int i=0;i<N;i++){ 
            dis1[i]=-1;
            vis1[i]=-1;
        }

        dis1[max_idx]=0;
        vis1[max_idx]=1;

        while(!q1.isEmpty()){
            int u1=q1.remove();
            for(int i=0;i<adj[u1].size();i++){ 
                int v1=adj[u1].get(i);
                if(vis1[v1]==-1){
                    vis1[v1]=1;
                    dis1[v1]=dis1[u1]+1;
                    q1.add(v1);
                }
            }
        }


        int max1=(int)Double.NEGATIVE_INFINITY;
        int max_idx1=-1;
        for(int i=0;i<dis1.length;i++){
            if(dis1[i]>max1){
                max1=dis1[i];
                max_idx1=i;
            }
        }
        longest.add(max_idx1);


        if(max1>max){
            pw.println(max1);
        }
        else if(max1==max){
            pw.println(max);
        }
        else{
            pw.println(max); 
        }

        for(int i=0;i<longest.size();i++){  
            pw.print((longest.get(i)+1)+" ");
        }

        pw.println();
        pw.flush();

    }
}

