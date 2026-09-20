import java.io.*;
import java.util.*;

public class C {
    public static void main(String[]args) throws Exception{
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     PrintWriter pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

     StringTokenizer st=new StringTokenizer(br.readLine());
    
     int N=Integer.parseInt(st.nextToken());
     int M=Integer.parseInt(st.nextToken());
     int source=Integer.parseInt(st.nextToken());
     int destination=Integer.parseInt(st.nextToken());

     StringTokenizer uu=new StringTokenizer(br.readLine());
     StringTokenizer vv=new StringTokenizer(br.readLine());

     ArrayList<Integer>[] adj=new ArrayList[N];

     for(int i=0;i<N;i++){  
        adj[i]=new ArrayList<>();
     }

     for(int i=0;i<M;i++){  
        int u=Integer.parseInt(uu.nextToken());
        int v=Integer.parseInt(vv.nextToken());
        adj[u-1].add(v-1);
        adj[v-1].add(u-1);
     }

     //sorting in descending order
     for(int i=0;i<adj.length;i++){
        adj[i]=mrgSrt(adj[i]);
     }

     ///////////
     int[]visit=new int[N];
     int[]par=new int[N];
     int[]dis=new int[N];
     
     //BFS
     Queue<Integer> q=new LinkedList<>();

     for(int i=0;i<par.length;i++){
        par[i]=-1;
        dis[i]=-1;
        visit[i]=-1;
     }

     q.add(source-1);
     visit[source-1]=1;
     dis[source-1]=0;

     while(!q.isEmpty()){
        int u=q.remove();
        for(int i=0;i<adj[u].size();i++){
            int v=adj[u].get(i);
            if(visit[v]==-1){
                visit[v]=1;
                par[v]=u;
                dis[v]=dis[u]+1;
                q.add(v);
            }
        }
     }

     /*--------------*/
     ArrayList<Integer> res=new ArrayList<>();
     if(visit[destination-1]==-1){
        pw.println(-1);
     }
     else{
        pw.println(dis[destination-1]);
        int p=destination-1;
        res.add(p+1);
        while(p!=(source-1)){
            p=par[p];
            res.add(p+1);
        }

        for(int i=res.size()-1;i>-1;i--){
            pw.print(res.get(i)+" ");
        }
        pw.println();
        }

     pw.flush();
    }

    public static ArrayList<Integer> mrgSrt(ArrayList<Integer> a){
        if(a.size()<=1){
            return a;
        }
        int mid=a.size()/2;
        ArrayList<Integer> lft=new ArrayList<>(a.subList(0,mid));
        ArrayList<Integer> rgt=new ArrayList<>(a.subList(mid,a.size()));

        lft=mrgSrt(lft);
        rgt=mrgSrt(rgt);

        return mrg(lft,rgt);
    }
    public static ArrayList<Integer> mrg(ArrayList<Integer> b1,ArrayList<Integer> b2){
        ArrayList<Integer> m=new ArrayList<>();
        int i=0,j=0;
        b1.add((int)Double.POSITIVE_INFINITY);
        b2.add((int)Double.POSITIVE_INFINITY);
        while(i<b1.size() && j<b2.size()){
           if(b1.get(i)<=b2.get(j)){
            m.add(b1.get(i));
            i++;
           }
           else{
            m.add(b2.get(j));
            j++;
           }
        }
        m.remove(m.size()-1);
        return m;
    }
}
